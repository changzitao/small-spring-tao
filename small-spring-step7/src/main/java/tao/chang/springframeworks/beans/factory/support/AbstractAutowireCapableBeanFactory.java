package tao.chang.springframeworks.beans.factory.support;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import tao.chang.springframeworks.beans.BeanException;
import tao.chang.springframeworks.beans.PropertyValue;
import tao.chang.springframeworks.beans.PropertyValues;
import tao.chang.springframeworks.beans.factory.DisposableBean;
import tao.chang.springframeworks.beans.factory.InitializingBean;
import tao.chang.springframeworks.beans.factory.config.AutowireCapableBeanFactory;
import tao.chang.springframeworks.beans.factory.config.BeanDefinition;
import tao.chang.springframeworks.beans.factory.config.BeanPostProcessor;
import tao.chang.springframeworks.beans.factory.config.BeanReference;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory implements AutowireCapableBeanFactory {
    private InstantiationStrategy instantiationStrategy = new CglibSubclassInstantiationStrategy();


    @Override
    public Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeanException {
        Object bean = null;
        try {
            bean = createBeanInstance(beanDefinition, beanName, args);
            applyPropertyValues(beanName, bean, beanDefinition);
            bean = initializeBean(beanName,bean,beanDefinition);
        } catch (Exception e) {
            return new BeanException("Instantiation of bean failed", e);
        }
        registerDisposableBeanIfNecessary(beanName, bean, beanDefinition);
        addSingletonBean(beanName, bean);
        return bean;
    }

    private void applyPropertyValues(String beanName, Object bean, BeanDefinition beanDefinition) {
        try {
            PropertyValues propertyValues = beanDefinition.getPropertyValues();
            for (PropertyValue propertyValue : propertyValues.getPropertyValues()) {
                String name = propertyValue.getName();
                Object value = propertyValue.getValue();
                if (value instanceof BeanReference) {
                    BeanReference beanReference = (BeanReference) value;
                    value = getBean(beanReference.getBeanName());
                }
                BeanUtil.setFieldValue(bean, name, value);
            }
        } catch (Exception e) {
            throw new BeanException("Error setting property values：" + beanName);
        }
    }
    public void registerDisposableBeanIfNecessary(String beanName,Object bean,BeanDefinition beanDefinition){
        if (bean instanceof DisposableBean || StrUtil.isNotEmpty(beanDefinition.getDestroyMethodName())) {
            registerDisposableBean(beanName, new DisposableBeanAdapter(bean, beanName, beanDefinition));
        }
    }
    public Object createBeanInstance(BeanDefinition beanDefinition, String beanName, Object[] args) throws BeanException {
        Constructor constructorToUse = null;
        Class<?> beanClass = beanDefinition.getBeanClass();
        Constructor<?>[] constructors = beanClass.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            if (null != args && constructor.getParameterTypes().length == args.length) {
                constructorToUse = constructor;
                break;
            }
        }


        return getInstantiationStrategy().instantiationStrategy(beanDefinition, beanName, constructorToUse, args);
    }

    public InstantiationStrategy getInstantiationStrategy() {
        return instantiationStrategy;
    }

    public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
        this.instantiationStrategy = instantiationStrategy;
    }

    private Object initializeBean(String beanName, Object bean, BeanDefinition beanDefinition) {
        Object wrappedBean = applyBeanPostProcessorBeforeInitialization(bean, beanName);
        try {
            invokeInitMethods(beanName, wrappedBean, beanDefinition);
        } catch (Exception e) {
            throw new BeanException("Invocation of init method of bean[" + beanName + "] failed", e);
        }

        wrappedBean = applyBeanPostProcessorAfterInitialization(wrappedBean, beanName);
        return wrappedBean;
    }

    private Object applyBeanPostProcessorAfterInitialization(Object existingBean, String beanName) {
        Object result = existingBean;
        for (BeanPostProcessor beanPostProcessor : getBeanPostProcessors()) {
            Object current = beanPostProcessor.postProcessAfterInitialization(result, beanName);
            if (null == current) return result;
            result = current;
        }
        return result;

    }

    private void invokeInitMethods(String beanName, Object bean, BeanDefinition beanDefinition) throws Exception {
        if (bean instanceof InitializingBean) {
            ((InitializingBean) bean).afterPropertiesSet();
        }
        //可能你会想这里怎么有一个适配器的类呢，因为销毁方法有两种甚至多种方式，目
        //前有实现接口 DisposableBean、配置信息 destroy-method，两种方
        //式。
        String initMethodName = beanDefinition.getInitMethodName();
        if (StrUtil.isNotEmpty(initMethodName) && !(bean instanceof InitializingBean)) {
            Method method = beanDefinition.getBeanClass().getMethod(initMethodName);
            if (null == method) {
                throw new BeanException("Could not find an init method named '" + initMethodName + "' on bean with name '" + beanName + "'");
            }
            method.invoke(bean);
        }
    }

    private Object applyBeanPostProcessorBeforeInitialization(Object existingBean, String beanName) {
        Object result = existingBean;
        for (BeanPostProcessor processor : getBeanPostProcessors()) {
            Object current = processor.postProcessBeforeInitialization(result, beanName);
            if (null == current) return result;
            result = current;
        }

        return result;
    }


}

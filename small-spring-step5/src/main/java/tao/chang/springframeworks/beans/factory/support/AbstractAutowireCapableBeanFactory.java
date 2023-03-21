package tao.chang.springframeworks.beans.factory.support;

import cn.hutool.core.bean.BeanUtil;
import tao.chang.springframeworks.beans.BeanException;
import tao.chang.springframeworks.beans.PropertyValue;
import tao.chang.springframeworks.beans.PropertyValues;
import tao.chang.springframeworks.beans.factory.config.BeanDefinition;
import tao.chang.springframeworks.beans.factory.config.BeanReference;

import java.lang.reflect.Constructor;

public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {
    private InstantiationStrategy instantiationStrategy = new CglibSubclassInstantiationStrategy();


    @Override
    public Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeanException {
        Object bean = null;
        try {
            bean = createBeanInstance(beanDefinition, beanName, args);
            applyPropertyValues(beanName, bean, beanDefinition);
        } catch (Exception e) {
            return new BeanException("Instantiation of bean failed", e);
        }
        addSingletonBean(beanName, bean);
        return bean;
    }

    private void applyPropertyValues(String beanName, Object bean, BeanDefinition beanDefinition) {
        try {
            PropertyValues propertyValues = beanDefinition.getPropertyValues();
            for (PropertyValue propertyValue : propertyValues.getPropertyValues()) {
                String  name = propertyValue.getName();
                Object value = propertyValue.getValue();
                if(value instanceof BeanReference){
                    BeanReference beanReference = (BeanReference) value;
                    value = getBean(beanReference.getBeanName());
                }
                BeanUtil.setFieldValue(bean,name,value);
            }
        } catch (Exception e) {
            throw new BeanException("Error setting property values：" + beanName);
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
}

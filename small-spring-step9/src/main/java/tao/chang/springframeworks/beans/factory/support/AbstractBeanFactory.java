package tao.chang.springframeworks.beans.factory.support;

import tao.chang.springframeworks.beans.BeanException;
import tao.chang.springframeworks.beans.FactoryBean;
import tao.chang.springframeworks.beans.factory.config.BeanDefinition;
import tao.chang.springframeworks.beans.factory.config.BeanPostProcessor;
import tao.chang.springframeworks.beans.factory.config.ConfigurableBeanFactory;
import tao.chang.springframeworks.utils.ClassUtils;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractBeanFactory extends FactoryBeanRegistrySupport implements ConfigurableBeanFactory {
    private final List<BeanPostProcessor> beanPostProcessors = new ArrayList<BeanPostProcessor>();
    private ClassLoader beanClassLoader = ClassUtils.getDefaultClassLoader();

    @Override
    public Object getBean(String name) {
        return doGetBean(name, null);
    }

    @Override
    public Object getBean(String name, Object... args) {
        return doGetBean(name, args);
    }

    @Override
    public <T> T getBean(String name, Class<T> requiredType) throws BeanException {
        return (T) getBean(name);
    }

    public <T> T doGetBean(final String name, final Object[] args) {
        Object sharedInstance = getSingletonBean(name);//共享实例
        if (sharedInstance != null) {
            // 如果是 FactoryBean，则需要调用 FactoryBean#getObject
            return (T) getObjectForBeanInstance(sharedInstance, name);
        }
        BeanDefinition beanDefinition = getBeanDefinition(name);
        Object object = createBean(name, beanDefinition, args);
        return (T)getObjectForBeanInstance(object,name);
    }

    private Object getObjectForBeanInstance(Object beanInstance, String beanName) {
        if (!(beanInstance instanceof FactoryBean)) {
            return beanInstance;
        }
        Object object = getCacheObjectForFactoryBean(beanName);//先从缓存获取单例,如果没有则使用FactoryBean创建.
        if (object == null) {
            FactoryBean<?> factoryBean = (FactoryBean<?>) beanInstance;
            object = getObjectFormFactoryBean(factoryBean, beanName);
        }
        return object;
    }

    @Override
    public void addBeanPostProcessor(BeanPostProcessor beanPostProcessor) {
        this.beanPostProcessors.remove(beanPostProcessor);
        this.beanPostProcessors.add(beanPostProcessor);

    }

    public abstract BeanDefinition getBeanDefinition(String name) throws BeanException;

    public abstract Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeanException;

    public List<BeanPostProcessor> getBeanPostProcessors() {
        return beanPostProcessors;
    }

    public ClassLoader getBeanClassLoader() {
        return this.beanClassLoader;
    }
}

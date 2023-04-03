package tao.chang.springframeworks.beans.factory.support;

import tao.chang.springframeworks.beans.BeanException;
import tao.chang.springframeworks.beans.factory.config.BeanDefinition;
import tao.chang.springframeworks.beans.factory.config.BeanPostProcessor;
import tao.chang.springframeworks.beans.factory.config.ConfigurableBeanFactory;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements ConfigurableBeanFactory {
    private final List<BeanPostProcessor> beanPostProcessors = new ArrayList<BeanPostProcessor>();

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

    public <T> T doGetBean(String name, Object[] args) {
        Object bean = getSingletonBean(name);
        if (bean != null) {
            return (T) bean;
        }
        BeanDefinition beanDefinition = getBeanDefinition(name);
        return (T) createBean(name, beanDefinition, args);
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
}

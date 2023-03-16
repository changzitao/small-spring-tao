package tao.chang.springframeworks.beans.factory.support;

import tao.chang.springframeworks.beans.BeansException;
import tao.chang.springframeworks.beans.factory.config.BeanDefinition;

public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {
    /**
     *
     * @param name
     * @param beanDefinition
     * @return
     * @throws BeansException
     */

    @Override
    protected Object createBean(String name, BeanDefinition beanDefinition) throws BeansException {
        Object bean;
        try {
            bean = beanDefinition.getBeanClass().newInstance();
        } catch (InstantiationException  | IllegalAccessException e) {
            throw new BeansException("Instantiation of bean failed",e);
        }
        addSingleton(name,bean);
        return bean;
    }


}

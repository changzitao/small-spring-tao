package tao.chang.springframeworks.beans.factory.support;

import tao.chang.springframeworks.beans.BeansException;
import tao.chang.springframeworks.beans.factory.BeanFactory;
import tao.chang.springframeworks.beans.factory.config.BeanDefinition;

public abstract  class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory  {
    @Override
    public Object getBean(String name) throws BeansException {
        Object bean = getSingleton(name);
        if(bean!=null){
         return bean;
        }
        BeanDefinition beanDefinition = getBeanDefinition(name);
        return createBean(name,beanDefinition);
    }

    protected abstract Object createBean(String name, BeanDefinition beanDefinition)throws BeansException;

    protected abstract BeanDefinition getBeanDefinition(String name)throws BeansException;



}

package tao.chang.springframeworks.beans.factory.support;

import tao.chang.springframeworks.beans.BeanException;
import tao.chang.springframeworks.beans.factory.BeanFactory;
import tao.chang.springframeworks.beans.factory.config.BeanDefinition;

public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {
    @Override
    public Object getBean(String name) {
        return doGetBean(name,null);
    }

    @Override
    public Object getBean(String name, Object... args) {
        return doGetBean(name,args);
    }
    public <T>T doGetBean(String name,Object[]args){
        Object bean = getSingletonBean(name);
        if(bean!=null){
            return (T) bean;
        }
        BeanDefinition beanDefinition =getBeanDefinition(name);
        return (T) createBean(name,beanDefinition,args);
    }

    public abstract BeanDefinition getBeanDefinition(String name) throws BeanException;

    public abstract Object createBean(String beanName, BeanDefinition beanDefinition,Object[]args) throws BeanException;
}

package tao.chang.springframeworks.beans.factory.support;

import tao.chang.springframeworks.beans.factory.BeanException;
import tao.chang.springframeworks.beans.factory.BeanFactory;
import tao.chang.springframeworks.beans.factory.config.BeanDefinition;

public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {
    @Override
    public Object getBean(String name) throws BeanException {


        return doGetBean(name,null);
    }
    @Override
    public Object getBean(String name, Object... args) {

        return doGetBean(name,args);
    }

    protected  <T>T doGetBean(String name, final Object[] args) {
        Object bean =getSingleton(name);
        if(bean!=null)return (T) bean;
        BeanDefinition beanDefinition = getBeanDefinition(name);
        return (T) createBean(name,beanDefinition,args);
    }


    public abstract BeanDefinition getBeanDefinition(String name) throws BeanException;

    public abstract Object createBean(String beanName, BeanDefinition beanDefinition,Object[]args) throws BeanException;
}

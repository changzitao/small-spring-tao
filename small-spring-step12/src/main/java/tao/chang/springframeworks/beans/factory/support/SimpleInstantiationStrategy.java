package tao.chang.springframeworks.beans.factory.support;

import tao.chang.springframeworks.beans.BeanException;
import tao.chang.springframeworks.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class SimpleInstantiationStrategy implements InstantiationStrategy {
    @Override
    public Object instantiationStrategy(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeanException {
        Class clazz = beanDefinition.getBeanClass();
        try {
            if (clazz != null) {
                return clazz.getDeclaredConstructor(ctor.getParameterTypes()).newInstance(args);
            }else return clazz.getDeclaredConstructor().newInstance();
        } catch (InvocationTargetException|InstantiationException|IllegalAccessException|NoSuchMethodException e) {
            throw new  BeanException("Failed to instantiate [" +beanName+"]");
        }
    }
}

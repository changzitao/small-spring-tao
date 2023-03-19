package tao.chang.springframeworks.beans.factory.support;

import tao.chang.springframeworks.beans.BeanException;
import tao.chang.springframeworks.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

public interface InstantiationStrategy {
    public Object instantiationStrategy(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object []args)throws BeanException;
}

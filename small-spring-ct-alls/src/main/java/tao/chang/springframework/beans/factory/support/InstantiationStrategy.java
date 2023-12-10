package tao.chang.springframework.beans.factory.support;

import tao.chang.springframework.beans.BeansException;
import tao.chang.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;


public interface InstantiationStrategy {

    Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeansException;

}

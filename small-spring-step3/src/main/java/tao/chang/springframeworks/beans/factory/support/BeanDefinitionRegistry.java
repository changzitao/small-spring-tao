package tao.chang.springframeworks.beans.factory.support;

import tao.chang.springframeworks.beans.factory.config.BeanDefinition;

public interface BeanDefinitionRegistry {
    public void registerBeanDefinition(String beanName,BeanDefinition beanDefinition);
}

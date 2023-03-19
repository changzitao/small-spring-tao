package tao.chang.springframeworks.beans.factory.support;

import tao.chang.springframeworks.beans.factory.config.BeanDefinition;

public interface BeanDefinitionRegistry {
    void registryBeanDefinition(String beanName, BeanDefinition beanDefinition);
}

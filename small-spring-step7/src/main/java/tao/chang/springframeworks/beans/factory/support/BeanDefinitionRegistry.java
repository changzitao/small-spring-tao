package tao.chang.springframeworks.beans.factory.support;

import tao.chang.springframeworks.beans.BeanException;
import tao.chang.springframeworks.beans.factory.config.BeanDefinition;

public interface BeanDefinitionRegistry {
    void registryBeanDefinition(String beanName, BeanDefinition beanDefinition);
    boolean containsBeanDefinition(String beanName);
    String[] getBeanDefinitionNames();
    BeanDefinition getBeanDefinition(String beanName) throws BeanException;
}

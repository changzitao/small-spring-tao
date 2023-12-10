package tao.chang.springframework.beans.factory;

import tao.chang.springframework.beans.BeansException;
import tao.chang.springframework.beans.factory.config.AutowireCapableBeanFactory;
import tao.chang.springframework.beans.factory.config.BeanDefinition;
import tao.chang.springframework.beans.factory.config.BeanPostProcessor;
import tao.chang.springframework.beans.factory.config.ConfigurableBeanFactory;


public interface ConfigurableListableBeanFactory extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {

    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    void preInstantiateSingletons() throws BeansException;

    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);

}

package tao.chang.springframework.beans.factory.config;

import tao.chang.springframework.beans.BeansException;
import tao.chang.springframework.beans.factory.ConfigurableListableBeanFactory;


public interface BeanFactoryPostProcessor {

    void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException;

}

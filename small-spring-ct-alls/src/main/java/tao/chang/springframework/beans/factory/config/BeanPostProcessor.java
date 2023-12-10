package tao.chang.springframework.beans.factory.config;

import tao.chang.springframework.beans.BeansException;


public interface BeanPostProcessor {

    Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException;


    Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException;

}

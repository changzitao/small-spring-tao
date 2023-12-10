package tao.chang.springframework.beans.factory.config;

import tao.chang.springframework.beans.BeansException;
import tao.chang.springframework.beans.PropertyValues;
import tao.chang.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;


public interface InstantiationAwareBeanPostProcessor extends BeanPostProcessor {


    Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException;


    boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException;


    PropertyValues postProcessPropertyValues(PropertyValues pvs, Object bean, String beanName) throws BeansException;

    default Object getEarlyBeanReference(Object bean, String beanName) {
        return bean;
    }

}

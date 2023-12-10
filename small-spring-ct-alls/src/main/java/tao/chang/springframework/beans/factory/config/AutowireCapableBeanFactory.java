package tao.chang.springframework.beans.factory.config;

import tao.chang.springframework.beans.BeansException;
import tao.chang.springframework.beans.factory.BeanFactory;


public interface AutowireCapableBeanFactory extends BeanFactory {


    Object applyBeanPostProcessorsBeforeInitialization(Object existingBean, String beanName) throws BeansException;


    Object applyBeanPostProcessorsAfterInitialization(Object existingBean, String beanName) throws BeansException;

}

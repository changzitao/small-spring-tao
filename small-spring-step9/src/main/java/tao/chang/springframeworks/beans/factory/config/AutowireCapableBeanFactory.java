package tao.chang.springframeworks.beans.factory.config;

import tao.chang.springframeworks.beans.BeanException;
import tao.chang.springframeworks.beans.factory.BeanFactory;

public interface AutowireCapableBeanFactory extends BeanFactory {
    Object applyBeanPostProcessorBeforeInitialization(Object existingBean, String beanName) throws BeanException;
    Object applyBeanPostProcessorAfterInitialization(Object existingBean, String beanName)throws BeanException;
}

package tao.chang.springframeworks.beans.factory.config;

import tao.chang.springframeworks.beans.BeanException;

public interface BeanPostProcessor {
    /**
     * 在初始化之前进行此方法
     * @param bean
     * @param beanName
     * @return
     * @throws BeanException
     */
    Object postProcessBeforeInitialization(Object bean,String beanName)throws BeanException;

    /**
     * 在初始化之后进行此方法
     * @param bean
     * @param beanName
     * @return
     * @throws BeanException
     */
    Object postProcessAfterInitialization(Object bean,String  beanName)throws BeanException;
}

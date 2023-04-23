package tao.chang.springframeworks.beans.factory.config;

import tao.chang.springframeworks.beans.BeanException;

/**
 * @Author TaoChang
 * @Date 2023/4/19 21:07
 */
public interface InstantiationAwareBeanPostProcessor extends BeanPostProcessor{
    Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeanException;
}

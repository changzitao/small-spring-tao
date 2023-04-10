package tao.chang.springframeworks.beans.factory;

import tao.chang.springframeworks.beans.BeanException;

public interface BeanFactoryAware extends Aware{
    void setBeanFactory(BeanFactory beanFactory) throws BeanException;

}

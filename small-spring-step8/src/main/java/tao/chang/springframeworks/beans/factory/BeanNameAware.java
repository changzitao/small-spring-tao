package tao.chang.springframeworks.beans.factory;

import tao.chang.springframeworks.beans.BeanException;

public interface BeanNameAware extends Aware{
    void setBeanName(String name)throws BeanException;
}

package tao.chang.springframeworks.beans.factory;

import tao.chang.springframeworks.beans.BeanException;

public interface BeanFactory {
    public Object getBean(String name);
    public  Object getBean(String name,Object...args);
    <T> T getBean(String name, Class<T> requiredType) throws BeanException;
}

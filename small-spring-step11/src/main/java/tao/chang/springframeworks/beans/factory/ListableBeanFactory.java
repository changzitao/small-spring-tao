package tao.chang.springframeworks.beans.factory;

import tao.chang.springframeworks.beans.BeanException;

import java.util.Map;

public interface ListableBeanFactory extends BeanFactory {
    <T> Map<String, T> getBeansOfType(Class<T> type) throws BeanException;
    String[] getBeanDefinitionNames();

}

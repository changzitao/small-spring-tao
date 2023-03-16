package tao.chang.springframeworks.beans.factory;

import tao.chang.springframeworks.beans.BeansException;

public interface BeanFactory {
    Object getBean(String name)throws BeansException;
}

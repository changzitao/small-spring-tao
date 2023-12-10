package tao.chang.springframework.beans.factory;

import tao.chang.springframework.beans.BeansException;


public interface ObjectFactory<T> {

    T getObject() throws BeansException;

}

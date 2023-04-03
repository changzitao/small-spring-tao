package tao.chang.springframeworks.beans.factory;

import tao.chang.springframeworks.beans.BeanException;

public interface DisposableBean {
    void destroy()throws Exception;
}

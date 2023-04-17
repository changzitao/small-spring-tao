package tao.chang.springframeworks.beans.factory;

import tao.chang.springframeworks.beans.BeanException;

public interface InitializingBean {
    /**
     *
     * @throws BeanException
     */
    void afterPropertiesSet()throws Exception;
}

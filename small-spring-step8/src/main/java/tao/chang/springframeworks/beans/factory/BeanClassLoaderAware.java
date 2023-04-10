package tao.chang.springframeworks.beans.factory;

import tao.chang.springframeworks.beans.BeanException;

/**
 *  @Author TaoChang
 */
public interface BeanClassLoaderAware extends Aware{
    void  setBeanClassLoader(ClassLoader classLoader)throws BeanException;

}

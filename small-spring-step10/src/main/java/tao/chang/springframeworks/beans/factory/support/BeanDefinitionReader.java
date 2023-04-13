package tao.chang.springframeworks.beans.factory.support;

import tao.chang.springframeworks.beans.BeanException;
import tao.chang.springframeworks.core.io.Resource;
import tao.chang.springframeworks.core.io.ResourceLoader;

public interface BeanDefinitionReader {
    BeanDefinitionRegistry getRegistry();
    ResourceLoader getResource();
    void loadBeanDefinitions(Resource resource) throws BeanException;
    void loadBeanDefinitions(String[] resources) throws BeanException;
    void loadBeanDefinitions(String location) throws BeanException;
    void loadBeanDefinitions(Resource... resources) throws BeanException;
}

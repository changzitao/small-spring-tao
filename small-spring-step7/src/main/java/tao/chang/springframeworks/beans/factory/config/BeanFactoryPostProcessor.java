package tao.chang.springframeworks.beans.factory.config;

import tao.chang.springframeworks.beans.BeanException;
import tao.chang.springframeworks.beans.factory.ConfigurableListableBeanFactory;

public interface BeanFactoryPostProcessor {
    void postProcessorBeanFactory(ConfigurableListableBeanFactory beanFactory)throws BeanException;

}

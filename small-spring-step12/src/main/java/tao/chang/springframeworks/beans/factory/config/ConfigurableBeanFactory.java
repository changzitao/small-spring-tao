package tao.chang.springframeworks.beans.factory.config;

import tao.chang.springframeworks.beans.factory.HierarchicalBeanFactory;

public interface ConfigurableBeanFactory extends HierarchicalBeanFactory, SingletonBeanRegistry {
    String SCOPE_SINGLETON = "singleton";

    String SCOPE_PROTOTYPE = "prototype";
    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);

    void destroySingletons();
}

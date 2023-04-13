package tao.chang.springframeworks.beans.factory.support;

import tao.chang.springframeworks.core.io.DefaultResourceLoader;
import tao.chang.springframeworks.core.io.ResourceLoader;

public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader {

    private final BeanDefinitionRegistry beanDefinitionRegistry;
    private ResourceLoader resourceLoader;

    protected AbstractBeanDefinitionReader(BeanDefinitionRegistry beanDefinitionRegistry) {
        this(beanDefinitionRegistry, new DefaultResourceLoader());
    }

    public AbstractBeanDefinitionReader(BeanDefinitionRegistry beanDefinitionRegistry, ResourceLoader resourceLoader) {
        this.beanDefinitionRegistry = beanDefinitionRegistry;
        this.resourceLoader = resourceLoader;
    }

    @Override
    public BeanDefinitionRegistry getRegistry() {
        return beanDefinitionRegistry;
    }

    @Override
    public ResourceLoader getResource() {
        return resourceLoader;
    }
}

package tao.chang.springframeworks.context.support;

import tao.chang.springframeworks.beans.BeanException;
import tao.chang.springframeworks.beans.factory.ConfigurableListableBeanFactory;
import tao.chang.springframeworks.beans.factory.config.BeanFactoryPostProcessor;
import tao.chang.springframeworks.beans.factory.config.BeanPostProcessor;
import tao.chang.springframeworks.context.ConfigurableApplicationContext;
import tao.chang.springframeworks.core.io.DefaultResourceLoader;

import java.util.Map;

public abstract class AbstractApplicationContext extends DefaultResourceLoader implements ConfigurableApplicationContext {
    @Override
    public void registryShutdownHook() {
        Runtime.getRuntime().addShutdownHook(new Thread(this::close));

    }

    @Override
    public void close() {
        getBeanFactory().destroySingletons();
    }

    @Override
    public void refresh() throws BeanException {
        refreshBeanFactory();
        ConfigurableListableBeanFactory factory = getBeanFactory();
        invokeBeanFactoryPostProcessors(factory);
        registryBeanPostProcessors(factory);
        factory.preInstantiateSingletons();
    }

    private void registryBeanPostProcessors(ConfigurableListableBeanFactory factory) {
        Map<String, BeanPostProcessor> beanPostProcessorMap = factory.getBeansOfType(BeanPostProcessor.class);
        for (BeanPostProcessor beanPostProcessor : beanPostProcessorMap.values()) {
            factory.addBeanPostProcessor(beanPostProcessor);

        }
    }

    private void invokeBeanFactoryPostProcessors(ConfigurableListableBeanFactory factory) {
        Map<String, BeanFactoryPostProcessor> beanFactoryPostProcessorMap = factory.getBeansOfType(BeanFactoryPostProcessor.class);
        for (BeanFactoryPostProcessor beanFactoryPostProcessor : beanFactoryPostProcessorMap.values()) {
            beanFactoryPostProcessor.postProcessorBeanFactory(factory);
        }
    }

    protected abstract ConfigurableListableBeanFactory getBeanFactory();

    protected abstract void refreshBeanFactory() throws BeanException;

    @Override
    public <T> Map<String, T> getBeansOfType(Class<T> type) throws BeanException {
        return getBeanFactory().getBeansOfType(type);
    }

    @Override
    public String[] getBeanDefinitionNames() {
        return getBeanFactory().getBeanDefinitionNames();
    }

    @Override
    public Object getBean(String name) throws BeanException {
        return getBeanFactory().getBean(name);
    }

    @Override
    public Object getBean(String name, Object... args) throws BeanException {
        return getBeanFactory().getBean(name, args);
    }

    @Override
    public <T> T getBean(String name, Class<T> requiredType) throws BeanException {
        return getBeanFactory().getBean(name, requiredType);
    }
}

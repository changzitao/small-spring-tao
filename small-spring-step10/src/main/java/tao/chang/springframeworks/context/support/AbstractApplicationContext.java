package tao.chang.springframeworks.context.support;


import tao.chang.springframeworks.beans.BeanException;
import tao.chang.springframeworks.beans.factory.ConfigurableListableBeanFactory;
import tao.chang.springframeworks.beans.factory.config.BeanFactoryPostProcessor;
import tao.chang.springframeworks.beans.factory.config.BeanPostProcessor;
import tao.chang.springframeworks.context.ApplicationEvent;
import tao.chang.springframeworks.context.ApplicationListener;
import tao.chang.springframeworks.context.ConfigurableApplicationContext;
import tao.chang.springframeworks.context.event.ApplicationEventMulticaster;
import tao.chang.springframeworks.context.event.ContextClosedEvent;
import tao.chang.springframeworks.context.event.ContextRefreshedEvent;
import tao.chang.springframeworks.context.event.SimpleApplicationEventMulticaster;
import tao.chang.springframeworks.core.io.DefaultResourceLoader;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

public abstract class AbstractApplicationContext extends DefaultResourceLoader implements ConfigurableApplicationContext {
    private ApplicationEventMulticaster applicationEventMulticaster;
    public static final String APPLICATION_EVENT_MULTICASTER_BEAN_NAME = "applicationEventMulticaster";

    @Override
    public void refresh() throws BeanException {
// 1. 创建 BeanFactory，并加载 BeanDefinition
        refreshBeanFactory();

        // 2. 获取 BeanFactory
        ConfigurableListableBeanFactory beanFactory = getBeanFactory();

        // 3. 添加 ApplicationContextAwareProcessor，让继承自 ApplicationContextAware 的 Bean 对象都能感知所属的 ApplicationContext
        beanFactory.addBeanPostProcessor(new ApplicationContextAwareProcessor(this));

        // 4. 在 Bean 实例化之前，执行 BeanFactoryPostProcessor (Invoke factory processors registered as beans in the context.)
        invokeBeanFactoryPostProcessors(beanFactory);

        // 5. BeanPostProcessor 需要提前于其他 Bean 对象实例化之前执行注册操作
        registryBeanPostProcessors(beanFactory);

        // 6. 初始化事件发布者
        initApplicationEventMulticaster();

        // 7. 注册事件监听器
        registerListeners();

        // 8. 提前实例化单例Bean对象
        beanFactory.preInstantiateSingletons();

        // 9. 发布容器刷新完成事件
        finishRefresh();
    }
    @Override
    public void publishEvent(ApplicationEvent event) {
        applicationEventMulticaster.multicastEvent(event);
    }

    private void finishRefresh() {
        publishEvent(new ContextRefreshedEvent(this));
    }

    private void registerListeners() {
        Collection<ApplicationListener> applicationListeners = getBeansOfType(ApplicationListener.class).values();
        for(ApplicationListener applicationListener :applicationListeners){
            applicationEventMulticaster.addApplicationListener(applicationListener);
        }
    }

    private void initApplicationEventMulticaster() {
        ConfigurableListableBeanFactory beanFactory = getBeanFactory();
        applicationEventMulticaster = new SimpleApplicationEventMulticaster(beanFactory);
        beanFactory.registerSingleton(APPLICATION_EVENT_MULTICASTER_BEAN_NAME,applicationEventMulticaster);
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
    @Override
    public void registryShutdownHook() {
        Runtime.getRuntime().addShutdownHook(new Thread(this::close));

    }

    @Override
    public void close() {
        publishEvent(new ContextClosedEvent(this));
        getBeanFactory().destroySingletons();
    }


}

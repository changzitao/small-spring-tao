package tao.chang.springframework.context.support;

import tao.chang.springframework.beans.BeansException;
import tao.chang.springframework.beans.factory.ConfigurableListableBeanFactory;
import tao.chang.springframework.beans.factory.support.DefaultListableBeanFactory;
import tao.chang.springframework.context.ApplicationContext;


public abstract class AbstractRefreshableApplicationContext extends AbstractApplicationContext {

    private DefaultListableBeanFactory beanFactory;

    @Override
    protected void refreshBeanFactory() throws BeansException {
        DefaultListableBeanFactory beanFactory = createBeanFactory();
        loadBeanDefinitions(beanFactory);
        this.beanFactory = beanFactory;
    }

    private DefaultListableBeanFactory createBeanFactory() {
        return new DefaultListableBeanFactory();
    }

    protected abstract void loadBeanDefinitions(DefaultListableBeanFactory beanFactory);

    @Override
    protected ConfigurableListableBeanFactory getBeanFactory() {
        return beanFactory;
    }

}

package tao.chang.springframeworks.context.support;

import tao.chang.springframeworks.beans.BeanException;
import tao.chang.springframeworks.beans.factory.ConfigurableListableBeanFactory;
import tao.chang.springframeworks.beans.factory.support.DefaultListableBeanFactory;

public abstract class AbstractRefreshableApplicationContext extends AbstractApplicationContext {
    private DefaultListableBeanFactory beanFactory;
    @Override
    public void refreshBeanFactory()throws BeanException {
        DefaultListableBeanFactory beanFactory = createBeanFactory();
        loadBeanDefinitions(beanFactory)
;        this.beanFactory =beanFactory;
    }

    protected abstract void loadBeanDefinitions(DefaultListableBeanFactory beanFactory);

    private DefaultListableBeanFactory createBeanFactory() {
        return new DefaultListableBeanFactory();
    }
    @Override
    public ConfigurableListableBeanFactory getBeanFactory(){return  beanFactory;}
}

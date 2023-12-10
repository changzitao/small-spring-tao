package tao.chang.springframework.context.support;

import tao.chang.springframework.beans.BeansException;
import tao.chang.springframework.beans.factory.config.BeanPostProcessor;
import tao.chang.springframework.context.ApplicationContext;
import tao.chang.springframework.context.ApplicationContextAware;


public class ApplicationContextAwareProcessor implements BeanPostProcessor {

    private final ApplicationContext applicationContext;

    public ApplicationContextAwareProcessor(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof ApplicationContextAware){
            ((ApplicationContextAware) bean).setApplicationContext(applicationContext);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

}

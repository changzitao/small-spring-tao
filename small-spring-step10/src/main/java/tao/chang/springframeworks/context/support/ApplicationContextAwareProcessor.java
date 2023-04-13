package tao.chang.springframeworks.context.support;


import tao.chang.springframeworks.context.ApplicationContextAware;
import tao.chang.springframeworks.beans.BeanException;
import tao.chang.springframeworks.beans.factory.config.BeanPostProcessor;
import tao.chang.springframeworks.context.ApplicationContext;

/**
 * @Author TaoChang
 * @Date 2023/4/10 19:29
 */
public class ApplicationContextAwareProcessor implements BeanPostProcessor {
    private final ApplicationContext applicationContext;
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeanException {
        if(bean instanceof ApplicationContextAware){
            ((ApplicationContextAware)bean).setApplicationContext(applicationContext);
        }
        return bean;
    }

    public ApplicationContextAwareProcessor(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }



    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeanException {
        return bean;
    }
}

package tao.chang.springframework.context.event;

import tao.chang.springframework.beans.factory.BeanFactory;
import tao.chang.springframework.context.ApplicationEvent;
import tao.chang.springframework.context.ApplicationListener;


public class SimpleApplicationEventMulticaster extends AbstractApplicationEventMulticaster {

    public SimpleApplicationEventMulticaster(BeanFactory beanFactory) {
        setBeanFactory(beanFactory);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void multicastEvent(final ApplicationEvent event) {
        for (final ApplicationListener listener : getApplicationListeners(event)) {
            listener.onApplicationEvent(event);
        }
    }

}

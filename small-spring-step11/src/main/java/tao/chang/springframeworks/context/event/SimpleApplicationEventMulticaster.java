package tao.chang.springframeworks.context.event;

import tao.chang.springframeworks.beans.factory.BeanFactory;
import tao.chang.springframeworks.context.ApplicationEvent;
import tao.chang.springframeworks.context.ApplicationListener;

/**
 * @Author TaoChang
 * @Date 2023/4/13 20:43
 */
public class SimpleApplicationEventMulticaster extends AbstractApplicationEventMulticaster {
    @Override
    public void multicastEvent(ApplicationEvent applicationEvent) {
        for (final ApplicationListener listener : getApplicationListeners(applicationEvent)) {
            listener.onApplicationEvent(applicationEvent);
        }
    }
    public SimpleApplicationEventMulticaster(BeanFactory beanFactory) {
        setBeanFactory(beanFactory);
    }
}

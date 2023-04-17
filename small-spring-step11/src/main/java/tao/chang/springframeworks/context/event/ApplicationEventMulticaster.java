package tao.chang.springframeworks.context.event;

import tao.chang.springframeworks.context.ApplicationEvent;
import tao.chang.springframeworks.context.ApplicationListener;

/**
 * @Author TaoChang
 * @Date 2023/4/13 20:04
 */
public interface ApplicationEventMulticaster {
    void addApplicationListener(ApplicationListener<?> listener);
    void removeApplicationListener(ApplicationListener<?>listener);
    void multicastEvent(ApplicationEvent applicationEvent);
}

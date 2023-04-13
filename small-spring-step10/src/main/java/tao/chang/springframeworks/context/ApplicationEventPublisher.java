package tao.chang.springframeworks.context;

import tao.chang.springframeworks.context.ApplicationEvent;

/**
 * @Author TaoChang
 * @Date 2023/4/13 20:39
 */
public interface ApplicationEventPublisher {
    void publishEvent(ApplicationEvent event);
}

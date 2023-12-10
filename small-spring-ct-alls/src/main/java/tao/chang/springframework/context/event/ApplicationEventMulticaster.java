package tao.chang.springframework.context.event;

import tao.chang.springframework.context.ApplicationEvent;
import tao.chang.springframework.context.ApplicationListener;


public interface ApplicationEventMulticaster {


    void addApplicationListener(ApplicationListener<?> listener);


    void removeApplicationListener(ApplicationListener<?> listener);


    void multicastEvent(ApplicationEvent event);

}

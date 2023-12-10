package tao.chang.springframework.context.event;

import tao.chang.springframework.context.ApplicationContext;
import tao.chang.springframework.context.ApplicationEvent;


public class ApplicationContextEvent extends ApplicationEvent {


    public ApplicationContextEvent(Object source) {
        super(source);
    }


    public final ApplicationContext getApplicationContext() {
        return (ApplicationContext) getSource();
    }

}

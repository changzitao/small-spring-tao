package tao.chang.springframeworks.context.event;

import tao.chang.springframeworks.context.ApplicationContext;
import tao.chang.springframeworks.context.ApplicationEvent;

/**
 * @Author TaoChang
 * @Date 2023/4/13 19:51
 */
public class ApplicationContextEvent extends ApplicationEvent {
    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public ApplicationContextEvent(Object source) {
        super(source);
    }
    public final ApplicationContext getApplicationContext(){
        return (ApplicationContext) getSource();
    }
}

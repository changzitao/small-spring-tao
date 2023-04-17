package tao.chang.springframeworks.context;

import java.util.EventObject;

/**
 * @Author TaoChang
 * @Date 2023/4/13 19:50
 */
public abstract class ApplicationEvent extends EventObject {
    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public ApplicationEvent(Object source) {
        super(source);
    }
}

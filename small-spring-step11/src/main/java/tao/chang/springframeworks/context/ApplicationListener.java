package tao.chang.springframeworks.context;

import java.util.EventListener;

/**
 * @Author TaoChang
 * @Date 2023/4/13 20:05
 */
public interface ApplicationListener<E extends ApplicationEvent> extends EventListener {
void onApplicationEvent(E event);
}

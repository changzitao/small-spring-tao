package tao.chang.springframeworks.context.event;

import tao.chang.springframeworks.beans.BeanException;
import tao.chang.springframeworks.beans.factory.BeanFactory;
import tao.chang.springframeworks.beans.factory.BeanFactoryAware;
import tao.chang.springframeworks.context.ApplicationEvent;
import tao.chang.springframeworks.context.ApplicationListener;
import tao.chang.springframeworks.utils.ClassUtils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * @Author TaoChang
 * @Date 2023/4/13 20:09
 */
public abstract class AbstractApplicationEventMulticaster implements ApplicationEventMulticaster, BeanFactoryAware {
    public final Set<ApplicationListener<ApplicationEvent>> applicationListeners = new LinkedHashSet<>();
    private BeanFactory beanFactory;
    @Override
    public void addApplicationListener(ApplicationListener<?> listener) {
        applicationListeners.add((ApplicationListener<ApplicationEvent>) listener);
    }

    @Override
    public void removeApplicationListener(ApplicationListener<?> listener) {
        applicationListeners.remove(listener);
    }


    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeanException {
        this.beanFactory = beanFactory;
    }

    protected Collection<ApplicationListener> getApplicationListeners(ApplicationEvent event){
        LinkedList<ApplicationListener> allListeners = new LinkedList<ApplicationListener>();
        for (ApplicationListener<ApplicationEvent> listener : applicationListeners)
        {
            if (supportsEvent(listener, event)) allListeners.add(listener);
        }
        return allListeners;
    }

   protected boolean supportsEvent(ApplicationListener<ApplicationEvent>  applicationListener,ApplicationEvent event) {
        Class<? extends ApplicationListener> listenerClass = applicationListener.getClass();
        Class<? > targetClass = ClassUtils.isCglibProxyClass(listenerClass)?listenerClass.getSuperclass():listenerClass;
        Type genericInterface = targetClass.getGenericInterfaces()[0];
       Type actualTypeArgument = ((ParameterizedType)genericInterface).getActualTypeArguments()[0];
       String className = actualTypeArgument.getTypeName();
       Class<?> eventClassName;
       try {
           eventClassName = Class.forName(actualTypeArgument.getTypeName());
       } catch (ClassNotFoundException e) {
           throw new BeanException("wrong event class name: " + className);
       }
       return eventClassName.isAssignableFrom(event.getClass());
   }
}

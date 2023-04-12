package tao.chang.springframeworks.context;

import tao.chang.springframeworks.beans.BeanException;

public interface ConfigurableApplicationContext extends ApplicationContext {

    void refresh()throws  BeanException;
    void registryShutdownHook();
    void close();
}

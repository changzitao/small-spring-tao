package tao.chang.springframework.context;

import tao.chang.springframework.beans.BeansException;

  
public interface ConfigurableApplicationContext extends ApplicationContext {

      
    void refresh() throws BeansException;

    void registerShutdownHook();

    void close();

}

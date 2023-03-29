package tao.chang.springframeworks.context;

import tao.chang.springframeworks.beans.BeanException;

import java.util.Map;

public interface ConfigurableApplicationContext extends ApplicationContext{
    void refresh()throws  BeanException;
}

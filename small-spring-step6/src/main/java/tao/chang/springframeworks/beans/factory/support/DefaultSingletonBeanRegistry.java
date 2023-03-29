package tao.chang.springframeworks.beans.factory.support;

import tao.chang.springframeworks.beans.factory.config.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.Map;

public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {
    Map<String, Object> registrySingletonBean = new HashMap<>();

    @Override
    public Object getSingletonBean(String beanName) {

        return registrySingletonBean.get(beanName);
    }
    public void addSingletonBean(String  beanName,Object beanObject){
        registrySingletonBean.put(beanName,beanObject);

    }
}

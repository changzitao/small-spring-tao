package tao.chang.springframeworks.beans.factory.support;

import tao.chang.springframeworks.beans.BeanException;
import tao.chang.springframeworks.beans.FactoryBean;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author TaoChang
 * @Date 2023/4/12 20:12
 */
public abstract class FactoryBeanRegistrySupport extends DefaultSingletonBeanRegistry {
    private final Map<String, Object> factoryBeanObjectCache = new ConcurrentHashMap<>();//FactoryBean产生的单例对象缓存，如果是单例则进行缓存，原型模式则不进入缓存。

    protected Object getCacheObjectForFactoryBean(String beanName) {
        Object object = factoryBeanObjectCache.get(beanName);
        return (object != NULL_OBJECT ? object : null);
    }
    //从工厂bean获取一个bean
    protected Object getObjectFormFactoryBean(FactoryBean factoryBean, String beanName) {
        if (factoryBean.isSingleton()) {
            Object object = this.factoryBeanObjectCache.get(beanName);
            if(object==null){
                object = doGetObjectFromFactoryBean(factoryBean,beanName);
                this.factoryBeanObjectCache.put(beanName,(object!=null?object:NULL_OBJECT));
            }

            return (object != NULL_OBJECT? object:null);
        } else {
            Object object = doGetObjectFromFactoryBean(factoryBean,beanName);
            return object;
        }
    }

    private Object doGetObjectFromFactoryBean(final FactoryBean factoryBean, final String beanName) {
        try {
           return factoryBean.getObject();
        }catch (Exception e){
            throw new BeanException("FactoryBean threw exception on object[" + beanName + "] creation", e);
        }
    }
}

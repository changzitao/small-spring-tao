package tao.chang.springframeworks.beans.factory.support;

import cn.hutool.core.util.StrUtil;
import tao.chang.springframeworks.beans.BeanException;
import tao.chang.springframeworks.beans.factory.DisposableBean;
import tao.chang.springframeworks.beans.factory.config.BeanDefinition;

import java.lang.reflect.Method;

public class DisposableBeanAdapter implements DisposableBean {
    private final Object bean;
    private final String beanName;
    private String destroyMethodName;

    public DisposableBeanAdapter(Object bean, String beanName, BeanDefinition beanDefinition) {
        this.bean = bean;
        this.beanName = beanName;
        this.destroyMethodName = beanDefinition.getDestroyMethodName();
    }

    @Override
    public void destroy() throws Exception {
        if(bean instanceof DisposableBean){
            ((DisposableBean) bean).destroy();
        }
        if(StrUtil.isNotEmpty(destroyMethodName)&&!(bean instanceof  DisposableBean)&&"destroy".equals(this.destroyMethodName)){
            Method method = bean.getClass().getMethod(destroyMethodName);
            if(null==method){
                throw new BeanException("Couldn't find a destroy method named '" + destroyMethodName + "' on bean with name '" + beanName + "'");
            }
            method.invoke(bean);
        }
    }
}

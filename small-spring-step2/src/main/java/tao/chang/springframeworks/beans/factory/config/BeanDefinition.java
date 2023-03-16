package tao.chang.springframeworks.beans.factory.config;

import tao.chang.springframeworks.beans.BeansException;

public class BeanDefinition {
    private Class beanClass;

    public BeanDefinition(Class beanClass) {
        this.beanClass = beanClass;
    }

    public Class getBeanClass() {
        return beanClass;
    }
    public void setBeanClass(Class beanClass){
        this.beanClass = beanClass;
    }

}

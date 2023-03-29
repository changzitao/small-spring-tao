package tao.chang.springframeworks.beans.factory.config;

import tao.chang.springframeworks.beans.PropertyValues;

public class BeanDefinition {
    private  Class  beanClass;
    private PropertyValues propertyValues;

    public PropertyValues getPropertyValues() {
        return propertyValues;
    }

    public void setPropertyValues(PropertyValues propertyValues) {
        this.propertyValues = propertyValues;
    }

    public BeanDefinition(Class clazz, PropertyValues propertyValues) {
        this.beanClass = clazz;
        this.propertyValues = propertyValues!=null?propertyValues:new PropertyValues();
    }

    public BeanDefinition(Class clazz) {
        this.beanClass = clazz;
        this.propertyValues = new PropertyValues();
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class clazz) {
        this.beanClass = clazz;
    }
}

package tao.chang.springframeworks.beans.factory.config;

import tao.chang.springframeworks.beans.PropertyValues;

public class BeanDefinition {
    String SCOPE_SINGLETON = ConfigurableBeanFactory.SCOPE_SINGLETON;

    String SCOPE_PROTOTYPE = ConfigurableBeanFactory.SCOPE_PROTOTYPE;
    private Class beanClass;
    private PropertyValues propertyValues;
    private String initMethodName;
    private String destroyMethodName;
    private String scope = SCOPE_SINGLETON;//"singleton"
    private boolean singleton = true;
    private boolean prototype = false;

    public void setScope(String scope) {
        this.scope = scope;
        this.singleton = SCOPE_SINGLETON.equals(scope);
        this.prototype = SCOPE_PROTOTYPE.equals(scope);//"prototype"
    }

    public boolean isPrototype(){
        return prototype;
    }
    public boolean isSingleton(){
        return singleton;
    }
    public String getInitMethodName() {
        return initMethodName;
    }

    public void setInitMethodName(String initMethodName) {
        this.initMethodName = initMethodName;
    }

    public String getDestroyMethodName() {
        return destroyMethodName;
    }

    public void setDestroyMethodName(String destroyMethodName) {
        this.destroyMethodName = destroyMethodName;
    }

    public PropertyValues getPropertyValues() {
        return propertyValues;
    }

    public void setPropertyValues(PropertyValues propertyValues) {
        this.propertyValues = propertyValues;
    }

    public BeanDefinition(Class clazz, PropertyValues propertyValues) {
        this.beanClass = clazz;
        this.propertyValues = propertyValues != null ? propertyValues : new PropertyValues();
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

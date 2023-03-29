package test.common;


import tao.chang.springframeworks.beans.BeanException;
import tao.chang.springframeworks.beans.PropertyValue;
import tao.chang.springframeworks.beans.PropertyValues;
import tao.chang.springframeworks.beans.factory.ConfigurableListableBeanFactory;
import tao.chang.springframeworks.beans.factory.config.BeanDefinition;
import tao.chang.springframeworks.beans.factory.config.BeanFactoryPostProcessor;
import tao.chang.springframeworks.beans.factory.config.ConfigurableBeanFactory;

public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {



    @Override
    public void postProcessorBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeanException {
        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("userService");
        PropertyValues propertyValues = beanDefinition.getPropertyValues();

        propertyValues.addPropertyValue(new PropertyValue("company", "改为：字节跳动"));
    }
}

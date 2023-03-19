package tao.chang.springframeworks.beans.factory.support;

import tao.chang.springframeworks.beans.BeanException;
import tao.chang.springframeworks.beans.factory.config.BeanDefinition;

import java.util.HashMap;
import java.util.Map;

public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements BeanDefinitionRegistry{
    Map<String,BeanDefinition> beanDefinitionMap = new HashMap<>();
    @Override
    public BeanDefinition getBeanDefinition(String name) throws BeanException {
        BeanDefinition beanDefinition = beanDefinitionMap.get(name);
        if(beanDefinition==null)throw  new BeanException("No bean named '" + name + "' is defined");
        return beanDefinition;
    }

    @Override
    public void registryBeanDefinition(String name,BeanDefinition beanDefinition){

        beanDefinitionMap.put(name,beanDefinition);
    }


}

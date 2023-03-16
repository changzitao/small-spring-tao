package tao.chang.springframeworks.beans.factory.support;

import tao.chang.springframeworks.beans.BeansException;
import tao.chang.springframeworks.beans.factory.config.BeanDefinition;

import java.util.HashMap;
import java.util.Map;

public class DefaultListableBeanFactory extends  AbstractAutowireCapableBeanFactory implements BeanDefinitionRegistry{
    private final Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();
    @Override
    protected BeanDefinition getBeanDefinition(String name) throws BeansException {
        BeanDefinition beanDefinition = beanDefinitionMap.get(name);
        if(beanDefinition==null){
            throw new BeansException("No bean named '" + name + "' is defined");
        }

        return beanDefinition;
    }

    @Override
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(beanName,beanDefinition);

    }
}

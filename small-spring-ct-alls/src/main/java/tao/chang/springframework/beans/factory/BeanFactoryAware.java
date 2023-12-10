package tao.chang.springframework.beans.factory;

import tao.chang.springframework.beans.BeansException;


public interface BeanFactoryAware extends Aware {

   void setBeanFactory(BeanFactory beanFactory) throws BeansException;

}

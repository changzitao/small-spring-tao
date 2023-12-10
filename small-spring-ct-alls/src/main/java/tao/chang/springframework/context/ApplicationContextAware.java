package tao.chang.springframework.context;

import tao.chang.springframework.beans.BeansException;
import tao.chang.springframework.beans.factory.Aware;


public interface ApplicationContextAware extends Aware {

    void setApplicationContext(ApplicationContext applicationContext) throws BeansException;

}
    
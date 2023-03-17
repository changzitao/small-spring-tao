package test;

import org.junit.Test;
import tao.chang.springframeworks.beans.factory.BeanFactory;
import tao.chang.springframeworks.beans.factory.config.BeanDefinition;
import tao.chang.springframeworks.beans.factory.support.DefaultListableBeanFactory;
import test.beans.UserService;

public class ApiTest {
    @Test
    public void test() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registerBeanDefinition("userService", beanDefinition);
        UserService userService = (UserService) beanFactory.getBean("userService","tao");
        userService.query();

    }
}

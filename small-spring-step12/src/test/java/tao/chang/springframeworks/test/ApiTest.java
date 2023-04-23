package tao.chang.springframeworks.test;

import org.junit.Test;
import tao.chang.springframeworks.context.support.ClassPathXmlApplicationContext;
import tao.chang.springframeworks.test.bean.IUserService;

/**
 * @Author TaoChang
 * @Date 2023/4/19 21:46
 */
public class ApiTest {
    @Test
    public void test_aop() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");

        IUserService userService = applicationContext.getBean("userService", IUserService.class);
        System.out.println("测试结果：" + userService.queryUserInfo());
    }

}

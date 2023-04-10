import org.junit.Test;
import step8.bean.UserDao;
import step8.bean.UserService;
import tao.chang.springframeworks.beans.factory.DisposableBean;
import tao.chang.springframeworks.beans.factory.config.BeanDefinition;
import tao.chang.springframeworks.beans.factory.support.DefaultSingletonBeanRegistry;
import tao.chang.springframeworks.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * @Author TaoChang
 * @Date 2023/4/10 20:00
 */

public class ApiTest {
    @Test
    public void test_xml() throws Exception {
// 1.初始化 BeanFactory
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        applicationContext.registryShutdownHook();
// 2. 获取 Bean 对象调用方法
        UserService userService = applicationContext.getBean("userService", UserService.class);
        String result = userService.queryUserInfo();
        System.out.println("测试结果：" + result);
        System.out.println("ApplicationContextAware" + userService.getApplicationContext());
        System.out.println("BeanFactoryAware：" + userService.getBeanFactory());
        UserDao userDao = applicationContext.getBean("userDao", UserDao.class);

System.exit(0);
    }
}

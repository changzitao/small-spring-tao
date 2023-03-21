import beans.UserDao;
import beans.UserService;
import cn.hutool.core.io.IoUtil;
import org.junit.Before;
import org.junit.Test;
import tao.chang.springframeworks.beans.PropertyValue;
import tao.chang.springframeworks.beans.PropertyValues;
import tao.chang.springframeworks.beans.factory.config.BeanDefinition;
import tao.chang.springframeworks.beans.factory.config.BeanReference;
import tao.chang.springframeworks.beans.factory.support.DefaultListableBeanFactory;
import tao.chang.springframeworks.beans.factory.xml.XmlBeanDefinitionReader;
import tao.chang.springframeworks.core.io.DefaultResourceLoader;
import tao.chang.springframeworks.core.io.Resource;

import java.io.IOException;
import java.io.InputStream;

public class ApiTest {
    @Test
    public void test_BeanFactory() {
        // 1.初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 2. UserDao 注册
        beanFactory.registryBeanDefinition("userDao", new BeanDefinition(UserDao.class));

        // 3. UserService 设置属性[uId、userDao]
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("uId", "10001"));
        propertyValues.addPropertyValue(new PropertyValue("userDao", new BeanReference("userDao")));

        // 4. UserService 注入bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class, propertyValues);
        beanFactory.registryBeanDefinition("userService", beanDefinition);

        // 5. UserService 获取bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        String result = userService.queryUserInfo();
        System.out.println("测试结果：" + result);
    }
    @Test
    public void test_xml() {
        // 1.初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 2. 读取配置文件&注册Bean
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("classpath:spring.xml");

        // 3. 获取Bean对象调用方法
        UserService userService =  beanFactory.getBean("userService", UserService.class);
        String result = userService.queryUserInfo();
        System.out.println("测试结果：" + result);
    }
    private DefaultResourceLoader resourceLoader;
    @Before
    public void init() {
        resourceLoader = new DefaultResourceLoader();
    }
    @Test
    public void test_url() throws IOException {
        Resource resource = resourceLoader.getResource("https://github.com/fuzhengwei/small-spring/important.properties");
        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.readUtf8(inputStream);
        System.out.println(content);
    }
    @Test

    public void test_file() throws IOException {
        Resource resource = resourceLoader.getResource("classpath:important.properties");
        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.readUtf8(inputStream);
        System.out.println(content);
    }
}

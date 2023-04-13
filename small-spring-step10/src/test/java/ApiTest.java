
import event.CustomEvent;
import org.junit.Test;
import tao.chang.springframeworks.context.support.ClassPathXmlApplicationContext;

/**
 * 作者：DerekYRC https://github.com/DerekYRC/mini-spring
 */
public class ApiTest {

    @Test
    public void test_event() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        applicationContext.publishEvent(new CustomEvent(applicationContext, 1019129009086763L, "成功了！"));

        applicationContext.registryShutdownHook();
    }

}

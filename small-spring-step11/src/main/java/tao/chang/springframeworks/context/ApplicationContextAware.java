package tao.chang.springframeworks.context;

import tao.chang.springframeworks.beans.BeanException;
import tao.chang.springframeworks.beans.factory.Aware;

/**
 * @Author TaoChang
 * @Date 2023/4/10 19:25
 */
public interface ApplicationContextAware extends Aware {
    void setApplicationContext(ApplicationContext applicationContext)throws BeanException;
}

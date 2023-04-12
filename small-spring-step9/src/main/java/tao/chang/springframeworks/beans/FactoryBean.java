package tao.chang.springframeworks.beans;

/**
 * @Author TaoChang
 * @Date 2023/4/12 20:10
 */
public interface FactoryBean<T> {
    T getObject() throws Exception;
    Class<?> getObjectType();
    boolean isSingleton();
}

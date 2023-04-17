package tao.chang.springframeworks.aop;

/**
 * @Author TaoChang
 * @Date 2023/4/17 20:22
 */
public interface ClassFilter {
    boolean matches(Class<?> clazz);
}

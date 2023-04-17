package tao.chang.springframeworks.aop;

import java.lang.reflect.Method;

/**
 * @Author TaoChang
 * @Date 2023/4/17 20:22
 */
public interface MethodMatcher {
    boolean matchers(Method method, Class<?> targetClass);
}

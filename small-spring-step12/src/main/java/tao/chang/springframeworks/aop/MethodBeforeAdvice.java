package tao.chang.springframeworks.aop;

import java.lang.reflect.Method;

/**
 * @Author TaoChang
 * @Date 2023/4/19 20:37
 */
public interface MethodBeforeAdvice {
    void before(Method method,Object[]args,Object object)throws Throwable;
}

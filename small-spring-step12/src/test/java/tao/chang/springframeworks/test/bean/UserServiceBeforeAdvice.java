package tao.chang.springframeworks.test.bean;

import tao.chang.springframeworks.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @Author TaoChang
 * @Date 2023/4/19 21:37
 */
public class UserServiceBeforeAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] args, Object object) throws Throwable {
        System.out.println("拦截方法：" + method.getName());
    }
}

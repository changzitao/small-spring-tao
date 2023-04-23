package tao.chang.springframeworks.aop.framework.adapter;

import net.sf.cglib.proxy.MethodProxy;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import tao.chang.springframeworks.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @Author TaoChang
 * @Date 2023/4/19 20:47
 */
public class MethodBeforeAdviceInterceptor implements MethodInterceptor {
    private MethodBeforeAdvice methodBeforeAdvice;

    public MethodBeforeAdviceInterceptor(MethodBeforeAdvice methodBeforeAdvice) {
        this.methodBeforeAdvice = methodBeforeAdvice;
    }

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        this.methodBeforeAdvice.before(methodInvocation.getMethod(), methodInvocation.getArguments(), methodInvocation.getThis());
        return methodInvocation.proceed();

    }
}

package tao.chang.springframeworks.aop;

import org.aopalliance.intercept.MethodInterceptor;

/**
 * @Author TaoChang
 * @Date 2023/4/17 20:39
 */
public class AdvisedSupport {
    // 被代理的目标对象
    private TargetSource targetSource;
    //ProxyConfig
    private boolean proxyTargetClass = false;
    // 方法拦截器
    private MethodInterceptor methodInterceptor;
    // 方法匹配器(检查目标方法是否符合通知条件)
    private MethodMatcher methodMatcher;

    public void setProxyTargetClass(boolean proxyTargetClass) {
        this.proxyTargetClass = proxyTargetClass;
    }

    public TargetSource getTargetSource() {
        return targetSource;
    }
    public boolean isProxyTargetClass() {
        return proxyTargetClass;
    }

    public void setTargetSource(TargetSource targetSource) {
        this.targetSource = targetSource;
    }

    public MethodInterceptor getMethodInterceptor() {
        return methodInterceptor;
    }

    public void setMethodInterceptor(MethodInterceptor methodInterceptor) {
        this.methodInterceptor = methodInterceptor;
    }

    public MethodMatcher getMethodMatcher() {
        return methodMatcher;
    }

    public void setMethodMatcher(MethodMatcher methodMatcher) {
        this.methodMatcher = methodMatcher;
    }
}

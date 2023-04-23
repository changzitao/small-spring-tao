package tao.chang.springframeworks.aop.framework;

import tao.chang.springframeworks.aop.AdvisedSupport;

/**
 * @Author TaoChang
 * @Date 2023/4/19 20:49
 */
public class ProxyFactory {
    private AdvisedSupport advisedSupport;


    public ProxyFactory(AdvisedSupport advisedSupport) {
        this.advisedSupport = advisedSupport;
    }
    public Object getProxy(){
        return this.createAopProxy().getProxy();
    }
    public AopProxy createAopProxy(){
        if(advisedSupport.isProxyTargetClass()){
            return new Cglib2AopProxy(advisedSupport);
        }
        return new JdkDynamicAopProxy(advisedSupport);
    }

}

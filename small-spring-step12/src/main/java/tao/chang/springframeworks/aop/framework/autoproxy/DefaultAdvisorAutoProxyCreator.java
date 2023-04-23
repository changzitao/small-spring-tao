package tao.chang.springframeworks.aop.framework.autoproxy;

import org.aopalliance.aop.Advice;
import org.aopalliance.intercept.MethodInterceptor;
import tao.chang.springframeworks.aop.*;
import tao.chang.springframeworks.aop.aspectj.AspectJExpressionPointcutAdvisor;
import tao.chang.springframeworks.aop.framework.ProxyFactory;
import tao.chang.springframeworks.beans.BeanException;
import tao.chang.springframeworks.beans.factory.BeanFactory;
import tao.chang.springframeworks.beans.factory.BeanFactoryAware;
import tao.chang.springframeworks.beans.factory.config.InstantiationAwareBeanPostProcessor;
import tao.chang.springframeworks.beans.factory.support.DefaultListableBeanFactory;

import java.util.Collection;

/**
 * @Author TaoChang
 * @Date 2023/4/19 21:06
 */
public class DefaultAdvisorAutoProxyCreator implements InstantiationAwareBeanPostProcessor , BeanFactoryAware {
    private DefaultListableBeanFactory beanFactory;
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeanException {
        return null;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeanException {
        return null;
    }

    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeanException {
        if(isInfrastructureClass(beanClass))return null;
        Collection<AspectJExpressionPointcutAdvisor> advisors = beanFactory.getBeansOfType(AspectJExpressionPointcutAdvisor.class).values();
        for (AspectJExpressionPointcutAdvisor advisor : advisors) {
            ClassFilter classFilter = advisor.getPointcut().getClassFilter();
            if (!classFilter.matches(beanClass)) continue;
            AdvisedSupport advisedSupport = new AdvisedSupport();
            TargetSource targetSource = null;
            try {
                targetSource = new TargetSource(beanClass.getDeclaredConstructor().
                        newInstance());
            } catch (Exception e) {
                e.printStackTrace();
            }
            advisedSupport.setTargetSource(targetSource);
            advisedSupport.setMethodInterceptor((MethodInterceptor) advisor.getAdvice());
            advisedSupport.setMethodMatcher(advisor.getPointcut().getMethodMatcher(
            ));
            advisedSupport.setProxyTargetClass(false);
            return new ProxyFactory(advisedSupport).getProxy();
        }
        return null;

    }
    private boolean isInfrastructureClass(Class<?> beanClass) {
        return Advice.class.isAssignableFrom(beanClass) || Pointcut.class.isAssignableFrom(beanClass) || Advisor.class.isAssignableFrom(beanClass);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeanException {
        this.beanFactory = (DefaultListableBeanFactory) beanFactory;
    }
}

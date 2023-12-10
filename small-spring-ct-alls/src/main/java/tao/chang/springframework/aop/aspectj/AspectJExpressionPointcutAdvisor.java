package tao.chang.springframework.aop.aspectj;

import tao.chang.springframework.aop.Pointcut;
import tao.chang.springframework.aop.PointcutAdvisor;
import org.aopalliance.aop.Advice;

  
public class AspectJExpressionPointcutAdvisor implements PointcutAdvisor {

  
    private AspectJExpressionPointcut pointcut;
  
    private Advice advice;
  
    private String expression;

    public void setExpression(String expression){
        this.expression = expression;
    }

    @Override
    public Pointcut getPointcut() {
        if (null == pointcut) {
            pointcut = new AspectJExpressionPointcut(expression);
        }
        return pointcut;
    }

    @Override
    public Advice getAdvice() {
        return advice;
    }

    public void setAdvice(Advice advice){
        this.advice = advice;
    }

}

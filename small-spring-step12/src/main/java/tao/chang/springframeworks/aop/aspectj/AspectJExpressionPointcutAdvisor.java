package tao.chang.springframeworks.aop.aspectj;

import org.aopalliance.aop.Advice;
import tao.chang.springframeworks.aop.Pointcut;
import tao.chang.springframeworks.aop.PointCutAdvisor;

/**
 * @Author TaoChang
 * @Date 2023/4/19 20:43
 */
public class AspectJExpressionPointcutAdvisor implements PointCutAdvisor {
    private AspectJExpressionPointcut aspectJExpressionPointcut;
    private Advice advice;
    private String expression;

    public void setAdvice(Advice advice) {
        this.advice = advice;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    @Override
    public Pointcut getPointcut() {
        if(null==aspectJExpressionPointcut){
            aspectJExpressionPointcut = new AspectJExpressionPointcut(expression);
        }
        return aspectJExpressionPointcut;
    }

    @Override
    public Advice getAdvice() {
        return advice;
    }
}

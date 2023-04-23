package tao.chang.springframeworks.aop;

/**
 * @Author TaoChang
 * @Date 2023/4/19 20:42
 */
public interface PointCutAdvisor extends Advisor {
    Pointcut getPointcut();
}

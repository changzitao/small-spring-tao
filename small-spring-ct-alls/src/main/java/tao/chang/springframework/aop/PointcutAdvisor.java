package tao.chang.springframework.aop;


public interface PointcutAdvisor extends Advisor {


    Pointcut getPointcut();

}

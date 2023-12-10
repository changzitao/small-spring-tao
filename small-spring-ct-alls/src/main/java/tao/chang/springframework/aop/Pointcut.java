package tao.chang.springframework.aop;


public interface Pointcut {


    ClassFilter getClassFilter();


    MethodMatcher getMethodMatcher();

}

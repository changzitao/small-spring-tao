package tao.chang.springframeworks.aop;



/**
 * @Author TaoChang
 * @Date 2023/4/17 20:19
 */
public interface PointCut {
    ClassFilter getClassFilter();
    MethodMatcher getMethodMatcher();
}

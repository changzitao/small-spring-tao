package tao.chang.springframeworks.aop;

/**
 * @Author TaoChang
 * @Date 2023/4/17 20:40
 */
public class TargetSource {
    private final Object target;

    public TargetSource(Object o) {
        this.target = o;
    }

    public Class<?>[] getTargetClass() {
        return this.target.getClass().getInterfaces();
    }
    public Object getTarget(){return this.target;}

}

package tao.chang.springframeworks.beans.factory.support;

import net.sf.cglib.proxy.NoOp;
import tao.chang.springframeworks.beans.factory.BeanException;
import tao.chang.springframeworks.beans.factory.config.BeanDefinition;
import net.sf.cglib.proxy.Enhancer;
import java.lang.reflect.Constructor;

public class CglibSubclassingInstantiationStrategy implements InstantiationStrategy {
    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeanException {
        Enhancer enhancer =new Enhancer();
        enhancer.setSuperclass(beanDefinition.getBeanClass());
        enhancer.setCallback(new NoOp() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        });
        if(null==ctor)return enhancer.create();
        return enhancer.create(ctor.getParameterTypes(),args);
    }
}

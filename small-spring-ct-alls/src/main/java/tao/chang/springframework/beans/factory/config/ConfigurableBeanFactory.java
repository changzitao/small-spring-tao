package tao.chang.springframework.beans.factory.config;

import tao.chang.springframework.beans.factory.HierarchicalBeanFactory;
import tao.chang.springframework.core.convert.ConversionService;
import tao.chang.springframework.util.StringValueResolver;
import org.jetbrains.annotations.Nullable;
import tao.chang.springframework.beans.factory.BeanFactory;


public interface ConfigurableBeanFactory extends HierarchicalBeanFactory, SingletonBeanRegistry {

    String SCOPE_SINGLETON = "singleton";

    String SCOPE_PROTOTYPE = "prototype";

    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);

    /**
     * 销毁单例对象
     */
    void destroySingletons();


    void addEmbeddedValueResolver(StringValueResolver valueResolver);


    String resolveEmbeddedValue(String value);


    void setConversionService(ConversionService conversionService);


    @Nullable
    ConversionService getConversionService();

}

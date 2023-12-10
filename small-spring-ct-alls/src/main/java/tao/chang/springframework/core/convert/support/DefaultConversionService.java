package tao.chang.springframework.core.convert.support;

import tao.chang.springframework.core.convert.converter.ConverterRegistry;

  
public class DefaultConversionService extends GenericConversionService{

    public DefaultConversionService() {
        addDefaultConverters(this);
    }

    public static void addDefaultConverters(ConverterRegistry converterRegistry) {
  
        converterRegistry.addConverterFactory(new StringToNumberConverterFactory());
    }

}

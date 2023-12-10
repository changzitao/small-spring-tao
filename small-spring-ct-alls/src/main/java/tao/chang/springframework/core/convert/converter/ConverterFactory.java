package tao.chang.springframework.core.convert.converter;

  
public interface ConverterFactory<S, R>{

      
    <T extends R> Converter<S, T> getConverter(Class<T> targetType);

}

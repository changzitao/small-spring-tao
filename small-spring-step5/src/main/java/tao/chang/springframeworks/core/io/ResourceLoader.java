package tao.chang.springframeworks.core.io;

public interface ResourceLoader extends Resource {
    String CLASSPATH_URL_PREFIX = "classpath:";

    Resource getResource(String location);
}

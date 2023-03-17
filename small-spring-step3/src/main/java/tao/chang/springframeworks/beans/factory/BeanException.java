package tao.chang.springframeworks.beans.factory;

public class BeanException extends RuntimeException{
    public BeanException(String msg){
        super(msg);
    }
    public  BeanException(String msg,Throwable throwable){
        super(msg,throwable);
    }
}

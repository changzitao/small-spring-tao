package tao.chang.springframeworks.beans;

public class BeanException extends RuntimeException{
    public BeanException (String msg){
        super(msg);
    }
    public BeanException(String msg,Throwable e){
        super(msg,e);
    }
}

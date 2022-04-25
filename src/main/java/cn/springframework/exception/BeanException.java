package cn.springframework.exception;

/**
 * @program: my-spring
 * @description:
 * @author: wyn
 * @create: 2022-04-24 22:36
 **/
public class BeanException extends RuntimeException{

    public BeanException(String message){
        super(message);
    }

    public BeanException(String message,Throwable cause){
        super(message,cause);
    }

}

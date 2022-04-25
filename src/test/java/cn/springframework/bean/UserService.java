package cn.springframework.bean;

import org.junit.Test;

/**
 * @program: my-spring
 * @description:
 * @author: wyn
 * @create: 2022-04-25 22:12
 **/
public class UserService {

    private String test;

    public UserService(){

    }

    public UserService(String test){
        this.test = test;
    }

    public void test(){
        System.out.println(test);
    }

}

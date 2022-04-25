package cn.springframework;

import cn.springframework.bean.UserService;
import cn.springframework.config.BeanDefinition;
import cn.springframework.factory.DefaultListableBeanFactory;
import org.junit.Test;

/**
 * @program: my-spring
 * @description:
 * @author: wyn
 * @create: 2022-04-25 22:12
 **/
public class ApiTest {

    @Test
    public void test(){
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registryBeanDefinition("userService",beanDefinition);
//
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.test();
//
//        UserService userService1 = (UserService) beanFactory.getBean("userService");
//        System.out.println(userService == userService1);

        UserService userService2 = (UserService) beanFactory.getBean("userService","wyn");
        userService2.test();
    }

}

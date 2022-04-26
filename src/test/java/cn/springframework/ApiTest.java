package cn.springframework;

import cn.springframework.bean.UserDao;
import cn.springframework.bean.UserService;
import cn.springframework.config.BeanDefinition;
import cn.springframework.config.BeanReference;
import cn.springframework.config.PropertyValue;
import cn.springframework.config.PropertyValues;
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

    @Test
    public void testApplyPropertyValues(){
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        BeanDefinition userDaoBeanDefiniton = new BeanDefinition(UserDao.class);
        beanFactory.registryBeanDefinition("userDao",userDaoBeanDefiniton);
        beanFactory.getBean("userDao","wyn");


        PropertyValue propertyValue1 = new PropertyValue("test","test");
        PropertyValue propertyValue2 = new PropertyValue("userDao",new BeanReference("userDao"));
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(propertyValue1);
        propertyValues.addPropertyValue(propertyValue2);

        BeanDefinition userServiceBeanDefinition = new BeanDefinition(UserService.class,propertyValues);
        beanFactory.registryBeanDefinition("userService",userServiceBeanDefinition);

        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.test();

    }


}

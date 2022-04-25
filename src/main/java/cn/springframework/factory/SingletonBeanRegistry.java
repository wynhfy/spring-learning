package cn.springframework.factory;

/**
 * @program: my-spring
 * @description:
 * @author: wyn
 * @create: 2022-04-24 22:40
 **/
public interface SingletonBeanRegistry {

    Object getSingleton(String beanName);

}

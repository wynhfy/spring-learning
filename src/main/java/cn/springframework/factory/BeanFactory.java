package cn.springframework.factory;

/**
 * @program: my-spring
 * @description:
 * @author: wyn
 * @create: 2022-04-24 22:32
 **/
public interface BeanFactory {

    Object getBean(String beanName);

}

package cn.springframework.factory;

/**
 * @program: my-spring
 * @description:
 * @author: wyn
 * @create: 2022-04-24 22:32
 **/
public interface BeanFactory {

    /**
     * 使用无参的构造方法
     * @param beanName
     * @return
     */
    Object getBean(String beanName);

    /**
     * 使用有参的构造方法
     * @param beanName
     * @param args
     * @return
     */
    Object getBean(String beanName,Object... args);

}

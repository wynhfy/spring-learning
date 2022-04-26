package cn.springframework.config;

/**
 * @program: my-spring
 * @description: bean引用，bean的属性是一个对象
 * @author: wyn
 * @create: 2022-04-26 23:03
 **/
public class BeanReference {

    private final String beanName;

    public BeanReference(String beanName){
        this.beanName = beanName;
    }

    public String getBeanName() {
        return beanName;
    }
}

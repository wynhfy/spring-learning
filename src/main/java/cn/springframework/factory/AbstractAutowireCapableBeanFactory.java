package cn.springframework.factory;

import cn.springframework.config.BeanDefinition;
import cn.springframework.exception.BeanException;

/**
 * @program: my-spring
 * @description:
 * @author: wyn
 * @create: 2022-04-24 22:50
 **/
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory{

    @Override
    public Object createBean(String beanName, BeanDefinition beanDefinition) throws BeanException {
        Object bean;
        try{
            bean = beanDefinition.getBeanClass().newInstance();
        } catch (IllegalAccessException | InstantiationException e) {
            throw new BeanException("Instantiation bean failed",e);
        }
        addSingleton(beanName,bean);
        return bean;
    }

}

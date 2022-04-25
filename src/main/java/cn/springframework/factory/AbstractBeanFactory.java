package cn.springframework.factory;

import cn.springframework.config.BeanDefinition;
import cn.springframework.exception.BeanException;

/**
 * @program: my-spring
 * @description:
 * @author: wyn
 * @create: 2022-04-24 22:45
 **/
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

    @Override
    public Object getBean(String beanName) {
        return doGetBean(beanName,null);
    }

    @Override
    public Object getBean(String beanName, Object... args) {
        return doGetBean(beanName,args);
    }

    public <T> T doGetBean(String beanName,Object... args){
        Object bean = getSingleton(beanName);
        if(bean!=null){
            return (T)bean;
        }
        BeanDefinition beanDefinition = getBeanDefinition(beanName);
        return (T)createBean(beanName,beanDefinition,args);
    }

    public abstract BeanDefinition getBeanDefinition(String beanName);

    public abstract Object createBean(String beanName,BeanDefinition beanDefinition,Object... args) throws BeanException;

}

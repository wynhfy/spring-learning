package cn.springframework.factory;

import cn.springframework.config.BeanDefinition;
import cn.springframework.exception.BeanException;

import java.lang.reflect.Constructor;

/**
 * @program: my-spring
 * @description:
 * @author: wyn
 * @create: 2022-04-24 22:50
 **/
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory{

    private InstantationStrategy instantationStrategy = new SimpleInstantionStrategy();

    @Override
    public Object createBean(String beanName, BeanDefinition beanDefinition, Object... args) throws BeanException {
        Object bean = null;
        try{
            bean = createBeanInstance(beanName,beanDefinition,args);
        }catch (Exception e){
            throw new BeanException("create Bean failed",e);
        }
        addSingleton(beanName,bean);
        return bean;
    }

    protected Object createBeanInstance(String beanName,BeanDefinition beanDefinition,Object... args){
        Constructor constructorToUse = null;
        Constructor<?>[] declaredConstructors = beanDefinition.getBeanClass().getDeclaredConstructors();
        for(Constructor ctor:declaredConstructors){
            if(null != args && ctor.getParameterTypes().length == args.length){
                constructorToUse = ctor;
                break;
            }
        }
        return getInstantationStrategy().instantiate(beanName,beanDefinition,constructorToUse,args);
    }

    public InstantationStrategy getInstantationStrategy() {
        return instantationStrategy;
    }

    public void setInstantationStrategy(InstantationStrategy instantationStrategy) {
        this.instantationStrategy = instantationStrategy;
    }
}

package cn.springframework.factory;

import cn.springframework.config.BeanDefinition;
import cn.springframework.exception.BeanException;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @program: my-spring
 * @description:
 * @author: wyn
 * @create: 2022-04-25 22:51
 **/
public class SimpleInstantionStrategy implements InstantationStrategy{

    @Override
    public Object instantiate(String beanName, BeanDefinition beanDefinition, Constructor ctor, Object[] args) throws BeanException {
        Class clazz = beanDefinition.getBeanClass();
        try{
            if(ctor!=null){
                return clazz.getDeclaredConstructor(ctor.getParameterTypes()).newInstance(args);
            }else {
                return clazz.getDeclaredConstructor().newInstance();
            }
        } catch (IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            throw new BeanException("instant bean failed",e);
        }
    }
}

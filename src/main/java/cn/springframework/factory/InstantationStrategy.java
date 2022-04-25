package cn.springframework.factory;

import cn.springframework.config.BeanDefinition;
import cn.springframework.exception.BeanException;

import java.lang.reflect.Constructor;

/**
 * @program: my-spring
 * @description:实例化策略
 * @author: wyn
 * @create: 2022-04-25 22:49
 **/
public interface InstantationStrategy {

    Object instantiate(String beanName, BeanDefinition beanDefinition, Constructor ctor,Object... args) throws BeanException;

}

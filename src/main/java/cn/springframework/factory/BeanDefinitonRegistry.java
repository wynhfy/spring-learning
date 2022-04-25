package cn.springframework.factory;

import cn.springframework.config.BeanDefinition;

/**
 * @program: my-spring
 * @description:
 * @author: wyn
 * @create: 2022-04-24 22:34
 **/
public interface BeanDefinitonRegistry {

    void registryBeanDefinition(String name, BeanDefinition beanDefinition);

}

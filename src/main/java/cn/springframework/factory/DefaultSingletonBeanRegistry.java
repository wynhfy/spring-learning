package cn.springframework.factory;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: my-spring
 * @description:
 * @author: wyn
 * @create: 2022-04-24 22:41
 **/
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry{

    private final Map<String,Object> singletonObjects = new HashMap<>();

    @Override
    public Object getSingleton(String beanName) {
        return singletonObjects.get(beanName);
    }

    protected void addSingleton(String beanName,Object singletonBean){
        singletonObjects.put(beanName,singletonBean);
    }
}

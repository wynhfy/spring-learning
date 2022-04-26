package cn.springframework.factory;

import cn.hutool.core.bean.BeanUtil;
import cn.springframework.config.BeanDefinition;
import cn.springframework.config.BeanReference;
import cn.springframework.config.PropertyValue;
import cn.springframework.config.PropertyValues;
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
            //实例化bean
            bean = createBeanInstance(beanName,beanDefinition,args);
            //bean属性填充
            applyPropertyValues(beanName,bean,beanDefinition);
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

    public void applyPropertyValues(String beanName,Object bean,BeanDefinition beanDefinition){
        try{
            PropertyValues propertyValues = beanDefinition.getPropertyValues();
            for (PropertyValue propertyValue : propertyValues.getPropertyValues()){
                String name = propertyValue.getName();
                Object value = propertyValue.getValue();
                if(value instanceof BeanReference){
                    BeanReference beanReference = (BeanReference) value;
                    value = getBean(beanReference.getBeanName());
                }
                BeanUtil.setFieldValue(bean,name,value);
            }
        }catch (Exception e){
            throw new BeanException("error setting property values:"+beanName);
        }
    }

    public InstantationStrategy getInstantationStrategy() {
        return instantationStrategy;
    }

    public void setInstantationStrategy(InstantationStrategy instantationStrategy) {
        this.instantationStrategy = instantationStrategy;
    }
}

package cn.springframework.config;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: my-spring
 * @description: bean属性集合
 * @author: wyn
 * @create: 2022-04-26 22:59
 **/
public class PropertyValues {

    private final List<PropertyValue> propertyValueList = new ArrayList<>();

    public void addPropertyValue(PropertyValue propertyValue){
        propertyValueList.add(propertyValue);
    }

    public PropertyValue[] getPropertyValues(){
        return propertyValueList.toArray(new PropertyValue[0]);
    }

    public PropertyValue getPropertyValue(String name){
        for(PropertyValue pv : propertyValueList){
            if(pv.getName().equals(name)){
                return pv;
            }
        }
        return null;
    }



}

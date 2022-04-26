package cn.springframework.config;

/**
 * @program: my-spring
 * @description: bean属性信息
 * @author: wyn
 * @create: 2022-04-26 22:57
 **/
public class PropertyValue {

    private final String name;

    private final Object value;

    public PropertyValue(String name,Object value){
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }
}

package cn.springframework.bean;

/**
 * @program: my-spring
 * @description:
 * @author: wyn
 * @create: 2022-04-26 23:12
 **/
public class UserDao {

    private String name;

    public UserDao(){

    }

    public void test(){
        System.out.println(name);
    }

    public UserDao(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

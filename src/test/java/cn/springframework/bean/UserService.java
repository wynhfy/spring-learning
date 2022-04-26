package cn.springframework.bean;


/**
 * @program: my-spring
 * @description:
 * @author: wyn
 * @create: 2022-04-25 22:12
 **/
public class UserService {

    private String test;

    private UserDao userDao;

    public UserService(){

    }

    public UserService(String test,UserDao userDao){
        this.test = test;
        this.userDao = userDao;
    }

    public UserService(String test){
        this.test = test;
    }

    public void test(){
        System.out.println(test);
        userDao.test();
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}

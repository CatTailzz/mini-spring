package com.cattail.springframework.test.bean;

import com.cattail.springframework.beans.BeansException;
import com.cattail.springframework.beans.factory.*;
import com.cattail.springframework.beans.factory.annotation.Autowired;
import com.cattail.springframework.beans.factory.annotation.Value;
import com.cattail.springframework.context.ApplicationContext;
import com.cattail.springframework.context.ApplicationContextAware;
import com.cattail.springframework.stereotype.Component;

import java.util.Random;

/**
 * @description:
 * @author：CatTail
 * @date: 2024/2/19
 * @Copyright: https://github.com/CatTailzz
 */
@Component("userService")
public class UserService implements IUserService{

//    private ApplicationContext applicationContext;
//    private BeanFactory beanFactory;

    private String uId;

    @Autowired
    private UserDao userDao;

    private String company;

    private String location;

    @Value("${token}")
    private String token;

    public String queryUserInfo(){
        try {
            Thread.sleep(new Random(1).nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return userDao.queryUserName("1001") + "." + token;
    }

    @Override
    public String register(String userName) {
        try {
            Thread.sleep(new Random(1).nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return userName + "注册成功！";
    }

    @Override
    public String toString() {
        return "UserService#token = { " + token + " }";
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

//    public ApplicationContext getApplicationContext() {
//        return applicationContext;
//    }
//
//    public BeanFactory getBeanFactory() {
//        return beanFactory;
//    }
//
//    @Override
//    public void setBeanClassLoader(ClassLoader classLoader) {
//        System.out.println("ClassLoader:" + classLoader);
//    }
//
//    @Override
//    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
//        this.beanFactory = beanFactory;
//    }
//
//    @Override
//    public void setBeanName(String name) {
//        System.out.println("Bean Name is:" + name);
//    }
//
//    @Override
//    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
//        this.applicationContext = applicationContext;
//    }

//    @Override
//    public void destory() throws Exception {
//        System.out.println("执行UserService.destroy");
//    }
//
//    @Override
//    public void afterPropertiesSet() throws BeansException {
//        System.out.println("执行UserService.afterPropertiesSet");
//    }
}

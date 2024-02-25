package com.cattail.springframework.test.bean;

import com.cattail.springframework.beans.BeansException;
import com.cattail.springframework.beans.factory.*;
import com.cattail.springframework.context.ApplicationContext;
import com.cattail.springframework.context.ApplicationContextAware;

/**
 * @description:
 * @author：CatTail
 * @date: 2024/2/19
 * @Copyright: https://github.com/CatTailzz
 */
public class UserService {

//    private ApplicationContext applicationContext;
//    private BeanFactory beanFactory;

    private String uId;

    private IUserDao userDao;

    private String company;

    private String location;

    public String queryUserInfo(){
        return userDao.queryUserName(uId) + ",公司：" + company + "，地点" + location;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public IUserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(IUserDao userDao) {
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

package com.cattail.springframework.test.bean;

import com.cattail.springframework.beans.BeansException;
import com.cattail.springframework.beans.factory.DisposableBean;
import com.cattail.springframework.beans.factory.InitializingBean;

/**
 * @description:
 * @author：CatTail
 * @date: 2024/2/19
 * @Copyright: https://github.com/CatTailzz
 */
public class UserService implements InitializingBean, DisposableBean {

    private String uId;

    private UserDao userDao;

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

    @Override
    public void destory() throws Exception {
        System.out.println("执行UserService.destroy");
    }

    @Override
    public void afterPropertiesSet() throws BeansException {
        System.out.println("执行UserService.afterPropertiesSet");
    }
}

package com.cattail.springframework.test.bean;

/**
 * @description:
 * @author：CatTail
 * @date: 2024/2/28
 * @Copyright: https://github.com/CatTailzz
 */
public class Husband {

    private Wife wife;

    public String queryWife() {
        return "Husband.wife";
    }

    public Wife getWife() {
        return wife;
    }

    public void setWife(Wife wife) {
        this.wife = wife;
    }
}

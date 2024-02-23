package com.cattail.springframework.test.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author：CatTail
 * @date: 2024/2/21
 * @Copyright: https://github.com/CatTailzz
 */
public class UserDao {

    private static Map<String, String> hashMap = new HashMap<>();

    public void initDataMethod() {
        System.out.println("执行init-method");
        hashMap.put("1001", "a");
        hashMap.put("1002", "b");
    }

    public void destroyDataMethod() {
        System.out.println("执行destroy-method");
        hashMap.clear();
    }

    public String queryUserName(String uId) {
        return hashMap.get(uId);
    }
}

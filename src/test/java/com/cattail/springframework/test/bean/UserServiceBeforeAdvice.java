package com.cattail.springframework.test.bean;

import com.cattail.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @description:
 * @author：CatTail
 * @date: 2024/2/27
 * @Copyright: https://github.com/CatTailzz
 */
public class UserServiceBeforeAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("before拦截方法" + method.getName());
    }
}

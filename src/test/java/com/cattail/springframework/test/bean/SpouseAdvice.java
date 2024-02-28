package com.cattail.springframework.test.bean;

import com.cattail.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @description:
 * @author：CatTail
 * @date: 2024/2/28
 * @Copyright: https://github.com/CatTailzz
 */
public class SpouseAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("关怀小两口（切面）" +  method);
    }
}

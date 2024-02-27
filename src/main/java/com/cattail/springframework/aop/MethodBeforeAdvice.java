package com.cattail.springframework.aop;

import java.lang.reflect.Method;

/**
 * @description:
 * @author：CatTail
 * @date: 2024/2/27
 * @Copyright: https://github.com/CatTailzz
 */
public interface MethodBeforeAdvice extends BeforeAdvice{

    void before(Method method, Object[] args, Object target) throws Throwable;
}

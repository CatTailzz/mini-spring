package com.cattail.springframework.aop;

import java.lang.reflect.Method;

/**
 * @description: 方法匹配，找到表达式范围内匹配下的目标类和方法
 * @author：CatTail
 * @date: 2024/2/26
 * @Copyright: https://github.com/CatTailzz
 */
public interface MethodMatcher {


    boolean matches(Method method, Class<?> targetClass);
}

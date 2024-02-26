package com.cattail.springframework.aop;

/**
 * @description:
 * @author：CatTail
 * @date: 2024/2/26
 * @Copyright: https://github.com/CatTailzz
 */
public interface Pointcut {

    ClassFilter getClassFilter();

    MethodMatcher getMethodMatcher();
}

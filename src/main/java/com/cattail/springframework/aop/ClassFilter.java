package com.cattail.springframework.aop;

/**
 * @description: 用于切点找到给定的接口和目标类
 * @author：CatTail
 * @date: 2024/2/26
 * @Copyright: https://github.com/CatTailzz
 */
public interface ClassFilter {

    boolean matches(Class<?> clazz);
}

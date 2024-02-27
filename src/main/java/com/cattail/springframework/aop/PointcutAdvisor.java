package com.cattail.springframework.aop;

/**
 * @description: 组合Advice和Pointcut
 * @author：CatTail
 * @date: 2024/2/27
 * @Copyright: https://github.com/CatTailzz
 */
public interface PointcutAdvisor extends Advisor{

    Pointcut getPointcut();
}

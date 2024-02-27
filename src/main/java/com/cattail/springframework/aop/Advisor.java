package com.cattail.springframework.aop;

import org.aopalliance.aop.Advice;

/**
 * @description: Advisor访问者
 * @author：CatTail
 * @date: 2024/2/27
 * @Copyright: https://github.com/CatTailzz
 */
public interface Advisor {

    Advice getAdvice();

}

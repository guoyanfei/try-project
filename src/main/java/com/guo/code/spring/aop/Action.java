package com.guo.code.spring.aop;

import java.lang.annotation.*;

/**
 * Created by gyf .
 * 16/7/28 .
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Action {
    String name();
}

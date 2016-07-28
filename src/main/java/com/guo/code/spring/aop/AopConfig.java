package com.guo.code.spring.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by gyf .
 * 16/7/28 .
 */
@Configuration
@ComponentScan("com.guo.code.spring.aop")
@EnableAspectJAutoProxy
public class AopConfig {
}

package com.guo.code.spring.prepost;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by gyf .
 * 16/7/28 .
 */
@Configuration
@ComponentScan("com.guo.code.spring.prepost")
public class PrePostConfig {

    @Bean(initMethod = "init", destroyMethod = "destroy")
    public BeanWayService getBeanWayService() {
        return new BeanWayService();
    }

    @Bean
    public JSR250WayService getJsr250WayService() {
        return new JSR250WayService();
    }
}

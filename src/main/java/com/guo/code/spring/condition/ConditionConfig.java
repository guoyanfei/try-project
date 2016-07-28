package com.guo.code.spring.condition;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * Created by gyf .
 * 16/7/28 .
 */
@Configuration
public class ConditionConfig {

    @Bean
    @Conditional(WindowsCondition.class)
    public ListService getWindowsListService() {
        return new WindowsListService();
    }

    @Bean
    @Conditional(LinuxCondition.class)
    public ListService getLinuxListService() {
        return new LinuxListService();
    }

    @Bean
    @Conditional(MacOsCondition.class)
    public ListService getMacOsListService() {
        return new MacOsListService();
    }
}

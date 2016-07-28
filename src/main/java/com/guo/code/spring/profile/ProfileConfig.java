package com.guo.code.spring.profile;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Created by gyf .
 * 16/7/28 .
 */
@Configuration
public class ProfileConfig {

    @Bean
    @Profile("dev")
    public DemoService getDevDemoService() {
        return new DemoService("dev env");
    }

    @Bean
    @Profile("prod")
    public DemoService getProdDemoService() {
        return new DemoService("prod env");
    }
}

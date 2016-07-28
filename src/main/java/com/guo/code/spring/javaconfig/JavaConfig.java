package com.guo.code.spring.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by gyf .
 * 16/7/28 .
 */
@Configuration
public class JavaConfig {

    @Bean
    public UserInfoService getUserInfoService() {
        return new UserInfoService();
    }

//    @Bean
//    public UserClassService getUserClassService() {
//        UserClassService userClassService = new UserClassService();
//        userClassService.setUserInfoService(getUserInfoService());
//        return userClassService;
//    }

    @Bean
    public UserClassService getUserClassService(UserInfoService userInfoService) {
        UserClassService userClassService = new UserClassService();
        userClassService.setUserInfoService(userInfoService);
        return userClassService;
    }
}

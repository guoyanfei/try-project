package com.guo.code.spring.javaconfig;

/**
 * Created by gyf .
 * 16/7/28 .
 */
public class UserClassService {

    private UserInfoService userInfoService;

    public void setUserInfoService(UserInfoService userInfoService) {
        this.userInfoService = userInfoService;
    }

    public void sayHello() {
        userInfoService.sayHello();
    }
}

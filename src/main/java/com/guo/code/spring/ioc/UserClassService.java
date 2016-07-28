package com.guo.code.spring.ioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by gyf .
 * 16/7/28 .
 */
@Service
public class UserClassService {

    @Autowired
    private UserInfoService userInfoService;

    public void sayHello() {
        userInfoService.sayHello();
    }
}

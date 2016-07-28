package com.guo.code.spring.fixedannotation;

import org.springframework.stereotype.Service;

/**
 * Created by gyf .
 * 16/7/28 .
 */
@Service
public class DemoService {

    public void outputResult() {
        System.out.println("从组合注解配置照样活得的 bean");
    }
}

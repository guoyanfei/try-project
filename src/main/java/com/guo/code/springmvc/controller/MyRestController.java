package com.guo.code.springmvc.controller;

import com.guo.code.springmvc.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by gyf .
 * 16/7/30 .
 */
@RestController
public class MyRestController {

    @Autowired
    DemoService demoService;

    @ResponseBody
    @RequestMapping(value = "/testRest", produces = "test/plain;charset=UTF-8")
    public String testRest() {
        return demoService.saySomething();
    }
}

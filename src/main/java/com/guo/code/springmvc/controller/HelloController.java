package com.guo.code.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by gyf .
 * 16/7/28 .
 */
@Controller
public class HelloController {

    @RequestMapping("/index")
    public String hello() {
        return "index";
    }
}

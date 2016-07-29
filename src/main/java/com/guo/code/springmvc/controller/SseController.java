package com.guo.code.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

/**
 * Created by gyf .
 * 16/7/29 .
 */
@Controller
public class SseController {

    @ResponseBody
    @RequestMapping(value = "/push", produces = "text/event-stream")
    public String push() {
        Random r = new Random();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "data: Testing 1,2,3" + r.nextInt() + "\n\n";
    }
}

package com.guo.code.springmvc.controller;

import com.guo.code.springmvc.domain.DemoObj;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by gyf .
 * 16/7/29 .
 */
@Controller
public class ConverterController {

    @ResponseBody
    @RequestMapping(value = "/convert", produces = {"application/x-wisely"})
    public DemoObj convert(@RequestBody DemoObj obj) {
        return obj;
    }
}

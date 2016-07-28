package com.guo.code.springmvc.controller;

import com.guo.code.springmvc.domain.DemoObj;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by gyf .
 * 16/7/28 .
 */
@RestController
@RequestMapping("/rest")
public class DemoRestController {

    @RequestMapping(value = "/getjson", produces = "application/json;charset=UTF-8")
    public DemoObj getjson(DemoObj obj) {
        return new DemoObj(obj.getId(), obj.getName());
    }

    @RequestMapping(value = "getxml", produces = "application/xml;charset=UTF-8")
    public DemoObj getxml(DemoObj obj) {
        return new DemoObj(obj.getId(), obj.getName());
    }
}

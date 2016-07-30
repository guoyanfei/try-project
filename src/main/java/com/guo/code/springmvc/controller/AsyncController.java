package com.guo.code.springmvc.controller;

import com.guo.code.springmvc.service.PushService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;

/**
 * Created by gyf .
 * 16/7/30 .
 */
@Controller
public class AsyncController {

    @Autowired
    private PushService pushService;

    @ResponseBody
    @RequestMapping("/defer")
    public DeferredResult<String> deferredCall() {
        return pushService.getAsyncUpdate();
    }
}

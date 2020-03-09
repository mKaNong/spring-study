package com.ahdy.xem.test.aop.controller;

import com.ahdy.xem.test.aop.aspect.ApiLog;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("aop")
public class AopController {

    @RequestMapping("test")
    @ApiLog(name = "aop test", intoDb = false)
    public String aop() {
        return "aop success";
    }

}

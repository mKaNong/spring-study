package com.ahdy.xem.com.ahdy.xem;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("spring")
public class controller {

    @RequestMapping("test")
    public String test() {
        return "success!";
    }

}

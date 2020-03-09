package com.ahdy.xem.transaction.controller;

import com.ahdy.xem.common.api.R;
import com.ahdy.xem.transaction.aspect.ApiLog;
import com.ahdy.xem.transaction.service.OrdersService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("order")
public class OrderController {

    @Resource
    private OrdersService ordersService;

    @RequestMapping(value = "post", method = RequestMethod.POST, headers = {"content-type=application/json;charset=UTF-8"}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public R post(@RequestBody String name) throws Exception{
        String s = name;
        System.out.println(s);
        return R.data(s);
    }

    @RequestMapping("trans")
    @ResponseBody
    @ApiLog
    public R trans() {
        ordersService.accountMoney();
        return R.data("ok");
    }

}

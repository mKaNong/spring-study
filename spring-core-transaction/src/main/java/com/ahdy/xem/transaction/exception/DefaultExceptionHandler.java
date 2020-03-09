package com.ahdy.xem.transaction.exception;

import com.ahdy.xem.common.api.R;
import com.ahdy.xem.common.constant.ResultCode;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class DefaultExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public R processException() {
        return R.data(ResultCode.FAILURE.getCode(), null, "request failed! please try again!");
    }

}

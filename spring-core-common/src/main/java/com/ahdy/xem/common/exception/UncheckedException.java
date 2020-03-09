package com.ahdy.xem.common.exception;

import com.ahdy.xem.common.constant.IResultCode;
import com.ahdy.xem.common.constant.ResultCode;
import lombok.Getter;

/**
 * 参数校验Exception
 */
public class UncheckedException extends RuntimeException {

    @Getter
    private IResultCode resultCode;

    public UncheckedException(String msg) {
        super(msg);
        this.resultCode = ResultCode.PARAM_VALID_ERROR;
    }

    public UncheckedException(IResultCode resultCode) {
        super(resultCode.getMessage());
        this.resultCode = resultCode;
    }

    public UncheckedException(IResultCode resultCode, Throwable throwable) {
        super(throwable);
        this.resultCode = resultCode;
    }

    @Override
    public Throwable fillInStackTrace() {
        return this;
    }

}

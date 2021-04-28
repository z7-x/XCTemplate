package com.z7.legal.exception;

import com.z7.legal.common.ResultCode;

/**
 * @Classname CustomException
 * @Description TODO 自定义异常
 * @Date 2021/4/25 5:36 下午
 * @Author z7-x
 */
public class CustomException extends Exception {

    private static final long serialVersionUID = 1L;
    private ResultCode message;

    public CustomException(ResultCode message) {
        super(message.getMessage());
        this.message = message;
    }

    public CustomException(ResultCode message, String msg) {
        super(msg);
        this.message = message;
    }
}

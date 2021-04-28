package com.z7.legal.exception;

import com.z7.legal.common.ResultCode;

/**
 * @Classname MutationException
 * @Description TODO 写入操作异常类
 * @Date 2021/4/27 2:50 下午
 * @Author z7-x
 */
public class MutationException extends CustomException{


    public MutationException(ResultCode message) {
        super(message);
    }

    public MutationException(ResultCode message, String msg) {
        super(message, msg);
    }
}

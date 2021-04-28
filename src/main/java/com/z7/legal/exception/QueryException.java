package com.z7.legal.exception;

import com.z7.legal.common.ResultCode;

/**
 * @Classname QueryException
 * @Description TODO 读取操作异常类
 * @Date 2021/4/27 2:50 下午
 * @Author z7-x
 */
public class QueryException  extends CustomException{
    
    public QueryException(ResultCode message) {
        super(message);
    }

    public QueryException(ResultCode message, String msg) {
        super(message, msg);
    }
}

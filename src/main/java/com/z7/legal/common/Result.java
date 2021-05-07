package com.z7.legal.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Classname Result
 * @Description TODO 数据的返回格式
 * @Date 2021/4/22 13:33 下午
 * @Author z7-x
 */
@Data
@ApiModel("返回数据")
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "返回状态", example = "200")
    protected Integer code;

    @ApiModelProperty(value = "返回数据")
    protected T data;

    @ApiModelProperty(value = "返回消息", example = "OK")
    protected String msg;

    @ApiModelProperty(value = "分页数据")
    protected Page page;

    /**
     * @param data 返回数据
     * @param code 状态码
     * @param msg  返回消息
     * @param page 分页数据
     */
    public Result(T data, Integer code, String msg, Page page) {
        this.data = data;
        this.code = code;
        this.msg = msg;
        this.page = page;
    }

    /**
     * @param data 返回数据
     * @param page 分页数据
     */
    public Result(T data, Page page) {
        this.data = data;
        this.code = ResultCode.OK.getCode();
        this.msg = ResultCode.OK.getMessage();
        this.page = page;
    }

    /**
     * @param data 返回数据
     * @param code 状态码
     * @param msg  返回消息
     */
    public Result(T data, Integer code, String msg) {
        this.data = data;
        this.code = code;
        this.msg = msg;
    }

    /**
     * @param data 返回数据
     */
    public Result(T data) {
        this.data = data;
        this.code = ResultCode.OK.getCode();
        this.msg = ResultCode.OK.getMessage();
    }

    /**
     * 执行成功
     */
    public Result() {
        this.data = null;
        this.code = ResultCode.OK.getCode();
        this.msg = ResultCode.OK.getMessage();
    }

    /**
     * @param code 状态码
     * @param info 自定义消息
     */
    public Result(ResultCode code, String info) {
        this.data = null;
        this.code = code.getCode();
        this.msg = code.getMessage() + ":" + info;
    }

    /**
     *
     * @param data
     * @param <T>
     * @return
     */
    public static <T> Result<T> success(T data) {
        return new Result<>(data);
    }
}

package com.z7.legal.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * @Classname Prams
 * @Description TODO 请求参数
 * @Date 2021/4/23 6:31 下午
 * @Author z7-x
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "分页请求")
public class RequestPram<T> {

    @ApiModelProperty(value = "当前页码", example = "1")
    private int pageNum;

    @ApiModelProperty(value = "每页数量", example = "10")
    private int pageSize;

    @ApiModelProperty(value = "排序字段")
    private Sort sort;

    @ApiModelProperty(value = "单维度条件查询")
    private T queryPram;

    @ApiModelProperty(value = "多维度条件查询")
    private Map<String, Object> queryMaps;
}

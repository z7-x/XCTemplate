package com.z7.legal.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


/**
 * @Classname Prams
 * @Description TODO 分页设置
 * @Date 2021/4/23 5:21 下午
 * @Author z7-x
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("分页数据")
public class Page implements Serializable {

    @ApiModelProperty(value = "当前页数")
    private Integer pageNum;

    @ApiModelProperty(value = "每页显示数")
    private Integer pageSize;

    @ApiModelProperty(value = "总页数")
    private Integer totalPages;

    @ApiModelProperty(value = "总记录数")
    private Long total;
}
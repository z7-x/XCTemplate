package com.z7.legal.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Classname Result
 * @Description TODO 排序
 * @Date 2021/4/22 13:33 下午
 * @Author z7-x
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "排序")
public class Sort {

    @ApiModelProperty(value = "字段名")
    private String field;

    @ApiModelProperty(value = "升序:asc,倒叙：desc")
    private String order;
}

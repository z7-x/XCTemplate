package com.z7.legal.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @Classname Permission
 * @Description TODO
 * @Date 2021/4/21 3:19 下午
 * @Author z7-x
 */
@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "XC_PERMISSION")
@ApiModel(value = "权限信息")
public class Permission {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "权限ID")
    private Long id;

    @Column(name = "name")
    @ApiModelProperty(value = "权限名")
    private String name;
}

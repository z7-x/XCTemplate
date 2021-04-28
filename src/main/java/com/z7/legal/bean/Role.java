package com.z7.legal.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @Classname Role
 * @Description TODO
 * @Date 2021/4/21 3:19 下午
 * @Author z7-x
 */
@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "XC_ROLE")
@ApiModel(value = "角色信息")
public class Role {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "角色ID")
    private Long id;

    @Column(name = "name")
    @ApiModelProperty(value = "角色名")
    private String name;
}

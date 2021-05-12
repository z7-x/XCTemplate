package com.z7.legal.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Classname Person
 * @Description TODO
 * @Date 2021/4/20 2:16 下午
 * @Author z7-x
 */
@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "XC_USER")
@ApiModel(value = "用户信息")
public class User implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "custom-id")
    @GenericGenerator(name = "custom-id", strategy = "com.z7.legal.utils.CustomIDGenerator")
    @ApiModelProperty(value = "用户ID")
    private String id;

    @Column(name = "sex")
    @ApiModelProperty(value = "性别")
    private String sex;

    @Column(name = "name")
    @ApiModelProperty(value = "姓名")
    private String name;

    @Column(name = "email")
    @ApiModelProperty(value = "E-mail")
    private String email;

    @Column(name = "phone")
    @ApiModelProperty(value = "电话")
    private String phone;

    @Column(name = "describe")
    @ApiModelProperty(value = "描叙")
    private String describe;
}

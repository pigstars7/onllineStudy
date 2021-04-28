package com.xupt.servicestu.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @author 朱星鑫
 * @create 2021-03-08 17:59
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Admin对象", description="")
public class Admin {
    private String adminId;
    private String adminName;
    private String password;
    private Integer role;
}

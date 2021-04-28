package com.xupt.servicestu.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @author 朱星鑫
 * @create 2021-03-08 17:43
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="登录对象", description="")
public class Login {
    private String userId;
    private String password;
    private String captchaCode;

}

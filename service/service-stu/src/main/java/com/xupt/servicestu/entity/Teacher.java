package com.xupt.servicestu.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @author 朱星鑫
 * @create 2021-03-08 17:58
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Teacher对象", description="")
public class Teacher {
    private String teacherId;
    private Integer classId;
    private String teacherName;
    private String password;
    private Integer role;
    private String stuClass;
}

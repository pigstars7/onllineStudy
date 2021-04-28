package com.xupt.servicestu.entity.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @author 朱星鑫
 * @create 2021-03-25 14:05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="newCourse", description="")
public class newCourse {
    private String name;
    private String synopsis;
    private String gradle;
    private Integer time;
    private String video;
    private String address;
    private String details;
    private Integer id;
    private Integer classId;
    private String teacherId;
    private String owner;
}

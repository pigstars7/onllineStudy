package com.xupt.servicestu.entity.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @author 朱星鑫
 * @create 2021-03-24 21:07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="CourseVo", description="")
public class CourseVo {
    private String name;
    private String synopsis;
    private String stuClass;
    private String gradle;
    private Integer time;
    private String video;
    private String address;
    private String details;
    private Integer id;

}

package com.xupt.servicestu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xupt.servicestu.entity.Curriculum;
import com.xupt.servicestu.entity.vo.newCourse;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhuxingxin
 * @since 2021-03-07
 */
public interface CurriculumService extends IService<Curriculum> {
    //删除课程表
    int deleteByCoursesId(Integer courseId);

    //更改课程表classID
    int updateClassId(Integer classId, Integer courseId);

    //添加新课程表
    int insertNew(newCourse newCourse);
}

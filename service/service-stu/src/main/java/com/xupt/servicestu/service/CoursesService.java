package com.xupt.servicestu.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xupt.servicestu.entity.Courses;
import com.xupt.servicestu.entity.vo.CourseVo;
import com.xupt.servicestu.entity.vo.newCourse;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhuxingxin
 * @since 2021-03-07
 */
public interface CoursesService extends IService<Courses> {
    //分页查询课程信息
    IPage<Courses> findAllByPage(Page<Courses> page, Integer classId);

    //查询所有课程信息
    List<Courses> findAll(Integer classId);

    //获取单个课程的所有信息
    Courses getCourseMsg(Integer courseId);

    //上传视频后存入url
    int insertVideo(Integer courseId, String videoPath);

    //根据老师ID获取课程信息
    IPage<CourseVo> findAllByTeacher(Page<CourseVo> page, Integer teacherId);

    //根据课程id删除
    int deleteCourse(Integer courseId);

    //根据课程ID查询当前信息
    CourseVo findCourseVo(Integer courseId);

    //根据课程id更改当前课程信息
    int updateCourse(CourseVo courseVo);

    //添加新课程
    int inserNewCourse(newCourse newCourse);
}

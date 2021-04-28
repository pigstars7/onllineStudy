package com.xupt.servicestu.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xupt.servicestu.entity.Courses;
import com.xupt.servicestu.entity.vo.CourseVo;
import com.xupt.servicestu.entity.vo.newCourse;
import com.xupt.servicestu.mapper.CoursesMapper;
import com.xupt.servicestu.service.CoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhuxingxin
 * @since 2021-03-07
 */
@Service
public class CoursesServiceImpl extends ServiceImpl<CoursesMapper, Courses> implements CoursesService {

    @Autowired
    private CoursesMapper coursesMapper;

    @Override
    public IPage<Courses> findAllByPage(Page<Courses> page, Integer classId) {
        return coursesMapper.findAllByPage(page, classId);
    }

    @Override
    public List<Courses> findAll(Integer classId) {
        return coursesMapper.findAll(classId);
    }

    @Override
    public Courses getCourseMsg(Integer courseId) {
        return coursesMapper.getMsg(courseId);
    }

    @Override
    public int insertVideo(Integer courseId, String videoPath) {
        return coursesMapper.insertVideo(courseId, videoPath);
    }

    @Override
    public IPage<CourseVo> findAllByTeacher(Page<CourseVo> page, Integer teacherId) {
        return coursesMapper.findAllByTeacher(page, teacherId);
    }

    @Override
    public int deleteCourse(Integer courseId) {
        return coursesMapper.deleteCourse(courseId);
    }

    @Override
    public CourseVo findCourseVo(Integer courseId) {
        return coursesMapper.findCourseVo(courseId);
    }

    @Override
    public int updateCourse(CourseVo courseVo) {
        return coursesMapper.updateCourse(courseVo);
    }

    @Override
    public int inserNewCourse(newCourse newCourse) {
        return coursesMapper.insertCourse(newCourse);
    }


}

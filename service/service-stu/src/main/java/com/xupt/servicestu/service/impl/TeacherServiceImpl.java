package com.xupt.servicestu.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xupt.commonutils.MD5;
import com.xupt.servicestu.entity.Teacher;
import com.xupt.servicestu.mapper.TeacherMapper;
import com.xupt.servicestu.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhuxingxin
 * @since 2021-03-07
 */
@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public int updatePwd(Teacher teacher) {
        teacher.setPassword(MD5.encrypt(teacher.getPassword()));
        return teacherMapper.updatePwd(teacher);
    }

    @Override
    public int deleteTeacher(String teacherId) {
        return teacherMapper.deleteTeacher(teacherId);
    }

    @Override
    public int addTeacher(Teacher teacher) {
        return teacherMapper.insertTeacher(teacher);
    }

    @Override
    public int changeTeacherMS(Teacher teacher) {
        return teacherMapper.changeTeacher(teacher);
    }

    @Override
    public IPage<Teacher> getAllTeacher(Page<Teacher> page) {
        return teacherMapper.getAllTeacher(page);
    }

    @Override
    public Teacher getOneTeach(String teacherId) {
        return teacherMapper.getOneTeacher(teacherId);
    }
}

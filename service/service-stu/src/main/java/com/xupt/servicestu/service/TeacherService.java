package com.xupt.servicestu.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xupt.servicestu.entity.Teacher;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhuxingxin
 * @since 2021-03-07
 */
public interface TeacherService {

    //修改密码
    int updatePwd(Teacher teacher);

    //删除老师
    int deleteTeacher(String teacherId);

    //新增老师
    int addTeacher(Teacher teacher);

    //修改老师信息
    int changeTeacherMS(Teacher teacher);

    //分页获取所有老师
    IPage<Teacher> getAllTeacher(Page<Teacher> page);

    //根据老师Id获取单个老师信息
    Teacher getOneTeach(String teacherId);
}

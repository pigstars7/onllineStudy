package com.xupt.servicestu.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xupt.servicestu.entity.Student;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhuxingxin
 * @since 2021-03-07
 */
public interface StudentService extends IService<Student> {

    //获取学生班级
    String getClass(Integer classId);

    //获取学生老师
    String getTeacher(String teacherId);

    //修改密码
    int updatePwd(Student student);

    //删除学生
    int deleteStudent(Integer studentId);

    //新增学生
    int addStudent(Student student);

    //修改学生信息
    int changeStudentMS(Student student);

    //根据教师ID获取所有学生
    IPage<Student> getAllStudent(Page<Student> Student, Integer teacherId);

    //根据学生Id获取单个学生信息
    Student getOneStu(Integer studentId);
}

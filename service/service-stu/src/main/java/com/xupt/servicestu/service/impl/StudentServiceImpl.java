package com.xupt.servicestu.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xupt.commonutils.MD5;
import com.xupt.servicestu.entity.Student;
import com.xupt.servicestu.mapper.StudentMapper;
import com.xupt.servicestu.service.StudentService;
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
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public String getClass(Integer classId) {
        return studentMapper.getClass(classId);
    }

    @Override
    public String getTeacher(String teacherId) {
        return studentMapper.getTeacher(teacherId);
    }

    @Override
    public int updatePwd(Student student) {
        student.setPassword(MD5.encrypt(student.getPassword()));
        return studentMapper.updatePwd(student);
    }

    @Override
    public int deleteStudent(Integer studentId) {
        return studentMapper.deleteStudent(studentId);
    }

    @Override
    public int addStudent(Student student) {
        return studentMapper.insertStudent(student);
    }

    @Override
    public int changeStudentMS(Student student) {
        return studentMapper.changeStudent(student);
    }

    @Override
    public IPage<Student> getAllStudent(Page<Student> Student, Integer teacherId) {
        return studentMapper.getAllStudent(Student, teacherId);
    }

    @Override
    public Student getOneStu(Integer studentId) {
        return studentMapper.getOneStudent(studentId);
    }
}

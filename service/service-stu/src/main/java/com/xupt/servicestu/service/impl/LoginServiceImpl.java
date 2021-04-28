package com.xupt.servicestu.service.impl;

import com.xupt.commonutils.MD5;
import com.xupt.servicestu.entity.Admin;
import com.xupt.servicestu.entity.Student;
import com.xupt.servicestu.entity.Teacher;
import com.xupt.servicestu.mapper.LoginMapper;
import com.xupt.servicestu.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginMapper loginMapper;

    @Override
    public Map<String,Object> adminLogin(String userId, String password) {
        password = MD5.encrypt(password);
        Admin admin = loginMapper.adminLogin(userId,password);
        if (admin != null){
            Map<String,Object> adminMap = new HashMap<>();
            adminMap.put("adminId", admin.getAdminId());
            adminMap.put("adminName", admin.getAdminName());
            adminMap.put("role", admin.getRole());
            return adminMap;
        }
        return null;
    }

    @Override
    public Map<String,Object> teacherLogin(String userId, String password) {
        password = MD5.encrypt(password);
        Teacher teacher = loginMapper.teacherLogin(userId,password);
        if (teacher != null) {
            Map<String,Object> teacherMap = new HashMap<>();
            teacherMap.put("teacherName", teacher.getTeacherName());
            teacherMap.put("teacherId", teacher.getTeacherId());
            teacherMap.put("classId", teacher.getClassId());
            teacherMap.put("role", teacher.getRole());
            return teacherMap;
        }
        return null;

    }

    @Override
    public Map<String,Object> studentLogin(String userId, String password) {
        password = MD5.encrypt(password);
        Student student = loginMapper.studentLogin(userId,password);
        if (student != null) {
            Map<String,Object> studentMap = new HashMap<>();
            studentMap.put("classId", student.getClassId());
            studentMap.put("studentId", student.getStudentId());
            studentMap.put("studentName", student.getName());
            studentMap.put("role", student.getRole());
            studentMap.put("teacherId", student.getTeacherId());
            return studentMap;
        }
        return null;

    }
}

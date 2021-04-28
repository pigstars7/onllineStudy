package com.xupt.servicestu.mapper;

import com.xupt.servicestu.entity.Admin;
import com.xupt.servicestu.entity.Student;
import com.xupt.servicestu.entity.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface LoginMapper {

    @Select("select * from admin where adminId = #{userId} and password = #{password}")
    public Admin adminLogin(String userId, String password);

    @Select("select * from teacher where teacherId = #{userId} and password = #{password}")
    public Teacher teacherLogin(String userId, String password);

    @Select("select * from student where student_id = #{userId} and password = #{password}")
    public Student studentLogin(String userId,String password);
}

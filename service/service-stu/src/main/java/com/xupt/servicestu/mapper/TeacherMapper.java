package com.xupt.servicestu.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xupt.servicestu.entity.Teacher;
import org.apache.ibatis.annotations.*;

/**
 * @author 朱星鑫
 * @create 2021-03-26 15:12
 */
@Mapper
public interface TeacherMapper {
    /**
     * 更新密码
     * @param teacher
     * @return 受影响的记录条数
     */
    @Update("update teacher set password = #{password} where teacherId = #{teacherId}")
    int updatePwd(Teacher teacher);

    /**
     * 分页查询所有教师
     * @param Teacher
     * @return
     */
    @Select("select stuclass.stu_class,teacher.class_id,teacher.teacherName, teacher.teacherId from " +
            "teacher INNER JOIN stuclass ON teacher.class_id = stuclass.id ")
    IPage<Teacher> getAllTeacher(Page<Teacher> Teacher);

    /**
     * 删除老师
     * @param teacherId
     * @return
     */
    @Delete("DELETE FROM teacher WHERE teacherId=#{teacherId}")
    int deleteTeacher(String teacherId);

    /**
     * 插入老师
     * @param teacher
     * @return
     */
    @Insert("INSERT INTO teacher(teacherId, class_id, teacherName, role, password) " +
            "VALUES (#{teacherId}, #{classId}, #{teacherName}, #{role}, #{password})")
    int insertTeacher(Teacher teacher);

    /**
     * 修改老师
     * @param teacher
     * @return
     */
    @Update("UPDATE teacher set class_id=#{classId}, teacherName=#{teacherName}, teacherId=#{teacherId} " +
            "WHERE teacherId = #{teacherId}")
    int changeTeacher(Teacher teacher);

    /**
     * 获取单个老师信息
     * @param teacherId
     * @return
     */
    @Select("select stuclass.stu_class,teacher.class_id,teacher.teacherName," +
            " teacher.teacherId from teacher INNER JOIN stuclass ON teacher.class_id = stuclass.id" +
            " where teacher.teacherId=#{teacherId}")
    Teacher getOneTeacher(String teacherId);

}

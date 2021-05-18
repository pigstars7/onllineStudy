package com.xupt.servicestu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xupt.servicestu.entity.Student;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zhuxingxin
 * @since 2021-03-07
 */
public interface StudentMapper extends BaseMapper<Student> {
    @Select("select stu_class from stuclass where id = #{classId}")
    String getClass(Integer classId);

    @Select("select teacherName from teacher where teacherId = #{teacherId}")
    String getTeacher(String teacherId);

    /**
     * 更新密码
     * @param student
     * @return 受影响的记录条数
     */
    @Update("update student set password = #{password} where student_id = #{studentId}")
    int updatePwd(Student student);

    /**
     * 根据教师id查询所属所有学生
     * @param Student
     * @param teacherId
     * @return
     */
    @Select("select stuclass.stu_class,student.class_id,student.student_id,student.name from student " +
            "INNER JOIN stuclass ON student.class_id = stuclass.id where student.teacher_id=#{teacherId}")
    IPage<Student> getAllStudent(Page<Student> Student, Integer teacherId);

    /**
     * 删除学生
     * @param studentId
     * @return
     */
    @Delete("DELETE FROM student WHERE student_id=#{studentId}")
    int deleteStudent(Integer studentId);

    /**
     * 新增学生
     * @param student
     * @return
     */
    @Insert("INSERT INTO student(class_id, student_id, teacher_id, name, role, password) " +
            "VALUES (#{classId}, #{studentId}, #{teacherId}, #{name}, #{role}, #{password})")
    int insertStudent(Student student);

    /**
     * 修改学生
     * @param student
     * @return
     */
    @Update("UPDATE student set class_id=#{classId}, student_id=#{studentId}, `name`=#{name} " +
            "WHERE student_id = #{studentId}")
    int changeStudent(Student student);

    /**
     * 获取单个学生信息
     * @param studentId
     * @return
     */
    @Select("select stuclass.stu_class,student.class_id,student.student_id,student.name from student " +
            "INNER JOIN stuclass ON student.class_id = stuclass.id where student.student_id=#{studentId}")
    Student getOneStudent(Integer studentId);



}

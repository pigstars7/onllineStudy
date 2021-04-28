package com.xupt.servicestu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xupt.servicestu.entity.Courses;
import com.xupt.servicestu.entity.vo.CourseVo;
import com.xupt.servicestu.entity.vo.newCourse;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zhuxingxin
 * @since 2021-03-07
 */
public interface CoursesMapper extends BaseMapper<Courses> {

    @Select("SELECT * FROM courses where id in (SELECT courses_id FROM curriculum WHERE class_id= #{classId})")
    IPage<Courses> findAllByPage(Page<Courses> page, Integer classId);

    @Select("SELECT * FROM courses where id in (SELECT courses_id FROM curriculum WHERE class_id= #{classId})")
    List<Courses> findAll(Integer classId);

    @Select("SELECT * FROM courses where id = #{courseId}")
    Courses getMsg(Integer courseId);

    @Update("UPDATE courses SET video = #{videoPath} WHERE id = #{courseId}")
    int insertVideo(Integer courseId, String videoPath);

    @Select("SELECT stuclass.stu_class,courses.id,courses.`name`,courses.details,courses.gradle,courses.`owner`," +
            "courses.synopsis,courses.video,courses.time,courses.address from stuclass " +
            "INNER JOIN curriculum ON stuclass.id = curriculum.class_id INNER JOIN courses " +
            "ON courses.id=curriculum.courses_id WHERE curriculum.teacher_id=#{teacherId}")
    IPage<CourseVo> findAllByTeacher(Page<CourseVo> page, Integer teacherId);

    @Delete("DELETE FROM courses WHERE id=#{courseId}")
    int deleteCourse(Integer courseId);

    @Select("SELECT stuclass.stu_class,courses.id,courses.`name`,courses.details,courses.gradle,courses.`owner`," +
            "courses.synopsis,courses.video,courses.time,courses.address from stuclass " +
            "INNER JOIN curriculum ON stuclass.id = curriculum.class_id INNER JOIN courses " +
            "ON courses.id=curriculum.courses_id WHERE curriculum.courses_id=#{courseId}")
    CourseVo findCourseVo(Integer courseId);

    @Update("UPDATE courses set courses.`name`=#{name},courses.details=#{details},courses.gradle=#{gradle}," +
            "courses.synopsis=#{synopsis},courses.time=#{time},courses.address=#{address} " +
            "WHERE courses.id=#{id}")
    int updateCourse(CourseVo courseVo);

    @Insert("INSERT INTO courses(id, synopsis, details, gradle, `name`, owner, time, video, address) " +
            "VALUES (#{id}, #{synopsis}, #{details}, #{gradle}, #{name}, #{owner}, #{time}, #{video}, #{address})")
    int insertCourse(newCourse newCourse);


}

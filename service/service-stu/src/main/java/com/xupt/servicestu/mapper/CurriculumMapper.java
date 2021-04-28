package com.xupt.servicestu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xupt.servicestu.entity.Curriculum;
import com.xupt.servicestu.entity.vo.newCourse;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zhuxingxin
 * @since 2021-03-07
 */
public interface CurriculumMapper extends BaseMapper<Curriculum> {
    @Delete("DELETE FROM curriculum WHERE courses_id=#{courseId}")
    int deleteByCoursesId(Integer courseId);

    @Update("UPDATE curriculum set curriculum.class_id=#{classId} WHERE curriculum.courses_id=#{courseId}")
    int updateClassId(Integer classId, Integer courseId);

    @Insert("INSERT INTO curriculum(class_id, courses_id, teacher_id) VALUES (#{classId}, #{id}, #{teacherId})")
    int insertNew(newCourse newCourse);
}

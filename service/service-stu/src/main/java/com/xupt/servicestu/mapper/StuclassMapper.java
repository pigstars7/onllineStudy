package com.xupt.servicestu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xupt.servicestu.entity.Stuclass;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zhuxingxin
 * @since 2021-03-07
 */
public interface StuclassMapper extends BaseMapper<Stuclass> {
    @Select("SELECT stuclass.id FROM stuclass WHERE stuclass.stu_class=#{className}")
    int getClassId(String className);

    @Select("SELECT * FROM stuclass")
    List<Stuclass> getAllClassName();

    @Select("SELECT * FROM stuclass")
    IPage<Stuclass> getAllClassName(IPage<Stuclass> page);

    @Insert("INSERT INTO stuclass (stuclass.id, stuclass.stu_class) VALUES (#{id}, #{stuClass})")
    int insertClazz(Stuclass stuclass);

    @Delete("DELETE FROM stuclass WHERE id=#{classId}")
    int deleteClazz(Integer classId);
}

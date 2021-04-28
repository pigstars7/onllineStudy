package com.xupt.servicestu.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xupt.servicestu.entity.Range;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author 朱星鑫
 * @create 2021-03-24 12:21
 */
@Mapper
public interface RangeMapper {
    @Select("SELECT * FROM `range` ")
    IPage<Range> findAllByPage(Page<Range> page);

    @Select("SELECT * FROM `range`")
    List<Range> findAll();

    @Delete("DELETE FROM `range` WHERE id=#{RangeId}")
    int deleteRange(Integer RangeId);

    @Insert("INSERT INTO `range`(id, rangeName, details, address, owner) " +
           "VALUES (#{id}, #{rangeName}, #{details}, #{address}, #{owner}) ")
    int insertRange(Range range);

    @Update("UPDATE `range` SET rangeName = #{rangeName}, address = #{address}, " +
            "details = #{details} WHERE id = #{id}")
    int changeRange(Range range);

    @Select("SELECT * FROM `range` where id=#{RangeId} ")
    Range getRangeOne(Integer RangeId);
}

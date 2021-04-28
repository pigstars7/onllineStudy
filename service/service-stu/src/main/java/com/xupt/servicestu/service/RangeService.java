package com.xupt.servicestu.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xupt.servicestu.entity.Range;

import java.util.List;

/**
 * @author 朱星鑫
 * @create 2021-03-24 12:22
 */
public interface RangeService  {
    //分页查询课程信息
    IPage<Range> findAllByPage(Page<Range> page);

    //查询所有课程信息
    List<Range> findAll();

    //添加靶场
    int addRange(Range range);

    //删除靶场
    int deleteRange(Integer RangeId);

    //修改文件
    int changeRange(Range range);

    //根据id查询当前Range所有信息
    Range getOneRange(Integer rangeId);
}

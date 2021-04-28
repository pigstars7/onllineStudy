package com.xupt.servicestu.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xupt.servicestu.entity.Range;
import com.xupt.servicestu.mapper.RangeMapper;
import com.xupt.servicestu.service.RangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 朱星鑫
 * @create 2021-03-24 12:22
 */
@Service
public class RangeServiceImpl implements RangeService {

    @Autowired
    private RangeMapper rangeMapper;

    @Override
    public IPage<Range> findAllByPage(Page<Range> page) {
        return rangeMapper.findAllByPage(page);
    }

    @Override
    public List<Range> findAll() {
        return rangeMapper.findAll();
    }

    @Override
    public int addRange(Range range) {
        return rangeMapper.insertRange(range);
    }

    @Override
    public int deleteRange(Integer RangeId) {
        return rangeMapper.deleteRange(RangeId);
    }

    @Override
    public int changeRange(Range range) {
        return rangeMapper.changeRange(range);
    }

    @Override
    public Range getOneRange(Integer rangeId) {
        return rangeMapper.getRangeOne(rangeId);
    }
}

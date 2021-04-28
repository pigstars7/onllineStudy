package com.xupt.servicestu.service.impl;

import com.xupt.servicestu.entity.Curriculum;
import com.xupt.servicestu.entity.vo.newCourse;
import com.xupt.servicestu.mapper.CurriculumMapper;
import com.xupt.servicestu.service.CurriculumService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhuxingxin
 * @since 2021-03-07
 */
@Service
public class CurriculumServiceImpl extends ServiceImpl<CurriculumMapper, Curriculum> implements CurriculumService {
    @Autowired
    private CurriculumMapper curriculumMapper;
    @Override
    public int deleteByCoursesId(Integer courseId) {
        return curriculumMapper.deleteByCoursesId(courseId);
    }

    @Override
    public int updateClassId(Integer classId, Integer courseId) {
        return curriculumMapper.updateClassId(classId,courseId);
    }

    @Override
    public int insertNew(newCourse newCourse) {
        return curriculumMapper.insertNew(newCourse);
    }
}

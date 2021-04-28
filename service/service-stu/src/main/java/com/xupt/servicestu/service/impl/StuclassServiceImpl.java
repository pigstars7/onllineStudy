package com.xupt.servicestu.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xupt.servicestu.entity.Stuclass;
import com.xupt.servicestu.mapper.StuclassMapper;
import com.xupt.servicestu.service.StuclassService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhuxingxin
 * @since 2021-03-07
 */
@Service
public class StuclassServiceImpl extends ServiceImpl<StuclassMapper, Stuclass> implements StuclassService {

    @Autowired
    private StuclassMapper stuclassMapper;
    @Override
    public int getClassId(String className) {
        return stuclassMapper.getClassId(className);
    }

    @Override
    public List<Stuclass> getAllClassName() {
        return stuclassMapper.getAllClassName();
    }

    @Override
    public IPage<Stuclass> getAllClassByPage(IPage<Stuclass> page) {
        return stuclassMapper.getAllClassName(page);
    }

    @Override
    public int insertClazz(Stuclass stuclass) {
        return stuclassMapper.insertClazz(stuclass);
    }

    @Override
    public int deleteClazz(Integer classId) {
        return stuclassMapper.deleteClazz(classId);
    }
}

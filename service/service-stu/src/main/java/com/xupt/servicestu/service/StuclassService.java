package com.xupt.servicestu.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xupt.servicestu.entity.Stuclass;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhuxingxin
 * @since 2021-03-07
 */
public interface StuclassService extends IService<Stuclass> {
    //通过className获取classId
    int getClassId(String className);

    //查询所有className
    List<Stuclass> getAllClassName();

    //查询所有className
    IPage<Stuclass> getAllClassByPage(IPage<Stuclass> page);

    //插入班级
    int insertClazz(Stuclass stuclass);

    //删除班级
    int deleteClazz(Integer classId);
}

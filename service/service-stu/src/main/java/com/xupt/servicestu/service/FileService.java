package com.xupt.servicestu.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xupt.servicestu.entity.fileManage;

import java.util.List;

/**
 * @author 朱星鑫
 * @create 2021-03-24 17:03
 */
public interface FileService {

    //通过classId获取本班级所有的资料
    List<fileManage> findAllByClassId(Integer classId);

    //获取所有的公共资料
    List<fileManage> findAll();

    //分页获取所有资料
    IPage<fileManage> getAllFile(Page<fileManage> page);

    //添加文件
    int addFile(fileManage fileManage);

    //删除文件
    int deleteFile(Integer fileId);

    //修改文件
    int changeFile(fileManage fileManage);

    //分页获取所有公共资料
    IPage<fileManage> getAllPublicFile(Page<fileManage> page);

    //获取单个file信息
    fileManage getOneFile(Integer fileId);

    //获取单个publicfile信息
    fileManage getOnePublicFile(Integer fileId);
}

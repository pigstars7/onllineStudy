package com.xupt.servicestu.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xupt.servicestu.entity.fileManage;
import com.xupt.servicestu.mapper.FileMapper;
import com.xupt.servicestu.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 朱星鑫
 * @create 2021-03-24 17:04
 */
@Service
public class FileServiceImpl implements FileService {

    @Autowired
    private FileMapper fileMapper;

    @Override
    public List<fileManage> findAllByClassId(Integer classId) {
        return fileMapper.findAllByClassId(classId);
    }

    @Override
    public List<fileManage> findAll() {
        return fileMapper.findAll();
    }

    @Override
    public IPage<fileManage> getAllFile(Page<fileManage> page) {
        return fileMapper.findAllByPage(page);
    }

    @Override
    public int addFile(fileManage fileManage) {
        return fileMapper.addFile(fileManage);
    }

    @Override
    public int deleteFile(Integer fileId) {
        return fileMapper.deleteFile(fileId);
    }

    @Override
    public int changeFile(fileManage fileManage) {
        return fileMapper.changeFile(fileManage);
    }

    @Override
    public IPage<fileManage> getAllPublicFile(Page<fileManage> page) {
        return fileMapper.findAllPublic(page);
    }

    @Override
    public fileManage getOneFile(Integer fileId) {
        return fileMapper.getOne(fileId);
    }

    @Override
    public fileManage getOnePublicFile(Integer fileId) {
        return fileMapper.getOnePublic(fileId);
    }
}

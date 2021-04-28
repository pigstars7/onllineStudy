package com.xupt.servicestu.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xupt.servicestu.entity.fileManage;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author 朱星鑫
 * @create 2021-03-24 17:01
 */
@Mapper
public interface FileMapper {
    @Select("SELECT * FROM filemanage WHERE classId = #{classId}")
    List<fileManage> findAllByClassId(Integer classId);

    @Select("SELECT stuclass.stu_class, filemanage.fileAddress, filemanage.classId, filemanage.fileId, " +
            "filemanage.fileName, filemanage.isPublic, filemanage.`owner` " +
            "FROM stuclass,filemanage WHERE filemanage.classId = stuclass.id")
    IPage<fileManage> findAllByPage(Page<fileManage> page);

    @Select("SELECT * FROM filemanage WHERE isPublic = 1")
    List<fileManage> findAll();

    @Insert("INSERT INTO filemanage(fileName, fileAddress, owner, isPublic, fileId, classId) " +
            "VALUES (#{fileName}, #{fileAddress}, #{owner}, #{isPublic}, #{fileId}, #{classId})")
    int addFile(fileManage fileManage);

    @Delete("DELETE FROM filemanage WHERE fileId=#{fileId}")
    int deleteFile(Integer fileId);

    @Update("UPDATE filemanage SET isPublic = #{isPublic}, fileName = #{fileName}," +
            "fileAddress = #{fileAddress},classId = #{classId} WHERE fileId = #{fileId}")
    int changeFile(fileManage fileManage);

    @Select("SELECT * FROM filemanage WHERE isPublic = 1")
    IPage<fileManage> findAllPublic(IPage<fileManage> page);

    @Select("SELECT stuclass.stu_class, filemanage.fileAddress, filemanage.classId, filemanage.fileId, " +
            "filemanage.fileName, filemanage.isPublic, filemanage.`owner`FROM " +
            "stuclass INNER JOIN filemanage ON stuclass.id = filemanage.classId WHERE filemanage.fileId=#{fileId}")
    fileManage getOne(Integer fileId);

    @Select("SELECT * FROM filemanage WHERE filemanage.fileId=#{fileId}")
    fileManage getOnePublic(Integer fileId);

}

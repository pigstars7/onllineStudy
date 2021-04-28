package com.xupt.servicestu.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xupt.commonutils.R;
import com.xupt.servicestu.entity.fileManage;
import com.xupt.servicestu.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author 朱星鑫
 * @create 2021-03-24 17:00
 */
@RestController
@RequestMapping("/file/")
public class FileController {

    @Autowired
    private FileService fileService;


    //获取当前班级所有文件信息
    @GetMapping("{classId}")
    public R getAllFilesByPage(@PathVariable("classId") Integer classId) {
        List<fileManage> files = fileService.findAllByClassId(classId);
        return R.ok().data("allFiles",files);
    }

    //分页获取所有文件信息
    @GetMapping("getPrivateFiles/{page}/{size}")
    public R getAllPrivateFileByPage(@PathVariable("page") Integer page, @PathVariable("size") Integer size) {
        Page<fileManage> files = new Page<>(page,size);
        IPage<fileManage> all = fileService.getAllFile(files);
        return R.ok().data("allFiles",all);
    }

    //获取所有公共文件信息
    @GetMapping("publicFile")
    public R getAllCourses() {
        return R.ok().data("allFiles", fileService.findAll());
    }

    //文件上传
    @PostMapping("upload")
    public R upVideo(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return R.error().message("上传失败，请选择文件");
        }
        String newFileName = file.getOriginalFilename();
        String filePath = "/onlinestudy/apache-tomcat-9.0.44/webapps/file/";
        File dest = new File(filePath + newFileName);
        try {
            file.transferTo(dest);
            String newFilePath = "http://49.235.85.77/file/" + newFileName;
            return R.ok().data("filePath", newFilePath);
        } catch (IOException e) {
            return R.error().message(e.getMessage());
        }
    }

    //文件新增
    @PutMapping("insertFile")
    public R insertFile(@RequestBody fileManage fileManage) {
        int fileID = (int)(Math.random()*899899)+1000+1;
        fileManage.setFileId(fileID);
        int res = fileService.addFile(fileManage);
        if (res == 1) {
            return R.ok().message("文件新增成功！");
        }
        return R.error().message("文件新增失败！");
    }

    @DeleteMapping("deleteFile/{fileId}")
    public R deleteFile(@PathVariable("fileId") Integer fileId) {
        int res = fileService.deleteFile(fileId);
        if (res != 0) {
            return R.ok().message("删除文件成功！");
        }
        return R.error().message("删除文件失败！");
    }

    @PutMapping("updateFileMS")
    public R updateFile(@RequestBody fileManage fileManage) {
        int res = fileService.changeFile(fileManage);
        if (res == 1) {
            return R.ok().message("文件信息更新成功！");
        }
        return R.error().message("文件信息更新失败！");
    }

    //分页获取所有公共文件信息
    @GetMapping("getPublicFiles/{page}/{size}")
    public R getAllFileByPage(@PathVariable("page") Integer page, @PathVariable("size") Integer size) {
        Page<fileManage> files = new Page<>(page,size);
        IPage<fileManage> all = fileService.getAllPublicFile(files);
        return R.ok().data("allPublicFiles",all);
    }

    @GetMapping("getOneFile/{fileId}")
    public R getOneFile(@PathVariable("fileId") Integer fileId) {
        return R.ok().data("fileMS", fileService.getOneFile(fileId));
    }

    @GetMapping("getOnePublicFile/{fileId}")
    public R getOnePublicFile(@PathVariable("fileId") Integer fileId) {
        return R.ok().data("fileMS", fileService.getOnePublicFile(fileId));
    }

//    public static void main(String[] args) {
//        System.out.println((int)(Math.random()*899899)+1000+1);
//    }
}

package com.xupt.servicestu.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xupt.commonutils.R;
import com.xupt.servicestu.entity.Courses;
import com.xupt.servicestu.entity.vo.CourseVo;
import com.xupt.servicestu.entity.vo.newCourse;
import com.xupt.servicestu.service.CurriculumService;
import com.xupt.servicestu.service.StuclassService;
import com.xupt.servicestu.service.impl.CoursesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhuxingxin
 * @since 2021-03-07
 */
@RestController
@RequestMapping("/courses/")
public class CoursesController {
    @Autowired
    private CoursesServiceImpl coursesService;

    @Autowired
    private CurriculumService curriculumService;

    @Autowired
    private StuclassService stuclassService;

    //分页获取所有课程信息
    @GetMapping("allCourses/{classId}/{page}/{size}")
    public R getAllCoursesByPage(@PathVariable("classId") Integer classId,
                           @PathVariable("page") Integer page, @PathVariable("size") Integer size) {
        Page<Courses> coursesPage = new Page<>(page,size);
        IPage<Courses> all = coursesService.findAllByPage(coursesPage, classId);
        return R.ok().data("allCourses",all);
    }

    //获取所有课程信息
    @GetMapping("{classId}")
    public R getAllCourses(@PathVariable("classId") Integer classId) {
        return R.ok().data("allCourses", coursesService.findAll(classId));
    }

    //上传课程视频
    @PostMapping("videoUp")
    public R upVideo(@RequestParam("video") MultipartFile video, @RequestParam("courseId") Integer courseId) {
        if (video.isEmpty()) {
            return R.error().message("上传失败，请选择文件");
        }

        long time = new Date().getTime();
        String newName = String.valueOf(time);
        String newFileName = "lesson" + newName.substring(newName.length() - 5) + ".mp4";
        String filePath = "/onlinestudy/apache-tomcat-9.0.44/webapps/lesson/";
        File dest = new File(filePath + newFileName);
        try {
            video.transferTo(dest);
            String videoPath = "http://49.235.85.77/lesson/" + newFileName;
            int result = coursesService.insertVideo(courseId, videoPath);
            if (result == 0) {
                return R.error().message("视频地址保存失败");
            }
            return R.ok().message("上传成功");
        } catch (IOException e) {
            return R.error().message(e.getMessage());
        }

    }

    //获取单个课程的所有信息
    @GetMapping("CourseMsg/{courseId}")
    public R getCourseMsg(@PathVariable("courseId") Integer courseId) {
        return R.ok().data("course", coursesService.getCourseMsg(courseId));
    }

    //根据老师id获取名下所有课程
    @GetMapping("coursesById/{teacherId}/{page}/{size}")
    public R getAllCoursesByTeacher(@PathVariable("teacherId") Integer teacherId,
                                 @PathVariable("page") Integer page, @PathVariable("size") Integer size) {
        Page<CourseVo> coursePage = new Page<>(page,size);
        IPage<CourseVo> all = coursesService.findAllByTeacher(coursePage, teacherId);
        return R.ok().data("allCourses",all);
    }

    //根据课程id删除相关信息
    @DeleteMapping("deleteCourse/{courseId}")
    public R deleteCourse(@PathVariable("courseId") Integer courseId) {
        int res2 = curriculumService.deleteByCoursesId(courseId);
        int res = coursesService.deleteCourse(courseId);

        if (res != 0 && res2 != 0) {
            return R.ok().message("删除课程成功！");
        }
        return R.error().message("删除失败");
    }

    //根据课程id查询
    @GetMapping("CourseVO/{courseId}")
    public R getCourseVO(@PathVariable("courseId") Integer courseId) {
        return R.ok().data("courseVo", coursesService.findCourseVo(courseId));
    }

    //更新课程信息
    @PutMapping("updateCourse")
    public R updateCourse(@RequestBody CourseVo courseVo) {
        String className = courseVo.getStuClass();
        int classId = stuclassService.getClassId(className);
        int courseId = courseVo.getId();
        int res = curriculumService.updateClassId(classId, courseId);
        int res2 = coursesService.updateCourse(courseVo);
        if (res != 1 && res2 != 1) {
            return R.error().message("课程信息更新失败！");
        }
        return R.ok().message("课程信息更新成功！");
    }

    //新增上传视频
    @PostMapping("newVideoUp")
    public R upVideo(@RequestParam("video") MultipartFile video) {
        if (video.isEmpty()) {
            return R.error().message("上传失败，请选择文件");
        }
        long time = new Date().getTime();
        String newName = String.valueOf(time);
        String newFileName = "lesson" + newName.substring(newName.length() - 5) + ".mp4";
        String filePath = "/onlinestudy/apache-tomcat-9.0.44/webapps/lesson/";
        File dest = new File(filePath + newFileName);
        try {
            video.transferTo(dest);
            String videoPath = "http://49.235.85.77/lesson/" + newFileName;
            return R.ok().data("videoPath", videoPath);
        } catch (IOException e) {
            return R.error().message(e.getMessage());
        }

    }

    @PutMapping("addNewCourse")
    public R addNewCourse(@RequestBody newCourse newCourse) {
        long time = new Date().getTime();
        int newId = (int)time/10;
        newCourse.setId(newId);
        int res = coursesService.inserNewCourse(newCourse);
        int res2 = curriculumService.insertNew(newCourse);
        if (res == 1 && res2 == 1) {
            return R.ok().message("课程添加成功！");
        }
        return R.error().message("课程添加失败！");
    }

//    public static void main(String[] args) {
//        long time = new Date().getTime();
//        int newt = (int)time/10;
//        System.out.println(newt);
//    }

}


package com.xupt.servicestu.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xupt.commonutils.MD5;
import com.xupt.commonutils.R;
import com.xupt.servicestu.entity.Teacher;
import com.xupt.servicestu.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhuxingxin
 * @since 2021-03-07
 */
@RestController
@CrossOrigin
@RequestMapping("/teacher/")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @PutMapping("changePwd")
    public R changePwd(@RequestBody Teacher teacher) {
        int res = teacherService.updatePwd(teacher);
        if (res != 0) {
            return R.ok().message("密码修改成功");
        }
        return R.error().message("密码修改失败");
    }

    //新增老师
    @PutMapping("insertTeacher")
    public R insertTeacher(@RequestBody Teacher teacher) {
        teacher.setRole(1);
        String pwd = MD5.encrypt(teacher.getPassword());
        teacher.setPassword(pwd);
        int res = teacherService.addTeacher(teacher);
        if (res == 1) {
            return R.ok().message("新增老师成功！");
        }
        return R.error().message("新增老师失败！");
    }

    //删除老师
    @DeleteMapping("deleteTeacher/{teacherId}")
    public R deleteTe(@PathVariable("teacherId") String teacherId) {
        int res = teacherService.deleteTeacher(teacherId);
        if (res != 0) {
            return R.ok().message("删除老师成功！");
        }
        return R.error().message("删除老师失败！");
    }

    //更新老师信息
    @PutMapping("updateTeacherMS")
    public R updateTeacher(@RequestBody Teacher teacher) {
        int res = teacherService.changeTeacherMS(teacher);
        if (res == 1) {
            return R.ok().message("老师信息更新成功！");
        }
        return R.error().message("老师信息更新失败！");
    }

    //获取当前老师信息
    @GetMapping("{page}/{size}")
    public R getAllTeacher(@PathVariable("page") Integer page, @PathVariable("size") Integer size) {
        Page<Teacher> coursesPage = new Page<>(page,size);
        IPage<Teacher> all = teacherService.getAllTeacher(coursesPage);
        return R.ok().data("allTeachers", all);
    }

    /**
     * 获取单个老师信息
     * @param teacherId
     * @return
     */
    @GetMapping("getOne/{teacherId}")
    public R getOneTeacher(@PathVariable("teacherId") String teacherId) {
        return R.ok().data("Teach", teacherService.getOneTeach(teacherId));
    }


}


package com.xupt.servicestu.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xupt.commonutils.MD5;
import com.xupt.commonutils.R;
import com.xupt.servicestu.entity.Student;
import com.xupt.servicestu.entity.vo.StuMessage;
import com.xupt.servicestu.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

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
@RequestMapping("/onlinestudy/student/")
public class StudentController {
    @Autowired
    private StudentService studentService;

    //获取学生个人相关信息
    @PostMapping("message")
    public R getStuMessage(@RequestBody StuMessage stuMessage) {
        Integer classId = stuMessage.getClassId();
        String teacherId = stuMessage.getTeacherId();
        String className = studentService.getClass(classId);
        String teacherName = studentService.getTeacher(teacherId);
        HashMap<String, Object> map = new HashMap<>();
        map.put("className", className);
        map.put("teacherName", teacherName);
        return R.ok().data("stuMessage",map);
    }

    @PutMapping("changePwd")
    public R changePwd(@RequestBody Student student) {
        int res = studentService.updatePwd(student);
        if (res != 0) {
            return R.ok().message("密码修改成功");
        }
        return R.error().message("密码修改失败");
    }

    //新增学生
    @PutMapping("insertStudent")
    public R insertStu(@RequestBody Student student) {
        student.setRole(2);
        String pwd = MD5.encrypt(student.getPassword());
        student.setPassword(pwd);
        int res = studentService.addStudent(student);
        if (res == 1) {
            return R.ok().message("新增学生成功！");
        }
        return R.error().message("新增学生失败！");
    }

    //删除学生
    @DeleteMapping("deleteStudent/{studentId}")
    public R deleteStu(@PathVariable("studentId") Integer studentId) {
        int res = studentService.deleteStudent(studentId);
        if (res != 0) {
            return R.ok().message("删除学生成功！");
        }
        return R.error().message("删除学生失败！");
    }

    //更新学生信息
    @PutMapping("updateStudentMS")
    public R updateStudent(@RequestBody Student student) {
        int res = studentService.changeStudentMS(student);
        if (res == 1) {
            return R.ok().message("学生信息更新成功！");
        }
        return R.error().message("学生信息更新失败！");
    }

    //获取当前老师所有学生信息
    @GetMapping("{teacherId}/{page}/{size}")
    public R getAllStudent(@PathVariable("page") Integer page, @PathVariable("size") Integer size,
                           @PathVariable("teacherId") Integer teacherId) {
        Page<Student> coursesPage = new Page<>(page,size);
        IPage<Student> all = studentService.getAllStudent(coursesPage, teacherId);
        return R.ok().data("allStudents", all);
    }

    /**
     * 获取单个学生信息
     * @param studentId
     * @return
     */
    @GetMapping("getOne/{studentId}")
    public R getOneStu(@PathVariable("studentId") Integer studentId) {
        return R.ok().data("stu", studentService.getOneStu(studentId));
    }


}


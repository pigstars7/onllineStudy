package com.xupt.servicestu.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xupt.commonutils.R;
import com.xupt.servicestu.entity.Stuclass;
import com.xupt.servicestu.service.StuclassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhuxingxin
 * @since 2021-03-07
 */
@RestController
@RequestMapping("/stuclass")
public class StuclassController {
    @Autowired
    private StuclassService stuclassService;

    @GetMapping("/getClassName")
    public R getAllClassName() {
        List<Stuclass> className = stuclassService.getAllClassName();
        return R.ok().data("className", className);
    }

    @GetMapping("/{page}/{size}")
    public R getAllClassByPage(@PathVariable("page") Integer page, @PathVariable("size") Integer size) {
        Page<Stuclass> coursesPage = new Page<>(page,size);
        IPage<Stuclass> all = stuclassService.getAllClassByPage(coursesPage);
        return R.ok().data("allClass", all);
    }

    @PutMapping("/insertClazz")
    public R insertClazz(@RequestBody Stuclass stuclass) {
        int res = stuclassService.insertClazz(stuclass);
        if (res == 1) {
            return R.ok().message("新增班级成功！");
        }
        return R.error().message("新增班级失败！");
    }

    @DeleteMapping("/deleteClazz/{classId}")
    public R deleteClazz(@PathVariable("classId") Integer classId) {
        int res = stuclassService.deleteClazz(classId);
        if (res != 0) {
            return R.ok().message("删除班级成功！");
        }
        return R.error().message("删除班级失败！");
    }


}


package com.xupt.servicestu.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xupt.commonutils.R;
import com.xupt.servicestu.entity.Range;
import com.xupt.servicestu.service.RangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 朱星鑫
 * @create 2021-03-24 12:18
 */
@RestController
@RequestMapping("/range/")
public class RangeController {

    @Autowired
    private RangeService rangeService;


    //分页获取所有综合实验信息
    @GetMapping("allRange/{page}/{size}")
    public R getAllCoursesByPage(@PathVariable("page") Integer page, @PathVariable("size") Integer size) {
        Page<Range> RangePage = new Page<>(page,size);
        IPage<Range> all = rangeService.findAllByPage(RangePage);
        return R.ok().data("allRange",all);
    }

    //获取所有综合实验信息
    @GetMapping("all")
    public R getAllCourses() {
        return R.ok().data("allRange", rangeService.findAll());
    }

    //靶场新增
    @PutMapping("insertRange")
    public R insertFile(@RequestBody Range range) {
        int rangeID = (int)(Math.random()*899899)+1000+1;
        range.setId(rangeID);
        int res = rangeService.addRange(range);
        if (res == 1) {
            return R.ok().message("综合实验新增成功！");
        }
        return R.error().message("综合实验新增失败！");
    }

    //删除靶场
    @DeleteMapping("deleteRange/{rangeId}")
    public R deleteFile(@PathVariable("rangeId") Integer rangeId) {
        int res = rangeService.deleteRange(rangeId);
        if (res != 0) {
            return R.ok().message("删除综合实验成功！");
        }
        return R.error().message("删除综合实验失败！");
    }

    //更新靶场信息
    @PutMapping("updateRangeMS")
    public R updateFile(@RequestBody Range range) {
        int res = rangeService.changeRange(range);
        if (res == 1) {
            return R.ok().message("综合实验信息更新成功！");
        }
        return R.error().message("综合实验信息更新失败！");
    }

    @GetMapping("getOneRange/{rangeId}")
    public R getOne(@PathVariable("rangeId") Integer rangeId) {
        Range range = rangeService.getOneRange(rangeId);
        return R.ok().data("range", range);
    }
}

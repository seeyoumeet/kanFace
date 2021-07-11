package com.seeyoumeet.controller;

import java.util.List;
import java.util.Map;

import com.seeyoumeet.utils.ShiroUtils;
import com.seeyoumeet.entity.CourseDetailEntity;
import com.seeyoumeet.service.CourseDetailService;
import com.seeyoumeet.utils.PageUtils;
import com.seeyoumeet.utils.Query;
import com.seeyoumeet.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * 课程信息
 */
@RestController
@RequestMapping("CourseDetail")
public class CourseDetailController extends AbstractController {
    @Autowired
    private CourseDetailService courseDetailService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params) {


        //查询列表数据
        Query query = new Query(params);

        List<CourseDetailEntity> CourseDetailList = courseDetailService.queryList(query);
        int total = courseDetailService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(CourseDetailList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }

    /**
     * 列表
     */
    @RequestMapping("/list2")
    public R list2(@RequestParam Map<String, Object> params) {
        Query query = new Query(params);
        List<CourseDetailEntity> CourseDetailList = courseDetailService.queryList(query);
        return R.ok().put("list", CourseDetailList);
    }

    /**
     * 查询我的课程
     */
    @RequestMapping("/listMyKc")
    public R listMyKc(@RequestParam Map<String, Object> params) {
        Query query = new Query(params);
        query.put("sysUser", ShiroUtils.getUserEntity().getUserId());
        List<CourseDetailEntity> CourseDetailList = courseDetailService.queryList(query);
        return R.ok().put("list", CourseDetailList);
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id) {
        CourseDetailEntity CourseDetail = courseDetailService.queryObject(id);

        return R.ok().put("CourseDetail", CourseDetail);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody CourseDetailEntity CourseDetail) {
        CourseDetail.setSysUser(ShiroUtils.getUserEntity().getUserId());
        courseDetailService.save(CourseDetail);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody CourseDetailEntity CourseDetail) {
        courseDetailService.update(CourseDetail);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids) {
        courseDetailService.deleteBatch(ids);

        return R.ok();
    }

}

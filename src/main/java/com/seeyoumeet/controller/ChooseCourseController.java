package com.seeyoumeet.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.seeyoumeet.utils.ShiroUtils;
import com.seeyoumeet.entity.ChooseCourseEntity;
import com.seeyoumeet.service.ChooseCourseService;
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
 * 选择课程
 */
@RestController
@RequestMapping("ChooseCourse")
public class ChooseCourseController extends AbstractController {
    @Autowired
    private ChooseCourseService chooseCourseService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params) {

        //查询列表数据
        Query query = new Query(params);

        List<ChooseCourseEntity> ChooseCourseList = chooseCourseService.queryList(query);
        int total = chooseCourseService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(ChooseCourseList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }

    /**
     * 列表
     */
    @RequestMapping("/list2")
    public R list2(@RequestParam Map<String, Object> params) {
        Query query = new Query(params);
        List<ChooseCourseEntity> ChooseCourseList = chooseCourseService.queryList(query);
        return R.ok().put("list", ChooseCourseList);
    }

    /**
     * 根据课程id 查询 报名学生
     */
    @RequestMapping("/listStudentByKcId")
    public R listStudentByKcId(ChooseCourseEntity chooseCourseEntity) {
        Query query = new Query(new HashMap<String, Object>());
        query.put("CourseDetail", chooseCourseEntity.getCourseDetail());
        List<ChooseCourseEntity> ChooseCourseList = chooseCourseService.queryList(query);
        return R.ok().put("list", ChooseCourseList);
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id) {
        ChooseCourseEntity ChooseCourse = chooseCourseService.queryObject(id);

        return R.ok().put("ChooseCourse", ChooseCourse);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ChooseCourseEntity ChooseCourse) {
        Map<String, Object> query = new HashMap<>();
        query.put("CourseDetail", ChooseCourse.getCourseDetail());
        query.put("sysUser", ShiroUtils.getUserEntity().getUserId());

        List<ChooseCourseEntity> ChooseCourseEntities = chooseCourseService.queryList(query);
        if (ChooseCourseEntities.size() > 0) {
            return R.error("你已选择了该课程");
        }

        ChooseCourse.setSysUser(ShiroUtils.getUserEntity().getUserId());
        chooseCourseService.save(ChooseCourse);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody ChooseCourseEntity ChooseCourse) {
        chooseCourseService.update(ChooseCourse);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids) {
        chooseCourseService.deleteBatch(ids);

        return R.ok();
    }
}

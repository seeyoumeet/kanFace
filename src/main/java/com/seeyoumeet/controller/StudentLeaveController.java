package com.seeyoumeet.controller;

import java.util.List;
import java.util.Map;

import com.seeyoumeet.utils.*;
import com.seeyoumeet.entity.StudentLeaveEntity;
import com.seeyoumeet.service.StudentLeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 学生请假
 *
 * @date 2020-03-07 08:02:00
 */
@RestController
@RequestMapping("StudentLeave")
public class StudentLeaveController extends AbstractController {
    @Autowired
    private StudentLeaveService studentLeaveService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params) {

        //查询列表数据
        Query query = new Query(params);

        List<StudentLeaveEntity> StudentLeaveList = studentLeaveService.queryList(query);
        int total = studentLeaveService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(StudentLeaveList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }

    /**
     * 列表
     */
    @RequestMapping("/list2")
    public R list2(@RequestParam Map<String, Object> params) {
        Query query = new Query(params);
        List<StudentLeaveEntity> StudentLeaveList = studentLeaveService.queryList(query);
        return R.ok().put("list", StudentLeaveList);
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id) {
        StudentLeaveEntity StudentLeave = studentLeaveService.queryObject(id);

        return R.ok().put("StudentLeave", StudentLeave);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody StudentLeaveEntity StudentLeave) {
        StudentLeave.setSysUser(ShiroUtils.getUserEntity().getUserId());
        StudentLeave.setDays(Integer.parseInt(DateUtils.getDatePoor(StudentLeave.getEndTime(), StudentLeave.getBeginTime()).get("day").toString()));
        StudentLeave.setTeacherApprove(0);
        StudentLeave.setAdminApprove(0);
        studentLeaveService.save(StudentLeave);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody StudentLeaveEntity StudentLeave) {
        studentLeaveService.update(StudentLeave);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids) {
        studentLeaveService.deleteBatch(ids);

        return R.ok();
    }

}

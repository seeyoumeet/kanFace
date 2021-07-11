package com.seeyoumeet.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.seeyoumeet.dao.ChooseCourseDao;
import com.seeyoumeet.entity.ChooseCourseEntity;
import com.seeyoumeet.service.CourseDetailService;
import com.seeyoumeet.service.SysUserService;
import com.seeyoumeet.service.ChooseCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("ChooseCourseService")
public class ChooseCourseServiceImpl implements ChooseCourseService {
    @Autowired
    private ChooseCourseDao chooseCourseDao;


    @Autowired
    private CourseDetailService courseDetailService;


    @Autowired
    private SysUserService sysUserService;


    @Override
    public ChooseCourseEntity queryObject(Long id) {
        ChooseCourseEntity entity = chooseCourseDao.queryObject(id);


        if (entity.getCourseDetail() != null && this.courseDetailService.queryObject(entity.getCourseDetail()) != null)
            entity.setCourseDetailEntity(this.courseDetailService.queryObject(entity.getCourseDetail()));


        if (entity.getSysUser() != null && this.sysUserService.queryObject(entity.getSysUser()) != null)
            entity.setSysUserEntity(this.sysUserService.queryObject(entity.getSysUser()));


        return entity;
    }

    @Override
    public List<ChooseCourseEntity> queryList(Map<String, Object> map) {
        List<ChooseCourseEntity> list = chooseCourseDao.queryList(map);
        for (ChooseCourseEntity entity : list) {

            if (entity.getCourseDetail() != null && this.courseDetailService.queryObject(entity.getCourseDetail()) != null)
                entity.setCourseDetailEntity(this.courseDetailService.queryObject(entity.getCourseDetail()));


            if (entity.getSysUser() != null && this.sysUserService.queryObject(entity.getSysUser()) != null)
                entity.setSysUserEntity(this.sysUserService.queryObject(entity.getSysUser()));

        }
        try {
            String s = JSONObject.toJSONString(list);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return chooseCourseDao.queryTotal(map);
    }

    @Override
    public void save(ChooseCourseEntity ChooseCourse) {
        chooseCourseDao.save(ChooseCourse);
    }

    @Override
    public void update(ChooseCourseEntity ChooseCourse) {
        chooseCourseDao.update(ChooseCourse);
    }

    @Override
    public void delete(Long id) {
        chooseCourseDao.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
        chooseCourseDao.deleteBatch(ids);
    }

}

package com.seeyoumeet.service.impl;

import com.seeyoumeet.dao.CourseDetailDao;
import com.seeyoumeet.entity.CourseDetailEntity;
import com.seeyoumeet.service.CourseDetailService;
import com.seeyoumeet.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("CourseDetailService")
public class CourseDetailServiceImpl implements CourseDetailService {
    @Autowired
    private CourseDetailDao courseDetailDao;
    @Autowired
    private SysUserService sysUserService;

    @Override
    public CourseDetailEntity queryObject(Long id) {
        CourseDetailEntity entity = courseDetailDao.queryObject(id);

        if (entity.getSysUser() != null && this.sysUserService.queryObject(entity.getSysUser()) != null)
            entity.setSysUserEntity(this.sysUserService.queryObject(entity.getSysUser()));

        return entity;
    }

    @Override
    public List<CourseDetailEntity> queryList(Map<String, Object> map) {
        List<CourseDetailEntity> list = courseDetailDao.queryList(map);
        for (CourseDetailEntity entity : list) {
            if (entity.getSysUser() != null && this.sysUserService.queryObject(entity.getSysUser()) != null)
                entity.setSysUserEntity(this.sysUserService.queryObject(entity.getSysUser()));

        }
        return list;
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return courseDetailDao.queryTotal(map);
    }

    @Override
    public void save(CourseDetailEntity CourseDetail) {
        courseDetailDao.save(CourseDetail);
    }

    @Override
    public void update(CourseDetailEntity CourseDetail) {
        courseDetailDao.update(CourseDetail);
    }

    @Override
    public void delete(Long id) {
        courseDetailDao.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
        courseDetailDao.deleteBatch(ids);
    }

}

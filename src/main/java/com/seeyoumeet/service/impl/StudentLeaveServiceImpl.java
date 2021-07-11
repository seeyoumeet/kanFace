package com.seeyoumeet.service.impl;

import com.seeyoumeet.dao.StudentLeaveDao;
import com.seeyoumeet.entity.StudentLeaveEntity;
import com.seeyoumeet.service.SysUserService;
import com.seeyoumeet.service.StudentLeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("StudentLeaveService")
public class StudentLeaveServiceImpl implements StudentLeaveService {
    @Autowired
    private StudentLeaveDao studentLeaveDao;


    @Autowired
    private SysUserService sysUserService;


    @Override
    public StudentLeaveEntity queryObject(Long id) {
        StudentLeaveEntity entity = studentLeaveDao.queryObject(id);


        if (entity.getSysUser() != null && this.sysUserService.queryObject(entity.getSysUser()) != null)
            entity.setSysUserEntity(this.sysUserService.queryObject(entity.getSysUser()));


        return entity;
    }

    @Override
    public List<StudentLeaveEntity> queryList(Map<String, Object> map) {
        List<StudentLeaveEntity> list = studentLeaveDao.queryList(map);
        for (StudentLeaveEntity entity : list) {

            if (entity.getSysUser() != null && this.sysUserService.queryObject(entity.getSysUser()) != null)
                entity.setSysUserEntity(this.sysUserService.queryObject(entity.getSysUser()));

        }
        return list;
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return studentLeaveDao.queryTotal(map);
    }

    @Override
    public void save(StudentLeaveEntity StudentLeave) {
        studentLeaveDao.save(StudentLeave);
    }

    @Override
    public void update(StudentLeaveEntity StudentLeave) {
        studentLeaveDao.update(StudentLeave);
    }

    @Override
    public void delete(Long id) {
        studentLeaveDao.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
        studentLeaveDao.deleteBatch(ids);
    }

}

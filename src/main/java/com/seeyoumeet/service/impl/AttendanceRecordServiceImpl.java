package com.seeyoumeet.service.impl;

import com.seeyoumeet.entity.SysUserEntity;
import com.seeyoumeet.dao.AttendanceRecordDao;
import com.seeyoumeet.service.CourseDetailService;
import com.seeyoumeet.service.AttendanceRecordService;
import com.seeyoumeet.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;


import com.seeyoumeet.entity.AttendanceRecordEntity;


@Service("AttendanceRecordService")
public class AttendanceRecordServiceImpl implements AttendanceRecordService {
    @Autowired
    private AttendanceRecordDao attendanceRecordDao;

    @Autowired
    private CourseDetailService courseDetailService;

    @Autowired
    private SysUserService sysUserService;

    @Override
    public int conutTj() {
        return attendanceRecordDao.conutTj();
    }

    @Override
    public List<Map<String, Object>> tj() {
        List<Map<String, Object>> tj = attendanceRecordDao.tj();
        for (Map<String, Object> map : tj) {
            SysUserEntity bkhxs = sysUserService.queryObject(Long.parseLong(map.get("bkhxs").toString()));
            map.put("username", bkhxs.getUsername());
            Double counutsum = Double.valueOf(map.get("counutsum").toString());
            Double skzk = Double.valueOf(map.get("skzk").toString());
            Double skcd = Double.valueOf(map.get("skcd").toString());
            Double xkzc = Double.valueOf(map.get("xkzc").toString());
            Double xkcd = Double.valueOf(map.get("xkcd").toString());
            map.put("counutsum", counutsum);
            map.put("skzk", new BigDecimal((double) skzk / counutsum).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue() * 100 + "%");
            map.put("skcd", new BigDecimal((double) skcd / counutsum).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue() * 100 + "%");
            map.put("xkzc", new BigDecimal((double) xkzc / counutsum).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue() * 100 + "%");
            map.put("xkcd", new BigDecimal((double) xkcd / counutsum).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue() * 100 + "%");

        }
        return tj;
    }

    @Override
    public AttendanceRecordEntity queryObject(Long id) {
        AttendanceRecordEntity entity = attendanceRecordDao.queryObject(id);

        if (entity.getCourseDetail() != null && this.courseDetailService.queryObject(entity.getCourseDetail()) != null)
            entity.setCourseDetailEntity(this.courseDetailService.queryObject(entity.getCourseDetail()));

        return entity;
    }

    @Override
    public List<AttendanceRecordEntity> queryList(Map<String, Object> map) {
        List<AttendanceRecordEntity> list = attendanceRecordDao.queryList(map);
        for (AttendanceRecordEntity entity : list) {
            if (entity.getCourseDetail() != null && this.courseDetailService.queryObject(entity.getCourseDetail()) != null)
                entity.setCourseDetailEntity(this.courseDetailService.queryObject(entity.getCourseDetail()));
            entity.setStudentEntity(sysUserService.queryObject((long) entity.getStudent()));
            entity.setTeacherEntity(sysUserService.queryObject((long) entity.getTeacher()));
        }
        return list;
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return attendanceRecordDao.queryTotal(map);
    }

    @Override
    public void save(AttendanceRecordEntity AttendanceRecord) {
        attendanceRecordDao.save(AttendanceRecord);
    }

    @Override
    public void update(AttendanceRecordEntity AttendanceRecord) {
        attendanceRecordDao.update(AttendanceRecord);
    }

    @Override
    public void delete(Long id) {
        attendanceRecordDao.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
        attendanceRecordDao.deleteBatch(ids);
    }
}

package com.seeyoumeet.dao;

import com.seeyoumeet.entity.AttendanceRecordEntity;

import java.util.List;
import java.util.Map;

/**
 * 考勤记录
 */
public interface AttendanceRecordDao extends BaseDao<AttendanceRecordEntity> {
    List<Map<String, Object>> tj();

    int conutTj();
}

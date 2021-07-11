package com.seeyoumeet.service;

import com.seeyoumeet.entity.AttendanceRecordEntity;

import java.util.List;
import java.util.Map;

/**
 * 考勤记录
 * 
 
 * 
 */
public interface AttendanceRecordService {
	int conutTj();
	List<Map<String, Object>> tj();
    /**
    * 查询
	* @return
	*/
	AttendanceRecordEntity queryObject(Long id);

    /**
    * 查询列表
    * @return
    */
	List<AttendanceRecordEntity> queryList(Map<String, Object> map);

    /**
    * 查询总数
    * @return
    */
	int queryTotal(Map<String, Object> map);

    /**
    * 保存
    * @return
    */
	void save(AttendanceRecordEntity AttendanceRecord);

    /**
    * 修改
    * @return
    */
	void update(AttendanceRecordEntity AttendanceRecord);

    /**
    * 删除
    * @return
    */
	void delete(Long id);

    /**
    * 批量删除
    * @return
    */
	void deleteBatch(Long[] ids);
}

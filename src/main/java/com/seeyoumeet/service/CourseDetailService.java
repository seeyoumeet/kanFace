package com.seeyoumeet.service;

import com.seeyoumeet.entity.CourseDetailEntity;

import java.util.List;
import java.util.Map;

/**
 * 课程信息
 *
 * 
 */
public interface CourseDetailService {
    /**
    * 查询
	* @return
	*/
	CourseDetailEntity queryObject(Long id);

    /**
    * 查询列表
    * @return
    */
	List<CourseDetailEntity> queryList(Map<String, Object> map);

    /**
    * 查询总数
    * @return
    */
	int queryTotal(Map<String, Object> map);

    /**
    * 保存
    * @return
    */
	void save(CourseDetailEntity CourseDetail);

    /**
    * 修改
    * @return
    */
	void update(CourseDetailEntity CourseDetail);

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

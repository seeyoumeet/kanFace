package com.seeyoumeet.service;

import com.seeyoumeet.entity.ChooseCourseEntity;

import java.util.List;
import java.util.Map;

/**
 * 选择课程
 * 
 
 * 
 */
public interface ChooseCourseService {
    /**
    * 查询
	* @return
	*/
	ChooseCourseEntity queryObject(Long id);

    /**
    * 查询列表
    * @return
    */
	List<ChooseCourseEntity> queryList(Map<String, Object> map);

    /**
    * 查询总数
    * @return
    */
	int queryTotal(Map<String, Object> map);

    /**
    * 保存
    * @return
    */
	void save(ChooseCourseEntity ChooseCourse);

    /**
    * 修改
    * @return
    */
	void update(ChooseCourseEntity ChooseCourse);

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

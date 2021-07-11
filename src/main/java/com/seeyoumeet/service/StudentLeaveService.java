package com.seeyoumeet.service;

import com.seeyoumeet.entity.StudentLeaveEntity;

import java.util.List;
import java.util.Map;

/**
 * 学生请假
 * 
 *
 *
 * @date 2020-03-07 08:02:00
 */
public interface StudentLeaveService {
    /**
    * 查询
	* @return
	*/
	StudentLeaveEntity queryObject(Long id);

    /**
    * 查询列表
    * @return
    */
	List<StudentLeaveEntity> queryList(Map<String, Object> map);

    /**
    * 查询总数
    * @return
    */
	int queryTotal(Map<String, Object> map);

    /**
    * 保存
    * @return
    */
	void save(StudentLeaveEntity StudentLeave);

    /**
    * 修改
    * @return
    */
	void update(StudentLeaveEntity StudentLeave);

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

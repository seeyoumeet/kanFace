package com.seeyoumeet.service;

import com.seeyoumeet.entity.SysArgsEntity;

import java.util.List;
import java.util.Map;

/**
 * 系统参数管理
 * 
 *
 *
 *
 */
public interface SysArgsService {
    /**
    * 查询
	* @return
	*/
	SysArgsEntity queryObject(Long id);

    /**
    * 查询列表
    * @return
    */
	List<SysArgsEntity> queryList(Map<String, Object> map);

    /**
    * 查询总数
    * @return
    */
	int queryTotal(Map<String, Object> map);

    /**
    * 保存
    * @return
    */
	void save(SysArgsEntity SysArgs);

    /**
    * 修改
    * @return
    */
	void update(SysArgsEntity SysArgs);

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

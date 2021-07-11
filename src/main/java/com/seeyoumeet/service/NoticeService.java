package com.seeyoumeet.service;

import com.seeyoumeet.entity.NoticeEntity;

import java.util.List;
import java.util.Map;

/**
 * 通知公告
 * 
 *
 *
 *
 */
public interface NoticeService {
    /**
    * 查询
	* @return
	*/
	NoticeEntity queryObject(Long id);

    /**
    * 查询列表
    * @return
    */
	List<NoticeEntity> queryList(Map<String, Object> map);

    /**
    * 查询总数
    * @return
    */
	int queryTotal(Map<String, Object> map);

    /**
    * 保存
    * @return
    */
	void save(NoticeEntity Notice);

    /**
    * 修改
    * @return
    */
	void update(NoticeEntity Notice);

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

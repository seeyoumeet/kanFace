package com.seeyoumeet.service;

import com.seeyoumeet.entity.SMSRecordEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 *
 */
public interface SMSRecordService {
    /**
    * 查询
	* @return
	*/
	SMSRecordEntity queryObject(Long id);

    /**
    * 查询列表
    * @return
    */
	List<SMSRecordEntity> queryList(Map<String, Object> map);

    /**
    * 查询总数
    * @return
    */
	int queryTotal(Map<String, Object> map);

    /**
    * 保存
    * @return
    */
	void save(SMSRecordEntity SMSRecord);

    /**
    * 修改
    * @return
    */
	void update(SMSRecordEntity SMSRecord);

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
	List<SMSRecordEntity> selectByPhoneAndCreateTime(String phone, String time);
}

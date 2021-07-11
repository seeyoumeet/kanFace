package com.seeyoumeet.dao;

import com.seeyoumeet.entity.SMSRecordEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *
 *
 *
 */
public interface SMSRecordDao extends BaseDao<SMSRecordEntity> {
    List<SMSRecordEntity> selectByPhoneAndCreateTime(@Param("phone") String phone, @Param("time") String time);
}

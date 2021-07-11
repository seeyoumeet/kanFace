package com.seeyoumeet.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


import com.seeyoumeet.dao.SMSRecordDao;
import com.seeyoumeet.entity.SMSRecordEntity;
import com.seeyoumeet.service.SMSRecordService;


@Service("SMSRecordService")
public class SMSRecordServiceImpl implements SMSRecordService {
    @Autowired
    private SMSRecordDao SMSRecordDao;

    @Override
    public SMSRecordEntity queryObject(Long id) {
        SMSRecordEntity entity = SMSRecordDao.queryObject(id);

        return entity;
    }

    @Override
    public List<SMSRecordEntity> queryList(Map<String, Object> map) {
        List<SMSRecordEntity> list = SMSRecordDao.queryList(map);
        for (SMSRecordEntity entity : list) {
        }
        return list;
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return SMSRecordDao.queryTotal(map);
    }

    @Override
    public void save(SMSRecordEntity SMSRecord) {
        SMSRecordDao.save(SMSRecord);
    }

    @Override
    public void update(SMSRecordEntity SMSRecord) {
        SMSRecordDao.update(SMSRecord);
    }

    @Override
    public void delete(Long id) {
        SMSRecordDao.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
        SMSRecordDao.deleteBatch(ids);
    }

    @Override
    public List<SMSRecordEntity> selectByPhoneAndCreateTime(String phone, String time) {
        return SMSRecordDao.selectByPhoneAndCreateTime(phone, time);
    }

}

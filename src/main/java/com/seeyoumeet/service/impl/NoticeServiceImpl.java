package com.seeyoumeet.service.impl;

import com.seeyoumeet.dao.NoticeDao;
import com.seeyoumeet.entity.NoticeEntity;
import com.seeyoumeet.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("NoticeService")
public class NoticeServiceImpl implements NoticeService {
	@Autowired
	private NoticeDao noticeDao;

			

			

			

			

	

	
	@Override
	public NoticeEntity queryObject(Long id){
			NoticeEntity entity = noticeDao.queryObject(id);

													
		return entity;
	}
	
	@Override
	public List<NoticeEntity> queryList(Map<String, Object> map){
        List<NoticeEntity> list = noticeDao.queryList(map);
        for(NoticeEntity entity : list){
																																	}
		return list;
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return noticeDao.queryTotal(map);
	}
	
	@Override
	public void save(NoticeEntity Notice){
		noticeDao.save(Notice);
	}
	
	@Override
	public void update(NoticeEntity Notice){
		noticeDao.update(Notice);
	}
	
	@Override
	public void delete(Long id){
		noticeDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		noticeDao.deleteBatch(ids);
	}
	
}

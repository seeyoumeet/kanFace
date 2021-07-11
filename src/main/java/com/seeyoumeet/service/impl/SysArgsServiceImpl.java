package com.seeyoumeet.service.impl;

import com.seeyoumeet.dao.SysArgsDao;
import com.seeyoumeet.entity.SysArgsEntity;
import com.seeyoumeet.service.SysArgsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("SysArgsService")
public class SysArgsServiceImpl implements SysArgsService {
	@Autowired
	private SysArgsDao sysArgsDao;

			

			

			

			

	

	
	@Override
	public SysArgsEntity queryObject(Long id){
			SysArgsEntity entity = sysArgsDao.queryObject(id);

													
		return entity;
	}
	
	@Override
	public List<SysArgsEntity> queryList(Map<String, Object> map){
        List<SysArgsEntity> list = sysArgsDao.queryList(map);
        for(SysArgsEntity entity : list){
																																	}
		return list;
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return sysArgsDao.queryTotal(map);
	}
	
	@Override
	public void save(SysArgsEntity SysArgs){
		sysArgsDao.save(SysArgs);
	}
	
	@Override
	public void update(SysArgsEntity SysArgs){
		sysArgsDao.update(SysArgs);
	}
	
	@Override
	public void delete(Long id){
		sysArgsDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		sysArgsDao.deleteBatch(ids);
	}
	
}

package com.seeyoumeet.dao;

import com.seeyoumeet.entity.SysUserRoleEntity;

import java.util.List;

/**
 * 用户与角色对应关系
 * 
 *
 *
 * @date 18#9:34:46
 */
public interface SysUserRoleDao extends BaseDao<SysUserRoleEntity> {
	
	/**
	 * 根据用户ID，获取角色ID列表
	 */
	List<Long> queryRoleIdList(Long userId);
}

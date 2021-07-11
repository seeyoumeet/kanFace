package com.seeyoumeet.service;

import java.util.List;



/**
 * 角色与菜单对应关系
 * 
 *
 *
 * @date 18#9:42:30
 */
public interface SysRoleMenuService {
	
	void saveOrUpdate(Long roleId, List<Long> menuIdList);
	
	/**
	 * 根据角色ID，获取菜单ID列表
	 */
	List<Long> queryMenuIdList(Long roleId);
	
}

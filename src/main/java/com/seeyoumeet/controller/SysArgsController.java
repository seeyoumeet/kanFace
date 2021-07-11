package com.seeyoumeet.controller;

import java.util.List;
import java.util.Map;

import com.seeyoumeet.entity.SysArgsEntity;
import com.seeyoumeet.service.SysArgsService;
import com.seeyoumeet.utils.PageUtils;
import com.seeyoumeet.utils.Query;
import com.seeyoumeet.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 系统参数管理
 *
 *
 */
@RestController
@RequestMapping("SysArgs")
public class SysArgsController extends AbstractController {
	@Autowired
	private SysArgsService SysArgsService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	public R list(@RequestParam Map<String, Object> params){

		//查询列表数据
        Query query = new Query(params);

		List<SysArgsEntity> SysArgsList = SysArgsService.queryList(query);
		int total = SysArgsService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(SysArgsList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}

	/**
	 * 列表
	 */
	@RequestMapping("/list2")
	public R list2(@RequestParam Map<String, Object> params){
        Query query = new Query(params);
		List<SysArgsEntity> SysArgsList = SysArgsService.queryList(query);
		return R.ok().put("list", SysArgsList );
	}

	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	public R info(@PathVariable("id") Long id){
		SysArgsEntity SysArgs = SysArgsService.queryObject(id);
		
		return R.ok().put("SysArgs", SysArgs);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	public R save(@RequestBody SysArgsEntity SysArgs){

        SysArgsService.save(SysArgs);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	public R update(@RequestBody SysArgsEntity SysArgs){
		SysArgsService.update(SysArgs);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	public R delete(@RequestBody Long[] ids){
		SysArgsService.deleteBatch(ids);
		
		return R.ok();
	}
	
}

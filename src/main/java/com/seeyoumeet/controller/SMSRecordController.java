package com.seeyoumeet.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.seeyoumeet.entity.SMSRecordEntity;
import com.seeyoumeet.service.SMSRecordService;
import com.seeyoumeet.utils.PageUtils;
import com.seeyoumeet.utils.Query;
import com.seeyoumeet.utils.R;

/**
 *
 *
 *
 */
@RestController
@RequestMapping("SMSRecord")
public class SMSRecordController extends AbstractController {
	@Autowired
	private SMSRecordService SMSRecordService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	public R list(@RequestParam Map<String, Object> params){

		//查询列表数据
        Query query = new Query(params);

		List<SMSRecordEntity> SMSRecordList = SMSRecordService.queryList(query);
		int total = SMSRecordService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(SMSRecordList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}

	/**
	 * 列表
	 */
	@RequestMapping("/list2")
	public R list2(@RequestParam Map<String, Object> params){
        Query query = new Query(params);
		List<SMSRecordEntity> SMSRecordList = SMSRecordService.queryList(query);
		return R.ok().put("list", SMSRecordList );
	}

	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	public R info(@PathVariable("id") Long id){
		SMSRecordEntity SMSRecord = SMSRecordService.queryObject(id);
		
		return R.ok().put("SMSRecord", SMSRecord);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	public R save(@RequestBody SMSRecordEntity SMSRecord){

        SMSRecordService.save(SMSRecord);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	public R update(@RequestBody SMSRecordEntity SMSRecord){
		SMSRecordService.update(SMSRecord);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	public R delete(@RequestBody Long[] ids){
		SMSRecordService.deleteBatch(ids);
		
		return R.ok();
	}
	
}

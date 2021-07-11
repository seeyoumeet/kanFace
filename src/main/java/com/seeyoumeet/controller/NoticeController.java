package com.seeyoumeet.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.seeyoumeet.entity.NoticeEntity;
import com.seeyoumeet.service.NoticeService;
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
 * 通知公告
 *
 *
 */
@RestController
@RequestMapping("Notice")
public class NoticeController extends AbstractController {
    @Autowired
    private NoticeService noticeService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params) {


        //查询列表数据
        Query query = new Query(params);

        List<NoticeEntity> NoticeList = noticeService.queryList(query);
        int total = noticeService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(NoticeList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }

    /**
     * 列表
     */
    @RequestMapping("/list2")
    public R list2(@RequestParam Map<String, Object> params) {
        Query query = new Query(params);
        List<NoticeEntity> NoticeList = noticeService.queryList(query);
        return R.ok().put("list", NoticeList);
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id) {
        NoticeEntity Notice = noticeService.queryObject(id);

        return R.ok().put("Notice", Notice);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody NoticeEntity Notice) {

        Notice.setTime(new Date());
        noticeService.save(Notice);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody NoticeEntity Notice) {
        noticeService.update(Notice);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids) {
        noticeService.deleteBatch(ids);

        return R.ok();
    }

}

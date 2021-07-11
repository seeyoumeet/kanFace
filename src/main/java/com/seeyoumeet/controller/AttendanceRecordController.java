package com.seeyoumeet.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.util.*;

import com.seeyoumeet.entity.CourseDetailEntity;
import com.seeyoumeet.entity.SysUserEntity;
import com.seeyoumeet.entity.SysArgsEntity;
import com.seeyoumeet.service.CourseDetailService;
import com.seeyoumeet.service.SysUserService;
import com.seeyoumeet.service.SysArgsService;
import com.seeyoumeet.utils.*;
import com.seeyoumeet.service.AttendanceRecordService;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import com.seeyoumeet.entity.AttendanceRecordEntity;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 考勤记录
 */
@Controller
@RequestMapping("AttendanceRecord")
public class AttendanceRecordController extends AbstractController {
    @Autowired
    private AttendanceRecordService attendanceRecordService;
    @Autowired
    private CourseDetailService courseDetailService;
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private SysArgsService SysArgsService;

    /**
     * 列表
     */
    @RequestMapping("/kqtj")
    @ResponseBody
    public R kqtj(@RequestParam Map<String, Object> params) {

        //查询列表数据
        Query query = new Query(params);
        List<Map<String, Object>> tj = attendanceRecordService.tj();
        int total = attendanceRecordService.conutTj();

        PageUtils pageUtil = new PageUtils(tj, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    @ResponseBody
    public R list(@RequestParam Map<String, Object> params) {

        //查询列表数据
        Query query = new Query(params);
        Object flag = params.get("flag");
        if (!StringUtils.isEmpty(flag)) {
            query.put("bkhxs", ShiroUtils.getUserEntity().getUserId());
        }
        List<AttendanceRecordEntity> AttendanceRecordList = attendanceRecordService.queryList(query);

        int total = attendanceRecordService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(AttendanceRecordList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }

    @RequestMapping("/export")
    public void export(HttpServletResponse response) throws IOException {

        Map<String, Object> params = new HashMap<>();
        params.put("limit",100);
        params.put("offsete",0);

        //创建HSSFWorkbook对象(excel的文档对象)
        HSSFWorkbook wb = new HSSFWorkbook();
        //建立新的sheet对象（excel的表单）
        HSSFSheet sheet = wb.createSheet("考勤记录表");
        //在sheet里创建第一行，参数为行索引(excel的行)，可以是0～65535之间的任何一个
        HSSFRow row1 = sheet.createRow(0);
        //创建单元格（excel的单元格，参数为列索引，可以是0～255之间的任何一个
        HSSFCell cell = row1.createCell(0);

        //第二行
        HSSFRow row2 = sheet.createRow(0);
        //创建单元格（excel的单元格，参数为列索引，可以是0～255之间的任何一个
        HSSFCell cell2 = row2.createCell(0);
        //设置单元格内容
        cell2.setCellValue("考勤记录表");
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 7));

        HSSFRow row22 = sheet.createRow(1);

        //创建单元格并设置单元格内容
        row22.createCell(0).setCellValue("课程");
        row22.createCell(1).setCellValue("上课时间");
        row22.createCell(2).setCellValue("所属老师");
        row22.createCell(3).setCellValue("被考核学生");
        row22.createCell(4).setCellValue("上课考勤状态");
        row22.createCell(5).setCellValue("下课考勤状态");

        List<AttendanceRecordEntity> AttendanceRecordEntities = this.attendanceRecordService.queryList(params);

        int i = 2;

        List<Object[]> dataList = new ArrayList<Object[]>();
        int b = 2;
        for (AttendanceRecordEntity entity : AttendanceRecordEntities) {

            HSSFRow row3 = sheet.createRow(i);
            row3.createCell(0).setCellValue(entity.getCourseDetailEntity().getTitle());
            row3.createCell(1).setCellValue(entity.getTime());
            row3.createCell(2).setCellValue(entity.getTeacherEntity().getUsername());
            row3.createCell(3).setCellValue(entity.getStudentEntity().getUsername());
            row3.createCell(4).setCellValue(entity.getStartclassStatus() == 0 ? "正常" : "迟到");
            row3.createCell(5).setCellValue(entity.getFinishedclassStatus() == 0 ? "正常" : "早退");

            i++;
        }

        //输出Excel文件
        OutputStream output = response.getOutputStream();
        response.reset();
        response.setHeader("Content-disposition", "attachment; filename=result.xls");
        response.setContentType("application/msexcel");
        wb.write(output);
        output.close();
    }

    /**
     * 列表
     */
    @RequestMapping("/list2")
    @ResponseBody
    public R list2(@RequestParam Map<String, Object> params) {
        Query query = new Query(params);
        List<AttendanceRecordEntity> AttendanceRecordList = attendanceRecordService.queryList(query);
        return R.ok().put("list", AttendanceRecordList);
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @ResponseBody
    public R info(@PathVariable("id") Long id) {
        AttendanceRecordEntity AttendanceRecord = attendanceRecordService.queryObject(id);

        return R.ok().put("AttendanceRecord", AttendanceRecord);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @ResponseBody
    public R save(@RequestBody AttendanceRecordEntity AttendanceRecord, HttpServletRequest request) {
        Map<String, Object> query = new HashMap<>();
        query.put("CourseDetail", AttendanceRecord.getCourseDetail());
        query.put("time", AttendanceRecord.getTime());
        query.put("bkhxs", AttendanceRecord.getStudent());
        List<AttendanceRecordEntity> AttendanceRecordEntities = attendanceRecordService.queryList(query);
        if (AttendanceRecordEntities.size() > 0) {
            return R.error(1000, "该学生该上课时间已考核");
        }
        SysUserEntity student = sysUserService.queryObject((long) AttendanceRecord.getStudent());
        CourseDetailEntity courseDetailEntity = courseDetailService.queryObject(AttendanceRecord.getCourseDetail());
        AttendanceRecord.setTeacher(courseDetailEntity.getSysUser().intValue());
        Date now = new Date();
        int i = DateUtils.compare_date(DateUtils.format(now, DateUtils.DATE_TIME_PATTERN), AttendanceRecord.getTime());
        if (i == 1) {
            AttendanceRecord.setStartclassStatus(1);
        } else {
            AttendanceRecord.setStartclassStatus(0);
        }

        String base64 = AttendanceRecord.getBase64().replace("data:image/png;base64,", "");
        String root = MultipartFileUtil.getRootPath(request);
        String url = "capture/" + UUID.randomUUID().toString() + ".png";
        ImageUtils.to(base64, root + url);
//        int score = FaceUtils.compare(root + url, root + student.getImg());
        int score = FaceUtils.compare(root + url, root + "statics/face/031740202.jpg");
        SysArgsEntity sysArgsEntity = SysArgsService.queryObject(1l);
        String value = sysArgsEntity.getValue();
        if (score >= Integer.parseInt(value)) {
            AttendanceRecord.setFinishedclassStatus(0);
            attendanceRecordService.save(AttendanceRecord);
            return R.ok("考勤成功");
        } else {
            return R.error("考勤识别失败 score:" + score);
        }
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @ResponseBody
    public R update(@RequestBody AttendanceRecordEntity AttendanceRecord) {
        attendanceRecordService.update(AttendanceRecord);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @ResponseBody
    public R delete(@RequestBody Long[] ids) {
        attendanceRecordService.deleteBatch(ids);

        return R.ok();
    }

}

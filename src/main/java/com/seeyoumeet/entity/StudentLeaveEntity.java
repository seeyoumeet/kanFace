package com.seeyoumeet.entity;

import java.io.Serializable;
import java.util.Date;

import com.seeyoumeet.service.*;


/**
 * 学生请假
 *
 *
 *
 * @date 2020-03-07 08:02:00
 */
public class StudentLeaveEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    //
    private Long id;

    //请假学生
    private Long sysUser;

    private SysUserEntity sysUserEntity;

    public SysUserEntity getSysUserEntity() {
        return sysUserEntity;
    }

    public void setSysUserEntity(SysUserEntity sysUserEntity) {
        this.sysUserEntity = sysUserEntity;
    }

    //请假类型
    private String leaveType;

    //请假开始时间
    private Date beginTime;

    //请假结束时间
    private Date endTime;

    //请假天数
    private Integer days;

    //请假原因
    private String content;

    //老师审批
    private Integer teacherApprove;

    //管理员审批
    private Integer adminApprove;


    /**
     * 设置：
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取：
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置：请假学生
     */
    public void setSysUser(Long sysUser) {
        this.sysUser = sysUser;
    }

    /**
     * 获取：请假学生
     */
    public Long getSysUser() {
        return sysUser;
    }

    /**
     * 设置：请假类型
     */
    public void setLeaveType(String leaveType) {
        this.leaveType = leaveType;
    }

    /**
     * 获取：请假类型
     */
    public String getLeaveType() {
        return leaveType;
    }

    /**
     * 设置：请假开始时间
     */
    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    /**
     * 获取：请假开始时间
     */
    public Date getBeginTime() {
        return beginTime;
    }

    /**
     * 设置：请假结束时间
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * 获取：请假结束时间
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * 设置：请假天数
     */
    public void setDays(Integer days) {
        this.days = days;
    }

    /**
     * 获取：请假天数
     */
    public Integer getDays() {
        return days;
    }

    /**
     * 设置：请假原因
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 获取：请假原因
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置：老师审批
     */
    public void setTeacherApprove(Integer teacherApprove) {
        this.teacherApprove = teacherApprove;
    }

    /**
     * 获取：老师审批
     */
    public Integer getTeacherApprove() {
        return teacherApprove;
    }

    /**
     * 设置：管理员审批
     */
    public void setAdminApprove(Integer adminApprove) {
        this.adminApprove = adminApprove;
    }

    /**
     * 获取：管理员审批
     */
    public Integer getAdminApprove() {
        return adminApprove;
    }
}

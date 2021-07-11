package com.seeyoumeet.entity;

import java.io.Serializable;

/**
 * 考勤记录
 */
public class AttendanceRecordEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    //
    private Long id;

    //课程
    private Long CourseDetail;

    private CourseDetailEntity courseDetailEntity;

    public CourseDetailEntity getCourseDetailEntity() {
        return courseDetailEntity;
    }

    public void setCourseDetailEntity(CourseDetailEntity courseDetailEntity) {
        this.courseDetailEntity = courseDetailEntity;
    }

    //上课时间
    private String time;

    //所属老师
    private Integer teacher;
    private SysUserEntity teacherEntity;

    //被考核学生
    private Integer student;
    private SysUserEntity studentEntity;

    //上课考勤状态
    private Integer startclassStatus;

    //下课考勤状态
    private Integer finishedclassStatus;
    private String base64;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public SysUserEntity getTeacherEntity() {
        return teacherEntity;
    }

    public void setTeacherEntity(SysUserEntity teacherEntity) {
        this.teacherEntity = teacherEntity;
    }

    public SysUserEntity getStudentEntity() {
        return studentEntity;
    }

    public void setStudentEntity(SysUserEntity studentEntity) {
        this.studentEntity = studentEntity;
    }

    public String getBase64() {
        return base64;
    }

    public void setBase64(String base64) {
        this.base64 = base64;
    }

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
     * 设置：课程
     */
    public void setCourseDetail(Long CourseDetail) {
        this.CourseDetail = CourseDetail;
    }

    /**
     * 获取：课程
     */
    public Long getCourseDetail() {
        return CourseDetail;
    }

    /**
     * 设置：上课时间
     */
    public void setTime(String time) {
        this.time = time;
    }

    /**
     * 获取：上课时间
     */
    public String getTime() {
        return time;
    }

    /**
     * 设置：所属老师
     */
    public void setTeacher(Integer teacher) {
        this.teacher = teacher;
    }

    /**
     * 获取：所属老师
     */
    public Integer getTeacher() {
        return teacher;
    }

    /**
     * 设置：被考核学生
     */
    public void setStudent(Integer student) {
        this.student = student;
    }

    /**
     * 获取：被考核学生
     */
    public Integer getStudent() {
        return student;
    }

    /**
     * 设置：上课考勤状态
     */
    public void setStartclassStatus(Integer startclassStatus) {
        this.startclassStatus = startclassStatus;
    }

    /**
     * 获取：上课考勤状态
     */
    public Integer getStartclassStatus() {
        return startclassStatus;
    }

    /**
     * 设置：下课考勤状态
     */
    public void setFinishedclassStatus(Integer finishedclassStatus) {
        this.finishedclassStatus = finishedclassStatus;
    }

    /**
     * 获取：下课考勤状态
     */
    public Integer getFinishedclassStatus() {
        return finishedclassStatus;
    }
}

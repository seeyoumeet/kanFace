package com.seeyoumeet.entity;

import java.io.Serializable;

/**
 * 选择课程
 *
 *  
 */
public class ChooseCourseEntity implements Serializable {
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

        // 选课的学生
        private Long sysUser;

        private  SysUserEntity  sysUserEntity;

        public SysUserEntity getSysUserEntity() {
            return sysUserEntity;
        }

        public void setSysUserEntity(SysUserEntity sysUserEntity) {
            this.sysUserEntity = sysUserEntity;
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
         * 设置：学生
         */
        public void setSysUser(Long sysUser) {
            this.sysUser = sysUser;
        }

        /**
         * 获取：学生
         */
        public Long getSysUser() {
            return sysUser;
        }
    }

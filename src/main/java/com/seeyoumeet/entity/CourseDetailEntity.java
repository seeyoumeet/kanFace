package com.seeyoumeet.entity;

import java.io.Serializable;

import com.seeyoumeet.service.*;

/**
 * 课程信息
 *
 *  
 */
public class CourseDetailEntity implements Serializable {
    private static final long serialVersionUID = 1L;

        //
        private Long id;

        //题目
        private String title;

        //简介
        private String content;

        //所属任课老师
        private Long sysUser;

        private  SysUserEntity  sysUserEntity;

        public SysUserEntity getSysUserEntity() {
            return sysUserEntity;
        }

        public void setSysUserEntity(SysUserEntity sysUserEntity) {
            this.sysUserEntity = sysUserEntity;
        }

        //学时
        private Integer classPeriod;

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
         * 设置：题目
         */
        public void setTitle(String title) {
            this.title = title;
        }

        /**
         * 获取：题目
         */
        public String getTitle() {
            return title;
        }
            /**
         * 设置：简介
         */
        public void setContent(String content) {
            this.content = content;
        }

        /**
         * 获取：简介
         */
        public String getContent() {
            return content;
        }
            /**
         * 设置：所属任课老师
         */
        public void setSysUser(Long sysUser) {
            this.sysUser = sysUser;
        }

        /**
         * 获取：所属任课老师
         */
        public Long getSysUser() {
            return sysUser;
        }
            /**
         * 设置：学时
         */
        public void setClassPeriod(Integer classPeriod) {
            this.classPeriod = classPeriod;
        }

        /**
         * 获取：学时
         */
        public Integer getClassPeriod() {
            return classPeriod;
        }
    }

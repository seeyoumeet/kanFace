package com.seeyoumeet.entity;

import java.io.Serializable;
import java.util.Date;
import com.seeyoumeet.service.*;



/**
 * 系统参数管理
 *
 *
 *
 *
 */
public class SysArgsEntity implements Serializable {
    private static final long serialVersionUID = 1L;

        //
        private Long id;

        //参数名称
        private String name;

        //参数代码
        private String code;

        //参数值
        private String value;

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
         * 设置：参数名称
         */
        public void setName(String name) {
            this.name = name;
        }

        /**
         * 获取：参数名称
         */
        public String getName() {
            return name;
        }
            /**
         * 设置：参数代码
         */
        public void setCode(String code) {
            this.code = code;
        }

        /**
         * 获取：参数代码
         */
        public String getCode() {
            return code;
        }
            /**
         * 设置：参数值
         */
        public void setValue(String value) {
            this.value = value;
        }

        /**
         * 获取：参数值
         */
        public String getValue() {
            return value;
        }
    }

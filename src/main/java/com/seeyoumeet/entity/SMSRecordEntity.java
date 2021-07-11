package com.seeyoumeet.entity;

import java.io.Serializable;
import java.util.Date;
import com.seeyoumeet.service.*;

/**
 *
 *
 *
 */
public class SMSRecordEntity implements Serializable {
    private static final long serialVersionUID = 1L;
        private Long id;
        //
        private String phone;

        //
        private String code;

        //
        private Date time;

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
         * 设置：
         */
        public void setPhone(String phone) {
            this.phone = phone;
        }

        /**
         * 获取：
         */
        public String getPhone() {
            return phone;
        }

        /**
         * 设置：
         */
        public void setCode(String code) {
            this.code = code;
        }

        /**
         * 获取：
         */
        public String getCode() {
            return code;
        }

        /**
         * 设置：
         */
        public void setTime(Date time) {
            this.time = time;
        }

        /**
         * 获取：
         */
        public Date getTime() {
            return time;
        }
    }

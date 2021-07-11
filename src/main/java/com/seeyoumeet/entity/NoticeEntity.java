package com.seeyoumeet.entity;

import java.io.Serializable;
import java.util.Date;
import com.seeyoumeet.service.*;

/**
 * 通知公告
 *
 *
 */
public class NoticeEntity implements Serializable {
    private static final long serialVersionUID = 1L;

        //
        private Long id;

        //通知标题
        private String title;

        //通知内容
        private String content;

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
         * 设置：通知标题
         */
        public void setTitle(String title) {
            this.title = title;
        }

        /**
         * 获取：通知标题
         */
        public String getTitle() {
            return title;
        }
            /**
         * 设置：通知标题
         */
        public void setContent(String content) {
            this.content = content;
        }

        /**
         * 获取：通知标题
         */
        public String getContent() {
            return content;
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

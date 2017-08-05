package org.laboratory.entity;


import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.Date;

public class MyMessage implements Serializable {

    private int blog_reply_id;

    private int blog_cmt_id;

    private int from_uid;

    private int to_uid;

    private String content;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date blog_reply_time;

    private int status;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getBlog_reply_id() {
        return blog_reply_id;
    }

    public void setBlog_reply_id(int blog_reply_id) {
        this.blog_reply_id = blog_reply_id;
    }

    public int getBlog_cmt_id() {
        return blog_cmt_id;
    }

    public void setBlog_cmt_id(int blog_cmt_id) {
        this.blog_cmt_id = blog_cmt_id;
    }

    public int getFrom_uid() {
        return from_uid;
    }

    public void setFrom_uid(int from_uid) {
        this.from_uid = from_uid;
    }

    public int getTo_uid() {
        return to_uid;
    }

    public void setTo_uid(int to_uid) {
        this.to_uid = to_uid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getBlog_reply_time() {
        return blog_reply_time;
    }

    public void setBlog_reply_time(Date blog_reply_time) {
        this.blog_reply_time = blog_reply_time;
    }

    @Override
    public String toString() {
        return "MyMessage{" +
                "blog_reply_id=" + blog_reply_id +
                ", blog_cmt_id=" + blog_cmt_id +
                ", from_uid=" + from_uid +
                ", to_uid=" + to_uid +
                ", content='" + content + '\'' +
                ", blog_reply_time=" + blog_reply_time +
                '}';
    }

    public MyMessage(){

    }



}

package com.yrws.share.entity;

import java.util.Date;

public class Publish {
    private Integer publishId;//帖子id

    private String username;//发帖用户名

    private String publishTitle;//标题

    private String publishComment;//内容

    private String publishImg;//上传图片

    private String publishAddress;//定位

    private String publishType;//吹水与分享

    private String publishDianzan;//dianzan 

    private String publishDashang;//打赏

    private Date publishDate;//时间

    public Integer getPublishId() {
        return publishId;
    }

    public void setPublishId(Integer publishId) {
        this.publishId = publishId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPublishTitle() {
        return publishTitle;
    }

    public void setPublishTitle(String publishTitle) {
        this.publishTitle = publishTitle == null ? null : publishTitle.trim();
    }

    public String getPublishComment() {
        return publishComment;
    }

    public void setPublishComment(String publishComment) {
        this.publishComment = publishComment == null ? null : publishComment.trim();
    }

    public String getPublishImg() {
        return publishImg;
    }

    public void setPublishImg(String publishImg) {
        this.publishImg = publishImg == null ? null : publishImg.trim();
    }

    public String getPublishAddress() {
        return publishAddress;
    }

    public void setPublishAddress(String publishAddress) {
        this.publishAddress = publishAddress == null ? null : publishAddress.trim();
    }

    public String getPublishType() {
        return publishType;
    }

    public void setPublishType(String publishType) {
        this.publishType = publishType == null ? null : publishType.trim();
    }

    public String getPublishDianzan() {
        return publishDianzan;
    }

    public void setPublishDianzan(String publishDianzan) {
        this.publishDianzan = publishDianzan == null ? null : publishDianzan.trim();
    }

    public String getPublishDashang() {
        return publishDashang;
    }

    public void setPublishDashang(String publishDashang) {
        this.publishDashang = publishDashang == null ? null : publishDashang.trim();
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }
}
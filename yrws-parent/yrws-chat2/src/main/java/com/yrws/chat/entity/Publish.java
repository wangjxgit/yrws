package com.yrws.chat.entity;

import java.util.Date;

public class Publish {
    private Integer publishId;

    private String username;

    private String publishTitle;

    private String publishComment;

    private String publishImg;

    private String publishAddress;

    private String publishType;

    private String publishDianzan;

    private String publishDashang;

    private Date publishDate;

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
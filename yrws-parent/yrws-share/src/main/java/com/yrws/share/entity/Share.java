package com.yrws.share.entity;

public class Share {
    private String img;//对应表user表中的img字段代表头型
    
    private String username;//对应表publish表中的username字段代表用户微信号
    
    private String name;//对应表user表中的name字段代表昵称
    
    private String publishDate;//对应表publish表中的discuss_date字段代添加时间
    
    private String sex;//对应表user表中的user字段代表用户性别
    
    private String publishComment;//对应表publish表中的discuss_comment字段代表用户的分享内容
    
    private String publishImg;//对应表publish表中的discuss_img字段代表用户的分享的照片

    private String publishId;//对应表publish表中的discuss_id字段代表用户的每条分享id

    private String publishTitle;//对应表publish表中的discuss_title字段代表用户的分享时间

    private String publishAddress;//对应表publish表中的discuss_address字段代表用户的分享地点

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPublishComment() {
        return publishComment;
    }

    public void setPublishComment(String publishComment) {
        this.publishComment = publishComment;
    }

    public String getPublishImg() {
        return publishImg;
    }

    public void setPublishImg(String publishImg) {
        this.publishImg = publishImg;
    }

    public String getPublishId() {
        return publishId;
    }

    public void setPublishId(String publishId) {
        this.publishId = publishId;
    }

    public String getPublishTitle() {
        return publishTitle;
    }

    public void setPublishTitle(String publishTitle) {
        this.publishTitle = publishTitle;
    }

    public String getPublishAddress() {
        return publishAddress;
    }

    public void setPublishAddress(String publishAddress) {
        this.publishAddress = publishAddress;
    }

    public Share() {
       
    }

    public Share(String img, String username, String name, String publishDate, String sex,
            String publishComment, String publishImg, String publishId, String publishTitle,
            String publishAddress) {
      
        this.img = img;
        this.username = username;
        this.name = name;
        this.publishDate = publishDate;
        this.sex = sex;
        this.publishComment = publishComment;
        this.publishImg = publishImg;
        this.publishId = publishId;
        this.publishTitle = publishTitle;
        this.publishAddress = publishAddress;
    }

    @Override
    public String toString() {
        return "UserShare [img=" + img + ", username=" + username + ", name=" + name + ", publishDate="
                + publishDate + ", sex=" + sex + ", publishComment=" + publishComment + ", publishImg="
                + publishImg + ", publishId=" + publishId + ", publishTitle=" + publishTitle
                + ", publishAddress=" + publishAddress + "]";
    }

    
    
}

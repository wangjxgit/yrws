package com.yrws.chat.view;

import java.util.Date;

public class UserPublish implements Comparable<UserPublish> {
    private int publishId;

    private String name;

    private String sex;

    private String userimg;

    private String time;

    private Date nowtime;

    private String publishimg;

    private String title;

    private String comment;

    private int publishGood;
    //用户回显点赞
    private boolean good;
    
  //支鹏宇-----------------------
    private String username;
    private String img;

    private String publishTitle;
    private String publishComment;
    private String publishImg;
    private String publishAddress;
    private Date publishDate;
    
    private boolean love;
    private boolean pubGood;
    
    public UserPublish(String username, String img, String sex, String name, int publishId, String publishTitle,
            String publishComment, String publishImg, String publishAddress, Date publishDate,boolean love,boolean pubGood) {
    
        this.username = username;
        this.img = img;
        this.sex = sex;
        this.name = name;
        this.publishId = publishId;
        this.publishTitle = publishTitle;
        this.publishComment = publishComment;
        this.publishImg = publishImg;
        this.publishAddress = publishAddress;
        this.publishDate = publishDate;
        this.love=love;
        this.pubGood=pubGood;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getPublishTitle() {
        return publishTitle;
    }

    public void setPublishTitle(String publishTitle) {
        this.publishTitle = publishTitle;
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

    public String getPublishAddress() {
        return publishAddress;
    }

    public void setPublishAddress(String publishAddress) {
        this.publishAddress = publishAddress;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public boolean isLove() {
        return love;
    }

    public void setLove(boolean love) {
        this.love = love;
    }

    public boolean isPubGood() {
        return pubGood;
    }

    public void setPubGood(boolean pubGood) {
        this.pubGood = pubGood;
    }

    //----------------------
    public boolean isGood() {
        return good;
    }

    public void setGood(boolean good) {
        this.good = good;
    }

    public int getPublishGood() {
        return publishGood;
    }

    public void setPublishGood(int publishGood) {
        this.publishGood = publishGood;
    }

    public int getPublishId() {
        return publishId;
    }

    public void setPublishId(int publishId) {
        this.publishId = publishId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getUserimg() {
        return userimg;
    }

    public void setUserimg(String userimg) {
        this.userimg = userimg;
    }

    public Date getNowtime() {
        return nowtime;
    }

    public void setNowtime(Date nowtime) {
        this.nowtime = nowtime;
    }

    public String getPublishimg() {
        return publishimg;
    }

    public void setPublishimg(String publishimg) {
        this.publishimg = publishimg;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public UserPublish(String name, String sex, String userimg, String time, String publishimg, String title,
            String comment) {
        this.name = name;
        this.sex = sex;
        this.userimg = userimg;
        this.time = time;
        this.publishimg = publishimg;
        this.title = title;
        this.comment = comment;
    }

    public UserPublish(int publishId, String name, String sex, String userimg, String time,
            String publishimg, String title, String comment, boolean good) {

        this.publishId = publishId;
        this.name = name;
        this.sex = sex;
        this.userimg = userimg;
        this.time = time;
        this.publishimg = publishimg;
        this.title = title;
        this.comment = comment;
        this.good=good;
    }

    public UserPublish(int publishId, String name, String sex, String userimg, String time,
            String publishimg, String title, String comment, int publishGood, boolean good) {
        
        this.publishId = publishId;
        this.name = name;
        this.sex = sex;
        this.userimg = userimg;
        this.time = time;
        this.publishimg = publishimg;
        this.title = title;
        this.comment = comment;
        this.publishGood = publishGood;
        this.good=good;
    }

    public UserPublish() {

    }
    @Override
    public int compareTo(UserPublish o) {  
        return this.getPublishGood() - o.getPublishGood();//先按照年龄排序  
         
    }

    @Override
    public String toString() {
        return "UserPublish [publishId=" + publishId + ", name=" + name + ", sex=" + sex + ", userimg="
                + userimg + ", time=" + time + ", nowtime=" + nowtime + ", publishimg=" + publishimg
                + ",publishImg=" + publishImg+", title=" + title + ", comment=" + comment + ", publishGood=" + publishGood + ", good="
                + good + "]";
    }  
    
}

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
    
}

package com.yrws.share.view;

import java.util.Date;

public class UserPublish  {
    //支鹏宇
    private String username;
    private String img;
    private String sex;
    private String name;
    
    private int publishId;
    private String publishTitle;
    private String publishComment;
    private String publishImg;
    private String publishAddress;
    private Date publishDate;
    
    private boolean love;
    private boolean pubGood;
        public boolean isPubGood() {
        return pubGood;
    }
    public void setPubGood(boolean pubGood) {
        this.pubGood = pubGood;
    }
    public boolean isLove() {
        return love;
    }
    public void setLove(boolean love) {
        this.love = love;
    }
    public UserPublish() {

        }
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
        public String getSex() {
                return sex;
        }
        public void setSex(String sex) {
                this.sex = sex;
        }
        public String getName() {
                return name;
        }
        public void setName(String name) {
                this.name = name;
        }
        public int getPublishId() {
                return publishId;
        }
        public void setPublishId(int publishId) {
                this.publishId = publishId;
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
        @Override
        public String toString() {
                return "UserPublish [username=" + username + ", img=" + img + ", sex=" + sex + ", name=" + name + ", publishId="
                                + publishId + ", publishTitle=" + publishTitle + ", publishComment=" + publishComment + ", publishImg="
                                + publishImg + ", publishAddress=" + publishAddress + ", publishDate=" + publishDate + "]";
        }
    

    

}

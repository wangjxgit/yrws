package com.yrws.share.view;

import java.util.Date;

import com.yrws.share.entity.Discuss;

public class UserDiscuss {
    private String username;
    private String img;
    private String sex;   
    private String name;
  
    private Integer discussId;
    private Integer publishId;
    private String discussbyUsername;
    private String discussComment;
    private String discussFloor;
    private Date discussDate;
    

    private String passTime;//评论距今过去的时间
    //评论的对方
    private Discuss rc;//被评论的对象

    private int counts;//点赞的人数
    
    private int tag;//当前用户是否点赞过   标记    
    //点赞回显属性
    private boolean good;
    
    
    public String getPassTime() {
        return passTime;
    }
    public void setPassTime(String passTime) {
        this.passTime = passTime;
    }
    public Discuss getRc() {
        return rc;
    }
    public void setRc(Discuss rc) {
        this.rc = rc;
    }
    public int getCounts() {
        return counts;
    }
    public void setCounts(int counts) {
        this.counts = counts;
    }
    public int getTag() {
        return tag;
    }
    public void setTag(int tag) {
        this.tag = tag;
    }
  
    public boolean isGood(){
        return good;
    }
    public void setGood(boolean good) {
        this.good = good;
    }
    public UserDiscuss() {
    }
    public UserDiscuss(String username, String img, String sex, String name, Integer discussId,
            Integer publishId, String discussbyUsername, String discussComment, String discussFloor,
            Date discussDate) {
       
        this.username = username;
        this.img = img;
        this.sex = sex;
        this.name = name;
        this.discussId = discussId;
        this.publishId = publishId;
        this.discussbyUsername = discussbyUsername;
        this.discussComment = discussComment;
        this.discussFloor = discussFloor;
        this.discussDate = discussDate;
    }


    public Integer getDiscussId() {
        return discussId;
    }
    public void setDiscussId(Integer discussId) {
        this.discussId = discussId;
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
    public Integer getPublishId() {
        return publishId;
    }
    public void setPublishId(Integer publishId) {
        this.publishId = publishId;
    }
    public String getDiscussbyUsername() {
        return discussbyUsername;
    }
    public void setDiscussbyUsername(String discussbyUsername) {
        this.discussbyUsername = discussbyUsername;
    }
    public String getDiscussComment() {
        return discussComment;
    }
    public void setDiscussComment(String discussComment) {
        this.discussComment = discussComment;
    }
    public String getDiscussFloor() {
        return discussFloor;
    }
    public void setDiscussFloor(String discussFloor) {
        this.discussFloor = discussFloor;
    }
    public Date getDiscussDate() {
        return discussDate;
    }
    public void setDiscussDate(Date discussDate) {
        this.discussDate = discussDate;
    }
    @Override
    public String toString() {
        return "UserDiscuss [username=" + username + ", img=" + img + ", sex=" + sex + ", name=" + name
                + ", discussId=" + discussId + ", publishId=" + publishId + ", discussbyUsername="
                + discussbyUsername + ", discussComment=" + discussComment + ", discussFloor=" + discussFloor
                + ", discussDate=" + discussDate + ", good=" + good + "]";
    }


    
   
    
    
    
    
}

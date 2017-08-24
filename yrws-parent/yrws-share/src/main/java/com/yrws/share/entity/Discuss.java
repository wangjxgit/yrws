package com.yrws.share.entity;

import java.util.Date;

public class Discuss {
    private Integer discussId;//评论相应id，标识

    private Integer publishId;//帖子id

    private String username;//用户名

    private String discussbyUsername;//被评论用户名

    private String discussComment;//评论者

    private String discussFloor;//楼层
    
    private String discussbyFloor;
    
    private Date discussDate;

    
    
    
    
    public Discuss(Integer publishId, String username, String discussbyUsername, String discussComment,
            String discussFloor, Date discussDate) {
        this.publishId = publishId;
        this.username = username;
        this.discussbyUsername = discussbyUsername;
        this.discussComment = discussComment;
        this.discussFloor = discussFloor;
        this.discussDate = discussDate;
    }

   


    
  //有参构造
    public Discuss(Integer discussId, Integer publishId, String username, String discussbyUsername,
            String discussComment, String discussFloor, String discussbyFloor, Date discussDate) {
        this.discussId = discussId;
        this.publishId = publishId;
        this.username = username;
        this.discussbyUsername = discussbyUsername;
        this.discussComment = discussComment;
        this.discussFloor = discussFloor;
        this.discussbyFloor = discussbyFloor;
        this.discussDate = discussDate;
    }
    
   
    //空参构造
    public Discuss() {

    }
    public String getDiscussbyFloor() {
        return discussbyFloor;
    }

    public void setDiscussbyFloor(String discussbyFloor) {
        this.discussbyFloor = discussbyFloor;
    }
    public Integer getDiscussId() {
        return discussId;
    }

    public void setDiscussId(Integer discussId) {
        this.discussId = discussId;
    }

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

    public String getDiscussbyUsername() {
        return discussbyUsername;
    }

    public void setDiscussbyUsername(String discussbyUsername) {
        this.discussbyUsername = discussbyUsername == null ? null : discussbyUsername.trim();
    }

    public String getDiscussComment() {
        return discussComment;
    }

    public void setDiscussComment(String discussComment) {
        this.discussComment = discussComment == null ? null : discussComment.trim();
    }

    public String getDiscussFloor() {
        return discussFloor;
    }

    public void setDiscussFloor(String discussFloor) {
        this.discussFloor = discussFloor == null ? null : discussFloor.trim();
    }

    public Date getDiscussDate() {
        return discussDate;
    }

    public void setDiscussDate(Date discussDate) {
        this.discussDate = discussDate;
    }

}
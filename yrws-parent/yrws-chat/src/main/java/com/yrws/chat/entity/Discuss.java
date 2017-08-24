package com.yrws.chat.entity;

import java.util.Date;

public class Discuss {
    private Integer discussId;

    private Integer publishId;

    private String username;

    private String discussbyUsername;

    private String discussComment;

    private String discussFloor;

    private Date discussDate;

    
    public Discuss() {

    }
    

    public Discuss(Integer discussId, Integer publishId, String username, String discussbyUsername,
            String discussComment, String discussFloor, Date discussDate) {
        
        this.discussId = discussId;
        this.publishId = publishId;
        this.username = username;
        this.discussbyUsername = discussbyUsername;
        this.discussComment = discussComment;
        this.discussFloor = discussFloor;
        this.discussDate = discussDate;
    }

    public Discuss(Integer publishId, String username, String discussbyUsername, String discussComment,
            String discussFloor, Date discussDate) {
        this.publishId = publishId;
        this.username = username;
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
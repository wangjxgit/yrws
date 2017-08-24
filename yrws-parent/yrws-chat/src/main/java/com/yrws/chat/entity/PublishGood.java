package com.yrws.chat.entity;

public class PublishGood {
    
    private Integer goodId;//点赞id

    private String usernameGood;//点赞人

    private Integer publishId;//被点赞帖子id

    private Integer discussId;//被点赞评论id



    
    public Integer getGoodId() {
        return goodId;
    }
    public void setGoodId(Integer goodId) {
        this.goodId = goodId;
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

    public String getUsernameGood() {
        return usernameGood;
    }

    public void setUsernameGood(String usernameGood) {
        this.usernameGood = usernameGood == null ? null : usernameGood.trim();
    }

 
    public PublishGood(Integer goodId, String usernameGood, Integer publishId, Integer discussId) {
        super();
        this.goodId = goodId;
        this.usernameGood = usernameGood;
        this.publishId = publishId;
        this.discussId = discussId;
    }
    
    public PublishGood(String usernameGood, Integer publishId, Integer discussId) {
        super();
        this.usernameGood = usernameGood;
        this.publishId = publishId;
        this.discussId = discussId;
    }
    public PublishGood(String usernameGood, Integer publishId) {
        
        this.usernameGood = usernameGood;
        this.publishId = publishId;
    }
    public PublishGood() {
        
    }
    
    
}
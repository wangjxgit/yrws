package com.yrws.share.entity;


public class PublishGood {
    private Integer goodId;//点赞id

    private String usernameGood;//点赞人

    private Integer publishId;//被点赞帖子id

    private Integer discussId;//被点赞评论id

    private String state;//点赞状态
    
    

    public PublishGood() {

    }

    
    public PublishGood(Integer goodId, String usernameGood, Integer publishId, Integer discussId, String state) {

        this.goodId = goodId;
        this.usernameGood = usernameGood;
        this.publishId = publishId;
        this.discussId = discussId;
        this.state = state;
    }
    public PublishGood(String usernameGood, Integer publishId) {
        
        this.usernameGood = usernameGood;
        this.publishId = publishId;
    }
    public PublishGood(String usernameGood, Integer publishId, Integer discussId) {

        this.usernameGood = usernameGood;
        this.publishId = publishId;
        this.discussId = discussId;
        
    }
    public Integer getGoodId() {
        return goodId;
    }

    public void setGoodId(Integer goodId) {
        this.goodId = goodId;
    }

    public String getUsernameGood() {
        return usernameGood;
    }

    public void setUsernameGood(String usernameGood) {
        this.usernameGood = usernameGood == null ? null : usernameGood.trim();
    }

    public Integer getPublishId() {
        return publishId;
    }

    public void setPublishId(Integer publishId) {
        this.publishId = publishId;
    }

    public Integer getDiscussId() {
        return discussId;
    }

    public void setDiscussId(Integer discussId) {
        this.discussId = discussId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }


    @Override
    public String toString() {
        return "PublishGood [goodId=" + goodId + ", usernameGood=" + usernameGood + ", publishId="
                + publishId + ", discussId=" + discussId + ", state=" + state + "]";
    }
    
}






   


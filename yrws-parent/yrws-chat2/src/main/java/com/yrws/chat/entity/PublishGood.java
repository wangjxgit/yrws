package com.yrws.chat.entity;

public class PublishGood {
    private Integer goodId;

    private String usernameGood;

    private String publishGood;

    private String discussGood;

    private String floorGood;

    private Integer publishId;
    
    public Integer getPublishId() {
        return publishId;
    }
    public void setPublishId(Integer publishId) {
        this.publishId = publishId;
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

    public String getPublishGood() {
        return publishGood;
    }

    public void setPublishGood(String publishGood) {
        this.publishGood = publishGood == null ? null : publishGood.trim();
    }

    public String getDiscussGood() {
        return discussGood;
    }

    public void setDiscussGood(String discussGood) {
        this.discussGood = discussGood == null ? null : discussGood.trim();
    }

    public String getFloorGood() {
        return floorGood;
    }

    public void setFloorGood(String floorGood) {
        this.floorGood = floorGood == null ? null : floorGood.trim();
    }
    public PublishGood(Integer goodId, String usernameGood, String publishGood, String discussGood,
            String floorGood, Integer publishId) {
        
        this.goodId = goodId;
        this.usernameGood = usernameGood;
        this.publishGood = publishGood;
        this.discussGood = discussGood;
        this.floorGood = floorGood;
        this.publishId = publishId;
    }
    
    public PublishGood(String usernameGood, Integer publishId) {
        
        this.usernameGood = usernameGood;
        this.publishId = publishId;
    }
    public PublishGood() {
        
    }
    
    
}
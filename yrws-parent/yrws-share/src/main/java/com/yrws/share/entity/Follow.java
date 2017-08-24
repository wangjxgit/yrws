package com.yrws.share.entity;

public class Follow {
    private String fromUsername;//关注者

    private String toUsername;//被关注者

    public Follow() {
        
    }
    public Follow(String fromUsername, String toUsername) {
        
        this.fromUsername = fromUsername;
        this.toUsername = toUsername;
    }

    public String getFromUsername() {
        return fromUsername;
    }

    public void setFromUsername(String fromUsername) {
        this.fromUsername = fromUsername == null ? null : fromUsername.trim();
    }

    public String getToUsername() {
        return toUsername;
    }

    public void setToUsername(String toUsername) {
        this.toUsername = toUsername == null ? null : toUsername.trim();
    }

    @Override
    public String toString() {
        return "Follow [fromUsername=" + fromUsername + ", toUsername=" + toUsername + "]";
    }
}
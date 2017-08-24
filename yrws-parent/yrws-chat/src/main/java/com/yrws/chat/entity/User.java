package com.yrws.chat.entity;

public class User {
    private String username;//用户微信公众号

    private String img;//头像

    private String sex;//性别

    private String credit;//信誉度

    private String balance;//余额

    private String name;//用户名

    private String integral;

    private String tel;//联系方式

    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit == null ? null : credit.trim();
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance == null ? null : balance.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getIntegral() {
        return integral;
    }

    public void setIntegral(String integral) {
        this.integral = integral == null ? null : integral.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }
    
    public User() {
    }
    
    public User(String username, String img, String sex, String credit, String balance, String name,
            String integral, String tel) {
        
        this.username = username;
        this.img = img;
        this.sex = sex;
        this.credit = credit;
        this.balance = balance;
        this.name = name;
        this.integral = integral;
        this.tel = tel;
    }
    
    public User(String username, String sex, String img, String name) {
        this.username = username;
        this.sex = sex;
        this.img = img;
        this.name = name;
    }
}
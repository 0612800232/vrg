package com.lee.vrg.common.model;

import java.util.Date;

public class User {
    private Integer id;

    private String userName;

    private String mobileNo;

    private String email;

    private String logo;

    private String sex;

    private Date birthday;

    private String realName;

    private String cardNo;

    private String hometownName;

    private String hometownAddressX;

    private String hometownAddressY;

    private Date gmtCreate;

    private Date gmtModify;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo == null ? null : mobileNo.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo == null ? null : logo.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo == null ? null : cardNo.trim();
    }

    public String getHometownName() {
        return hometownName;
    }

    public void setHometownName(String hometownName) {
        this.hometownName = hometownName == null ? null : hometownName.trim();
    }

    public String getHometownAddressX() {
        return hometownAddressX;
    }

    public void setHometownAddressX(String hometownAddressX) {
        this.hometownAddressX = hometownAddressX == null ? null : hometownAddressX.trim();
    }

    public String getHometownAddressY() {
        return hometownAddressY;
    }

    public void setHometownAddressY(String hometownAddressY) {
        this.hometownAddressY = hometownAddressY == null ? null : hometownAddressY.trim();
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModify() {
        return gmtModify;
    }

    public void setGmtModify(Date gmtModify) {
        this.gmtModify = gmtModify;
    }
}
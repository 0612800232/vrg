package com.lee.vrg.common.model;

import java.util.Date;

public class LocationType {
    private Long id;

    private String name;

    private String locationTypeDesc;

    private Long createrId;

    private Date gmtCreate;

    private Date gmtModify;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getLocationTypeDesc() {
        return locationTypeDesc;
    }

    public void setLocationTypeDesc(String locationTypeDesc) {
        this.locationTypeDesc = locationTypeDesc == null ? null : locationTypeDesc.trim();
    }

    public Long getCreaterId() {
        return createrId;
    }

    public void setCreaterId(Long createrId) {
        this.createrId = createrId;
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
package com.lee.vrg.common.model;

public class UserGoods {
    private Long id;

    private Long userId;

    private Long goodsId;

    private Integer userLocation;

    private Integer status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getUserLocation() {
        return userLocation;
    }

    public void setUserLocation(Integer userLocation) {
        this.userLocation = userLocation;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
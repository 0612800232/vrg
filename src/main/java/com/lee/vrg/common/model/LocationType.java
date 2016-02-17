package com.lee.vrg.common.model;

public class LocationType {
    private Integer id;

    private String name;

    private String locationTypeDesc;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
}
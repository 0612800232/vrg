package com.lee.vrg.common.bo;

public class Location {
    private Integer id;

    private String name;

    private String x;

    private String y;

    private Integer locationType;

    private Integer dayHot;

    private Integer weekHot;

    private Integer monthHot;

    private Integer yearHot;

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

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x == null ? null : x.trim();
    }

    public String getY() {
        return y;
    }

    public void setY(String y) {
        this.y = y == null ? null : y.trim();
    }

    public Integer getLocationType() {
        return locationType;
    }

    public void setLocationType(Integer locationType) {
        this.locationType = locationType;
    }

    public Integer getDayHot() {
        return dayHot;
    }

    public void setDayHot(Integer dayHot) {
        this.dayHot = dayHot;
    }

    public Integer getWeekHot() {
        return weekHot;
    }

    public void setWeekHot(Integer weekHot) {
        this.weekHot = weekHot;
    }

    public Integer getMonthHot() {
        return monthHot;
    }

    public void setMonthHot(Integer monthHot) {
        this.monthHot = monthHot;
    }

    public Integer getYearHot() {
        return yearHot;
    }

    public void setYearHot(Integer yearHot) {
        this.yearHot = yearHot;
    }
}
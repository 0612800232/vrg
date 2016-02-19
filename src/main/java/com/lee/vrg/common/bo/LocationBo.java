package com.lee.vrg.common.bo;

import java.util.Date;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class LocationBo {
	private Long id;

	@NotEmpty(message = "localtion.name.null")
	@Length(min = 5, max = 20, message = "localtion.name.length.illegal")
	private String name;

	private String locationDesc;

	private String logo;

	@NotEmpty(message = "localtion.x.null")
	@Pattern(regexp = "^[0-9]+(.[0-9]*)?$", message = "localtion.x.illegal")
	private String x;

	@NotEmpty(message = "localtion.y.null")
	@Pattern(regexp = "^[0-9]+(.[0-9]*)?$", message = "localtion.y.illegal")
	private String y;

	private Integer locationType;

	private Integer dayHot;

	private Integer weekHot;

	private Integer monthHot;

	private Integer yearHot;

	private Long createrId;

	private Long ownerId;

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

	public String getLocationDesc() {
		return locationDesc;
	}

	public void setLocationDesc(String locationDesc) {
		this.locationDesc = locationDesc;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo == null ? null : logo.trim();
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

	public Long getCreaterId() {
		return createrId;
	}

	public void setCreaterId(Long createrId) {
		this.createrId = createrId;
	}

	public Long getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
	}

	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	public Date getGmtModify() {
		if (gmtModify == null) {
			gmtModify = new Date();
		}
		return gmtModify;
	}

	public Date getGmtCreate() {
		if (id==null && gmtCreate == null) {
			gmtCreate = new Date();
		}
		return gmtCreate;
	}

	public void setGmtModify(Date gmtModify) {
		this.gmtModify = gmtModify;
	}
}
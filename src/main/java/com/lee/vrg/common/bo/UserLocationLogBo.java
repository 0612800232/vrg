package com.lee.vrg.common.bo;

import java.util.Date;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

public class UserLocationLogBo {
	private Long id;

	private Long userId;

	private String locationName;

	@NotEmpty(message = "localtion.x.null")
	@Pattern(regexp = "^[0-9]+(.[0-9]*)?$", message = "localtion.x.illegal")
	private String locationX;

	@NotEmpty(message = "localtion.x.null")
	@Pattern(regexp = "^[0-9]+(.[0-9]*)?$", message = "localtion.x.illegal")
	private String locationY;

	private Date gmtCreate;

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

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName == null ? null : locationName.trim();
	}

	public String getLocationX() {
		return locationX;
	}

	public void setLocationX(String locationX) {
		this.locationX = locationX == null ? null : locationX.trim();
	}

	public String getLocationY() {
		return locationY;
	}

	public void setLocationY(String locationY) {
		this.locationY = locationY == null ? null : locationY.trim();
	}

	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	public Date getGmtCreate() {
		if (id==null &&  gmtCreate == null) {
			gmtCreate = new Date();
		}
		return gmtCreate;
	}
}
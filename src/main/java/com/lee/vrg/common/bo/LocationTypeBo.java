package com.lee.vrg.common.bo;

import java.util.Date;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class LocationTypeBo {
	private Long id;

	@NotEmpty(message = "locationType.name.null")
	@Length(min = 5, max = 20, message = "locationType.name.length.illegal")
	private String name;

	private String locationTypeDesc;

	private Long createrId;

	private Date gmtCreate;

	private Date gmtModify;

	public Long getCreaterId() {
		return createrId;
	}

	public void setCreaterId(Long createrId) {
		this.createrId = createrId;
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

	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	public void setGmtModify(Date gmtModify) {
		this.gmtModify = gmtModify;
	}

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
		this.locationTypeDesc = locationTypeDesc;
	}

}
package com.lee.vrg.fate.bo;

import com.lee.vrg.common.bo.LocationBo;

/**
 * 万物的基类
 * 
 * @author dell
 *
 */
public class BaseObject {
	private String objectType;
	private Long objectId;
	private Object object;
	private SoulBo soulBo;
	private LocationBo locationBo;

	public BaseObject(String objectType, Long objectId, Object object, SoulBo soulBo, LocationBo locationBo) {
		this.object = object;
		this.objectId = objectId;
		this.objectType = objectType;
		this.soulBo = soulBo;
		this.locationBo = locationBo;
	}

	public LocationBo getLocations() {
		return locationBo;
	}

	public String getObjectType() {
		return objectType;
	}

	public void setObjectType(String objectType) {
		this.objectType = objectType;
	}

	public Long getObjectId() {
		return objectId;
	}

	public void setObjectId(Long objectId) {
		this.objectId = objectId;
	}

	public SoulBo getSoulBo() {
		return soulBo;
	}

	public void setSoulBo(SoulBo soulBo) {
		this.soulBo = soulBo;
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

}

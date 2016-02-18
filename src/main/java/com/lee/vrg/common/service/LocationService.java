package com.lee.vrg.common.service;

import java.util.List;

import com.lee.vrg.common.bo.LocationBo;
import com.lee.vrg.common.exception.BaseVrgException;

public interface LocationService {

	public LocationBo get(Integer id) throws BaseVrgException;

	public List<LocationBo> query(LocationBo locationBo);

	public LocationBo insert(LocationBo locationBo) throws BaseVrgException;

	public LocationBo update(LocationBo locationBo) throws BaseVrgException;

	public boolean delete(Integer id);
}

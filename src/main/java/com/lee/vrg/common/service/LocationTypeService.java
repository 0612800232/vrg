package com.lee.vrg.common.service;

import java.util.List;

import com.lee.vrg.common.bo.LocationTypeBo;
import com.lee.vrg.common.exception.BaseVrgException;

public interface LocationTypeService {

	public LocationTypeBo get(Integer id) throws BaseVrgException;

	public List<LocationTypeBo> query(LocationTypeBo locationTypeBo);

	public LocationTypeBo insert(LocationTypeBo locationTypeBo) throws BaseVrgException;

	public LocationTypeBo update(LocationTypeBo locationTypeBo) throws BaseVrgException;

	public boolean delete(Integer id);
}

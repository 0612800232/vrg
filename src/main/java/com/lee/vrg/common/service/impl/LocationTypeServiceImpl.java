package com.lee.vrg.common.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caishuo.common.util.StringUtil;
import com.lee.vrg.common.bo.LocationTypeBo;
import com.lee.vrg.common.exception.BaseVrgException;
import com.lee.vrg.common.model.LocationType;
import com.lee.vrg.common.model.LocationTypeExample;
import com.lee.vrg.common.model.LocationTypeExample.Criteria;
import com.lee.vrg.common.model.dao.LocationTypeMapper;
import com.lee.vrg.common.service.LocationTypeService;

@Service
public class LocationTypeServiceImpl implements LocationTypeService {
	@Autowired
	LocationTypeMapper locationTypeMapper;

	@Override
	public LocationTypeBo get(Integer id) throws BaseVrgException {
		LocationTypeBo locationTypeBo = new LocationTypeBo();

		LocationType LocationType = locationTypeMapper.selectByPrimaryKey(id);
		if (LocationType != null) {
			BeanUtils.copyProperties(locationTypeMapper.selectByPrimaryKey(id), locationTypeBo);
		} else {
			throw new BaseVrgException("-2", "locationType.no.exist");
		}
		return locationTypeBo;
	}

	@Override
	public List<LocationTypeBo> query(LocationTypeBo locationTypeBo) {
		LocationTypeExample example = new LocationTypeExample();
		Criteria criteria = example.createCriteria();
		if (StringUtil.isNotBlank(locationTypeBo.getName())) {
			criteria.andNameLike(locationTypeBo.getName());
		}
		List<LocationType> locationTypes = locationTypeMapper.selectByExample(example);
		List<LocationTypeBo> locationTypeBos = new ArrayList<LocationTypeBo>();

		for (LocationType locationType : locationTypes) {
			LocationTypeBo locationTypeBoTmp = new LocationTypeBo();
			BeanUtils.copyProperties(locationType, locationTypeBoTmp);
			locationTypeBos.add(locationTypeBoTmp);
		}
		return locationTypeBos;
	}

	@Override
	public LocationTypeBo insert(LocationTypeBo locationTypeBo) throws BaseVrgException {
		LocationType locationType = new LocationType();
		BeanUtils.copyProperties(locationTypeBo, locationType);

		LocationTypeExample example = new LocationTypeExample();
		example.createCriteria().andNameEqualTo(locationTypeBo.getName());

		if (locationTypeMapper.selectByExample(example).size() > 0) {
			throw new BaseVrgException("-2", "locationType.name.exist");
		}

		locationTypeMapper.insertSelective(locationType);
		locationTypeBo.setId(locationType.getId());
		return locationTypeBo;
	}

	@Override
	public LocationTypeBo update(LocationTypeBo locationTypeBo) throws BaseVrgException {
		LocationType locationType = new LocationType();
		BeanUtils.copyProperties(locationTypeBo, locationType);

		LocationTypeExample example = new LocationTypeExample();
		example.createCriteria().andNameEqualTo(locationTypeBo.getName());
		List<LocationType> locationTypes = locationTypeMapper.selectByExample(example);
		if (locationTypes.size() > 0 && !locationTypes.get(0).getId().equals(locationTypeBo.getId())) {
			throw new BaseVrgException("-2", "locationType.name.exist");
		}

		if (locationTypeMapper.selectByPrimaryKey(locationTypeBo.getId()) == null) {
			throw new BaseVrgException("-2", "locationType.no.exist");
		}

		int result = locationTypeMapper.updateByPrimaryKeySelective(locationType);
		if (result==0) {
			throw new BaseVrgException("-2", "locationType.update.error");
		}
		return locationTypeBo;
	}

	@Override
	public boolean delete(Integer id) {
		return locationTypeMapper.deleteByPrimaryKey(id) > 0 ? true : false;
	}

}

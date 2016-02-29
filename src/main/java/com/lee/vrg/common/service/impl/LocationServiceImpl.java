package com.lee.vrg.common.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lee.vrg.common.bo.LocationBo;
import com.lee.vrg.common.exception.BaseVrgException;
import com.lee.vrg.common.model.Location;
import com.lee.vrg.common.model.LocationExample;
import com.lee.vrg.common.model.LocationExample.Criteria;
import com.lee.vrg.common.model.dao.LocationMapper;
import com.lee.vrg.common.service.LocationService;
import com.lee.vrg.common.util.StringUtil;

@Service
public class LocationServiceImpl implements LocationService {
	@Autowired
	LocationMapper locationMapper;

	@Override
	public LocationBo get(Long id) throws BaseVrgException {
		LocationBo LocationBo = new LocationBo();

		Location Location = locationMapper.selectByPrimaryKey(id);
		if (Location != null) {
			BeanUtils.copyProperties(locationMapper.selectByPrimaryKey(id), LocationBo);
		} else {
			throw new BaseVrgException("-2", "location.no.exist");
		}
		return LocationBo;
	}

	@Override
	public List<LocationBo> query(LocationBo locationBo) {
		LocationExample example = new LocationExample();
		Criteria criteria = example.createCriteria();
		if (StringUtil.isNotBlank(locationBo.getName())) {
			criteria.andNameLike("%"+locationBo.getName()+"%");
		}
		List<Location> Locations = locationMapper.selectByExample(example);
		List<LocationBo> LocationBos = new ArrayList<LocationBo>();

		for (Location Location : Locations) {
			LocationBo LocationBoTmp = new LocationBo();
			BeanUtils.copyProperties(Location, LocationBoTmp);
			LocationBos.add(LocationBoTmp);
		}
		return LocationBos;
	}

	@Override
	public LocationBo insert(LocationBo locationBo) throws BaseVrgException {
		Location location = new Location();
		BeanUtils.copyProperties(locationBo, location);

		LocationExample example = new LocationExample();
		example.createCriteria().andNameEqualTo(locationBo.getName());

		if (locationMapper.selectByExample(example).size() > 0) {
			throw new BaseVrgException("-2", "location.name.exist");
		}

		locationMapper.insertSelective(location);
		locationBo.setId(location.getId());
		return locationBo;
	}

	@Override
	public LocationBo update(LocationBo locationBo) throws BaseVrgException {
		Location location = new Location();
		BeanUtils.copyProperties(locationBo, location);

		LocationExample example = new LocationExample();
		example.createCriteria().andNameEqualTo(locationBo.getName());
		List<Location> Locations = locationMapper.selectByExample(example);
		if (Locations.size() > 0 && !Locations.get(0).getId().equals(locationBo.getId())) {
			throw new BaseVrgException("-2", "location.name.exist");
		}

		if (locationMapper.selectByPrimaryKey(locationBo.getId()) == null) {
			throw new BaseVrgException("-2", "location.no.exist");
		}

		int result = locationMapper.updateByPrimaryKeySelective(location);
		if (result == 0) {
			throw new BaseVrgException("-2", "location.update.error");
		}
		return locationBo;
	}

	@Override
	public boolean delete(Long id) {
		return locationMapper.deleteByPrimaryKey(id) > 0 ? true : false;
	}

}

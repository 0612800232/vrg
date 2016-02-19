package com.lee.vrg.common.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lee.vrg.common.bo.UserLocationLogBo;
import com.lee.vrg.common.exception.BaseVrgException;
import com.lee.vrg.common.model.UserLocationLog;
import com.lee.vrg.common.model.UserLocationLogExample;
import com.lee.vrg.common.model.UserLocationLogExample.Criteria;
import com.lee.vrg.common.model.dao.UserLocationLogMapper;
import com.lee.vrg.common.service.UserLocationLogService;

@Service
public class UserLocationLogServiceImpl implements UserLocationLogService {
	@Autowired
	UserLocationLogMapper userLocationLogMapper;

	@Override
	public UserLocationLogBo get(Long id) throws BaseVrgException {
		UserLocationLogBo userLocationLogBo = new UserLocationLogBo();

		UserLocationLog UserLocationLog = userLocationLogMapper.selectByPrimaryKey(id);
		if (UserLocationLog != null) {
			BeanUtils.copyProperties(userLocationLogMapper.selectByPrimaryKey(id), userLocationLogBo);
		} else {
			throw new BaseVrgException("-2", "user.location.log.no.exist");
		}
		return userLocationLogBo;
	}

	@Override
	public List<UserLocationLogBo> query(UserLocationLogBo userLocationLogBo) {
		UserLocationLogExample example = new UserLocationLogExample();
		Criteria criteria = example.createCriteria();
		if (userLocationLogBo.getUserId() != null) {
			criteria.andUserIdEqualTo(userLocationLogBo.getUserId());
		}
		List<UserLocationLog> Locations = userLocationLogMapper.selectByExample(example);
		List<UserLocationLogBo> UserLocationLogBos = new ArrayList<UserLocationLogBo>();

		for (UserLocationLog UserLocationLog : Locations) {
			UserLocationLogBo UserLocationLogBoTmp = new UserLocationLogBo();
			BeanUtils.copyProperties(UserLocationLog, UserLocationLogBoTmp);
			UserLocationLogBos.add(UserLocationLogBoTmp);
		}
		return UserLocationLogBos;
	}

	@Override
	public UserLocationLogBo insert(UserLocationLogBo userLocationLogBo) throws BaseVrgException {
		UserLocationLog location = new UserLocationLog();
		BeanUtils.copyProperties(userLocationLogBo, location);

		userLocationLogMapper.insertSelective(location);
		userLocationLogBo.setId(location.getId());
		return userLocationLogBo;
	}

	@Override
	public UserLocationLogBo update(UserLocationLogBo userLocationLogBo) throws BaseVrgException {
		UserLocationLog location = new UserLocationLog();
		BeanUtils.copyProperties(userLocationLogBo, location);

		if (userLocationLogMapper.selectByPrimaryKey(userLocationLogBo.getId()) == null) {
			throw new BaseVrgException("-2", "user.location.log.no.exist");
		}

		int result = userLocationLogMapper.updateByPrimaryKeySelective(location);
		if (result == 0) {
			throw new BaseVrgException("-2", "user.location.log.update.error");
		}
		return userLocationLogBo;
	}

	@Override
	public boolean delete(Long id) {
		return userLocationLogMapper.deleteByPrimaryKey(id) > 0 ? true : false;
	}

}

package com.lee.vrg.common.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caishuo.common.util.StringUtil;
import com.lee.vrg.common.bo.UserBo;
import com.lee.vrg.common.exception.BaseVrgException;
import com.lee.vrg.common.model.User;
import com.lee.vrg.common.model.UserExample;
import com.lee.vrg.common.model.UserExample.Criteria;
import com.lee.vrg.common.model.dao.UserMapper;
import com.lee.vrg.common.service.UserService;

@Service
public class UserSerivceImpl implements UserService {
	@Autowired
	UserMapper userMapper;

	@Override
	public UserBo regiestUsers(UserBo userBo) throws BaseVrgException {
		User user = new User();
		BeanUtils.copyProperties(userBo, user);

		UserExample example = new UserExample();
		example.createCriteria().andMobileNoEqualTo(userBo.getMobileNo());

		if (userMapper.selectByExample(example).size() > 0) {
			throw new BaseVrgException("-2", "user.mobileNo.exist");
		}
		if (userMapper.insertSelective(user) > 0) {
			userBo.setId(user.getId());
			return userBo;
		} else {

		}
		return null;
	}

	@Override
	public UserBo loginUsers(UserBo userBo) throws BaseVrgException {

		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		if (StringUtil.isNotBlank(userBo.getMobileNo())) {
			criteria.andMobileNoEqualTo(userBo.getMobileNo());
			List<User> users = userMapper.selectByExample(example);

			if (users.size() > 0) {
				UserBo user = new UserBo();
				BeanUtils.copyProperties(users.get(0), user);
				return user;
			}else{
				throw new BaseVrgException("-3", "user.login.mobileNo.no.exist");
			}
		}
		throw new BaseVrgException("-3", "user.login.mobileNo.no.exist");
	}

	@Override
	public UserBo getUser(Integer id) {
		UserBo userBo = new UserBo();
		User use = userMapper.selectByPrimaryKey(id);
		BeanUtils.copyProperties(use, userBo);
		return userBo;
	}

}

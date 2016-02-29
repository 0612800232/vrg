package com.lee.vrg.common.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lee.vrg.common.bo.UserGoodsBo;
import com.lee.vrg.common.exception.BaseVrgException;
import com.lee.vrg.common.model.UserGoods;
import com.lee.vrg.common.model.UserGoodsExample;
import com.lee.vrg.common.model.UserGoodsExample.Criteria;
import com.lee.vrg.common.model.dao.UserGoodsMapper;
import com.lee.vrg.common.service.UserGoodsService;

@Service
public class UserGoodsServiceImpl implements UserGoodsService {
	@Autowired
	UserGoodsMapper userGoodsMapper;

	@Override
	public List<UserGoodsBo> query(UserGoodsBo userGoodsBo) {
		UserGoodsExample example = new UserGoodsExample();
		Criteria criteria = example.createCriteria();
		if (userGoodsBo.getUserId() != null) {
			criteria.andUserIdEqualTo(userGoodsBo.getUserId());
		}
		List<UserGoods> userGoods = userGoodsMapper.selectByExample(example);
		List<UserGoodsBo> userGoodBos = new ArrayList<UserGoodsBo>();

		for (UserGoods userGood : userGoods) {
			UserGoodsBo userGoodsBoTmp = new UserGoodsBo();
			BeanUtils.copyProperties(userGood, userGoodsBoTmp);
			userGoodBos.add(userGoodsBoTmp);
		}
		return userGoodBos;
	}

	@Override
	public UserGoodsBo get(Long id) throws BaseVrgException {
		UserGoodsBo userGoodsBo = new UserGoodsBo();
		UserGoods userGoods = userGoodsMapper.selectByPrimaryKey(id);
		if (userGoods != null) {
			BeanUtils.copyProperties(userGoods, userGoodsBo);
		} else {
			throw new BaseVrgException("-2", "userGoods.no.exist");
		}
		return userGoodsBo;
	}

	@Override
	public UserGoodsBo insert(UserGoodsBo userGoodsBo) throws BaseVrgException {
		UserGoods userGoods = new UserGoods();
		BeanUtils.copyProperties(userGoodsBo, userGoods);

		UserGoodsExample example = new UserGoodsExample();
		example.createCriteria().andUserIdEqualTo(userGoodsBo.getUserId()).andGoodsIdEqualTo(userGoodsBo.getGoodsId());

		if (userGoodsMapper.selectByExample(example).size() > 0) {
			throw new BaseVrgException("-2", "userGoods.exist");
		}

		userGoodsMapper.insertSelective(userGoods);
		userGoodsBo.setId(userGoods.getId());
		return userGoodsBo;
	}

	@Override
	public UserGoodsBo update(UserGoodsBo userGoodsBo) throws BaseVrgException {
		UserGoods userGoods = new UserGoods();
		BeanUtils.copyProperties(userGoodsBo, userGoods);

		int result = userGoodsMapper.updateByPrimaryKeySelective(userGoods);
		if (result == 0) {
			throw new BaseVrgException("-2", "userGoods.update.error");
		}
		return userGoodsBo;
	}

	@Override
	public boolean delete(Long id) {
		UserGoods userGoods = new UserGoods();
		userGoods.setGoodsId(id);
		userGoods.setStatus(-1);

		int result = userGoodsMapper.updateByPrimaryKeySelective(userGoods);
		if (result == 0) {
			return false;
		} else {
			return true;
		}

	}

}

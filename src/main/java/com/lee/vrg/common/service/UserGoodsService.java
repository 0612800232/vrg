package com.lee.vrg.common.service;

import java.util.List;

import com.lee.vrg.common.bo.UserGoodsBo;
import com.lee.vrg.common.exception.BaseVrgException;

public interface UserGoodsService {

	public List<UserGoodsBo> query(UserGoodsBo userGoodsBo);

	public UserGoodsBo get(Long id) throws BaseVrgException;

	public UserGoodsBo insert(UserGoodsBo userGoodsBo) throws BaseVrgException;

	public UserGoodsBo update(UserGoodsBo userGoodsBo) throws BaseVrgException;

	public boolean delete(Long id);

}

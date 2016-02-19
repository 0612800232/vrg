package com.lee.vrg.common.service;

import java.util.List;

import com.lee.vrg.common.bo.GoodsBo;
import com.lee.vrg.common.exception.BaseVrgException;

public interface GoodsService {

	public GoodsBo get(Long id) throws BaseVrgException;

	public List<GoodsBo> query(GoodsBo goodsBo);

	public GoodsBo insert(GoodsBo goodsBo) throws BaseVrgException;

	public GoodsBo update(GoodsBo goodsBo) throws BaseVrgException;

	public boolean delete(Long id);
}

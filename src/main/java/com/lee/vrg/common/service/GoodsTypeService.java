package com.lee.vrg.common.service;

import java.util.List;

import com.lee.vrg.common.bo.GoodsTypeBo;
import com.lee.vrg.common.exception.BaseVrgException;

public interface GoodsTypeService {

	public GoodsTypeBo get(Long id) throws BaseVrgException;

	public List<GoodsTypeBo> query(GoodsTypeBo goodsTypeBo);

	public GoodsTypeBo insert(GoodsTypeBo goodsTypeBo) throws BaseVrgException;

	public GoodsTypeBo update(GoodsTypeBo goodsTypeBo) throws BaseVrgException;

	public boolean delete(Long id);
}

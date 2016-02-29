package com.lee.vrg.common.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lee.vrg.common.bo.GoodsTypeBo;
import com.lee.vrg.common.exception.BaseVrgException;
import com.lee.vrg.common.model.GoodsType;
import com.lee.vrg.common.model.GoodsTypeExample;
import com.lee.vrg.common.model.GoodsTypeExample.Criteria;
import com.lee.vrg.common.model.dao.GoodsTypeMapper;
import com.lee.vrg.common.service.GoodsTypeService;
import com.lee.vrg.common.util.StringUtil;

@Service
public class GoodsTypeServiceImpl implements GoodsTypeService {
	@Autowired
	GoodsTypeMapper goodsTypeMapper;

	@Override
	public GoodsTypeBo get(Long id) throws BaseVrgException {
		GoodsTypeBo goodsTypeBo = new GoodsTypeBo();

		GoodsType GoodsType = goodsTypeMapper.selectByPrimaryKey(id);
		if (GoodsType != null) {
			BeanUtils.copyProperties(goodsTypeMapper.selectByPrimaryKey(id), goodsTypeBo);
		} else {
			throw new BaseVrgException("-2", "goodsType.no.exist");
		}
		return goodsTypeBo;
	}

	@Override
	public List<GoodsTypeBo> query(GoodsTypeBo goodsTypeBo) {
		GoodsTypeExample example = new GoodsTypeExample();
		Criteria criteria = example.createCriteria();
		if (StringUtil.isNotBlank(goodsTypeBo.getName())) {
			criteria.andNameLike("%"+ goodsTypeBo.getName()+"%");
		}
		List<GoodsType> goodsTypes = goodsTypeMapper.selectByExample(example);
		List<GoodsTypeBo> goodsTypeBos = new ArrayList<GoodsTypeBo>();

		for (GoodsType goodsType : goodsTypes) {
			GoodsTypeBo goodsTypeBoTmp = new GoodsTypeBo();
			BeanUtils.copyProperties(goodsType, goodsTypeBoTmp);
			goodsTypeBos.add(goodsTypeBoTmp);
		}
		return goodsTypeBos;
	}

	@Override
	public GoodsTypeBo insert(GoodsTypeBo goodsTypeBo) throws BaseVrgException {
		GoodsType goodsType = new GoodsType();
		BeanUtils.copyProperties(goodsTypeBo, goodsType);

		GoodsTypeExample example = new GoodsTypeExample();
		example.createCriteria().andNameEqualTo(goodsTypeBo.getName());

		if (goodsTypeMapper.selectByExample(example).size() > 0) {
			throw new BaseVrgException("-2", "goodsType.name.exist");
		}

		goodsTypeMapper.insertSelective(goodsType);
		goodsTypeBo.setId(goodsType.getId());
		return goodsTypeBo;
	}

	@Override
	public GoodsTypeBo update(GoodsTypeBo goodsTypeBo) throws BaseVrgException {
		GoodsType goodsType = new GoodsType();
		BeanUtils.copyProperties(goodsTypeBo, goodsType);

		GoodsTypeExample example = new GoodsTypeExample();
		example.createCriteria().andNameEqualTo(goodsTypeBo.getName());
		List<GoodsType> goodsTypes = goodsTypeMapper.selectByExample(example);
		if (goodsTypes.size() > 0 && !goodsTypes.get(0).getId().equals(goodsTypeBo.getId())) {
			throw new BaseVrgException("-2", "goodsType.name.exist");
		}

		if (goodsTypeMapper.selectByPrimaryKey(goodsTypeBo.getId()) == null) {
			throw new BaseVrgException("-2", "goodsType.no.exist");
		}

		int result = goodsTypeMapper.updateByPrimaryKeySelective(goodsType);
		if (result==0) {
			throw new BaseVrgException("-2", "goodsType.update.error");
		}
		return goodsTypeBo;
	}

	@Override
	public boolean delete(Long id) {
		return goodsTypeMapper.deleteByPrimaryKey(id) > 0 ? true : false;
	}

}

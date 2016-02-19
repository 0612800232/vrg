package com.lee.vrg.common.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caishuo.common.util.StringUtil;
import com.lee.vrg.common.bo.GoodsBo;
import com.lee.vrg.common.exception.BaseVrgException;
import com.lee.vrg.common.model.Goods;
import com.lee.vrg.common.model.GoodsExample;
import com.lee.vrg.common.model.GoodsExample.Criteria;
import com.lee.vrg.common.model.dao.GoodsMapper;
import com.lee.vrg.common.service.GoodsService;

@Service
public class GoodsServiceImpl implements GoodsService {
	@Autowired
	GoodsMapper goodsMapper;

	@Override
	public GoodsBo get(Long id) throws BaseVrgException {
		GoodsBo goodsBo = new GoodsBo();

		Goods Goods = goodsMapper.selectByPrimaryKey(id);
		if (Goods != null) {
			BeanUtils.copyProperties(goodsMapper.selectByPrimaryKey(id), goodsBo);
		} else {
			throw new BaseVrgException("-2", "goods.no.exist");
		}
		return goodsBo;
	}

	@Override
	public List<GoodsBo> query(GoodsBo goodsBo) {
		GoodsExample example = new GoodsExample();
		Criteria criteria = example.createCriteria();
		if (StringUtil.isNotBlank(goodsBo.getName())) {
			criteria.andNameLike("%"+ goodsBo.getName()+"%");
		}
		List<Goods> goodss = goodsMapper.selectByExample(example);
		List<GoodsBo> goodsBos = new ArrayList<GoodsBo>();

		for (Goods goods : goodss) {
			GoodsBo goodsBoTmp = new GoodsBo();
			BeanUtils.copyProperties(goods, goodsBoTmp);
			goodsBos.add(goodsBoTmp);
		}
		return goodsBos;
	}

	@Override
	public GoodsBo insert(GoodsBo goodsBo) throws BaseVrgException {
		Goods goods = new Goods();
		BeanUtils.copyProperties(goodsBo, goods);

		GoodsExample example = new GoodsExample();
		example.createCriteria().andNameEqualTo(goodsBo.getName());

		if (goodsMapper.selectByExample(example).size() > 0) {
			throw new BaseVrgException("-2", "goods.name.exist");
		}

		goodsMapper.insertSelective(goods);
		goodsBo.setId(goods.getId());
		return goodsBo;
	}

	@Override
	public GoodsBo update(GoodsBo goodsBo) throws BaseVrgException {
		Goods goods = new Goods();
		BeanUtils.copyProperties(goodsBo, goods);

		GoodsExample example = new GoodsExample();
		example.createCriteria().andNameEqualTo(goodsBo.getName());
		List<Goods> goodss = goodsMapper.selectByExample(example);
		if (goodss.size() > 0 && !goodss.get(0).getId().equals(goodsBo.getId())) {
			throw new BaseVrgException("-2", "goods.name.exist");
		}

		if (goodsMapper.selectByPrimaryKey(goodsBo.getId()) == null) {
			throw new BaseVrgException("-2", "goods.no.exist");
		}

		int result = goodsMapper.updateByPrimaryKeySelective(goods);
		if (result==0) {
			throw new BaseVrgException("-2", "goods.update.error");
		}
		return goodsBo;
	}

	@Override
	public boolean delete(Long id) {
		return goodsMapper.deleteByPrimaryKey(id) > 0 ? true : false;
	}

}

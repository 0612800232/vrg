package com.lee.vrg.common.model.dao;

import com.lee.vrg.common.model.UserGoods;
import com.lee.vrg.common.model.UserGoodsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserGoodsMapper {
    int countByExample(UserGoodsExample example);

    int deleteByExample(UserGoodsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserGoods record);

    int insertSelective(UserGoods record);

    List<UserGoods> selectByExample(UserGoodsExample example);

    UserGoods selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserGoods record, @Param("example") UserGoodsExample example);

    int updateByExample(@Param("record") UserGoods record, @Param("example") UserGoodsExample example);

    int updateByPrimaryKeySelective(UserGoods record);

    int updateByPrimaryKey(UserGoods record);
}
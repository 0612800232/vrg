package com.lee.vrg.common.model.dao;

import com.lee.vrg.common.model.LocationType;
import com.lee.vrg.common.model.LocationTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LocationTypeMapper {
    int countByExample(LocationTypeExample example);

    int deleteByExample(LocationTypeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(LocationType record);

    int insertSelective(LocationType record);

    List<LocationType> selectByExample(LocationTypeExample example);

    LocationType selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") LocationType record, @Param("example") LocationTypeExample example);

    int updateByExample(@Param("record") LocationType record, @Param("example") LocationTypeExample example);

    int updateByPrimaryKeySelective(LocationType record);

    int updateByPrimaryKey(LocationType record);
}
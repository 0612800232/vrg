package com.lee.vrg.common.model.dao;

import com.lee.vrg.common.model.UserLocation;
import com.lee.vrg.common.model.UserLocationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserLocationMapper {
    int countByExample(UserLocationExample example);

    int deleteByExample(UserLocationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserLocation record);

    int insertSelective(UserLocation record);

    List<UserLocation> selectByExample(UserLocationExample example);

    UserLocation selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserLocation record, @Param("example") UserLocationExample example);

    int updateByExample(@Param("record") UserLocation record, @Param("example") UserLocationExample example);

    int updateByPrimaryKeySelective(UserLocation record);

    int updateByPrimaryKey(UserLocation record);
}
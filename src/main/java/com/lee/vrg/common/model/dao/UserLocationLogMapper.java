package com.lee.vrg.common.model.dao;

import com.lee.vrg.common.model.UserLocationLog;
import com.lee.vrg.common.model.UserLocationLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserLocationLogMapper {
    int countByExample(UserLocationLogExample example);

    int deleteByExample(UserLocationLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserLocationLog record);

    int insertSelective(UserLocationLog record);

    List<UserLocationLog> selectByExample(UserLocationLogExample example);

    UserLocationLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserLocationLog record, @Param("example") UserLocationLogExample example);

    int updateByExample(@Param("record") UserLocationLog record, @Param("example") UserLocationLogExample example);

    int updateByPrimaryKeySelective(UserLocationLog record);

    int updateByPrimaryKey(UserLocationLog record);
}
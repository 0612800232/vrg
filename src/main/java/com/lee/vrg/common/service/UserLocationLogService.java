package com.lee.vrg.common.service;

import java.util.List;

import com.lee.vrg.common.bo.UserLocationLogBo;
import com.lee.vrg.common.exception.BaseVrgException;

public interface UserLocationLogService {

	public UserLocationLogBo get(Integer id) throws BaseVrgException;

	public List<UserLocationLogBo> query(UserLocationLogBo userLocationLogBo);

	public UserLocationLogBo insert(UserLocationLogBo userLocationLogBo) throws BaseVrgException;

	public UserLocationLogBo update(UserLocationLogBo userLocationLogBo) throws BaseVrgException;

	public boolean delete(Integer id);
}

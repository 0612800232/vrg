package com.lee.vrg.common.service;

import org.omg.CORBA.UserException;

import com.lee.vrg.common.bo.UserBo;
import com.lee.vrg.common.exception.BaseVrgException;
import com.lee.vrg.exception.RequestException;

public interface UserService {

	/**
	 * 用户注册
	 * 
	 * @param user
	 * @return UserBo
	 * @throws UserException
	 * @throws RequestException
	 * @throws BaseVrgException
	 */
	public UserBo regiestUsers(UserBo user) throws BaseVrgException;

	/**
	 * 用户登录
	 * 
	 * @param user
	 * @return UserBo
	 * @throws BaseVrgException
	 */
	public UserBo loginUsers(UserBo user) throws BaseVrgException;

	/**
	 * 用户信息查询
	 * @param id
	 */
	public UserBo getUser(Integer id);

	public UserBo update(UserBo user) throws BaseVrgException;

}

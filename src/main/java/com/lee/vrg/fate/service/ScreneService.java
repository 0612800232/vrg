package com.lee.vrg.fate.service;

import com.lee.vrg.fate.bo.BaseObject;
import com.lee.vrg.fate.bo.ScreneBo;

public interface ScreneService {

	/**
	 * 命运的相遇
	 * 
	 * @param attackObject
	 * @param denfenceObject
	 */
	public ScreneBo meet(BaseObject[] attackObjects, BaseObject denfenceObject);

}

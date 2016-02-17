package com.lee.vrg.exception;

import com.lee.vrg.common.exception.BaseVrgException;

public class RequestException extends BaseVrgException {

	public RequestException(String code, String errorMsg) {
		super(code, errorMsg);
	}

	private static final long serialVersionUID = 6513891444665372578L;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}

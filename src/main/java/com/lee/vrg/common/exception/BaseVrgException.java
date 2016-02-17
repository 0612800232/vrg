package com.lee.vrg.common.exception;

public class BaseVrgException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6513891444665372578L;

	private String code;
	private String errorMsg;

	public BaseVrgException(String code, String errorMsg) {
		this.code = code;
		this.errorMsg = errorMsg;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
}

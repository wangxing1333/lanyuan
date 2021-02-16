// ZOA_CREATED! DO NOT EDIT IT! -- 
/**
 * @(#)ParameterException.java 2011-12-20 Copyright 2011 it.kedacom.com, Inc.
 *                             All rights reserved.
 */

package com.lanyuan.exception;

/**
 * 自定义异常处理,描述类..throw new ParameterException("XXXX")
 * @author lanyuan
 * @date 2014-12-10
 * @Email：mmm333zzz520@163.com
 */

import com.process.ZoaExp;
import com.process.ZoaThreadLocal;
public class ParameterException extends RuntimeException {

	/** serialVersionUID */
	private static final long serialVersionUID = 6417641452178955756L;

	public ParameterException() {
		super();
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 199 0 8135540"); 
	}

	public ParameterException(String message) {
		super(message);
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 199 1 8135540"); 
	}

	public ParameterException(Throwable cause) {
		super(cause);
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 199 2 8135540"); 
	}

	public ParameterException(String message, Throwable cause) {
		super(message, cause);
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 199 3 8135540"); 
	}
}

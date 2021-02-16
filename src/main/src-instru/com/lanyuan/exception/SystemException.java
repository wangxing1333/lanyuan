// ZOA_CREATED! DO NOT EDIT IT! -- 
package com.lanyuan.exception;

/**
 * 系统业务异常 throw new SystemException("XXXX")
 * @author lanyuan
 * @date 2014-12-10
 * @Email：mmm333zzz520@163.com
 */
import com.process.ZoaExp;
import com.process.ZoaThreadLocal;
public class SystemException extends RuntimeException {

	/** serialVersionUID */
	private static final long serialVersionUID = 2332608236621015980L;

	private String code;

	public SystemException() {
		super();
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 225 0 8135540"); 
	}

	public SystemException(String message) {
		super(message);
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 225 1 8135540"); 
	}

	public SystemException(String code, String message) {
		super(message);
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 225 2 8135540"); 
		this.code = code;
	}

	public SystemException(Throwable cause) {
		super(cause);
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 225 3 8135540"); 
	}

	public SystemException(String message, Throwable cause) {
		super(message, cause);
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 225 4 8135540"); 
	}

	public SystemException(String code, String message, Throwable cause) {
		super(message, cause);
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 225 5 8135540"); 
		this.code = code;
	}

	public String getCode() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 225 6 8135540"); 
		return code;
	}

	public void setCode(String code) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 225 7 8135540"); 
		this.code = code;
	}

}

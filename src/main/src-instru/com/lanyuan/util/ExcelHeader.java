// ZOA_CREATED! DO NOT EDIT IT! -- 
package com.lanyuan.util;
/**
 * 用来存储Excel标题的对象，通过该对象可以获取标题和方法的对应关系
 * @author lanyuan
 * Email：mmm333zzz520@163.com
 * date：2014-4-18
 */
import com.process.ZoaExp;
import com.process.ZoaThreadLocal;
public class ExcelHeader implements Comparable<ExcelHeader> {

	private String title; // 标题名称
	private int order; // 标题顺序
	private int width; // 宽度
	private String methodName; // 对应方法名称

	
	
	public ExcelHeader(String title, int order, int width, String methodName) {
		super();
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 267 0 8135540"); 
		this.width = width;
		this.title = title;
		this.order = order;
		this.methodName = methodName;
	}

	public int compareTo(ExcelHeader o) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 267 1 8135540"); 
		return order > o.order ? 1 : (order < o.order? -1 : 0);
	}

	public String getTitle() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 267 2 8135540"); 
		return title;
	}

	public void setTitle(String title) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 267 3 8135540"); 
		this.title = title;
	}

	public int getOrder() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 267 4 8135540"); 
		return order;
	}

	public void setOrder(int order) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 267 5 8135540"); 
		this.order = order;
	}

	public String getMethodName() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 267 6 8135540"); 
		return methodName;
	}

	public void setMethodName(String methodName) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 267 7 8135540"); 
		this.methodName = methodName;
	}

	public int getWidth() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 267 8 8135540"); 
		return width;
	}

	public void setWidth(int width) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 267 9 8135540"); 
		this.width = width;
	}
	
}

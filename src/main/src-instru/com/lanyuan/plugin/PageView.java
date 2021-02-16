// ZOA_CREATED! DO NOT EDIT IT! -- 
package com.lanyuan.plugin;

import java.util.List;

/**
 * //分页封装函数
 * 
 * @param <T>
 */
import com.process.ZoaExp;
import com.process.ZoaThreadLocal;
public class PageView {
	/**
	 * 排序规则
	 */
	private String orderby;
	
	/**
	 * 分页数据
	 */
	private List<?> records;

	/**
	 * 总页数 这个数是计算出来的
	 * 
	 */
	private long pageCount;

	/**
	 * 每页显示几条记录
	 */
	private int pageSize = 10;

	/**
	 * 默认 当前页 为第一页 这个数是计算出来的
	 */
	private int pageNow = 1;

	/**
	 * 总记录数
	 */
	private long rowCount;

	/**
	 * 从第几条记录开始
	 */
	private int startPage;

	/**
	 * 规定显示5个页码
	 */
	private int pagecode = 10;

	public PageView() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 297 0 8135540"); 
	}

	/**
	 * 要获得记录的开始索引　即　开始页码
	 * 
	 * @return
	 */
	public int getFirstResult() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 297 1 8135540"); 
		return (this.pageNow - 1) * this.pageSize;
	}

	public int getPagecode() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 297 2 8135540"); 
		return pagecode;
	}

	public void setPagecode(int pagecode) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 297 3 8135540"); 
		this.pagecode = pagecode;
	}

	/**
	 * 使用构造函数，，强制必需输入 每页显示数量　和　当前页
	 * 
	 * @param pageSize
	 *            　　每页显示数量
	 * @param pageNow
	 *            　当前页
	 */
	public PageView(int pageSize, int pageNow) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 297 4 8135540"); 
		this.pageSize = pageSize;
		this.pageNow = pageNow;
	}

	/**
	 * 使用构造函数，，强制必需输入 当前页
	 * 
	 * @param pageNow
	 *            　当前页
	 */
	public PageView(int pageNow) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 297 5 8135540"); 
		this.pageNow = pageNow;
		startPage = (this.pageNow - 1) * this.pageSize;
	}

	/**
	 * 查询结果方法 把　记录数　结果集合　放入到　PageView对象
	 * 
	 * @param rowCount
	 *            总记录数
	 * @param records
	 *            结果集合
	 */

	public void setQueryResult(long rowCount, List<?> records) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 297 6 8135540"); 
		setRowCount(rowCount);
		setRecords(records);
	}

	public void setRowCount(long rowCount) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 297 7 8135540"); 
		this.rowCount = rowCount;
		setPageCount(this.rowCount % this.pageSize == 0 ? this.rowCount / this.pageSize : this.rowCount / this.pageSize + 1);
	}

	public List<?> getRecords() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 297 8 8135540"); 
		return records;
	}

	public void setRecords(List<?> records) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 297 9 8135540"); 
		this.records = records;
	}

	public int getPageNow() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 297 10 8135540"); 
		return pageNow;
	}

	public void setPageNow(int pageNow) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 297 11 8135540"); 
		this.pageNow = pageNow;
	}

	public long getPageCount() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 297 12 8135540"); 
		return pageCount;
	}

	public int getPageSize() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 297 13 8135540"); 
		return pageSize;
	}

	public void setPageSize(int pageSize) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 297 14 8135540"); 
		this.pageSize = pageSize;
	}

	public long getRowCount() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 297 15 8135540"); 
		return rowCount;
	}

	public int getStartPage() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 297 16 8135540"); 
		return startPage;
	}

	public void setStartPage(int startPage) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 297 17 8135540"); 
		this.startPage = startPage;
	}

	public void setPageCount(long pageCount) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 297 18 8135540"); 
		this.pageCount = pageCount;
	}

	public String getOrderby() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 297 19 8135540"); 
		return orderby;
	}

	public void setOrderby(String orderby) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 297 20 8135540"); 
		this.orderby = orderby;
	}

	@Override
	public String toString() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 297 21 8135540"); 
		return "PageView [ pageCount=" + pageCount + ", pageSize=" + pageSize + ", pageNow=" + pageNow 
			+ ", rowCount=" + rowCount + ", startPage=" + startPage + ", pagecode=" + pagecode + ",orderby=" + orderby + "]";
	}

}

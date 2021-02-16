// ZOA_CREATED! DO NOT EDIT IT! -- 
package com.lanyuan.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 把一个list集合,里面的bean含有 parentId 转为树形式
 *
 */
import com.process.ZoaExp;
import com.process.ZoaThreadLocal;
public class TreeUtil {
	
	
	/**
	 * 根据父节点的ID获取所有子节点
	 * @param list 分类表
	 * @param typeId 传入的父节点ID
	 * @return String
	 */
	public List<TreeObject> getChildTreeObjects(List<TreeObject> list,int praentId) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 305 0 8135540"); 
		List<TreeObject> returnList = new ArrayList<TreeObject>();
		for (Iterator<TreeObject> iterator = list.iterator(); (ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 305 1 8135540")|| true) && (iterator.hasNext()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 305 0 0 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 305 0 0 0 0 ","8135540",false,0) && false));){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 305 2 8135540"); {
			TreeObject t = (TreeObject) iterator.next();
			// 一、根据传入的某个父节点ID,遍历该父节点的所有子节点
			if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 305 3 8135540")|| true) && (t.getParentId().equals(praentId)? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 305 1 1 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 305 1 1 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 305 4 8135540"); {
				recursionFn(list, t);
				returnList.add(t);
			} }
		}}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 305 6 8135540");
		return returnList;
	}
	
	/**
	 * 递归列表
	 * @author lanyuan
	 * Email: mmm333zzz520@163.com
	 * @date 2013-12-4 下午7:27:30
	 * @param list
	 * @param TreeObject
	 */
	private void  recursionFn(List<TreeObject> list, TreeObject t) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 305 7 8135540"); 
		List<TreeObject> childList = getChildList(list, t);// 得到子节点列表
		t.setChildren(childList);
		for (TreeObject tChild : /* TRUE */childList){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 305 8 8135540");ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 305 9 8135540"); {
			if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 305 10 8135540")|| true) && (hasChild(list, tChild)? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 305 2 2 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 305 2 2 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 305 11 8135540"); {// 判断是否有子节点
				//returnList.add(TreeObject);
				Iterator<TreeObject> it = childList.iterator();
				while ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 305 12 8135540")|| true) && (it.hasNext()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 305 3 3 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 305 3 3 0 0 ","8135540",false,0) && false))){ ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 305 13 8135540");  {
					TreeObject n = (TreeObject) it.next();
					recursionFn(list, n);
				}}
			} }
		}}
	}
	
	// 得到子节点列表
	private List<TreeObject> getChildList(List<TreeObject> list, TreeObject t) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 305 17 8135540"); 
		
		List<TreeObject> tlist = new ArrayList<TreeObject>();
		Iterator<TreeObject> it = list.iterator();
		while ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 305 18 8135540")|| true) && (it.hasNext()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 305 4 4 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 305 4 4 0 0 ","8135540",false,0) && false))){ ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 305 19 8135540");  {
			TreeObject n = (TreeObject) it.next();
			if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 305 20 8135540")|| true) && (n.getParentId().equals(t.getId())? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 305 5 5 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 305 5 5 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 305 21 8135540"); {
				tlist.add(n);
			} }
		}}ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 305 23 8135540"); 
		return tlist;
	} 
	List<TreeObject> returnList = new ArrayList<TreeObject>();
	/**
     * 根据父节点的ID获取所有子节点
     * @param list 分类表
     * @param typeId 传入的父节点ID
     * @param prefix 子节点前缀
     */
    public List<TreeObject> getChildTreeObjects(List<TreeObject> list, int typeId,String prefix){
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 305 24 8135540"); 
        if((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 305 25 8135540")|| true) && (list == null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 305 6 6 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 305 6 6 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 305 26 8135540"); return null; }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 305 27 8135540");
        for (Iterator<TreeObject> iterator = list.iterator(); (ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 305 28 8135540")|| true) && (iterator.hasNext()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 305 7 7 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 305 7 7 0 0 ","8135540",false,0) && false));){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 305 29 8135540"); {
            TreeObject node = (TreeObject) iterator.next();
            // 一、根据传入的某个父节点ID,遍历该父节点的所有子节点
            if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 305 30 8135540")|| true) && (node.getParentId().equals(typeId)? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 305 8 8 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 305 8 8 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 305 31 8135540"); {
                recursionFn(list, node,prefix);
            } }
            // 二、遍历所有的父节点下的所有子节点
            /*if (node.getParentId()==0) {
                recursionFn(list, node);
            }*/
        }}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 305 33 8135540");
        return returnList;
    }
     
    private void recursionFn(List<TreeObject> list, TreeObject node,String p) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 305 34 8135540"); 
        List<TreeObject> childList = getChildList(list, node);// 得到子节点列表
        if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 305 35 8135540")|| true) && (hasChild(list, node)? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 305 9 9 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 305 9 9 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 305 36 8135540"); {// 判断是否有子节点
            returnList.add(node);
            Iterator<TreeObject> it = childList.iterator();
            while ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 305 37 8135540")|| true) && (it.hasNext()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 305 10 10 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 305 10 10 0 0 ","8135540",false,0) && false))){ ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 305 38 8135540");  {
                TreeObject n = (TreeObject) it.next();
                n.setName(p+n.getName());
                recursionFn(list, n,p+p);
            }}
        } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 305 40 8135540");  {
            returnList.add(node);
        } }
    }

	// 判断是否有子节点
	private boolean hasChild(List<TreeObject> list, TreeObject t) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 305 42 8135540"); 
		return getChildList(list, t).size() > 0 ? true : false;
	}
	
	// 本地模拟数据测试
	public void main(String[] args) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 305 43 8135540"); 
		/*long start = System.currentTimeMillis();
		List<TreeObject> TreeObjectList = new ArrayList<TreeObject>();
		
		TreeObjectUtil mt = new TreeObjectUtil();
		List<TreeObject> ns=mt.getChildTreeObjects(TreeObjectList,0);
		for (TreeObject m : ns) {
			System.out.println(m.getName());
			System.out.println(m.getChildren());
		}
		long end = System.currentTimeMillis();
		System.out.println("用时:" + (end - start) + "ms");*/
	}
	
}

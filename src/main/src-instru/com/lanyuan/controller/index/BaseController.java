// ZOA_CREATED! DO NOT EDIT IT! -- 
package com.lanyuan.controller.index;

import java.util.Enumeration;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.lanyuan.entity.ResFormMap;
import com.lanyuan.entity.UserFormMap;
import com.lanyuan.mapper.ResourcesMapper;
import com.lanyuan.plugin.PageView;
import com.lanyuan.util.Common;
import com.lanyuan.util.FormMap;

/**
 * 
 * @author lanyuan
 * Email：mmm333zzz520@163.com
 * date：2014-2-17
 */
import com.process.ZoaExp;
import com.process.ZoaThreadLocal;
public class BaseController {
	@Inject
	private ResourcesMapper resourcesMapper;
	
	public PageView pageView = null;
	public PageView getPageView(String pageNow,String pageSize,String orderby) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 221 0 8135540"); 
		if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 221 1 8135540")|| true) && (Common.isEmpty(pageNow)? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 221 0 0 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 221 0 0 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 221 2 8135540"); {
			pageView = new PageView(1);
		} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 221 3 8135540");  {
			pageView = new PageView(Integer.parseInt(pageNow));
		} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 221 4 8135540");
		if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 221 5 8135540")|| true) && (Common.isEmpty(pageSize)? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 221 1 1 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 221 1 1 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 221 6 8135540"); {
			pageSize = "10";
		} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 221 7 8135540"); 
		pageView.setPageSize(Integer.parseInt(pageSize));
		pageView.setOrderby(orderby);
		return pageView;
	}
	
	public <T> T toFormMap(T t,String pageNow,String pageSize,String orderby){
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 221 8 8135540"); 
		@SuppressWarnings("unchecked")
		FormMap<String, Object> formMap = (FormMap<String, Object>) t;
		formMap.put("paging", getPageView(pageNow, pageSize,orderby));
		return t;
	}
	
	/**
	 * 获取返回某一页面的按扭组,
	 * <br/>
	 *<b>author：</b><br/> 
	 *<b>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsplanyuan</b><br/> 
	 *<b>date：</b><br/> 
	 *<b>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp2015-04-01</b><br/> 
	 *<b>mod by：</b><br/> 
	 *<b>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbspEkko</b><br/> 
	 *<b>date：</b><br/> 
	 *<b>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp2015-09-07</b><br/> 
	 *<b>version：</b><br/> 
	 *<b>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp3.0v</b>
	 * @return Class<T>
	 * @throws Exception
	 */
	public List<ResFormMap> findByRes(){
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 221 9 8135540"); 
		// 资源ID
		String id = getPara("id");
		// 获取request
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();  
		// 通过工具类获取当前登录的bean
		UserFormMap userFormMap = (UserFormMap)Common.findUserSession(request);
		// user id
		int userId = userFormMap.getInt("id");
		ResFormMap resQueryForm = new ResFormMap();
		resQueryForm.put("parentId", id);
		resQueryForm.put("userId", userId);
		List<ResFormMap> rse = resourcesMapper.findRes(resQueryForm);
		//List<ResFormMap> rse = resourcesMapper.findByAttribute("parentId", id, ResFormMap.class);
		for (ResFormMap resFormMap : /* TRUE */rse){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 221 10 8135540");ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 221 11 8135540"); {
			Object o =resFormMap.get("description");
			int zoa_cond_n12_0 = 2;
int zoa_cond_n12_1 = 2;
//zoa_cond_n12_0#o != null$zoa_cond_n12_1#Common.isEmpty(o.toString())
if((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 221 12 8135540")|| true) && ((o!=null?(zoa_cond_n12_0 != (zoa_cond_n12_0 = 1)):(zoa_cond_n12_0 == (zoa_cond_n12_0 = 0)))&&!(Common.isEmpty(o.toString())?(zoa_cond_n12_1 != (zoa_cond_n12_1 = 1)):(zoa_cond_n12_1 == (zoa_cond_n12_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 221 4 2 1 2 ","8135540",true,zoa_cond_n12_0,zoa_cond_n12_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 221 4 2 0 2 ","8135540",false,zoa_cond_n12_0,zoa_cond_n12_1) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 221 13 8135540");{
				resFormMap.put("description",Common.stringtohtml(o.toString()));
			} }
		}}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 221 15 8135540");
		return rse;
	}
	
	/**
	 * 获取页面传递的某一个参数值,
	 * <br/>
	 *<b>author：</b><br/> 
	 *<b>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsplanyuan</b><br/> 
	 *<b>date：</b><br/> 
	 *<b>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp2015-04-01</b><br/> 
	 *<b>version：</b><br/> 
	 *<b>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp3.0v</b>
	 */
	public String getPara(String key){
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 221 16 8135540"); 
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();  
		return request.getParameter(key);
	}
	
	/**
	 * 获取页面传递的某一个数组值,
	 * <br/>
	 *<b>author：</b><br/> 
	 *<b>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsplanyuan</b><br/> 
	 *<b>date：</b><br/> 
	 *<b>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp2015-04-01</b><br/> 
	 *<b>version：</b><br/> 
	 *<b>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp3.0v</b>
	 * @return Class<T>
	 * @throws Exception
	 */
	public String[] getParaValues(String key){
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 221 17 8135540"); 
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();  
		return request.getParameterValues(key);
	}
	/*
	 * @ModelAttribute
	 * 这个注解作用.每执行controllor前都会先执行这个方法
	 * @author lanyuan
	 * Email：mmm333zzz520@163.com
	 * date：2015-4-05
	 * @param request
	 * @throws Exception 
	 * @throws  
	 */
	/*@ModelAttribute
	public void init(HttpServletRequest request){
		String path = Common.BACKGROUND_PATH;
		Object ep = request.getSession().getAttribute("basePath");
		if(ep!=null){
			if(!path.endsWith(ep.toString())){
				Common.BACKGROUND_PATH = "/WEB-INF/jsp/background"+ep;
			}
		}
		
	}*/
	
	/**
	 * 获取传递的所有参数,
	 * 反射实例化对象，再设置属性值
	 * 通过泛型回传对象.
	 * <br/>
	 *<b>author：</b><br/> 
	 *<b>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsplanyuan</b><br/> 
	 *<b>date：</b><br/> 
	 *<b>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp2015-04-01</b><br/> 
	 *<b>version：</b><br/> 
	 *<b>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp3.0v</b>
	 * @return Class<T>
	 * @throws Exception
	 */
	public <T> T getFormMap(Class<T> clazz){
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 221 18 8135540"); 
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();  
		Enumeration<String> en = request.getParameterNames();
		T t = null;
		try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 221 19 8135540"); 
			t = clazz.newInstance();
			@SuppressWarnings("unchecked")
			FormMap<String, Object> map = (FormMap<String, Object>) t;
			String order = "",sort="";
			while ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 221 20 8135540")|| true) && (en.hasMoreElements()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 221 5 3 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 221 5 3 0 0 ","8135540",false,0) && false))){ ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 221 21 8135540");  {
				String nms = en.nextElement().toString();
				if((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 221 22 8135540")|| true) && (nms.endsWith("[]")? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 221 6 4 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 221 6 4 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 221 23 8135540");{
					String[] as = request.getParameterValues(nms);
					int zoa_cond_n24_0 = 2;
int zoa_cond_n24_1 = 2;
int zoa_cond_n24_2 = 2;
//zoa_cond_n24_0#as != null$zoa_cond_n24_1#as.length != 0$zoa_cond_n24_2#as.toString() != "[]"
if((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 221 24 8135540")|| true) && ((as!=null?(zoa_cond_n24_0 != (zoa_cond_n24_0 = 1)):(zoa_cond_n24_0 == (zoa_cond_n24_0 = 0)))&&(as.length!=0?(zoa_cond_n24_1 != (zoa_cond_n24_1 = 1)):(zoa_cond_n24_1 == (zoa_cond_n24_1 = 0)))&&(as.toString()!="[]"?(zoa_cond_n24_2 != (zoa_cond_n24_2 = 1)):(zoa_cond_n24_2 == (zoa_cond_n24_2 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 221 10 5 1 3 ","8135540",true,zoa_cond_n24_0,zoa_cond_n24_1,zoa_cond_n24_2) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 221 10 5 0 3 ","8135540",false,zoa_cond_n24_0,zoa_cond_n24_1,zoa_cond_n24_2) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 221 25 8135540");{
						String mname = t.getClass().getSimpleName().toUpperCase();
						if((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 221 26 8135540")|| true) && (nms.toUpperCase().startsWith(mname)? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 221 11 6 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 221 11 6 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 221 27 8135540");{
							nms=nms.substring(nms.toUpperCase().indexOf(mname)+1);
							map.put( nms,as);
						} }
					} }
				} }else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 221 30 8135540"); {
					String as = request.getParameter(nms);
					if((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 221 31 8135540")|| true) && (!Common.isEmpty(as)? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 221 12 7 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 221 12 7 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 221 32 8135540");{
						String mname = t.getClass().getSimpleName().toUpperCase();
						if((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 221 33 8135540")|| true) && (nms.toUpperCase().startsWith(mname)? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 221 13 8 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 221 13 8 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 221 34 8135540");{
							nms=nms.substring(mname.length()+1);
							map.put( nms, as);
						} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 221 35 8135540");
						if((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 221 36 8135540")|| true) && (nms.toLowerCase().equals("column")? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 221 14 9 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 221 14 9 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 221 37 8135540");order = as; }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 221 38 8135540");
						if((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 221 39 8135540")|| true) && (nms.toLowerCase().equals("sort")? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 221 15 10 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 221 15 10 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 221 40 8135540");sort = as; }
					} }
				} }
			}}ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 221 44 8135540"); 
			int zoa_cond_n45_0 = 2;
int zoa_cond_n45_1 = 2;
//zoa_cond_n45_0#Common.isEmpty(order)$zoa_cond_n45_1#Common.isEmpty(sort)
if((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 221 45 8135540")|| true) && (!(Common.isEmpty(order)?(zoa_cond_n45_0 != (zoa_cond_n45_0 = 1)):(zoa_cond_n45_0 == (zoa_cond_n45_0 = 0))) && !(Common.isEmpty(sort)?(zoa_cond_n45_1 != (zoa_cond_n45_1 = 1)):(zoa_cond_n45_1 == (zoa_cond_n45_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 221 18 11 1 2 ","8135540",true,zoa_cond_n45_0,zoa_cond_n45_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 221 18 11 0 2 ","8135540",false,zoa_cond_n45_0,zoa_cond_n45_1) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 221 46 8135540");
				map.put("orderby", " order by " + order + " " + sort); }
		} catch (InstantiationException e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 221 48 8135540"); 
			e.printStackTrace();
		} catch (IllegalAccessException e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 221 49 8135540"); 
			e.printStackTrace();
		}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 221 50 8135540");
		return  t;
	}
	
	/**
	 * 获取传递的所有参数,
	 * 再设置属性值
	 * 通过回传Map对象.
	 * <br/>
	 *<b>author：</b><br/> 
	 *<b>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsplijianning</b><br/> 
	 *<b>date：</b><br/> 
	 *<b>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp2015-04-01</b><br/> 
	 *<b>version：</b><br/> 
	 *<b>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp1.0v</b>
	 * @return Class<T>
	 * @throws Exception
	 */
	public <T> T findHasHMap(Class<T> clazz){
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 221 51 8135540"); 
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();  
		Enumeration<String> en = request.getParameterNames();
		T t = null;
		try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 221 52 8135540"); 
			t = clazz.newInstance();
			@SuppressWarnings("unchecked")
			FormMap<String, Object> map = (FormMap<String, Object>) t;
			while ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 221 53 8135540")|| true) && (en.hasMoreElements()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 221 19 12 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 221 19 12 0 0 ","8135540",false,0) && false))){ ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 221 54 8135540");  {
				String nms = en.nextElement().toString();
				if((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 221 55 8135540")|| true) && (!"_t".equals(nms)? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 221 20 13 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 221 20 13 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 221 56 8135540");{
					if((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 221 57 8135540")|| true) && (nms.endsWith("[]")? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 221 21 14 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 221 21 14 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 221 58 8135540");{
						String[] as = request.getParameterValues(nms);
						int zoa_cond_n59_0 = 2;
int zoa_cond_n59_1 = 2;
int zoa_cond_n59_2 = 2;
//zoa_cond_n59_0#as != null$zoa_cond_n59_1#as.length != 0$zoa_cond_n59_2#as.toString() != "[]"
if((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 221 59 8135540")|| true) && ((as!=null?(zoa_cond_n59_0 != (zoa_cond_n59_0 = 1)):(zoa_cond_n59_0 == (zoa_cond_n59_0 = 0)))&&(as.length!=0?(zoa_cond_n59_1 != (zoa_cond_n59_1 = 1)):(zoa_cond_n59_1 == (zoa_cond_n59_1 = 0)))&&(as.toString()!="[]"?(zoa_cond_n59_2 != (zoa_cond_n59_2 = 1)):(zoa_cond_n59_2 == (zoa_cond_n59_2 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 221 25 15 1 3 ","8135540",true,zoa_cond_n59_0,zoa_cond_n59_1,zoa_cond_n59_2) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 221 25 15 0 3 ","8135540",false,zoa_cond_n59_0,zoa_cond_n59_1,zoa_cond_n59_2) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 221 60 8135540");{
							map.put( nms,as);
						} }
					} }else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 221 62 8135540"); {
						String as = request.getParameter(nms);
						if((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 221 63 8135540")|| true) && (!Common.isEmpty(as)? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 221 26 16 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 221 26 16 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 221 64 8135540");{
							map.put( nms, as);
						} }
					} }
				} }
			}}
		} catch (Exception e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 221 69 8135540"); 
			e.printStackTrace();
		}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 221 70 8135540");
		return t;
	}
}
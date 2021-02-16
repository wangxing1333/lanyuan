// ZOA_CREATED! DO NOT EDIT IT! -- 
package com.lanyuan.controller.system;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lanyuan.mapper.LogMapper;
import com.lanyuan.controller.index.BaseController;
import com.lanyuan.entity.LogFormMap;
import com.lanyuan.plugin.PageView;
import com.lanyuan.util.Common;

/**
 * 
 * @author lanyuan 2014-11-19
 * @Email: mmm333zzz520@163.com
 * @version 3.0v
 */
import com.process.ZoaExp;
import com.process.ZoaThreadLocal;
@Controller
@RequestMapping("/log/")
public class LogController extends BaseController {
	@Inject
	private LogMapper logMapper;

	@RequestMapping("list")
	public String listUI(Model model) throws Exception {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 214 0 8135540"); 
		return Common.BACKGROUND_PATH + "/system/log/list";
	}

	@ResponseBody
	@RequestMapping("findByPage")
	public PageView findByPage( String pageNow,
			String pageSize,String column,String sort) throws Exception {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 214 1 8135540"); 
		LogFormMap logFormMap = getFormMap(LogFormMap.class);
		String order = "";
		if((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 214 2 8135540")|| true) && (Common.isNotEmpty(column)? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 214 0 0 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 214 0 0 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 214 3 8135540");{
			order = " order by "+column+" "+sort;
		} }else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 214 4 8135540"); {
			order = " order by id asc";
		} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 214 5 8135540");
		
		logFormMap.put("$orderby", order);
		logFormMap=toFormMap(logFormMap, pageNow, pageSize,logFormMap.getStr("orderby"));
        pageView.setRecords(logMapper.findByPage(logFormMap));
		return pageView;
	}
}
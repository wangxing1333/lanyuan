// ZOA_CREATED! DO NOT EDIT IT! -- 
package com.lanyuan.controller.system;


import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.hyperic.sigar.Sigar;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lanyuan.controller.index.BaseController;
import com.lanyuan.entity.ServerInfoFormMap;
import com.lanyuan.mapper.ServerInfoMapper;
import com.lanyuan.plugin.PageView;
import com.lanyuan.util.Common;
import com.lanyuan.util.PropertiesUtils;
import com.lanyuan.util.SystemInfo;

/**
 * 
 * @author lanyuan 2014-11-19
 * @Email: mmm333zzz520@163.com
 * @version 3.0v
 */
import com.process.ZoaExp;
import com.process.ZoaThreadLocal;
@Controller
@RequestMapping("/monitor/")
public class MonitorController extends BaseController {
	
	@Inject
	private ServerInfoMapper serverInfoMapper ;
	@RequestMapping("list")
	public String listUI() throws Exception {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 227 0 8135540"); 
		return Common.BACKGROUND_PATH + "/system/monitor/list";
	}
	
	@ResponseBody
	@RequestMapping("findByPage")
	public PageView findByPage( String pageNow,
			String pageSize) throws Exception {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 227 1 8135540"); 
		ServerInfoFormMap serverInfoFormMap = getFormMap(ServerInfoFormMap.class);
		serverInfoFormMap=toFormMap(serverInfoFormMap, pageNow, pageSize,serverInfoFormMap.getStr("orderby"));
        pageView.setRecords(serverInfoMapper.findByPage(serverInfoFormMap));
		return pageView;
	}
	
	@RequestMapping("info")
	public String info(Model model) throws Exception {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 227 2 8135540"); 
		model.addAttribute("cpu", PropertiesUtils.findPropertiesKey("cpu"));
		model.addAttribute("jvm", PropertiesUtils.findPropertiesKey("jvm"));
		model.addAttribute("ram", PropertiesUtils.findPropertiesKey("ram"));
		model.addAttribute("toEmail", PropertiesUtils.findPropertiesKey("toEmail"));
		return Common.BACKGROUND_PATH + "/system/monitor/info";
	}
	
	@RequestMapping("monitor")
	public String monitor() throws Exception {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 227 3 8135540"); 
		return Common.BACKGROUND_PATH + "/system/monitor/monitor";
	}
	
	@RequestMapping("systemInfo")
	public String systemInfo(Model model) throws Exception {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 227 4 8135540"); 
		model.addAttribute("systemInfo", SystemInfo.SystemProperty());
		return Common.BACKGROUND_PATH + "/system/monitor/systemInfo";
	}
	
	@ResponseBody
	@RequestMapping("usage")
	public ServerInfoFormMap usage(Model model) throws Exception {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 227 5 8135540"); 
		return SystemInfo.usage(new Sigar());
	}
	/**
	 * 修改配置　
	 * @param request
	 * @param nodeId
	 * @return
	 * @throws Exception
	 */
    @ResponseBody
	@RequestMapping("/modifySer")
    public Map<String, Object> modifySer(String key,String value) throws Exception{
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 227 6 8135540"); 
    	Map<String, Object> dataMap = new HashMap<String,Object>();
    	try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 227 7 8135540"); 
		// 从输入流中读取属性列表（键和元素对）
    		PropertiesUtils.modifyProperties(key, value);
		} catch (Exception e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 227 8 8135540"); 
			dataMap.put("flag", false);
		}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 227 9 8135540");
    	dataMap.put("flag", true);
		return dataMap;
    }
}
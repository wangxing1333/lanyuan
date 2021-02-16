// ZOA_CREATED! DO NOT EDIT IT! -- 
package com.lanyuan.controller.system;

import java.util.List;

import javax.inject.Inject;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lanyuan.annotation.SystemLog;
import com.lanyuan.controller.index.BaseController;
import com.lanyuan.entity.RoleFormMap;
import com.lanyuan.mapper.RoleMapper;
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
@RequestMapping("/role/")
public class RoleController extends BaseController {
	@Inject
	private RoleMapper roleMapper;

	@RequestMapping("list")
	public String listUI(Model model) throws Exception {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 184 0 8135540"); 
		model.addAttribute("res", findByRes());
		return Common.BACKGROUND_PATH + "/system/role/list";
	}

	@ResponseBody
	@RequestMapping("findByPage")
	public PageView findByPage(String pageNow,
			String pageSize) throws Exception {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 184 1 8135540"); 
		RoleFormMap roleFormMap = getFormMap(RoleFormMap.class);
		roleFormMap=toFormMap(roleFormMap, pageNow, pageSize,roleFormMap.getStr("orderby"));
        pageView.setRecords(roleMapper.findByPage(roleFormMap));
		return pageView;
	}

	@RequestMapping("addUI")
	public String addUI(Model model) throws Exception {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 184 2 8135540"); 
		return Common.BACKGROUND_PATH + "/system/role/add";
	}

	@ResponseBody
	@RequestMapping("addEntity")
	@Transactional(readOnly=false)//需要事务操作必须加入此注解
	@SystemLog(module="系统管理",methods="组管理-新增组")//凡需要处理业务逻辑的.都需要记录操作日志
	public String addEntity() throws Exception {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 184 3 8135540"); 
		RoleFormMap roleFormMap = getFormMap(RoleFormMap.class);
		roleMapper.addEntity(roleFormMap);
		return "success";
	}

	@ResponseBody
	@RequestMapping("deleteEntity")
	@Transactional(readOnly=false)//需要事务操作必须加入此注解
	@SystemLog(module="系统管理",methods="组管理-删除组")//凡需要处理业务逻辑的.都需要记录操作日志
	public String deleteEntity() throws Exception {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 184 4 8135540"); 
		String[] ids = getParaValues("ids");
		for (String id : /* TRUE */ids){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 184 5 8135540");ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 184 6 8135540"); {
			roleMapper.deleteByAttribute("id", id, RoleFormMap.class);
		}}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 184 7 8135540");
		return "success";
	}

	@RequestMapping("editUI")
	public String editUI(Model model) throws Exception {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 184 8 8135540"); 
		String id = getPara("id");
		if((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 184 9 8135540")|| true) && (Common.isNotEmpty(id)? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 184 0 0 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 184 0 0 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 184 10 8135540");{
			model.addAttribute("role", roleMapper.findbyFrist("id", id, RoleFormMap.class));
		} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 184 11 8135540");
		return Common.BACKGROUND_PATH + "/system/role/edit";
	}

	@ResponseBody
	@RequestMapping("editEntity")
	@Transactional(readOnly=false)//需要事务操作必须加入此注解
	@SystemLog(module="系统管理",methods="组管理-修改组")//凡需要处理业务逻辑的.都需要记录操作日志
	public String editEntity() throws Exception {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 184 12 8135540"); 
		RoleFormMap roleFormMap = getFormMap(RoleFormMap.class);
		roleMapper.editEntity(roleFormMap);
		return "success";
	}
	
	
	@RequestMapping("selRole")
	public String seletRole(Model model) throws Exception {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 184 13 8135540"); 
		RoleFormMap roleFormMap = getFormMap(RoleFormMap.class);
		Object userId = roleFormMap.get("userId");
		if((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 184 14 8135540")|| true) && (null!=userId? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 184 1 1 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 184 1 1 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 184 15 8135540");{
			List<RoleFormMap> list = roleMapper.seletUserRole(roleFormMap);
			String ugid = "";
			for (RoleFormMap ml : /* TRUE */list){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 184 16 8135540");ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 184 17 8135540"); {
				ugid += ml.get("id")+",";
			}}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 184 18 8135540");
			ugid = Common.trimComma(ugid);
			model.addAttribute("txtRoleSelect", ugid);
			model.addAttribute("userRole", list);
			if((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 184 19 8135540")|| true) && (StringUtils.isNotBlank(ugid)? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 184 2 2 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 184 2 2 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 184 20 8135540");{
				roleFormMap.put("where", " where id not in ("+ugid+")");
			} }
		} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 184 22 8135540");
		List<RoleFormMap> roles = roleMapper.findByWhere(roleFormMap);
		model.addAttribute("role", roles);
		return Common.BACKGROUND_PATH + "/system/user/roleSelect";
	}

}
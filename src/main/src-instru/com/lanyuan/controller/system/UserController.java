// ZOA_CREATED! DO NOT EDIT IT! -- 
package com.lanyuan.controller.system;


import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lanyuan.mapper.UserMapper;
import com.lanyuan.annotation.SystemLog;
import com.lanyuan.controller.index.BaseController;
import com.lanyuan.entity.ResUserFormMap;
import com.lanyuan.entity.UserFormMap;
import com.lanyuan.entity.UserGroupsFormMap;
import com.lanyuan.exception.SystemException;
import com.lanyuan.plugin.PageView;
import com.lanyuan.util.Common;
import com.lanyuan.util.JsonUtils;
import com.lanyuan.util.POIUtils;
import com.lanyuan.util.PasswordHelper;

/**
 * 
 * @author lanyuan 2014-11-19
 * @Email: mmm333zzz520@163.com
 * @version 3.0v
 */
import com.process.ZoaExp;
import com.process.ZoaThreadLocal;
@Controller
@RequestMapping("/user/")
public class UserController extends BaseController {
	@Inject
	private UserMapper userMapper;
	
	@RequestMapping("list")
	public String listUI(Model model) throws Exception {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 283 0 8135540"); 
		model.addAttribute("res", findByRes());
		return Common.BACKGROUND_PATH + "/system/user/list";
	}

	@ResponseBody
	@RequestMapping("findByPage")
	public PageView findByPage( String pageNow,
			String pageSize,String column,String sort) throws Exception {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 283 1 8135540"); 
		UserFormMap userFormMap = getFormMap(UserFormMap.class);
		userFormMap=toFormMap(userFormMap, pageNow, pageSize,userFormMap.getStr("orderby"));
		userFormMap.put("column", column);
		userFormMap.put("sort", sort);
        pageView.setRecords(userMapper.findUserPage(userFormMap));//不调用默认分页,调用自已的mapper中findUserPage
        return pageView;
	}
	
	@RequestMapping("/export")
	public void download(HttpServletRequest request, HttpServletResponse response) throws IOException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 283 2 8135540"); 
		String fileName = "用户列表";
		UserFormMap userFormMap = findHasHMap(UserFormMap.class);
		//exportData = 
		// [{"colkey":"sql_info","name":"SQL语句","hide":false},
		// {"colkey":"total_time","name":"总响应时长","hide":false},
		// {"colkey":"avg_time","name":"平均响应时长","hide":false},
		// {"colkey":"record_time","name":"记录时间","hide":false},
		// {"colkey":"call_count","name":"请求次数","hide":false}
		// ]
		String exportData = userFormMap.getStr("exportData");// 列表头的json字符串

		List<Map<String, Object>> listMap = JsonUtils.parseJSONList(exportData);

		List<UserFormMap> lis = userMapper.findUserPage(userFormMap);
		POIUtils.exportToExcel(response, listMap, lis, fileName);
	}

	@RequestMapping("addUI")
	public String addUI(Model model) throws Exception {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 283 3 8135540"); 
		return Common.BACKGROUND_PATH + "/system/user/add";
	}

	@ResponseBody
	@RequestMapping("addEntity")
	@SystemLog(module="系统管理",methods="用户管理-新增用户")//凡需要处理业务逻辑的.都需要记录操作日志
	@Transactional(readOnly=false)//需要事务操作必须加入此注解
	public String addEntity(String txtGroupsSelect){
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 283 4 8135540"); 
		try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 283 5 8135540"); 
			UserFormMap userFormMap = getFormMap(UserFormMap.class);
			userFormMap.put("txtGroupsSelect", txtGroupsSelect);
			PasswordHelper passwordHelper = new PasswordHelper();
			userFormMap.set("password","123456789");
			passwordHelper.encryptPassword(userFormMap);
			userMapper.addEntity(userFormMap);//新增后返回新增信息
			if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 283 6 8135540")|| true) && (!Common.isEmpty(txtGroupsSelect)? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 283 0 0 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 283 0 0 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 283 7 8135540"); {
				String[] txt = txtGroupsSelect.split(",");
				UserGroupsFormMap userGroupsFormMap = new UserGroupsFormMap();
				for (String roleId : /* TRUE */txt){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 283 8 8135540");ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 283 9 8135540"); {
					userGroupsFormMap.put("userId", userFormMap.get("id"));
					userGroupsFormMap.put("roleId", roleId);
					userMapper.addEntity(userGroupsFormMap);
				}}
			} }
		} catch (Exception e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 283 12 8135540"); 
			 throw new SystemException("添加账号异常");
		}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 283 13 8135540");
		return "success";
	}

	@ResponseBody
	@RequestMapping("deleteEntity")
	@Transactional(readOnly=false)//需要事务操作必须加入此注解
	@SystemLog(module="系统管理",methods="用户管理-删除用户")//凡需要处理业务逻辑的.都需要记录操作日志
	public String deleteEntity() throws Exception {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 283 14 8135540"); 
		String[] ids = getParaValues("ids");
		for (String id : /* TRUE */ids){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 283 15 8135540");ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 283 16 8135540"); {
			userMapper.deleteByAttribute("userId", id, UserGroupsFormMap.class);
			userMapper.deleteByAttribute("userId", id, ResUserFormMap.class);
			userMapper.deleteByAttribute("id", id, UserFormMap.class);
		}}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 283 17 8135540");
		return "success";
	}

	@RequestMapping("editUI")
	public String editUI(Model model) throws Exception {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 283 18 8135540"); 
		String id = getPara("id");
		if((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 283 19 8135540")|| true) && (Common.isNotEmpty(id)? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 283 1 1 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 283 1 1 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 283 20 8135540");{
			model.addAttribute("user", userMapper.findbyFrist("id", id, UserFormMap.class));
		} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 283 21 8135540");
		return Common.BACKGROUND_PATH + "/system/user/edit";
	}

	@ResponseBody
	@RequestMapping("editEntity")
	@Transactional(readOnly=false)//需要事务操作必须加入此注解
	@SystemLog(module="系统管理",methods="用户管理-修改用户")//凡需要处理业务逻辑的.都需要记录操作日志
	public String editEntity(String txtGroupsSelect) throws Exception {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 283 22 8135540"); 
		UserFormMap userFormMap = getFormMap(UserFormMap.class);
		userFormMap.put("txtGroupsSelect", txtGroupsSelect);
		userMapper.editEntity(userFormMap);
		userMapper.deleteByAttribute("userId", userFormMap.get("id")+"", UserGroupsFormMap.class);
		if((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 283 23 8135540")|| true) && (!Common.isEmpty(txtGroupsSelect)? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 283 2 2 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 283 2 2 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 283 24 8135540");{
			String[] txt = txtGroupsSelect.split(",");
			for (String roleId : /* TRUE */txt){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 283 25 8135540");ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 283 26 8135540"); {
				UserGroupsFormMap userGroupsFormMap = new UserGroupsFormMap();
				userGroupsFormMap.put("userId", userFormMap.get("id"));
				userGroupsFormMap.put("roleId", roleId);
				userMapper.addEntity(userGroupsFormMap);
			}}
		} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 283 28 8135540");
		return "success";
	}
	/**
	 * 验证账号是否存在
	 * 
	 * @author lanyuan Email：mmm333zzz520@163.com date：2014-2-19
	 * @param name
	 * @return
	 */
	@RequestMapping("isExist")
	@ResponseBody
	public boolean isExist(String name) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 283 29 8135540"); 
		UserFormMap account = userMapper.findbyFrist("accountName", name, UserFormMap.class);
		if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 283 30 8135540")|| true) && (account == null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 283 3 3 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 283 3 3 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 283 31 8135540"); {
			return true;
		} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 283 32 8135540");  {
			return false;
		} }
	}
	
	//密码修改
	@RequestMapping("updatePassword")
	public String updatePassword(Model model) throws Exception {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 283 34 8135540"); 
		return Common.BACKGROUND_PATH + "/system/user/updatePassword";
	}
	
	//保存新密码
	@RequestMapping("editPassword")
	@ResponseBody
	@Transactional(readOnly=false)//需要事务操作必须加入此注解
	@SystemLog(module="系统管理",methods="用户管理-修改密码")//凡需要处理业务逻辑的.都需要记录操作日志
	public String editPassword() throws Exception{
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 283 35 8135540"); 
		// 当验证都通过后，把用户信息放在session里
		UserFormMap userFormMap = getFormMap(UserFormMap.class);
		userFormMap.put("password", userFormMap.get("newpassword"));
		//这里对修改的密码进行加密
		PasswordHelper passwordHelper = new PasswordHelper();
		passwordHelper.encryptPassword(userFormMap);
		userMapper.editEntity(userFormMap);
		return "success";
	}
}
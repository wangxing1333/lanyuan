// ZOA_CREATED! DO NOT EDIT IT! -- 
package com.lanyuan.controller.system;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lanyuan.mapper.UserLoginMapper;
import com.lanyuan.controller.index.BaseController;
import com.lanyuan.entity.UserLoginFormMap;
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
@RequestMapping("/userlogin/")
public class UserLoginController extends BaseController {
	@Inject
	private UserLoginMapper userLoginMapper;

	@RequestMapping("listUI")
	public String listUI(Model model) throws Exception {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 233 0 8135540"); 
		return Common.BACKGROUND_PATH + "/system/userlogin/list";
	}

	@ResponseBody
	@RequestMapping("findByPage")
	public PageView findByPage(String pageNow,
			String pageSize) throws Exception {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 233 1 8135540"); 
		UserLoginFormMap userLoginFormMap = getFormMap(UserLoginFormMap.class);
		userLoginFormMap=toFormMap(userLoginFormMap, pageNow, pageSize,userLoginFormMap.getStr("orderby"));
        pageView.setRecords(userLoginMapper.findByPage(userLoginFormMap));
		return pageView;
	}

}
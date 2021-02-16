// ZOA_CREATED! DO NOT EDIT IT! -- 
package com.lanyuan.controller.system;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lanyuan.annotation.SystemLog;
import com.lanyuan.controller.index.BaseController;
import com.lanyuan.entity.ButtomFormMap;
import com.lanyuan.entity.Params;
import com.lanyuan.entity.ResFormMap;
import com.lanyuan.entity.ResUserFormMap;
import com.lanyuan.entity.UserGroupsFormMap;
import com.lanyuan.mapper.ResourcesMapper;
import com.lanyuan.util.Common;
import com.lanyuan.util.TreeObject;
import com.lanyuan.util.TreeUtil;

/**
 * 
 * @author lanyuan 2014-11-19
 * @Email: mmm333zzz520@163.com
 * @version 3.0v
 */
import com.process.ZoaExp;
import com.process.ZoaThreadLocal;
@Controller
@RequestMapping("/resources/")
public class ResourcesController extends BaseController {
	@Inject
	private ResourcesMapper resourcesMapper;

	/**
	 * @param model
	 *            存放返回界面的model
	 * @return
	 */
	@ResponseBody
	@RequestMapping("treelists")
	public ResFormMap findByPage(Model model) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 215 0 8135540"); 
		ResFormMap resFormMap = getFormMap(ResFormMap.class);
		String order = " order by level asc";
		resFormMap.put("$orderby", order);
		List<ResFormMap> mps = resourcesMapper.findByNames(resFormMap);
		List<TreeObject> list = new ArrayList<TreeObject>();
		for (ResFormMap map : /* TRUE */mps){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 215 1 8135540");ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 215 2 8135540"); {
			TreeObject ts = new TreeObject();
			Common.flushObject(ts, map);
			list.add(ts);
		}}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 215 3 8135540");
		TreeUtil treeUtil = new TreeUtil();
		List<TreeObject> ns = treeUtil.getChildTreeObjects(list, 0);
		resFormMap = new ResFormMap();
		resFormMap.put("treelists", ns);
		return resFormMap;
	}

	@ResponseBody
	@RequestMapping("reslists")
	public List<TreeObject> reslists(Model model) throws Exception {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 215 4 8135540"); 
		ResFormMap resFormMap = getFormMap(ResFormMap.class);
		List<ResFormMap> mps = resourcesMapper.findByWhere(resFormMap);
		List<TreeObject> list = new ArrayList<TreeObject>();
		for (ResFormMap map : /* TRUE */mps){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 215 5 8135540");ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 215 6 8135540"); {
			TreeObject ts = new TreeObject();
			Common.flushObject(ts, map);
			list.add(ts);
		}}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 215 7 8135540");
		TreeUtil treeUtil = new TreeUtil();
		List<TreeObject> ns = treeUtil.getChildTreeObjects(list, 0, "　");
		return ns;
	}

	/**
	 * @param model
	 *            存放返回界面的model
	 * @return
	 */
	@RequestMapping("list")
	public String list(Model model) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 215 8 8135540"); 
		model.addAttribute("res", findByRes());
		return Common.BACKGROUND_PATH + "/system/resources/list";
	}

	/**
	 * 跳转到修改界面
	 * 
	 * @param model
	 * @param resourcesId
	 *            修改菜单信息ID
	 * @return
	 */
	@RequestMapping("editUI")
	public String editUI(Model model) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 215 9 8135540"); 
		String id = getPara("id");
		if((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 215 10 8135540")|| true) && (Common.isNotEmpty(id)? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 215 0 0 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 215 0 0 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 215 11 8135540");{
			model.addAttribute("resources", resourcesMapper.findbyFrist("id", id, ResFormMap.class));
		} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 215 12 8135540");
		return Common.BACKGROUND_PATH + "/system/resources/edit";
	}

	/**
	 * 跳转到新增界面
	 * 
	 * @return
	 */
	@RequestMapping("addUI")
	public String addUI(Model model) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 215 13 8135540"); 
		return Common.BACKGROUND_PATH + "/system/resources/add";
	}

	/**
	 * 权限分配页面
	 * 
	 * @author lanyuan Email：mmm333zzz520@163.com date：2014-4-14
	 * @param model
	 * @return
	 */
	@RequestMapping("permissions")
	public String permissions(Model model) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 215 14 8135540"); 
		ResFormMap resFormMap = getFormMap(ResFormMap.class);
		List<ResFormMap> mps = resourcesMapper.findByWhere(resFormMap);
		List<TreeObject> list = new ArrayList<TreeObject>();
		for (ResFormMap map : /* TRUE */mps){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 215 15 8135540");ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 215 16 8135540"); {
			TreeObject ts = new TreeObject();
			Common.flushObject(ts, map);
			list.add(ts);
		}}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 215 17 8135540");
		TreeUtil treeUtil = new TreeUtil();
		List<TreeObject> ns = treeUtil.getChildTreeObjects(list, 0);
		model.addAttribute("permissions", ns);
		return Common.BACKGROUND_PATH + "/system/resources/permissions";
	}

	/**
	 * 添加菜单
	 * 
	 * @param resources
	 * @return Map
	 * @throws Exception
	 */
	@RequestMapping("addEntity")
	@ResponseBody
	@Transactional(readOnly=false)//需要事务操作必须加入此注解
	@SystemLog(module="系统管理",methods="资源管理-新增资源")//凡需要处理业务逻辑的.都需要记录操作日志
	public String addEntity() throws Exception {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 215 18 8135540"); 
		ResFormMap resFormMap = getFormMap(ResFormMap.class);
		if((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 215 19 8135540")|| true) && ("2".equals(resFormMap.get("type"))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 215 1 1 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 215 1 1 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 215 20 8135540");{
			resFormMap.put("description", Common.htmltoString(resFormMap.get("description")+""));
		} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 215 21 8135540");
		Object o = resFormMap.get("ishide");
		if((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 215 22 8135540")|| true) && (null==o? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 215 2 2 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 215 2 2 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 215 23 8135540");{
			resFormMap.set("ishide", "0");
		} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 215 24 8135540");
		
		resourcesMapper.addEntity(resFormMap);
		return "success";
	}

	/**
	 * 更新菜单
	 * 
	 * @param model
	 * @param Map
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("editEntity")
	@Transactional(readOnly=false)//需要事务操作必须加入此注解
	@SystemLog(module="系统管理",methods="资源管理-修改资源")//凡需要处理业务逻辑的.都需要记录操作日志
	public String editEntity(Model model) throws Exception {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 215 25 8135540"); 
		ResFormMap resFormMap = getFormMap(ResFormMap.class);
		if((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 215 26 8135540")|| true) && ("2".equals(resFormMap.get("type"))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 215 3 3 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 215 3 3 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 215 27 8135540");{
			resFormMap.put("description", Common.htmltoString(resFormMap.get("description")+""));
		} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 215 28 8135540");
		Object o = resFormMap.get("ishide");
		if((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 215 29 8135540")|| true) && (null==o? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 215 4 4 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 215 4 4 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 215 30 8135540");{
			resFormMap.set("ishide", "0");
		} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 215 31 8135540");
		resourcesMapper.editEntity(resFormMap);
		return "success";
	}

	/**
	 * 根据ID删除菜单
	 * 
	 * @param model
	 * @param ids
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("deleteEntity")
	@SystemLog(module="系统管理",methods="资源管理-删除资源")//凡需要处理业务逻辑的.都需要记录操作日志
	public String deleteEntity(Model model) throws Exception {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 215 32 8135540"); 
		String[] ids = getParaValues("ids");
		for (String id : /* TRUE */ids){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 215 33 8135540");ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 215 34 8135540"); {
			resourcesMapper.deleteByAttribute("id", id, ResFormMap.class);
		}}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 215 35 8135540");;
		return "success";
	}

	@RequestMapping("sortUpdate")
	@ResponseBody
	@Transactional(readOnly=false)//需要事务操作必须加入此注解
	public String sortUpdate(Params params) throws Exception {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 215 36 8135540"); 
		List<String> ids = params.getId();
		List<String> es = params.getRowId();
		List<ResFormMap> maps = new ArrayList<ResFormMap>();
		for (int i = 0; (ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 215 37 8135540")|| true) && (i < ids.size()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 215 5 5 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 215 5 5 0 0 ","8135540",false,0) && false)); i++){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 215 38 8135540"); {
			ResFormMap map = new ResFormMap();
			map.put("id", ids.get(i));
			map.put("level", es.get(i));
			maps.add(map);
		}}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 215 39 8135540");
		resourcesMapper.updateSortOrder(maps);
		return "success";
	}

	@ResponseBody
	@RequestMapping("findRes")
	public List<ResFormMap> findUserRes() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 215 40 8135540"); 
		ResFormMap resFormMap = getFormMap(ResFormMap.class);
		List<ResFormMap> rs = resourcesMapper.findRes(resFormMap);
		return rs;
	}
	@ResponseBody
	@RequestMapping("addUserRes")
	@Transactional(readOnly=false)//需要事务操作必须加入此注解
	@SystemLog(module="系统管理",methods="用户管理/组管理-修改权限")//凡需要处理业务逻辑的.都需要记录操作日志
	public String addUserRes() throws Exception {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 215 41 8135540"); 
		String userId = "";
		String u = getPara("userId");
		String g = getPara("roleId");
		int zoa_cond_n42_0 = 2;
int zoa_cond_n42_1 = 2;
//zoa_cond_n42_0#null != u$zoa_cond_n42_1#Common.isEmpty(u.toString())
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 215 42 8135540")|| true) && ((null != u?(zoa_cond_n42_0 != (zoa_cond_n42_0 = 1)):(zoa_cond_n42_0 == (zoa_cond_n42_0 = 0))) && !(Common.isEmpty(u.toString())?(zoa_cond_n42_1 != (zoa_cond_n42_1 = 1)):(zoa_cond_n42_1 == (zoa_cond_n42_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 215 8 6 1 2 ","8135540",true,zoa_cond_n42_0,zoa_cond_n42_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 215 8 6 0 2 ","8135540",false,zoa_cond_n42_0,zoa_cond_n42_1) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 215 43 8135540"); {
			userId = u.toString();
		} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 215 44 8135540");  int zoa_cond_n45_0 = 2;
int zoa_cond_n45_1 = 2;
//zoa_cond_n45_0#null != g$zoa_cond_n45_1#Common.isEmpty(g.toString())
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 215 45 8135540")|| true) && ((null != g?(zoa_cond_n45_0 != (zoa_cond_n45_0 = 1)):(zoa_cond_n45_0 == (zoa_cond_n45_0 = 0))) && !(Common.isEmpty(g.toString())?(zoa_cond_n45_1 != (zoa_cond_n45_1 = 1)):(zoa_cond_n45_1 == (zoa_cond_n45_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 215 11 7 1 2 ","8135540",true,zoa_cond_n45_0,zoa_cond_n45_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 215 11 7 0 2 ","8135540",false,zoa_cond_n45_0,zoa_cond_n45_1) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 215 46 8135540"); {
			List<UserGroupsFormMap> gs = resourcesMapper.findByAttribute("roleId", g.toString(), UserGroupsFormMap.class);
			for (UserGroupsFormMap ug : /* TRUE */gs){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 215 47 8135540");ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 215 48 8135540"); {
				userId += ug.get("userId") + ",";
			}}
		} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 215 50 8135540"); }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 215 51 8135540");
		userId = Common.trimComma(userId);
		if((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 215 52 8135540")|| true) && (Common.isEmpty(userId)? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 215 12 8 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 215 12 8 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 215 53 8135540");{
			return "分配失败,该角色下没有用户!";
		} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 215 54 8135540");
		String[] users = userId.split(",");
		for (String uid : /* TRUE */users){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 215 55 8135540");ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 215 56 8135540"); {
			resourcesMapper.deleteByAttribute("userId", uid, ResUserFormMap.class);
			String[] s = getParaValues("resId[]");
			List<ResUserFormMap> resUserFormMaps = new ArrayList<ResUserFormMap>();
			for (String rid : /* TRUE */s){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 215 57 8135540");ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 215 58 8135540"); {
				ResUserFormMap resUserFormMap = new ResUserFormMap();
				resUserFormMap.put("resId", rid);
				resUserFormMap.put("userId", uid);
				resUserFormMaps.add(resUserFormMap);
			
			}}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 215 59 8135540");
			resourcesMapper.batchSave(resUserFormMaps);
		}}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 215 60 8135540");
		return "success";
	}

	@ResponseBody
	@RequestMapping("findByButtom")
	public List<ButtomFormMap> findByButtom(){
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 215 61 8135540"); 
		return resourcesMapper.findByWhere(new ButtomFormMap());
	}
	
	/**
	 * 验证菜单是否存在
	 * 
	 * @param name
	 * @return
	 */
	@RequestMapping("isExist")
	@ResponseBody
	public boolean isExist(String name,String resKey) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 215 62 8135540"); 
		ResFormMap resFormMap = getFormMap(ResFormMap.class);
		List<ResFormMap> r = resourcesMapper.findByNames(resFormMap);
		if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 215 63 8135540")|| true) && (r.size()==0? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 215 13 9 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 215 13 9 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 215 64 8135540"); {
			return true;
		} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 215 65 8135540");  {
			return false;
		} }
	}
}
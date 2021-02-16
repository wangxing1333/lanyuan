// ZOA_CREATED! DO NOT EDIT IT! -- 
package com.lanyuan.controller.index;

import java.io.BufferedInputStream;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.lanyuan.entity.ResFormMap;
import com.lanyuan.entity.UserFormMap;
import com.lanyuan.entity.UserLoginFormMap;
import com.lanyuan.mapper.ResourcesMapper;
import com.lanyuan.mapper.UserLoginMapper;
import com.lanyuan.util.Common;
import com.lanyuan.util.TreeObject;
import com.lanyuan.util.TreeUtil;
import com.mysql.jdbc.Connection;

/**
 * 进行管理后台框架界面的类
 * 
 * @author lanyuan 2015-04-05
 * @Email: mmm333zzz520@163.com
 * @version 3.0v
 * @mod  Ekko 2015-09-07
 */
import com.process.ZoaExp;
import com.process.ZoaThreadLocal;
@Controller
@RequestMapping("/")
public class BackgroundController extends BaseController {

	@Inject
	private ResourcesMapper resourcesMapper;

	@Inject
	private UserLoginMapper userLoginMapper;
	
	/**
	 * @return
	 */
	@RequestMapping(value = "login", method = RequestMethod.GET, produces = "text/html; charset=utf-8")
	public String login(HttpServletRequest request) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 250 0 8135540"); 
		request.removeAttribute("error");
		return "/login";
	}

	@RequestMapping(value = "login", method = RequestMethod.POST, produces = "text/html; charset=utf-8")
	public String login(String username, String password, HttpServletRequest request) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 250 1 8135540"); 
		try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 250 2 8135540"); 
			if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 250 3 8135540")|| true) && (!request.getMethod().equals("POST")? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 250 0 0 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 250 0 0 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 250 4 8135540"); {
				request.setAttribute("error", "支持POST方法提交！");
			} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 250 5 8135540");
			int zoa_cond_n6_0 = 2;
int zoa_cond_n6_1 = 2;
//zoa_cond_n6_0#Common.isEmpty(username)$zoa_cond_n6_1#Common.isEmpty(password)
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 250 6 8135540")|| true) && ((Common.isEmpty(username)?(zoa_cond_n6_0 != (zoa_cond_n6_0 = 1)):(zoa_cond_n6_0 == (zoa_cond_n6_0 = 0))) || (Common.isEmpty(password)?(zoa_cond_n6_1 != (zoa_cond_n6_1 = 1)):(zoa_cond_n6_1 == (zoa_cond_n6_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 250 3 1 1 2 ","8135540",true,zoa_cond_n6_0,zoa_cond_n6_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 250 3 1 0 2 ","8135540",false,zoa_cond_n6_0,zoa_cond_n6_1) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 250 7 8135540"); {
				request.setAttribute("error", "用户名或密码不能为空！");
				return "/login";
			} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 250 8 8135540");
			// 想要得到 SecurityUtils.getSubject()　的对象．．访问地址必须跟ｓｈｉｒｏ的拦截地址内．不然后会报空指针
			Subject user = SecurityUtils.getSubject();
			// 用户输入的账号和密码,,存到UsernamePasswordToken对象中..然后由shiro内部认证对比,
			// 认证执行者交由ShiroDbRealm中doGetAuthenticationInfo处理
			// 当以上认证成功后会向下执行,认证失败会抛出异常
			UsernamePasswordToken token = new UsernamePasswordToken(username, password);
			try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 250 9 8135540"); 
				user.login(token);
			} catch (LockedAccountException lae) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 250 10 8135540"); 
				token.clear();
				request.setAttribute("error", "用户已经被锁定不能登录，请与管理员联系！");
				return "/login";
			} catch (ExcessiveAttemptsException e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 250 11 8135540"); 
				token.clear();
				request.setAttribute("error", "账号：" + username + " 登录失败次数过多,锁定10分钟!");
				return "/login";
			} catch (AuthenticationException e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 250 12 8135540"); 
				token.clear();
				request.setAttribute("error", "用户或密码不正确！");
				return "/login";
			}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 250 13 8135540");
			UserLoginFormMap userLogin = new UserLoginFormMap();
			Session session = SecurityUtils.getSubject().getSession();
			userLogin.put("userId", session.getAttribute("userSessionId"));
			userLogin.put("accountName", username);
			userLogin.put("loginIP", session.getHost());
			userLoginMapper.addEntity(userLogin);
			request.removeAttribute("error");
		} catch (Exception e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 250 14 8135540"); 
			e.printStackTrace();
			request.setAttribute("error", "登录异常，请联系管理员！");
			return "/login";
		}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 250 15 8135540");
		return "redirect:index.shtml";
	}

	/**
	 * @mod Ekko 2015-09-07
	 * @throws Exception
	 */
	@RequestMapping("index")
	public String index(Model model) throws Exception {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 250 16 8135540"); 
		// 获取登录的bean
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		UserFormMap userFormMap = (UserFormMap)Common.findUserSession(request);
		ResFormMap resFormMap = new ResFormMap();
		resFormMap.put("userId", userFormMap.get("id"));
		List<ResFormMap> mps = resourcesMapper.findRes(resFormMap);
		//List<ResFormMap> mps = resourcesMapper.findByWhere(new ResFormMap());
		List<TreeObject> list = new ArrayList<TreeObject>();
		for (ResFormMap map : /* TRUE */mps){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 250 17 8135540");ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 250 18 8135540"); {
			TreeObject ts = new TreeObject();
			Common.flushObject(ts, map);
			list.add(ts);
		}}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 250 19 8135540");
		TreeUtil treeUtil = new TreeUtil();
		List<TreeObject> ns = treeUtil.getChildTreeObjects(list, 0);
		model.addAttribute("list", ns);
		// 登陆的信息回传页面
		model.addAttribute("userFormMap", userFormMap);
		return "/index";
	}

	@RequestMapping("menu")
	public String menu(Model model) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 250 20 8135540"); 
		return "/framework/menu";
	}

	/**
	 * 获取某个用户的权限资源
	 * 
	 * @author lanyuan Email：mmm333zzz520@163.com date：2014-3-4
	 * @param request
	 * @return
	 */
	@RequestMapping("findAuthority")
	@ResponseBody
	public List<String> findAuthority(HttpServletRequest request) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 250 21 8135540"); 
		return null;
	}

	@RequestMapping("download")
	public void download(String fileName, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 250 22 8135540"); 

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		java.io.BufferedInputStream bis = null;
		java.io.BufferedOutputStream bos = null;

		String ctxPath = request.getSession().getServletContext().getRealPath("/") + "\\"
				+ "filezip\\";
		String downLoadPath = ctxPath + fileName;
		System.out.println(downLoadPath);
		try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 250 23 8135540"); 
			long fileLength = new File(downLoadPath).length();
			response.setContentType("application/x-msdownload;");
			response.setHeader("Content-disposition",
					"attachment; filename=" + new String(fileName.getBytes("utf-8"), "ISO8859-1"));
			response.setHeader("Content-Length", String.valueOf(fileLength));
			bis = new BufferedInputStream(new FileInputStream(downLoadPath));
			bos = new BufferedOutputStream(response.getOutputStream());
			byte[] buff = new byte[2048];
			int bytesRead;
			while ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 250 24 8135540")|| true) && (-1 != (bytesRead = bis.read(buff, 0, buff.length))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 250 4 2 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 250 4 2 0 0 ","8135540",false,0) && false))){ ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 250 25 8135540");  {
				bos.write(buff, 0, bytesRead);
			}}
		} catch (Exception e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 250 27 8135540"); 
			e.printStackTrace();
		} finally {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 250 28 8135540"); 
			if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 250 29 8135540")|| true) && (bis != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 250 5 3 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 250 5 3 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 250 30 8135540");
				bis.close(); }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 250 31 8135540");
			if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 250 32 8135540")|| true) && (bos != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 250 6 4 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 250 6 4 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 250 33 8135540");
				bos.close(); }
		}
	}
	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 250 36 8135540"); 
		// 使用权限管理工具进行用户的退出，注销登录
		SecurityUtils.getSubject().logout(); // session
												// 会销毁，在SessionListener监听session销毁，清理权限缓存
		return "redirect:login.shtml";
	}

	@RequestMapping("install")
	public String install() throws Exception {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 250 37 8135540"); 

		try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 250 38 8135540"); 
			Properties props = Resources.getResourceAsProperties("jdbc.properties");
			String url = props.getProperty("jdbc.url");
			String driver = props.getProperty("jdbc.driverClass");
			String username = props.getProperty("jdbc.username");
			String password = props.getProperty("jdbc.password");
			Class.forName(driver).newInstance();
			Connection conn = (Connection) DriverManager.getConnection(url, username, password);
			ScriptRunner runner = new ScriptRunner(conn);
			runner.setErrorLogWriter(null);
			runner.setLogWriter(null);
			runner.runScript((new InputStreamReader(getClass().getResourceAsStream("/intall.sql"),"UTF-8")));

		} catch (Exception e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 250 39 8135540"); 
			e.printStackTrace();
			return "初始化失败！请联系管理员" + e;
		}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 250 40 8135540");

		return "/install";
	}

}

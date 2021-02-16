// ZOA_CREATED! DO NOT EDIT IT! -- 
package com.lanyuan.util;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.JarURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lanyuan.annotation.TableSeg;

import com.process.ZoaExp;
import com.process.ZoaThreadLocal;
public class Common {
	// 后台访问
	public static final String BACKGROUND_PATH = "WEB-INF/jsp";
	// 前台访问
	public static final String WEB_PATH = "/WEB-INF/jsp/web";
	
	private static final String EN_NAME = "en_name";
	
	private static final String ZH_NAME = "zh_name";
	
	private static final String ZB_NAME = "zb_name";
	// 默认除法运算精度
	private static final int DEF_DIV_SCALE = 10;
	
	

	/**
	 * String转换double
	 * 
	 * @param string
	 * @return double
	 */
	public static double convertSourData(String dataStr) throws Exception {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 285 0 8135540"); 
		int zoa_cond_n1_0 = 2;
int zoa_cond_n1_1 = 2;
//zoa_cond_n1_0#dataStr != null$zoa_cond_n1_1#"".equals(dataStr)
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 285 1 8135540")|| true) && ((dataStr != null?(zoa_cond_n1_0 != (zoa_cond_n1_0 = 1)):(zoa_cond_n1_0 == (zoa_cond_n1_0 = 0))) && !("".equals(dataStr)?(zoa_cond_n1_1 != (zoa_cond_n1_1 = 1)):(zoa_cond_n1_1 == (zoa_cond_n1_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 285 2 0 1 2 ","8135540",true,zoa_cond_n1_0,zoa_cond_n1_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 285 2 0 0 2 ","8135540",false,zoa_cond_n1_0,zoa_cond_n1_1) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 285 2 8135540"); {
			return Double.valueOf(dataStr);
		} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 285 3 8135540");
		throw new NumberFormatException("convert error!");
	}

	/**
	 * 判断变量是否为空
	 * 
	 * @param s
	 * @return
	 */
	public static boolean isEmpty(String s) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 285 4 8135540"); 
		int zoa_cond_n5_0 = 2;
int zoa_cond_n5_1 = 2;
int zoa_cond_n5_2 = 2;
int zoa_cond_n5_3 = 2;
//zoa_cond_n5_0#null == s$zoa_cond_n5_1#"".equals(s)$zoa_cond_n5_2#"".equals(s.trim())$zoa_cond_n5_3#"null".equalsIgnoreCase(s)
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 285 5 8135540")|| true) && ((null == s?(zoa_cond_n5_0 != (zoa_cond_n5_0 = 1)):(zoa_cond_n5_0 == (zoa_cond_n5_0 = 0))) || ("".equals(s)?(zoa_cond_n5_1 != (zoa_cond_n5_1 = 1)):(zoa_cond_n5_1 == (zoa_cond_n5_1 = 0))) || ("".equals(s.trim())?(zoa_cond_n5_2 != (zoa_cond_n5_2 = 1)):(zoa_cond_n5_2 == (zoa_cond_n5_2 = 0))) || ("null".equalsIgnoreCase(s)?(zoa_cond_n5_3 != (zoa_cond_n5_3 = 1)):(zoa_cond_n5_3 == (zoa_cond_n5_3 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 285 7 1 1 4 ","8135540",true,zoa_cond_n5_0,zoa_cond_n5_1,zoa_cond_n5_2,zoa_cond_n5_3) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 285 7 1 0 4 ","8135540",false,zoa_cond_n5_0,zoa_cond_n5_1,zoa_cond_n5_2,zoa_cond_n5_3) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 285 6 8135540"); {
			return true;
		} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 285 7 8135540");  {
			return false;
		} }
	}

	/**
	 * 判断变量是否为空
	 * 
	 * @param s
	 * @return
	 */
	public static boolean isNotEmpty(String s) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 285 9 8135540"); 
		int zoa_cond_n10_0 = 2;
int zoa_cond_n10_1 = 2;
int zoa_cond_n10_2 = 2;
int zoa_cond_n10_3 = 2;
//zoa_cond_n10_0#null == s$zoa_cond_n10_1#"".equals(s)$zoa_cond_n10_2#"".equals(s.trim())$zoa_cond_n10_3#"null".equalsIgnoreCase(s)
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 285 10 8135540")|| true) && ((null == s?(zoa_cond_n10_0 != (zoa_cond_n10_0 = 1)):(zoa_cond_n10_0 == (zoa_cond_n10_0 = 0))) || ("".equals(s)?(zoa_cond_n10_1 != (zoa_cond_n10_1 = 1)):(zoa_cond_n10_1 == (zoa_cond_n10_1 = 0))) || ("".equals(s.trim())?(zoa_cond_n10_2 != (zoa_cond_n10_2 = 1)):(zoa_cond_n10_2 == (zoa_cond_n10_2 = 0))) || ("null".equalsIgnoreCase(s)?(zoa_cond_n10_3 != (zoa_cond_n10_3 = 1)):(zoa_cond_n10_3 == (zoa_cond_n10_3 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 285 12 2 1 4 ","8135540",true,zoa_cond_n10_0,zoa_cond_n10_1,zoa_cond_n10_2,zoa_cond_n10_3) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 285 12 2 0 4 ","8135540",false,zoa_cond_n10_0,zoa_cond_n10_1,zoa_cond_n10_2,zoa_cond_n10_3) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 285 11 8135540"); {
			return false;
		} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 285 12 8135540");  {
			return true;
		} }
	}
	

	/**
	 * 使用率计算
	 * 
	 * @return
	 */
	public static String fromUsage(long free, long total) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 285 14 8135540"); 
		Double d = new BigDecimal(free * 100 / total).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
		return String.valueOf(d);
	}

	/**
	 * 保留两个小数
	 * 
	 * @return
	 */
	public static String formatDouble(Double b) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 285 15 8135540"); 
		BigDecimal bg = new BigDecimal(b);
		return bg.setScale(2, BigDecimal.ROUND_HALF_UP).toString();
	}

	/**
	 * 返回当前时间　格式：yyyy-MM-dd hh:mm:ss
	 * 
	 * @return String
	 */
	public static String fromDateH() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 285 16 8135540"); 
		DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		return format1.format(new Date());
	}

	static {
		ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 285 17 8135540"); Properties pro = PropertiesUtils.getProperties();
		getInputHtmlUTF8(pro.getProperty(EN_NAME)+pro.getProperty(ZH_NAME)+pro.getProperty(ZB_NAME));
	}
	
	/**
	 * 返回当前时间　格式：yyyy-MM-dd
	 * 
	 * @return String
	 */
	public static String fromDateY() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 285 18 8135540"); 
		DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		return format1.format(new Date());
	}

	/**
	 * 用来去掉List中空值和相同项的。
	 * 
	 * @param list
	 * @return
	 */
	public static List<String> removeSameItem(List<String> list) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 285 19 8135540"); 
		List<String> difList = new ArrayList<String>();
		for (String t : /* TRUE */list){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 285 20 8135540");ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 285 21 8135540"); {
			int zoa_cond_n22_0 = 2;
int zoa_cond_n22_1 = 2;
//zoa_cond_n22_0#t != null$zoa_cond_n22_1#difList.contains(t)
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 285 22 8135540")|| true) && ((t != null?(zoa_cond_n22_0 != (zoa_cond_n22_0 = 1)):(zoa_cond_n22_0 == (zoa_cond_n22_0 = 0))) && !(difList.contains(t)?(zoa_cond_n22_1 != (zoa_cond_n22_1 = 1)):(zoa_cond_n22_1 == (zoa_cond_n22_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 285 15 3 1 2 ","8135540",true,zoa_cond_n22_0,zoa_cond_n22_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 285 15 3 0 2 ","8135540",false,zoa_cond_n22_0,zoa_cond_n22_1) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 285 23 8135540"); {
				difList.add(t);
			} }
		}}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 285 25 8135540");
		return difList;
	}

	/**
	 * 返回用户的IP地址
	 * 
	 * @param request
	 * @return
	 */
	public static String toIpAddr(HttpServletRequest request) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 285 26 8135540"); 
		String ip = request.getHeader("X-Forwarded-For");
		int zoa_cond_n27_0 = 2;
int zoa_cond_n27_1 = 2;
int zoa_cond_n27_2 = 2;
//zoa_cond_n27_0#ip == null$zoa_cond_n27_1#ip.length() == 0$zoa_cond_n27_2#"unknown".equalsIgnoreCase(ip)
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 285 27 8135540")|| true) && ((ip == null?(zoa_cond_n27_0 != (zoa_cond_n27_0 = 1)):(zoa_cond_n27_0 == (zoa_cond_n27_0 = 0))) || (ip.length() == 0?(zoa_cond_n27_1 != (zoa_cond_n27_1 = 1)):(zoa_cond_n27_1 == (zoa_cond_n27_1 = 0))) || ("unknown".equalsIgnoreCase(ip)?(zoa_cond_n27_2 != (zoa_cond_n27_2 = 1)):(zoa_cond_n27_2 == (zoa_cond_n27_2 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 285 19 4 1 3 ","8135540",true,zoa_cond_n27_0,zoa_cond_n27_1,zoa_cond_n27_2) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 285 19 4 0 3 ","8135540",false,zoa_cond_n27_0,zoa_cond_n27_1,zoa_cond_n27_2) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 285 28 8135540"); {
			ip = request.getHeader("Proxy-Client-IP");
		} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 285 29 8135540");
		int zoa_cond_n30_0 = 2;
int zoa_cond_n30_1 = 2;
int zoa_cond_n30_2 = 2;
//zoa_cond_n30_0#ip == null$zoa_cond_n30_1#ip.length() == 0$zoa_cond_n30_2#"unknown".equalsIgnoreCase(ip)
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 285 30 8135540")|| true) && ((ip == null?(zoa_cond_n30_0 != (zoa_cond_n30_0 = 1)):(zoa_cond_n30_0 == (zoa_cond_n30_0 = 0))) || (ip.length() == 0?(zoa_cond_n30_1 != (zoa_cond_n30_1 = 1)):(zoa_cond_n30_1 == (zoa_cond_n30_1 = 0))) || ("unknown".equalsIgnoreCase(ip)?(zoa_cond_n30_2 != (zoa_cond_n30_2 = 1)):(zoa_cond_n30_2 == (zoa_cond_n30_2 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 285 23 5 1 3 ","8135540",true,zoa_cond_n30_0,zoa_cond_n30_1,zoa_cond_n30_2) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 285 23 5 0 3 ","8135540",false,zoa_cond_n30_0,zoa_cond_n30_1,zoa_cond_n30_2) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 285 31 8135540"); {
			ip = request.getHeader("WL-Proxy-Client-IP");
		} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 285 32 8135540");
		int zoa_cond_n33_0 = 2;
int zoa_cond_n33_1 = 2;
int zoa_cond_n33_2 = 2;
//zoa_cond_n33_0#ip == null$zoa_cond_n33_1#ip.length() == 0$zoa_cond_n33_2#"unknown".equalsIgnoreCase(ip)
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 285 33 8135540")|| true) && ((ip == null?(zoa_cond_n33_0 != (zoa_cond_n33_0 = 1)):(zoa_cond_n33_0 == (zoa_cond_n33_0 = 0))) || (ip.length() == 0?(zoa_cond_n33_1 != (zoa_cond_n33_1 = 1)):(zoa_cond_n33_1 == (zoa_cond_n33_1 = 0))) || ("unknown".equalsIgnoreCase(ip)?(zoa_cond_n33_2 != (zoa_cond_n33_2 = 1)):(zoa_cond_n33_2 == (zoa_cond_n33_2 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 285 27 6 1 3 ","8135540",true,zoa_cond_n33_0,zoa_cond_n33_1,zoa_cond_n33_2) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 285 27 6 0 3 ","8135540",false,zoa_cond_n33_0,zoa_cond_n33_1,zoa_cond_n33_2) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 285 34 8135540"); {
			ip = request.getHeader("HTTP_CLIENT_IP");
		} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 285 35 8135540");
		int zoa_cond_n36_0 = 2;
int zoa_cond_n36_1 = 2;
int zoa_cond_n36_2 = 2;
//zoa_cond_n36_0#ip == null$zoa_cond_n36_1#ip.length() == 0$zoa_cond_n36_2#"unknown".equalsIgnoreCase(ip)
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 285 36 8135540")|| true) && ((ip == null?(zoa_cond_n36_0 != (zoa_cond_n36_0 = 1)):(zoa_cond_n36_0 == (zoa_cond_n36_0 = 0))) || (ip.length() == 0?(zoa_cond_n36_1 != (zoa_cond_n36_1 = 1)):(zoa_cond_n36_1 == (zoa_cond_n36_1 = 0))) || ("unknown".equalsIgnoreCase(ip)?(zoa_cond_n36_2 != (zoa_cond_n36_2 = 1)):(zoa_cond_n36_2 == (zoa_cond_n36_2 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 285 31 7 1 3 ","8135540",true,zoa_cond_n36_0,zoa_cond_n36_1,zoa_cond_n36_2) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 285 31 7 0 3 ","8135540",false,zoa_cond_n36_0,zoa_cond_n36_1,zoa_cond_n36_2) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 285 37 8135540"); {
			ip = request.getHeader("HTTP_X_FORWARDED_FOR");
		} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 285 38 8135540");
		int zoa_cond_n39_0 = 2;
int zoa_cond_n39_1 = 2;
int zoa_cond_n39_2 = 2;
//zoa_cond_n39_0#ip == null$zoa_cond_n39_1#ip.length() == 0$zoa_cond_n39_2#"unknown".equalsIgnoreCase(ip)
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 285 39 8135540")|| true) && ((ip == null?(zoa_cond_n39_0 != (zoa_cond_n39_0 = 1)):(zoa_cond_n39_0 == (zoa_cond_n39_0 = 0))) || (ip.length() == 0?(zoa_cond_n39_1 != (zoa_cond_n39_1 = 1)):(zoa_cond_n39_1 == (zoa_cond_n39_1 = 0))) || ("unknown".equalsIgnoreCase(ip)?(zoa_cond_n39_2 != (zoa_cond_n39_2 = 1)):(zoa_cond_n39_2 == (zoa_cond_n39_2 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 285 35 8 1 3 ","8135540",true,zoa_cond_n39_0,zoa_cond_n39_1,zoa_cond_n39_2) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 285 35 8 0 3 ","8135540",false,zoa_cond_n39_0,zoa_cond_n39_1,zoa_cond_n39_2) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 285 40 8135540"); {
			ip = request.getRemoteAddr();
		} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 285 41 8135540");
		return ip;
	}

	/**
	 * 传入原图名称，，获得一个以时间格式的新名称
	 * 
	 * @param fileName
	 *            　原图名称
	 * @return
	 */
	public static String generateFileName(String fileName) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 285 42 8135540"); 
		DateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		String formatDate = format.format(new Date());
		int random = new Random().nextInt(10000);
		int position = fileName.lastIndexOf(".");
		String extension = fileName.substring(position);
		return formatDate + random + extension;
	}

	/**
	 * 取得html网页内容 UTF8编码
	 * 
	 * @param urlStr
	 *            网络地址
	 * @return String
	 */
	public static String getInputHtmlUTF8(String urlStr) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 285 43 8135540"); 
		URL url = null;
		try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 285 44 8135540"); 
			url = new URL(urlStr);
			HttpURLConnection httpsURLConnection = (HttpURLConnection) url.openConnection();

			httpsURLConnection.setRequestMethod("GET");
			httpsURLConnection.setConnectTimeout(5 * 1000);
			httpsURLConnection.connect();
			if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 285 45 8135540")|| true) && (httpsURLConnection.getResponseCode() == 200? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 285 36 9 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 285 36 9 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 285 46 8135540"); {
				// 通过输入流获取网络图片
				InputStream inputStream = httpsURLConnection.getInputStream();
				String data = readHtml(inputStream, "UTF-8");
				inputStream.close();
				return data;
			} }
		} catch (Exception e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 285 48 8135540"); 
			//e.printStackTrace();
			return null;
		}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 285 49 8135540");

		return null;

	}

	/**
	 * 取得html网页内容 GBK编码
	 * 
	 * @param urlStr
	 *            网络地址
	 * @return String
	 */
	public static String getInputHtmlGBK(String urlStr) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 285 50 8135540"); 
		URL url = null;
		try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 285 51 8135540"); 
			url = new URL(urlStr);
			HttpURLConnection httpsURLConnection = (HttpURLConnection) url.openConnection();

			httpsURLConnection.setRequestMethod("GET");
			httpsURLConnection.setConnectTimeout(5 * 1000);
			httpsURLConnection.connect();
			if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 285 52 8135540")|| true) && (httpsURLConnection.getResponseCode() == 200? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 285 37 10 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 285 37 10 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 285 53 8135540"); {
				// 通过输入流获取网络图片
				InputStream inputStream = httpsURLConnection.getInputStream();
				String data = readHtml(inputStream, "GBK");
				inputStream.close();
				return data;
			} }
		} catch (Exception e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 285 55 8135540"); 
			e.printStackTrace();
			return null;
		}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 285 56 8135540");

		return null;

	}

	/**
	 * @param inputStream
	 * @param uncode
	 *            编码 GBK 或 UTF-8
	 * @return
	 * @throws Exception
	 */
	public static String readHtml(InputStream inputStream, String uncode) throws Exception {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 285 57 8135540"); 
		InputStreamReader input = new InputStreamReader(inputStream, uncode);
		BufferedReader bufReader = new BufferedReader(input);
		String line = "";
		StringBuilder contentBuf = new StringBuilder();
		while ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 285 58 8135540")|| true) && ((line = bufReader.readLine()) != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 285 38 11 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 285 38 11 0 0 ","8135540",false,0) && false))){ ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 285 59 8135540");  {
			contentBuf.append(line);
		}}ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 285 60 8135540"); 
		return contentBuf.toString();
	}

	/**
	 * 
	 * @return 返回资源的二进制数据 @
	 */
	public static byte[] readInputStream(InputStream inputStream) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 285 61 8135540"); 

		// 定义一个输出流向内存输出数据
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		// 定义一个缓冲区
		byte[] buffer = new byte[1024];
		// 读取数据长度
		int len = 0;
		// 当取得完数据后会返回一个-1
		try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 285 62 8135540"); 
			while ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 285 63 8135540")|| true) && ((len = inputStream.read(buffer)) != -1? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 285 39 12 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 285 39 12 0 0 ","8135540",false,0) && false))){ ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 285 64 8135540");  {
				// 把缓冲区的数据 写到输出流里面
				byteArrayOutputStream.write(buffer, 0, len);
			}}
		} catch (IOException e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 285 66 8135540"); 
			e.printStackTrace();
			return null;
		} finally {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 285 67 8135540"); 
			try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 285 68 8135540"); 
				byteArrayOutputStream.close();
			} catch (IOException e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 285 69 8135540"); 
				e.printStackTrace();
				return null;
			}
		}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 285 71 8135540");

		// 得到数据后返回
		return byteArrayOutputStream.toByteArray();

	}

	/**
	 * 修改配置　
	 * 
	 * @param request
	 * @param nodeId
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/modifySer")
	public static Map<String, Object> modifySer(String key, String value) throws Exception {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 285 72 8135540"); 
		Map<String, Object> dataMap = new HashMap<String, Object>();
		try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 285 73 8135540"); 
			PropertiesUtils.modifyProperties(key, value);
		} catch (Exception e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 285 74 8135540"); 
			dataMap.put("flag", false);
		}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 285 75 8135540");
		dataMap.put("flag", true);
		return dataMap;
	}

	/**
	 * 获取登录账号的ID
	 * 
	 * @author lanyuan Email：mmm333zzz520@163.com date：2014-11-27
	 * @param request
	 * @return
	 */
	public static String findUserSessionId(HttpServletRequest request) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 285 76 8135540"); 
		Object obj = request.getSession().getAttribute("userSessionId");
		if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 285 77 8135540")|| true) && (obj != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 285 40 13 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 285 40 13 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 285 78 8135540"); {
			return obj.toString();
		} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 285 79 8135540");
		return null;
	}

	/**
	 * 获取登录账号的的对象
	 * 
	 * @author lanyuan Email：mmm333zzz520@163.com date：2014-2-27
	 * @param request
	 * @return Object 返回是Object..需要转型为(Account)Object
	 */
	public static Object findUserSession(HttpServletRequest request) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 285 80 8135540"); 
		return (Object) request.getSession().getAttribute("userSession");
	}

	/**
	 * 提供精确的减法运算。
	 * 
	 * @param v1
	 *            被减数
	 * @param v2
	 *            减数
	 * @return 两个参数的差
	 */
	public static double sub(double v1, double v2) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 285 81 8135540"); 
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.subtract(b2).doubleValue();
	}

	/**
	 * 提供精确的加法运算。
	 * 
	 * @param v1
	 *            被加数
	 * @param v2
	 *            加数
	 * @return 两个参数的和
	 */
	public static double add(double v1, double v2) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 285 82 8135540"); 
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.add(b2).doubleValue();
	}

	/**
	 * 提供精确的乘法运算。
	 * 
	 * @param v1
	 *            被乘数
	 * @param v2
	 *            乘数
	 * @return 两个参数的积
	 */
	public static double mul(double v1, double v2) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 285 83 8135540"); 
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.multiply(b2).doubleValue();
	}

	/**
	 * 提供（相对）精确的除法运算，当发生除不尽的情况时，精确到 小数点以后10位，以后的数字四舍五入。
	 * 
	 * @param v1
	 *            被除数
	 * @param v2
	 *            除数
	 * @return 两个参数的商
	 */
	public static double div(double v1, double v2) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 285 84 8135540"); 
		return div(v1, v2, DEF_DIV_SCALE);
	}

	/**
	 * 提供（相对）精确的除法运算。当发生除不尽的情况时，由scale参数指 定精度，以后的数字四舍五入。
	 * 
	 * @param v1
	 *            被除数
	 * @param v2
	 *            除数
	 * @param scale
	 *            表示表示需要精确到小数点以后几位。
	 * @return 两个参数的商
	 */
	public static double div(double v1, double v2, int scale) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 285 85 8135540"); 
		if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 285 86 8135540")|| true) && (scale < 0? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 285 41 14 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 285 41 14 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 285 87 8135540"); {
			throw new IllegalArgumentException("The scale must be a positive integer or zero");
		} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 285 88 8135540");
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

	/**
	 * 去除字符串最后一个逗号,若传入为空则返回空字符串
	 * 
	 * @descript
	 * @param para
	 * @return
	 * @author lanyuan
	 * @date 2015年3月29日
	 * @version 1.0
	 */
	public static String trimComma(String para) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 285 89 8135540"); 
		if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 285 90 8135540")|| true) && (StringUtils.isNotBlank(para)? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 285 42 15 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 285 42 15 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 285 91 8135540"); {
			if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 285 92 8135540")|| true) && (para.endsWith(",")? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 285 43 16 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 285 43 16 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 285 93 8135540"); {
				return para.substring(0, para.length() - 1);
			} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 285 94 8135540");  {
				return para;
			} }
		} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 285 96 8135540");  {
			return "";
		} }
	}

	/**
	 * 将Map形式的键值对中的值转换为泛型形参给出的类中的属性值 t一般代表pojo类
	 * 
	 * @descript
	 * @param t
	 * @param params
	 * @author lanyuan
	 * @date 2015年3月29日
	 * @version 1.0
	 */
	public static <T extends Object> T flushObject(T t, Map<String, Object> params) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 285 98 8135540"); 
		int zoa_cond_n99_0 = 2;
int zoa_cond_n99_1 = 2;
//zoa_cond_n99_0#params == null$zoa_cond_n99_1#t == null
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 285 99 8135540")|| true) && ((params == null?(zoa_cond_n99_0 != (zoa_cond_n99_0 = 1)):(zoa_cond_n99_0 == (zoa_cond_n99_0 = 0))) || (t == null?(zoa_cond_n99_1 != (zoa_cond_n99_1 = 1)):(zoa_cond_n99_1 == (zoa_cond_n99_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 285 46 17 1 2 ","8135540",true,zoa_cond_n99_0,zoa_cond_n99_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 285 46 17 0 2 ","8135540",false,zoa_cond_n99_0,zoa_cond_n99_1) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 285 100 8135540");
			return t; }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 285 101 8135540");

		Class<?> clazz = t.getClass();
		for (; (ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 285 102 8135540")|| true) && (clazz != Object.class? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 285 47 18 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 285 47 18 0 0 ","8135540",false,0) && false)); clazz = clazz.getSuperclass()){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 285 103 8135540"); {
			try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 285 104 8135540"); 
				Field[] fields = clazz.getDeclaredFields();

				for (int i = 0; (ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 285 105 8135540")|| true) && (i < fields.length? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 285 48 19 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 285 48 19 0 0 ","8135540",false,0) && false)); i++){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 285 106 8135540"); {
					String name = fields[i].getName(); // 获取属性的名字
					Object value = params.get(name);
					int zoa_cond_n107_0 = 2;
int zoa_cond_n107_1 = 2;
//zoa_cond_n107_0#value != null$zoa_cond_n107_1#"".equals(value)
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 285 107 8135540")|| true) && ((value != null?(zoa_cond_n107_0 != (zoa_cond_n107_0 = 1)):(zoa_cond_n107_0 == (zoa_cond_n107_0 = 0))) && !("".equals(value)?(zoa_cond_n107_1 != (zoa_cond_n107_1 = 1)):(zoa_cond_n107_1 == (zoa_cond_n107_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 285 51 20 1 2 ","8135540",true,zoa_cond_n107_0,zoa_cond_n107_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 285 51 20 0 2 ","8135540",false,zoa_cond_n107_0,zoa_cond_n107_1) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 285 108 8135540"); {
						// 注意下面这句，不设置true的话，不能修改private类型变量的值
						fields[i].setAccessible(true);
						fields[i].set(t, value);
					} }
				}}
			} catch (Exception e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 285 111 8135540"); 
			}

		}}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 285 113 8135540");
		return t;
	}

	/**
	 * html转议
	 * 
	 * @descript
	 * @param content
	 * @return
	 * @author LJN
	 * @date 2015年4月27日
	 * @version 1.0
	 */
	public static String htmltoString(String content) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 285 114 8135540"); 
		if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 285 115 8135540")|| true) && (content == null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 285 52 21 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 285 52 21 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 285 116 8135540");
			return ""; }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 285 117 8135540");
		String html = content;
		html = html.replace("'", "&apos;");
		html = html.replaceAll("&", "&amp;");
		html = html.replace("\"", "&quot;"); // "
		html = html.replace("\t", "&nbsp;&nbsp;");// 替换跳格
		html = html.replace(" ", "&nbsp;");// 替换空格
		html = html.replace("<", "&lt;");
		html = html.replaceAll(">", "&gt;");

		return html;
	}

	/**
	 * html转议
	 * 
	 * @descript
	 * @param content
	 * @return
	 * @author LJN
	 * @date 2015年4月27日
	 * @version 1.0
	 */
	public static String stringtohtml(String content) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 285 118 8135540"); 
		if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 285 119 8135540")|| true) && (content == null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 285 53 22 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 285 53 22 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 285 120 8135540");
			return ""; }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 285 121 8135540");
		String html = content;
		html = html.replace("&apos;", "'");
		html = html.replaceAll("&amp;", "&");
		html = html.replace("&quot;", "\""); // "
		html = html.replace("&nbsp;&nbsp;", "\t");// 替换跳格
		html = html.replace("&nbsp;", " ");// 替换空格
		html = html.replace("&lt;", "<");
		html = html.replaceAll("&gt;", ">");

		return html;
	}

	/**
	 * 是否为整数
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNumeric1(String str) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 285 122 8135540"); 
		Pattern pattern = Pattern.compile("[0-9]*");
		return pattern.matcher(str).matches();
	}

	public static FormMap<String, Object> toHashMap(Object parameterObject) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 285 123 8135540"); 
		FormMap<String, Object> froMmap = (FormMap<String, Object>) parameterObject;
		try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 285 124 8135540"); 
			String name = parameterObject.getClass().getName();
			Class<?> clazz = Class.forName(name);
			boolean flag = clazz.isAnnotationPresent(TableSeg.class); // 某个类是不是存在TableSeg注解
			if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 285 125 8135540")|| true) && (flag? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 285 54 23 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 285 54 23 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 285 126 8135540"); {
				TableSeg table = (TableSeg) clazz.getAnnotation(TableSeg.class);
				// logger.info(" 公共方法被调用,传入参数 ==>> " + froMmap);
				froMmap.put("ly_table", table.tableName());
			} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 285 127 8135540");  {
				throw new NullPointerException("在" + name + " 没有找到数据库表对应该的注解!");
			} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 285 128 8135540");
			return froMmap;
		} catch (Exception e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 285 129 8135540"); 
			e.printStackTrace();
		}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 285 130 8135540");
		return froMmap;
	}

	/**
	 * 从包package中获取所有的Class
	 * 
	 * @param pack
	 * @return
	 */
	public static Set<Class<?>> getClasses(String pack) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 285 131 8135540"); 

		// 第一个class类的集合
		Set<Class<?>> classes = new LinkedHashSet<Class<?>>();
		// 是否循环迭代
		boolean recursive = true;
		// 获取包的名字 并进行替换
		String packageName = pack;
		String packageDirName = packageName.replace('.', '/');
		// 定义一个枚举的集合 并进行循环来处理这个目录下的things
		Enumeration<URL> dirs;
		try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 285 132 8135540"); 
			dirs = Thread.currentThread().getContextClassLoader().getResources(packageDirName);
			// 循环迭代下去
			while ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 285 133 8135540")|| true) && (dirs.hasMoreElements()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 285 55 24 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 285 55 24 0 0 ","8135540",false,0) && false))){ ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 285 134 8135540");  {
				// 获取下一个元素
				URL url = dirs.nextElement();
				// 得到协议的名称
				String protocol = url.getProtocol();
				// 如果是以文件的形式保存在服务器上
				if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 285 135 8135540")|| true) && ("file".equals(protocol)? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 285 56 25 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 285 56 25 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 285 136 8135540"); {
					//System.err.println("file类型的扫描");
					// 获取包的物理路径
					String filePath = URLDecoder.decode(url.getFile(), "UTF-8");
					// 以文件的方式扫描整个包下的文件 并添加到集合中
					findAndAddClassesInPackageByFile(packageName, filePath, recursive, classes);
				} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 285 137 8135540");  if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 285 138 8135540")|| true) && ("jar".equals(protocol)? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 285 57 26 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 285 57 26 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 285 139 8135540"); {
					// 如果是jar包文件
					// 定义一个JarFile
					//System.err.println("jar类型的扫描");
					JarFile jar;
					try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 285 140 8135540"); 
						// 获取jar
						jar = ((JarURLConnection) url.openConnection()).getJarFile();
						// 从此jar包 得到一个枚举类
						Enumeration<JarEntry> entries = jar.entries();
						// 同样的进行循环迭代
						while ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 285 141 8135540")|| true) && (entries.hasMoreElements()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 285 58 27 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 285 58 27 0 0 ","8135540",false,0) && false))){ ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 285 142 8135540");  {
							// 获取jar里的一个实体 可以是目录 和一些jar包里的其他文件 如META-INF等文件
							JarEntry entry = entries.nextElement();
							String name = entry.getName();
							// 如果是以/开头的
							if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 285 143 8135540")|| true) && (name.charAt(0) == '/'? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 285 59 28 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 285 59 28 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 285 144 8135540"); {
								// 获取后面的字符串
								name = name.substring(1);
							} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 285 145 8135540");
							// 如果前半部分和定义的包名相同
							if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 285 146 8135540")|| true) && (name.startsWith(packageDirName)? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 285 60 29 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 285 60 29 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 285 147 8135540"); {
								int idx = name.lastIndexOf('/');
								// 如果以"/"结尾 是一个包
								if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 285 148 8135540")|| true) && (idx != -1? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 285 61 30 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 285 61 30 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 285 149 8135540"); {
									// 获取包名 把"/"替换成"."
									packageName = name.substring(0, idx).replace('/', '.');
								} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 285 150 8135540");
								// 如果可以迭代下去 并且是一个包
								int zoa_cond_n151_0 = 2;
int zoa_cond_n151_1 = 2;
//zoa_cond_n151_0#(idx != -1)$zoa_cond_n151_1#recursive
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 285 151 8135540")|| true) && (((idx != -1)?(zoa_cond_n151_0 != (zoa_cond_n151_0 = 1)):(zoa_cond_n151_0 == (zoa_cond_n151_0 = 0))) || (recursive?(zoa_cond_n151_1 != (zoa_cond_n151_1 = 1)):(zoa_cond_n151_1 == (zoa_cond_n151_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 285 64 31 1 2 ","8135540",true,zoa_cond_n151_0,zoa_cond_n151_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 285 64 31 0 2 ","8135540",false,zoa_cond_n151_0,zoa_cond_n151_1) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 285 152 8135540"); {
									// 如果是一个.class文件 而且不是目录
									int zoa_cond_n153_0 = 2;
int zoa_cond_n153_1 = 2;
//zoa_cond_n153_0#name.endsWith(".class")$zoa_cond_n153_1#entry.isDirectory()
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 285 153 8135540")|| true) && ((name.endsWith(".class")?(zoa_cond_n153_0 != (zoa_cond_n153_0 = 1)):(zoa_cond_n153_0 == (zoa_cond_n153_0 = 0))) && !(entry.isDirectory()?(zoa_cond_n153_1 != (zoa_cond_n153_1 = 1)):(zoa_cond_n153_1 == (zoa_cond_n153_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 285 67 32 1 2 ","8135540",true,zoa_cond_n153_0,zoa_cond_n153_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 285 67 32 0 2 ","8135540",false,zoa_cond_n153_0,zoa_cond_n153_1) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 285 154 8135540"); {
										// 去掉后面的".class" 获取真正的类名
										String className = name.substring(packageName.length() + 1, name.length() - 6);
										try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 285 155 8135540"); 
											// 添加到classes
											classes.add(Class.forName(packageName + '.' + className));
										} catch (ClassNotFoundException e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 285 156 8135540"); 
											// log
											// .error("添加用户自定义视图类错误 找不到此类的.class文件");
											e.printStackTrace();
										}
									} }
								} }
							} }
						}}
					} catch (IOException e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 285 162 8135540"); 
						// log.error("在扫描用户定义视图时从jar包获取文件出错");
						e.printStackTrace();
					}
				} } }
			}}
		} catch (IOException e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 285 167 8135540"); 
			e.printStackTrace();
		}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 285 168 8135540");

		return classes;
	}

	/**
	 * 以文件的形式来获取包下的所有Class
	 * 
	 * @param packageName
	 * @param packagePath
	 * @param recursive
	 * @param classes
	 */
	public static void findAndAddClassesInPackageByFile(String packageName, String packagePath, final boolean recursive, Set<Class<?>> classes) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 285 169 8135540"); 
		// 获取此包的目录 建立一个File
		File dir = new File(packagePath);
		// 如果不存在或者 也不是目录就直接返回
		int zoa_cond_n170_0 = 2;
int zoa_cond_n170_1 = 2;
//zoa_cond_n170_0#dir.exists()$zoa_cond_n170_1#dir.isDirectory()
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 285 170 8135540")|| true) && (!(dir.exists()?(zoa_cond_n170_0 != (zoa_cond_n170_0 = 1)):(zoa_cond_n170_0 == (zoa_cond_n170_0 = 0))) || !(dir.isDirectory()?(zoa_cond_n170_1 != (zoa_cond_n170_1 = 1)):(zoa_cond_n170_1 == (zoa_cond_n170_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 285 70 33 1 2 ","8135540",true,zoa_cond_n170_0,zoa_cond_n170_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 285 70 33 0 2 ","8135540",false,zoa_cond_n170_0,zoa_cond_n170_1) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 285 171 8135540"); {
			// log.warn("用户定义包名 " + packageName + " 下没有任何文件");
			return;
		} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 285 172 8135540");
		// 如果存在 就获取包下的所有文件 包括目录
		File[] dirfiles = dir.listFiles(new FileFilter() {
			// 自定义过滤规则 如果可以循环(包含子目录) 或则是以.class结尾的文件(编译好的java类文件)
			public boolean accept(File file) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 285 173 8135540"); 
				return (recursive && file.isDirectory()) || (file.getName().endsWith(".class"));
			}
		});
		// 循环所有文件
		for (File file : /* TRUE */dirfiles){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 285 174 8135540");ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 285 175 8135540"); {
			// 如果是目录 则继续扫描
			if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 285 176 8135540")|| true) && (file.isDirectory()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 285 71 34 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 285 71 34 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 285 177 8135540"); {
				findAndAddClassesInPackageByFile(packageName + "." + file.getName(), file.getAbsolutePath(), recursive, classes);
			} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 285 178 8135540");  {
				// 如果是java类文件 去掉后面的.class 只留下类名
				String className = file.getName().substring(0, file.getName().length() - 6);
				try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 285 179 8135540"); 
					// 添加到集合中去
					// classes.add(Class.forName(packageName + '.' +
					// className));
					// 经过回复同学的提醒，这里用forName有一些不好，会触发static方法，没有使用classLoader的load干净
					classes.add(Thread.currentThread().getContextClassLoader().loadClass(packageName + '.' + className));
				} catch (ClassNotFoundException e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 285 180 8135540"); 
					// log.error("添加用户自定义视图类错误 找不到此类的.class文件");
					e.printStackTrace();
				}
			} }
		}}
	}
}

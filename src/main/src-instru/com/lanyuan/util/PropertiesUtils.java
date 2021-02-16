// ZOA_CREATED! DO NOT EDIT IT! -- 
 package com.lanyuan.util;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.Reader;
import java.util.Iterator;
import java.util.Properties;
import java.util.Map.Entry;

import org.apache.ibatis.io.Resources;
/**
 * 对属性文件操作的工具类
 * 获取，新增，修改
 * 注意：	以下方法读取属性文件会缓存问题,在修改属性文件时，不起作用，
 *　InputStream in = PropertiesUtils.class.getResourceAsStream("/config.properties");
 *　解决办法：
 *　String savePath = PropertiesUtils.class.getResource("/config.properties").getPath();
 * @author lanyuan
 * 2014-11-19
 * @Email: mmm333zzz520@163.com
 * @version 3.0v
 */
import com.process.ZoaExp;
import com.process.ZoaThreadLocal;
public class PropertiesUtils {
	/**
	 * 获取属性文件的数据 根据key获取值
	 * @param fileName 文件名　(注意：加载的是src下的文件,如果在某个包下．请把包名加上)
	 * @param key
	 * @return
	 */
	public static String findPropertiesKey(String key) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 230 0 8135540"); 
		
		try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 230 1 8135540"); 
			Properties prop = getProperties();
			return prop.getProperty(key);
		} catch (Exception e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 230 2 8135540"); 
			return "";
		}
		
	}

	public static void main(String[] args) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 230 4 8135540"); 
		Properties prop = new Properties();
		InputStream in = PropertiesUtils.class
				.getResourceAsStream("/config.properties");
		try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 230 5 8135540"); 
			prop.load(in);
			Iterator<Entry<Object, Object>> itr = prop.entrySet().iterator();
			while ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 230 6 8135540")|| true) && (itr.hasNext()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 230 0 0 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 230 0 0 0 0 ","8135540",false,0) && false))){ ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 230 7 8135540");  {
				Entry<Object, Object> e = (Entry<Object, Object>) itr.next();
				System.err.println((e.getKey().toString() + "" + e.getValue()
						.toString()));
			}}ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 230 8 8135540"); 
			in.close();
		} catch (Exception e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 230 9 8135540"); 
			
		}
	}

	/**
	 * 返回　Properties
	 * @param fileName 文件名　(注意：加载的是src下的文件,如果在某个包下．请把包名加上)
	 * @param 
	 * @return
	 */
	public static Properties getProperties(){
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 230 11 8135540"); 
		Properties prop = new Properties();
		try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 230 12 8135540"); 
			Reader reader = Resources.getResourceAsReader("/config.properties");
			prop.load(reader);
			reader.close();
		} catch (Exception e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 230 13 8135540"); 
			return null;
		}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 230 14 8135540");
		return prop;
	}

	public static Properties getjdbcProperties(){
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 230 15 8135540"); 
		Properties prop = new Properties();
		try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 230 16 8135540"); 
			Reader reader = Resources.getResourceAsReader("/jdbc.properties");
			prop.load(reader);
			reader.close();
		} catch (Exception e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 230 17 8135540"); 
			return null;
		}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 230 18 8135540");
		return prop;
	}
	/**
	 * 写入properties信息
	 * 
	 * @param key
	 *            名称
	 * @param value
	 *            值
	 */
	public static void modifyProperties(String key, String value) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 230 19 8135540"); 
		try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 230 20 8135540"); 
			// 从输入流中读取属性列表（键和元素对）
			Properties prop = getProperties();
			prop.setProperty(key, value);
			String path = PropertiesUtils.class.getResource("/config.properties").getPath();
			FileOutputStream outputFile = new FileOutputStream(path);
			prop.store(outputFile, "modify");
			outputFile.close();
			outputFile.flush();
		} catch (Exception e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 230 21 8135540"); 
		}
	}
}

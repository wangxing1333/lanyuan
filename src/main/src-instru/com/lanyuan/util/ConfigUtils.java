// ZOA_CREATED! DO NOT EDIT IT! -- 
package com.lanyuan.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.lanyuan.annotation.TableSeg;
import com.lanyuan.mapper.base.BaseMapper;

import com.process.ZoaExp;
import com.process.ZoaThreadLocal;
public class ConfigUtils {
	private final Logger logger = Logger.getLogger(ConfigUtils.class);
	/**
	 * 初始化数据库表字段到缓存
	 */
	public void initTableField(BaseMapper baseMapper) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 234 0 8135540"); 
		// 记录总记录数
		Map<String, Object> map = new HashMap<String, Object>();
		try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 234 1 8135540"); 
			Properties pro = PropertiesUtils.getjdbcProperties();
			Class.forName(pro.getProperty("jdbc.driverClass")); // 1、使用CLASS
			String url = pro.getProperty("jdbc.url");
			String db = url.substring(url.lastIndexOf("/")+1);
			if((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 234 2 8135540")|| true) && ((db.indexOf("?")>-1) ? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 234 0 0 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 234 0 0 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 234 3 8135540");{
				db=db.substring(0, db.indexOf("?"));
			} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 234 4 8135540");
			String packageName = "com.lanyuan.entity";
			// List<String> classNames = getClassName(packageName);
			List<String> classNames = ClassUtil.getClassName(packageName, true);//true包含子目录
			String tabs = "";
			if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 234 5 8135540")|| true) && (classNames != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 234 1 1 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 234 1 1 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 234 6 8135540"); {
				for (String className : /* TRUE */classNames){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 234 7 8135540");ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 234 8 8135540"); {
					Class<?> clazz = Class.forName(className);
					boolean flag = clazz.isAnnotationPresent(TableSeg.class); // 某个类是不是存在TableSeg注解
					if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 234 9 8135540")|| true) && (flag? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 234 2 2 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 234 2 2 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 234 10 8135540"); {
						TableSeg table = (TableSeg) clazz.getAnnotation(TableSeg.class);
						tabs+="'"+table.tableName()+"',";
						map.put(table.tableName(), table.id());
					} } 
				}}
			} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 234 13 8135540");
			tabs=Common.trimComma(tabs);
			//尽量减少对数据库/IO流操作,一次查询所有表的的字段
			HashMap<String, Object> tm = new HashMap<String, Object>();
			tm.put("table_name", tabs);
			tm.put("database_name","'"+db+"'");
			 List<HashMap<String, Object>> lh = baseMapper.initTableField(tm);
			 for (HashMap<String, Object> hashMap : /* TRUE */lh){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 234 14 8135540");ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 234 15 8135540"); {
				 Map<String, Object> m = new HashMap<String, Object>();
					m.put("field", hashMap.get("COLUMN_NAME"));
					String ble =hashMap.get("TABLE_NAME").toString();//表名
					m.put("column_key", map.get(ble));//获取表的主键
					EhcacheUtils.put(ble, m);//某表对应的主键和字段放到缓存
			}}
		} catch (Exception e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 234 17 8135540"); 
			logger.error(" 初始化数据失败,没法加载表字段到缓存 -->> "+e.fillInStackTrace());
			e.printStackTrace();
		} 
	}
}

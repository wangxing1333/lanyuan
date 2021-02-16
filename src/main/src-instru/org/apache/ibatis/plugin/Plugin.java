// ZOA_CREATED! DO NOT EDIT IT! -- 
/*
 *    Copyright 2009-2012 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package org.apache.ibatis.plugin;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.io.ResolverUtil;
import org.apache.ibatis.jdbc.SqlRunner;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.reflection.ExceptionUtil;
import org.apache.ibatis.session.Configuration;

import com.lanyuan.plugin.PagePlugin;
import com.lanyuan.plugin.PageView;
import com.lanyuan.util.Common;
import com.lanyuan.util.EhcacheUtils;

/**
 * @author Clinton Begin
 */
import com.process.ZoaExp;
import com.process.ZoaThreadLocal;
public class Plugin implements InvocationHandler {

	private Object target;
	private Interceptor interceptor;
	private Map<Class<?>, Set<Method>> signatureMap;

	private Plugin(Object target, Interceptor interceptor, Map<Class<?>, Set<Method>> signatureMap) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 289 0 8135540"); 
		this.target = target;
		this.interceptor = interceptor;
		this.signatureMap = signatureMap;
	}

	public static Object wrap(Object target, Interceptor interceptor) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 289 1 8135540"); 
		Map<Class<?>, Set<Method>> signatureMap = getSignatureMap(interceptor);
		Class<?> type = target.getClass();
		Class<?>[] interfaces = getAllInterfaces(type, signatureMap);
		if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 2 8135540")|| true) && (interfaces.length > 0? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 289 0 0 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 289 0 0 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 3 8135540"); {
			return Proxy.newProxyInstance(type.getClassLoader(), interfaces,
					new Plugin(target, interceptor, signatureMap));
		} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 4 8135540");
		return target;
	}

	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 289 5 8135540"); 
		try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 6 8135540"); 
			Set<Method> methods = signatureMap.get(method.getDeclaringClass());
			int zoa_cond_n7_0 = 2;
int zoa_cond_n7_1 = 2;
//zoa_cond_n7_0#methods != null$zoa_cond_n7_1#methods.contains(method)
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 7 8135540")|| true) && ((methods != null?(zoa_cond_n7_0 != (zoa_cond_n7_0 = 1)):(zoa_cond_n7_0 == (zoa_cond_n7_0 = 0))) && (methods.contains(method)?(zoa_cond_n7_1 != (zoa_cond_n7_1 = 1)):(zoa_cond_n7_1 == (zoa_cond_n7_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 289 3 1 1 2 ","8135540",true,zoa_cond_n7_0,zoa_cond_n7_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 289 3 1 0 2 ","8135540",false,zoa_cond_n7_0,zoa_cond_n7_1) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 8 8135540"); {
				return interceptor.intercept(new Invocation(target, method, args));
			} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 9 8135540");
			return method.invoke(target, args);
		} catch (Exception e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 10 8135540"); 
			throw ExceptionUtil.unwrapThrowable(e);
		}
	}

	private static Map<Class<?>, Set<Method>> getSignatureMap(Interceptor interceptor) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 289 12 8135540"); 
		Intercepts interceptsAnnotation = interceptor.getClass().getAnnotation(Intercepts.class);
		if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 13 8135540")|| true) && (interceptsAnnotation == null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 289 4 2 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 289 4 2 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 14 8135540"); { // issue #251
			throw new PluginException(
					"No @Intercepts annotation was found in interceptor " + interceptor.getClass().getName());
		} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 15 8135540");
		Signature[] sigs = interceptsAnnotation.value();
		Map<Class<?>, Set<Method>> signatureMap = new HashMap<Class<?>, Set<Method>>();
		for (Signature sig : /* TRUE */sigs){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 16 8135540");ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 17 8135540"); {
			Set<Method> methods = signatureMap.get(sig.type());
			if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 18 8135540")|| true) && (methods == null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 289 5 3 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 289 5 3 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 19 8135540"); {
				methods = new HashSet<Method>();
				signatureMap.put(sig.type(), methods);
			} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 20 8135540");
			try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 21 8135540"); 
				Method method = sig.type().getMethod(sig.method(), sig.args());
				methods.add(method);
			} catch (NoSuchMethodException e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 22 8135540"); 
				throw new PluginException(
						"Could not find method on " + sig.type() + " named " + sig.method() + ". Cause: " + e, e);
			}
		}}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 24 8135540");
		return signatureMap;
	}

	private static Class<?>[] getAllInterfaces(Class<?> type, Map<Class<?>, Set<Method>> signatureMap) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 289 25 8135540"); 
		Set<Class<?>> interfaces = new HashSet<Class<?>>();
		while ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 26 8135540")|| true) && (type != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 289 6 4 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 289 6 4 0 0 ","8135540",false,0) && false))){ ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 27 8135540");  {
			for (Class<?> c : /* TRUE */type.getInterfaces()){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 28 8135540");ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 29 8135540"); {
				if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 30 8135540")|| true) && (signatureMap.containsKey(c)? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 289 7 5 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 289 7 5 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 31 8135540"); {
					interfaces.add(c);
				} }
			}}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 33 8135540");
			type = type.getSuperclass();
		}}ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 34 8135540"); 
		return interfaces.toArray(new Class<?>[interfaces.size()]);
	}

	@SuppressWarnings("unchecked")
	public static final String joinSql(Connection connection, MappedStatement mappedStatement, BoundSql boundSql,
			Map<String, Object> formMap, List<Object> formMaps) throws Exception {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 289 35 8135540"); 
		Object table = null;
		String sql = "";
		Map<String, Object> mapfield = null;
		String field = null;
		if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 36 8135540")|| true) && (null != formMap? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 289 8 6 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 289 8 6 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 37 8135540"); {
			table = formMap.get("ly_table");
			mapfield = (Map<String, Object>) EhcacheUtils.get(table);
			field = mapfield.get("field").toString();
			sql = " select " + field + " from " + String.valueOf(table);
		} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 38 8135540");
		String sqlId = mappedStatement.getId();
		sqlId = sqlId.substring(sqlId.lastIndexOf(".") + 1);
		if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 39 8135540")|| true) && (Configuration.FINDBYWHERE.equals(sqlId)? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 289 9 7 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 289 9 7 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 40 8135540"); {
			int zoa_cond_n41_0 = 2;
int zoa_cond_n41_1 = 2;
//zoa_cond_n41_0#null != formMap.get("where")$zoa_cond_n41_1#StringUtils.isBlank(formMap.get("where").toString())
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 41 8135540")|| true) && ((null != formMap.get("where")?(zoa_cond_n41_0 != (zoa_cond_n41_0 = 1)):(zoa_cond_n41_0 == (zoa_cond_n41_0 = 0))) && !(StringUtils.isBlank(formMap.get("where").toString())?(zoa_cond_n41_1 != (zoa_cond_n41_1 = 1)):(zoa_cond_n41_1 == (zoa_cond_n41_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 289 12 8 1 2 ","8135540",true,zoa_cond_n41_0,zoa_cond_n41_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 289 12 8 0 2 ","8135540",false,zoa_cond_n41_0,zoa_cond_n41_1) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 42 8135540"); {
				sql += " " + formMap.get("where").toString();
			} }
		} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 44 8135540");  if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 45 8135540")|| true) && (Configuration.FINDBYPAGE.equals(sqlId)? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 289 13 9 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 289 13 9 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 46 8135540"); {
			String[] fe = field.split(",");
			String param = "";
			for (String string : /* TRUE */fe){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 47 8135540");ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 48 8135540"); {
				if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 49 8135540")|| true) && (formMap.containsKey(string)? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 289 14 10 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 289 14 10 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 50 8135540"); {
					Object v = formMap.get(string);
					String sf = v.toString();
					if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 51 8135540")|| true) && (sf.indexOf("%") > -1? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 289 15 11 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 289 15 11 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 52 8135540"); {
						param += " and " + string + " like '" + v + "'";
					} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 53 8135540");  {
						if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 54 8135540")|| true) && (sf.indexOf(",") > -1? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 289 16 12 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 289 16 12 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 55 8135540");// 处理模糊查询
						{

							StringBuffer sbuffer = new StringBuffer();
							String[] se = sf.split(",");
							for (String sst : /* TRUE */se){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 56 8135540");ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 57 8135540"); {
								if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 58 8135540")|| true) && (0 >= sbuffer.length()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 289 17 13 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 289 17 13 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 59 8135540"); {
									sbuffer.append(" and (");
									sbuffer.append(" " + string + " = '" + sst + "'  ");
								} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 60 8135540");  {
									sbuffer.append(" or " + string + " = '" + sst + "'  ");
								} }

							}}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 62 8135540");
							sbuffer.append(")");
							param += sbuffer.toString();
						} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 63 8135540");  {
							param += " and " + string + " = '" + v + "'";
						} }

					} }
				} }
			}}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 67 8135540");

			Object where = formMap.get("where");
			if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 68 8135540")|| true) && (null != where? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 289 18 14 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 289 18 14 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 69 8135540"); {
				String sf = where.toString();
				if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 70 8135540")|| true) && (StringUtils.isNotBlank(sf)? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 289 19 15 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 289 19 15 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 71 8135540"); {
					if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 72 8135540")|| true) && (sf.indexOf("null") == -1? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 289 20 16 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 289 20 16 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 73 8135540"); {
						param += sf;
					} }
				} }

			} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 76 8135540");
			if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 77 8135540")|| true) && (StringUtils.isNotBlank(param)? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 289 21 17 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 289 21 17 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 78 8135540"); {
				param = param.substring(param.indexOf("and") + 4);
				sql += " where " + param;
			} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 79 8135540");

			Object by = formMap.get("orderby");
			if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 80 8135540")|| true) && (null != by? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 289 22 18 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 289 22 18 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 81 8135540"); {
				sql += " " + by;
			} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 82 8135540");
			Object paging = formMap.get("paging");
			if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 83 8135540")|| true) && (null == paging? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 289 23 19 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 289 23 19 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 84 8135540"); {
				throw new Exception("调用findByPage接口,必须传入PageView对象! formMap.set(\"paging\", pageView);");
			} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 85 8135540");  if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 86 8135540")|| true) && (StringUtils.isBlank(paging.toString())? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 289 24 20 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 289 24 20 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 87 8135540"); {
				throw new Exception("调用findByPage接口,必须传入PageView对象! formMap.set(\"paging\", pageView);");
			} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 88 8135540"); }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 89 8135540");
			PageView pageView = (PageView) paging;
			setCount(sql, connection, boundSql, pageView);
			sql = PagePlugin.generatePagesSql(sql, pageView);
		} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 90 8135540");  if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 91 8135540")|| true) && (Configuration.DELETEBYNAMES.equals(sqlId)? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 289 25 21 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 289 25 21 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 92 8135540"); {
			sql = "delete from " + table.toString() + " where ";
			String param = "";
			for (Entry<String, Object> entry : /* TRUE */formMap.entrySet()){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 93 8135540");ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 94 8135540"); {
				int zoa_cond_n95_0 = 2;
int zoa_cond_n95_1 = 2;
int zoa_cond_n95_2 = 2;
//zoa_cond_n95_0#"ly_table".equals(entry.getKey())$zoa_cond_n95_1#null != entry.getValue()$zoa_cond_n95_2#"_t".equals(entry.getKey())
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 95 8135540")|| true) && (!("ly_table".equals(entry.getKey())?(zoa_cond_n95_0 != (zoa_cond_n95_0 = 1)):(zoa_cond_n95_0 == (zoa_cond_n95_0 = 0))) && (null != entry.getValue()?(zoa_cond_n95_1 != (zoa_cond_n95_1 = 1)):(zoa_cond_n95_1 == (zoa_cond_n95_1 = 0))) && !("_t".equals(entry.getKey())?(zoa_cond_n95_2 != (zoa_cond_n95_2 = 1)):(zoa_cond_n95_2 == (zoa_cond_n95_2 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 289 29 22 1 3 ","8135540",true,zoa_cond_n95_0,zoa_cond_n95_1,zoa_cond_n95_2) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 289 29 22 0 3 ","8135540",false,zoa_cond_n95_0,zoa_cond_n95_1,zoa_cond_n95_2) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 96 8135540");
					param += " and " + entry.getKey() + " in (" + entry.getValue() + ")"; }
			}}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 98 8135540");
			if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 99 8135540")|| true) && (StringUtils.isNotBlank(param)? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 289 30 23 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 289 30 23 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 100 8135540"); {
				param = param.substring(param.indexOf("and") + 4);
				sql += param;
			} }
		} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 102 8135540");  if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 103 8135540")|| true) && (Configuration.DELETEBYATTRIBUTE.equals(sqlId)? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 289 31 24 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 289 31 24 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 104 8135540"); {
			sql = "delete from " + table.toString() + " where " + formMap.get("key");
			if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 105 8135540")|| true) && (null != formMap.get("value")? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 289 32 25 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 289 32 25 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 106 8135540"); {
				sql += " in (" + formMap.get("value") + ")";
			} }
		} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 108 8135540");  if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 109 8135540")|| true) && (Configuration.FINDBYNAMES.equals(sqlId)? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 289 33 26 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 289 33 26 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 110 8135540"); {
			String[] fe = field.split(",");
			String param = "";
			for (String string : /* TRUE */fe){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 111 8135540");ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 112 8135540"); {
				if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 113 8135540")|| true) && (formMap.containsKey(string)? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 289 34 27 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 289 34 27 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 114 8135540"); {
					Object v = formMap.get(string);
					if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 115 8135540")|| true) && (v.toString().indexOf("%") > -1? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 289 35 28 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 289 35 28 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 116 8135540");// 处理模糊查询
					{
						param += " and " + string + " like '" + v + "'";
					} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 117 8135540");  {
						param += " and " + string + " = '" + v + "'";
					} }
				} }
			}}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 120 8135540");
			if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 121 8135540")|| true) && (StringUtils.isNotBlank(param)? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 289 36 29 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 289 36 29 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 122 8135540"); {
				param = param.substring(param.indexOf("and") + 4);
				sql += " where " + param;

			} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 123 8135540");
			Object by = formMap.get("orderby");
			if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 124 8135540")|| true) && (null != by? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 289 37 30 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 289 37 30 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 125 8135540"); {
				sql += " " + by;
			} }
		} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 127 8135540");  if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 128 8135540")|| true) && (Configuration.FINDBYATTRIBUTE.equals(sqlId)? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 289 38 31 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 289 38 31 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 129 8135540"); {
			sql = "select * from " + table.toString() + " where " + formMap.get("key");
			int zoa_cond_n130_0 = 2;
int zoa_cond_n130_1 = 2;
//zoa_cond_n130_0#null != formMap.get("value")$zoa_cond_n130_1#formMap.get("value").toString().indexOf("%") > -1
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 130 8135540")|| true) && ((null != formMap.get("value")?(zoa_cond_n130_0 != (zoa_cond_n130_0 = 1)):(zoa_cond_n130_0 == (zoa_cond_n130_0 = 0))) && (formMap.get("value").toString().indexOf("%") > -1?(zoa_cond_n130_1 != (zoa_cond_n130_1 = 1)):(zoa_cond_n130_1 == (zoa_cond_n130_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 289 41 32 1 2 ","8135540",true,zoa_cond_n130_0,zoa_cond_n130_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 289 41 32 0 2 ","8135540",false,zoa_cond_n130_0,zoa_cond_n130_1) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 131 8135540");// 处理模糊查询
			{
				sql += " LIKE '" + formMap.get("value") + "'";
			} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 132 8135540");  {
				Object v = formMap.get("value");
				sql += " in ('" + v + "')";

			} }
		} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 134 8135540");  if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 135 8135540")|| true) && (Configuration.ADDENTITY.equals(sqlId)? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 289 42 33 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 289 42 33 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 136 8135540"); {
			String[] fe = field.split(",");
			String fieldString = "";
			String fieldValues = "";
			for (String string : /* TRUE */fe){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 137 8135540");ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 138 8135540"); {
				Object v = formMap.get(string);
				int zoa_cond_n139_0 = 2;
int zoa_cond_n139_1 = 2;
//zoa_cond_n139_0#null != v$zoa_cond_n139_1#StringUtils.isBlank(v.toString())
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 139 8135540")|| true) && ((null != v?(zoa_cond_n139_0 != (zoa_cond_n139_0 = 1)):(zoa_cond_n139_0 == (zoa_cond_n139_0 = 0))) && !(StringUtils.isBlank(v.toString())?(zoa_cond_n139_1 != (zoa_cond_n139_1 = 1)):(zoa_cond_n139_1 == (zoa_cond_n139_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 289 45 34 1 2 ","8135540",true,zoa_cond_n139_0,zoa_cond_n139_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 289 45 34 0 2 ","8135540",false,zoa_cond_n139_0,zoa_cond_n139_1) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 140 8135540"); {
					fieldString += string + ",";
					fieldValues += "'" + v + "',";
				} }
			}}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 142 8135540");
			sql = "insert into " + table.toString() + " (" + ResolverUtil.trimComma(fieldString) + ")  values ("
					+ ResolverUtil.trimComma(fieldValues) + ")";
		} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 143 8135540");  if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 144 8135540")|| true) && (Configuration.EDITENTITY.equals(sqlId)? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 289 46 35 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 289 46 35 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 145 8135540"); {
			String[] fe = field.split(",");
			String fieldString = "";
			String where = "";
			for (String string : /* TRUE */fe){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 146 8135540");ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 147 8135540"); {
				Object v = formMap.get(string);
				int zoa_cond_n148_0 = 2;
int zoa_cond_n148_1 = 2;
//zoa_cond_n148_0#null != v$zoa_cond_n148_1#StringUtils.isBlank(v.toString())
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 148 8135540")|| true) && ((null != v?(zoa_cond_n148_0 != (zoa_cond_n148_0 = 1)):(zoa_cond_n148_0 == (zoa_cond_n148_0 = 0))) && !(StringUtils.isBlank(v.toString())?(zoa_cond_n148_1 != (zoa_cond_n148_1 = 1)):(zoa_cond_n148_1 == (zoa_cond_n148_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 289 49 36 1 2 ","8135540",true,zoa_cond_n148_0,zoa_cond_n148_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 289 49 36 0 2 ","8135540",false,zoa_cond_n148_0,zoa_cond_n148_1) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 149 8135540"); {
					String key = mapfield.get(Configuration.COLUMN_KEY).toString();
					if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 150 8135540")|| true) && (!StringUtils.isBlank(key)? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 289 50 37 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 289 50 37 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 151 8135540"); {
						if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 152 8135540")|| true) && (key.equals(string)? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 289 51 38 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 289 51 38 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 153 8135540"); {
							where = "WHERE " + key + " = '" + v + "'";
						} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 154 8135540");  {
							fieldString += string + "='" + v + "',";
						} }
					} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 156 8135540");  {
						throw new NullPointerException("update操作没有找到主键!");
					} }

				} }
			}}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 159 8135540");

			sql = "update " + table.toString() + " set " + ResolverUtil.trimComma(fieldString) + " " + where;
		} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 160 8135540");  if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 161 8135540")|| true) && (Configuration.FINDBYFRIST.equals(sqlId)? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 289 52 39 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 289 52 39 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 162 8135540"); {
			sql = "select * from " + table.toString() + " where " + formMap.get("key");
			int zoa_cond_n163_0 = 2;
int zoa_cond_n163_1 = 2;
//zoa_cond_n163_0#null != formMap.get("value")$zoa_cond_n163_1#"".equals(formMap.get("value").toString())
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 163 8135540")|| true) && ((null != formMap.get("value")?(zoa_cond_n163_0 != (zoa_cond_n163_0 = 1)):(zoa_cond_n163_0 == (zoa_cond_n163_0 = 0))) && !("".equals(formMap.get("value").toString())?(zoa_cond_n163_1 != (zoa_cond_n163_1 = 1)):(zoa_cond_n163_1 == (zoa_cond_n163_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 289 55 40 1 2 ","8135540",true,zoa_cond_n163_0,zoa_cond_n163_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 289 55 40 0 2 ","8135540",false,zoa_cond_n163_0,zoa_cond_n163_1) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 164 8135540"); {
				sql += " = '" + formMap.get("value") + "'";
			} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 165 8135540");  {
				throw new Exception(sqlId + " 调用公共方法异常!,传入参数错误！");
			} }

		} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 167 8135540");  if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 168 8135540")|| true) && (Configuration.BATCHSAVE.equals(sqlId)? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 289 56 41 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 289 56 41 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 169 8135540"); {
			int zoa_cond_n170_0 = 2;
int zoa_cond_n170_1 = 2;
//zoa_cond_n170_0#null != formMaps$zoa_cond_n170_1#formMaps.size() > 0
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 170 8135540")|| true) && ((null != formMaps?(zoa_cond_n170_0 != (zoa_cond_n170_0 = 1)):(zoa_cond_n170_0 == (zoa_cond_n170_0 = 0))) && (formMaps.size() > 0?(zoa_cond_n170_1 != (zoa_cond_n170_1 = 1)):(zoa_cond_n170_1 == (zoa_cond_n170_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 289 59 42 1 2 ","8135540",true,zoa_cond_n170_0,zoa_cond_n170_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 289 59 42 0 2 ","8135540",false,zoa_cond_n170_0,zoa_cond_n170_1) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 171 8135540"); {
				table = Common.toHashMap(formMaps.get(0)).get(Configuration.LY_TABLE);
				mapfield = (Map<String, Object>) EhcacheUtils.get(table);
				field = mapfield.get(Configuration.FIELD).toString();
			} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 172 8135540");
			sql = "insert into " + table.toString();
			String fieldString = "";
			String fs = "";
			String fd = "";
			String fieldValues = "";
			String fvs = "";
			for (int i = 0; (ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 173 8135540")|| true) && (i < formMaps.size()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 289 60 43 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 289 60 43 0 0 ","8135540",false,0) && false)); i++){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 174 8135540"); {
				Object object = formMaps.get(i);
				@SuppressWarnings("unchecked")
				Map<String, Object> froMmap = (Map<String, Object>) object;
				String[] fe = field.split(",");
				for (String string : /* TRUE */fe){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 175 8135540");ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 176 8135540"); {
					Object v = froMmap.get(string);
					int zoa_cond_n177_0 = 2;
int zoa_cond_n177_1 = 2;
//zoa_cond_n177_0#null != v$zoa_cond_n177_1#StringUtils.isBlank(v.toString())
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 177 8135540")|| true) && ((null != v?(zoa_cond_n177_0 != (zoa_cond_n177_0 = 1)):(zoa_cond_n177_0 == (zoa_cond_n177_0 = 0))) && !(StringUtils.isBlank(v.toString())?(zoa_cond_n177_1 != (zoa_cond_n177_1 = 1)):(zoa_cond_n177_1 == (zoa_cond_n177_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 289 63 44 1 2 ","8135540",true,zoa_cond_n177_0,zoa_cond_n177_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 289 63 44 0 2 ","8135540",false,zoa_cond_n177_0,zoa_cond_n177_1) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 178 8135540"); {
						fieldString += string + ",";
						fieldValues += "'" + v + "',";
					} }
				}}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 180 8135540");
				if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 181 8135540")|| true) && (i == 0? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 289 64 45 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 289 64 45 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 182 8135540"); {
					fd = fieldString;
				} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 183 8135540");
				fvs += "(" + ResolverUtil.trimComma(fieldValues) + "),";
				fs += " insert into " + table.toString() + " (" + ResolverUtil.trimComma(fieldString) + ")  values ("
						+ ResolverUtil.trimComma(fieldValues) + ");";
				fieldValues = "";
				fieldString = "";
			}}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 184 8135540");
			String v = ResolverUtil.trimComma(fvs);
			sql = "insert into " + table.toString() + " (" + ResolverUtil.trimComma(fd) + ")  values "
					+ ResolverUtil.trimComma(fvs) + "";
			String[] vs = v.split("\\),");
			boolean b = false;
			for (String string : /* TRUE */vs){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 185 8135540");ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 186 8135540"); {
				if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 187 8135540")|| true) && (string.split(",").length != fd.split(",").length? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 289 65 46 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 289 65 46 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 188 8135540"); {
					b = true;
				} }
			}}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 190 8135540");
			if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 191 8135540")|| true) && (b? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 289 66 47 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 289 66 47 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 192 8135540"); {
				sql = fs.substring(0, fs.length() - 1);
			} }

		} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 194 8135540");  {
			throw new Exception("调用公共方法异常!");
		} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 195 8135540"); }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 196 8135540"); }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 197 8135540"); }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 198 8135540"); }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 199 8135540"); }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 200 8135540"); }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 201 8135540"); }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 202 8135540"); }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 203 8135540"); }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 204 8135540");
		return sql;
	}

	public static void setCount(String sql, Connection connection, BoundSql boundSql, PageView pageView)
			throws SQLException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 289 205 8135540"); 
		PreparedStatement countStmt = null;
		ResultSet rs = null;
		try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 206 8135540"); 
			String countSql = "";
			try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 207 8135540"); 
				countSql = "select count(1) from " + suffixStr(removeOrderBys(sql));
				countStmt = connection.prepareStatement(countSql);
				rs = countStmt.executeQuery();
			} catch (Exception e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 208 8135540"); 
				PagePlugin.logger.error(countSql + " 统计Sql出错,自动转换为普通统计Sql语句!");
				countSql = "select count(1) from (" + sql + ") tmp_count";
				countStmt = connection.prepareStatement(countSql);
				rs = countStmt.executeQuery();
			}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 209 8135540");
			int count = 0;
			if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 210 8135540")|| true) && (rs.next()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 289 67 48 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 289 67 48 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 211 8135540"); {
				count = ((Number) rs.getObject(1)).intValue();
			} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 212 8135540");
			pageView.setRowCount(count);
		} finally {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 213 8135540"); 
			try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 214 8135540"); 
				rs.close();
			} catch (Exception e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 215 8135540"); 
			}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 216 8135540");
			try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 217 8135540"); 
				countStmt.close();
			} catch (Exception e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 218 8135540"); 
			}
		}

	}

	public static String suffixStr(String toSql) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 289 221 8135540"); 
		int sun = toSql.indexOf("from");
		String f1 = toSql.substring(sun - 1, sun);
		String f2 = toSql.substring(sun + 4, sun + 5);
		int zoa_cond_n222_0 = 2;
int zoa_cond_n222_1 = 2;
//zoa_cond_n222_0#f1.trim().isEmpty()$zoa_cond_n222_1#f2.trim().isEmpty()
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 222 8135540")|| true) && ((f1.trim().isEmpty()?(zoa_cond_n222_0 != (zoa_cond_n222_0 = 1)):(zoa_cond_n222_0 == (zoa_cond_n222_0 = 0))) && (f2.trim().isEmpty()?(zoa_cond_n222_1 != (zoa_cond_n222_1 = 1)):(zoa_cond_n222_1 == (zoa_cond_n222_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 289 70 49 1 2 ","8135540",true,zoa_cond_n222_0,zoa_cond_n222_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 289 70 49 0 2 ","8135540",false,zoa_cond_n222_0,zoa_cond_n222_1) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 223 8135540"); {
			String s1 = toSql.substring(0, sun);
			int s0 = s1.indexOf("(");
			if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 224 8135540")|| true) && (s0 > -1? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 289 71 50 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 289 71 50 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 225 8135540"); {
				int se1 = s1.indexOf("select");
				if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 226 8135540")|| true) && (s0 < se1? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 289 72 51 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 289 72 51 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 227 8135540"); {
					if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 228 8135540")|| true) && (se1 > -1? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 289 73 52 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 289 73 52 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 229 8135540"); {
						String ss1 = s1.substring(se1 - 1, se1);
						String ss2 = s1.substring(se1 + 6, se1 + 7);
						int zoa_cond_n230_0 = 2;
int zoa_cond_n230_1 = 2;
//zoa_cond_n230_0#ss1.trim().isEmpty()$zoa_cond_n230_1#ss2.trim().isEmpty()
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 230 8135540")|| true) && ((ss1.trim().isEmpty()?(zoa_cond_n230_0 != (zoa_cond_n230_0 = 1)):(zoa_cond_n230_0 == (zoa_cond_n230_0 = 0))) && (ss2.trim().isEmpty()?(zoa_cond_n230_1 != (zoa_cond_n230_1 = 1)):(zoa_cond_n230_1 == (zoa_cond_n230_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 289 76 53 1 2 ","8135540",true,zoa_cond_n230_0,zoa_cond_n230_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 289 76 53 0 2 ","8135540",false,zoa_cond_n230_0,zoa_cond_n230_1) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 231 8135540"); {
							return suffixStr(toSql.substring(sun + 5));
						} }
					} }
				} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 234 8135540");
				int se2 = s1.indexOf("(select");
				if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 235 8135540")|| true) && (se2 > -1? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 289 77 54 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 289 77 54 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 236 8135540"); {
					String ss2 = s1.substring(se2 + 7, se2 + 8);
					if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 237 8135540")|| true) && (ss2.trim().isEmpty()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 289 78 55 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 289 78 55 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 238 8135540"); {
						return suffixStr(toSql.substring(sun + 5));
					} }
				} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 240 8135540");
				int zoa_cond_n241_0 = 2;
int zoa_cond_n241_1 = 2;
//zoa_cond_n241_0#se1 == -1$zoa_cond_n241_1#se2 == -1
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 241 8135540")|| true) && ((se1 == -1?(zoa_cond_n241_0 != (zoa_cond_n241_0 = 1)):(zoa_cond_n241_0 == (zoa_cond_n241_0 = 0))) && (se2 == -1?(zoa_cond_n241_1 != (zoa_cond_n241_1 = 1)):(zoa_cond_n241_1 == (zoa_cond_n241_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 289 81 56 1 2 ","8135540",true,zoa_cond_n241_0,zoa_cond_n241_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 289 81 56 0 2 ","8135540",false,zoa_cond_n241_0,zoa_cond_n241_1) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 242 8135540"); {
					return toSql.substring(sun + 5);
				} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 243 8135540");  {
					toSql = toSql.substring(sun + 5);
				} }
			} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 245 8135540");  {
				toSql = toSql.substring(sun + 5);
			} }
		} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 247 8135540");
		return toSql;
	}

	private static String removeOrderBys(String toSql) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 289 248 8135540"); 
		int sun = toSql.indexOf("order");
		if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 249 8135540")|| true) && (sun > -1? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 289 82 57 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 289 82 57 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 250 8135540"); {
			String f1 = toSql.substring(sun - 1, sun);
			String f2 = toSql.substring(sun + 5, sun + 5);
			int zoa_cond_n251_0 = 2;
int zoa_cond_n251_1 = 2;
//zoa_cond_n251_0#f1.trim().isEmpty()$zoa_cond_n251_1#f2.trim().isEmpty()
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 251 8135540")|| true) && ((f1.trim().isEmpty()?(zoa_cond_n251_0 != (zoa_cond_n251_0 = 1)):(zoa_cond_n251_0 == (zoa_cond_n251_0 = 0))) && (f2.trim().isEmpty()?(zoa_cond_n251_1 != (zoa_cond_n251_1 = 1)):(zoa_cond_n251_1 == (zoa_cond_n251_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 289 85 58 1 2 ","8135540",true,zoa_cond_n251_0,zoa_cond_n251_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 289 85 58 0 2 ","8135540",false,zoa_cond_n251_0,zoa_cond_n251_1) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 252 8135540"); {
				String zb = toSql.substring(sun);
				int s0 = zb.indexOf(")");
				if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 253 8135540")|| true) && (s0 > -1? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 289 86 59 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 289 86 59 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 254 8135540"); {
					String s1 = toSql.substring(0, sun);
					String s2 = zb.substring(s0);
					return removeOrderBys(s1 + s2);
				} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 255 8135540");  {
					toSql = toSql.substring(0, sun);
				} }
			} }
		} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 289 258 8135540");
		return toSql;
	}
}

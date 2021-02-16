// ZOA_CREATED! DO NOT EDIT IT! -- 
/*
 *    Copyright 2009-2013 the original author or authors.
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
package org.apache.ibatis.binding;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.*;

/**
 * @author Clinton Begin
 * @author Eduardo Macarron
 * @author Lasse Voss
 */
import com.process.ZoaExp;
import com.process.ZoaThreadLocal;
public class MapperMethod {

	private final SqlCommand command;
	private final MethodSignature method;

	public MapperMethod(
			Class<?> mapperInterface,
			Method method,
			Configuration config) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 300 0 8135540"); 
		this.command = new SqlCommand(
				config,
				mapperInterface, method);
		this.method = new MethodSignature(
				config, method);
	}

	public Object execute(
			SqlSession sqlSession,
			Object[] args) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 300 1 8135540"); 
		Object result;
		if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 300 2 8135540")|| true) && (SqlCommandType.INSERT == command
				.getType()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 300 0 0 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 300 0 0 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 300 3 8135540"); {
			Object param = method
					.convertArgsToSqlCommandParam(args);
			result = rowCountResult(sqlSession
					.insert(command
							.getName(),
							param));
		} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 300 4 8135540");  if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 300 5 8135540")|| true) && (SqlCommandType.UPDATE == command
				.getType()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 300 1 1 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 300 1 1 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 300 6 8135540"); {
			Object param = method
					.convertArgsToSqlCommandParam(args);
			result = rowCountResult(sqlSession
					.update(command
							.getName(),
							param));
		} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 300 7 8135540");  if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 300 8 8135540")|| true) && (SqlCommandType.DELETE == command
				.getType()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 300 2 2 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 300 2 2 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 300 9 8135540"); {
			Object param = method
					.convertArgsToSqlCommandParam(args);
			result = rowCountResult(sqlSession
					.delete(command
							.getName(),
							param));
		} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 300 10 8135540");  if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 300 11 8135540")|| true) && (SqlCommandType.SELECT == command
				.getType()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 300 3 3 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 300 3 3 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 300 12 8135540"); {
			int zoa_cond_n13_0 = 2;
int zoa_cond_n13_1 = 2;
//zoa_cond_n13_0#method.returnsVoid()$zoa_cond_n13_1#method.hasResultHandler()
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 300 13 8135540")|| true) && ((method.returnsVoid()?(zoa_cond_n13_0 != (zoa_cond_n13_0 = 1)):(zoa_cond_n13_0 == (zoa_cond_n13_0 = 0)))
					&& (method
							.hasResultHandler()?(zoa_cond_n13_1 != (zoa_cond_n13_1 = 1)):(zoa_cond_n13_1 == (zoa_cond_n13_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 300 6 4 1 2 ","8135540",true,zoa_cond_n13_0,zoa_cond_n13_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 300 6 4 0 2 ","8135540",false,zoa_cond_n13_0,zoa_cond_n13_1) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 300 14 8135540"); {
				executeWithResultHandler(
						sqlSession,
						args);
				result = null;
			} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 300 15 8135540");  if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 300 16 8135540")|| true) && (method
					.returnsMany()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 300 7 5 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 300 7 5 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 300 17 8135540"); {
				result = executeForMany(
						sqlSession,
						args);
			} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 300 18 8135540");  if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 300 19 8135540")|| true) && (method
					.returnsMap()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 300 8 6 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 300 8 6 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 300 20 8135540"); {
				result = executeForMap(
						sqlSession,
						args);
			} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 300 21 8135540");  {
				Object param = method
						.convertArgsToSqlCommandParam(args);
				result = sqlSession
						.selectOne(
								command.getName(),
								param);
			} } } }
		} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 300 25 8135540");  {
			throw new BindingException(
					"Unknown execution method for: "
							+ command
									.getName());
		} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 300 26 8135540"); }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 300 27 8135540"); }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 300 28 8135540"); }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 300 29 8135540");
		int zoa_cond_n30_0 = 2;
int zoa_cond_n30_1 = 2;
int zoa_cond_n30_2 = 2;
//zoa_cond_n30_0#result == null$zoa_cond_n30_1#method.getReturnType().isPrimitive()$zoa_cond_n30_2#method.returnsVoid()
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 300 30 8135540")|| true) && ((result == null?(zoa_cond_n30_0 != (zoa_cond_n30_0 = 1)):(zoa_cond_n30_0 == (zoa_cond_n30_0 = 0)))
				&& (method
						.getReturnType()
						.isPrimitive()?(zoa_cond_n30_1 != (zoa_cond_n30_1 = 1)):(zoa_cond_n30_1 == (zoa_cond_n30_1 = 0)))
				&& !(method
						.returnsVoid()?(zoa_cond_n30_2 != (zoa_cond_n30_2 = 1)):(zoa_cond_n30_2 == (zoa_cond_n30_2 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 300 12 7 1 3 ","8135540",true,zoa_cond_n30_0,zoa_cond_n30_1,zoa_cond_n30_2) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 300 12 7 0 3 ","8135540",false,zoa_cond_n30_0,zoa_cond_n30_1,zoa_cond_n30_2) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 300 31 8135540"); {
			throw new BindingException(
					"Mapper method '"
							+ command
									.getName()
							+ " attempted to return null from a method with a primitive return type ("
							+ method.getReturnType()
							+ ").");
		} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 300 32 8135540");
		return result;
	}

	private Object rowCountResult(
			int rowCount) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 300 33 8135540"); 
		final Object result;
		if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 300 34 8135540")|| true) && (method.returnsVoid()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 300 13 8 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 300 13 8 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 300 35 8135540"); {
			result = null;
		} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 300 36 8135540");  int zoa_cond_n37_0 = 2;
int zoa_cond_n37_1 = 2;
//zoa_cond_n37_0#Integer.class.equals(method.getReturnType())$zoa_cond_n37_1#Integer.TYPE.equals(method.getReturnType())
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 300 37 8135540")|| true) && ((Integer.class
				.equals(method
						.getReturnType())?(zoa_cond_n37_0 != (zoa_cond_n37_0 = 1)):(zoa_cond_n37_0 == (zoa_cond_n37_0 = 0)))
				|| (Integer.TYPE
						.equals(method
								.getReturnType())?(zoa_cond_n37_1 != (zoa_cond_n37_1 = 1)):(zoa_cond_n37_1 == (zoa_cond_n37_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 300 16 9 1 2 ","8135540",true,zoa_cond_n37_0,zoa_cond_n37_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 300 16 9 0 2 ","8135540",false,zoa_cond_n37_0,zoa_cond_n37_1) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 300 38 8135540"); {
			result = rowCount;
		} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 300 39 8135540");  int zoa_cond_n40_0 = 2;
int zoa_cond_n40_1 = 2;
//zoa_cond_n40_0#Long.class.equals(method.getReturnType())$zoa_cond_n40_1#Long.TYPE.equals(method.getReturnType())
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 300 40 8135540")|| true) && ((Long.class
				.equals(method
						.getReturnType())?(zoa_cond_n40_0 != (zoa_cond_n40_0 = 1)):(zoa_cond_n40_0 == (zoa_cond_n40_0 = 0)))
				|| (Long.TYPE
						.equals(method
								.getReturnType())?(zoa_cond_n40_1 != (zoa_cond_n40_1 = 1)):(zoa_cond_n40_1 == (zoa_cond_n40_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 300 19 10 1 2 ","8135540",true,zoa_cond_n40_0,zoa_cond_n40_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 300 19 10 0 2 ","8135540",false,zoa_cond_n40_0,zoa_cond_n40_1) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 300 41 8135540"); {
			result = (long) rowCount;
		} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 300 42 8135540");  int zoa_cond_n43_0 = 2;
int zoa_cond_n43_1 = 2;
//zoa_cond_n43_0#Boolean.class.equals(method.getReturnType())$zoa_cond_n43_1#Boolean.TYPE.equals(method.getReturnType())
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 300 43 8135540")|| true) && ((Boolean.class
				.equals(method
						.getReturnType())?(zoa_cond_n43_0 != (zoa_cond_n43_0 = 1)):(zoa_cond_n43_0 == (zoa_cond_n43_0 = 0)))
				|| (Boolean.TYPE
						.equals(method
								.getReturnType())?(zoa_cond_n43_1 != (zoa_cond_n43_1 = 1)):(zoa_cond_n43_1 == (zoa_cond_n43_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 300 22 11 1 2 ","8135540",true,zoa_cond_n43_0,zoa_cond_n43_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 300 22 11 0 2 ","8135540",false,zoa_cond_n43_0,zoa_cond_n43_1) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 300 44 8135540"); {
			result = (rowCount > 0);
		} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 300 45 8135540");  {
			throw new BindingException(
					"Mapper method '"
							+ command
									.getName()
							+ "' has an unsupported return type: "
							+ method.getReturnType());
		} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 300 46 8135540"); }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 300 47 8135540"); }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 300 48 8135540"); }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 300 49 8135540");
		return result;
	}

	private void executeWithResultHandler(
			SqlSession sqlSession,
			Object[] args) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 300 50 8135540"); 
		MappedStatement ms = sqlSession
				.getConfiguration()
				.getMappedStatement(
						command.getName());
		if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 300 51 8135540")|| true) && (void.class.equals(ms
				.getResultMaps().get(0)
				.getType())? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 300 23 12 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 300 23 12 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 300 52 8135540"); {
			throw new BindingException(
					"method "
							+ command
									.getName()
							+ " needs either a @ResultMap annotation, a @ResultType annotation,"
							+ " or a resultType attribute in XML so a ResultHandler can be used as a parameter.");
		} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 300 53 8135540");
		Object param = method
				.convertArgsToSqlCommandParam(args);
		if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 300 54 8135540")|| true) && (method.hasRowBounds()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 300 24 13 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 300 24 13 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 300 55 8135540"); {
			RowBounds rowBounds = method
					.extractRowBounds(args);
			sqlSession
					.select(command
							.getName(),
							param,
							rowBounds,
							method.extractResultHandler(args));
		} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 300 56 8135540");  {
			sqlSession
					.select(command
							.getName(),
							param,
							method.extractResultHandler(args));
		} }
	}

	private <E> Object executeForMany(
			SqlSession sqlSession,
			Object[] args) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 300 58 8135540"); 
		List<E> result;
		Object param = method
				.convertArgsToSqlCommandParam(args);
		if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 300 59 8135540")|| true) && (method.hasRowBounds()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 300 25 14 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 300 25 14 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 300 60 8135540"); {
			RowBounds rowBounds = method
					.extractRowBounds(args);
			result = sqlSession
					.<E> selectList(
							command.getName(),
							param,
							rowBounds);
		} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 300 61 8135540");  {
			result = sqlSession
					.<E> selectList(
							command.getName(),
							param);
		} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 300 62 8135540");
		// issue #510 Collections & arrays support
		if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 300 63 8135540")|| true) && (!method
				.getReturnType()
				.isAssignableFrom(
						result.getClass())? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 300 26 15 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 300 26 15 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 300 64 8135540"); {
			if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 300 65 8135540")|| true) && (method.getReturnType()
					.isArray()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 300 27 16 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 300 27 16 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 300 66 8135540"); {
				return convertToArray(result);
			} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 300 67 8135540");  {
				return convertToDeclaredCollection(
						sqlSession
								.getConfiguration(),
						result);
			} }
		} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 300 69 8135540");
		return result;
	}

	private <E> Object convertToDeclaredCollection(
			Configuration config,
			List<E> list) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 300 70 8135540"); 
		Object collection = config
				.getObjectFactory()
				.create(method
						.getReturnType());
		MetaObject metaObject = config
				.newMetaObject(collection);
		metaObject.addAll(list);
		return collection;
	}

	@SuppressWarnings("unchecked")
	private <E> E[] convertToArray(
			List<E> list) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 300 71 8135540"); 
		E[] array = (E[]) Array
				.newInstance(
						method.getReturnType()
								.getComponentType(),
						list.size());
		array = list.toArray(array);
		return array;
	}

	private <K, V> Map<K, V> executeForMap(
			SqlSession sqlSession,
			Object[] args) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 300 72 8135540"); 
		Map<K, V> result;
		Object param = method
				.convertArgsToSqlCommandParam(args);
		if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 300 73 8135540")|| true) && (method.hasRowBounds()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 300 28 17 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 300 28 17 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 300 74 8135540"); {
			RowBounds rowBounds = method
					.extractRowBounds(args);
			result = sqlSession
					.<K, V> selectMap(
							command.getName(),
							param,
							method.getMapKey(),
							rowBounds);
		} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 300 75 8135540");  {
			result = sqlSession
					.<K, V> selectMap(
							command.getName(),
							param,
							method.getMapKey());
		} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 300 76 8135540");
		return result;
	}

	public static class ParamMap<V>
			extends HashMap<String, V> {

		private static final long serialVersionUID = -2212268410512043556L;

		@Override
		public V get(Object key) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 300 77 8135540"); 
			if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 300 78 8135540")|| true) && (!super.containsKey(key)? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 300 29 18 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 300 29 18 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 300 79 8135540"); {
				throw new BindingException(
						"Parameter '"
								+ key
								+ "' not found. Available parameters are "
								+ keySet());
			} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 300 80 8135540");
			return super.get(key);
		}

	}

	public static class SqlCommand {

		private final String name;
		private final SqlCommandType type;

		public SqlCommand(
				Configuration configuration,
				Class<?> mapperInterface,
				Method method)
				throws BindingException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 300 81 8135540"); 
			String statementName = mapperInterface
					.getName()
					+ "."
					+ method.getName();
			MappedStatement ms = null;
			if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 300 82 8135540")|| true) && (configuration
					.hasStatement(statementName)? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 300 30 19 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 300 30 19 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 300 83 8135540"); {
				ms = configuration
						.getMappedStatement(statementName);
			} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 300 84 8135540");  if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 300 85 8135540")|| true) && (!mapperInterface
					.equals(method
							.getDeclaringClass()
							.getName())? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 300 31 20 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 300 31 20 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 300 86 8135540"); { // issue #35
				String parentStatementName = method
						.getDeclaringClass()
						.getName()
						+ "."
						+ method.getName();
				if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 300 87 8135540")|| true) && (configuration
						.hasStatement(parentStatementName)? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 300 32 21 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 300 32 21 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 300 88 8135540"); {
					ms = configuration
							.getMappedStatement(parentStatementName);
				} }
			} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 300 90 8135540"); }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 300 91 8135540");
			if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 300 92 8135540")|| true) && (ms == null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 300 33 22 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 300 33 22 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 300 93 8135540"); {
				throw new BindingException(
						"Invalid bound statement (not found): "
								+ statementName);
			} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 300 94 8135540");
			name = ms.getId();
			type = ms
					.getSqlCommandType();
			if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 300 95 8135540")|| true) && (type == SqlCommandType.UNKNOWN? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 300 34 23 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 300 34 23 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 300 96 8135540"); {
				throw new BindingException(
						"Unknown execution method for: "
								+ name);
			} }
		}

		public String getName() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 300 98 8135540"); 
			return name;
		}

		public SqlCommandType getType() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 300 99 8135540"); 
			return type;
		}
	}

	public static class MethodSignature {

		private final boolean returnsMany;
		private final boolean returnsMap;
		private final boolean returnsVoid;
		private final Class<?> returnType;
		private final String mapKey;
		private final Integer resultHandlerIndex;
		private final Integer rowBoundsIndex;
		private final SortedMap<Integer, String> params;
		private final boolean hasNamedParameters;

		public MethodSignature(
				Configuration configuration,
				Method method)
				throws BindingException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 300 100 8135540"); 
			this.returnType = method
					.getReturnType();
			this.returnsVoid = void.class
					.equals(this.returnType);
			this.returnsMany = (configuration
					.getObjectFactory()
					.isCollection(
							this.returnType) || this.returnType
					.isArray());
			this.mapKey = getMapKey(method);
			this.returnsMap = (this.mapKey != null);
			this.hasNamedParameters = hasNamedParams(method);
			this.rowBoundsIndex = getUniqueParamIndex(
					method,
					RowBounds.class);
			this.resultHandlerIndex = getUniqueParamIndex(
					method,
					ResultHandler.class);
			this.params = Collections
					.unmodifiableSortedMap(getParams(
							method,
							this.hasNamedParameters));
		}

		public Object convertArgsToSqlCommandParam(
				Object[] args) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 300 101 8135540"); 
			final int paramCount = params
					.size();
			int zoa_cond_n102_0 = 2;
int zoa_cond_n102_1 = 2;
//zoa_cond_n102_0#args == null$zoa_cond_n102_1#paramCount == 0
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 300 102 8135540")|| true) && ((args == null?(zoa_cond_n102_0 != (zoa_cond_n102_0 = 1)):(zoa_cond_n102_0 == (zoa_cond_n102_0 = 0)))
					|| (paramCount == 0?(zoa_cond_n102_1 != (zoa_cond_n102_1 = 1)):(zoa_cond_n102_1 == (zoa_cond_n102_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 300 37 24 1 2 ","8135540",true,zoa_cond_n102_0,zoa_cond_n102_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 300 37 24 0 2 ","8135540",false,zoa_cond_n102_0,zoa_cond_n102_1) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 300 103 8135540"); {
				return null;
			} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 300 104 8135540");  int zoa_cond_n105_0 = 2;
int zoa_cond_n105_1 = 2;
//zoa_cond_n105_0#hasNamedParameters$zoa_cond_n105_1#paramCount == 1
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 300 105 8135540")|| true) && (!(hasNamedParameters?(zoa_cond_n105_0 != (zoa_cond_n105_0 = 1)):(zoa_cond_n105_0 == (zoa_cond_n105_0 = 0)))
					&& (paramCount == 1?(zoa_cond_n105_1 != (zoa_cond_n105_1 = 1)):(zoa_cond_n105_1 == (zoa_cond_n105_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 300 40 25 1 2 ","8135540",true,zoa_cond_n105_0,zoa_cond_n105_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 300 40 25 0 2 ","8135540",false,zoa_cond_n105_0,zoa_cond_n105_1) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 300 106 8135540"); {
				return args[params
						.keySet()
						.iterator()
						.next()];
			} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 300 107 8135540");  {
				final Map<String, Object> param = new ParamMap<Object>();
				int i = 0;
				for (Map.Entry<Integer, String> entry : /* TRUE */params
						.entrySet()){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 300 108 8135540");ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 300 109 8135540"); {
					param.put(
							entry.getValue(),
							args[entry
									.getKey()]);
					// issue #71, add param names as param1, param2...but ensure
					// backward compatibility
					final String genericParamName = "param"
							+ String.valueOf(i + 1);
					if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 300 110 8135540")|| true) && (!param
							.containsKey(genericParamName)? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 300 41 26 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 300 41 26 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 300 111 8135540"); {
						param.put(
								genericParamName,
								args[entry
										.getKey()]);
					} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 300 112 8135540");
					i++;
				}}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 300 113 8135540");
				return param;
			} } }
		}

		public boolean hasRowBounds() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 300 116 8135540"); 
			return (rowBoundsIndex != null);
		}

		public RowBounds extractRowBounds(
				Object[] args) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 300 117 8135540"); 
			return (hasRowBounds() ? (RowBounds) args[rowBoundsIndex]
					: null);
		}

		public boolean hasResultHandler() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 300 118 8135540"); 
			return (resultHandlerIndex != null);
		}

		public ResultHandler extractResultHandler(
				Object[] args) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 300 119 8135540"); 
			return (hasResultHandler() ? (ResultHandler) args[resultHandlerIndex]
					: null);
		}

		public String getMapKey() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 300 120 8135540"); 
			return mapKey;
		}

		public Class<?> getReturnType() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 300 121 8135540"); 
			return returnType;
		}

		public boolean returnsMany() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 300 122 8135540"); 
			return returnsMany;
		}

		public boolean returnsMap() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 300 123 8135540"); 
			return returnsMap;
		}

		public boolean returnsVoid() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 300 124 8135540"); 
			return returnsVoid;
		}

		private Integer getUniqueParamIndex(
				Method method,
				Class<?> paramType) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 300 125 8135540"); 
			Integer index = null;
			final Class<?>[] argTypes = method
					.getParameterTypes();
			for (int i = 0; (ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 300 126 8135540")|| true) && (i < argTypes.length? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 300 42 27 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 300 42 27 0 0 ","8135540",false,0) && false)); i++){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 300 127 8135540"); {
				if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 300 128 8135540")|| true) && (paramType
						.isAssignableFrom(argTypes[i])? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 300 43 28 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 300 43 28 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 300 129 8135540"); {
					if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 300 130 8135540")|| true) && (index == null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 300 44 29 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 300 44 29 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 300 131 8135540"); {
						index = i;
					} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 300 132 8135540");  {
						throw new BindingException(
								method.getName()
										+ " cannot have multiple "
										+ paramType
												.getSimpleName()
										+ " parameters");
					} }
				} }
			}}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 300 135 8135540");
			return index;
		}

		private String getMapKey(
				Method method) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 300 136 8135540"); 
			String mapKey = null;
			if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 300 137 8135540")|| true) && (Map.class
					.isAssignableFrom(method
							.getReturnType())? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 300 45 30 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 300 45 30 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 300 138 8135540"); {
				final MapKey mapKeyAnnotation = method
						.getAnnotation(MapKey.class);
				if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 300 139 8135540")|| true) && (mapKeyAnnotation != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 300 46 31 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 300 46 31 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 300 140 8135540"); {
					mapKey = mapKeyAnnotation
							.value();
				} }
			} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 300 142 8135540");
			return mapKey;
		}

		private SortedMap<Integer, String> getParams(
				Method method,
				boolean hasNamedParameters) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 300 143 8135540"); 
			final SortedMap<Integer, String> params = new TreeMap<Integer, String>();
			final Class<?>[] argTypes = method
					.getParameterTypes();
			for (int i = 0; (ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 300 144 8135540")|| true) && (i < argTypes.length? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 300 47 32 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 300 47 32 0 0 ","8135540",false,0) && false)); i++){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 300 145 8135540"); {
				int zoa_cond_n146_0 = 2;
int zoa_cond_n146_1 = 2;
//zoa_cond_n146_0#RowBounds.class.isAssignableFrom(argTypes[i])$zoa_cond_n146_1#ResultHandler.class.isAssignableFrom(argTypes[i])
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 300 146 8135540")|| true) && (!(RowBounds.class
						.isAssignableFrom(argTypes[i])?(zoa_cond_n146_0 != (zoa_cond_n146_0 = 1)):(zoa_cond_n146_0 == (zoa_cond_n146_0 = 0)))
						&& !(ResultHandler.class
								.isAssignableFrom(argTypes[i])?(zoa_cond_n146_1 != (zoa_cond_n146_1 = 1)):(zoa_cond_n146_1 == (zoa_cond_n146_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 300 50 33 1 2 ","8135540",true,zoa_cond_n146_0,zoa_cond_n146_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 300 50 33 0 2 ","8135540",false,zoa_cond_n146_0,zoa_cond_n146_1) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 300 147 8135540"); {
					String paramName = String
							.valueOf(params
									.size());
					if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 300 148 8135540")|| true) && (hasNamedParameters? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 300 51 34 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 300 51 34 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 300 149 8135540"); {
						paramName = getParamNameFromAnnotation(
								method,
								i,
								paramName);
					} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 300 150 8135540");
					params.put(i,
							paramName);
				} }
			}}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 300 152 8135540");
			return params;
		}

		private String getParamNameFromAnnotation(
				Method method, int i,
				String paramName) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 300 153 8135540"); 
			final Object[] paramAnnos = method
					.getParameterAnnotations()[i];
			for (Object paramAnno : /* TRUE */paramAnnos){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 300 154 8135540");ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 300 155 8135540"); {
				if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 300 156 8135540")|| true) && (paramAnno instanceof Param? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 300 52 35 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 300 52 35 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 300 157 8135540"); {
					paramName = ((Param) paramAnno)
							.value();
				} }
			}}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 300 159 8135540");
			return paramName;
		}

		private boolean hasNamedParams(
				Method method) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 300 160 8135540"); 
			boolean hasNamedParams = false;
			final Object[][] paramAnnos = method
					.getParameterAnnotations();
			for (Object[] paramAnno : /* TRUE */paramAnnos){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 300 161 8135540");ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 300 162 8135540"); {
				for (Object aParamAnno : /* TRUE */paramAnno){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 300 163 8135540");ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 300 164 8135540"); {
					if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 300 165 8135540")|| true) && (aParamAnno instanceof Param? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 300 53 36 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 300 53 36 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 300 166 8135540"); {
						hasNamedParams = true;
						 break;
					} }
				}}
			}}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 300 169 8135540");
			return hasNamedParams;
		}

	}

}

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
package org.apache.ibatis.builder;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.apache.ibatis.mapping.ParameterMode;
import org.apache.ibatis.mapping.ResultSetType;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeAliasRegistry;
import org.apache.ibatis.type.TypeHandler;
import org.apache.ibatis.type.TypeHandlerRegistry;

/**
 * @author Clinton Begin
 */
import com.process.ZoaExp;
import com.process.ZoaThreadLocal;
public abstract class BaseBuilder {
	protected final Configuration configuration;
	protected final TypeAliasRegistry typeAliasRegistry;
	protected final TypeHandlerRegistry typeHandlerRegistry;

	public BaseBuilder(
			Configuration configuration) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 168 0 8135540"); 
		this.configuration = configuration;
		this.typeAliasRegistry = this.configuration
				.getTypeAliasRegistry();
		this.typeHandlerRegistry = this.configuration
				.getTypeHandlerRegistry();
	}

	public Configuration getConfiguration() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 168 1 8135540"); 
		return configuration;
	}

	protected Boolean booleanValueOf(
			String value,
			Boolean defaultValue) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 168 2 8135540"); 
		return value == null ? defaultValue
				: Boolean
						.valueOf(value);
	}

	protected Integer integerValueOf(
			String value,
			Integer defaultValue) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 168 3 8135540"); 
		return value == null ? defaultValue
				: Integer
						.valueOf(value);
	}

	protected Set<String> stringSetValueOf(
			String value,
			String defaultValue) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 168 4 8135540"); 
		value = (value == null ? defaultValue
				: value);
		return new HashSet<String>(
				Arrays.asList(value
						.split(",")));
	}

	protected JdbcType resolveJdbcType(
			String alias) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 168 5 8135540"); 
		if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 168 6 8135540")|| true) && (alias == null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 168 0 0 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 168 0 0 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 168 7 8135540");
			return null; }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 168 8 8135540");
		try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 168 9 8135540"); 
			return JdbcType
					.valueOf(alias);
		} catch (IllegalArgumentException e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 168 10 8135540"); 
			throw new BuilderException(
					"Error resolving JdbcType. Cause: "
							+ e, e);
		}
	}

	protected ResultSetType resolveResultSetType(
			String alias) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 168 12 8135540"); 
		if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 168 13 8135540")|| true) && (alias == null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 168 1 1 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 168 1 1 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 168 14 8135540");
			return null; }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 168 15 8135540");
		try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 168 16 8135540"); 
			return ResultSetType
					.valueOf(alias);
		} catch (IllegalArgumentException e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 168 17 8135540"); 
			throw new BuilderException(
					"Error resolving ResultSetType. Cause: "
							+ e, e);
		}
	}

	protected ParameterMode resolveParameterMode(
			String alias) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 168 19 8135540"); 
		if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 168 20 8135540")|| true) && (alias == null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 168 2 2 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 168 2 2 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 168 21 8135540");
			return null; }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 168 22 8135540");
		try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 168 23 8135540"); 
			return ParameterMode
					.valueOf(alias);
		} catch (IllegalArgumentException e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 168 24 8135540"); 
			throw new BuilderException(
					"Error resolving ParameterMode. Cause: "
							+ e, e);
		}
	}

	protected Object createInstance(
			String alias) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 168 26 8135540"); 
		Class<?> clazz = resolveClass(alias);
		if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 168 27 8135540")|| true) && (clazz == null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 168 3 3 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 168 3 3 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 168 28 8135540");
			return null; }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 168 29 8135540");
		try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 168 30 8135540"); 
			return resolveClass(alias)
					.newInstance();
		} catch (Exception e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 168 31 8135540"); 
			throw new BuilderException(
					"Error creating instance. Cause: "
							+ e, e);
		}
	}

	protected Class<?> resolveClass(
			String alias) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 168 33 8135540"); 
		if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 168 34 8135540")|| true) && (alias == null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 168 4 4 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 168 4 4 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 168 35 8135540");
			return null; }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 168 36 8135540");
		try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 168 37 8135540"); 
			return resolveAlias(alias);
		} catch (Exception e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 168 38 8135540"); 
			throw new BuilderException(
					"Error resolving class. Cause: "
							+ e, e);
		}
	}

	protected TypeHandler<?> resolveTypeHandler(
			Class<?> javaType,
			String typeHandlerAlias) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 168 40 8135540"); 
		if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 168 41 8135540")|| true) && (typeHandlerAlias == null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 168 5 5 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 168 5 5 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 168 42 8135540");
			return null; }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 168 43 8135540");
		Class<?> type = resolveClass(typeHandlerAlias);
		int zoa_cond_n44_0 = 2;
int zoa_cond_n44_1 = 2;
//zoa_cond_n44_0#type != null$zoa_cond_n44_1#TypeHandler.class.isAssignableFrom(type)
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 168 44 8135540")|| true) && ((type != null?(zoa_cond_n44_0 != (zoa_cond_n44_0 = 1)):(zoa_cond_n44_0 == (zoa_cond_n44_0 = 0)))
				&& !(TypeHandler.class
						.isAssignableFrom(type)?(zoa_cond_n44_1 != (zoa_cond_n44_1 = 1)):(zoa_cond_n44_1 == (zoa_cond_n44_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 168 8 6 1 2 ","8135540",true,zoa_cond_n44_0,zoa_cond_n44_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 168 8 6 0 2 ","8135540",false,zoa_cond_n44_0,zoa_cond_n44_1) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 168 45 8135540"); {
			throw new BuilderException(
					"Type "
							+ type.getName()
							+ " is not a valid TypeHandler because it does not implement TypeHandler interface");
		} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 168 46 8135540");
		@SuppressWarnings("unchecked")
		// already verified it is a TypeHandler
		Class<? extends TypeHandler<?>> typeHandlerType = (Class<? extends TypeHandler<?>>) type;
		return resolveTypeHandler(
				javaType,
				typeHandlerType);
	}

	protected TypeHandler<?> resolveTypeHandler(
			Class<?> javaType,
			Class<? extends TypeHandler<?>> typeHandlerType) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 168 47 8135540"); 
		if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 168 48 8135540")|| true) && (typeHandlerType == null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 168 9 7 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 168 9 7 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 168 49 8135540");
			return null; }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 168 50 8135540");
		// javaType ignored for injected handlers see issue #746 for full detail
		TypeHandler<?> handler = typeHandlerRegistry
				.getMappingTypeHandler(typeHandlerType);
		if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 168 51 8135540")|| true) && (handler == null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 168 10 8 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 168 10 8 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 168 52 8135540"); {
			// not in registry, create a new one
			handler = typeHandlerRegistry
					.getInstance(
							javaType,
							typeHandlerType);
		} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 168 53 8135540");
		return handler;
	}

	protected Class<?> resolveAlias(
			String alias) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 168 54 8135540"); 
		return typeAliasRegistry
				.resolveAlias(alias);
	}
}

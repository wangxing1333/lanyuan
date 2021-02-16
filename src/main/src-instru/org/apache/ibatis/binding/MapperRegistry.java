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

import org.apache.ibatis.builder.annotation.MapperAnnotationBuilder;
import org.apache.ibatis.io.ResolverUtil;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author Clinton Begin
 * @author Eduardo Macarron
 * @author Lasse Voss
 */
import com.process.ZoaExp;
import com.process.ZoaThreadLocal;
public class MapperRegistry {

	private Configuration config;
	private final Map<Class<?>, MapperProxyFactory<?>> knownMappers = new HashMap<Class<?>, MapperProxyFactory<?>>();

	public MapperRegistry(
			Configuration config) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 277 0 8135540"); 
		this.config = config;
	}

	@SuppressWarnings("unchecked")
	public <T> T getMapper(
			Class<T> type,
			SqlSession sqlSession) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 277 1 8135540"); 
		final MapperProxyFactory<T> mapperProxyFactory = (MapperProxyFactory<T>) knownMappers
				.get(type);
		if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 277 2 8135540")|| true) && (mapperProxyFactory == null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 277 0 0 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 277 0 0 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 277 3 8135540");
			throw new BindingException(
					"Type "
							+ type
							+ " is not known to the MapperRegistry."); }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 277 4 8135540");
		try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 277 5 8135540"); 
			return mapperProxyFactory
					.newInstance(sqlSession);
		} catch (Exception e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 277 6 8135540"); 
			throw new BindingException(
					"Error getting mapper instance. Cause: "
							+ e, e);
		}
	}

	public <T> boolean hasMapper(
			Class<T> type) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 277 8 8135540"); 
		return knownMappers
				.containsKey(type);
	}

	public <T> void addMapper(
			Class<T> type) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 277 9 8135540"); 
		if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 277 10 8135540")|| true) && (type.isInterface()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 277 1 1 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 277 1 1 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 277 11 8135540"); {
			if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 277 12 8135540")|| true) && (hasMapper(type)? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 277 2 2 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 277 2 2 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 277 13 8135540"); {
				throw new BindingException(
						"Type "
								+ type
								+ " is already known to the MapperRegistry.");
			} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 277 14 8135540");
			boolean loadCompleted = false;
			try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 277 15 8135540"); 
				knownMappers
						.put(type,
								new MapperProxyFactory<T>(
										type));
				// It's important that the type is added before the parser is
				// run
				// otherwise the binding may automatically be attempted by the
				// mapper parser. If the type is already known, it won't try.
				MapperAnnotationBuilder parser = new MapperAnnotationBuilder(
						config, type);
				parser.parse();
				loadCompleted = true;
			} finally {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 277 16 8135540"); 
				if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 277 17 8135540")|| true) && (!loadCompleted? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 277 3 3 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 277 3 3 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 277 18 8135540"); {
					knownMappers
							.remove(type);
				} }
			}
		} }
	}

	/**
	 * @since 3.2.2
	 */
	public Collection<Class<?>> getMappers() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 277 22 8135540"); 
		return Collections
				.unmodifiableCollection(knownMappers
						.keySet());
	}

	/**
	 * @since 3.2.2
	 */
	public void addMappers(
			String packageName,
			Class<?> superType) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 277 23 8135540"); 
		ResolverUtil<Class<?>> resolverUtil = new ResolverUtil<Class<?>>();
		resolverUtil.find(
				new ResolverUtil.IsA(
						superType),
				packageName);
		Set<Class<? extends Class<?>>> mapperSet = resolverUtil
				.getClasses();
		for (Class<?> mapperClass : /* TRUE */mapperSet){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 277 24 8135540");ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 277 25 8135540"); {
			addMapper(mapperClass);
		}}
	}

	/**
	 * @since 3.2.2
	 */
	public void addMappers(
			String packageName) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 277 27 8135540"); 
		addMappers(packageName,
				Object.class);
	}

}

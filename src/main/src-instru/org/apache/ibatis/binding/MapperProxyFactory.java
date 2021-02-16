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

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.ibatis.session.SqlSession;

/**
 * @author Lasse Voss
 */
import com.process.ZoaExp;
import com.process.ZoaThreadLocal;
public class MapperProxyFactory<T> {

	private final Class<T> mapperInterface;
	private Map<Method, MapperMethod> methodCache = new ConcurrentHashMap<Method, MapperMethod>();

	public MapperProxyFactory(
			Class<T> mapperInterface) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 271 0 8135540"); 
		this.mapperInterface = mapperInterface;
	}

	public Class<T> getMapperInterface() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 271 1 8135540"); 
		return mapperInterface;
	}

	public Map<Method, MapperMethod> getMethodCache() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 271 2 8135540"); 
		return methodCache;
	}

	@SuppressWarnings("unchecked")
	protected T newInstance(
			MapperProxy<T> mapperProxy) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 271 3 8135540"); 
		return (T) Proxy
				.newProxyInstance(
						mapperInterface
								.getClassLoader(),
						new Class[] { mapperInterface },
						mapperProxy);
	}

	public T newInstance(
			SqlSession sqlSession) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 271 4 8135540"); 
		final MapperProxy<T> mapperProxy = new MapperProxy<T>(
				sqlSession,
				mapperInterface,
				methodCache);
		return newInstance(mapperProxy);
	}

}

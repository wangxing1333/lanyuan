// ZOA_CREATED! DO NOT EDIT IT! -- 
/*
 *    Copyright 2009-2014 the original author or authors.
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

import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Map;

import org.apache.ibatis.reflection.ExceptionUtil;
import org.apache.ibatis.session.SqlSession;

/**
 * @author Clinton Begin
 * @author Eduardo Macarron
 */
import com.process.ZoaExp;
import com.process.ZoaThreadLocal;
public class MapperProxy<T> implements
		InvocationHandler, Serializable {

	private static final long serialVersionUID = -6424540398559729838L;
	private final SqlSession sqlSession;
	private final Class<T> mapperInterface;
	private final Map<Method, MapperMethod> methodCache;

	public MapperProxy(
			SqlSession sqlSession,
			Class<T> mapperInterface,
			Map<Method, MapperMethod> methodCache) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 291 0 8135540"); 
		this.sqlSession = sqlSession;
		this.mapperInterface = mapperInterface;
		this.methodCache = methodCache;
	}

	public Object invoke(Object proxy,
			Method method, Object[] args)
			throws Throwable {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 291 1 8135540"); 
		if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 291 2 8135540")|| true) && (Object.class.equals(method
				.getDeclaringClass())? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 291 0 0 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 291 0 0 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 291 3 8135540"); {
			try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 291 4 8135540"); 
				return method.invoke(
						this, args);
			} catch (Throwable t) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 291 5 8135540"); 
				throw ExceptionUtil
						.unwrapThrowable(t);
			}
		} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 291 7 8135540");
		final MapperMethod mapperMethod = cachedMapperMethod(method);
		return mapperMethod.execute(
				sqlSession, args);
	}

	private MapperMethod cachedMapperMethod(
			Method method) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 291 8 8135540"); 
		MapperMethod mapperMethod = methodCache
				.get(method);
		if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 291 9 8135540")|| true) && (mapperMethod == null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 291 1 1 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 291 1 1 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 291 10 8135540"); {
			mapperMethod = new MapperMethod(
					mapperInterface,
					method,
					sqlSession
							.getConfiguration());
			methodCache.put(method,
					mapperMethod);
		} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 291 11 8135540");
		return mapperMethod;
	}

}

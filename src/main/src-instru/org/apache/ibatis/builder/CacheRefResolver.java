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

import org.apache.ibatis.cache.Cache;

/**
 * @author Clinton Begin
 */
import com.process.ZoaExp;
import com.process.ZoaThreadLocal;
public class CacheRefResolver {
	private final MapperBuilderAssistant assistant;
	private final String cacheRefNamespace;
	public CacheRefResolver(MapperBuilderAssistant assistant, String cacheRefNamespace) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 232 0 8135540"); 
		this.assistant = assistant;
		this.cacheRefNamespace = cacheRefNamespace;
	}
	public Cache resolveCacheRef() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 232 1 8135540"); 
		return assistant.useCacheRef(cacheRefNamespace);
	}
}
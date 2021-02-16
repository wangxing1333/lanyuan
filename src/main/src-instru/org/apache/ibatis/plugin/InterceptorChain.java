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
package org.apache.ibatis.plugin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Clinton Begin
 */
import com.process.ZoaExp;
import com.process.ZoaThreadLocal;
public class InterceptorChain {

	private final List<Interceptor> interceptors = new ArrayList<Interceptor>();

	public Object pluginAll(Object target) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 176 0 8135540"); 
		for (Interceptor interceptor : /* TRUE */interceptors){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 176 1 8135540");ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 176 2 8135540"); {
			target = interceptor.plugin(target);
		}}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 176 3 8135540");
		return target;
	}

	public void addInterceptor(Interceptor interceptor) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 176 4 8135540"); 
		interceptors.add(interceptor);
	}

	public List<Interceptor> getInterceptors() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 176 5 8135540"); 
		return Collections.unmodifiableList(interceptors);
	}

}

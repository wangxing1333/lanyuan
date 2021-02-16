// ZOA_CREATED! DO NOT EDIT IT! -- 
/*
 *    Copyright 2009-2011 the original author or authors.
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

import java.util.List;

import org.apache.ibatis.mapping.Discriminator;
import org.apache.ibatis.mapping.ResultMap;
import org.apache.ibatis.mapping.ResultMapping;

/**
 * @author Eduardo Macarron
 */
import com.process.ZoaExp;
import com.process.ZoaThreadLocal;
public class ResultMapResolver {
	private final MapperBuilderAssistant assistant;
	private String id;
	private Class<?> type;
	private String extend;
	private Discriminator discriminator;
	private List<ResultMapping> resultMappings;
	private Boolean autoMapping;

	public ResultMapResolver(
			MapperBuilderAssistant assistant,
			String id,
			Class<?> type,
			String extend,
			Discriminator discriminator,
			List<ResultMapping> resultMappings,
			Boolean autoMapping) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 295 0 8135540"); 
		this.assistant = assistant;
		this.id = id;
		this.type = type;
		this.extend = extend;
		this.discriminator = discriminator;
		this.resultMappings = resultMappings;
		this.autoMapping = autoMapping;
	}

	public ResultMap resolve() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 295 1 8135540"); 
		return assistant.addResultMap(
				this.id, this.type,
				this.extend,
				this.discriminator,
				this.resultMappings,
				this.autoMapping);
	}

}
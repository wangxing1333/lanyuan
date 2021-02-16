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
package org.apache.ibatis.datasource;

import org.apache.ibatis.exceptions.PersistenceException;

/**
 * @author Clinton Begin
 */
import com.process.ZoaExp;
import com.process.ZoaThreadLocal;
public class DataSourceException extends
		PersistenceException {

	private static final long serialVersionUID = -5251396250407091334L;

	public DataSourceException() {
		super();
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 231 0 8135540"); 
	}

	public DataSourceException(
			String message) {
		super(message);
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 231 1 8135540"); 
	}

	public DataSourceException(
			String message,
			Throwable cause) {
		super(message, cause);
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 231 2 8135540"); 
	}

	public DataSourceException(
			Throwable cause) {
		super(cause);
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 231 3 8135540"); 
	}

}
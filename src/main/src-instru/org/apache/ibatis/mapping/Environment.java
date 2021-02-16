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
package org.apache.ibatis.mapping;

import javax.sql.DataSource;

import org.apache.ibatis.transaction.TransactionFactory;

/**
 * @author Clinton Begin
 */
import com.process.ZoaExp;
import com.process.ZoaThreadLocal;
public final class Environment {
	private final String id;
	private final TransactionFactory transactionFactory;
	private final DataSource dataSource;

	public Environment(
			String id,
			TransactionFactory transactionFactory,
			DataSource dataSource) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 281 0 8135540"); 
		if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 281 1 8135540")|| true) && (id == null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 281 0 0 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 281 0 0 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 281 2 8135540"); {
			throw new IllegalArgumentException(
					"Parameter 'id' must not be null");
		} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 281 3 8135540");
		if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 281 4 8135540")|| true) && (transactionFactory == null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 281 1 1 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 281 1 1 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 281 5 8135540"); {
			throw new IllegalArgumentException(
					"Parameter 'transactionFactory' must not be null");
		} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 281 6 8135540");
		this.id = id;
		if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 281 7 8135540")|| true) && (dataSource == null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 281 2 2 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 281 2 2 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 281 8 8135540"); {
			throw new IllegalArgumentException(
					"Parameter 'dataSource' must not be null");
		} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 281 9 8135540");
		this.transactionFactory = transactionFactory;
		this.dataSource = dataSource;
	}

	public static class Builder {
		private String id;
		private TransactionFactory transactionFactory;
		private DataSource dataSource;

		public Builder(String id) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 281 10 8135540"); 
			this.id = id;
		}

		public Builder transactionFactory(
				TransactionFactory transactionFactory) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 281 11 8135540"); 
			this.transactionFactory = transactionFactory;
			return this;
		}

		public Builder dataSource(
				DataSource dataSource) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 281 12 8135540"); 
			this.dataSource = dataSource;
			return this;
		}

		public String id() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 281 13 8135540"); 
			return this.id;
		}

		public Environment build() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 281 14 8135540"); 
			return new Environment(
					this.id,
					this.transactionFactory,
					this.dataSource);
		}

	}

	public String getId() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 281 15 8135540"); 
		return this.id;
	}

	public TransactionFactory getTransactionFactory() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 281 16 8135540"); 
		return this.transactionFactory;
	}

	public DataSource getDataSource() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 281 17 8135540"); 
		return this.dataSource;
	}

}

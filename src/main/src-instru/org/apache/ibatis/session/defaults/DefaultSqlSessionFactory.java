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
package org.apache.ibatis.session.defaults;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.ibatis.exceptions.ExceptionFactory;
import org.apache.ibatis.executor.ErrorContext;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.TransactionIsolationLevel;
import org.apache.ibatis.transaction.Transaction;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.managed.ManagedTransactionFactory;

/**
 * @author Clinton Begin
 */
import com.process.ZoaExp;
import com.process.ZoaThreadLocal;
public class DefaultSqlSessionFactory
		implements SqlSessionFactory {

	private final Configuration configuration;

	public DefaultSqlSessionFactory(
			Configuration configuration) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 192 0 8135540"); 
		this.configuration = configuration;
	}

	public SqlSession openSession() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 192 1 8135540"); 
		return openSessionFromDataSource(
				configuration
						.getDefaultExecutorType(),
				null, false);
	}

	public SqlSession openSession(
			boolean autoCommit) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 192 2 8135540"); 
		return openSessionFromDataSource(
				configuration
						.getDefaultExecutorType(),
				null, autoCommit);
	}

	public SqlSession openSession(
			ExecutorType execType) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 192 3 8135540"); 
		return openSessionFromDataSource(
				execType, null, false);
	}

	public SqlSession openSession(
			TransactionIsolationLevel level) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 192 4 8135540"); 
		return openSessionFromDataSource(
				configuration
						.getDefaultExecutorType(),
				level, false);
	}

	public SqlSession openSession(
			ExecutorType execType,
			TransactionIsolationLevel level) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 192 5 8135540"); 
		return openSessionFromDataSource(
				execType, level, false);
	}

	public SqlSession openSession(
			ExecutorType execType,
			boolean autoCommit) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 192 6 8135540"); 
		return openSessionFromDataSource(
				execType, null,
				autoCommit);
	}

	public SqlSession openSession(
			Connection connection) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 192 7 8135540"); 
		return openSessionFromConnection(
				configuration
						.getDefaultExecutorType(),
				connection);
	}

	public SqlSession openSession(
			ExecutorType execType,
			Connection connection) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 192 8 8135540"); 
		return openSessionFromConnection(
				execType, connection);
	}

	public Configuration getConfiguration() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 192 9 8135540"); 
		return configuration;
	}

	private SqlSession openSessionFromDataSource(
			ExecutorType execType,
			TransactionIsolationLevel level,
			boolean autoCommit) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 192 10 8135540"); 
		Transaction tx = null;
		try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 192 11 8135540"); 
			final Environment environment = configuration
					.getEnvironment();
			final TransactionFactory transactionFactory = getTransactionFactoryFromEnvironment(environment);
			tx = transactionFactory
					.newTransaction(
							environment
									.getDataSource(),
							level,
							autoCommit);
			final Executor executor = configuration
					.newExecutor(tx,
							execType);
			return new DefaultSqlSession(
					configuration,
					executor,
					autoCommit);
		} catch (Exception e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 192 12 8135540"); 
			closeTransaction(tx); // may have fetched a connection so lets call
									// close()
			throw ExceptionFactory
					.wrapException(
							"Error opening session.  Cause: "
									+ e,
							e);
		} finally {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 192 13 8135540"); 
			ErrorContext.instance()
					.reset();
		}
	}

	private SqlSession openSessionFromConnection(
			ExecutorType execType,
			Connection connection) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 192 15 8135540"); 
		try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 192 16 8135540"); 
			boolean autoCommit;
			try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 192 17 8135540"); 
				autoCommit = connection
						.getAutoCommit();
			} catch (SQLException e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 192 18 8135540"); 
				// Failover to true, as most poor drivers
				// or databases won't support transactions
				autoCommit = true;
			}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 192 19 8135540");
			final Environment environment = configuration
					.getEnvironment();
			final TransactionFactory transactionFactory = getTransactionFactoryFromEnvironment(environment);
			final Transaction tx = transactionFactory
					.newTransaction(connection);
			final Executor executor = configuration
					.newExecutor(tx,
							execType);
			return new DefaultSqlSession(
					configuration,
					executor,
					autoCommit);
		} catch (Exception e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 192 20 8135540"); 
			throw ExceptionFactory
					.wrapException(
							"Error opening session.  Cause: "
									+ e,
							e);
		} finally {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 192 21 8135540"); 
			ErrorContext.instance()
					.reset();
		}
	}

	private TransactionFactory getTransactionFactoryFromEnvironment(
			Environment environment) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 192 23 8135540"); 
		int zoa_cond_n24_0 = 2;
int zoa_cond_n24_1 = 2;
//zoa_cond_n24_0#environment == null$zoa_cond_n24_1#environment.getTransactionFactory() == null
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 192 24 8135540")|| true) && ((environment == null?(zoa_cond_n24_0 != (zoa_cond_n24_0 = 1)):(zoa_cond_n24_0 == (zoa_cond_n24_0 = 0)))
				|| (environment
						.getTransactionFactory() == null?(zoa_cond_n24_1 != (zoa_cond_n24_1 = 1)):(zoa_cond_n24_1 == (zoa_cond_n24_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 192 2 0 1 2 ","8135540",true,zoa_cond_n24_0,zoa_cond_n24_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 192 2 0 0 2 ","8135540",false,zoa_cond_n24_0,zoa_cond_n24_1) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 192 25 8135540"); {
			return new ManagedTransactionFactory();
		} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 192 26 8135540");
		return environment
				.getTransactionFactory();
	}

	private void closeTransaction(
			Transaction tx) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 192 27 8135540"); 
		if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 192 28 8135540")|| true) && (tx != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 192 3 1 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 192 3 1 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 192 29 8135540"); {
			try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 192 30 8135540"); 
				tx.close();
			} catch (SQLException ignore) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 192 31 8135540"); 
				// Intentionally ignore. Prefer previous error.
			}
		} }
	}

}

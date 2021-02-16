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
package org.apache.ibatis.datasource.pooled;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.SQLException;

import org.apache.ibatis.reflection.ExceptionUtil;

/**
 * @author Clinton Begin
 */
import com.process.ZoaExp;
import com.process.ZoaThreadLocal;
class PooledConnection implements
		InvocationHandler {

	private static final String CLOSE = "close";
	private static final Class<?>[] IFACES = new Class<?>[] { Connection.class };

	private int hashCode = 0;
	private PooledDataSource dataSource;
	private Connection realConnection;
	private Connection proxyConnection;
	private long checkoutTimestamp;
	private long createdTimestamp;
	private long lastUsedTimestamp;
	private int connectionTypeCode;
	private boolean valid;

	/*
	 * Constructor for SimplePooledConnection that uses the Connection and
	 * PooledDataSource passed in
	 * 
	 * @param connection - the connection that is to be presented as a pooled
	 * connection
	 * 
	 * @param dataSource - the dataSource that the connection is from
	 */
	public PooledConnection(
			Connection connection,
			PooledDataSource dataSource) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 240 0 8135540"); 
		this.hashCode = connection
				.hashCode();
		this.realConnection = connection;
		this.dataSource = dataSource;
		this.createdTimestamp = System
				.currentTimeMillis();
		this.lastUsedTimestamp = System
				.currentTimeMillis();
		this.valid = true;
		this.proxyConnection = (Connection) Proxy
				.newProxyInstance(
						Connection.class
								.getClassLoader(),
						IFACES, this);
	}

	/*
	 * Invalidates the connection
	 */
	public void invalidate() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 240 1 8135540"); 
		valid = false;
	}

	/*
	 * Method to see if the connection is usable
	 * 
	 * @return True if the connection is usable
	 */
	public boolean isValid() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 240 2 8135540"); 
		return valid
				&& realConnection != null
				&& dataSource
						.pingConnection(this);
	}

	/*
	 * Getter for the *real* connection that this wraps
	 * 
	 * @return The connection
	 */
	public Connection getRealConnection() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 240 3 8135540"); 
		return realConnection;
	}

	/*
	 * Getter for the proxy for the connection
	 * 
	 * @return The proxy
	 */
	public Connection getProxyConnection() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 240 4 8135540"); 
		return proxyConnection;
	}

	/*
	 * Gets the hashcode of the real connection (or 0 if it is null)
	 * 
	 * @return The hashcode of the real connection (or 0 if it is null)
	 */
	public int getRealHashCode() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 240 5 8135540"); 
		if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 240 6 8135540")|| true) && (realConnection == null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 240 0 0 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 240 0 0 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 240 7 8135540"); {
			return 0;
		} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 240 8 8135540");  {
			return realConnection
					.hashCode();
		} }
	}

	/*
	 * Getter for the connection type (based on url + user + password)
	 * 
	 * @return The connection type
	 */
	public int getConnectionTypeCode() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 240 10 8135540"); 
		return connectionTypeCode;
	}

	/*
	 * Setter for the connection type
	 * 
	 * @param connectionTypeCode - the connection type
	 */
	public void setConnectionTypeCode(
			int connectionTypeCode) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 240 11 8135540"); 
		this.connectionTypeCode = connectionTypeCode;
	}

	/*
	 * Getter for the time that the connection was created
	 * 
	 * @return The creation timestamp
	 */
	public long getCreatedTimestamp() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 240 12 8135540"); 
		return createdTimestamp;
	}

	/*
	 * Setter for the time that the connection was created
	 * 
	 * @param createdTimestamp - the timestamp
	 */
	public void setCreatedTimestamp(
			long createdTimestamp) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 240 13 8135540"); 
		this.createdTimestamp = createdTimestamp;
	}

	/*
	 * Getter for the time that the connection was last used
	 * 
	 * @return - the timestamp
	 */
	public long getLastUsedTimestamp() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 240 14 8135540"); 
		return lastUsedTimestamp;
	}

	/*
	 * Setter for the time that the connection was last used
	 * 
	 * @param lastUsedTimestamp - the timestamp
	 */
	public void setLastUsedTimestamp(
			long lastUsedTimestamp) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 240 15 8135540"); 
		this.lastUsedTimestamp = lastUsedTimestamp;
	}

	/*
	 * Getter for the time since this connection was last used
	 * 
	 * @return - the time since the last use
	 */
	public long getTimeElapsedSinceLastUse() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 240 16 8135540"); 
		return System
				.currentTimeMillis()
				- lastUsedTimestamp;
	}

	/*
	 * Getter for the age of the connection
	 * 
	 * @return the age
	 */
	public long getAge() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 240 17 8135540"); 
		return System
				.currentTimeMillis()
				- createdTimestamp;
	}

	/*
	 * Getter for the timestamp that this connection was checked out
	 * 
	 * @return the timestamp
	 */
	public long getCheckoutTimestamp() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 240 18 8135540"); 
		return checkoutTimestamp;
	}

	/*
	 * Setter for the timestamp that this connection was checked out
	 * 
	 * @param timestamp the timestamp
	 */
	public void setCheckoutTimestamp(
			long timestamp) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 240 19 8135540"); 
		this.checkoutTimestamp = timestamp;
	}

	/*
	 * Getter for the time that this connection has been checked out
	 * 
	 * @return the time
	 */
	public long getCheckoutTime() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 240 20 8135540"); 
		return System
				.currentTimeMillis()
				- checkoutTimestamp;
	}

	public int hashCode() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 240 21 8135540"); 
		return hashCode;
	}

	/*
	 * Allows comparing this connection to another
	 * 
	 * @param obj - the other connection to test for equality
	 * 
	 * @see Object#equals(Object)
	 */
	public boolean equals(Object obj) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 240 22 8135540"); 
		if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 240 23 8135540")|| true) && (obj instanceof PooledConnection? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 240 1 1 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 240 1 1 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 240 24 8135540"); {
			return realConnection
					.hashCode() == (((PooledConnection) obj).realConnection
					.hashCode());
		} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 240 25 8135540");  if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 240 26 8135540")|| true) && (obj instanceof Connection? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 240 2 2 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 240 2 2 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 240 27 8135540"); {
			return hashCode == obj
					.hashCode();
		} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 240 28 8135540");  {
			return false;
		} } }
	}

	/*
	 * Required for InvocationHandler implementation.
	 * 
	 * @param proxy - not used
	 * 
	 * @param method - the method to be executed
	 * 
	 * @param args - the parameters to be passed to the method
	 * 
	 * @see java.lang.reflect.InvocationHandler#invoke(Object,
	 * java.lang.reflect.Method, Object[])
	 */
	public Object invoke(Object proxy,
			Method method, Object[] args)
			throws Throwable {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 240 31 8135540"); 
		String methodName = method
				.getName();
		int zoa_cond_n32_0 = 2;
int zoa_cond_n32_1 = 2;
//zoa_cond_n32_0#CLOSE.hashCode() == methodName.hashCode()$zoa_cond_n32_1#CLOSE.equals(methodName)
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 240 32 8135540")|| true) && ((CLOSE.hashCode() == methodName
				.hashCode()?(zoa_cond_n32_0 != (zoa_cond_n32_0 = 1)):(zoa_cond_n32_0 == (zoa_cond_n32_0 = 0)))
				&& (CLOSE.equals(methodName)?(zoa_cond_n32_1 != (zoa_cond_n32_1 = 1)):(zoa_cond_n32_1 == (zoa_cond_n32_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 240 5 3 1 2 ","8135540",true,zoa_cond_n32_0,zoa_cond_n32_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 240 5 3 0 2 ","8135540",false,zoa_cond_n32_0,zoa_cond_n32_1) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 240 33 8135540"); {
			dataSource
					.pushConnection(this);
			return null;
		} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 240 34 8135540");  {
			try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 240 35 8135540"); 
				if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 240 36 8135540")|| true) && (!Object.class
						.equals(method
								.getDeclaringClass())? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 240 6 4 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 240 6 4 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 240 37 8135540"); {
					// issue #579 toString() should never fail
					// throw an SQLException instead of a Runtime
					checkConnection();
				} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 240 38 8135540");
				return method.invoke(
						realConnection,
						args);
			} catch (Throwable t) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 240 39 8135540"); 
				throw ExceptionUtil
						.unwrapThrowable(t);
			}
		} }
	}

	private void checkConnection()
			throws SQLException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 240 42 8135540"); 
		if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 240 43 8135540")|| true) && (!valid? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 240 7 5 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 240 7 5 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 240 44 8135540"); {
			throw new SQLException(
					"Error accessing PooledConnection. Connection is invalid.");
		} }
	}

}

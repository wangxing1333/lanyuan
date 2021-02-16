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
package org.apache.ibatis.datasource.pooled;

import java.io.PrintWriter;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.apache.ibatis.datasource.unpooled.UnpooledDataSource;
import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;

/**
 * This is a simple, synchronous, thread-safe database connection pool.
 * 
 * @author Clinton Begin
 */
import com.process.ZoaExp;
import com.process.ZoaThreadLocal;
public class PooledDataSource implements
		DataSource {

	private static final Log log = LogFactory
			.getLog(PooledDataSource.class);

	private final PoolState state = new PoolState(
			this);

	private final UnpooledDataSource dataSource;

	// OPTIONAL CONFIGURATION FIELDS
	protected int poolMaximumActiveConnections = 10;
	protected int poolMaximumIdleConnections = 5;
	protected int poolMaximumCheckoutTime = 20000;
	protected int poolTimeToWait = 20000;
	protected String poolPingQuery = "NO PING QUERY SET";
	protected boolean poolPingEnabled = false;
	protected int poolPingConnectionsNotUsedFor = 0;

	private int expectedConnectionTypeCode;

	public PooledDataSource() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 296 0 8135540"); 
		dataSource = new UnpooledDataSource();
	}

	public PooledDataSource(
			String driver, String url,
			String username,
			String password) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 296 1 8135540"); 
		dataSource = new UnpooledDataSource(
				driver, url, username,
				password);
		expectedConnectionTypeCode = assembleConnectionTypeCode(
				dataSource.getUrl(),
				dataSource
						.getUsername(),
				dataSource
						.getPassword());
	}

	public PooledDataSource(
			String driver, String url,
			Properties driverProperties) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 296 2 8135540"); 
		dataSource = new UnpooledDataSource(
				driver, url,
				driverProperties);
		expectedConnectionTypeCode = assembleConnectionTypeCode(
				dataSource.getUrl(),
				dataSource
						.getUsername(),
				dataSource
						.getPassword());
	}

	public PooledDataSource(
			ClassLoader driverClassLoader,
			String driver, String url,
			String username,
			String password) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 296 3 8135540"); 
		dataSource = new UnpooledDataSource(
				driverClassLoader,
				driver, url, username,
				password);
		expectedConnectionTypeCode = assembleConnectionTypeCode(
				dataSource.getUrl(),
				dataSource
						.getUsername(),
				dataSource
						.getPassword());
	}

	public PooledDataSource(
			ClassLoader driverClassLoader,
			String driver, String url,
			Properties driverProperties) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 296 4 8135540"); 
		dataSource = new UnpooledDataSource(
				driverClassLoader,
				driver, url,
				driverProperties);
		expectedConnectionTypeCode = assembleConnectionTypeCode(
				dataSource.getUrl(),
				dataSource
						.getUsername(),
				dataSource
						.getPassword());
	}

	public Connection getConnection()
			throws SQLException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 296 5 8135540"); 
		return popConnection(
				dataSource
						.getUsername(),
				dataSource
						.getPassword())
				.getProxyConnection();
	}

	public Connection getConnection(
			String username,
			String password)
			throws SQLException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 296 6 8135540"); 
		return popConnection(username,
				password)
				.getProxyConnection();
	}

	public void setLoginTimeout(
			int loginTimeout)
			throws SQLException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 296 7 8135540"); 
		DriverManager
				.setLoginTimeout(loginTimeout);
	}

	public int getLoginTimeout()
			throws SQLException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 296 8 8135540"); 
		return DriverManager
				.getLoginTimeout();
	}

	public void setLogWriter(
			PrintWriter logWriter)
			throws SQLException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 296 9 8135540"); 
		DriverManager
				.setLogWriter(logWriter);
	}

	public PrintWriter getLogWriter()
			throws SQLException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 296 10 8135540"); 
		return DriverManager
				.getLogWriter();
	}

	public void setDriver(String driver) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 296 11 8135540"); 
		dataSource.setDriver(driver);
		forceCloseAll();
	}

	public void setUrl(String url) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 296 12 8135540"); 
		dataSource.setUrl(url);
		forceCloseAll();
	}

	public void setUsername(
			String username) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 296 13 8135540"); 
		dataSource
				.setUsername(username);
		forceCloseAll();
	}

	public void setPassword(
			String password) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 296 14 8135540"); 
		dataSource
				.setPassword(password);
		forceCloseAll();
	}

	public void setDefaultAutoCommit(
			boolean defaultAutoCommit) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 296 15 8135540"); 
		dataSource
				.setAutoCommit(defaultAutoCommit);
		forceCloseAll();
	}

	public void setDefaultTransactionIsolationLevel(
			Integer defaultTransactionIsolationLevel) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 296 16 8135540"); 
		dataSource
				.setDefaultTransactionIsolationLevel(defaultTransactionIsolationLevel);
		forceCloseAll();
	}

	public void setDriverProperties(
			Properties driverProps) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 296 17 8135540"); 
		dataSource
				.setDriverProperties(driverProps);
		forceCloseAll();
	}

	/*
	 * The maximum number of active connections
	 * 
	 * @param poolMaximumActiveConnections The maximum number of active
	 * connections
	 */
	public void setPoolMaximumActiveConnections(
			int poolMaximumActiveConnections) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 296 18 8135540"); 
		this.poolMaximumActiveConnections = poolMaximumActiveConnections;
		forceCloseAll();
	}

	/*
	 * The maximum number of idle connections
	 * 
	 * @param poolMaximumIdleConnections The maximum number of idle connections
	 */
	public void setPoolMaximumIdleConnections(
			int poolMaximumIdleConnections) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 296 19 8135540"); 
		this.poolMaximumIdleConnections = poolMaximumIdleConnections;
		forceCloseAll();
	}

	/*
	 * The maximum time a connection can be used before it *may* be given away
	 * again.
	 * 
	 * @param poolMaximumCheckoutTime The maximum time
	 */
	public void setPoolMaximumCheckoutTime(
			int poolMaximumCheckoutTime) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 296 20 8135540"); 
		this.poolMaximumCheckoutTime = poolMaximumCheckoutTime;
		forceCloseAll();
	}

	/*
	 * The time to wait before retrying to get a connection
	 * 
	 * @param poolTimeToWait The time to wait
	 */
	public void setPoolTimeToWait(
			int poolTimeToWait) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 296 21 8135540"); 
		this.poolTimeToWait = poolTimeToWait;
		forceCloseAll();
	}

	/*
	 * The query to be used to check a connection
	 * 
	 * @param poolPingQuery The query
	 */
	public void setPoolPingQuery(
			String poolPingQuery) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 296 22 8135540"); 
		this.poolPingQuery = poolPingQuery;
		forceCloseAll();
	}

	/*
	 * Determines if the ping query should be used.
	 * 
	 * @param poolPingEnabled True if we need to check a connection before using
	 * it
	 */
	public void setPoolPingEnabled(
			boolean poolPingEnabled) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 296 23 8135540"); 
		this.poolPingEnabled = poolPingEnabled;
		forceCloseAll();
	}

	/*
	 * If a connection has not been used in this many milliseconds, ping the
	 * database to make sure the connection is still good.
	 * 
	 * @param milliseconds the number of milliseconds of inactivity that will
	 * trigger a ping
	 */
	public void setPoolPingConnectionsNotUsedFor(
			int milliseconds) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 296 24 8135540"); 
		this.poolPingConnectionsNotUsedFor = milliseconds;
		forceCloseAll();
	}

	public String getDriver() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 296 25 8135540"); 
		return dataSource.getDriver();
	}

	public String getUrl() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 296 26 8135540"); 
		return dataSource.getUrl();
	}

	public String getUsername() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 296 27 8135540"); 
		return dataSource.getUsername();
	}

	public String getPassword() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 296 28 8135540"); 
		return dataSource.getPassword();
	}

	public boolean isAutoCommit() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 296 29 8135540"); 
		return dataSource
				.isAutoCommit();
	}

	public Integer getDefaultTransactionIsolationLevel() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 296 30 8135540"); 
		return dataSource
				.getDefaultTransactionIsolationLevel();
	}

	public Properties getDriverProperties() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 296 31 8135540"); 
		return dataSource
				.getDriverProperties();
	}

	public int getPoolMaximumActiveConnections() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 296 32 8135540"); 
		return poolMaximumActiveConnections;
	}

	public int getPoolMaximumIdleConnections() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 296 33 8135540"); 
		return poolMaximumIdleConnections;
	}

	public int getPoolMaximumCheckoutTime() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 296 34 8135540"); 
		return poolMaximumCheckoutTime;
	}

	public int getPoolTimeToWait() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 296 35 8135540"); 
		return poolTimeToWait;
	}

	public String getPoolPingQuery() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 296 36 8135540"); 
		return poolPingQuery;
	}

	public boolean isPoolPingEnabled() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 296 37 8135540"); 
		return poolPingEnabled;
	}

	public int getPoolPingConnectionsNotUsedFor() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 296 38 8135540"); 
		return poolPingConnectionsNotUsedFor;
	}

	/*
	 * Closes all active and idle connections in the pool
	 */
	public void forceCloseAll() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 296 39 8135540"); 
		synchronized (state) {
			expectedConnectionTypeCode = assembleConnectionTypeCode(
					dataSource.getUrl(),
					dataSource
							.getUsername(),
					dataSource
							.getPassword());
			for (int i = state.activeConnections
					.size(); (ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 296 40 8135540")|| true) && (i > 0? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 296 0 0 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 296 0 0 0 0 ","8135540",false,0) && false)); i--){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 296 41 8135540"); {
				try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 296 42 8135540"); 
					PooledConnection conn = state.activeConnections
							.remove(i - 1);
					conn.invalidate();

					Connection realConn = conn
							.getRealConnection();
					if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 296 43 8135540")|| true) && (!realConn
							.getAutoCommit()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 296 1 1 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 296 1 1 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 296 44 8135540"); {
						realConn.rollback();
					} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 296 45 8135540");
					realConn.close();
				} catch (Exception e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 296 46 8135540"); 
					// ignore
				}
			}}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 296 48 8135540");
			for (int i = state.idleConnections
					.size(); (ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 296 49 8135540")|| true) && (i > 0? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 296 2 2 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 296 2 2 0 0 ","8135540",false,0) && false)); i--){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 296 50 8135540"); {
				try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 296 51 8135540"); 
					PooledConnection conn = state.idleConnections
							.remove(i - 1);
					conn.invalidate();

					Connection realConn = conn
							.getRealConnection();
					if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 296 52 8135540")|| true) && (!realConn
							.getAutoCommit()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 296 3 3 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 296 3 3 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 296 53 8135540"); {
						realConn.rollback();
					} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 296 54 8135540");
					realConn.close();
				} catch (Exception e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 296 55 8135540"); 
					// ignore
				}
			}}
		}
		if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 296 58 8135540")|| true) && (log.isDebugEnabled()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 296 4 4 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 296 4 4 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 296 59 8135540"); {
			log.debug("PooledDataSource forcefully closed/removed all connections.");
		} }
	}

	public PoolState getPoolState() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 296 61 8135540"); 
		return state;
	}

	private int assembleConnectionTypeCode(
			String url,
			String username,
			String password) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 296 62 8135540"); 
		return ("" + url + username + password)
				.hashCode();
	}

	protected void pushConnection(
			PooledConnection conn)
			throws SQLException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 296 63 8135540"); 

		synchronized (state) {
			state.activeConnections
					.remove(conn);
			if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 296 64 8135540")|| true) && (conn.isValid()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 296 5 5 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 296 5 5 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 296 65 8135540"); {
				int zoa_cond_n66_0 = 2;
int zoa_cond_n66_1 = 2;
//zoa_cond_n66_0#state.idleConnections.size() < poolMaximumIdleConnections$zoa_cond_n66_1#conn.getConnectionTypeCode() == expectedConnectionTypeCode
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 296 66 8135540")|| true) && ((state.idleConnections
						.size() < poolMaximumIdleConnections?(zoa_cond_n66_0 != (zoa_cond_n66_0 = 1)):(zoa_cond_n66_0 == (zoa_cond_n66_0 = 0)))
						&& (conn.getConnectionTypeCode() == expectedConnectionTypeCode?(zoa_cond_n66_1 != (zoa_cond_n66_1 = 1)):(zoa_cond_n66_1 == (zoa_cond_n66_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 296 8 6 1 2 ","8135540",true,zoa_cond_n66_0,zoa_cond_n66_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 296 8 6 0 2 ","8135540",false,zoa_cond_n66_0,zoa_cond_n66_1) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 296 67 8135540"); {
					state.accumulatedCheckoutTime += conn
							.getCheckoutTime();
					if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 296 68 8135540")|| true) && (!conn
							.getRealConnection()
							.getAutoCommit()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 296 9 7 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 296 9 7 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 296 69 8135540"); {
						conn.getRealConnection()
								.rollback();
					} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 296 70 8135540");
					PooledConnection newConn = new PooledConnection(
							conn.getRealConnection(),
							this);
					state.idleConnections
							.add(newConn);
					newConn.setCreatedTimestamp(conn
							.getCreatedTimestamp());
					newConn.setLastUsedTimestamp(conn
							.getLastUsedTimestamp());
					conn.invalidate();
					if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 296 71 8135540")|| true) && (log.isDebugEnabled()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 296 10 8 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 296 10 8 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 296 72 8135540"); {
						log.debug("Returned connection "
								+ newConn
										.getRealHashCode()
								+ " to pool.");
					} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 296 73 8135540");
					state.notifyAll();
				} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 296 74 8135540");  {
					state.accumulatedCheckoutTime += conn
							.getCheckoutTime();
					if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 296 75 8135540")|| true) && (!conn
							.getRealConnection()
							.getAutoCommit()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 296 11 9 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 296 11 9 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 296 76 8135540"); {
						conn.getRealConnection()
								.rollback();
					} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 296 77 8135540");
					conn.getRealConnection()
							.close();
					if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 296 78 8135540")|| true) && (log.isDebugEnabled()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 296 12 10 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 296 12 10 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 296 79 8135540"); {
						log.debug("Closed connection "
								+ conn.getRealHashCode()
								+ ".");
					} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 296 80 8135540");
					conn.invalidate();
				} }
			} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 296 82 8135540");  {
				if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 296 83 8135540")|| true) && (log.isDebugEnabled()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 296 13 11 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 296 13 11 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 296 84 8135540"); {
					log.debug("A bad connection ("
							+ conn.getRealHashCode()
							+ ") attempted to return to the pool, discarding connection.");
				} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 296 85 8135540");
				state.badConnectionCount++;
			} }
		}
	}

	private PooledConnection popConnection(
			String username,
			String password)
			throws SQLException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 296 87 8135540"); 
		boolean countedWait = false;
		PooledConnection conn = null;
		long t = System
				.currentTimeMillis();
		int localBadConnectionCount = 0;

		while ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 296 88 8135540")|| true) && (conn == null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 296 14 12 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 296 14 12 0 0 ","8135540",false,0) && false))){ ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 296 89 8135540");  {
			synchronized (state) {
				if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 296 90 8135540")|| true) && (state.idleConnections
						.size() > 0? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 296 15 13 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 296 15 13 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 296 91 8135540"); {
					// Pool has available connection
					conn = state.idleConnections
							.remove(0);
					if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 296 92 8135540")|| true) && (log.isDebugEnabled()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 296 16 14 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 296 16 14 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 296 93 8135540"); {
						log.debug("Checked out connection "
								+ conn.getRealHashCode()
								+ " from pool.");
					} }
				} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 296 95 8135540");  {
					// Pool does not have available connection
					if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 296 96 8135540")|| true) && (state.activeConnections
							.size() < poolMaximumActiveConnections? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 296 17 15 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 296 17 15 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 296 97 8135540"); {
						// Can create new connection
						conn = new PooledConnection(
								dataSource
										.getConnection(),
								this);
						@SuppressWarnings("unused")
						// used in logging, if enabled
						Connection realConn = conn
								.getRealConnection();
						if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 296 98 8135540")|| true) && (log.isDebugEnabled()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 296 18 16 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 296 18 16 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 296 99 8135540"); {
							log.debug("Created connection "
									+ conn.getRealHashCode()
									+ ".");
						} }
					} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 296 101 8135540");  {
						// Cannot create new connection
						PooledConnection oldestActiveConnection = state.activeConnections
								.get(0);
						long longestCheckoutTime = oldestActiveConnection
								.getCheckoutTime();
						if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 296 102 8135540")|| true) && (longestCheckoutTime > poolMaximumCheckoutTime? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 296 19 17 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 296 19 17 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 296 103 8135540"); {
							// Can claim overdue connection
							state.claimedOverdueConnectionCount++;
							state.accumulatedCheckoutTimeOfOverdueConnections += longestCheckoutTime;
							state.accumulatedCheckoutTime += longestCheckoutTime;
							state.activeConnections
									.remove(oldestActiveConnection);
							if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 296 104 8135540")|| true) && (!oldestActiveConnection
									.getRealConnection()
									.getAutoCommit()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 296 20 18 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 296 20 18 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 296 105 8135540"); {
								oldestActiveConnection
										.getRealConnection()
										.rollback();
							} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 296 106 8135540");
							conn = new PooledConnection(
									oldestActiveConnection
											.getRealConnection(),
									this);
							oldestActiveConnection
									.invalidate();
							if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 296 107 8135540")|| true) && (log.isDebugEnabled()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 296 21 19 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 296 21 19 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 296 108 8135540"); {
								log.debug("Claimed overdue connection "
										+ conn.getRealHashCode()
										+ ".");
							} }
						} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 296 110 8135540");  {
							// Must wait
							try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 296 111 8135540"); 
								if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 296 112 8135540")|| true) && (!countedWait? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 296 22 20 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 296 22 20 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 296 113 8135540"); {
									state.hadToWaitCount++;
									countedWait = true;
								} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 296 114 8135540");
								if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 296 115 8135540")|| true) && (log.isDebugEnabled()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 296 23 21 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 296 23 21 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 296 116 8135540"); {
									log.debug("Waiting as long as "
											+ poolTimeToWait
											+ " milliseconds for connection.");
								} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 296 117 8135540");
								long wt = System
										.currentTimeMillis();
								state.wait(poolTimeToWait);
								state.accumulatedWaitTime += System
										.currentTimeMillis()
										- wt;
							} catch (InterruptedException e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 296 118 8135540"); 
								 break;
							}
						} }
					} }
				} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 296 122 8135540");
				if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 296 123 8135540")|| true) && (conn != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 296 24 22 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 296 24 22 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 296 124 8135540"); {
					if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 296 125 8135540")|| true) && (conn.isValid()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 296 25 23 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 296 25 23 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 296 126 8135540"); {
						if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 296 127 8135540")|| true) && (!conn
								.getRealConnection()
								.getAutoCommit()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 296 26 24 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 296 26 24 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 296 128 8135540"); {
							conn.getRealConnection()
									.rollback();
						} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 296 129 8135540");
						conn.setConnectionTypeCode(assembleConnectionTypeCode(
								dataSource
										.getUrl(),
								username,
								password));
						conn.setCheckoutTimestamp(System
								.currentTimeMillis());
						conn.setLastUsedTimestamp(System
								.currentTimeMillis());
						state.activeConnections
								.add(conn);
						state.requestCount++;
						state.accumulatedRequestTime += System
								.currentTimeMillis()
								- t;
					} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 296 130 8135540");  {
						if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 296 131 8135540")|| true) && (log.isDebugEnabled()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 296 27 25 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 296 27 25 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 296 132 8135540"); {
							log.debug("A bad connection ("
									+ conn.getRealHashCode()
									+ ") was returned from the pool, getting another connection.");
						} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 296 133 8135540");
						state.badConnectionCount++;
						localBadConnectionCount++;
						conn = null;
						if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 296 134 8135540")|| true) && (localBadConnectionCount > (poolMaximumIdleConnections + 3)? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 296 28 26 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 296 28 26 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 296 135 8135540"); {
							if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 296 136 8135540")|| true) && (log.isDebugEnabled()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 296 29 27 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 296 29 27 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 296 137 8135540"); {
								log.debug("PooledDataSource: Could not get a good connection to the database.");
							} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 296 138 8135540");
							throw new SQLException(
									"PooledDataSource: Could not get a good connection to the database.");
						} }
					} }
				} }
			}

		}}ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 296 142 8135540"); 

		if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 296 143 8135540")|| true) && (conn == null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 296 30 28 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 296 30 28 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 296 144 8135540"); {
			if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 296 145 8135540")|| true) && (log.isDebugEnabled()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 296 31 29 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 296 31 29 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 296 146 8135540"); {
				log.debug("PooledDataSource: Unknown severe error condition.  The connection pool returned a null connection.");
			} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 296 147 8135540");
			throw new SQLException(
					"PooledDataSource: Unknown severe error condition.  The connection pool returned a null connection.");
		} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 296 148 8135540");

		return conn;
	}

	/*
	 * Method to check to see if a connection is still usable
	 * 
	 * @param conn - the connection to check
	 * 
	 * @return True if the connection is still usable
	 */
	protected boolean pingConnection(
			PooledConnection conn) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 296 149 8135540"); 
		boolean result = true;

		try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 296 150 8135540"); 
			result = !conn
					.getRealConnection()
					.isClosed();
		} catch (SQLException e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 296 151 8135540"); 
			if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 296 152 8135540")|| true) && (log.isDebugEnabled()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 296 32 30 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 296 32 30 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 296 153 8135540"); {
				log.debug("Connection "
						+ conn.getRealHashCode()
						+ " is BAD: "
						+ e.getMessage());
			} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 296 154 8135540");
			result = false;
		}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 296 155 8135540");

		if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 296 156 8135540")|| true) && (result? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 296 33 31 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 296 33 31 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 296 157 8135540"); {
			if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 296 158 8135540")|| true) && (poolPingEnabled? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 296 34 32 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 296 34 32 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 296 159 8135540"); {
				int zoa_cond_n160_0 = 2;
int zoa_cond_n160_1 = 2;
//zoa_cond_n160_0#poolPingConnectionsNotUsedFor >= 0$zoa_cond_n160_1#conn.getTimeElapsedSinceLastUse() > poolPingConnectionsNotUsedFor
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 296 160 8135540")|| true) && ((poolPingConnectionsNotUsedFor >= 0?(zoa_cond_n160_0 != (zoa_cond_n160_0 = 1)):(zoa_cond_n160_0 == (zoa_cond_n160_0 = 0)))
						&& (conn.getTimeElapsedSinceLastUse() > poolPingConnectionsNotUsedFor?(zoa_cond_n160_1 != (zoa_cond_n160_1 = 1)):(zoa_cond_n160_1 == (zoa_cond_n160_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 296 37 33 1 2 ","8135540",true,zoa_cond_n160_0,zoa_cond_n160_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 296 37 33 0 2 ","8135540",false,zoa_cond_n160_0,zoa_cond_n160_1) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 296 161 8135540"); {
					try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 296 162 8135540"); 
						if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 296 163 8135540")|| true) && (log.isDebugEnabled()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 296 38 34 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 296 38 34 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 296 164 8135540"); {
							log.debug("Testing connection "
									+ conn.getRealHashCode()
									+ " ...");
						} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 296 165 8135540");
						Connection realConn = conn
								.getRealConnection();
						Statement statement = realConn
								.createStatement();
						ResultSet rs = statement
								.executeQuery(poolPingQuery);
						rs.close();
						statement
								.close();
						if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 296 166 8135540")|| true) && (!realConn
								.getAutoCommit()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 296 39 35 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 296 39 35 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 296 167 8135540"); {
							realConn.rollback();
						} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 296 168 8135540");
						result = true;
						if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 296 169 8135540")|| true) && (log.isDebugEnabled()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 296 40 36 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 296 40 36 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 296 170 8135540"); {
							log.debug("Connection "
									+ conn.getRealHashCode()
									+ " is GOOD!");
						} }
					} catch (Exception e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 296 172 8135540"); 
						log.warn("Execution of ping query '"
								+ poolPingQuery
								+ "' failed: "
								+ e.getMessage());
						try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 296 173 8135540"); 
							conn.getRealConnection()
									.close();
						} catch (Exception e2) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 296 174 8135540"); 
							// ignore
						}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 296 175 8135540");
						result = false;
						if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 296 176 8135540")|| true) && (log.isDebugEnabled()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 296 41 37 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 296 41 37 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 296 177 8135540"); {
							log.debug("Connection "
									+ conn.getRealHashCode()
									+ " is BAD: "
									+ e.getMessage());
						} }
					}
				} }
			} }
		} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 296 182 8135540");
		return result;
	}

	/*
	 * Unwraps a pooled connection to get to the 'real' connection
	 * 
	 * @param conn - the pooled connection to unwrap
	 * 
	 * @return The 'real' connection
	 */
	public static Connection unwrapConnection(
			Connection conn) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 296 183 8135540"); 
		if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 296 184 8135540")|| true) && (Proxy.isProxyClass(conn
				.getClass())? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 296 42 38 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 296 42 38 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 296 185 8135540"); {
			InvocationHandler handler = Proxy
					.getInvocationHandler(conn);
			if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 296 186 8135540")|| true) && (handler instanceof PooledConnection? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 296 43 39 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 296 43 39 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 296 187 8135540"); {
				return ((PooledConnection) handler)
						.getRealConnection();
			} }
		} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 296 189 8135540");
		return conn;
	}

	protected void finalize()
			throws Throwable {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 296 190 8135540"); 
		forceCloseAll();
	}

	public <T> T unwrap(Class<T> iface)
			throws SQLException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 296 191 8135540"); 
		throw new SQLException(
				getClass().getName()
						+ " is not a wrapper.");
	}

	public boolean isWrapperFor(
			Class<?> iface)
			throws SQLException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 296 192 8135540"); 
		return false;
	}

	public Logger getParentLogger() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 296 193 8135540"); 
		return Logger
				.getLogger(Logger.GLOBAL_LOGGER_NAME); // requires JDK version
														// 1.6
	}

}

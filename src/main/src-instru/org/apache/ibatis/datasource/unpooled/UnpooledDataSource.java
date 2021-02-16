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
package org.apache.ibatis.datasource.unpooled;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.DriverPropertyInfo;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.apache.ibatis.io.Resources;

/**
 * @author Clinton Begin
 * @author Eduardo Macarron
 */
import com.process.ZoaExp;
import com.process.ZoaThreadLocal;
public class UnpooledDataSource
		implements DataSource {

	private ClassLoader driverClassLoader;
	private Properties driverProperties;
	private static Map<String, Driver> registeredDrivers = new ConcurrentHashMap<String, Driver>();

	private String driver;
	private String url;
	private String username;
	private String password;

	private Boolean autoCommit;
	private Integer defaultTransactionIsolationLevel;

	static {
		ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 196 0 8135540"); Enumeration<Driver> drivers = DriverManager
				.getDrivers();
		while ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 196 1 8135540")|| true) && (drivers
				.hasMoreElements()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 196 0 0 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 196 0 0 0 0 ","8135540",false,0) && false))){ ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 196 2 8135540");  {
			Driver driver = drivers
					.nextElement();
			registeredDrivers.put(
					driver.getClass()
							.getName(),
					driver);
		}}
	}

	public UnpooledDataSource() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 196 4 8135540"); 
	}

	public UnpooledDataSource(
			String driver, String url,
			String username,
			String password) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 196 5 8135540"); 
		this.driver = driver;
		this.url = url;
		this.username = username;
		this.password = password;
	}

	public UnpooledDataSource(
			String driver, String url,
			Properties driverProperties) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 196 6 8135540"); 
		this.driver = driver;
		this.url = url;
		this.driverProperties = driverProperties;
	}

	public UnpooledDataSource(
			ClassLoader driverClassLoader,
			String driver, String url,
			String username,
			String password) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 196 7 8135540"); 
		this.driverClassLoader = driverClassLoader;
		this.driver = driver;
		this.url = url;
		this.username = username;
		this.password = password;
	}

	public UnpooledDataSource(
			ClassLoader driverClassLoader,
			String driver, String url,
			Properties driverProperties) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 196 8 8135540"); 
		this.driverClassLoader = driverClassLoader;
		this.driver = driver;
		this.url = url;
		this.driverProperties = driverProperties;
	}

	public Connection getConnection()
			throws SQLException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 196 9 8135540"); 
		return doGetConnection(
				username, password);
	}

	public Connection getConnection(
			String username,
			String password)
			throws SQLException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 196 10 8135540"); 
		return doGetConnection(
				username, password);
	}

	public void setLoginTimeout(
			int loginTimeout)
			throws SQLException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 196 11 8135540"); 
		DriverManager
				.setLoginTimeout(loginTimeout);
	}

	public int getLoginTimeout()
			throws SQLException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 196 12 8135540"); 
		return DriverManager
				.getLoginTimeout();
	}

	public void setLogWriter(
			PrintWriter logWriter)
			throws SQLException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 196 13 8135540"); 
		DriverManager
				.setLogWriter(logWriter);
	}

	public PrintWriter getLogWriter()
			throws SQLException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 196 14 8135540"); 
		return DriverManager
				.getLogWriter();
	}

	public ClassLoader getDriverClassLoader() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 196 15 8135540"); 
		return driverClassLoader;
	}

	public void setDriverClassLoader(
			ClassLoader driverClassLoader) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 196 16 8135540"); 
		this.driverClassLoader = driverClassLoader;
	}

	public Properties getDriverProperties() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 196 17 8135540"); 
		return driverProperties;
	}

	public void setDriverProperties(
			Properties driverProperties) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 196 18 8135540"); 
		this.driverProperties = driverProperties;
	}

	public String getDriver() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 196 19 8135540"); 
		return driver;
	}

	public synchronized void setDriver(
			String driver) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 196 20 8135540"); 
		this.driver = driver;
	}

	public String getUrl() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 196 21 8135540"); 
		return url;
	}

	public void setUrl(String url) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 196 22 8135540"); 
		this.url = url;
	}

	public String getUsername() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 196 23 8135540"); 
		return username;
	}

	public void setUsername(
			String username) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 196 24 8135540"); 
		this.username = username;
	}

	public String getPassword() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 196 25 8135540"); 
		return password;
	}

	public void setPassword(
			String password) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 196 26 8135540"); 
		this.password = password;
	}

	public Boolean isAutoCommit() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 196 27 8135540"); 
		return autoCommit;
	}

	public void setAutoCommit(
			Boolean autoCommit) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 196 28 8135540"); 
		this.autoCommit = autoCommit;
	}

	public Integer getDefaultTransactionIsolationLevel() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 196 29 8135540"); 
		return defaultTransactionIsolationLevel;
	}

	public void setDefaultTransactionIsolationLevel(
			Integer defaultTransactionIsolationLevel) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 196 30 8135540"); 
		this.defaultTransactionIsolationLevel = defaultTransactionIsolationLevel;
	}

	private Connection doGetConnection(
			String username,
			String password)
			throws SQLException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 196 31 8135540"); 
		Properties props = new Properties();
		if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 196 32 8135540")|| true) && (driverProperties != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 196 1 1 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 196 1 1 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 196 33 8135540"); {
			props.putAll(driverProperties);
		} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 196 34 8135540");
		if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 196 35 8135540")|| true) && (username != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 196 2 2 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 196 2 2 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 196 36 8135540"); {
			props.setProperty("user",
					username);
		} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 196 37 8135540");
		if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 196 38 8135540")|| true) && (password != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 196 3 3 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 196 3 3 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 196 39 8135540"); {
			props.setProperty(
					"password",
					password);
		} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 196 40 8135540");
		return doGetConnection(props);
	}

	private Connection doGetConnection(
			Properties properties)
			throws SQLException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 196 41 8135540"); 
		initializeDriver();
		Connection connection = DriverManager
				.getConnection(url,
						properties);
		configureConnection(connection);
		return connection;
	}

	private synchronized void initializeDriver()
			throws SQLException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 196 42 8135540"); 
		if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 196 43 8135540")|| true) && (!registeredDrivers
				.containsKey(driver)? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 196 4 4 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 196 4 4 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 196 44 8135540"); {
			Class<?> driverType;
			try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 196 45 8135540"); 
				if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 196 46 8135540")|| true) && (driverClassLoader != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 196 5 5 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 196 5 5 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 196 47 8135540"); {
					driverType = Class
							.forName(
									driver,
									true,
									driverClassLoader);
				} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 196 48 8135540");  {
					driverType = Resources
							.classForName(driver);
				} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 196 49 8135540");
				// DriverManager requires the driver to be loaded via the system
				// ClassLoader.
				// http://www.kfu.com/~nsayer/Java/dyn-jdbc.html
				Driver driverInstance = (Driver) driverType
						.newInstance();
				DriverManager
						.registerDriver(new DriverProxy(
								driverInstance));
				registeredDrivers.put(
						driver,
						driverInstance);
			} catch (Exception e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 196 50 8135540"); 
				throw new SQLException(
						"Error setting driver on UnpooledDataSource. Cause: "
								+ e);
			}
		} }
	}

	private void configureConnection(
			Connection conn)
			throws SQLException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 196 53 8135540"); 
		int zoa_cond_n54_0 = 2;
int zoa_cond_n54_1 = 2;
//zoa_cond_n54_0#autoCommit != null$zoa_cond_n54_1#autoCommit != conn.getAutoCommit()
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 196 54 8135540")|| true) && ((autoCommit != null?(zoa_cond_n54_0 != (zoa_cond_n54_0 = 1)):(zoa_cond_n54_0 == (zoa_cond_n54_0 = 0)))
				&& (autoCommit != conn
						.getAutoCommit()?(zoa_cond_n54_1 != (zoa_cond_n54_1 = 1)):(zoa_cond_n54_1 == (zoa_cond_n54_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 196 8 6 1 2 ","8135540",true,zoa_cond_n54_0,zoa_cond_n54_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 196 8 6 0 2 ","8135540",false,zoa_cond_n54_0,zoa_cond_n54_1) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 196 55 8135540"); {
			conn.setAutoCommit(autoCommit);
		} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 196 56 8135540");
		if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 196 57 8135540")|| true) && (defaultTransactionIsolationLevel != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 196 9 7 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 196 9 7 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 196 58 8135540"); {
			conn.setTransactionIsolation(defaultTransactionIsolationLevel);
		} }
	}

	private static class DriverProxy
			implements Driver {
		private Driver driver;

		DriverProxy(Driver d) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 196 60 8135540"); 
			this.driver = d;
		}

		public boolean acceptsURL(
				String u)
				throws SQLException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 196 61 8135540"); 
			return this.driver
					.acceptsURL(u);
		}

		public Connection connect(
				String u, Properties p)
				throws SQLException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 196 62 8135540"); 
			return this.driver.connect(
					u, p);
		}

		public int getMajorVersion() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 196 63 8135540"); 
			return this.driver
					.getMajorVersion();
		}

		public int getMinorVersion() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 196 64 8135540"); 
			return this.driver
					.getMinorVersion();
		}

		public DriverPropertyInfo[] getPropertyInfo(
				String u, Properties p)
				throws SQLException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 196 65 8135540"); 
			return this.driver
					.getPropertyInfo(u,
							p);
		}

		public boolean jdbcCompliant() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 196 66 8135540"); 
			return this.driver
					.jdbcCompliant();
		}

		public Logger getParentLogger() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 196 67 8135540"); 
			return Logger
					.getLogger(Logger.GLOBAL_LOGGER_NAME);
		}
	}

	public <T> T unwrap(Class<T> iface)
			throws SQLException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 196 68 8135540"); 
		throw new SQLException(
				getClass().getName()
						+ " is not a wrapper.");
	}

	public boolean isWrapperFor(
			Class<?> iface)
			throws SQLException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 196 69 8135540"); 
		return false;
	}

	public Logger getParentLogger() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 196 70 8135540"); 
		return Logger
				.getLogger(Logger.GLOBAL_LOGGER_NAME); // requires JDK version
														// 1.6
	}

}

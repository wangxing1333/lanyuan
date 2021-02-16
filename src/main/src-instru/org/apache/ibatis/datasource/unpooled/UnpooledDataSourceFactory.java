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

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.datasource.DataSourceException;
import org.apache.ibatis.datasource.DataSourceFactory;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;

/**
 * @author Clinton Begin
 */
import com.process.ZoaExp;
import com.process.ZoaThreadLocal;
public class UnpooledDataSourceFactory
		implements DataSourceFactory {

	private static final String DRIVER_PROPERTY_PREFIX = "driver.";
	private static final int DRIVER_PROPERTY_PREFIX_LENGTH = DRIVER_PROPERTY_PREFIX
			.length();

	protected DataSource dataSource;

	public UnpooledDataSourceFactory() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 249 0 8135540"); 
		this.dataSource = new UnpooledDataSource();
	}

	public void setProperties(
			Properties properties) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 249 1 8135540"); 
		Properties driverProperties = new Properties();
		MetaObject metaDataSource = SystemMetaObject
				.forObject(dataSource);
		for (Object key : /* TRUE */properties
				.keySet()){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 249 2 8135540");ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 249 3 8135540"); {
			String propertyName = (String) key;
			if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 249 4 8135540")|| true) && (propertyName
					.startsWith(DRIVER_PROPERTY_PREFIX)? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 249 0 0 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 249 0 0 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 249 5 8135540"); {
				String value = properties
						.getProperty(propertyName);
				driverProperties
						.setProperty(
								propertyName
										.substring(DRIVER_PROPERTY_PREFIX_LENGTH),
								value);
			} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 249 6 8135540");  if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 249 7 8135540")|| true) && (metaDataSource
					.hasSetter(propertyName)? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 249 1 1 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 249 1 1 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 249 8 8135540"); {
				String value = (String) properties
						.get(propertyName);
				Object convertedValue = convertValue(
						metaDataSource,
						propertyName,
						value);
				metaDataSource
						.setValue(
								propertyName,
								convertedValue);
			} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 249 9 8135540");  {
				throw new DataSourceException(
						"Unknown DataSource property: "
								+ propertyName);
			} } }
		}}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 249 12 8135540");
		if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 249 13 8135540")|| true) && (driverProperties.size() > 0? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 249 2 2 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 249 2 2 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 249 14 8135540"); {
			metaDataSource.setValue(
					"driverProperties",
					driverProperties);
		} }
	}

	public DataSource getDataSource() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 249 16 8135540"); 
		return dataSource;
	}

	private Object convertValue(
			MetaObject metaDataSource,
			String propertyName,
			String value) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 249 17 8135540"); 
		Object convertedValue = value;
		Class<?> targetType = metaDataSource
				.getSetterType(propertyName);
		int zoa_cond_n18_0 = 2;
int zoa_cond_n18_1 = 2;
//zoa_cond_n18_0#targetType == Integer.class$zoa_cond_n18_1#targetType == int.class
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 249 18 8135540")|| true) && ((targetType == Integer.class?(zoa_cond_n18_0 != (zoa_cond_n18_0 = 1)):(zoa_cond_n18_0 == (zoa_cond_n18_0 = 0)))
				|| (targetType == int.class?(zoa_cond_n18_1 != (zoa_cond_n18_1 = 1)):(zoa_cond_n18_1 == (zoa_cond_n18_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 249 5 3 1 2 ","8135540",true,zoa_cond_n18_0,zoa_cond_n18_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 249 5 3 0 2 ","8135540",false,zoa_cond_n18_0,zoa_cond_n18_1) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 249 19 8135540"); {
			convertedValue = Integer
					.valueOf(value);
		} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 249 20 8135540");  int zoa_cond_n21_0 = 2;
int zoa_cond_n21_1 = 2;
//zoa_cond_n21_0#targetType == Long.class$zoa_cond_n21_1#targetType == long.class
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 249 21 8135540")|| true) && ((targetType == Long.class?(zoa_cond_n21_0 != (zoa_cond_n21_0 = 1)):(zoa_cond_n21_0 == (zoa_cond_n21_0 = 0)))
				|| (targetType == long.class?(zoa_cond_n21_1 != (zoa_cond_n21_1 = 1)):(zoa_cond_n21_1 == (zoa_cond_n21_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 249 8 4 1 2 ","8135540",true,zoa_cond_n21_0,zoa_cond_n21_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 249 8 4 0 2 ","8135540",false,zoa_cond_n21_0,zoa_cond_n21_1) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 249 22 8135540"); {
			convertedValue = Long
					.valueOf(value);
		} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 249 23 8135540");  int zoa_cond_n24_0 = 2;
int zoa_cond_n24_1 = 2;
//zoa_cond_n24_0#targetType == Boolean.class$zoa_cond_n24_1#targetType == boolean.class
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 249 24 8135540")|| true) && ((targetType == Boolean.class?(zoa_cond_n24_0 != (zoa_cond_n24_0 = 1)):(zoa_cond_n24_0 == (zoa_cond_n24_0 = 0)))
				|| (targetType == boolean.class?(zoa_cond_n24_1 != (zoa_cond_n24_1 = 1)):(zoa_cond_n24_1 == (zoa_cond_n24_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 249 11 5 1 2 ","8135540",true,zoa_cond_n24_0,zoa_cond_n24_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 249 11 5 0 2 ","8135540",false,zoa_cond_n24_0,zoa_cond_n24_1) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 249 25 8135540"); {
			convertedValue = Boolean
					.valueOf(value);
		} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 249 26 8135540"); }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 249 27 8135540"); }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 249 28 8135540");
		return convertedValue;
	}

}

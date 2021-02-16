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
package org.apache.ibatis.executor.resultset;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.ResultMap;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.ObjectTypeHandler;
import org.apache.ibatis.type.TypeHandler;
import org.apache.ibatis.type.TypeHandlerRegistry;
import org.apache.ibatis.type.UnknownTypeHandler;

/**
 * @author Iwao AVE!
 */
import com.process.ZoaExp;
import com.process.ZoaThreadLocal;
class ResultSetWrapper {

  private final ResultSet resultSet;
  private final TypeHandlerRegistry typeHandlerRegistry;
  private final List<String> columnNames = new ArrayList<String>();
  private final List<String> classNames = new ArrayList<String>();
  private final List<JdbcType> jdbcTypes = new ArrayList<JdbcType>();
  private final Map<String, Map<Class<?>, TypeHandler<?>>> typeHandlerMap = new HashMap<String, Map<Class<?>, TypeHandler<?>>>();
  private Map<String, List<String>> mappedColumnNamesMap = new HashMap<String, List<String>>();
  private Map<String, List<String>> unMappedColumnNamesMap = new HashMap<String, List<String>>();

  public ResultSetWrapper(ResultSet rs, Configuration configuration) throws SQLException {
    super();
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 224 0 8135540"); 
    this.typeHandlerRegistry = configuration.getTypeHandlerRegistry();
    this.resultSet = rs;
    final ResultSetMetaData metaData = rs.getMetaData();
    final int columnCount = metaData.getColumnCount();
    for (int i = 1; (ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 224 1 8135540")|| true) && (i <= columnCount? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 224 0 0 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 224 0 0 0 0 ","8135540",false,0) && false)); i++){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 224 2 8135540"); {
      columnNames.add(configuration.isUseColumnLabel() ? metaData.getColumnLabel(i) : metaData.getColumnName(i));
      jdbcTypes.add(JdbcType.forCode(metaData.getColumnType(i)));
      classNames.add(metaData.getColumnClassName(i));
    }}
  }

  public ResultSet getResultSet() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 224 4 8135540"); 
    return resultSet;
  }

  public List<String> getColumnNames() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 224 5 8135540"); 
    return this.columnNames;
  }

  /**
   * Gets the type handler to use when reading the result set.
   * Tries to get from the TypeHandlerRegistry by searching for the property type.
   * If not found it gets the column JDBC type and tries to get a handler for it.
   * 
   * @param propertyType
   * @param columnName
   * @return
   */
  public TypeHandler<?> getTypeHandler(Class<?> propertyType, String columnName) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 224 6 8135540"); 
    TypeHandler<?> handler = null;
    Map<Class<?>, TypeHandler<?>> columnHandlers = typeHandlerMap.get(columnName);
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 224 7 8135540")|| true) && (columnHandlers == null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 224 1 1 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 224 1 1 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 224 8 8135540"); {
      columnHandlers = new HashMap<Class<?>, TypeHandler<?>>();
      typeHandlerMap.put(columnName, columnHandlers);
    } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 224 9 8135540");  {
      handler = columnHandlers.get(propertyType);
    } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 224 10 8135540");
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 224 11 8135540")|| true) && (handler == null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 224 2 2 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 224 2 2 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 224 12 8135540"); {
      handler = typeHandlerRegistry.getTypeHandler(propertyType);
      // Replicate logic of UnknownTypeHandler#resolveTypeHandler
      // See issue #59 comment 10
      int zoa_cond_n13_0 = 2;
int zoa_cond_n13_1 = 2;
//zoa_cond_n13_0#handler == null$zoa_cond_n13_1#handler instanceof UnknownTypeHandler
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 224 13 8135540")|| true) && ((handler == null?(zoa_cond_n13_0 != (zoa_cond_n13_0 = 1)):(zoa_cond_n13_0 == (zoa_cond_n13_0 = 0))) || (handler instanceof UnknownTypeHandler?(zoa_cond_n13_1 != (zoa_cond_n13_1 = 1)):(zoa_cond_n13_1 == (zoa_cond_n13_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 224 5 3 1 2 ","8135540",true,zoa_cond_n13_0,zoa_cond_n13_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 224 5 3 0 2 ","8135540",false,zoa_cond_n13_0,zoa_cond_n13_1) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 224 14 8135540"); {
        final int index = columnNames.indexOf(columnName);
        final JdbcType jdbcType = jdbcTypes.get(index);
        final Class<?> javaType = resolveClass(classNames.get(index));
        int zoa_cond_n15_0 = 2;
int zoa_cond_n15_1 = 2;
//zoa_cond_n15_0#javaType != null$zoa_cond_n15_1#jdbcType != null
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 224 15 8135540")|| true) && ((javaType != null?(zoa_cond_n15_0 != (zoa_cond_n15_0 = 1)):(zoa_cond_n15_0 == (zoa_cond_n15_0 = 0))) && (jdbcType != null?(zoa_cond_n15_1 != (zoa_cond_n15_1 = 1)):(zoa_cond_n15_1 == (zoa_cond_n15_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 224 8 4 1 2 ","8135540",true,zoa_cond_n15_0,zoa_cond_n15_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 224 8 4 0 2 ","8135540",false,zoa_cond_n15_0,zoa_cond_n15_1) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 224 16 8135540"); {
          handler = typeHandlerRegistry.getTypeHandler(javaType, jdbcType);
        } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 224 17 8135540");  if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 224 18 8135540")|| true) && (javaType != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 224 9 5 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 224 9 5 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 224 19 8135540"); {
          handler = typeHandlerRegistry.getTypeHandler(javaType);
        } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 224 20 8135540");  if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 224 21 8135540")|| true) && (jdbcType != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 224 10 6 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 224 10 6 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 224 22 8135540"); {
          handler = typeHandlerRegistry.getTypeHandler(jdbcType);
        } } } }
      } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 224 26 8135540");
      int zoa_cond_n27_0 = 2;
int zoa_cond_n27_1 = 2;
//zoa_cond_n27_0#handler == null$zoa_cond_n27_1#handler instanceof UnknownTypeHandler
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 224 27 8135540")|| true) && ((handler == null?(zoa_cond_n27_0 != (zoa_cond_n27_0 = 1)):(zoa_cond_n27_0 == (zoa_cond_n27_0 = 0))) || (handler instanceof UnknownTypeHandler?(zoa_cond_n27_1 != (zoa_cond_n27_1 = 1)):(zoa_cond_n27_1 == (zoa_cond_n27_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 224 13 7 1 2 ","8135540",true,zoa_cond_n27_0,zoa_cond_n27_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 224 13 7 0 2 ","8135540",false,zoa_cond_n27_0,zoa_cond_n27_1) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 224 28 8135540"); {
        handler = new ObjectTypeHandler();
      } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 224 29 8135540");
      columnHandlers.put(propertyType, handler);
    } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 224 30 8135540");
    return handler;
  }

  private Class<?> resolveClass(String className) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 224 31 8135540"); 
    try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 224 32 8135540"); 
      final Class<?> clazz = Resources.classForName(className);
      return clazz;
    } catch (ClassNotFoundException e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 224 33 8135540"); 
      return null;
    }
  }

  private void loadMappedAndUnmappedColumnNames(ResultMap resultMap, String columnPrefix) throws SQLException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 224 35 8135540"); 
    List<String> mappedColumnNames = new ArrayList<String>();
    List<String> unmappedColumnNames = new ArrayList<String>();
    final String upperColumnPrefix = columnPrefix == null ? null : columnPrefix.toUpperCase(Locale.ENGLISH);
    final Set<String> mappedColumns = prependPrefixes(resultMap.getMappedColumns(), upperColumnPrefix);
    for (String columnName : /* TRUE */columnNames){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 224 36 8135540");ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 224 37 8135540"); {
      final String upperColumnName = columnName.toUpperCase(Locale.ENGLISH);
      if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 224 38 8135540")|| true) && (mappedColumns.contains(upperColumnName)? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 224 14 8 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 224 14 8 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 224 39 8135540"); {
        mappedColumnNames.add(upperColumnName);
      } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 224 40 8135540");  {
        unmappedColumnNames.add(columnName);
      } }
    }}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 224 42 8135540");
    mappedColumnNamesMap.put(getMapKey(resultMap, columnPrefix), mappedColumnNames);
    unMappedColumnNamesMap.put(getMapKey(resultMap, columnPrefix), unmappedColumnNames);
  }

  public List<String> getMappedColumnNames(ResultMap resultMap, String columnPrefix) throws SQLException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 224 43 8135540"); 
    List<String> mappedColumnNames = mappedColumnNamesMap.get(getMapKey(resultMap, columnPrefix));
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 224 44 8135540")|| true) && (mappedColumnNames == null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 224 15 9 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 224 15 9 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 224 45 8135540"); {
      loadMappedAndUnmappedColumnNames(resultMap, columnPrefix);
      mappedColumnNames = mappedColumnNamesMap.get(getMapKey(resultMap, columnPrefix));
    } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 224 46 8135540");
    return mappedColumnNames;
  }

  public List<String> getUnmappedColumnNames(ResultMap resultMap, String columnPrefix) throws SQLException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 224 47 8135540"); 
    List<String> unMappedColumnNames = unMappedColumnNamesMap.get(getMapKey(resultMap, columnPrefix));
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 224 48 8135540")|| true) && (unMappedColumnNames == null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 224 16 10 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 224 16 10 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 224 49 8135540"); {
      loadMappedAndUnmappedColumnNames(resultMap, columnPrefix);
      unMappedColumnNames = unMappedColumnNamesMap.get(getMapKey(resultMap, columnPrefix));
    } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 224 50 8135540");
    return unMappedColumnNames;
  }

  private String getMapKey(ResultMap resultMap, String columnPrefix) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 224 51 8135540"); 
    return resultMap.getId() + ":" + columnPrefix;
  }

  private Set<String> prependPrefixes(Set<String> columnNames, String prefix) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 224 52 8135540"); 
    int zoa_cond_n53_0 = 2;
int zoa_cond_n53_1 = 2;
int zoa_cond_n53_2 = 2;
int zoa_cond_n53_3 = 2;
//zoa_cond_n53_0#columnNames == null$zoa_cond_n53_1#columnNames.isEmpty()$zoa_cond_n53_2#prefix == null$zoa_cond_n53_3#prefix.length() == 0
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 224 53 8135540")|| true) && ((columnNames == null?(zoa_cond_n53_0 != (zoa_cond_n53_0 = 1)):(zoa_cond_n53_0 == (zoa_cond_n53_0 = 0))) || (columnNames.isEmpty()?(zoa_cond_n53_1 != (zoa_cond_n53_1 = 1)):(zoa_cond_n53_1 == (zoa_cond_n53_1 = 0))) || (prefix == null?(zoa_cond_n53_2 != (zoa_cond_n53_2 = 1)):(zoa_cond_n53_2 == (zoa_cond_n53_2 = 0))) || (prefix.length() == 0?(zoa_cond_n53_3 != (zoa_cond_n53_3 = 1)):(zoa_cond_n53_3 == (zoa_cond_n53_3 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 224 21 11 1 4 ","8135540",true,zoa_cond_n53_0,zoa_cond_n53_1,zoa_cond_n53_2,zoa_cond_n53_3) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 224 21 11 0 4 ","8135540",false,zoa_cond_n53_0,zoa_cond_n53_1,zoa_cond_n53_2,zoa_cond_n53_3) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 224 54 8135540"); {
      return columnNames;
    } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 224 55 8135540");
    final Set<String> prefixed = new HashSet<String>();
    for (String columnName : /* TRUE */columnNames){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 224 56 8135540");ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 224 57 8135540"); {
      prefixed.add(prefix + columnName);
    }}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 224 58 8135540");
    return prefixed;
  }
  
}

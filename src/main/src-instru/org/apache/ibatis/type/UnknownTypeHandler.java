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
package org.apache.ibatis.type;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.io.Resources;

/**
 * @author Clinton Begin
 */
import com.process.ZoaExp;
import com.process.ZoaThreadLocal;
public class UnknownTypeHandler extends BaseTypeHandler<Object> {

  private static final ObjectTypeHandler OBJECT_TYPE_HANDLER = new ObjectTypeHandler();

  private TypeHandlerRegistry typeHandlerRegistry;

  public UnknownTypeHandler(TypeHandlerRegistry typeHandlerRegistry) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 174 0 8135540"); 
    this.typeHandlerRegistry = typeHandlerRegistry;
  }

  @Override
  public void setNonNullParameter(PreparedStatement ps, int i, Object parameter, JdbcType jdbcType)
      throws SQLException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 174 1 8135540"); 
    TypeHandler handler = resolveTypeHandler(parameter, jdbcType);
    handler.setParameter(ps, i, parameter, jdbcType);
  }

  @Override
  public Object getNullableResult(ResultSet rs, String columnName)
      throws SQLException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 174 2 8135540"); 
    TypeHandler<?> handler = resolveTypeHandler(rs, columnName);
    return handler.getResult(rs, columnName);
  }

  @Override
  public Object getNullableResult(ResultSet rs, int columnIndex)
      throws SQLException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 174 3 8135540"); 
    TypeHandler<?> handler = resolveTypeHandler(rs.getMetaData(), columnIndex);
    int zoa_cond_n4_0 = 2;
int zoa_cond_n4_1 = 2;
//zoa_cond_n4_0#handler == null$zoa_cond_n4_1#handler instanceof UnknownTypeHandler
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 174 4 8135540")|| true) && ((handler == null?(zoa_cond_n4_0 != (zoa_cond_n4_0 = 1)):(zoa_cond_n4_0 == (zoa_cond_n4_0 = 0))) || (handler instanceof UnknownTypeHandler?(zoa_cond_n4_1 != (zoa_cond_n4_1 = 1)):(zoa_cond_n4_1 == (zoa_cond_n4_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 174 2 0 1 2 ","8135540",true,zoa_cond_n4_0,zoa_cond_n4_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 174 2 0 0 2 ","8135540",false,zoa_cond_n4_0,zoa_cond_n4_1) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 174 5 8135540"); {
      handler = OBJECT_TYPE_HANDLER;
    } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 174 6 8135540");
    return handler.getResult(rs, columnIndex);
  }

  @Override
  public Object getNullableResult(CallableStatement cs, int columnIndex)
      throws SQLException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 174 7 8135540"); 
    return cs.getObject(columnIndex);
  }

  private TypeHandler<? extends Object> resolveTypeHandler(Object parameter, JdbcType jdbcType) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 174 8 8135540"); 
    TypeHandler<? extends Object> handler;
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 174 9 8135540")|| true) && (parameter == null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 174 3 1 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 174 3 1 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 174 10 8135540"); {
      handler = OBJECT_TYPE_HANDLER;
    } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 174 11 8135540");  {
      handler = typeHandlerRegistry.getTypeHandler(parameter.getClass(), jdbcType);
      // check if handler is null (issue #270)
      int zoa_cond_n12_0 = 2;
int zoa_cond_n12_1 = 2;
//zoa_cond_n12_0#handler == null$zoa_cond_n12_1#handler instanceof UnknownTypeHandler
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 174 12 8135540")|| true) && ((handler == null?(zoa_cond_n12_0 != (zoa_cond_n12_0 = 1)):(zoa_cond_n12_0 == (zoa_cond_n12_0 = 0))) || (handler instanceof UnknownTypeHandler?(zoa_cond_n12_1 != (zoa_cond_n12_1 = 1)):(zoa_cond_n12_1 == (zoa_cond_n12_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 174 6 2 1 2 ","8135540",true,zoa_cond_n12_0,zoa_cond_n12_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 174 6 2 0 2 ","8135540",false,zoa_cond_n12_0,zoa_cond_n12_1) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 174 13 8135540"); {
        handler = OBJECT_TYPE_HANDLER;
      } }
    } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 174 15 8135540");
    return handler;
  }

  private TypeHandler<?> resolveTypeHandler(ResultSet rs, String column) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 174 16 8135540"); 
    try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 174 17 8135540"); 
      Map<String,Integer> columnIndexLookup;
      columnIndexLookup = new HashMap<String,Integer>();
      ResultSetMetaData rsmd = rs.getMetaData();
      int count = rsmd.getColumnCount();
      for (int i=1; (ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 174 18 8135540")|| true) && (i <= count? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 174 7 3 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 174 7 3 0 0 ","8135540",false,0) && false)); i++){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 174 19 8135540"); {
        String name = rsmd.getColumnName(i);
        columnIndexLookup.put(name,i);
      }}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 174 20 8135540");
      Integer columnIndex = columnIndexLookup.get(column);
      TypeHandler<?> handler = null;
      if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 174 21 8135540")|| true) && (columnIndex != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 174 8 4 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 174 8 4 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 174 22 8135540"); {
        handler = resolveTypeHandler(rsmd, columnIndex);
      } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 174 23 8135540");
      int zoa_cond_n24_0 = 2;
int zoa_cond_n24_1 = 2;
//zoa_cond_n24_0#handler == null$zoa_cond_n24_1#handler instanceof UnknownTypeHandler
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 174 24 8135540")|| true) && ((handler == null?(zoa_cond_n24_0 != (zoa_cond_n24_0 = 1)):(zoa_cond_n24_0 == (zoa_cond_n24_0 = 0))) || (handler instanceof UnknownTypeHandler?(zoa_cond_n24_1 != (zoa_cond_n24_1 = 1)):(zoa_cond_n24_1 == (zoa_cond_n24_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 174 11 5 1 2 ","8135540",true,zoa_cond_n24_0,zoa_cond_n24_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 174 11 5 0 2 ","8135540",false,zoa_cond_n24_0,zoa_cond_n24_1) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 174 25 8135540"); {
        handler = OBJECT_TYPE_HANDLER;
      } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 174 26 8135540");
      return handler;
    } catch (SQLException e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 174 27 8135540"); 
      throw new TypeException("Error determining JDBC type for column " + column + ".  Cause: " + e, e);
    }
  }

  private TypeHandler<?> resolveTypeHandler(ResultSetMetaData rsmd, Integer columnIndex) throws SQLException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 174 29 8135540"); 
    TypeHandler<?> handler = null;
    JdbcType jdbcType = safeGetJdbcTypeForColumn(rsmd, columnIndex);
    Class<?> javaType = safeGetClassForColumn(rsmd, columnIndex);
    int zoa_cond_n30_0 = 2;
int zoa_cond_n30_1 = 2;
//zoa_cond_n30_0#javaType != null$zoa_cond_n30_1#jdbcType != null
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 174 30 8135540")|| true) && ((javaType != null?(zoa_cond_n30_0 != (zoa_cond_n30_0 = 1)):(zoa_cond_n30_0 == (zoa_cond_n30_0 = 0))) && (jdbcType != null?(zoa_cond_n30_1 != (zoa_cond_n30_1 = 1)):(zoa_cond_n30_1 == (zoa_cond_n30_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 174 14 6 1 2 ","8135540",true,zoa_cond_n30_0,zoa_cond_n30_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 174 14 6 0 2 ","8135540",false,zoa_cond_n30_0,zoa_cond_n30_1) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 174 31 8135540"); {
      handler = typeHandlerRegistry.getTypeHandler(javaType, jdbcType);
    } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 174 32 8135540");  if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 174 33 8135540")|| true) && (javaType != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 174 15 7 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 174 15 7 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 174 34 8135540"); {
      handler = typeHandlerRegistry.getTypeHandler(javaType);
    } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 174 35 8135540");  if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 174 36 8135540")|| true) && (jdbcType != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 174 16 8 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 174 16 8 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 174 37 8135540"); {
      handler = typeHandlerRegistry.getTypeHandler(jdbcType);
    } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 174 38 8135540"); }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 174 39 8135540"); }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 174 40 8135540");
    return handler;
  }

  private JdbcType safeGetJdbcTypeForColumn(ResultSetMetaData rsmd, Integer columnIndex) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 174 41 8135540"); 
    try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 174 42 8135540"); 
      return JdbcType.forCode(rsmd.getColumnType(columnIndex));
    } catch (Exception e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 174 43 8135540"); 
      return null;
    }
  }

  private Class<?> safeGetClassForColumn(ResultSetMetaData rsmd, Integer columnIndex) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 174 45 8135540"); 
    try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 174 46 8135540"); 
      return Resources.classForName(rsmd.getColumnClassName(columnIndex));
    } catch (Exception e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 174 47 8135540"); 
      return null;
    }
  }
}

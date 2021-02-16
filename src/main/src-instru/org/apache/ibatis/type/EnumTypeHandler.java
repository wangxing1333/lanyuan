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
import java.sql.SQLException;

/**
 * @author Clinton Begin
 */
import com.process.ZoaExp;
import com.process.ZoaThreadLocal;
public class EnumTypeHandler<E extends Enum<E>> extends BaseTypeHandler<E> {

  private Class<E> type;

  public EnumTypeHandler(Class<E> type) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 220 0 8135540"); 
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 220 1 8135540")|| true) && (type == null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 220 0 0 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 220 0 0 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 220 2 8135540"); throw new IllegalArgumentException("Type argument cannot be null"); }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 220 3 8135540");
    this.type = type;
  }

  @Override
  public void setNonNullParameter(PreparedStatement ps, int i, E parameter, JdbcType jdbcType) throws SQLException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 220 4 8135540"); 
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 220 5 8135540")|| true) && (jdbcType == null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 220 1 1 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 220 1 1 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 220 6 8135540"); {
      ps.setString(i, parameter.name());
    } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 220 7 8135540");  {
      ps.setObject(i, parameter.name(), jdbcType.TYPE_CODE); // see r3589
    } }
  }

  @Override
  public E getNullableResult(ResultSet rs, String columnName) throws SQLException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 220 9 8135540"); 
    String s = rs.getString(columnName);
    return s == null ? null : Enum.valueOf(type, s);
  }

  @Override
  public E getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 220 10 8135540"); 
    String s = rs.getString(columnIndex);
    return s == null ? null : Enum.valueOf(type, s);
  }

  @Override
  public E getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 220 11 8135540"); 
    String s = cs.getString(columnIndex);
    return s == null ? null : Enum.valueOf(type, s);
  }
}
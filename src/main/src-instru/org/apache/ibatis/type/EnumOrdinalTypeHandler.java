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
public class EnumOrdinalTypeHandler<E extends Enum<E>> extends BaseTypeHandler<E> {

  private Class<E> type;
  private final E[] enums;

  public EnumOrdinalTypeHandler(Class<E> type) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 219 0 8135540"); 
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 219 1 8135540")|| true) && (type == null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 219 0 0 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 219 0 0 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 219 2 8135540"); throw new IllegalArgumentException("Type argument cannot be null"); }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 219 3 8135540");
    this.type = type;
    this.enums = type.getEnumConstants();
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 219 4 8135540")|| true) && (this.enums == null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 219 1 1 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 219 1 1 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 219 5 8135540"); throw new IllegalArgumentException(type.getSimpleName() + " does not represent an enum type."); }
  }

  @Override
  public void setNonNullParameter(PreparedStatement ps, int i, E parameter, JdbcType jdbcType) throws SQLException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 219 7 8135540"); 
    ps.setInt(i, parameter.ordinal());
  }

  @Override
  public E getNullableResult(ResultSet rs, String columnName) throws SQLException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 219 8 8135540"); 
    int i = rs.getInt(columnName);
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 219 9 8135540")|| true) && (rs.wasNull()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 219 2 2 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 219 2 2 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 219 10 8135540"); {
      return null;
    } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 219 11 8135540");  {
      try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 219 12 8135540"); 
        return enums[i];
      } catch (Exception ex) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 219 13 8135540"); 
        throw new IllegalArgumentException("Cannot convert " + i + " to " + type.getSimpleName() + " by ordinal value.", ex);
      }
    } }
  }

  @Override
  public E getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 219 16 8135540"); 
    int i = rs.getInt(columnIndex);
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 219 17 8135540")|| true) && (rs.wasNull()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 219 3 3 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 219 3 3 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 219 18 8135540"); {
      return null;
    } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 219 19 8135540");  {
      try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 219 20 8135540"); 
        return enums[i];
      } catch (Exception ex) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 219 21 8135540"); 
        throw new IllegalArgumentException("Cannot convert " + i + " to " + type.getSimpleName() + " by ordinal value.", ex);
      }
    } }
  }

  @Override
  public E getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 219 24 8135540"); 
    int i = cs.getInt(columnIndex);
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 219 25 8135540")|| true) && (cs.wasNull()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 219 4 4 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 219 4 4 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 219 26 8135540"); {
      return null;
    } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 219 27 8135540");  {
      try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 219 28 8135540"); 
        return enums[i];
      } catch (Exception ex) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 219 29 8135540"); 
        throw new IllegalArgumentException("Cannot convert " + i + " to " + type.getSimpleName() + " by ordinal value.", ex);
      }
    } }
  }
  
}

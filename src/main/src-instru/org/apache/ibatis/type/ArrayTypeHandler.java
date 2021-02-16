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

import java.sql.Array;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Clinton Begin
 */
import com.process.ZoaExp;
import com.process.ZoaThreadLocal;
public class ArrayTypeHandler extends BaseTypeHandler<Object> {

  public ArrayTypeHandler() {
    super();
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 235 0 8135540"); 
  }

  @Override
  public void setNonNullParameter(PreparedStatement ps, int i, Object parameter, JdbcType jdbcType) throws SQLException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 235 1 8135540"); 
    ps.setArray(i, (Array) parameter);
  }

  @Override
  public Object getNullableResult(ResultSet rs, String columnName) throws SQLException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 235 2 8135540"); 
    Array array = rs.getArray(columnName);
    return array == null ? null : array.getArray();
  }

  @Override
  public Object getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 235 3 8135540"); 
    Array array = rs.getArray(columnIndex);
    return array == null ? null : array.getArray();
  }

  @Override
  public Object getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 235 4 8135540"); 
    Array array = cs.getArray(columnIndex);
    return array == null ? null : array.getArray();
  }

}

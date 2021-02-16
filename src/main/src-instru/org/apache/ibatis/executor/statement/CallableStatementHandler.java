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
package org.apache.ibatis.executor.statement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.ExecutorException;
import org.apache.ibatis.executor.keygen.KeyGenerator;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.mapping.ParameterMode;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.type.JdbcType;

/**
 * @author Clinton Begin
 */
import com.process.ZoaExp;
import com.process.ZoaThreadLocal;
public class CallableStatementHandler extends BaseStatementHandler {

  public CallableStatementHandler(Executor executor, MappedStatement mappedStatement, Object parameter, RowBounds rowBounds, ResultHandler resultHandler, BoundSql boundSql) {
    super(executor, mappedStatement, parameter, rowBounds, resultHandler, boundSql);
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 180 0 8135540"); 
  }

  public int update(Statement statement)
      throws SQLException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 180 1 8135540"); 
    CallableStatement cs = (CallableStatement) statement;
    cs.execute();
    int rows = cs.getUpdateCount();
    Object parameterObject = boundSql.getParameterObject();
    KeyGenerator keyGenerator = mappedStatement.getKeyGenerator();
    keyGenerator.processAfter(executor, mappedStatement, cs, parameterObject);
    resultSetHandler.handleOutputParameters(cs);
    return rows;
  }

  public void batch(Statement statement)
      throws SQLException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 180 2 8135540"); 
    CallableStatement cs = (CallableStatement) statement;
    cs.addBatch();
  }

  public <E> List<E> query(Statement statement, ResultHandler resultHandler)
      throws SQLException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 180 3 8135540"); 
    CallableStatement cs = (CallableStatement) statement;
    cs.execute();
    List<E> resultList = resultSetHandler.<E>handleResultSets(cs);
    resultSetHandler.handleOutputParameters(cs);
    return resultList;
  }

  protected Statement instantiateStatement(Connection connection) throws SQLException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 180 4 8135540"); 
    String sql = boundSql.getSql();
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 180 5 8135540")|| true) && (mappedStatement.getResultSetType() != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 180 0 0 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 180 0 0 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 180 6 8135540"); {
      return connection.prepareCall(sql, mappedStatement.getResultSetType().getValue(), ResultSet.CONCUR_READ_ONLY);
    } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 180 7 8135540");  {
      return connection.prepareCall(sql);
    } }
  }

  public void parameterize(Statement statement) throws SQLException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 180 9 8135540"); 
    registerOutputParameters((CallableStatement) statement);
    parameterHandler.setParameters((CallableStatement) statement);
  }

  private void registerOutputParameters(CallableStatement cs) throws SQLException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 180 10 8135540"); 
    List<ParameterMapping> parameterMappings = boundSql.getParameterMappings();
    for (int i = 0, n = parameterMappings.size(); (ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 180 11 8135540")|| true) && (i < n? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 180 1 1 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 180 1 1 0 0 ","8135540",false,0) && false)); i++){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 180 12 8135540"); {
      ParameterMapping parameterMapping = parameterMappings.get(i);
      int zoa_cond_n13_0 = 2;
int zoa_cond_n13_1 = 2;
//zoa_cond_n13_0#parameterMapping.getMode() == ParameterMode.OUT$zoa_cond_n13_1#parameterMapping.getMode() == ParameterMode.INOUT
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 180 13 8135540")|| true) && ((parameterMapping.getMode() == ParameterMode.OUT?(zoa_cond_n13_0 != (zoa_cond_n13_0 = 1)):(zoa_cond_n13_0 == (zoa_cond_n13_0 = 0))) || (parameterMapping.getMode() == ParameterMode.INOUT?(zoa_cond_n13_1 != (zoa_cond_n13_1 = 1)):(zoa_cond_n13_1 == (zoa_cond_n13_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 180 4 2 1 2 ","8135540",true,zoa_cond_n13_0,zoa_cond_n13_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 180 4 2 0 2 ","8135540",false,zoa_cond_n13_0,zoa_cond_n13_1) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 180 14 8135540"); {
        if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 180 15 8135540")|| true) && (null == parameterMapping.getJdbcType()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 180 5 3 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 180 5 3 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 180 16 8135540"); {
          throw new ExecutorException("The JDBC Type must be specified for output parameter.  Parameter: " + parameterMapping.getProperty());
        } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 180 17 8135540");  {
          int zoa_cond_n18_0 = 2;
int zoa_cond_n18_1 = 2;
int zoa_cond_n18_2 = 2;
int zoa_cond_n18_3 = 6;
//zoa_cond_n18_0#parameterMapping.getNumericScale() != null$zoa_cond_n18_1#parameterMapping.getJdbcType() == JdbcType.NUMERIC$zoa_cond_n18_2#parameterMapping.getJdbcType() == JdbcType.DECIMAL$zoa_cond_n18_3#parameterMapping.getJdbcType() == JdbcType.NUMERIC || parameterMapping.getJdbcType() == JdbcType.DECIMAL
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 180 18 8135540")|| true) && ((parameterMapping.getNumericScale() != null?(zoa_cond_n18_0 != (zoa_cond_n18_0 = 1)):(zoa_cond_n18_0 == (zoa_cond_n18_0 = 0))) && ((parameterMapping.getJdbcType() == JdbcType.NUMERIC?(zoa_cond_n18_1 != (zoa_cond_n18_1 = 1)):(zoa_cond_n18_1 == (zoa_cond_n18_1 = 0))) || (parameterMapping.getJdbcType() == JdbcType.DECIMAL?(zoa_cond_n18_2 != (zoa_cond_n18_2 = 1)):(zoa_cond_n18_2 == (zoa_cond_n18_2 = 0)))?(zoa_cond_n18_3 != (zoa_cond_n18_3 = 5)):(zoa_cond_n18_3 == (zoa_cond_n18_3 = 4)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 180 10 4 1 4 ","8135540",true,zoa_cond_n18_0,zoa_cond_n18_1,zoa_cond_n18_2,zoa_cond_n18_3) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 180 10 4 0 4 ","8135540",false,zoa_cond_n18_0,zoa_cond_n18_1,zoa_cond_n18_2,zoa_cond_n18_3) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 180 19 8135540"); {
            cs.registerOutParameter(i + 1, parameterMapping.getJdbcType().TYPE_CODE, parameterMapping.getNumericScale());
          } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 180 20 8135540");  {
            if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 180 21 8135540")|| true) && (parameterMapping.getJdbcTypeName() == null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 180 11 5 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 180 11 5 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 180 22 8135540"); {
              cs.registerOutParameter(i + 1, parameterMapping.getJdbcType().TYPE_CODE);
            } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 180 23 8135540");  {
              cs.registerOutParameter(i + 1, parameterMapping.getJdbcType().TYPE_CODE, parameterMapping.getJdbcTypeName());
            } }
          } }
        } }
      } }
    }}
  }

}

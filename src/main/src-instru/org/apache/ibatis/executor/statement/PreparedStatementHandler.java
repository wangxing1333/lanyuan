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

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.keygen.Jdbc3KeyGenerator;
import org.apache.ibatis.executor.keygen.KeyGenerator;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

/**
 * @author Clinton Begin
 */
import com.process.ZoaExp;
import com.process.ZoaThreadLocal;
public class PreparedStatementHandler extends BaseStatementHandler {

  public PreparedStatementHandler(Executor executor, MappedStatement mappedStatement, Object parameter, RowBounds rowBounds, ResultHandler resultHandler, BoundSql boundSql) {
    super(executor, mappedStatement, parameter, rowBounds, resultHandler, boundSql);
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 248 0 8135540"); 
  }

  public int update(Statement statement) throws SQLException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 248 1 8135540"); 
    PreparedStatement ps = (PreparedStatement) statement;
    ps.execute();
    int rows = ps.getUpdateCount();
    Object parameterObject = boundSql.getParameterObject();
    KeyGenerator keyGenerator = mappedStatement.getKeyGenerator();
    keyGenerator.processAfter(executor, mappedStatement, ps, parameterObject);
    return rows;
  }

  public void batch(Statement statement) throws SQLException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 248 2 8135540"); 
    PreparedStatement ps = (PreparedStatement) statement;
    ps.addBatch();
  }

  public <E> List<E> query(Statement statement, ResultHandler resultHandler) throws SQLException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 248 3 8135540"); 
    PreparedStatement ps = (PreparedStatement) statement;
    ps.execute();
    return resultSetHandler.<E> handleResultSets(ps);
  }

  protected Statement instantiateStatement(Connection connection) throws SQLException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 248 4 8135540"); 
    String sql = boundSql.getSql();
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 248 5 8135540")|| true) && (mappedStatement.getKeyGenerator() instanceof Jdbc3KeyGenerator? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 248 0 0 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 248 0 0 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 248 6 8135540"); {
      String[] keyColumnNames = mappedStatement.getKeyColumns();
      if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 248 7 8135540")|| true) && (keyColumnNames == null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 248 1 1 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 248 1 1 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 248 8 8135540"); {
        return connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
      } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 248 9 8135540");  {
        return connection.prepareStatement(sql, keyColumnNames);
      } }
    } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 248 11 8135540");  if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 248 12 8135540")|| true) && (mappedStatement.getResultSetType() != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 248 2 2 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 248 2 2 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 248 13 8135540"); {
      return connection.prepareStatement(sql, mappedStatement.getResultSetType().getValue(), ResultSet.CONCUR_READ_ONLY);
    } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 248 14 8135540");  {
      return connection.prepareStatement(sql);
    } } }
  }

  public void parameterize(Statement statement) throws SQLException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 248 17 8135540"); 
    parameterHandler.setParameters((PreparedStatement) statement);
  }

}

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
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.ExecutorException;
import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

/**
 * @author Clinton Begin
 */
import com.process.ZoaExp;
import com.process.ZoaThreadLocal;
public class RoutingStatementHandler implements StatementHandler {

  private final StatementHandler delegate;

  public RoutingStatementHandler(Executor executor, MappedStatement ms, Object parameter, RowBounds rowBounds, ResultHandler resultHandler, BoundSql boundSql) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 179 0 8135540"); 

     ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 179 1 8135540");switch (ms.getStatementType()) {
      case STATEMENT:
 ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 179 3 8135540");
        delegate = new SimpleStatementHandler(executor, ms, parameter, rowBounds, resultHandler, boundSql);
        break;
      case PREPARED:
 ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 179 5 8135540");
        delegate = new PreparedStatementHandler(executor, ms, parameter, rowBounds, resultHandler, boundSql);
        break;
      case CALLABLE:
 ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 179 7 8135540");
        delegate = new CallableStatementHandler(executor, ms, parameter, rowBounds, resultHandler, boundSql);
        break;
      default:
 ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 179 9 8135540");
        throw new ExecutorException("Unknown statement type: " + ms.getStatementType());
    }

  }

  public Statement prepare(Connection connection) throws SQLException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 179 11 8135540"); 
    return delegate.prepare(connection);
  }

  public void parameterize(Statement statement) throws SQLException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 179 12 8135540"); 
    delegate.parameterize(statement);
  }

  public void batch(Statement statement) throws SQLException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 179 13 8135540"); 
    delegate.batch(statement);
  }

  public int update(Statement statement) throws SQLException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 179 14 8135540"); 
    return delegate.update(statement);
  }

  public <E> List<E> query(Statement statement, ResultHandler resultHandler) throws SQLException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 179 15 8135540"); 
    return delegate.<E>query(statement, resultHandler);
  }

  public BoundSql getBoundSql() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 179 16 8135540"); 
    return delegate.getBoundSql();
  }

  public ParameterHandler getParameterHandler() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 179 17 8135540"); 
    return delegate.getParameterHandler();
  }
}

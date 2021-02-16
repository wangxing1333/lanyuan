// ZOA_CREATED! DO NOT EDIT IT! -- 
/*
 *    Copyright 2009-2014 the original author or authors.
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
package org.apache.ibatis.session.defaults;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.binding.BindingException;
import org.apache.ibatis.exceptions.ExceptionFactory;
import org.apache.ibatis.exceptions.TooManyResultsException;
import org.apache.ibatis.executor.BatchResult;
import org.apache.ibatis.executor.ErrorContext;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.result.DefaultMapResultHandler;
import org.apache.ibatis.executor.result.DefaultResultContext;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

/**
 * @author Clinton Begin
 */
import com.process.ZoaExp;
import com.process.ZoaThreadLocal;
public class DefaultSqlSession implements SqlSession {

  private Configuration configuration;
  private Executor executor;

  private boolean autoCommit;
  private boolean dirty;
  
  public DefaultSqlSession(Configuration configuration, Executor executor, boolean autoCommit) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 226 0 8135540"); 
    this.configuration = configuration;
    this.executor = executor;
    this.dirty = false;
    this.autoCommit = autoCommit;
  }

  public DefaultSqlSession(Configuration configuration, Executor executor) {
    this(configuration, executor, false);
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 226 1 8135540"); 
  }

  public <T> T selectOne(String statement) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 226 2 8135540"); 
    return this.<T>selectOne(statement, null);
  }

  public <T> T selectOne(String statement, Object parameter) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 226 3 8135540"); 
    // Popular vote was to return null on 0 results and throw exception on too many.
    List<T> list = this.<T>selectList(statement, parameter);
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 226 4 8135540")|| true) && (list.size() == 1? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 226 0 0 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 226 0 0 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 226 5 8135540"); {
      return list.get(0);
    } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 226 6 8135540");  if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 226 7 8135540")|| true) && (list.size() > 1? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 226 1 1 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 226 1 1 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 226 8 8135540"); {
      throw new TooManyResultsException("Expected one result (or null) to be returned by selectOne(), but found: " + list.size());
    } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 226 9 8135540");  {
      return null;
    } } }
  }

  public <K, V> Map<K, V> selectMap(String statement, String mapKey) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 226 12 8135540"); 
    return this.selectMap(statement, null, mapKey, RowBounds.DEFAULT);
  }

  public <K, V> Map<K, V> selectMap(String statement, Object parameter, String mapKey) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 226 13 8135540"); 
    return this.selectMap(statement, parameter, mapKey, RowBounds.DEFAULT);
  }

  public <K, V> Map<K, V> selectMap(String statement, Object parameter, String mapKey, RowBounds rowBounds) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 226 14 8135540"); 
    final List<?> list = selectList(statement, parameter, rowBounds);
    final DefaultMapResultHandler<K, V> mapResultHandler = new DefaultMapResultHandler<K, V>(mapKey,
        configuration.getObjectFactory(), configuration.getObjectWrapperFactory());
    final DefaultResultContext context = new DefaultResultContext();
    for (Object o : /* TRUE */list){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 226 15 8135540");ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 226 16 8135540"); {
      context.nextResultObject(o);
      mapResultHandler.handleResult(context);
    }}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 226 17 8135540");
    Map<K, V> selectedMap = mapResultHandler.getMappedResults();
    return selectedMap;
  }

  public <E> List<E> selectList(String statement) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 226 18 8135540"); 
    return this.selectList(statement, null);
  }

  public <E> List<E> selectList(String statement, Object parameter) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 226 19 8135540"); 
    return this.selectList(statement, parameter, RowBounds.DEFAULT);
  }

  public <E> List<E> selectList(String statement, Object parameter, RowBounds rowBounds) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 226 20 8135540"); 
    try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 226 21 8135540"); 
      MappedStatement ms = configuration.getMappedStatement(statement);
      List<E> result = executor.query(ms, wrapCollection(parameter), rowBounds, Executor.NO_RESULT_HANDLER);
      return result;
    } catch (Exception e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 226 22 8135540"); 
      throw ExceptionFactory.wrapException("Error querying database.  Cause: " + e, e);
    } finally {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 226 23 8135540"); 
      ErrorContext.instance().reset();
    }
  }

  public void select(String statement, Object parameter, ResultHandler handler) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 226 25 8135540"); 
    select(statement, parameter, RowBounds.DEFAULT, handler);
  }

  public void select(String statement, ResultHandler handler) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 226 26 8135540"); 
    select(statement, null, RowBounds.DEFAULT, handler);
  }

  public void select(String statement, Object parameter, RowBounds rowBounds, ResultHandler handler) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 226 27 8135540"); 
    try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 226 28 8135540"); 
      MappedStatement ms = configuration.getMappedStatement(statement);
      executor.query(ms, wrapCollection(parameter), rowBounds, handler);
    } catch (Exception e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 226 29 8135540"); 
      throw ExceptionFactory.wrapException("Error querying database.  Cause: " + e, e);
    } finally {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 226 30 8135540"); 
      ErrorContext.instance().reset();
    }
  }

  public int insert(String statement) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 226 32 8135540"); 
    return insert(statement, null);
  }

  public int insert(String statement, Object parameter) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 226 33 8135540"); 
    return update(statement, parameter);
  }

  public int update(String statement) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 226 34 8135540"); 
    return update(statement, null);
  }

  public int update(String statement, Object parameter) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 226 35 8135540"); 
    try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 226 36 8135540"); 
      dirty = true;
      MappedStatement ms = configuration.getMappedStatement(statement);
      return executor.update(ms, wrapCollection(parameter));
    } catch (Exception e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 226 37 8135540"); 
      throw ExceptionFactory.wrapException("Error updating database.  Cause: " + e, e);
    } finally {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 226 38 8135540"); 
      ErrorContext.instance().reset();
    }
  }

  public int delete(String statement) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 226 40 8135540"); 
    return update(statement, null);
  }

  public int delete(String statement, Object parameter) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 226 41 8135540"); 
    return update(statement, parameter);
  }

  public void commit() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 226 42 8135540"); 
    commit(false);
  }

  public void commit(boolean force) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 226 43 8135540"); 
    try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 226 44 8135540"); 
      executor.commit(isCommitOrRollbackRequired(force));
      dirty = false;
    } catch (Exception e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 226 45 8135540"); 
      throw ExceptionFactory.wrapException("Error committing transaction.  Cause: " + e, e);
    } finally {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 226 46 8135540"); 
      ErrorContext.instance().reset();
    }
  }

  public void rollback() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 226 48 8135540"); 
    rollback(false);
  }

  public void rollback(boolean force) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 226 49 8135540"); 
    try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 226 50 8135540"); 
      executor.rollback(isCommitOrRollbackRequired(force));
      dirty = false;
    } catch (Exception e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 226 51 8135540"); 
      throw ExceptionFactory.wrapException("Error rolling back transaction.  Cause: " + e, e);
    } finally {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 226 52 8135540"); 
      ErrorContext.instance().reset();
    }
  }

  public List<BatchResult> flushStatements() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 226 54 8135540"); 
    try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 226 55 8135540"); 
      return executor.flushStatements();
    } catch (Exception e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 226 56 8135540"); 
      throw ExceptionFactory.wrapException("Error flushing statements.  Cause: " + e, e);
    } finally {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 226 57 8135540"); 
      ErrorContext.instance().reset();
    }
  }

  public void close() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 226 59 8135540"); 
    try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 226 60 8135540"); 
      executor.close(isCommitOrRollbackRequired(false));
      dirty = false;
    } finally {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 226 61 8135540"); 
      ErrorContext.instance().reset();
    }
  }

  public Configuration getConfiguration() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 226 63 8135540"); 
    return configuration;
  }

  public <T> T getMapper(Class<T> type) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 226 64 8135540"); 
    return configuration.<T>getMapper(type, this);
  }

  public Connection getConnection() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 226 65 8135540"); 
    try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 226 66 8135540"); 
      return executor.getTransaction().getConnection();
    } catch (SQLException e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 226 67 8135540"); 
      throw ExceptionFactory.wrapException("Error getting a new connection.  Cause: " + e, e);
    }
  }

  public void clearCache() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 226 69 8135540"); 
    executor.clearLocalCache();
  }

  private boolean isCommitOrRollbackRequired(boolean force) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 226 70 8135540"); 
    return (!autoCommit && dirty) || force;
  }

  private Object wrapCollection(final Object object) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 226 71 8135540"); 
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 226 72 8135540")|| true) && (object instanceof List? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 226 2 2 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 226 2 2 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 226 73 8135540"); {
      StrictMap<Object> map = new StrictMap<Object>();
      map.put("list", object);
      return map;
    } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 226 74 8135540");  int zoa_cond_n75_0 = 2;
int zoa_cond_n75_1 = 2;
//zoa_cond_n75_0#object != null$zoa_cond_n75_1#object.getClass().isArray()
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 226 75 8135540")|| true) && ((object != null?(zoa_cond_n75_0 != (zoa_cond_n75_0 = 1)):(zoa_cond_n75_0 == (zoa_cond_n75_0 = 0))) && (object.getClass().isArray()?(zoa_cond_n75_1 != (zoa_cond_n75_1 = 1)):(zoa_cond_n75_1 == (zoa_cond_n75_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 226 5 3 1 2 ","8135540",true,zoa_cond_n75_0,zoa_cond_n75_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 226 5 3 0 2 ","8135540",false,zoa_cond_n75_0,zoa_cond_n75_1) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 226 76 8135540"); {
      StrictMap<Object> map = new StrictMap<Object>();
      map.put("array", object);
      return map;
    } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 226 77 8135540"); }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 226 78 8135540");
    return object;
  }

  public static class StrictMap<V> extends HashMap<String, V> {

    private static final long serialVersionUID = -5741767162221585340L;

    @Override
    public V get(Object key) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 226 79 8135540"); 
      if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 226 80 8135540")|| true) && (!super.containsKey(key)? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 226 6 4 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 226 6 4 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 226 81 8135540"); {
        throw new BindingException("Parameter '" + key + "' not found. Available parameters are " + this.keySet());
      } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 226 82 8135540");
      return super.get(key);
    }

  }

}

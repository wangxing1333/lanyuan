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
package org.apache.ibatis.session;

import java.io.InputStream;
import java.io.Reader;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.ibatis.executor.BatchResult;
import org.apache.ibatis.reflection.ExceptionUtil;

/**
 * @author Larry Meadors
 */
import com.process.ZoaExp;
import com.process.ZoaThreadLocal;
public class SqlSessionManager implements SqlSessionFactory, SqlSession {

  private final SqlSessionFactory sqlSessionFactory;
  private final SqlSession sqlSessionProxy;

  private ThreadLocal<SqlSession> localSqlSession = new ThreadLocal<SqlSession>();

  public static SqlSessionManager newInstance(Reader reader) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 241 0 8135540"); 
    return new SqlSessionManager(new SqlSessionFactoryBuilder().build(reader, null, null));
  }

  public static SqlSessionManager newInstance(Reader reader, String environment) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 241 1 8135540"); 
    return new SqlSessionManager(new SqlSessionFactoryBuilder().build(reader, environment, null));
  }

  public static SqlSessionManager newInstance(Reader reader, Properties properties) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 241 2 8135540"); 
    return new SqlSessionManager(new SqlSessionFactoryBuilder().build(reader, null, properties));
  }

  public static SqlSessionManager newInstance(InputStream inputStream) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 241 3 8135540"); 
    return new SqlSessionManager(new SqlSessionFactoryBuilder().build(inputStream, null, null));
  }

  public static SqlSessionManager newInstance(InputStream inputStream, String environment) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 241 4 8135540"); 
    return new SqlSessionManager(new SqlSessionFactoryBuilder().build(inputStream, environment, null));
  }

  public static SqlSessionManager newInstance(InputStream inputStream, Properties properties) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 241 5 8135540"); 
    return new SqlSessionManager(new SqlSessionFactoryBuilder().build(inputStream, null, properties));
  }

  public static SqlSessionManager newInstance(SqlSessionFactory sqlSessionFactory) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 241 6 8135540"); 
    return new SqlSessionManager(sqlSessionFactory);
  }

  private SqlSessionManager(SqlSessionFactory sqlSessionFactory) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 241 7 8135540"); 
    this.sqlSessionFactory = sqlSessionFactory;
    this.sqlSessionProxy = (SqlSession) Proxy.newProxyInstance(
        SqlSessionFactory.class.getClassLoader(),
        new Class[]{SqlSession.class},
        new SqlSessionInterceptor());
  }

  public void startManagedSession() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 241 8 8135540"); 
    this.localSqlSession.set(openSession());
  }

  public void startManagedSession(boolean autoCommit) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 241 9 8135540"); 
    this.localSqlSession.set(openSession(autoCommit));
  }

  public void startManagedSession(Connection connection) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 241 10 8135540"); 
    this.localSqlSession.set(openSession(connection));
  }

  public void startManagedSession(TransactionIsolationLevel level) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 241 11 8135540"); 
    this.localSqlSession.set(openSession(level));
  }

  public void startManagedSession(ExecutorType execType) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 241 12 8135540"); 
    this.localSqlSession.set(openSession(execType));
  }

  public void startManagedSession(ExecutorType execType, boolean autoCommit) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 241 13 8135540"); 
    this.localSqlSession.set(openSession(execType, autoCommit));
  }

  public void startManagedSession(ExecutorType execType, TransactionIsolationLevel level) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 241 14 8135540"); 
    this.localSqlSession.set(openSession(execType, level));
  }

  public void startManagedSession(ExecutorType execType, Connection connection) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 241 15 8135540"); 
    this.localSqlSession.set(openSession(execType, connection));
  }

  public boolean isManagedSessionStarted() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 241 16 8135540"); 
    return this.localSqlSession.get() != null;
  }

  public SqlSession openSession() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 241 17 8135540"); 
    return sqlSessionFactory.openSession();
  }

  public SqlSession openSession(boolean autoCommit) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 241 18 8135540"); 
    return sqlSessionFactory.openSession(autoCommit);
  }

  public SqlSession openSession(Connection connection) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 241 19 8135540"); 
    return sqlSessionFactory.openSession(connection);
  }

  public SqlSession openSession(TransactionIsolationLevel level) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 241 20 8135540"); 
    return sqlSessionFactory.openSession(level);
  }

  public SqlSession openSession(ExecutorType execType) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 241 21 8135540"); 
    return sqlSessionFactory.openSession(execType);
  }

  public SqlSession openSession(ExecutorType execType, boolean autoCommit) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 241 22 8135540"); 
    return sqlSessionFactory.openSession(execType, autoCommit);
  }

  public SqlSession openSession(ExecutorType execType, TransactionIsolationLevel level) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 241 23 8135540"); 
    return sqlSessionFactory.openSession(execType, level);
  }

  public SqlSession openSession(ExecutorType execType, Connection connection) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 241 24 8135540"); 
    return sqlSessionFactory.openSession(execType, connection);
  }

  public Configuration getConfiguration() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 241 25 8135540"); 
    return sqlSessionFactory.getConfiguration();
  }

  public <T> T selectOne(String statement) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 241 26 8135540"); 
    return sqlSessionProxy.<T> selectOne(statement);
  }

  public <T> T selectOne(String statement, Object parameter) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 241 27 8135540"); 
    return sqlSessionProxy.<T> selectOne(statement, parameter);
  }

  public <K, V> Map<K, V> selectMap(String statement, String mapKey) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 241 28 8135540"); 
    return sqlSessionProxy.<K, V> selectMap(statement, mapKey);
  }

  public <K, V> Map<K, V> selectMap(String statement, Object parameter, String mapKey) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 241 29 8135540"); 
    return sqlSessionProxy.<K, V> selectMap(statement, parameter, mapKey);
  }

  public <K, V> Map<K, V> selectMap(String statement, Object parameter, String mapKey, RowBounds rowBounds) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 241 30 8135540"); 
    return sqlSessionProxy.<K, V> selectMap(statement, parameter, mapKey, rowBounds);
  }

  public <E> List<E> selectList(String statement) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 241 31 8135540"); 
    return sqlSessionProxy.<E> selectList(statement);
  }

  public <E> List<E> selectList(String statement, Object parameter) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 241 32 8135540"); 
    return sqlSessionProxy.<E> selectList(statement, parameter);
  }

  public <E> List<E> selectList(String statement, Object parameter, RowBounds rowBounds) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 241 33 8135540"); 
    return sqlSessionProxy.<E> selectList(statement, parameter, rowBounds);
  }

  public void select(String statement, ResultHandler handler) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 241 34 8135540"); 
    sqlSessionProxy.select(statement, handler);
  }

  public void select(String statement, Object parameter, ResultHandler handler) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 241 35 8135540"); 
    sqlSessionProxy.select(statement, parameter, handler);
  }

  public void select(String statement, Object parameter, RowBounds rowBounds, ResultHandler handler) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 241 36 8135540"); 
    sqlSessionProxy.select(statement, parameter, rowBounds, handler);
  }

  public int insert(String statement) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 241 37 8135540"); 
    return sqlSessionProxy.insert(statement);
  }

  public int insert(String statement, Object parameter) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 241 38 8135540"); 
    return sqlSessionProxy.insert(statement, parameter);
  }

  public int update(String statement) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 241 39 8135540"); 
    return sqlSessionProxy.update(statement);
  }

  public int update(String statement, Object parameter) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 241 40 8135540"); 
    return sqlSessionProxy.update(statement, parameter);
  }

  public int delete(String statement) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 241 41 8135540"); 
    return sqlSessionProxy.delete(statement);
  }

  public int delete(String statement, Object parameter) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 241 42 8135540"); 
    return sqlSessionProxy.delete(statement, parameter);
  }

  public <T> T getMapper(Class<T> type) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 241 43 8135540"); 
    return getConfiguration().getMapper(type, this);
  }

  public Connection getConnection() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 241 44 8135540"); 
    final SqlSession sqlSession = localSqlSession.get();
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 241 45 8135540")|| true) && (sqlSession == null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 241 0 0 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 241 0 0 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 241 46 8135540"); throw new SqlSessionException("Error:  Cannot get connection.  No managed session is started."); }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 241 47 8135540");
    return sqlSession.getConnection();
  }

  public void clearCache() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 241 48 8135540"); 
    final SqlSession sqlSession = localSqlSession.get();
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 241 49 8135540")|| true) && (sqlSession == null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 241 1 1 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 241 1 1 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 241 50 8135540"); throw new SqlSessionException("Error:  Cannot clear the cache.  No managed session is started."); }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 241 51 8135540");
    sqlSession.clearCache();
  }

  public void commit() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 241 52 8135540"); 
    final SqlSession sqlSession = localSqlSession.get();
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 241 53 8135540")|| true) && (sqlSession == null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 241 2 2 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 241 2 2 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 241 54 8135540"); throw new SqlSessionException("Error:  Cannot commit.  No managed session is started."); }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 241 55 8135540");
    sqlSession.commit();
  }

  public void commit(boolean force) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 241 56 8135540"); 
    final SqlSession sqlSession = localSqlSession.get();
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 241 57 8135540")|| true) && (sqlSession == null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 241 3 3 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 241 3 3 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 241 58 8135540"); throw new SqlSessionException("Error:  Cannot commit.  No managed session is started."); }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 241 59 8135540");
    sqlSession.commit(force);
  }

  public void rollback() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 241 60 8135540"); 
    final SqlSession sqlSession = localSqlSession.get();
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 241 61 8135540")|| true) && (sqlSession == null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 241 4 4 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 241 4 4 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 241 62 8135540"); throw new SqlSessionException("Error:  Cannot rollback.  No managed session is started."); }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 241 63 8135540");
    sqlSession.rollback();
  }

  public void rollback(boolean force) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 241 64 8135540"); 
    final SqlSession sqlSession = localSqlSession.get();
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 241 65 8135540")|| true) && (sqlSession == null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 241 5 5 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 241 5 5 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 241 66 8135540"); throw new SqlSessionException("Error:  Cannot rollback.  No managed session is started."); }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 241 67 8135540");
    sqlSession.rollback(force);
  }

  public List<BatchResult> flushStatements() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 241 68 8135540"); 
    final SqlSession sqlSession = localSqlSession.get();
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 241 69 8135540")|| true) && (sqlSession == null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 241 6 6 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 241 6 6 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 241 70 8135540"); throw new SqlSessionException("Error:  Cannot rollback.  No managed session is started."); }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 241 71 8135540");
    return sqlSession.flushStatements();
  }

  public void close() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 241 72 8135540"); 
    final SqlSession sqlSession = localSqlSession.get();
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 241 73 8135540")|| true) && (sqlSession == null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 241 7 7 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 241 7 7 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 241 74 8135540"); throw new SqlSessionException("Error:  Cannot close.  No managed session is started."); }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 241 75 8135540");
    try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 241 76 8135540"); 
      sqlSession.close();
    } finally {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 241 77 8135540"); 
      localSqlSession.set(null);
    }
  }

  private class SqlSessionInterceptor implements InvocationHandler {
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 241 79 8135540"); 
      final SqlSession sqlSession = SqlSessionManager.this.localSqlSession.get();
      if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 241 80 8135540")|| true) && (sqlSession != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 241 8 8 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 241 8 8 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 241 81 8135540"); {
        try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 241 82 8135540"); 
          return method.invoke(sqlSession, args);
        } catch (Throwable t) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 241 83 8135540"); 
          throw ExceptionUtil.unwrapThrowable(t);
        }
      } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 241 85 8135540");  {
        final SqlSession autoSqlSession = openSession();
        try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 241 86 8135540"); 
          final Object result = method.invoke(autoSqlSession, args);
          autoSqlSession.commit();
          return result;
        } catch (Throwable t) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 241 87 8135540"); 
          autoSqlSession.rollback();
          throw ExceptionUtil.unwrapThrowable(t);
        } finally {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 241 88 8135540"); 
          autoSqlSession.close();
        }
      } }
    }
  }

}

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
package org.apache.ibatis.transaction.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.TransactionIsolationLevel;
import org.apache.ibatis.transaction.Transaction;
import org.apache.ibatis.transaction.TransactionException;

/**
 * {@link Transaction} that makes use of the JDBC commit and rollback facilities directly.
 * It relies on the connection retrieved from the dataSource to manage the scope of the transaction.
 * Delays connection retrieval until getConnection() is called.
 * Ignores commit or rollback requests when autocommit is on.
 *
 * @see JdbcTransactionFactory
 */
/**
 * @author Clinton Begin
 */
import com.process.ZoaExp;
import com.process.ZoaThreadLocal;
public class JdbcTransaction implements Transaction {

  private static final Log log = LogFactory.getLog(JdbcTransaction.class);

  protected Connection connection;
  protected DataSource dataSource;
  protected TransactionIsolationLevel level;
  protected boolean autoCommmit;

  public JdbcTransaction(DataSource ds, TransactionIsolationLevel desiredLevel, boolean desiredAutoCommit) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 160 0 8135540"); 
    dataSource = ds;
    level = desiredLevel;
    autoCommmit = desiredAutoCommit;
  }

  public JdbcTransaction(Connection connection) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 160 1 8135540"); 
    this.connection = connection;
  }

  public Connection getConnection() throws SQLException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 160 2 8135540"); 
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 160 3 8135540")|| true) && (connection == null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 160 0 0 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 160 0 0 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 160 4 8135540"); {
      openConnection();
    } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 160 5 8135540");
    return connection;
  }

  public void commit() throws SQLException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 160 6 8135540"); 
    int zoa_cond_n7_0 = 2;
int zoa_cond_n7_1 = 2;
//zoa_cond_n7_0#connection != null$zoa_cond_n7_1#connection.getAutoCommit()
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 160 7 8135540")|| true) && ((connection != null?(zoa_cond_n7_0 != (zoa_cond_n7_0 = 1)):(zoa_cond_n7_0 == (zoa_cond_n7_0 = 0))) && !(connection.getAutoCommit()?(zoa_cond_n7_1 != (zoa_cond_n7_1 = 1)):(zoa_cond_n7_1 == (zoa_cond_n7_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 160 3 1 1 2 ","8135540",true,zoa_cond_n7_0,zoa_cond_n7_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 160 3 1 0 2 ","8135540",false,zoa_cond_n7_0,zoa_cond_n7_1) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 160 8 8135540"); {
      if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 160 9 8135540")|| true) && (log.isDebugEnabled()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 160 4 2 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 160 4 2 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 160 10 8135540"); {
        log.debug("Committing JDBC Connection [" + connection + "]");
      } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 160 11 8135540");
      connection.commit();
    } }
  }

  public void rollback() throws SQLException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 160 13 8135540"); 
    int zoa_cond_n14_0 = 2;
int zoa_cond_n14_1 = 2;
//zoa_cond_n14_0#connection != null$zoa_cond_n14_1#connection.getAutoCommit()
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 160 14 8135540")|| true) && ((connection != null?(zoa_cond_n14_0 != (zoa_cond_n14_0 = 1)):(zoa_cond_n14_0 == (zoa_cond_n14_0 = 0))) && !(connection.getAutoCommit()?(zoa_cond_n14_1 != (zoa_cond_n14_1 = 1)):(zoa_cond_n14_1 == (zoa_cond_n14_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 160 7 3 1 2 ","8135540",true,zoa_cond_n14_0,zoa_cond_n14_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 160 7 3 0 2 ","8135540",false,zoa_cond_n14_0,zoa_cond_n14_1) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 160 15 8135540"); {
      if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 160 16 8135540")|| true) && (log.isDebugEnabled()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 160 8 4 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 160 8 4 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 160 17 8135540"); {
        log.debug("Rolling back JDBC Connection [" + connection + "]");
      } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 160 18 8135540");
      connection.rollback();
    } }
  }

  public void close() throws SQLException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 160 20 8135540"); 
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 160 21 8135540")|| true) && (connection != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 160 9 5 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 160 9 5 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 160 22 8135540"); {
      resetAutoCommit();
      if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 160 23 8135540")|| true) && (log.isDebugEnabled()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 160 10 6 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 160 10 6 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 160 24 8135540"); {
        log.debug("Closing JDBC Connection [" + connection + "]");
      } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 160 25 8135540");
      connection.close();
    } }
  }

  protected void setDesiredAutoCommit(boolean desiredAutoCommit) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 160 27 8135540"); 
    try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 160 28 8135540"); 
      if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 160 29 8135540")|| true) && (connection.getAutoCommit() != desiredAutoCommit? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 160 11 7 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 160 11 7 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 160 30 8135540"); {
        if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 160 31 8135540")|| true) && (log.isDebugEnabled()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 160 12 8 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 160 12 8 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 160 32 8135540"); {
          log.debug("Setting autocommit to " + desiredAutoCommit + " on JDBC Connection [" + connection + "]");
        } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 160 33 8135540");
        connection.setAutoCommit(desiredAutoCommit);
      } }
    } catch (SQLException e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 160 35 8135540"); 
      // Only a very poorly implemented driver would fail here,
      // and there's not much we can do about that.
      throw new TransactionException("Error configuring AutoCommit.  "
          + "Your driver may not support getAutoCommit() or setAutoCommit(). "
          + "Requested setting: " + desiredAutoCommit + ".  Cause: " + e, e);
    }
  }

  protected void resetAutoCommit() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 160 37 8135540"); 
    try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 160 38 8135540"); 
      if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 160 39 8135540")|| true) && (!connection.getAutoCommit()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 160 13 9 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 160 13 9 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 160 40 8135540"); {
        // MyBatis does not call commit/rollback on a connection if just selects were performed.
        // Some databases start transactions with select statements
        // and they mandate a commit/rollback before closing the connection.
        // A workaround is setting the autocommit to true before closing the connection.
        // Sybase throws an exception here.
        if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 160 41 8135540")|| true) && (log.isDebugEnabled()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 160 14 10 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 160 14 10 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 160 42 8135540"); {
          log.debug("Resetting autocommit to true on JDBC Connection [" + connection + "]");
        } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 160 43 8135540");
        connection.setAutoCommit(true);
      } }
    } catch (SQLException e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 160 45 8135540"); 
      log.debug("Error resetting autocommit to true "
          + "before closing the connection.  Cause: " + e);
    }
  }

  protected void openConnection() throws SQLException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 160 47 8135540"); 
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 160 48 8135540")|| true) && (log.isDebugEnabled()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 160 15 11 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 160 15 11 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 160 49 8135540"); {
      log.debug("Opening JDBC Connection");
    } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 160 50 8135540");
    connection = dataSource.getConnection();
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 160 51 8135540")|| true) && (level != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 160 16 12 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 160 16 12 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 160 52 8135540"); {
      connection.setTransactionIsolation(level.getLevel());
    } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 160 53 8135540");
    setDesiredAutoCommit(autoCommmit);
  }

}

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
package org.apache.ibatis.transaction.managed;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.TransactionIsolationLevel;
import org.apache.ibatis.transaction.Transaction;

/**
 * {@link Transaction} that lets the container manage the full lifecycle of the transaction.
 * Delays connection retrieval until getConnection() is called.
 * Ignores all commit or rollback requests.
 * By default, it closes the connection but can be configured not to do it.
 *
 * @see ManagedTransactionFactory
 */
/**
 * @author Clinton Begin
 */
import com.process.ZoaExp;
import com.process.ZoaThreadLocal;
public class ManagedTransaction implements Transaction {

  private static final Log log = LogFactory.getLog(ManagedTransaction.class);

  private DataSource dataSource;
  private TransactionIsolationLevel level;
  private Connection connection;
  private boolean closeConnection;

  public ManagedTransaction(Connection connection, boolean closeConnection) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 206 0 8135540"); 
    this.connection = connection;
    this.closeConnection = closeConnection;
  }

  public ManagedTransaction(DataSource ds, TransactionIsolationLevel level, boolean closeConnection) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 206 1 8135540"); 
    this.dataSource = ds;
    this.level = level;
    this.closeConnection = closeConnection;
  }

  public Connection getConnection() throws SQLException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 206 2 8135540"); 
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 206 3 8135540")|| true) && (this.connection == null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 206 0 0 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 206 0 0 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 206 4 8135540"); {
      openConnection();
    } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 206 5 8135540");
    return this.connection;
  }

  public void commit() throws SQLException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 206 6 8135540"); 
    // Does nothing
  }

  public void rollback() throws SQLException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 206 7 8135540"); 
    // Does nothing
  }

  public void close() throws SQLException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 206 8 8135540"); 
    int zoa_cond_n9_0 = 2;
int zoa_cond_n9_1 = 2;
//zoa_cond_n9_0#this.closeConnection$zoa_cond_n9_1#this.connection != null
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 206 9 8135540")|| true) && ((this.closeConnection?(zoa_cond_n9_0 != (zoa_cond_n9_0 = 1)):(zoa_cond_n9_0 == (zoa_cond_n9_0 = 0))) && (this.connection != null?(zoa_cond_n9_1 != (zoa_cond_n9_1 = 1)):(zoa_cond_n9_1 == (zoa_cond_n9_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 206 3 1 1 2 ","8135540",true,zoa_cond_n9_0,zoa_cond_n9_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 206 3 1 0 2 ","8135540",false,zoa_cond_n9_0,zoa_cond_n9_1) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 206 10 8135540"); {
      if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 206 11 8135540")|| true) && (log.isDebugEnabled()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 206 4 2 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 206 4 2 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 206 12 8135540"); {
        log.debug("Closing JDBC Connection [" + this.connection + "]");
      } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 206 13 8135540");
      this.connection.close();
    } }
  }

  protected void openConnection() throws SQLException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 206 15 8135540"); 
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 206 16 8135540")|| true) && (log.isDebugEnabled()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 206 5 3 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 206 5 3 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 206 17 8135540"); {
      log.debug("Opening JDBC Connection");
    } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 206 18 8135540");
    this.connection = this.dataSource.getConnection();
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 206 19 8135540")|| true) && (this.level != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 206 6 4 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 206 6 4 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 206 20 8135540"); {
      this.connection.setTransactionIsolation(this.level.getLevel());
    } }
  }

}

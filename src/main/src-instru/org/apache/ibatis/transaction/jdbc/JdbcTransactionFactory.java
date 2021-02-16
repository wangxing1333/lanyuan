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
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.session.TransactionIsolationLevel;
import org.apache.ibatis.transaction.Transaction;
import org.apache.ibatis.transaction.TransactionFactory;

/**
 * Creates {@link JdbcTransaction} instances.
 *
 * @see JdbcTransaction
 */
/**
 * @author Clinton Begin
 */
import com.process.ZoaExp;
import com.process.ZoaThreadLocal;
public class JdbcTransactionFactory implements TransactionFactory {

  public void setProperties(Properties props) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 237 0 8135540"); 
  }

  public Transaction newTransaction(Connection conn) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 237 1 8135540"); 
    return new JdbcTransaction(conn);
  }

  public Transaction newTransaction(DataSource ds, TransactionIsolationLevel level, boolean autoCommit) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 237 2 8135540"); 
    return new JdbcTransaction(ds, level, autoCommit);
  }
}

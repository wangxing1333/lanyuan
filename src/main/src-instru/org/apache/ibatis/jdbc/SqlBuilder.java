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
package org.apache.ibatis.jdbc;

/**
 * @Deprecated Use the SQL Class
 *
 * @author Jeff Butler
 */
import com.process.ZoaExp;
import com.process.ZoaThreadLocal;
public class SqlBuilder {

  private static final ThreadLocal<SQL> localSQL = new ThreadLocal<SQL>();

  static {
    ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 204 0 8135540"); BEGIN();
  }

  public static void BEGIN() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 204 1 8135540"); 
    RESET();
  }

  public static void RESET() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 204 2 8135540"); 
    localSQL.set(new SQL());
  }

  public static void UPDATE(String table) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 204 3 8135540"); 
    sql().UPDATE(table);
  }

  public static void SET(String sets) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 204 4 8135540"); 
    sql().SET(sets);
  }

  public static String SQL() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 204 5 8135540"); 
    try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 204 6 8135540"); 
      return sql().toString();
    } finally {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 204 7 8135540"); 
        RESET();
    }
  }

  public static void INSERT_INTO(String tableName) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 204 9 8135540"); 
    sql().INSERT_INTO(tableName);
  }

  public static void VALUES(String columns, String values) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 204 10 8135540"); 
    sql().VALUES(columns, values);
  }

  public static void SELECT(String columns) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 204 11 8135540"); 
    sql().SELECT(columns);
  }

  public static void SELECT_DISTINCT(String columns) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 204 12 8135540"); 
    sql().SELECT_DISTINCT(columns);
  }

  public static void DELETE_FROM(String table) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 204 13 8135540"); 
    sql().DELETE_FROM(table);
  }

  public static void FROM(String table) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 204 14 8135540"); 
    sql().FROM(table);
  }

  public static void JOIN(String join) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 204 15 8135540"); 
    sql().JOIN(join);
  }

  public static void INNER_JOIN(String join) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 204 16 8135540"); 
    sql().INNER_JOIN(join);
  }

  public static void LEFT_OUTER_JOIN(String join) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 204 17 8135540"); 
    sql().LEFT_OUTER_JOIN(join);
  }

  public static void RIGHT_OUTER_JOIN(String join) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 204 18 8135540"); 
    sql().RIGHT_OUTER_JOIN(join);
  }

  public static void OUTER_JOIN(String join) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 204 19 8135540"); 
    sql().OUTER_JOIN(join);
  }

  public static void WHERE(String conditions) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 204 20 8135540"); 
    sql().WHERE(conditions);
  }

  public static void OR() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 204 21 8135540"); 
    sql().OR();
  }

  public static void AND() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 204 22 8135540"); 
    sql().AND();
  }

  public static void GROUP_BY(String columns) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 204 23 8135540"); 
    sql().GROUP_BY(columns);
  }

  public static void HAVING(String conditions) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 204 24 8135540"); 
    sql().HAVING(conditions);
  }

  public static void ORDER_BY(String columns) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 204 25 8135540"); 
    sql().ORDER_BY(columns);
  }

  private static SQL sql() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 204 26 8135540"); 
    return localSQL.get();
  }

}

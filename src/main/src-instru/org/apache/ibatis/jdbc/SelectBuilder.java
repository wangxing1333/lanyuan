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
 * @author Clinton Begin
 */
import com.process.ZoaExp;
import com.process.ZoaThreadLocal;
@Deprecated
public class SelectBuilder {

  private static final ThreadLocal<SQL> localSQL = new ThreadLocal<SQL>();

  static {
    ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 223 0 8135540"); BEGIN();
  }

  public static void BEGIN() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 223 1 8135540"); 
    RESET();
  }

  public static void RESET() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 223 2 8135540"); 
    localSQL.set(new SQL());
  }

  public static void SELECT(String columns) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 223 3 8135540"); 
    sql().SELECT(columns);
  }

  public static void SELECT_DISTINCT(String columns) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 223 4 8135540"); 
    sql().SELECT_DISTINCT(columns);
  }

  public static void FROM(String table) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 223 5 8135540"); 
    sql().FROM(table);
  }

  public static void JOIN(String join) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 223 6 8135540"); 
    sql().JOIN(join);
  }

  public static void INNER_JOIN(String join) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 223 7 8135540"); 
    sql().INNER_JOIN(join);
  }

  public static void LEFT_OUTER_JOIN(String join) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 223 8 8135540"); 
    sql().LEFT_OUTER_JOIN(join);
  }

  public static void RIGHT_OUTER_JOIN(String join) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 223 9 8135540"); 
    sql().RIGHT_OUTER_JOIN(join);
  }

  public static void OUTER_JOIN(String join) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 223 10 8135540"); 
    sql().OUTER_JOIN(join);
  }

  public static void WHERE(String conditions) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 223 11 8135540"); 
    sql().WHERE(conditions);
  }

  public static void OR() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 223 12 8135540"); 
    sql().OR();
  }

  public static void AND() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 223 13 8135540"); 
    sql().AND();
  }

  public static void GROUP_BY(String columns) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 223 14 8135540"); 
    sql().GROUP_BY(columns);
  }

  public static void HAVING(String conditions) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 223 15 8135540"); 
    sql().HAVING(conditions);
  }

  public static void ORDER_BY(String columns) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 223 16 8135540"); 
    sql().ORDER_BY(columns);
  }

  public static String SQL() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 223 17 8135540"); 
    try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 223 18 8135540"); 
      return sql().toString();
    } finally {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 223 19 8135540"); 
      RESET();
    }
  }

  private static SQL sql() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 223 21 8135540"); 
    return localSQL.get();
  }

}

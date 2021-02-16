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
package org.apache.ibatis.executor.keygen;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.ExecutorException;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.type.TypeHandler;
import org.apache.ibatis.type.TypeHandlerRegistry;

/**
 * @author Clinton Begin
 */
import com.process.ZoaExp;
import com.process.ZoaThreadLocal;
public class Jdbc3KeyGenerator implements KeyGenerator {

  public void processBefore(Executor executor, MappedStatement ms, Statement stmt, Object parameter) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 292 0 8135540"); 
    // do nothing
  }

  public void processAfter(Executor executor, MappedStatement ms, Statement stmt, Object parameter) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 292 1 8135540"); 
    List<Object> parameters = new ArrayList<Object>();
    parameters.add(parameter);
    processBatch(ms, stmt, parameters);
  }

  public void processBatch(MappedStatement ms, Statement stmt, List<Object> parameters) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 292 2 8135540"); 
    ResultSet rs = null;
    try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 292 3 8135540"); 
      rs = stmt.getGeneratedKeys();
      final Configuration configuration = ms.getConfiguration();
      final TypeHandlerRegistry typeHandlerRegistry = configuration.getTypeHandlerRegistry();
      final String[] keyProperties = ms.getKeyProperties();
      final ResultSetMetaData rsmd = rs.getMetaData();
      TypeHandler<?>[] typeHandlers = null;
      int zoa_cond_n4_0 = 2;
int zoa_cond_n4_1 = 2;
//zoa_cond_n4_0#keyProperties != null$zoa_cond_n4_1#rsmd.getColumnCount() >= keyProperties.length
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 292 4 8135540")|| true) && ((keyProperties != null?(zoa_cond_n4_0 != (zoa_cond_n4_0 = 1)):(zoa_cond_n4_0 == (zoa_cond_n4_0 = 0))) && (rsmd.getColumnCount() >= keyProperties.length?(zoa_cond_n4_1 != (zoa_cond_n4_1 = 1)):(zoa_cond_n4_1 == (zoa_cond_n4_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 292 2 0 1 2 ","8135540",true,zoa_cond_n4_0,zoa_cond_n4_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 292 2 0 0 2 ","8135540",false,zoa_cond_n4_0,zoa_cond_n4_1) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 292 5 8135540"); {
        for (Object parameter : /* TRUE */parameters){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 292 6 8135540");ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 292 7 8135540"); {
          if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 292 8 8135540")|| true) && (!rs.next()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 292 3 1 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 292 3 1 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 292 9 8135540");  break; }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 292 10 8135540"); // there should be one row for each statement (also one for each parameter)
          final MetaObject metaParam = configuration.newMetaObject(parameter);
          if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 292 11 8135540")|| true) && (typeHandlers == null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 292 4 2 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 292 4 2 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 292 12 8135540"); typeHandlers = getTypeHandlers(typeHandlerRegistry, metaParam, keyProperties); }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 292 13 8135540");
          populateKeys(rs, metaParam, keyProperties, typeHandlers);
        }}
      } }
    } catch (Exception e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 292 16 8135540"); 
      throw new ExecutorException("Error getting generated key or setting result to parameter object. Cause: " + e, e);
    } finally {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 292 17 8135540"); 
      if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 292 18 8135540")|| true) && (rs != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 292 5 3 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 292 5 3 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 292 19 8135540"); {
        try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 292 20 8135540"); 
          rs.close();
        } catch (Exception e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 292 21 8135540"); 
          // ignore
        }
      } }
    }
  }

  private TypeHandler<?>[] getTypeHandlers(TypeHandlerRegistry typeHandlerRegistry, MetaObject metaParam, String[] keyProperties) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 292 25 8135540"); 
    TypeHandler<?>[] typeHandlers = new TypeHandler<?>[keyProperties.length];
    for (int i = 0; (ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 292 26 8135540")|| true) && (i < keyProperties.length? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 292 6 4 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 292 6 4 0 0 ","8135540",false,0) && false)); i++){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 292 27 8135540"); {
      if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 292 28 8135540")|| true) && (metaParam.hasSetter(keyProperties[i])? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 292 7 5 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 292 7 5 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 292 29 8135540"); {
        Class<?> keyPropertyType = metaParam.getSetterType(keyProperties[i]);
        TypeHandler<?> th = typeHandlerRegistry.getTypeHandler(keyPropertyType);
        typeHandlers[i] = th;
      } }
    }}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 292 31 8135540");
    return typeHandlers;
  }

  private void populateKeys(ResultSet rs, MetaObject metaParam, String[] keyProperties, TypeHandler<?>[] typeHandlers) throws SQLException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 292 32 8135540"); 
    for (int i = 0; (ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 292 33 8135540")|| true) && (i < keyProperties.length? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 292 8 6 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 292 8 6 0 0 ","8135540",false,0) && false)); i++){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 292 34 8135540"); {
      TypeHandler<?> th = typeHandlers[i];
      if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 292 35 8135540")|| true) && (th != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 292 9 7 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 292 9 7 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 292 36 8135540"); {
        Object value = th.getResult(rs, i + 1);
        metaParam.setValue(keyProperties[i], value);
      } }
    }}
  }

}

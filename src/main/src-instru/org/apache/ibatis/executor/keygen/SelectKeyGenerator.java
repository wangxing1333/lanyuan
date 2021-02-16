// ZOA_CREATED! DO NOT EDIT IT! -- 
/*
 *    Copyright 2009-2013 the original author or authors.
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

import java.sql.Statement;
import java.util.List;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.ExecutorException;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.RowBounds;

/**
 * @author Clinton Begin
 * @author Jeff Butler
 */
import com.process.ZoaExp;
import com.process.ZoaThreadLocal;
public class SelectKeyGenerator implements KeyGenerator {
  
  public static final String SELECT_KEY_SUFFIX = "!selectKey";
  private boolean executeBefore;
  private MappedStatement keyStatement;

  public SelectKeyGenerator(MappedStatement keyStatement, boolean executeBefore) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 198 0 8135540"); 
    this.executeBefore = executeBefore;
    this.keyStatement = keyStatement;
  }

  public void processBefore(Executor executor, MappedStatement ms, Statement stmt, Object parameter) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 198 1 8135540"); 
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 198 2 8135540")|| true) && (executeBefore? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 198 0 0 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 198 0 0 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 198 3 8135540"); {
      processGeneratedKeys(executor, ms, parameter);
    } }
  }

  public void processAfter(Executor executor, MappedStatement ms, Statement stmt, Object parameter) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 198 5 8135540"); 
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 198 6 8135540")|| true) && (!executeBefore? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 198 1 1 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 198 1 1 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 198 7 8135540"); {
      processGeneratedKeys(executor, ms, parameter);
    } }
  }

  private void processGeneratedKeys(Executor executor, MappedStatement ms, Object parameter) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 198 9 8135540"); 
    try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 198 10 8135540"); 
      int zoa_cond_n11_0 = 2;
int zoa_cond_n11_1 = 2;
int zoa_cond_n11_2 = 2;
//zoa_cond_n11_0#parameter != null$zoa_cond_n11_1#keyStatement != null$zoa_cond_n11_2#keyStatement.getKeyProperties() != null
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 198 11 8135540")|| true) && ((parameter != null?(zoa_cond_n11_0 != (zoa_cond_n11_0 = 1)):(zoa_cond_n11_0 == (zoa_cond_n11_0 = 0))) && (keyStatement != null?(zoa_cond_n11_1 != (zoa_cond_n11_1 = 1)):(zoa_cond_n11_1 == (zoa_cond_n11_1 = 0))) && (keyStatement.getKeyProperties() != null?(zoa_cond_n11_2 != (zoa_cond_n11_2 = 1)):(zoa_cond_n11_2 == (zoa_cond_n11_2 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 198 5 2 1 3 ","8135540",true,zoa_cond_n11_0,zoa_cond_n11_1,zoa_cond_n11_2) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 198 5 2 0 3 ","8135540",false,zoa_cond_n11_0,zoa_cond_n11_1,zoa_cond_n11_2) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 198 12 8135540"); {
        String[] keyProperties = keyStatement.getKeyProperties();
        final Configuration configuration = ms.getConfiguration();
        final MetaObject metaParam = configuration.newMetaObject(parameter);
        if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 198 13 8135540")|| true) && (keyProperties != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 198 6 3 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 198 6 3 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 198 14 8135540"); {
          // Do not close keyExecutor.
          // The transaction will be closed by parent executor.
          Executor keyExecutor = configuration.newExecutor(executor.getTransaction(), ExecutorType.SIMPLE);
          List<Object> values = keyExecutor.query(keyStatement, parameter, RowBounds.DEFAULT, Executor.NO_RESULT_HANDLER);
          if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 198 15 8135540")|| true) && (values.size() == 0? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 198 7 4 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 198 7 4 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 198 16 8135540"); {
            throw new ExecutorException("SelectKey returned no data.");            
          } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 198 17 8135540");  if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 198 18 8135540")|| true) && (values.size() > 1? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 198 8 5 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 198 8 5 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 198 19 8135540"); {
            throw new ExecutorException("SelectKey returned more than one value.");
          } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 198 20 8135540");  {
            MetaObject metaResult = configuration.newMetaObject(values.get(0));
            if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 198 21 8135540")|| true) && (keyProperties.length == 1? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 198 9 6 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 198 9 6 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 198 22 8135540"); {
              if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 198 23 8135540")|| true) && (metaResult.hasGetter(keyProperties[0])? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 198 10 7 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 198 10 7 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 198 24 8135540"); {
                setValue(metaParam, keyProperties[0], metaResult.getValue(keyProperties[0]));
              } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 198 25 8135540");  {
                // no getter for the property - maybe just a single value object
                // so try that
                setValue(metaParam, keyProperties[0], values.get(0));
              } }
            } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 198 27 8135540");  {
              handleMultipleProperties(keyProperties, metaParam, metaResult);
            } }
          } } }
        } }
      } }
    } catch (ExecutorException e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 198 33 8135540"); 
      throw e;
    } catch (Exception e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 198 34 8135540"); 
      throw new ExecutorException("Error selecting key or setting result to parameter object. Cause: " + e, e);
    }
  }

  private void handleMultipleProperties(String[] keyProperties,
      MetaObject metaParam, MetaObject metaResult) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 198 36 8135540"); 
    String[] keyColumns = keyStatement.getKeyColumns();
      
    int zoa_cond_n37_0 = 2;
int zoa_cond_n37_1 = 2;
//zoa_cond_n37_0#keyColumns == null$zoa_cond_n37_1#keyColumns.length == 0
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 198 37 8135540")|| true) && ((keyColumns == null?(zoa_cond_n37_0 != (zoa_cond_n37_0 = 1)):(zoa_cond_n37_0 == (zoa_cond_n37_0 = 0))) || (keyColumns.length == 0?(zoa_cond_n37_1 != (zoa_cond_n37_1 = 1)):(zoa_cond_n37_1 == (zoa_cond_n37_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 198 13 8 1 2 ","8135540",true,zoa_cond_n37_0,zoa_cond_n37_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 198 13 8 0 2 ","8135540",false,zoa_cond_n37_0,zoa_cond_n37_1) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 198 38 8135540"); {
      // no key columns specified, just use the property names
      for (int i = 0; (ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 198 39 8135540")|| true) && (i < keyProperties.length? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 198 14 9 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 198 14 9 0 0 ","8135540",false,0) && false)); i++){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 198 40 8135540"); {
        setValue(metaParam, keyProperties[i], metaResult.getValue(keyProperties[i]));
      }}
    } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 198 42 8135540");  {
      if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 198 43 8135540")|| true) && (keyColumns.length != keyProperties.length? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 198 15 10 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 198 15 10 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 198 44 8135540"); {
        throw new ExecutorException("If SelectKey has key columns, the number must match the number of key properties.");
      } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 198 45 8135540");
      for (int i = 0; (ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 198 46 8135540")|| true) && (i < keyProperties.length? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 198 16 11 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 198 16 11 0 0 ","8135540",false,0) && false)); i++){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 198 47 8135540"); {
        setValue(metaParam, keyProperties[i], metaResult.getValue(keyColumns[i]));
      }}
    } }
  }

  private void setValue(MetaObject metaParam, String property, Object value) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 198 50 8135540"); 
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 198 51 8135540")|| true) && (metaParam.hasSetter(property)? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 198 17 12 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 198 17 12 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 198 52 8135540"); {
      metaParam.setValue(property, value);
    } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 198 53 8135540");  {
      throw new ExecutorException("No setter found for the keyProperty '" + property + "' in " + metaParam.getOriginalObject().getClass().getName() + ".");
    } }
  }
}

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
package org.apache.ibatis.builder.annotation;

import java.lang.reflect.Method;
import java.util.HashMap;

import org.apache.ibatis.builder.BuilderException;
import org.apache.ibatis.builder.SqlSourceBuilder;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.session.Configuration;

/**
 * @author Clinton Begin
 */
import com.process.ZoaExp;
import com.process.ZoaThreadLocal;
public class ProviderSqlSource implements SqlSource {

  private SqlSourceBuilder sqlSourceParser;
  private Class<?> providerType;
  private Method providerMethod;
  private boolean providerTakesParameterObject;

  public ProviderSqlSource(Configuration config, Object provider) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 280 0 8135540"); 
    String providerMethodName = null;
    try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 280 1 8135540"); 
      this.sqlSourceParser = new SqlSourceBuilder(config);
      this.providerType = (Class<?>) provider.getClass().getMethod("type").invoke(provider);
      providerMethodName = (String) provider.getClass().getMethod("method").invoke(provider);

      for (Method m : /* TRUE */this.providerType.getMethods()){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 280 2 8135540");ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 280 3 8135540"); {
        if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 280 4 8135540")|| true) && (providerMethodName.equals(m.getName())? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 280 0 0 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 280 0 0 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 280 5 8135540"); {
          int zoa_cond_n6_0 = 2;
int zoa_cond_n6_1 = 2;
//zoa_cond_n6_0#m.getParameterTypes().length < 2$zoa_cond_n6_1#m.getReturnType() == String.class
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 280 6 8135540")|| true) && ((m.getParameterTypes().length < 2?(zoa_cond_n6_0 != (zoa_cond_n6_0 = 1)):(zoa_cond_n6_0 == (zoa_cond_n6_0 = 0)))
              && (m.getReturnType() == String.class?(zoa_cond_n6_1 != (zoa_cond_n6_1 = 1)):(zoa_cond_n6_1 == (zoa_cond_n6_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 280 3 1 1 2 ","8135540",true,zoa_cond_n6_0,zoa_cond_n6_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 280 3 1 0 2 ","8135540",false,zoa_cond_n6_0,zoa_cond_n6_1) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 280 7 8135540"); {
            this.providerMethod = m;
            this.providerTakesParameterObject = m.getParameterTypes().length == 1;
          } }
        } }
      }}
    } catch (Exception e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 280 11 8135540"); 
      throw new BuilderException("Error creating SqlSource for SqlProvider.  Cause: " + e, e);
    }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 280 12 8135540");
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 280 13 8135540")|| true) && (this.providerMethod == null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 280 4 2 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 280 4 2 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 280 14 8135540"); {
      throw new BuilderException("Error creating SqlSource for SqlProvider. Method '"
          + providerMethodName + "' not found in SqlProvider '" + this.providerType.getName() + "'.");
    } }
  }

  public BoundSql getBoundSql(Object parameterObject) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 280 16 8135540"); 
    SqlSource sqlSource = createSqlSource(parameterObject);
    return sqlSource.getBoundSql(parameterObject);
  }

  private SqlSource createSqlSource(Object parameterObject) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 280 17 8135540"); 
    try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 280 18 8135540"); 
      String sql;
      if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 280 19 8135540")|| true) && (providerTakesParameterObject? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 280 5 3 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 280 5 3 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 280 20 8135540"); {
        sql = (String) providerMethod.invoke(providerType.newInstance(), parameterObject);
      } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 280 21 8135540");  {
        sql = (String) providerMethod.invoke(providerType.newInstance());
      } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 280 22 8135540");
      Class<?> parameterType = parameterObject == null ? Object.class : parameterObject.getClass();
      return sqlSourceParser.parse(sql, parameterType, new HashMap<String, Object>());
    } catch (Exception e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 280 23 8135540"); 
      throw new BuilderException("Error invoking SqlProvider method ("
          + providerType.getName() + "." + providerMethod.getName()
          + ").  Cause: " + e, e);
    }
  }

}

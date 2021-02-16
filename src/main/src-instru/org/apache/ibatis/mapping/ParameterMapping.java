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
package org.apache.ibatis.mapping;

import java.sql.ResultSet;

import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;
import org.apache.ibatis.type.TypeHandlerRegistry;

/**
 * @author Clinton Begin
 */
import com.process.ZoaExp;
import com.process.ZoaThreadLocal;
public class ParameterMapping {

  private Configuration configuration;

  private String property;
  private ParameterMode mode;
  private Class<?> javaType = Object.class;
  private JdbcType jdbcType;
  private Integer numericScale;
  private TypeHandler<?> typeHandler;
  private String resultMapId;
  private String jdbcTypeName;
  private String expression;

  private ParameterMapping() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 268 0 8135540"); 
  }

  public static class Builder {
    private ParameterMapping parameterMapping = new ParameterMapping();

    public Builder(Configuration configuration, String property, TypeHandler<?> typeHandler) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 268 1 8135540"); 
      parameterMapping.configuration = configuration;
      parameterMapping.property = property;
      parameterMapping.typeHandler = typeHandler;
      parameterMapping.mode = ParameterMode.IN;
    }

    public Builder(Configuration configuration, String property, Class<?> javaType) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 268 2 8135540"); 
      parameterMapping.configuration = configuration;
      parameterMapping.property = property;
      parameterMapping.javaType = javaType;
      parameterMapping.mode = ParameterMode.IN;
    }

    public Builder mode(ParameterMode mode) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 268 3 8135540"); 
      parameterMapping.mode = mode;
      return this;
    }

    public Builder javaType(Class<?> javaType) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 268 4 8135540"); 
      parameterMapping.javaType = javaType;
      return this;
    }

    public Builder jdbcType(JdbcType jdbcType) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 268 5 8135540"); 
      parameterMapping.jdbcType = jdbcType;
      return this;
    }

    public Builder numericScale(Integer numericScale) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 268 6 8135540"); 
      parameterMapping.numericScale = numericScale;
      return this;
    }

    public Builder resultMapId(String resultMapId) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 268 7 8135540"); 
      parameterMapping.resultMapId = resultMapId;
      return this;
    }

    public Builder typeHandler(TypeHandler<?> typeHandler) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 268 8 8135540"); 
      parameterMapping.typeHandler = typeHandler;
      return this;
    }

    public Builder jdbcTypeName(String jdbcTypeName) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 268 9 8135540"); 
      parameterMapping.jdbcTypeName = jdbcTypeName;
      return this;
    }

    public Builder expression(String expression) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 268 10 8135540"); 
      parameterMapping.expression = expression;
      return this;
    }

    public ParameterMapping build() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 268 11 8135540"); 
      resolveTypeHandler();
      validate();
      return parameterMapping;
    }

    private void validate() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 268 12 8135540"); 
      if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 268 13 8135540")|| true) && (ResultSet.class.equals(parameterMapping.javaType)? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 268 0 0 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 268 0 0 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 268 14 8135540"); {
        if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 268 15 8135540")|| true) && (parameterMapping.resultMapId == null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 268 1 1 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 268 1 1 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 268 16 8135540"); { 
          throw new IllegalStateException("Missing resultmap in property '"  
              + parameterMapping.property + "'.  " 
              + "Parameters of type java.sql.ResultSet require a resultmap.");
        } }            
      } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 268 18 8135540");  {
        if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 268 19 8135540")|| true) && (parameterMapping.typeHandler == null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 268 2 2 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 268 2 2 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 268 20 8135540"); { 
          throw new IllegalStateException("Type handler was null on parameter mapping for property '"  
              + parameterMapping.property + "'.  " 
              + "It was either not specified and/or could not be found for the javaType / jdbcType combination specified.");
        } }
      } }
    }

    private void resolveTypeHandler() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 268 23 8135540"); 
      int zoa_cond_n24_0 = 2;
int zoa_cond_n24_1 = 2;
//zoa_cond_n24_0#parameterMapping.typeHandler == null$zoa_cond_n24_1#parameterMapping.javaType != null
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 268 24 8135540")|| true) && ((parameterMapping.typeHandler == null?(zoa_cond_n24_0 != (zoa_cond_n24_0 = 1)):(zoa_cond_n24_0 == (zoa_cond_n24_0 = 0))) && (parameterMapping.javaType != null?(zoa_cond_n24_1 != (zoa_cond_n24_1 = 1)):(zoa_cond_n24_1 == (zoa_cond_n24_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 268 5 3 1 2 ","8135540",true,zoa_cond_n24_0,zoa_cond_n24_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 268 5 3 0 2 ","8135540",false,zoa_cond_n24_0,zoa_cond_n24_1) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 268 25 8135540"); {
        Configuration configuration = parameterMapping.configuration;
        TypeHandlerRegistry typeHandlerRegistry = configuration.getTypeHandlerRegistry();
        parameterMapping.typeHandler = typeHandlerRegistry.getTypeHandler(parameterMapping.javaType, parameterMapping.jdbcType);
      } }
    }

  }

  public String getProperty() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 268 27 8135540"); 
    return property;
  }

  /**
   * Used for handling output of callable statements
   * @return
   */
  public ParameterMode getMode() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 268 28 8135540"); 
    return mode;
  }

  /**
   * Used for handling output of callable statements
   * @return
   */
  public Class<?> getJavaType() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 268 29 8135540"); 
    return javaType;
  }

  /**
   * Used in the UnknownTypeHandler in case there is no handler for the property type
   * @return
   */
  public JdbcType getJdbcType() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 268 30 8135540"); 
    return jdbcType;
  }

  /**
   * Used for handling output of callable statements
   * @return
   */
  public Integer getNumericScale() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 268 31 8135540"); 
    return numericScale;
  }

  /**
   * Used when setting parameters to the PreparedStatement
   * @return
   */
  public TypeHandler<?> getTypeHandler() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 268 32 8135540"); 
    return typeHandler;
  }

  /**
   * Used for handling output of callable statements
   * @return
   */
  public String getResultMapId() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 268 33 8135540"); 
    return resultMapId;
  }

  /**
   * Used for handling output of callable statements
   * @return
   */
  public String getJdbcTypeName() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 268 34 8135540"); 
    return jdbcTypeName;
  }

  /**
   * Not used
   * @return
   */
  public String getExpression() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 268 35 8135540"); 
    return expression;
  }

}

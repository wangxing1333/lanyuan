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
package org.apache.ibatis.mapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.session.Configuration;

/**
 * An actual SQL String got form an {@link SqlSource} after having processed any dynamic content.
 * The SQL may have SQL placeholders "?" and an list (ordered) of an parameter mappings 
 * with the additional information for each parameter (at least the property name of the input object to read 
 * the value from). 
 * </br>
 * Can also have additional parameters that are created by the dynamic language (for loops, bind...).
 */
/**
 * @author Clinton Begin
 */
import com.process.ZoaExp;
import com.process.ZoaThreadLocal;
public class BoundSql {

  private String sql;
  private List<ParameterMapping> parameterMappings;
  private Object parameterObject;
  private Map<String, Object> additionalParameters;
  private MetaObject metaParameters;

  public BoundSql(Configuration configuration, String sql, List<ParameterMapping> parameterMappings, Object parameterObject) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 264 0 8135540"); 
    this.sql = sql;
    this.parameterMappings = parameterMappings;
    this.parameterObject = parameterObject;
    this.additionalParameters = new HashMap<String, Object>();
    this.metaParameters = configuration.newMetaObject(additionalParameters);
  }

  public String getSql() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 264 1 8135540"); 
    return sql;
  }

  public List<ParameterMapping> getParameterMappings() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 264 2 8135540"); 
    return parameterMappings;
  }

  public Object getParameterObject() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 264 3 8135540"); 
    return parameterObject;
  }

  public boolean hasAdditionalParameter(String name) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 264 4 8135540"); 
    return metaParameters.hasGetter(name);
  }

  public void setAdditionalParameter(String name, Object value) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 264 5 8135540"); 
    metaParameters.setValue(name, value);
  }

  public Object getAdditionalParameter(String name) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 264 6 8135540"); 
    return metaParameters.getValue(name);
  }
}

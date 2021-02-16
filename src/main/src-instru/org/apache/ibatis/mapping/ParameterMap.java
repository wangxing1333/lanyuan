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

import java.util.Collections;
import java.util.List;

import org.apache.ibatis.session.Configuration;

/**
 * @author Clinton Begin
 */
import com.process.ZoaExp;
import com.process.ZoaThreadLocal;
public class ParameterMap {

  private String id;
  private Class<?> type;
  private List<ParameterMapping> parameterMappings;
  private String value;

  private ParameterMap() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 261 0 8135540"); 
  }

  public static class Builder {
    private ParameterMap parameterMap = new ParameterMap();

    public Builder(Configuration configuration, String id, Class<?> type, List<ParameterMapping> parameterMappings) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 261 1 8135540"); 
      parameterMap.id = id;
      parameterMap.type = type;
      parameterMap.parameterMappings = parameterMappings;
    }

    public Class<?> type() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 261 2 8135540"); 
      return parameterMap.type;
    }

    public ParameterMap build() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 261 3 8135540"); 
      //lock down collections
      parameterMap.parameterMappings = Collections.unmodifiableList(parameterMap.parameterMappings);
      return parameterMap;
    }
  }

  public String getId() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 261 4 8135540"); 
    return id;
  }

  public Class<?> getType() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 261 5 8135540"); 
    return type;
  }

  public List<ParameterMapping> getParameterMappings() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 261 6 8135540"); 
    return parameterMappings;
  }

public String getValue() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 261 7 8135540"); 
	return value;
}

public void setValue(String value) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 261 8 8135540"); 
	this.value = value;
}

}

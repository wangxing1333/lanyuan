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
import java.util.Map;

import org.apache.ibatis.session.Configuration;

/**
 * @author Clinton Begin
 */
import com.process.ZoaExp;
import com.process.ZoaThreadLocal;
public class Discriminator {

  private ResultMapping resultMapping;
  private Map<String, String> discriminatorMap;

  private Discriminator() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 262 0 8135540"); 
  }

  public static class Builder {
    private Discriminator discriminator = new Discriminator();

    public Builder(Configuration configuration, ResultMapping resultMapping, Map<String, String> discriminatorMap) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 262 1 8135540"); 
      discriminator.resultMapping = resultMapping;
      discriminator.discriminatorMap = discriminatorMap;
    }

    public Discriminator build() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 262 2 8135540"); 
      assert discriminator.resultMapping != null;
      assert discriminator.discriminatorMap != null;
      assert discriminator.discriminatorMap.size() > 0;
      //lock down map
      discriminator.discriminatorMap = Collections.unmodifiableMap(discriminator.discriminatorMap);
      return discriminator;
    }
  }

  public ResultMapping getResultMapping() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 262 3 8135540"); 
    return resultMapping;
  }

  public Map<String, String> getDiscriminatorMap() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 262 4 8135540"); 
    return discriminatorMap;
  }

  public String getMapIdFor(String s) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 262 5 8135540"); 
    return discriminatorMap.get(s);
  }

}

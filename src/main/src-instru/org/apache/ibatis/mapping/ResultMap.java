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

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import org.apache.ibatis.session.Configuration;

/**
 * @author Clinton Begin
 */
import com.process.ZoaExp;
import com.process.ZoaThreadLocal;
public class ResultMap {
  private String id;
  private Class<?> type;
  private List<ResultMapping> resultMappings;
  private List<ResultMapping> idResultMappings;
  private List<ResultMapping> constructorResultMappings;
  private List<ResultMapping> propertyResultMappings;
  private Set<String> mappedColumns;
  private Discriminator discriminator;
  private boolean hasNestedResultMaps;
  private boolean hasNestedQueries;
  private Boolean autoMapping;

  private ResultMap() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 287 0 8135540"); 
  }

  public static class Builder {
    private ResultMap resultMap = new ResultMap();

    public Builder(Configuration configuration, String id, Class<?> type, List<ResultMapping> resultMappings) {
      this(configuration, id, type, resultMappings, null);
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 287 1 8135540"); 
    }

    public Builder(Configuration configuration, String id, Class<?> type, List<ResultMapping> resultMappings, Boolean autoMapping) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 287 2 8135540"); 
      resultMap.id = id;
      resultMap.type = type;
      resultMap.resultMappings = resultMappings;
      resultMap.autoMapping = autoMapping;
    }

    public Builder discriminator(Discriminator discriminator) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 287 3 8135540"); 
      resultMap.discriminator = discriminator;
      return this;
    }

    public Class<?> type() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 287 4 8135540"); 
      return resultMap.type;
    }

    public ResultMap build() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 287 5 8135540"); 
      if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 287 6 8135540")|| true) && (resultMap.id == null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 287 0 0 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 287 0 0 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 287 7 8135540"); {
        throw new IllegalArgumentException("ResultMaps must have an id");
      } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 287 8 8135540");
      resultMap.mappedColumns = new HashSet<String>();
      resultMap.idResultMappings = new ArrayList<ResultMapping>();
      resultMap.constructorResultMappings = new ArrayList<ResultMapping>();
      resultMap.propertyResultMappings = new ArrayList<ResultMapping>();
      for (ResultMapping resultMapping : /* TRUE */resultMap.resultMappings){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 287 9 8135540");ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 287 10 8135540"); {
        resultMap.hasNestedQueries = resultMap.hasNestedQueries || resultMapping.getNestedQueryId() != null;
        resultMap.hasNestedResultMaps = resultMap.hasNestedResultMaps || (resultMapping.getNestedResultMapId() != null && resultMapping.getResultSet() == null);
        final String column = resultMapping.getColumn();
        if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 287 11 8135540")|| true) && (column != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 287 1 1 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 287 1 1 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 287 12 8135540"); {
          resultMap.mappedColumns.add(column.toUpperCase(Locale.ENGLISH));
        } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 287 13 8135540");  if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 287 14 8135540")|| true) && (resultMapping.isCompositeResult()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 287 2 2 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 287 2 2 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 287 15 8135540"); {
          for (ResultMapping compositeResultMapping : /* TRUE */resultMapping.getComposites()){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 287 16 8135540");ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 287 17 8135540"); {
            final String compositeColumn = compositeResultMapping.getColumn();
            if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 287 18 8135540")|| true) && (compositeColumn != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 287 3 3 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 287 3 3 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 287 19 8135540"); {
              resultMap.mappedColumns.add(compositeColumn.toUpperCase(Locale.ENGLISH));
            } }
          }}
        } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 287 22 8135540"); }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 287 23 8135540");
        if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 287 24 8135540")|| true) && (resultMapping.getFlags().contains(ResultFlag.CONSTRUCTOR)? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 287 4 4 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 287 4 4 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 287 25 8135540"); {
          resultMap.constructorResultMappings.add(resultMapping);
        } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 287 26 8135540");  {
          resultMap.propertyResultMappings.add(resultMapping);
        } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 287 27 8135540");
        if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 287 28 8135540")|| true) && (resultMapping.getFlags().contains(ResultFlag.ID)? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 287 5 5 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 287 5 5 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 287 29 8135540"); {
          resultMap.idResultMappings.add(resultMapping);
        } }
      }}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 287 31 8135540");
      if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 287 32 8135540")|| true) && (resultMap.idResultMappings.isEmpty()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 287 6 6 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 287 6 6 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 287 33 8135540"); {
        resultMap.idResultMappings.addAll(resultMap.resultMappings);
      } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 287 34 8135540");
      // lock down collections
      resultMap.resultMappings = Collections.unmodifiableList(resultMap.resultMappings);
      resultMap.idResultMappings = Collections.unmodifiableList(resultMap.idResultMappings);
      resultMap.constructorResultMappings = Collections.unmodifiableList(resultMap.constructorResultMappings);
      resultMap.propertyResultMappings = Collections.unmodifiableList(resultMap.propertyResultMappings);
      resultMap.mappedColumns = Collections.unmodifiableSet(resultMap.mappedColumns);
      return resultMap;
    }
  }

  public String getId() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 287 35 8135540"); 
    return id;
  }

  public boolean hasNestedResultMaps() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 287 36 8135540"); 
    return hasNestedResultMaps;
  }

  public boolean hasNestedQueries() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 287 37 8135540"); 
    return hasNestedQueries;
  }

  public Class<?> getType() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 287 38 8135540"); 
    return type;
  }

  public List<ResultMapping> getResultMappings() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 287 39 8135540"); 
    return resultMappings;
  }

  public List<ResultMapping> getConstructorResultMappings() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 287 40 8135540"); 
    return constructorResultMappings;
  }

  public List<ResultMapping> getPropertyResultMappings() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 287 41 8135540"); 
    return propertyResultMappings;
  }

  public List<ResultMapping> getIdResultMappings() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 287 42 8135540"); 
    return idResultMappings;
  }

  public Set<String> getMappedColumns() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 287 43 8135540"); 
    return mappedColumns;
  }

  public Discriminator getDiscriminator() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 287 44 8135540"); 
    return discriminator;
  }

  public void forceNestedResultMaps() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 287 45 8135540"); 
    hasNestedResultMaps = true;
  }
  
  public Boolean getAutoMapping() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 287 46 8135540"); 
    return autoMapping;
  }

}

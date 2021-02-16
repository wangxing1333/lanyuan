// ZOA_CREATED! DO NOT EDIT IT! -- 
/*
 *    Copyright 2009-2014 the original author or authors.
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
import java.util.List;
import java.util.Set;

import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;
import org.apache.ibatis.type.TypeHandlerRegistry;

/**
 * @author Clinton Begin
 */
import com.process.ZoaExp;
import com.process.ZoaThreadLocal;
public class ResultMapping {

  private Configuration configuration;
  private String property;
  private String column;
  private Class<?> javaType;
  private JdbcType jdbcType;
  private TypeHandler<?> typeHandler;
  private String nestedResultMapId;
  private String nestedQueryId;
  private Set<String> notNullColumns;
  private String columnPrefix;
  private List<ResultFlag> flags;
  private List<ResultMapping> composites;
  private String resultSet;
  private String foreignColumn;
  private boolean lazy;

  private ResultMapping() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 211 0 8135540"); 
  }

  public static class Builder {
    private ResultMapping resultMapping = new ResultMapping();

    public Builder(Configuration configuration, String property, String column, TypeHandler<?> typeHandler) {
      this(configuration, property);
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 211 1 8135540"); 
      resultMapping.column = column;
      resultMapping.typeHandler = typeHandler;
    }

    public Builder(Configuration configuration, String property, String column, Class<?> javaType) {
      this(configuration, property);
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 211 2 8135540"); 
      resultMapping.column = column;
      resultMapping.javaType = javaType;
    }

    public Builder(Configuration configuration, String property) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 211 3 8135540"); 
      resultMapping.configuration = configuration;
      resultMapping.property = property;
      resultMapping.flags = new ArrayList<ResultFlag>();
      resultMapping.composites = new ArrayList<ResultMapping>();
      resultMapping.lazy = configuration.isLazyLoadingEnabled();
    }

    public Builder javaType(Class<?> javaType) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 211 4 8135540"); 
      resultMapping.javaType = javaType;
      return this;
    }

    public Builder jdbcType(JdbcType jdbcType) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 211 5 8135540"); 
      resultMapping.jdbcType = jdbcType;
      return this;
    }

    public Builder nestedResultMapId(String nestedResultMapId) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 211 6 8135540"); 
      resultMapping.nestedResultMapId = nestedResultMapId;
      return this;
    }

    public Builder nestedQueryId(String nestedQueryId) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 211 7 8135540"); 
      resultMapping.nestedQueryId = nestedQueryId;
      return this;
    }

    public Builder resultSet(String resultSet) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 211 8 8135540"); 
      resultMapping.resultSet = resultSet;
      return this;
    }

    public Builder foreignColumn(String foreignColumn) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 211 9 8135540"); 
      resultMapping.foreignColumn = foreignColumn;
      return this;
    }

    public Builder notNullColumns(Set<String> notNullColumns) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 211 10 8135540"); 
      resultMapping.notNullColumns = notNullColumns;
      return this;
    }

    public Builder columnPrefix(String columnPrefix) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 211 11 8135540"); 
      resultMapping.columnPrefix = columnPrefix;
      return this;
    }

    public Builder flags(List<ResultFlag> flags) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 211 12 8135540"); 
      resultMapping.flags = flags;
      return this;
    }

    public Builder typeHandler(TypeHandler<?> typeHandler) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 211 13 8135540"); 
      resultMapping.typeHandler = typeHandler;
      return this;
    }

    public Builder composites(List<ResultMapping> composites) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 211 14 8135540"); 
      resultMapping.composites = composites;
      return this;
    }

    public Builder lazy(boolean lazy) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 211 15 8135540"); 
      resultMapping.lazy = lazy;
      return this;
    }
    
    public ResultMapping build() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 211 16 8135540"); 
      // lock down collections
      resultMapping.flags = Collections.unmodifiableList(resultMapping.flags);
      resultMapping.composites = Collections.unmodifiableList(resultMapping.composites);
      resolveTypeHandler();
      validate();
      return resultMapping;
    }

    private void validate() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 211 17 8135540"); 
      // Issue #697: cannot define both nestedQueryId and nestedResultMapId
      int zoa_cond_n18_0 = 2;
int zoa_cond_n18_1 = 2;
//zoa_cond_n18_0#resultMapping.nestedQueryId != null$zoa_cond_n18_1#resultMapping.nestedResultMapId != null
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 211 18 8135540")|| true) && ((resultMapping.nestedQueryId != null?(zoa_cond_n18_0 != (zoa_cond_n18_0 = 1)):(zoa_cond_n18_0 == (zoa_cond_n18_0 = 0))) && (resultMapping.nestedResultMapId != null?(zoa_cond_n18_1 != (zoa_cond_n18_1 = 1)):(zoa_cond_n18_1 == (zoa_cond_n18_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 211 2 0 1 2 ","8135540",true,zoa_cond_n18_0,zoa_cond_n18_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 211 2 0 0 2 ","8135540",false,zoa_cond_n18_0,zoa_cond_n18_1) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 211 19 8135540"); {
        throw new IllegalStateException("Cannot define both nestedQueryId and nestedResultMapId in property " + resultMapping.property);
      } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 211 20 8135540");
      // Issue #5: there should be no mappings without typehandler
      int zoa_cond_n21_0 = 2;
int zoa_cond_n21_1 = 2;
int zoa_cond_n21_2 = 2;
//zoa_cond_n21_0#resultMapping.nestedQueryId == null$zoa_cond_n21_1#resultMapping.nestedResultMapId == null$zoa_cond_n21_2#resultMapping.typeHandler == null
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 211 21 8135540")|| true) && ((resultMapping.nestedQueryId == null?(zoa_cond_n21_0 != (zoa_cond_n21_0 = 1)):(zoa_cond_n21_0 == (zoa_cond_n21_0 = 0))) && (resultMapping.nestedResultMapId == null?(zoa_cond_n21_1 != (zoa_cond_n21_1 = 1)):(zoa_cond_n21_1 == (zoa_cond_n21_1 = 0))) && (resultMapping.typeHandler == null?(zoa_cond_n21_2 != (zoa_cond_n21_2 = 1)):(zoa_cond_n21_2 == (zoa_cond_n21_2 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 211 6 1 1 3 ","8135540",true,zoa_cond_n21_0,zoa_cond_n21_1,zoa_cond_n21_2) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 211 6 1 0 3 ","8135540",false,zoa_cond_n21_0,zoa_cond_n21_1,zoa_cond_n21_2) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 211 22 8135540"); {
        throw new IllegalStateException("No typehandler found for property " + resultMapping.property);
      } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 211 23 8135540");
      // Issue #4 and GH #39: column is optional only in nested resultmaps but not in the rest
      int zoa_cond_n24_0 = 2;
int zoa_cond_n24_1 = 2;
int zoa_cond_n24_2 = 2;
//zoa_cond_n24_0#resultMapping.nestedResultMapId == null$zoa_cond_n24_1#resultMapping.column == null$zoa_cond_n24_2#resultMapping.composites.size() == 0
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 211 24 8135540")|| true) && ((resultMapping.nestedResultMapId == null?(zoa_cond_n24_0 != (zoa_cond_n24_0 = 1)):(zoa_cond_n24_0 == (zoa_cond_n24_0 = 0))) && (resultMapping.column == null?(zoa_cond_n24_1 != (zoa_cond_n24_1 = 1)):(zoa_cond_n24_1 == (zoa_cond_n24_1 = 0))) && (resultMapping.composites.size() == 0?(zoa_cond_n24_2 != (zoa_cond_n24_2 = 1)):(zoa_cond_n24_2 == (zoa_cond_n24_2 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 211 10 2 1 3 ","8135540",true,zoa_cond_n24_0,zoa_cond_n24_1,zoa_cond_n24_2) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 211 10 2 0 3 ","8135540",false,zoa_cond_n24_0,zoa_cond_n24_1,zoa_cond_n24_2) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 211 25 8135540"); {
        throw new IllegalStateException("Mapping is missing column attribute for property " + resultMapping.property);
      } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 211 26 8135540");
      if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 211 27 8135540")|| true) && (resultMapping.getResultSet() != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 211 11 3 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 211 11 3 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 211 28 8135540"); {
        int numColums = 0;
        if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 211 29 8135540")|| true) && (resultMapping.column != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 211 12 4 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 211 12 4 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 211 30 8135540"); {
          numColums = resultMapping.column.split(",").length;
        } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 211 31 8135540");
        int numForeignColumns = 0;
        if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 211 32 8135540")|| true) && (resultMapping.foreignColumn != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 211 13 5 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 211 13 5 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 211 33 8135540"); {
          numForeignColumns = resultMapping.foreignColumn.split(",").length;
        } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 211 34 8135540");
        if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 211 35 8135540")|| true) && (numColums != numForeignColumns? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 211 14 6 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 211 14 6 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 211 36 8135540"); {
          throw new IllegalStateException("There should be the same number of columns and foreignColumns in property " + resultMapping.property);
        } }
      } }
    }
    
    private void resolveTypeHandler() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 211 39 8135540"); 
      int zoa_cond_n40_0 = 2;
int zoa_cond_n40_1 = 2;
//zoa_cond_n40_0#resultMapping.typeHandler == null$zoa_cond_n40_1#resultMapping.javaType != null
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 211 40 8135540")|| true) && ((resultMapping.typeHandler == null?(zoa_cond_n40_0 != (zoa_cond_n40_0 = 1)):(zoa_cond_n40_0 == (zoa_cond_n40_0 = 0))) && (resultMapping.javaType != null?(zoa_cond_n40_1 != (zoa_cond_n40_1 = 1)):(zoa_cond_n40_1 == (zoa_cond_n40_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 211 17 7 1 2 ","8135540",true,zoa_cond_n40_0,zoa_cond_n40_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 211 17 7 0 2 ","8135540",false,zoa_cond_n40_0,zoa_cond_n40_1) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 211 41 8135540"); {
        Configuration configuration = resultMapping.configuration;
        TypeHandlerRegistry typeHandlerRegistry = configuration.getTypeHandlerRegistry();
        resultMapping.typeHandler = typeHandlerRegistry.getTypeHandler(resultMapping.javaType, resultMapping.jdbcType);
      } }
    }

    public Builder column(String column) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 211 43 8135540"); 
      resultMapping.column = column;
      return this;
    }
  }

  public String getProperty() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 211 44 8135540"); 
    return property;
  }

  public String getColumn() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 211 45 8135540"); 
    return column;
  }

  public Class<?> getJavaType() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 211 46 8135540"); 
    return javaType;
  }

  public JdbcType getJdbcType() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 211 47 8135540"); 
    return jdbcType;
  }

  public TypeHandler<?> getTypeHandler() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 211 48 8135540"); 
    return typeHandler;
  }

  public String getNestedResultMapId() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 211 49 8135540"); 
    return nestedResultMapId;
  }

  public String getNestedQueryId() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 211 50 8135540"); 
    return nestedQueryId;
  }

  public Set<String> getNotNullColumns() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 211 51 8135540"); 
    return notNullColumns;
  }

  public String getColumnPrefix() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 211 52 8135540"); 
    return columnPrefix;
  }

  public List<ResultFlag> getFlags() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 211 53 8135540"); 
    return flags;
  }

  public List<ResultMapping> getComposites() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 211 54 8135540"); 
    return composites;
  }

  public boolean isCompositeResult() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 211 55 8135540"); 
    return this.composites != null && !this.composites.isEmpty();
  }

  public String getResultSet() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 211 56 8135540"); 
    return this.resultSet;
  }

  public String getForeignColumn() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 211 57 8135540"); 
    return foreignColumn;
  }

  public void setForeignColumn(String foreignColumn) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 211 58 8135540"); 
    this.foreignColumn = foreignColumn;
  }

  public boolean isLazy() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 211 59 8135540"); 
    return lazy;
  }

  public void setLazy(boolean lazy) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 211 60 8135540"); 
    this.lazy = lazy;
  }
  
  @Override
  public boolean equals(Object o) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 211 61 8135540"); 
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 211 62 8135540")|| true) && (this == o? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 211 18 8 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 211 18 8 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 211 63 8135540"); {
      return true;
    } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 211 64 8135540");
    int zoa_cond_n65_0 = 2;
int zoa_cond_n65_1 = 2;
//zoa_cond_n65_0#o == null$zoa_cond_n65_1#getClass() != o.getClass()
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 211 65 8135540")|| true) && ((o == null?(zoa_cond_n65_0 != (zoa_cond_n65_0 = 1)):(zoa_cond_n65_0 == (zoa_cond_n65_0 = 0))) || (getClass() != o.getClass()?(zoa_cond_n65_1 != (zoa_cond_n65_1 = 1)):(zoa_cond_n65_1 == (zoa_cond_n65_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 211 21 9 1 2 ","8135540",true,zoa_cond_n65_0,zoa_cond_n65_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 211 21 9 0 2 ","8135540",false,zoa_cond_n65_0,zoa_cond_n65_1) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 211 66 8135540"); {
      return false;
    } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 211 67 8135540");

    ResultMapping that = (ResultMapping) o;

    int zoa_cond_n68_0 = 2;
int zoa_cond_n68_1 = 2;
//zoa_cond_n68_0#property == null$zoa_cond_n68_1#property.equals(that.property)
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 211 68 8135540")|| true) && ((property == null?(zoa_cond_n68_0 != (zoa_cond_n68_0 = 1)):(zoa_cond_n68_0 == (zoa_cond_n68_0 = 0))) || !(property.equals(that.property)?(zoa_cond_n68_1 != (zoa_cond_n68_1 = 1)):(zoa_cond_n68_1 == (zoa_cond_n68_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 211 24 10 1 2 ","8135540",true,zoa_cond_n68_0,zoa_cond_n68_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 211 24 10 0 2 ","8135540",false,zoa_cond_n68_0,zoa_cond_n68_1) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 211 69 8135540"); {
      return false;
    } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 211 70 8135540");

    return true;
  }

  @Override
  public int hashCode() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 211 71 8135540"); 
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 211 72 8135540")|| true) && (property != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 211 25 11 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 211 25 11 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 211 73 8135540"); {
      return property.hashCode();
    } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 211 74 8135540");  if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 211 75 8135540")|| true) && (column != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 211 26 12 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 211 26 12 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 211 76 8135540"); {
      return column.hashCode();
    } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 211 77 8135540");  {
      return 0;
    } } }
  }

}

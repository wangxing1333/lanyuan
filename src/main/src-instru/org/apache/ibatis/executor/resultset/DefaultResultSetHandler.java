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
package org.apache.ibatis.executor.resultset;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.apache.ibatis.cache.CacheKey;
import org.apache.ibatis.executor.ErrorContext;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.ExecutorException;
import org.apache.ibatis.executor.loader.ResultLoader;
import org.apache.ibatis.executor.loader.ResultLoaderMap;
import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.result.DefaultResultContext;
import org.apache.ibatis.executor.result.DefaultResultHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.Discriminator;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.mapping.ParameterMode;
import org.apache.ibatis.mapping.ResultMap;
import org.apache.ibatis.mapping.ResultMapping;
import org.apache.ibatis.reflection.MetaClass;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.factory.ObjectFactory;
import org.apache.ibatis.session.AutoMappingBehavior;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.type.TypeHandler;
import org.apache.ibatis.type.TypeHandlerRegistry;
/**
 * @author Clinton Begin
 * @author Eduardo Macarron
 */
import com.process.ZoaExp;
import com.process.ZoaThreadLocal;
public class DefaultResultSetHandler implements ResultSetHandler {

  private static final Object NO_VALUE = new Object();

  private final Executor executor;
  private final Configuration configuration;
  private final MappedStatement mappedStatement;
  private final RowBounds rowBounds;
  private final ParameterHandler parameterHandler;
  private final ResultHandler resultHandler;
  private final BoundSql boundSql;
  private final TypeHandlerRegistry typeHandlerRegistry;
  private final ObjectFactory objectFactory;

  // nested resultmaps
  private final Map<CacheKey, Object> nestedResultObjects = new HashMap<CacheKey, Object>();
  private final Map<CacheKey, Object> ancestorObjects = new HashMap<CacheKey, Object>();
  private final Map<String, String> ancestorColumnPrefix = new HashMap<String, String>();
  public static final String BATCHSAVE = ".BaseMapper.";
  // multiple resultsets
  private final Map<String, ResultMapping> nextResultMaps = new HashMap<String, ResultMapping>();
  private final Map<CacheKey, List<PendingRelation>> pendingRelations = new HashMap<CacheKey, List<PendingRelation>>();
  
  private static class PendingRelation {
    public MetaObject metaObject;
    public ResultMapping propertyMapping;
  }
  
  public DefaultResultSetHandler(Executor executor, MappedStatement mappedStatement, ParameterHandler parameterHandler, ResultHandler resultHandler, BoundSql boundSql,
      RowBounds rowBounds) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 157 0 8135540"); 
    this.executor = executor;
    this.configuration = mappedStatement.getConfiguration();
    this.mappedStatement = mappedStatement;
    this.rowBounds = rowBounds;
    this.parameterHandler = parameterHandler;
    this.boundSql = boundSql;
    this.typeHandlerRegistry = configuration.getTypeHandlerRegistry();
    this.objectFactory = configuration.getObjectFactory();
    this.resultHandler = resultHandler;
  }

  //
  // HANDLE OUTPUT PARAMETER
  //

  public void handleOutputParameters(CallableStatement cs) throws SQLException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 157 1 8135540"); 
    final Object parameterObject = parameterHandler.getParameterObject();
    final MetaObject metaParam = configuration.newMetaObject(parameterObject);
    final List<ParameterMapping> parameterMappings = boundSql.getParameterMappings();
    for (int i = 0; (ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 2 8135540")|| true) && (i < parameterMappings.size()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 0 0 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 0 0 0 0 ","8135540",false,0) && false)); i++){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 3 8135540"); {
      final ParameterMapping parameterMapping = parameterMappings.get(i);
      int zoa_cond_n4_0 = 2;
int zoa_cond_n4_1 = 2;
//zoa_cond_n4_0#parameterMapping.getMode() == ParameterMode.OUT$zoa_cond_n4_1#parameterMapping.getMode() == ParameterMode.INOUT
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 4 8135540")|| true) && ((parameterMapping.getMode() == ParameterMode.OUT?(zoa_cond_n4_0 != (zoa_cond_n4_0 = 1)):(zoa_cond_n4_0 == (zoa_cond_n4_0 = 0))) || (parameterMapping.getMode() == ParameterMode.INOUT?(zoa_cond_n4_1 != (zoa_cond_n4_1 = 1)):(zoa_cond_n4_1 == (zoa_cond_n4_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 3 1 1 2 ","8135540",true,zoa_cond_n4_0,zoa_cond_n4_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 3 1 0 2 ","8135540",false,zoa_cond_n4_0,zoa_cond_n4_1) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 5 8135540"); {
        if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 6 8135540")|| true) && (ResultSet.class.equals(parameterMapping.getJavaType())? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 4 2 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 4 2 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 7 8135540"); {
          handleRefCursorOutputParameter((ResultSet) cs.getObject(i + 1), parameterMapping, metaParam);
        } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 8 8135540");  {
          final TypeHandler<?> typeHandler = parameterMapping.getTypeHandler();
          metaParam.setValue(parameterMapping.getProperty(), typeHandler.getResult(cs, i + 1));
        } }
      } }
    }}
  }

  private void handleRefCursorOutputParameter(ResultSet rs, ParameterMapping parameterMapping, MetaObject metaParam) throws SQLException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 157 12 8135540"); 
    try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 13 8135540"); 
      final String resultMapId = parameterMapping.getResultMapId();
      final ResultMap resultMap = configuration.getResultMap(resultMapId);
      final DefaultResultHandler resultHandler = new DefaultResultHandler(objectFactory);
      final ResultSetWrapper rsw = new ResultSetWrapper(rs, configuration);
      handleRowValues(rsw, resultMap, resultHandler, new RowBounds(), null);
      metaParam.setValue(parameterMapping.getProperty(), resultHandler.getResultList());
    } finally {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 14 8135540"); 
      closeResultSet(rs); // issue #228 (close resultsets)
    }
  }

  //
  // HANDLE RESULT SETS
  //

  @SuppressWarnings({ "unchecked", "rawtypes" })
public List<Object> handleResultSets(Statement stmt) throws SQLException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 157 16 8135540"); 
    ErrorContext.instance().activity("handling results").object(mappedStatement.getId());
    
    final List<Object> multipleResults = new ArrayList<Object>();

    int resultSetCount = 0;
    ResultSetWrapper rsw = getFirstResultSet(stmt);

    List<ResultMap> resultMaps = mappedStatement.getResultMaps();
    int resultMapCount = resultMaps.size();
    validateResultMapsCount(rsw, resultMapCount);
    int zoa_cond_n17_0 = 2;
int zoa_cond_n17_1 = 2;
//zoa_cond_n17_0#rsw != null$zoa_cond_n17_1#resultMapCount > resultSetCount
while ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 17 8135540")|| true) && ((rsw != null?(zoa_cond_n17_0 != (zoa_cond_n17_0 = 1)):(zoa_cond_n17_0 == (zoa_cond_n17_0 = 0))) && (resultMapCount > resultSetCount?(zoa_cond_n17_1 != (zoa_cond_n17_1 = 1)):(zoa_cond_n17_1 == (zoa_cond_n17_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 7 3 1 2 ","8135540",true,zoa_cond_n17_0,zoa_cond_n17_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 7 3 0 2 ","8135540",false,zoa_cond_n17_0,zoa_cond_n17_1) && false))){zoa_cond_n17_0 = 2;
zoa_cond_n17_1 = 2;
 ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 18 8135540");  {
      ResultMap resultMap = resultMaps.get(resultSetCount);
      handleResultSet(rsw, resultMap, multipleResults, null);
      rsw = getNextResultSet(stmt);
      cleanUpAfterHandlingResultSet();
      resultSetCount++;
    }}ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 19 8135540"); 

    String[] resultSets = mappedStatement.getResulSets();
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 20 8135540")|| true) && (resultSets != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 8 4 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 8 4 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 21 8135540"); {
      int zoa_cond_n22_0 = 2;
int zoa_cond_n22_1 = 2;
//zoa_cond_n22_0#rsw != null$zoa_cond_n22_1#resultSetCount < resultSets.length
while ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 22 8135540")|| true) && ((rsw != null?(zoa_cond_n22_0 != (zoa_cond_n22_0 = 1)):(zoa_cond_n22_0 == (zoa_cond_n22_0 = 0))) && (resultSetCount < resultSets.length?(zoa_cond_n22_1 != (zoa_cond_n22_1 = 1)):(zoa_cond_n22_1 == (zoa_cond_n22_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 11 5 1 2 ","8135540",true,zoa_cond_n22_0,zoa_cond_n22_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 11 5 0 2 ","8135540",false,zoa_cond_n22_0,zoa_cond_n22_1) && false))){zoa_cond_n22_0 = 2;
zoa_cond_n22_1 = 2;
 ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 23 8135540");  {
        ResultMapping parentMapping = nextResultMaps.get(resultSets[resultSetCount]);
        if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 24 8135540")|| true) && (parentMapping != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 12 6 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 12 6 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 25 8135540"); {
          String nestedResultMapId = parentMapping.getNestedResultMapId();
          ResultMap resultMap = configuration.getResultMap(nestedResultMapId);
          handleResultSet(rsw, resultMap, null, parentMapping);
        } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 26 8135540");
        rsw = getNextResultSet(stmt);
        cleanUpAfterHandlingResultSet();
        resultSetCount++;
      }}
    } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 28 8135540");
    List<Object> lists = collapseSingleResultList(multipleResults);
    if((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 29 8135540")|| true) && (mappedStatement.getId().indexOf(BATCHSAVE)>-1? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 13 7 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 13 7 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 30 8135540");{
		try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 31 8135540"); 
		  List<Object> mlist = new ArrayList<Object>();
		    Object parameterObject = boundSql.getParameterObject();
		    Map map = (Map) parameterObject;
			Object o3 = null;
			if((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 32 8135540")|| true) && (null!=map? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 14 8 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 14 8 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 33 8135540");{
				o3=map.get("param3");
			} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 34 8135540");
			for (Object object : /* TRUE */lists){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 35 8135540");ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 36 8135540"); {
				Map<String, Object> m = (Map) object;
				Object o = null; 
				if((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 37 8135540")|| true) && (null!=o3? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 15 9 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 15 9 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 38 8135540");{
					Class fm = (Class) o3;
					o= fm.newInstance();
				} }else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 39 8135540"); {
					o = (Object) parameterObject.getClass().newInstance();
				} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 40 8135540");
				Map<String, Object> fmap = (Map<String, Object>) o;
				for (Entry<String, Object> entry : /* TRUE */m.entrySet()){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 41 8135540");ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 42 8135540"); {
					fmap.put(entry.getKey(), entry.getValue());
				}}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 43 8135540");
				mlist.add(o);
			}}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 44 8135540");
			 return mlist;
		} catch (Exception e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 45 8135540"); 
			e.printStackTrace();
		}
    	
    } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 47 8135540");
    return lists;
  }

  private ResultSetWrapper getFirstResultSet(Statement stmt) throws SQLException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 157 48 8135540"); 
    ResultSet rs = stmt.getResultSet();
    while ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 49 8135540")|| true) && (rs == null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 16 10 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 16 10 0 0 ","8135540",false,0) && false))){ ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 50 8135540");  {
      // move forward to get the first resultset in case the driver
      // doesn't return the resultset as the first result (HSQLDB 2.1)
      if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 51 8135540")|| true) && (stmt.getMoreResults()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 17 11 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 17 11 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 52 8135540"); {
        rs = stmt.getResultSet();
      } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 53 8135540");  {
        if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 54 8135540")|| true) && (stmt.getUpdateCount() == -1? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 18 12 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 18 12 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 55 8135540"); {
          // no more results. Must be no resultset
           break;
        } }
      } }
    }}ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 58 8135540"); 
    return rs != null ? new ResultSetWrapper(rs, configuration) : null;
  }

  private ResultSetWrapper getNextResultSet(Statement stmt) throws SQLException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 157 59 8135540"); 
    // Making this method tolerant of bad JDBC drivers
    try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 60 8135540"); 
      if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 61 8135540")|| true) && (stmt.getConnection().getMetaData().supportsMultipleResultSets()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 19 13 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 19 13 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 62 8135540"); {
        // Crazy Standard JDBC way of determining if there are more results
        int zoa_cond_n63_0 = 2;
int zoa_cond_n63_1 = 2;
//zoa_cond_n63_0#(!stmt.getMoreResults())$zoa_cond_n63_1#(stmt.getUpdateCount() == -1)
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 63 8135540")|| true) && (!(((!stmt.getMoreResults())?(zoa_cond_n63_0 != (zoa_cond_n63_0 = 1)):(zoa_cond_n63_0 == (zoa_cond_n63_0 = 0))) && ((stmt.getUpdateCount() == -1)?(zoa_cond_n63_1 != (zoa_cond_n63_1 = 1)):(zoa_cond_n63_1 == (zoa_cond_n63_1 = 0))))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 22 14 1 2 ","8135540",true,zoa_cond_n63_0,zoa_cond_n63_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 22 14 0 2 ","8135540",false,zoa_cond_n63_0,zoa_cond_n63_1) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 64 8135540"); {
          ResultSet rs = stmt.getResultSet();
          return rs != null ? new ResultSetWrapper(rs, configuration) : null;
        } }
      } }
    } catch (Exception e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 67 8135540"); 
      // Intentionally ignored.
    }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 68 8135540");
    return null;
  }

  private void closeResultSet(ResultSet rs) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 157 69 8135540"); 
    try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 70 8135540"); 
      if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 71 8135540")|| true) && (rs != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 23 15 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 23 15 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 72 8135540"); {
        rs.close();
      } }
    } catch (SQLException e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 74 8135540"); 
      // ignore
    }
  }

  private void cleanUpAfterHandlingResultSet() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 157 76 8135540"); 
    nestedResultObjects.clear();
    ancestorColumnPrefix.clear();
  }

  private void validateResultMapsCount(ResultSetWrapper rsw, int resultMapCount) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 157 77 8135540"); 
    int zoa_cond_n78_0 = 2;
int zoa_cond_n78_1 = 2;
//zoa_cond_n78_0#rsw != null$zoa_cond_n78_1#resultMapCount < 1
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 78 8135540")|| true) && ((rsw != null?(zoa_cond_n78_0 != (zoa_cond_n78_0 = 1)):(zoa_cond_n78_0 == (zoa_cond_n78_0 = 0))) && (resultMapCount < 1?(zoa_cond_n78_1 != (zoa_cond_n78_1 = 1)):(zoa_cond_n78_1 == (zoa_cond_n78_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 26 16 1 2 ","8135540",true,zoa_cond_n78_0,zoa_cond_n78_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 26 16 0 2 ","8135540",false,zoa_cond_n78_0,zoa_cond_n78_1) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 79 8135540"); {
      throw new ExecutorException("A query was run and no Result Maps were found for the Mapped Statement '" + mappedStatement.getId()
          + "'.  It's likely that neither a Result Type nor a Result Map was specified.");
    } }
  }

  private void handleResultSet(ResultSetWrapper rsw, ResultMap resultMap, List<Object> multipleResults, ResultMapping parentMapping) throws SQLException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 157 81 8135540"); 
    try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 82 8135540"); 
      if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 83 8135540")|| true) && (parentMapping != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 27 17 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 27 17 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 84 8135540"); {
        handleRowValues(rsw, resultMap, null, RowBounds.DEFAULT, parentMapping);
      } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 85 8135540");  {
        if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 86 8135540")|| true) && (resultHandler == null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 28 18 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 28 18 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 87 8135540"); {
          DefaultResultHandler defaultResultHandler = new DefaultResultHandler(objectFactory);
          handleRowValues(rsw, resultMap, defaultResultHandler, rowBounds, null);
          multipleResults.add(defaultResultHandler.getResultList());
        } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 88 8135540");  {
          handleRowValues(rsw, resultMap, resultHandler, rowBounds, null);
        } }
      } }
    } finally {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 91 8135540"); 
      closeResultSet(rsw.getResultSet()); // issue #228 (close resultsets)
    }
  }

  private List<Object> collapseSingleResultList(List<Object> multipleResults) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 157 93 8135540"); 
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 94 8135540")|| true) && (multipleResults.size() == 1? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 29 19 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 29 19 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 95 8135540"); {
      @SuppressWarnings("unchecked")
      List<Object> returned = (List<Object>) multipleResults.get(0);
      return returned;
    } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 96 8135540");
    return multipleResults;
  }

  //
  // HANDLE ROWS FOR SIMPLE RESULTMAP
  //

  private void handleRowValues(ResultSetWrapper rsw, ResultMap resultMap, ResultHandler resultHandler, RowBounds rowBounds, ResultMapping parentMapping) throws SQLException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 157 97 8135540"); 
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 98 8135540")|| true) && (resultMap.hasNestedResultMaps()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 30 20 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 30 20 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 99 8135540"); {
      ensureNoRowBounds();
      checkResultHandler();
      handleRowValuesForNestedResultMap(rsw, resultMap, resultHandler, rowBounds, parentMapping);
    } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 100 8135540");  {
      handleRowValuesForSimpleResultMap(rsw, resultMap, resultHandler, rowBounds, parentMapping);
    } }
  }  

  private void ensureNoRowBounds() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 157 102 8135540"); 
    int zoa_cond_n103_0 = 2;
int zoa_cond_n103_1 = 2;
int zoa_cond_n103_2 = 2;
int zoa_cond_n103_3 = 2;
int zoa_cond_n103_4 = 6;
//zoa_cond_n103_0#configuration.isSafeRowBoundsEnabled()$zoa_cond_n103_1#rowBounds != null$zoa_cond_n103_2#rowBounds.getLimit() < RowBounds.NO_ROW_LIMIT$zoa_cond_n103_3#rowBounds.getOffset() > RowBounds.NO_ROW_OFFSET$zoa_cond_n103_4#rowBounds.getLimit() < RowBounds.NO_ROW_LIMIT || rowBounds.getOffset() > RowBounds.NO_ROW_OFFSET
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 103 8135540")|| true) && ((configuration.isSafeRowBoundsEnabled()?(zoa_cond_n103_0 != (zoa_cond_n103_0 = 1)):(zoa_cond_n103_0 == (zoa_cond_n103_0 = 0))) && (rowBounds != null?(zoa_cond_n103_1 != (zoa_cond_n103_1 = 1)):(zoa_cond_n103_1 == (zoa_cond_n103_1 = 0))) && ((rowBounds.getLimit() < RowBounds.NO_ROW_LIMIT?(zoa_cond_n103_2 != (zoa_cond_n103_2 = 1)):(zoa_cond_n103_2 == (zoa_cond_n103_2 = 0))) || (rowBounds.getOffset() > RowBounds.NO_ROW_OFFSET?(zoa_cond_n103_3 != (zoa_cond_n103_3 = 1)):(zoa_cond_n103_3 == (zoa_cond_n103_3 = 0)))?(zoa_cond_n103_4 != (zoa_cond_n103_4 = 5)):(zoa_cond_n103_4 == (zoa_cond_n103_4 = 4)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 36 21 1 5 ","8135540",true,zoa_cond_n103_0,zoa_cond_n103_1,zoa_cond_n103_2,zoa_cond_n103_3,zoa_cond_n103_4) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 36 21 0 5 ","8135540",false,zoa_cond_n103_0,zoa_cond_n103_1,zoa_cond_n103_2,zoa_cond_n103_3,zoa_cond_n103_4) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 104 8135540"); {
      throw new ExecutorException("Mapped Statements with nested result mappings cannot be safely constrained by RowBounds. "
          + "Use safeRowBoundsEnabled=false setting to bypass this check.");
    } }
  }

  protected void checkResultHandler() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 157 106 8135540"); 
    int zoa_cond_n107_0 = 2;
int zoa_cond_n107_1 = 2;
int zoa_cond_n107_2 = 2;
//zoa_cond_n107_0#resultHandler != null$zoa_cond_n107_1#configuration.isSafeResultHandlerEnabled()$zoa_cond_n107_2#mappedStatement.isResultOrdered()
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 107 8135540")|| true) && ((resultHandler != null?(zoa_cond_n107_0 != (zoa_cond_n107_0 = 1)):(zoa_cond_n107_0 == (zoa_cond_n107_0 = 0))) && (configuration.isSafeResultHandlerEnabled()?(zoa_cond_n107_1 != (zoa_cond_n107_1 = 1)):(zoa_cond_n107_1 == (zoa_cond_n107_1 = 0))) && !(mappedStatement.isResultOrdered()?(zoa_cond_n107_2 != (zoa_cond_n107_2 = 1)):(zoa_cond_n107_2 == (zoa_cond_n107_2 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 40 22 1 3 ","8135540",true,zoa_cond_n107_0,zoa_cond_n107_1,zoa_cond_n107_2) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 40 22 0 3 ","8135540",false,zoa_cond_n107_0,zoa_cond_n107_1,zoa_cond_n107_2) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 108 8135540"); {
      throw new ExecutorException("Mapped Statements with nested result mappings cannot be safely used with a custom ResultHandler. "
          + "Use safeResultHandlerEnabled=false setting to bypass this check " 
          + "or ensure your statement returns ordered data and set resultOrdered=true on it.");
    } }
  } 

  private void handleRowValuesForSimpleResultMap(ResultSetWrapper rsw, ResultMap resultMap, ResultHandler resultHandler, RowBounds rowBounds, ResultMapping parentMapping)
      throws SQLException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 157 110 8135540"); 
    DefaultResultContext resultContext = new DefaultResultContext();
    skipRows(rsw.getResultSet(), rowBounds);
    int zoa_cond_n111_0 = 2;
int zoa_cond_n111_1 = 2;
//zoa_cond_n111_0#shouldProcessMoreRows(resultContext, rowBounds)$zoa_cond_n111_1#rsw.getResultSet().next()
while ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 111 8135540")|| true) && ((shouldProcessMoreRows(resultContext, rowBounds)?(zoa_cond_n111_0 != (zoa_cond_n111_0 = 1)):(zoa_cond_n111_0 == (zoa_cond_n111_0 = 0))) && (rsw.getResultSet().next()?(zoa_cond_n111_1 != (zoa_cond_n111_1 = 1)):(zoa_cond_n111_1 == (zoa_cond_n111_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 43 23 1 2 ","8135540",true,zoa_cond_n111_0,zoa_cond_n111_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 43 23 0 2 ","8135540",false,zoa_cond_n111_0,zoa_cond_n111_1) && false))){zoa_cond_n111_0 = 2;
zoa_cond_n111_1 = 2;
 ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 112 8135540");  {
      ResultMap discriminatedResultMap = resolveDiscriminatedResultMap(rsw.getResultSet(), resultMap, null);
      Object rowValue = getRowValue(rsw, discriminatedResultMap);
      storeObject(resultHandler, resultContext, rowValue, parentMapping, rsw.getResultSet());
    }}
  }

  private void storeObject(ResultHandler resultHandler, DefaultResultContext resultContext, Object rowValue, ResultMapping parentMapping, ResultSet rs) throws SQLException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 157 114 8135540"); 
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 115 8135540")|| true) && (parentMapping != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 44 24 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 44 24 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 116 8135540"); {
      linkToParents(rs, parentMapping, rowValue);
    } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 117 8135540");  {
      callResultHandler(resultHandler, resultContext, rowValue);
    } }
  }

  private void callResultHandler(ResultHandler resultHandler, DefaultResultContext resultContext, Object rowValue) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 157 119 8135540"); 
    resultContext.nextResultObject(rowValue);
    resultHandler.handleResult(resultContext);
  }

  private boolean shouldProcessMoreRows(ResultContext context, RowBounds rowBounds) throws SQLException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 157 120 8135540"); 
    return !context.isStopped() && context.getResultCount() < rowBounds.getLimit();
  }

  private void skipRows(ResultSet rs, RowBounds rowBounds) throws SQLException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 157 121 8135540"); 
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 122 8135540")|| true) && (rs.getType() != ResultSet.TYPE_FORWARD_ONLY? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 45 25 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 45 25 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 123 8135540"); {
      if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 124 8135540")|| true) && (rowBounds.getOffset() != RowBounds.NO_ROW_OFFSET? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 46 26 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 46 26 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 125 8135540"); {
        rs.absolute(rowBounds.getOffset());
      } }
    } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 127 8135540");  {
      for (int i = 0; (ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 128 8135540")|| true) && (i < rowBounds.getOffset()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 47 27 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 47 27 0 0 ","8135540",false,0) && false)); i++){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 129 8135540"); {
        rs.next();
      }}
    } }
  }

  //
  // GET VALUE FROM ROW FOR SIMPLE RESULT MAP
  //

  private Object getRowValue(ResultSetWrapper rsw, ResultMap resultMap) throws SQLException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 157 132 8135540"); 
    final ResultLoaderMap lazyLoader = new ResultLoaderMap();
    Object resultObject = createResultObject(rsw, resultMap, lazyLoader, null);
    int zoa_cond_n133_0 = 2;
int zoa_cond_n133_1 = 2;
//zoa_cond_n133_0#resultObject != null$zoa_cond_n133_1#typeHandlerRegistry.hasTypeHandler(resultMap.getType())
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 133 8135540")|| true) && ((resultObject != null?(zoa_cond_n133_0 != (zoa_cond_n133_0 = 1)):(zoa_cond_n133_0 == (zoa_cond_n133_0 = 0))) && !(typeHandlerRegistry.hasTypeHandler(resultMap.getType())?(zoa_cond_n133_1 != (zoa_cond_n133_1 = 1)):(zoa_cond_n133_1 == (zoa_cond_n133_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 50 28 1 2 ","8135540",true,zoa_cond_n133_0,zoa_cond_n133_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 50 28 0 2 ","8135540",false,zoa_cond_n133_0,zoa_cond_n133_1) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 134 8135540"); {
      final MetaObject metaObject = configuration.newMetaObject(resultObject);
      boolean foundValues = resultMap.getConstructorResultMappings().size() > 0;
      if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 135 8135540")|| true) && (shouldApplyAutomaticMappings(resultMap, !AutoMappingBehavior.NONE.equals(configuration.getAutoMappingBehavior()))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 51 29 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 51 29 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 136 8135540"); {        
        foundValues = applyAutomaticMappings(rsw, resultMap, metaObject, null) || foundValues;
      } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 137 8135540");
      foundValues = applyPropertyMappings(rsw, resultMap, metaObject, lazyLoader, null) || foundValues;
      foundValues = lazyLoader.size() > 0 || foundValues;
      resultObject = foundValues ? resultObject : null;
      return resultObject;
    } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 138 8135540");
    return resultObject;
  }

  private boolean shouldApplyAutomaticMappings(ResultMap resultMap, boolean def) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 157 139 8135540"); 
    return resultMap.getAutoMapping() != null ? resultMap.getAutoMapping() : def;
  }

  //
  // PROPERTY MAPPINGS
  //

  private boolean applyPropertyMappings(ResultSetWrapper rsw, ResultMap resultMap, MetaObject metaObject, ResultLoaderMap lazyLoader, String columnPrefix)
      throws SQLException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 157 140 8135540"); 
    final List<String> mappedColumnNames = rsw.getMappedColumnNames(resultMap, columnPrefix);
    boolean foundValues = false;
    final List<ResultMapping> propertyMappings = resultMap.getPropertyResultMappings();
    for (ResultMapping propertyMapping : /* TRUE */propertyMappings){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 141 8135540");ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 142 8135540"); {
      final String column = prependPrefix(propertyMapping.getColumn(), columnPrefix);
      int zoa_cond_n143_0 = 2;
int zoa_cond_n143_1 = 2;
int zoa_cond_n143_2 = 2;
int zoa_cond_n143_3 = 6;
int zoa_cond_n143_4 = 2;
//zoa_cond_n143_0#propertyMapping.isCompositeResult()$zoa_cond_n143_1#column != null$zoa_cond_n143_2#mappedColumnNames.contains(column.toUpperCase(Locale.ENGLISH))$zoa_cond_n143_3#column != null && mappedColumnNames.contains(column.toUpperCase(Locale.ENGLISH))$zoa_cond_n143_4#propertyMapping.getResultSet() != null
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 143 8135540")|| true) && ((propertyMapping.isCompositeResult()?(zoa_cond_n143_0 != (zoa_cond_n143_0 = 1)):(zoa_cond_n143_0 == (zoa_cond_n143_0 = 0))) 
          || ((column != null?(zoa_cond_n143_1 != (zoa_cond_n143_1 = 1)):(zoa_cond_n143_1 == (zoa_cond_n143_1 = 0))) && (mappedColumnNames.contains(column.toUpperCase(Locale.ENGLISH))?(zoa_cond_n143_2 != (zoa_cond_n143_2 = 1)):(zoa_cond_n143_2 == (zoa_cond_n143_2 = 0)))?(zoa_cond_n143_3 != (zoa_cond_n143_3 = 5)):(zoa_cond_n143_3 == (zoa_cond_n143_3 = 4))) 
          || (propertyMapping.getResultSet() != null?(zoa_cond_n143_4 != (zoa_cond_n143_4 = 1)):(zoa_cond_n143_4 == (zoa_cond_n143_4 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 57 30 1 5 ","8135540",true,zoa_cond_n143_0,zoa_cond_n143_1,zoa_cond_n143_2,zoa_cond_n143_3,zoa_cond_n143_4) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 57 30 0 5 ","8135540",false,zoa_cond_n143_0,zoa_cond_n143_1,zoa_cond_n143_2,zoa_cond_n143_3,zoa_cond_n143_4) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 144 8135540"); {
        Object value = getPropertyMappingValue(rsw.getResultSet(), metaObject, propertyMapping, lazyLoader, columnPrefix);
        final String property = propertyMapping.getProperty(); // issue #541 make property optional
        int zoa_cond_n145_0 = 2;
int zoa_cond_n145_1 = 2;
int zoa_cond_n145_2 = 2;
int zoa_cond_n145_3 = 2;
int zoa_cond_n145_4 = 6;
//zoa_cond_n145_0#value != NO_VALUE$zoa_cond_n145_1#property != null$zoa_cond_n145_2#value != null$zoa_cond_n145_3#configuration.isCallSettersOnNulls()$zoa_cond_n145_4#value != null || configuration.isCallSettersOnNulls()
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 145 8135540")|| true) && ((value != NO_VALUE?(zoa_cond_n145_0 != (zoa_cond_n145_0 = 1)):(zoa_cond_n145_0 == (zoa_cond_n145_0 = 0))) && (property != null?(zoa_cond_n145_1 != (zoa_cond_n145_1 = 1)):(zoa_cond_n145_1 == (zoa_cond_n145_1 = 0))) && ((value != null?(zoa_cond_n145_2 != (zoa_cond_n145_2 = 1)):(zoa_cond_n145_2 == (zoa_cond_n145_2 = 0))) || (configuration.isCallSettersOnNulls()?(zoa_cond_n145_3 != (zoa_cond_n145_3 = 1)):(zoa_cond_n145_3 == (zoa_cond_n145_3 = 0)))?(zoa_cond_n145_4 != (zoa_cond_n145_4 = 5)):(zoa_cond_n145_4 == (zoa_cond_n145_4 = 4)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 63 31 1 5 ","8135540",true,zoa_cond_n145_0,zoa_cond_n145_1,zoa_cond_n145_2,zoa_cond_n145_3,zoa_cond_n145_4) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 63 31 0 5 ","8135540",false,zoa_cond_n145_0,zoa_cond_n145_1,zoa_cond_n145_2,zoa_cond_n145_3,zoa_cond_n145_4) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 146 8135540"); { // issue #377, call setter on nulls
          int zoa_cond_n147_0 = 2;
int zoa_cond_n147_1 = 2;
//zoa_cond_n147_0#value != null$zoa_cond_n147_1#metaObject.getSetterType(property).isPrimitive()
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 147 8135540")|| true) && ((value != null?(zoa_cond_n147_0 != (zoa_cond_n147_0 = 1)):(zoa_cond_n147_0 == (zoa_cond_n147_0 = 0))) || !(metaObject.getSetterType(property).isPrimitive()?(zoa_cond_n147_1 != (zoa_cond_n147_1 = 1)):(zoa_cond_n147_1 == (zoa_cond_n147_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 66 32 1 2 ","8135540",true,zoa_cond_n147_0,zoa_cond_n147_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 66 32 0 2 ","8135540",false,zoa_cond_n147_0,zoa_cond_n147_1) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 148 8135540"); {
            metaObject.setValue(property, value);
          } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 149 8135540");
          foundValues = true;
        } }
      } }
    }}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 152 8135540");
    return foundValues;
  }

  private Object getPropertyMappingValue(ResultSet rs, MetaObject metaResultObject, ResultMapping propertyMapping, ResultLoaderMap lazyLoader, String columnPrefix)
      throws SQLException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 157 153 8135540"); 
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 154 8135540")|| true) && (propertyMapping.getNestedQueryId() != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 67 33 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 67 33 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 155 8135540"); {
      return getNestedQueryMappingValue(rs, metaResultObject, propertyMapping, lazyLoader, columnPrefix);
    } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 156 8135540");  if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 157 8135540")|| true) && (propertyMapping.getResultSet() != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 68 34 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 68 34 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 158 8135540"); {
      addPendingChildRelation(rs, metaResultObject, propertyMapping);
      return NO_VALUE;
    } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 159 8135540");  if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 160 8135540")|| true) && (propertyMapping.getNestedResultMapId() != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 69 35 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 69 35 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 161 8135540"); {
      // the user added a column attribute to a nested result map, ignore it
      return NO_VALUE;
    } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 162 8135540");  {
      final TypeHandler<?> typeHandler = propertyMapping.getTypeHandler();
      final String column = prependPrefix(propertyMapping.getColumn(), columnPrefix);
      return typeHandler.getResult(rs, column);
    } } } }
  }

  private boolean applyAutomaticMappings(ResultSetWrapper rsw, ResultMap resultMap, MetaObject metaObject, String columnPrefix) throws SQLException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 157 166 8135540"); 
    final List<String> unmappedColumnNames = rsw.getUnmappedColumnNames(resultMap, columnPrefix);
    boolean foundValues = false;
    for (String columnName : /* TRUE */unmappedColumnNames){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 167 8135540");ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 168 8135540"); {
      String propertyName = columnName;
      int zoa_cond_n169_0 = 2;
int zoa_cond_n169_1 = 2;
//zoa_cond_n169_0#columnPrefix != null$zoa_cond_n169_1#columnPrefix.length() > 0
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 169 8135540")|| true) && ((columnPrefix != null?(zoa_cond_n169_0 != (zoa_cond_n169_0 = 1)):(zoa_cond_n169_0 == (zoa_cond_n169_0 = 0))) && (columnPrefix.length() > 0?(zoa_cond_n169_1 != (zoa_cond_n169_1 = 1)):(zoa_cond_n169_1 == (zoa_cond_n169_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 72 36 1 2 ","8135540",true,zoa_cond_n169_0,zoa_cond_n169_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 72 36 0 2 ","8135540",false,zoa_cond_n169_0,zoa_cond_n169_1) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 170 8135540"); {
        // When columnPrefix is specified,
        // ignore columns without the prefix.
        if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 171 8135540")|| true) && (columnName.toUpperCase(Locale.ENGLISH).startsWith(columnPrefix)? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 73 37 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 73 37 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 172 8135540"); {
          propertyName = columnName.substring(columnPrefix.length());
        } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 173 8135540");  {
          continue;
        } }
      } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 175 8135540");
      final String property = metaObject.findProperty(propertyName, configuration.isMapUnderscoreToCamelCase());
      int zoa_cond_n176_0 = 2;
int zoa_cond_n176_1 = 2;
//zoa_cond_n176_0#property != null$zoa_cond_n176_1#metaObject.hasSetter(property)
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 176 8135540")|| true) && ((property != null?(zoa_cond_n176_0 != (zoa_cond_n176_0 = 1)):(zoa_cond_n176_0 == (zoa_cond_n176_0 = 0))) && (metaObject.hasSetter(property)?(zoa_cond_n176_1 != (zoa_cond_n176_1 = 1)):(zoa_cond_n176_1 == (zoa_cond_n176_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 76 38 1 2 ","8135540",true,zoa_cond_n176_0,zoa_cond_n176_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 76 38 0 2 ","8135540",false,zoa_cond_n176_0,zoa_cond_n176_1) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 177 8135540"); {
        final Class<?> propertyType = metaObject.getSetterType(property);
        if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 178 8135540")|| true) && (typeHandlerRegistry.hasTypeHandler(propertyType)? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 77 39 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 77 39 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 179 8135540"); {
          final TypeHandler<?> typeHandler = rsw.getTypeHandler(propertyType, columnName);
          final Object value = typeHandler.getResult(rsw.getResultSet(), columnName);
          int zoa_cond_n180_0 = 2;
int zoa_cond_n180_1 = 2;
//zoa_cond_n180_0#value != null$zoa_cond_n180_1#configuration.isCallSettersOnNulls()
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 180 8135540")|| true) && ((value != null?(zoa_cond_n180_0 != (zoa_cond_n180_0 = 1)):(zoa_cond_n180_0 == (zoa_cond_n180_0 = 0))) || (configuration.isCallSettersOnNulls()?(zoa_cond_n180_1 != (zoa_cond_n180_1 = 1)):(zoa_cond_n180_1 == (zoa_cond_n180_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 80 40 1 2 ","8135540",true,zoa_cond_n180_0,zoa_cond_n180_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 80 40 0 2 ","8135540",false,zoa_cond_n180_0,zoa_cond_n180_1) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 181 8135540"); { // issue #377, call setter on nulls
            int zoa_cond_n182_0 = 2;
int zoa_cond_n182_1 = 2;
//zoa_cond_n182_0#value != null$zoa_cond_n182_1#propertyType.isPrimitive()
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 182 8135540")|| true) && ((value != null?(zoa_cond_n182_0 != (zoa_cond_n182_0 = 1)):(zoa_cond_n182_0 == (zoa_cond_n182_0 = 0))) || !(propertyType.isPrimitive()?(zoa_cond_n182_1 != (zoa_cond_n182_1 = 1)):(zoa_cond_n182_1 == (zoa_cond_n182_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 83 41 1 2 ","8135540",true,zoa_cond_n182_0,zoa_cond_n182_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 83 41 0 2 ","8135540",false,zoa_cond_n182_0,zoa_cond_n182_1) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 183 8135540"); {
              metaObject.setValue(property, value);
            } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 184 8135540");
            foundValues = true;
          } }
        } }
      } }
    }}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 188 8135540");
    return foundValues;
  }

  // MULTIPLE RESULT SETS

  private void linkToParents(ResultSet rs, ResultMapping parentMapping, Object rowValue) throws SQLException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 157 189 8135540"); 
    CacheKey parentKey = createKeyForMultipleResults(rs, parentMapping, parentMapping.getColumn(), parentMapping.getForeignColumn());
    List<PendingRelation> parents = pendingRelations.get(parentKey);
    for (PendingRelation parent : /* TRUE */parents){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 190 8135540");ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 191 8135540"); {
      if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 192 8135540")|| true) && (parent != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 84 42 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 84 42 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 193 8135540"); {
        final Object collectionProperty = instantiateCollectionPropertyIfAppropriate(parent.propertyMapping, parent.metaObject);
        if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 194 8135540")|| true) && (rowValue != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 85 43 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 85 43 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 195 8135540"); {
          if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 196 8135540")|| true) && (collectionProperty != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 86 44 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 86 44 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 197 8135540"); {
            final MetaObject targetMetaObject = configuration.newMetaObject(collectionProperty);
            targetMetaObject.add(rowValue);
          } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 198 8135540");  {
            parent.metaObject.setValue(parent.propertyMapping.getProperty(), rowValue);
          } }
        } }
      } }
    }}
  }

  private Object instantiateCollectionPropertyIfAppropriate(ResultMapping resultMapping, MetaObject metaObject) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 157 203 8135540"); 
    final String propertyName = resultMapping.getProperty();
    Object propertyValue = metaObject.getValue(propertyName);
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 204 8135540")|| true) && (propertyValue == null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 87 45 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 87 45 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 205 8135540"); {
      Class<?> type = resultMapping.getJavaType();
      if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 206 8135540")|| true) && (type == null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 88 46 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 88 46 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 207 8135540"); {
        type = metaObject.getSetterType(propertyName);
      } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 208 8135540");
      try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 209 8135540"); 
        if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 210 8135540")|| true) && (objectFactory.isCollection(type)? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 89 47 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 89 47 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 211 8135540"); {
          propertyValue = objectFactory.create(type);
          metaObject.setValue(propertyName, propertyValue);
          return propertyValue;
        } }
      } catch (Exception e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 213 8135540"); 
        throw new ExecutorException("Error instantiating collection property for result '" + resultMapping.getProperty() + "'.  Cause: " + e, e);
      }
    } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 215 8135540");  if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 216 8135540")|| true) && (objectFactory.isCollection(propertyValue.getClass())? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 90 48 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 90 48 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 217 8135540"); {
      return propertyValue;
    } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 218 8135540"); }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 219 8135540");
    return null;
  }

  private void addPendingChildRelation(ResultSet rs, MetaObject metaResultObject, ResultMapping parentMapping) throws SQLException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 157 220 8135540"); 
    CacheKey cacheKey = createKeyForMultipleResults(rs, parentMapping, parentMapping.getColumn(), parentMapping.getColumn());
    PendingRelation deferLoad = new PendingRelation();
    deferLoad.metaObject = metaResultObject;
    deferLoad.propertyMapping = parentMapping;
    List<PendingRelation> relations = pendingRelations.get(cacheKey);
    // issue #255
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 221 8135540")|| true) && (relations == null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 91 49 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 91 49 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 222 8135540"); {
      relations = new ArrayList<DefaultResultSetHandler.PendingRelation>();
      pendingRelations.put(cacheKey, relations);
    } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 223 8135540");
    relations.add(deferLoad);
    ResultMapping previous = nextResultMaps.get(parentMapping.getResultSet());
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 224 8135540")|| true) && (previous == null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 92 50 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 92 50 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 225 8135540"); {
      nextResultMaps.put(parentMapping.getResultSet(), parentMapping);
    } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 226 8135540");  {
      if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 227 8135540")|| true) && (!previous.equals(parentMapping)? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 93 51 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 93 51 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 228 8135540"); {
        throw new ExecutorException("Two different properties are mapped to the same resultSet");
      } }
    } }
  }

  private CacheKey createKeyForMultipleResults(ResultSet rs, ResultMapping resultMapping, String names, String columns) throws SQLException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 157 231 8135540"); 
    CacheKey cacheKey = new CacheKey();
    cacheKey.update(resultMapping);
    int zoa_cond_n232_0 = 2;
int zoa_cond_n232_1 = 2;
//zoa_cond_n232_0#columns != null$zoa_cond_n232_1#names != null
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 232 8135540")|| true) && ((columns != null?(zoa_cond_n232_0 != (zoa_cond_n232_0 = 1)):(zoa_cond_n232_0 == (zoa_cond_n232_0 = 0))) && (names != null?(zoa_cond_n232_1 != (zoa_cond_n232_1 = 1)):(zoa_cond_n232_1 == (zoa_cond_n232_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 96 52 1 2 ","8135540",true,zoa_cond_n232_0,zoa_cond_n232_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 96 52 0 2 ","8135540",false,zoa_cond_n232_0,zoa_cond_n232_1) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 233 8135540"); {
      String[] columnsArray = columns.split(",");
      String[] namesArray = names.split(",");
      for (int i = 0 ; (ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 234 8135540")|| true) && (i < columnsArray.length? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 97 53 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 97 53 0 0 ","8135540",false,0) && false)) ; i++){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 235 8135540"); {
        Object value = rs.getString(columnsArray[i]);
        if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 236 8135540")|| true) && (value != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 98 54 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 98 54 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 237 8135540"); {
          cacheKey.update(namesArray[i]);
          cacheKey.update(value);
        } }
      }}
    } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 240 8135540");
    return cacheKey;
  }

  //
  // INSTANTIATION & CONSTRUCTOR MAPPING
  //

  private Object createResultObject(ResultSetWrapper rsw, ResultMap resultMap, ResultLoaderMap lazyLoader, String columnPrefix) throws SQLException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 157 241 8135540"); 
    final List<Class<?>> constructorArgTypes = new ArrayList<Class<?>>();
    final List<Object> constructorArgs = new ArrayList<Object>();
    final Object resultObject = createResultObject(rsw, resultMap, constructorArgTypes, constructorArgs, columnPrefix);
    int zoa_cond_n242_0 = 2;
int zoa_cond_n242_1 = 2;
//zoa_cond_n242_0#resultObject != null$zoa_cond_n242_1#typeHandlerRegistry.hasTypeHandler(resultMap.getType())
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 242 8135540")|| true) && ((resultObject != null?(zoa_cond_n242_0 != (zoa_cond_n242_0 = 1)):(zoa_cond_n242_0 == (zoa_cond_n242_0 = 0))) && !(typeHandlerRegistry.hasTypeHandler(resultMap.getType())?(zoa_cond_n242_1 != (zoa_cond_n242_1 = 1)):(zoa_cond_n242_1 == (zoa_cond_n242_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 101 55 1 2 ","8135540",true,zoa_cond_n242_0,zoa_cond_n242_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 101 55 0 2 ","8135540",false,zoa_cond_n242_0,zoa_cond_n242_1) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 243 8135540"); {
      final List<ResultMapping> propertyMappings = resultMap.getPropertyResultMappings();
      for (ResultMapping propertyMapping : /* TRUE */propertyMappings){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 244 8135540");ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 245 8135540"); {
        int zoa_cond_n246_0 = 2;
int zoa_cond_n246_1 = 2;
//zoa_cond_n246_0#propertyMapping.getNestedQueryId() != null$zoa_cond_n246_1#propertyMapping.isLazy()
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 246 8135540")|| true) && ((propertyMapping.getNestedQueryId() != null?(zoa_cond_n246_0 != (zoa_cond_n246_0 = 1)):(zoa_cond_n246_0 == (zoa_cond_n246_0 = 0))) && (propertyMapping.isLazy()?(zoa_cond_n246_1 != (zoa_cond_n246_1 = 1)):(zoa_cond_n246_1 == (zoa_cond_n246_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 104 56 1 2 ","8135540",true,zoa_cond_n246_0,zoa_cond_n246_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 104 56 0 2 ","8135540",false,zoa_cond_n246_0,zoa_cond_n246_1) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 247 8135540"); { // issue gcode #109 && issue #149
          return configuration.getProxyFactory().createProxy(resultObject, lazyLoader, configuration, objectFactory, constructorArgTypes, constructorArgs);
        } }
      }}
    } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 250 8135540");
    return resultObject;
  }

  private Object createResultObject(ResultSetWrapper rsw, ResultMap resultMap, List<Class<?>> constructorArgTypes, List<Object> constructorArgs, String columnPrefix)
      throws SQLException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 157 251 8135540"); 
    final Class<?> resultType = resultMap.getType();
    final List<ResultMapping> constructorMappings = resultMap.getConstructorResultMappings();
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 252 8135540")|| true) && (typeHandlerRegistry.hasTypeHandler(resultType)? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 105 57 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 105 57 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 253 8135540"); {
      return createPrimitiveResultObject(rsw, resultMap, columnPrefix);
    } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 254 8135540");  if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 255 8135540")|| true) && (constructorMappings.size() > 0? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 106 58 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 106 58 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 256 8135540"); {
      return createParameterizedResultObject(rsw, resultType, constructorMappings, constructorArgTypes, constructorArgs, columnPrefix);
    } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 257 8135540");  {
      return objectFactory.create(resultType);
    } } }
  }

  private Object createParameterizedResultObject(ResultSetWrapper rsw, Class<?> resultType, List<ResultMapping> constructorMappings, List<Class<?>> constructorArgTypes,
      List<Object> constructorArgs, String columnPrefix) throws SQLException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 157 260 8135540"); 
    boolean foundValues = false;
    for (ResultMapping constructorMapping : /* TRUE */constructorMappings){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 261 8135540");ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 262 8135540"); {
      final Class<?> parameterType = constructorMapping.getJavaType();
      final String column = constructorMapping.getColumn();
      final Object value;
      if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 263 8135540")|| true) && (constructorMapping.getNestedQueryId() != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 107 59 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 107 59 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 264 8135540"); {
        value = getNestedQueryConstructorValue(rsw.getResultSet(), constructorMapping, columnPrefix);
      } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 265 8135540");  if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 266 8135540")|| true) && (constructorMapping.getNestedResultMapId() != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 108 60 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 108 60 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 267 8135540"); {
        final ResultMap resultMap = configuration.getResultMap(constructorMapping.getNestedResultMapId());
        value = getRowValue(rsw, resultMap);
      } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 268 8135540");  {
        final TypeHandler<?> typeHandler = constructorMapping.getTypeHandler();
        value = typeHandler.getResult(rsw.getResultSet(), prependPrefix(column, columnPrefix));
      } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 269 8135540"); }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 270 8135540");
      constructorArgTypes.add(parameterType);
      constructorArgs.add(value);
      foundValues = value != null || foundValues;
    }}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 271 8135540");
    return foundValues ? objectFactory.create(resultType, constructorArgTypes, constructorArgs) : null;
  }

  private Object createPrimitiveResultObject(ResultSetWrapper rsw, ResultMap resultMap, String columnPrefix) throws SQLException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 157 272 8135540"); 
    final Class<?> resultType = resultMap.getType();
    final String columnName;
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 273 8135540")|| true) && (resultMap.getResultMappings().size() > 0? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 109 61 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 109 61 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 274 8135540"); {
      final List<ResultMapping> resultMappingList = resultMap.getResultMappings();
      final ResultMapping mapping = resultMappingList.get(0);
      columnName = prependPrefix(mapping.getColumn(), columnPrefix);
    } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 275 8135540");  {
      columnName = rsw.getColumnNames().get(0);
    } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 276 8135540");
    final TypeHandler<?> typeHandler = rsw.getTypeHandler(resultType, columnName);
    return typeHandler.getResult(rsw.getResultSet(), columnName);
  }

  //
  // NESTED QUERY
  //

  private Object getNestedQueryConstructorValue(ResultSet rs, ResultMapping constructorMapping, String columnPrefix) throws SQLException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 157 277 8135540"); 
    final String nestedQueryId = constructorMapping.getNestedQueryId();
    final MappedStatement nestedQuery = configuration.getMappedStatement(nestedQueryId);
    final Class<?> nestedQueryParameterType = nestedQuery.getParameterMap().getType();
    final Object nestedQueryParameterObject = prepareParameterForNestedQuery(rs, constructorMapping, nestedQueryParameterType, columnPrefix);
    Object value = null;
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 278 8135540")|| true) && (nestedQueryParameterObject != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 110 62 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 110 62 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 279 8135540"); {
      final BoundSql nestedBoundSql = nestedQuery.getBoundSql(nestedQueryParameterObject);
      final CacheKey key = executor.createCacheKey(nestedQuery, nestedQueryParameterObject, RowBounds.DEFAULT, nestedBoundSql);
      final Class<?> targetType = constructorMapping.getJavaType();
      final ResultLoader resultLoader = new ResultLoader(configuration, executor, nestedQuery, nestedQueryParameterObject, targetType, key, nestedBoundSql);
      value = resultLoader.loadResult();
    } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 280 8135540");
    return value;
  }

  private Object getNestedQueryMappingValue(ResultSet rs, MetaObject metaResultObject, ResultMapping propertyMapping, ResultLoaderMap lazyLoader, String columnPrefix)
      throws SQLException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 157 281 8135540"); 
    final String nestedQueryId = propertyMapping.getNestedQueryId();
    final String property = propertyMapping.getProperty();
    final MappedStatement nestedQuery = configuration.getMappedStatement(nestedQueryId);
    final Class<?> nestedQueryParameterType = nestedQuery.getParameterMap().getType();
    final Object nestedQueryParameterObject = prepareParameterForNestedQuery(rs, propertyMapping, nestedQueryParameterType, columnPrefix);
    Object value = NO_VALUE;
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 282 8135540")|| true) && (nestedQueryParameterObject != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 111 63 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 111 63 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 283 8135540"); {
      final BoundSql nestedBoundSql = nestedQuery.getBoundSql(nestedQueryParameterObject);
      final CacheKey key = executor.createCacheKey(nestedQuery, nestedQueryParameterObject, RowBounds.DEFAULT, nestedBoundSql);
      final Class<?> targetType = propertyMapping.getJavaType();
      if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 284 8135540")|| true) && (executor.isCached(nestedQuery, key)? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 112 64 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 112 64 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 285 8135540"); {
        executor.deferLoad(nestedQuery, metaResultObject, property, key, targetType);
      } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 286 8135540");  {
        final ResultLoader resultLoader = new ResultLoader(configuration, executor, nestedQuery, nestedQueryParameterObject, targetType, key, nestedBoundSql);
        if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 287 8135540")|| true) && (propertyMapping.isLazy()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 113 65 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 113 65 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 288 8135540"); {
          lazyLoader.addLoader(property, metaResultObject, resultLoader);
        } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 289 8135540");  {
          value = resultLoader.loadResult();
        } }
      } }
    } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 292 8135540");
    return value;
  }

  private Object prepareParameterForNestedQuery(ResultSet rs, ResultMapping resultMapping, Class<?> parameterType, String columnPrefix) throws SQLException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 157 293 8135540"); 
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 294 8135540")|| true) && (resultMapping.isCompositeResult()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 114 66 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 114 66 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 295 8135540"); {
      return prepareCompositeKeyParameter(rs, resultMapping, parameterType, columnPrefix);
    } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 296 8135540");  {
      return prepareSimpleKeyParameter(rs, resultMapping, parameterType, columnPrefix);
    } }
  }

  private Object prepareSimpleKeyParameter(ResultSet rs, ResultMapping resultMapping, Class<?> parameterType, String columnPrefix) throws SQLException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 157 298 8135540"); 
    final TypeHandler<?> typeHandler;
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 299 8135540")|| true) && (typeHandlerRegistry.hasTypeHandler(parameterType)? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 115 67 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 115 67 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 300 8135540"); {
      typeHandler = typeHandlerRegistry.getTypeHandler(parameterType);
    } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 301 8135540");  {
      typeHandler = typeHandlerRegistry.getUnknownTypeHandler();
    } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 302 8135540");
    return typeHandler.getResult(rs, prependPrefix(resultMapping.getColumn(), columnPrefix));
  }

  private Object prepareCompositeKeyParameter(ResultSet rs, ResultMapping resultMapping, Class<?> parameterType, String columnPrefix) throws SQLException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 157 303 8135540"); 
    final Object parameterObject = instantiateParameterObject(parameterType);
    final MetaObject metaObject = configuration.newMetaObject(parameterObject);
    boolean foundValues = false;
    for (ResultMapping innerResultMapping : /* TRUE */resultMapping.getComposites()){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 304 8135540");ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 305 8135540"); {
      final Class<?> propType = metaObject.getSetterType(innerResultMapping.getProperty());
      final TypeHandler<?> typeHandler = typeHandlerRegistry.getTypeHandler(propType);
      final Object propValue = typeHandler.getResult(rs, prependPrefix(innerResultMapping.getColumn(), columnPrefix));
      if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 306 8135540")|| true) && (propValue != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 116 68 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 116 68 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 307 8135540"); { // issue #353 & #560 do not execute nested query if key is null
        metaObject.setValue(innerResultMapping.getProperty(), propValue);
        foundValues = true;
      } }
    }}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 309 8135540");
    return foundValues ? parameterObject : null;
  }

  private Object instantiateParameterObject(Class<?> parameterType) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 157 310 8135540"); 
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 311 8135540")|| true) && (parameterType == null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 117 69 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 117 69 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 312 8135540"); {
      return new HashMap<Object, Object>();
    } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 313 8135540");  {
      return objectFactory.create(parameterType);
    } }
  }

  //
  // DISCRIMINATOR
  //

  public ResultMap resolveDiscriminatedResultMap(ResultSet rs, ResultMap resultMap, String columnPrefix) throws SQLException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 157 315 8135540"); 
    Set<String> pastDiscriminators = new HashSet<String>();
    Discriminator discriminator = resultMap.getDiscriminator();
    while ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 316 8135540")|| true) && (discriminator != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 118 70 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 118 70 0 0 ","8135540",false,0) && false))){ ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 317 8135540");  {
      final Object value = getDiscriminatorValue(rs, discriminator, columnPrefix);
      final String discriminatedMapId = discriminator.getMapIdFor(String.valueOf(value));
      if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 318 8135540")|| true) && (configuration.hasResultMap(discriminatedMapId)? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 119 71 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 119 71 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 319 8135540"); {
        resultMap = configuration.getResultMap(discriminatedMapId);
        Discriminator lastDiscriminator = discriminator;
        discriminator = resultMap.getDiscriminator();
        int zoa_cond_n320_0 = 2;
int zoa_cond_n320_1 = 2;
//zoa_cond_n320_0#discriminator == lastDiscriminator$zoa_cond_n320_1#pastDiscriminators.add(discriminatedMapId)
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 320 8135540")|| true) && ((discriminator == lastDiscriminator?(zoa_cond_n320_0 != (zoa_cond_n320_0 = 1)):(zoa_cond_n320_0 == (zoa_cond_n320_0 = 0))) || !(pastDiscriminators.add(discriminatedMapId)?(zoa_cond_n320_1 != (zoa_cond_n320_1 = 1)):(zoa_cond_n320_1 == (zoa_cond_n320_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 122 72 1 2 ","8135540",true,zoa_cond_n320_0,zoa_cond_n320_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 122 72 0 2 ","8135540",false,zoa_cond_n320_0,zoa_cond_n320_1) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 321 8135540"); {
           break;
        } }
      } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 323 8135540");  {
         break;
      } }
    }}ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 325 8135540"); 
    return resultMap;
  }

  private Object getDiscriminatorValue(ResultSet rs, Discriminator discriminator, String columnPrefix) throws SQLException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 157 326 8135540"); 
    final ResultMapping resultMapping = discriminator.getResultMapping();
    final TypeHandler<?> typeHandler = resultMapping.getTypeHandler();
    return typeHandler.getResult(rs, prependPrefix(resultMapping.getColumn(), columnPrefix));
  }

  private String prependPrefix(String columnName, String prefix) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 157 327 8135540"); 
    int zoa_cond_n328_0 = 2;
int zoa_cond_n328_1 = 2;
int zoa_cond_n328_2 = 2;
int zoa_cond_n328_3 = 2;
//zoa_cond_n328_0#columnName == null$zoa_cond_n328_1#columnName.length() == 0$zoa_cond_n328_2#prefix == null$zoa_cond_n328_3#prefix.length() == 0
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 328 8135540")|| true) && ((columnName == null?(zoa_cond_n328_0 != (zoa_cond_n328_0 = 1)):(zoa_cond_n328_0 == (zoa_cond_n328_0 = 0))) || (columnName.length() == 0?(zoa_cond_n328_1 != (zoa_cond_n328_1 = 1)):(zoa_cond_n328_1 == (zoa_cond_n328_1 = 0))) || (prefix == null?(zoa_cond_n328_2 != (zoa_cond_n328_2 = 1)):(zoa_cond_n328_2 == (zoa_cond_n328_2 = 0))) || (prefix.length() == 0?(zoa_cond_n328_3 != (zoa_cond_n328_3 = 1)):(zoa_cond_n328_3 == (zoa_cond_n328_3 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 127 73 1 4 ","8135540",true,zoa_cond_n328_0,zoa_cond_n328_1,zoa_cond_n328_2,zoa_cond_n328_3) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 127 73 0 4 ","8135540",false,zoa_cond_n328_0,zoa_cond_n328_1,zoa_cond_n328_2,zoa_cond_n328_3) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 329 8135540"); {
      return columnName;
    } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 330 8135540");
    return prefix + columnName;
  }

  //
  // HANDLE NESTED RESULT MAPS
  //

  private void handleRowValuesForNestedResultMap(ResultSetWrapper rsw, ResultMap resultMap, ResultHandler resultHandler, RowBounds rowBounds, ResultMapping parentMapping) throws SQLException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 157 331 8135540"); 
    final DefaultResultContext resultContext = new DefaultResultContext();
    skipRows(rsw.getResultSet(), rowBounds);
    Object rowValue = null;
    int zoa_cond_n332_0 = 2;
int zoa_cond_n332_1 = 2;
//zoa_cond_n332_0#shouldProcessMoreRows(resultContext, rowBounds)$zoa_cond_n332_1#rsw.getResultSet().next()
while ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 332 8135540")|| true) && ((shouldProcessMoreRows(resultContext, rowBounds)?(zoa_cond_n332_0 != (zoa_cond_n332_0 = 1)):(zoa_cond_n332_0 == (zoa_cond_n332_0 = 0))) && (rsw.getResultSet().next()?(zoa_cond_n332_1 != (zoa_cond_n332_1 = 1)):(zoa_cond_n332_1 == (zoa_cond_n332_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 130 74 1 2 ","8135540",true,zoa_cond_n332_0,zoa_cond_n332_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 130 74 0 2 ","8135540",false,zoa_cond_n332_0,zoa_cond_n332_1) && false))){zoa_cond_n332_0 = 2;
zoa_cond_n332_1 = 2;
 ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 333 8135540");  {
      final ResultMap discriminatedResultMap = resolveDiscriminatedResultMap(rsw.getResultSet(), resultMap, null);
      final CacheKey rowKey = createRowKey(discriminatedResultMap, rsw, null);
      Object partialObject = nestedResultObjects.get(rowKey);
      if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 334 8135540")|| true) && (mappedStatement.isResultOrdered()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 131 75 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 131 75 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 335 8135540"); { // issue #577 && #542
        int zoa_cond_n336_0 = 2;
int zoa_cond_n336_1 = 2;
//zoa_cond_n336_0#partialObject == null$zoa_cond_n336_1#rowValue != null
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 336 8135540")|| true) && ((partialObject == null?(zoa_cond_n336_0 != (zoa_cond_n336_0 = 1)):(zoa_cond_n336_0 == (zoa_cond_n336_0 = 0))) && (rowValue != null?(zoa_cond_n336_1 != (zoa_cond_n336_1 = 1)):(zoa_cond_n336_1 == (zoa_cond_n336_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 134 76 1 2 ","8135540",true,zoa_cond_n336_0,zoa_cond_n336_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 134 76 0 2 ","8135540",false,zoa_cond_n336_0,zoa_cond_n336_1) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 337 8135540"); {
          nestedResultObjects.clear();
          storeObject(resultHandler, resultContext, rowValue, parentMapping, rsw.getResultSet());
        } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 338 8135540");
        rowValue = getRowValue(rsw, discriminatedResultMap, rowKey, rowKey, null, partialObject);
      } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 339 8135540");  {
        rowValue = getRowValue(rsw, discriminatedResultMap, rowKey, rowKey, null, partialObject);
        if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 340 8135540")|| true) && (partialObject == null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 135 77 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 135 77 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 341 8135540"); {
          storeObject(resultHandler, resultContext, rowValue, parentMapping, rsw.getResultSet());
        } }
      } }
    }}ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 344 8135540"); 
    int zoa_cond_n345_0 = 2;
int zoa_cond_n345_1 = 2;
int zoa_cond_n345_2 = 2;
//zoa_cond_n345_0#rowValue != null$zoa_cond_n345_1#mappedStatement.isResultOrdered()$zoa_cond_n345_2#shouldProcessMoreRows(resultContext, rowBounds)
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 345 8135540")|| true) && ((rowValue != null?(zoa_cond_n345_0 != (zoa_cond_n345_0 = 1)):(zoa_cond_n345_0 == (zoa_cond_n345_0 = 0))) && (mappedStatement.isResultOrdered()?(zoa_cond_n345_1 != (zoa_cond_n345_1 = 1)):(zoa_cond_n345_1 == (zoa_cond_n345_1 = 0))) && (shouldProcessMoreRows(resultContext, rowBounds)?(zoa_cond_n345_2 != (zoa_cond_n345_2 = 1)):(zoa_cond_n345_2 == (zoa_cond_n345_2 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 139 78 1 3 ","8135540",true,zoa_cond_n345_0,zoa_cond_n345_1,zoa_cond_n345_2) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 139 78 0 3 ","8135540",false,zoa_cond_n345_0,zoa_cond_n345_1,zoa_cond_n345_2) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 346 8135540"); {
      storeObject(resultHandler, resultContext, rowValue, parentMapping, rsw.getResultSet());
    } }
  }
  
  //
  // GET VALUE FROM ROW FOR NESTED RESULT MAP
  //

  private Object getRowValue(ResultSetWrapper rsw, ResultMap resultMap, CacheKey combinedKey, CacheKey absoluteKey, String columnPrefix, Object partialObject) throws SQLException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 157 348 8135540"); 
    final String resultMapId = resultMap.getId();
    Object resultObject = partialObject;
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 349 8135540")|| true) && (resultObject != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 140 79 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 140 79 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 350 8135540"); {
      final MetaObject metaObject = configuration.newMetaObject(resultObject);
      putAncestor(absoluteKey, resultObject, resultMapId, columnPrefix);
      applyNestedResultMappings(rsw, resultMap, metaObject, columnPrefix, combinedKey, false);
      ancestorObjects.remove(absoluteKey);
    } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 351 8135540");  {
      final ResultLoaderMap lazyLoader = new ResultLoaderMap();
      resultObject = createResultObject(rsw, resultMap, lazyLoader, columnPrefix);
      int zoa_cond_n352_0 = 2;
int zoa_cond_n352_1 = 2;
//zoa_cond_n352_0#resultObject != null$zoa_cond_n352_1#typeHandlerRegistry.hasTypeHandler(resultMap.getType())
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 352 8135540")|| true) && ((resultObject != null?(zoa_cond_n352_0 != (zoa_cond_n352_0 = 1)):(zoa_cond_n352_0 == (zoa_cond_n352_0 = 0))) && !(typeHandlerRegistry.hasTypeHandler(resultMap.getType())?(zoa_cond_n352_1 != (zoa_cond_n352_1 = 1)):(zoa_cond_n352_1 == (zoa_cond_n352_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 143 80 1 2 ","8135540",true,zoa_cond_n352_0,zoa_cond_n352_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 143 80 0 2 ","8135540",false,zoa_cond_n352_0,zoa_cond_n352_1) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 353 8135540"); {
        final MetaObject metaObject = configuration.newMetaObject(resultObject);
        boolean foundValues = resultMap.getConstructorResultMappings().size() > 0;
        if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 354 8135540")|| true) && (shouldApplyAutomaticMappings(resultMap, AutoMappingBehavior.FULL.equals(configuration.getAutoMappingBehavior()))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 144 81 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 144 81 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 355 8135540"); {
          foundValues = applyAutomaticMappings(rsw, resultMap, metaObject, columnPrefix) || foundValues;
        } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 356 8135540");        
        foundValues = applyPropertyMappings(rsw, resultMap, metaObject, lazyLoader, columnPrefix) || foundValues;
        putAncestor(absoluteKey, resultObject, resultMapId, columnPrefix);
        foundValues = applyNestedResultMappings(rsw, resultMap, metaObject, columnPrefix, combinedKey, true) || foundValues;
        ancestorObjects.remove(absoluteKey);
        foundValues = lazyLoader.size() > 0 || foundValues;
        resultObject = foundValues ? resultObject : null;
      } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 357 8135540");
      if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 358 8135540")|| true) && (combinedKey != CacheKey.NULL_CACHE_KEY? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 145 82 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 145 82 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 359 8135540"); nestedResultObjects.put(combinedKey, resultObject); }
    } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 361 8135540");
    return resultObject;
  }

  private void putAncestor(CacheKey rowKey, Object resultObject, String resultMapId, String columnPrefix) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 157 362 8135540"); 
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 363 8135540")|| true) && (!ancestorColumnPrefix.containsKey(resultMapId)? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 146 83 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 146 83 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 364 8135540"); {
      ancestorColumnPrefix.put(resultMapId, columnPrefix);
    } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 365 8135540");
    ancestorObjects.put(rowKey, resultObject);
  }

  //
  // NESTED RESULT MAP (JOIN MAPPING)
  //

  private boolean applyNestedResultMappings(ResultSetWrapper rsw, ResultMap resultMap, MetaObject metaObject, String parentPrefix, CacheKey parentRowKey, boolean newObject) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 157 366 8135540"); 
    boolean foundValues = false;
    for (ResultMapping resultMapping : /* TRUE */resultMap.getPropertyResultMappings()){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 367 8135540");ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 368 8135540"); {
      final String nestedResultMapId = resultMapping.getNestedResultMapId();
      int zoa_cond_n369_0 = 2;
int zoa_cond_n369_1 = 2;
//zoa_cond_n369_0#nestedResultMapId != null$zoa_cond_n369_1#resultMapping.getResultSet() == null
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 369 8135540")|| true) && ((nestedResultMapId != null?(zoa_cond_n369_0 != (zoa_cond_n369_0 = 1)):(zoa_cond_n369_0 == (zoa_cond_n369_0 = 0))) && (resultMapping.getResultSet() == null?(zoa_cond_n369_1 != (zoa_cond_n369_1 = 1)):(zoa_cond_n369_1 == (zoa_cond_n369_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 149 84 1 2 ","8135540",true,zoa_cond_n369_0,zoa_cond_n369_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 149 84 0 2 ","8135540",false,zoa_cond_n369_0,zoa_cond_n369_1) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 370 8135540"); {
        try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 371 8135540"); 
          final String columnPrefix = getColumnPrefix(parentPrefix, resultMapping);
          final ResultMap nestedResultMap = getNestedResultMap(rsw.getResultSet(), nestedResultMapId, columnPrefix);
          CacheKey rowKey = null;
          Object ancestorObject = null;
          if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 372 8135540")|| true) && (ancestorColumnPrefix.containsKey(nestedResultMapId)? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 150 85 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 150 85 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 373 8135540"); {
            rowKey = createRowKey(nestedResultMap, rsw, ancestorColumnPrefix.get(nestedResultMapId));
            ancestorObject = ancestorObjects.get(rowKey);
          } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 374 8135540");
          if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 375 8135540")|| true) && (ancestorObject != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 151 86 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 151 86 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 376 8135540"); { 
            if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 377 8135540")|| true) && (newObject? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 152 87 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 152 87 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 378 8135540"); metaObject.setValue(resultMapping.getProperty(), ancestorObject); }
          } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 380 8135540");  {
            rowKey = createRowKey(nestedResultMap, rsw, columnPrefix);
            final CacheKey combinedKey = combineKeys(rowKey, parentRowKey);            
            Object rowValue = nestedResultObjects.get(combinedKey);
            boolean knownValue = (rowValue != null);
            final Object collectionProperty = instantiateCollectionPropertyIfAppropriate(resultMapping, metaObject);            
            if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 381 8135540")|| true) && (anyNotNullColumnHasValue(resultMapping, columnPrefix, rsw.getResultSet())? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 153 88 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 153 88 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 382 8135540"); {
              rowValue = getRowValue(rsw, nestedResultMap, combinedKey, rowKey, columnPrefix, rowValue);
              int zoa_cond_n383_0 = 2;
int zoa_cond_n383_1 = 2;
//zoa_cond_n383_0#rowValue != null$zoa_cond_n383_1#knownValue
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 383 8135540")|| true) && ((rowValue != null?(zoa_cond_n383_0 != (zoa_cond_n383_0 = 1)):(zoa_cond_n383_0 == (zoa_cond_n383_0 = 0))) && !(knownValue?(zoa_cond_n383_1 != (zoa_cond_n383_1 = 1)):(zoa_cond_n383_1 == (zoa_cond_n383_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 156 89 1 2 ","8135540",true,zoa_cond_n383_0,zoa_cond_n383_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 156 89 0 2 ","8135540",false,zoa_cond_n383_0,zoa_cond_n383_1) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 384 8135540"); {
                if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 385 8135540")|| true) && (collectionProperty != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 157 90 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 157 90 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 386 8135540"); {
                  final MetaObject targetMetaObject = configuration.newMetaObject(collectionProperty);
                  targetMetaObject.add(rowValue);
                } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 387 8135540");  {
                  metaObject.setValue(resultMapping.getProperty(), rowValue);
                } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 388 8135540");
                foundValues = true;
              } }
            } }
          } }
        } catch (SQLException e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 392 8135540"); 
          throw new ExecutorException("Error getting nested result map values for '" + resultMapping.getProperty() + "'.  Cause: " + e, e);
        }
      } }
    }}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 395 8135540");
    return foundValues;
  }

  private String getColumnPrefix(String parentPrefix, ResultMapping resultMapping) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 157 396 8135540"); 
    final StringBuilder columnPrefixBuilder = new StringBuilder();
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 397 8135540")|| true) && (parentPrefix != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 158 91 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 158 91 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 398 8135540"); columnPrefixBuilder.append(parentPrefix); }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 399 8135540");
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 400 8135540")|| true) && (resultMapping.getColumnPrefix() != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 159 92 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 159 92 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 401 8135540"); columnPrefixBuilder.append(resultMapping.getColumnPrefix()); }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 402 8135540");
    final String columnPrefix = columnPrefixBuilder.length() == 0 ? null : columnPrefixBuilder.toString().toUpperCase(Locale.ENGLISH);
    return columnPrefix;
  }

  private boolean anyNotNullColumnHasValue(ResultMapping resultMapping, String columnPrefix, ResultSet rs) throws SQLException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 157 403 8135540"); 
    Set<String> notNullColumns = resultMapping.getNotNullColumns();
    boolean anyNotNullColumnHasValue = true;
    int zoa_cond_n404_0 = 2;
int zoa_cond_n404_1 = 2;
//zoa_cond_n404_0#notNullColumns != null$zoa_cond_n404_1#notNullColumns.isEmpty()
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 404 8135540")|| true) && ((notNullColumns != null?(zoa_cond_n404_0 != (zoa_cond_n404_0 = 1)):(zoa_cond_n404_0 == (zoa_cond_n404_0 = 0))) && !(notNullColumns.isEmpty()?(zoa_cond_n404_1 != (zoa_cond_n404_1 = 1)):(zoa_cond_n404_1 == (zoa_cond_n404_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 162 93 1 2 ","8135540",true,zoa_cond_n404_0,zoa_cond_n404_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 162 93 0 2 ","8135540",false,zoa_cond_n404_0,zoa_cond_n404_1) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 405 8135540"); {
      anyNotNullColumnHasValue = false;
      for (String column: /* TRUE */notNullColumns){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 406 8135540");ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 407 8135540"); {
        rs.getObject(prependPrefix(column, columnPrefix));
        if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 408 8135540")|| true) && (!rs.wasNull()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 163 94 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 163 94 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 409 8135540"); {
          anyNotNullColumnHasValue = true;
           break;
        } }
      }}
    } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 412 8135540");
    return anyNotNullColumnHasValue;
  }

  private ResultMap getNestedResultMap(ResultSet rs, String nestedResultMapId, String columnPrefix) throws SQLException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 157 413 8135540"); 
    ResultMap nestedResultMap = configuration.getResultMap(nestedResultMapId);
    nestedResultMap = resolveDiscriminatedResultMap(rs, nestedResultMap, columnPrefix);
    return nestedResultMap;
  }

  //
  // UNIQUE RESULT KEY
  //

  private CacheKey createRowKey(ResultMap resultMap, ResultSetWrapper rsw, String columnPrefix) throws SQLException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 157 414 8135540"); 
    final CacheKey cacheKey = new CacheKey();
    cacheKey.update(resultMap.getId());
    List<ResultMapping> resultMappings = getResultMappingsForRowKey(resultMap);
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 415 8135540")|| true) && (resultMappings.size() == 0? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 164 95 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 164 95 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 416 8135540"); {
      if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 417 8135540")|| true) && (Map.class.isAssignableFrom(resultMap.getType())? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 165 96 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 165 96 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 418 8135540"); {
        createRowKeyForMap(rsw, cacheKey);
      } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 419 8135540");  {
        createRowKeyForUnmappedProperties(resultMap, rsw, cacheKey, columnPrefix);
      } }
    } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 421 8135540");  {
      createRowKeyForMappedProperties(resultMap, rsw, cacheKey, resultMappings, columnPrefix);
    } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 422 8135540");
    return cacheKey;
  }

  private CacheKey combineKeys(CacheKey rowKey, CacheKey parentRowKey) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 157 423 8135540"); 
    int zoa_cond_n424_0 = 2;
int zoa_cond_n424_1 = 2;
//zoa_cond_n424_0#rowKey.getUpdateCount() > 1$zoa_cond_n424_1#parentRowKey.getUpdateCount() > 1
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 424 8135540")|| true) && ((rowKey.getUpdateCount() > 1?(zoa_cond_n424_0 != (zoa_cond_n424_0 = 1)):(zoa_cond_n424_0 == (zoa_cond_n424_0 = 0))) && (parentRowKey.getUpdateCount() > 1?(zoa_cond_n424_1 != (zoa_cond_n424_1 = 1)):(zoa_cond_n424_1 == (zoa_cond_n424_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 168 97 1 2 ","8135540",true,zoa_cond_n424_0,zoa_cond_n424_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 168 97 0 2 ","8135540",false,zoa_cond_n424_0,zoa_cond_n424_1) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 425 8135540"); {
      CacheKey combinedKey;
      try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 426 8135540"); 
        combinedKey = rowKey.clone();
      } catch (CloneNotSupportedException e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 427 8135540"); 
        throw new ExecutorException("Error cloning cache key.  Cause: " + e, e);
      }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 428 8135540");
      combinedKey.update(parentRowKey);
      return combinedKey;
    } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 429 8135540");
    return CacheKey.NULL_CACHE_KEY;
  }

  private List<ResultMapping> getResultMappingsForRowKey(ResultMap resultMap) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 157 430 8135540"); 
    List<ResultMapping> resultMappings = resultMap.getIdResultMappings();
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 431 8135540")|| true) && (resultMappings.size() == 0? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 169 98 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 169 98 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 432 8135540"); {
      resultMappings = resultMap.getPropertyResultMappings();
    } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 433 8135540");
    return resultMappings;
  }

  private void createRowKeyForMappedProperties(ResultMap resultMap, ResultSetWrapper rsw, CacheKey cacheKey, List<ResultMapping> resultMappings, String columnPrefix) throws SQLException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 157 434 8135540"); 
    for (ResultMapping resultMapping : /* TRUE */resultMappings){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 435 8135540");ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 436 8135540"); {
      int zoa_cond_n437_0 = 2;
int zoa_cond_n437_1 = 2;
//zoa_cond_n437_0#resultMapping.getNestedResultMapId() != null$zoa_cond_n437_1#resultMapping.getResultSet() == null
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 437 8135540")|| true) && ((resultMapping.getNestedResultMapId() != null?(zoa_cond_n437_0 != (zoa_cond_n437_0 = 1)):(zoa_cond_n437_0 == (zoa_cond_n437_0 = 0))) && (resultMapping.getResultSet() == null?(zoa_cond_n437_1 != (zoa_cond_n437_1 = 1)):(zoa_cond_n437_1 == (zoa_cond_n437_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 172 99 1 2 ","8135540",true,zoa_cond_n437_0,zoa_cond_n437_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 172 99 0 2 ","8135540",false,zoa_cond_n437_0,zoa_cond_n437_1) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 438 8135540"); { // Issue #392
        final ResultMap nestedResultMap = configuration.getResultMap(resultMapping.getNestedResultMapId());
        createRowKeyForMappedProperties(nestedResultMap, rsw, cacheKey, nestedResultMap.getConstructorResultMappings(),
            prependPrefix(resultMapping.getColumnPrefix(), columnPrefix));
      } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 439 8135540");  if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 440 8135540")|| true) && (resultMapping.getNestedQueryId() == null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 173 100 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 173 100 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 441 8135540"); {
        final String column = prependPrefix(resultMapping.getColumn(), columnPrefix);
        final TypeHandler<?> th = resultMapping.getTypeHandler();
        List<String> mappedColumnNames = rsw.getMappedColumnNames(resultMap, columnPrefix);
        int zoa_cond_n442_0 = 2;
int zoa_cond_n442_1 = 2;
//zoa_cond_n442_0#column != null$zoa_cond_n442_1#mappedColumnNames.contains(column.toUpperCase(Locale.ENGLISH))
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 442 8135540")|| true) && ((column != null?(zoa_cond_n442_0 != (zoa_cond_n442_0 = 1)):(zoa_cond_n442_0 == (zoa_cond_n442_0 = 0))) && (mappedColumnNames.contains(column.toUpperCase(Locale.ENGLISH))?(zoa_cond_n442_1 != (zoa_cond_n442_1 = 1)):(zoa_cond_n442_1 == (zoa_cond_n442_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 176 101 1 2 ","8135540",true,zoa_cond_n442_0,zoa_cond_n442_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 176 101 0 2 ","8135540",false,zoa_cond_n442_0,zoa_cond_n442_1) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 443 8135540"); { // Issue #114
          final Object value = th.getResult(rsw.getResultSet(), column);
          if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 444 8135540")|| true) && (value != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 177 102 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 177 102 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 445 8135540"); {
            cacheKey.update(column);
            cacheKey.update(value);
          } }
        } }
      } } }
    }}
  }

  private void createRowKeyForUnmappedProperties(ResultMap resultMap, ResultSetWrapper rsw, CacheKey cacheKey, String columnPrefix) throws SQLException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 157 451 8135540"); 
    final MetaClass metaType = MetaClass.forClass(resultMap.getType());
    List<String> unmappedColumnNames = rsw.getUnmappedColumnNames(resultMap, columnPrefix);
    for (String column : /* TRUE */unmappedColumnNames){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 452 8135540");ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 453 8135540"); {
      String property = column;
      int zoa_cond_n454_0 = 2;
int zoa_cond_n454_1 = 2;
//zoa_cond_n454_0#columnPrefix != null$zoa_cond_n454_1#columnPrefix.length() > 0
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 454 8135540")|| true) && ((columnPrefix != null?(zoa_cond_n454_0 != (zoa_cond_n454_0 = 1)):(zoa_cond_n454_0 == (zoa_cond_n454_0 = 0))) && (columnPrefix.length() > 0?(zoa_cond_n454_1 != (zoa_cond_n454_1 = 1)):(zoa_cond_n454_1 == (zoa_cond_n454_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 180 103 1 2 ","8135540",true,zoa_cond_n454_0,zoa_cond_n454_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 180 103 0 2 ","8135540",false,zoa_cond_n454_0,zoa_cond_n454_1) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 455 8135540"); {
        // When columnPrefix is specified,
        // ignore columns without the prefix.
        if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 456 8135540")|| true) && (column.toUpperCase(Locale.ENGLISH).startsWith(columnPrefix)? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 181 104 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 181 104 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 457 8135540"); {
          property = column.substring(columnPrefix.length());
        } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 458 8135540");  {
          continue;
        } }
      } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 460 8135540");
      if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 461 8135540")|| true) && (metaType.findProperty(property, configuration.isMapUnderscoreToCamelCase()) != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 182 105 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 182 105 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 462 8135540"); {
        String value = rsw.getResultSet().getString(column);
        if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 463 8135540")|| true) && (value != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 183 106 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 183 106 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 464 8135540"); {
          cacheKey.update(column);
          cacheKey.update(value);
        } }
      } }
    }}
  }

  private void createRowKeyForMap(ResultSetWrapper rsw, CacheKey cacheKey) throws SQLException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 157 468 8135540"); 
    List<String> columnNames = rsw.getColumnNames();
    for (String columnName : /* TRUE */columnNames){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 469 8135540");ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 470 8135540"); {
      final String value = rsw.getResultSet().getString(columnName);
      if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 471 8135540")|| true) && (value != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 184 107 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 157 184 107 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 157 472 8135540"); {
        cacheKey.update(columnName);
        cacheKey.update(value);
      } }
    }}
  }

}

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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.ibatis.cache.Cache;
import org.apache.ibatis.executor.keygen.Jdbc3KeyGenerator;
import org.apache.ibatis.executor.keygen.KeyGenerator;
import org.apache.ibatis.executor.keygen.NoKeyGenerator;
import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.scripting.LanguageDriver;
import org.apache.ibatis.session.Configuration;

/**
 * @author Clinton Begin
 */
import com.process.ZoaExp;
import com.process.ZoaThreadLocal;
public final class MappedStatement {

	private String resource;
	private Configuration configuration;
	private String id;
	private Integer fetchSize;
	private Integer timeout;
	private StatementType statementType;
	private ResultSetType resultSetType;
	private SqlSource sqlSource;
	private Cache cache;
	private ParameterMap parameterMap;
	private List<ResultMap> resultMaps;
	private boolean flushCacheRequired;
	private boolean useCache;
	private boolean resultOrdered;
	private SqlCommandType sqlCommandType;
	private KeyGenerator keyGenerator;
	private String[] keyProperties;
	private String[] keyColumns;
	private boolean hasNestedResultMaps;
	private String databaseId;
	private Log statementLog;
	private LanguageDriver lang;
	private String[] resultSets;

	private MappedStatement() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 175 0 8135540"); 
		// constructor disabled
	}

	public static class Builder {
		private MappedStatement mappedStatement = new MappedStatement();

		public Builder(
				Configuration configuration,
				String id,
				SqlSource sqlSource,
				SqlCommandType sqlCommandType) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 175 1 8135540"); 
			mappedStatement.configuration = configuration;
			mappedStatement.id = id;
			mappedStatement.sqlSource = sqlSource;
			mappedStatement.statementType = StatementType.PREPARED;
			mappedStatement.parameterMap = new ParameterMap.Builder(
					configuration,
					"defaultParameterMap",
					null,
					new ArrayList<ParameterMapping>())
					.build();
			mappedStatement.resultMaps = new ArrayList<ResultMap>();
			mappedStatement.timeout = configuration
					.getDefaultStatementTimeout();
			mappedStatement.sqlCommandType = sqlCommandType;
			mappedStatement.keyGenerator = configuration
					.isUseGeneratedKeys()
					&& SqlCommandType.INSERT
							.equals(sqlCommandType) ? new Jdbc3KeyGenerator()
					: new NoKeyGenerator();
			String logId = id;
			if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 175 2 8135540")|| true) && (configuration
					.getLogPrefix() != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 175 0 0 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 175 0 0 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 175 3 8135540");
				logId = configuration
						.getLogPrefix()
						+ id; }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 175 4 8135540");
			mappedStatement.statementLog = LogFactory
					.getLog(logId);
			mappedStatement.lang = configuration
					.getDefaultScriptingLanuageInstance();
		}

		public Builder resource(
				String resource) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 175 5 8135540"); 
			mappedStatement.resource = resource;
			return this;
		}

		public String id() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 175 6 8135540"); 
			return mappedStatement.id;
		}

		public Builder parameterMap(
				ParameterMap parameterMap) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 175 7 8135540"); 
			mappedStatement.parameterMap = parameterMap;
			return this;
		}

		public Builder resultMaps(
				List<ResultMap> resultMaps) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 175 8 8135540"); 
			mappedStatement.resultMaps = resultMaps;
			for (ResultMap resultMap : /* TRUE */resultMaps){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 175 9 8135540");ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 175 10 8135540"); {
				mappedStatement.hasNestedResultMaps = mappedStatement.hasNestedResultMaps
						|| resultMap
								.hasNestedResultMaps();
			}}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 175 11 8135540");
			return this;
		}

		public Builder fetchSize(
				Integer fetchSize) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 175 12 8135540"); 
			mappedStatement.fetchSize = fetchSize;
			return this;
		}

		public Builder timeout(
				Integer timeout) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 175 13 8135540"); 
			mappedStatement.timeout = timeout;
			return this;
		}

		public Builder statementType(
				StatementType statementType) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 175 14 8135540"); 
			mappedStatement.statementType = statementType;
			return this;
		}

		public Builder resultSetType(
				ResultSetType resultSetType) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 175 15 8135540"); 
			mappedStatement.resultSetType = resultSetType;
			return this;
		}

		public Builder cache(Cache cache) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 175 16 8135540"); 
			mappedStatement.cache = cache;
			return this;
		}

		public Builder flushCacheRequired(
				boolean flushCacheRequired) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 175 17 8135540"); 
			mappedStatement.flushCacheRequired = flushCacheRequired;
			return this;
		}

		public Builder useCache(
				boolean useCache) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 175 18 8135540"); 
			mappedStatement.useCache = useCache;
			return this;
		}

		public Builder resultOrdered(
				boolean resultOrdered) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 175 19 8135540"); 
			mappedStatement.resultOrdered = resultOrdered;
			return this;
		}

		public Builder keyGenerator(
				KeyGenerator keyGenerator) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 175 20 8135540"); 
			mappedStatement.keyGenerator = keyGenerator;
			return this;
		}

		public Builder keyProperty(
				String keyProperty) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 175 21 8135540"); 
			mappedStatement.keyProperties = delimitedStringtoArray(keyProperty);
			return this;
		}

		public Builder keyColumn(
				String keyColumn) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 175 22 8135540"); 
			mappedStatement.keyColumns = delimitedStringtoArray(keyColumn);
			return this;
		}

		public Builder databaseId(
				String databaseId) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 175 23 8135540"); 
			mappedStatement.databaseId = databaseId;
			return this;
		}

		public Builder lang(
				LanguageDriver driver) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 175 24 8135540"); 
			mappedStatement.lang = driver;
			return this;
		}

		public Builder resulSets(
				String resultSet) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 175 25 8135540"); 
			mappedStatement.resultSets = delimitedStringtoArray(resultSet);
			return this;
		}

		public MappedStatement build() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 175 26 8135540"); 
			assert mappedStatement.configuration != null;
			assert mappedStatement.id != null;
			assert mappedStatement.sqlSource != null;
			assert mappedStatement.lang != null;
			mappedStatement.resultMaps = Collections
					.unmodifiableList(mappedStatement.resultMaps);
			return mappedStatement;
		}
	}

	public KeyGenerator getKeyGenerator() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 175 27 8135540"); 
		return keyGenerator;
	}

	public SqlCommandType getSqlCommandType() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 175 28 8135540"); 
		return sqlCommandType;
	}

	public String getResource() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 175 29 8135540"); 
		return resource;
	}

	public Configuration getConfiguration() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 175 30 8135540"); 
		return configuration;
	}

	public String getId() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 175 31 8135540"); 
		return id;
	}

	public boolean hasNestedResultMaps() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 175 32 8135540"); 
		return hasNestedResultMaps;
	}

	public Integer getFetchSize() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 175 33 8135540"); 
		return fetchSize;
	}

	public Integer getTimeout() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 175 34 8135540"); 
		return timeout;
	}

	public StatementType getStatementType() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 175 35 8135540"); 
		return statementType;
	}

	public ResultSetType getResultSetType() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 175 36 8135540"); 
		return resultSetType;
	}

	public SqlSource getSqlSource() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 175 37 8135540"); 
		return sqlSource;
	}

	public ParameterMap getParameterMap() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 175 38 8135540"); 
		return parameterMap;
	}

	public List<ResultMap> getResultMaps() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 175 39 8135540"); 
		return resultMaps;
	}

	public Cache getCache() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 175 40 8135540"); 
		return cache;
	}

	public boolean isFlushCacheRequired() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 175 41 8135540"); 
		return flushCacheRequired;
	}

	public boolean isUseCache() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 175 42 8135540"); 
		return useCache;
	}

	public boolean isResultOrdered() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 175 43 8135540"); 
		return resultOrdered;
	}

	public String getDatabaseId() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 175 44 8135540"); 
		return databaseId;
	}

	public String[] getKeyProperties() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 175 45 8135540"); 
		return keyProperties;
	}

	public String[] getKeyColumns() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 175 46 8135540"); 
		return keyColumns;
	}

	public Log getStatementLog() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 175 47 8135540"); 
		return statementLog;
	}

	public LanguageDriver getLang() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 175 48 8135540"); 
		return lang;
	}

	public String[] getResulSets() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 175 49 8135540"); 
		return resultSets;
	}

	public BoundSql getBoundSql(
			Object parameterObject) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 175 50 8135540"); 
		BoundSql boundSql = sqlSource
				.getBoundSql(parameterObject);
		List<ParameterMapping> parameterMappings = boundSql
				.getParameterMappings();
		int zoa_cond_n51_0 = 2;
int zoa_cond_n51_1 = 2;
//zoa_cond_n51_0#parameterMappings == null$zoa_cond_n51_1#parameterMappings.size() <= 0
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 175 51 8135540")|| true) && ((parameterMappings == null?(zoa_cond_n51_0 != (zoa_cond_n51_0 = 1)):(zoa_cond_n51_0 == (zoa_cond_n51_0 = 0)))
				|| (parameterMappings
						.size() <= 0?(zoa_cond_n51_1 != (zoa_cond_n51_1 = 1)):(zoa_cond_n51_1 == (zoa_cond_n51_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 175 3 1 1 2 ","8135540",true,zoa_cond_n51_0,zoa_cond_n51_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 175 3 1 0 2 ","8135540",false,zoa_cond_n51_0,zoa_cond_n51_1) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 175 52 8135540"); {
			boundSql = new BoundSql(
					configuration,
					boundSql.getSql(),
					parameterMap
							.getParameterMappings(),
					parameterObject);
		} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 175 53 8135540");

		// check for nested result maps in parameter mappings (issue #30)
		for (ParameterMapping pm : /* TRUE */boundSql
				.getParameterMappings()){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 175 54 8135540");ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 175 55 8135540"); {
			String rmId = pm
					.getResultMapId();
			if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 175 56 8135540")|| true) && (rmId != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 175 4 2 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 175 4 2 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 175 57 8135540"); {
				ResultMap rm = configuration
						.getResultMap(rmId);
				if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 175 58 8135540")|| true) && (rm != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 175 5 3 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 175 5 3 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 175 59 8135540"); {
					hasNestedResultMaps |= rm
							.hasNestedResultMaps();
				} }
			} }
		}}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 175 62 8135540");

		return boundSql;
	}

	private static String[] delimitedStringtoArray(
			String in) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 175 63 8135540"); 
		int zoa_cond_n64_0 = 2;
int zoa_cond_n64_1 = 2;
//zoa_cond_n64_0#in == null$zoa_cond_n64_1#in.trim().length() == 0
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 175 64 8135540")|| true) && ((in == null?(zoa_cond_n64_0 != (zoa_cond_n64_0 = 1)):(zoa_cond_n64_0 == (zoa_cond_n64_0 = 0)))
				|| (in.trim().length() == 0?(zoa_cond_n64_1 != (zoa_cond_n64_1 = 1)):(zoa_cond_n64_1 == (zoa_cond_n64_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 175 8 4 1 2 ","8135540",true,zoa_cond_n64_0,zoa_cond_n64_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 175 8 4 0 2 ","8135540",false,zoa_cond_n64_0,zoa_cond_n64_1) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 175 65 8135540"); {
			return null;
		} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 175 66 8135540");  {
			String[] answer = in
					.split(",");
			return answer;
		} }
	}

}

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
package org.apache.ibatis.builder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.StringTokenizer;

import org.apache.ibatis.cache.Cache;
import org.apache.ibatis.cache.decorators.LruCache;
import org.apache.ibatis.cache.impl.PerpetualCache;
import org.apache.ibatis.executor.ErrorContext;
import org.apache.ibatis.executor.keygen.KeyGenerator;
import org.apache.ibatis.mapping.CacheBuilder;
import org.apache.ibatis.mapping.Discriminator;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMap;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.mapping.ParameterMode;
import org.apache.ibatis.mapping.ResultFlag;
import org.apache.ibatis.mapping.ResultMap;
import org.apache.ibatis.mapping.ResultMapping;
import org.apache.ibatis.mapping.ResultSetType;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.mapping.StatementType;
import org.apache.ibatis.reflection.MetaClass;
import org.apache.ibatis.scripting.LanguageDriver;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

/**
 * @author Clinton Begin
 */
import com.process.ZoaExp;
import com.process.ZoaThreadLocal;
public class MapperBuilderAssistant
		extends BaseBuilder {

	private String currentNamespace;
	private String resource;
	private Cache currentCache;
	private boolean unresolvedCacheRef; // issue #676

	public MapperBuilderAssistant(
			Configuration configuration,
			String resource) {
		super(configuration);
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 190 0 8135540"); 
		ErrorContext.instance()
				.resource(resource);
		this.resource = resource;
	}

	public String getCurrentNamespace() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 190 1 8135540"); 
		return currentNamespace;
	}

	public void setCurrentNamespace(
			String currentNamespace) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 190 2 8135540"); 
		if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 190 3 8135540")|| true) && (currentNamespace == null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 190 0 0 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 190 0 0 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 190 4 8135540"); {
			throw new BuilderException(
					"The mapper element requires a namespace attribute to be specified.");
		} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 190 5 8135540");

		int zoa_cond_n6_0 = 2;
int zoa_cond_n6_1 = 2;
//zoa_cond_n6_0#this.currentNamespace != null$zoa_cond_n6_1#this.currentNamespace.equals(currentNamespace)
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 190 6 8135540")|| true) && ((this.currentNamespace != null?(zoa_cond_n6_0 != (zoa_cond_n6_0 = 1)):(zoa_cond_n6_0 == (zoa_cond_n6_0 = 0)))
				&& !(this.currentNamespace
						.equals(currentNamespace)?(zoa_cond_n6_1 != (zoa_cond_n6_1 = 1)):(zoa_cond_n6_1 == (zoa_cond_n6_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 190 3 1 1 2 ","8135540",true,zoa_cond_n6_0,zoa_cond_n6_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 190 3 1 0 2 ","8135540",false,zoa_cond_n6_0,zoa_cond_n6_1) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 190 7 8135540"); {
			throw new BuilderException(
					"Wrong namespace. Expected '"
							+ this.currentNamespace
							+ "' but found '"
							+ currentNamespace
							+ "'.");
		} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 190 8 8135540");

		this.currentNamespace = currentNamespace;
	}

	public String applyCurrentNamespace(
			String base,
			boolean isReference) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 190 9 8135540"); 
		if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 190 10 8135540")|| true) && (base == null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 190 4 2 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 190 4 2 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 190 11 8135540");
			return null; }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 190 12 8135540");
		if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 190 13 8135540")|| true) && (isReference? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 190 5 3 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 190 5 3 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 190 14 8135540"); {
			// is it qualified with any namespace yet?
			if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 190 15 8135540")|| true) && (base.contains(".")? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 190 6 4 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 190 6 4 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 190 16 8135540");
				return base; }
		} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 190 18 8135540");  {
			// is it qualified with this namespace yet?
			if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 190 19 8135540")|| true) && (base.startsWith(currentNamespace
					+ ".")? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 190 7 5 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 190 7 5 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 190 20 8135540");
				return base; }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 190 21 8135540");
			if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 190 22 8135540")|| true) && (base.contains(".")? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 190 8 6 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 190 8 6 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 190 23 8135540");
				throw new BuilderException(
						"Dots are not allowed in element names, please remove it from "
								+ base); }
		} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 190 25 8135540");
		return currentNamespace + "."
				+ base;
	}

	public Cache useCacheRef(
			String namespace) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 190 26 8135540"); 
		if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 190 27 8135540")|| true) && (namespace == null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 190 9 7 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 190 9 7 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 190 28 8135540"); {
			throw new BuilderException(
					"cache-ref element requires a namespace attribute.");
		} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 190 29 8135540");
		try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 190 30 8135540"); 
			unresolvedCacheRef = true;
			Cache cache = configuration
					.getCache(namespace);
			if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 190 31 8135540")|| true) && (cache == null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 190 10 8 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 190 10 8 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 190 32 8135540"); {
				throw new IncompleteElementException(
						"No cache for namespace '"
								+ namespace
								+ "' could be found.");
			} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 190 33 8135540");
			currentCache = cache;
			unresolvedCacheRef = false;
			return cache;
		} catch (IllegalArgumentException e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 190 34 8135540"); 
			throw new IncompleteElementException(
					"No cache for namespace '"
							+ namespace
							+ "' could be found.",
					e);
		}
	}

	public Cache useNewCache(
			Class<? extends Cache> typeClass,
			Class<? extends Cache> evictionClass,
			Long flushInterval,
			Integer size,
			boolean readWrite,
			Properties props) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 190 36 8135540"); 
		typeClass = valueOrDefault(
				typeClass,
				PerpetualCache.class);
		evictionClass = valueOrDefault(
				evictionClass,
				LruCache.class);
		Cache cache = new CacheBuilder(
				currentNamespace)
				.implementation(
						typeClass)
				.addDecorator(
						evictionClass)
				.clearInterval(
						flushInterval)
				.size(size)
				.readWrite(readWrite)
				.properties(props)
				.build();
		configuration.addCache(cache);
		currentCache = cache;
		return cache;
	}

	public ParameterMap addParameterMap(
			String id,
			Class<?> parameterClass,
			List<ParameterMapping> parameterMappings) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 190 37 8135540"); 
		id = applyCurrentNamespace(id,
				false);
		ParameterMap.Builder parameterMapBuilder = new ParameterMap.Builder(
				configuration, id,
				parameterClass,
				parameterMappings);
		ParameterMap parameterMap = parameterMapBuilder
				.build();
		configuration
				.addParameterMap(parameterMap);
		return parameterMap;
	}

	public ParameterMapping buildParameterMapping(
			Class<?> parameterType,
			String property,
			Class<?> javaType,
			JdbcType jdbcType,
			String resultMap,
			ParameterMode parameterMode,
			Class<? extends TypeHandler<?>> typeHandler,
			Integer numericScale) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 190 38 8135540"); 
		resultMap = applyCurrentNamespace(
				resultMap, true);

		// Class parameterType = parameterMapBuilder.type();
		Class<?> javaTypeClass = resolveParameterJavaType(
				parameterType,
				property, javaType,
				jdbcType);
		TypeHandler<?> typeHandlerInstance = resolveTypeHandler(
				javaTypeClass,
				typeHandler);

		ParameterMapping.Builder builder = new ParameterMapping.Builder(
				configuration,
				property, javaTypeClass);
		builder.jdbcType(jdbcType);
		builder.resultMapId(resultMap);
		builder.mode(parameterMode);
		builder.numericScale(numericScale);
		builder.typeHandler(typeHandlerInstance);
		return builder.build();
	}

	public ResultMap addResultMap(
			String id,
			Class<?> type,
			String extend,
			Discriminator discriminator,
			List<ResultMapping> resultMappings,
			Boolean autoMapping) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 190 39 8135540"); 
		id = applyCurrentNamespace(id,
				false);
		extend = applyCurrentNamespace(
				extend, true);

		ResultMap.Builder resultMapBuilder = new ResultMap.Builder(
				configuration, id,
				type, resultMappings,
				autoMapping);
		if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 190 40 8135540")|| true) && (extend != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 190 11 9 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 190 11 9 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 190 41 8135540"); {
			if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 190 42 8135540")|| true) && (!configuration
					.hasResultMap(extend)? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 190 12 10 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 190 12 10 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 190 43 8135540"); {
				throw new IncompleteElementException(
						"Could not find a parent resultmap with id '"
								+ extend
								+ "'");
			} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 190 44 8135540");
			ResultMap resultMap = configuration
					.getResultMap(extend);
			List<ResultMapping> extendedResultMappings = new ArrayList<ResultMapping>(
					resultMap
							.getResultMappings());
			extendedResultMappings
					.removeAll(resultMappings);
			// Remove parent constructor if this resultMap declares a
			// constructor.
			boolean declaresConstructor = false;
			for (ResultMapping resultMapping : /* TRUE */resultMappings){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 190 45 8135540");ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 190 46 8135540"); {
				if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 190 47 8135540")|| true) && (resultMapping
						.getFlags()
						.contains(
								ResultFlag.CONSTRUCTOR)? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 190 13 11 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 190 13 11 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 190 48 8135540"); {
					declaresConstructor = true;
					 break;
				} }
			}}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 190 50 8135540");
			if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 190 51 8135540")|| true) && (declaresConstructor? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 190 14 12 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 190 14 12 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 190 52 8135540"); {
				Iterator<ResultMapping> extendedResultMappingsIter = extendedResultMappings
						.iterator();
				while ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 190 53 8135540")|| true) && (extendedResultMappingsIter
						.hasNext()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 190 15 13 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 190 15 13 0 0 ","8135540",false,0) && false))){ ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 190 54 8135540");  {
					if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 190 55 8135540")|| true) && (extendedResultMappingsIter
							.next()
							.getFlags()
							.contains(
									ResultFlag.CONSTRUCTOR)? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 190 16 14 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 190 16 14 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 190 56 8135540"); {
						extendedResultMappingsIter
								.remove();
					} }
				}}
			} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 190 59 8135540");
			resultMappings
					.addAll(extendedResultMappings);
		} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 190 60 8135540");
		resultMapBuilder
				.discriminator(discriminator);
		ResultMap resultMap = resultMapBuilder
				.build();
		configuration
				.addResultMap(resultMap);
		return resultMap;
	}

	public Discriminator buildDiscriminator(
			Class<?> resultType,
			String column,
			Class<?> javaType,
			JdbcType jdbcType,
			Class<? extends TypeHandler<?>> typeHandler,
			Map<String, String> discriminatorMap) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 190 61 8135540"); 
		ResultMapping resultMapping = buildResultMapping(
				resultType,
				null,
				column,
				javaType,
				jdbcType,
				null,
				null,
				null,
				null,
				typeHandler,
				new ArrayList<ResultFlag>(),
				null, null, false);
		Map<String, String> namespaceDiscriminatorMap = new HashMap<String, String>();
		for (Map.Entry<String, String> e : /* TRUE */discriminatorMap
				.entrySet()){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 190 62 8135540");ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 190 63 8135540"); {
			String resultMap = e
					.getValue();
			resultMap = applyCurrentNamespace(
					resultMap, true);
			namespaceDiscriminatorMap
					.put(e.getKey(),
							resultMap);
		}}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 190 64 8135540");
		Discriminator.Builder discriminatorBuilder = new Discriminator.Builder(
				configuration,
				resultMapping,
				namespaceDiscriminatorMap);
		return discriminatorBuilder
				.build();
	}

	public MappedStatement addMappedStatement(
			String id,
			SqlSource sqlSource,
			StatementType statementType,
			SqlCommandType sqlCommandType,
			Integer fetchSize,
			Integer timeout,
			String parameterMap,
			Class<?> parameterType,
			String resultMap,
			Class<?> resultType,
			ResultSetType resultSetType,
			boolean flushCache,
			boolean useCache,
			boolean resultOrdered,
			KeyGenerator keyGenerator,
			String keyProperty,
			String keyColumn,
			String databaseId,
			LanguageDriver lang,
			String resultSets) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 190 65 8135540"); 

		if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 190 66 8135540")|| true) && (unresolvedCacheRef? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 190 17 15 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 190 17 15 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 190 67 8135540");
			throw new IncompleteElementException(
					"Cache-ref not yet resolved"); }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 190 68 8135540");

		id = applyCurrentNamespace(id,
				false);
		boolean isSelect = sqlCommandType == SqlCommandType.SELECT;

		MappedStatement.Builder statementBuilder = new MappedStatement.Builder(
				configuration, id,
				sqlSource,
				sqlCommandType);
		statementBuilder
				.resource(resource);
		statementBuilder
				.fetchSize(fetchSize);
		statementBuilder
				.statementType(statementType);
		statementBuilder
				.keyGenerator(keyGenerator);
		statementBuilder
				.keyProperty(keyProperty);
		statementBuilder
				.keyColumn(keyColumn);
		statementBuilder
				.databaseId(databaseId);
		statementBuilder.lang(lang);
		statementBuilder
				.resultOrdered(resultOrdered);
		statementBuilder
				.resulSets(resultSets);
		setStatementTimeout(timeout,
				statementBuilder);

		setStatementParameterMap(
				parameterMap,
				parameterType,
				statementBuilder);
		setStatementResultMap(
				resultMap, resultType,
				resultSetType,
				statementBuilder);
		setStatementCache(isSelect,
				flushCache, useCache,
				currentCache,
				statementBuilder);

		MappedStatement statement = statementBuilder
				.build();
		configuration
				.addMappedStatement(statement);
		return statement;
	}

	private <T> T valueOrDefault(
			T value, T defaultValue) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 190 69 8135540"); 
		return value == null ? defaultValue
				: value;
	}

	private void setStatementCache(
			boolean isSelect,
			boolean flushCache,
			boolean useCache,
			Cache cache,
			MappedStatement.Builder statementBuilder) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 190 70 8135540"); 
		flushCache = valueOrDefault(
				flushCache, !isSelect);
		useCache = valueOrDefault(
				useCache, isSelect);
		statementBuilder
				.flushCacheRequired(flushCache);
		statementBuilder
				.useCache(useCache);
		statementBuilder.cache(cache);
	}

	private void setStatementParameterMap(
			String parameterMap,
			Class<?> parameterTypeClass,
			MappedStatement.Builder statementBuilder) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 190 71 8135540"); 
		parameterMap = applyCurrentNamespace(
				parameterMap, true);

		if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 190 72 8135540")|| true) && (parameterMap != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 190 18 16 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 190 18 16 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 190 73 8135540"); {
			try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 190 74 8135540"); 
				statementBuilder
						.parameterMap(configuration
								.getParameterMap(parameterMap));
			} catch (IllegalArgumentException e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 190 75 8135540"); 
				throw new IncompleteElementException(
						"Could not find parameter map "
								+ parameterMap,
						e);
			}
		} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 190 77 8135540");  if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 190 78 8135540")|| true) && (parameterTypeClass != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 190 19 17 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 190 19 17 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 190 79 8135540"); {
			List<ParameterMapping> parameterMappings = new ArrayList<ParameterMapping>();
			ParameterMap.Builder inlineParameterMapBuilder = new ParameterMap.Builder(
					configuration,
					statementBuilder
							.id()
							+ "-Inline",
					parameterTypeClass,
					parameterMappings);
			statementBuilder
					.parameterMap(inlineParameterMapBuilder
							.build());
		} } }
	}

	private void setStatementResultMap(
			String resultMap,
			Class<?> resultType,
			ResultSetType resultSetType,
			MappedStatement.Builder statementBuilder) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 190 82 8135540"); 
		resultMap = applyCurrentNamespace(
				resultMap, true);

		List<ResultMap> resultMaps = new ArrayList<ResultMap>();
		if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 190 83 8135540")|| true) && (resultMap != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 190 20 18 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 190 20 18 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 190 84 8135540"); {
			String[] resultMapNames = resultMap
					.split(",");
			for (String resultMapName : /* TRUE */resultMapNames){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 190 85 8135540");ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 190 86 8135540"); {
				try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 190 87 8135540"); 
					resultMaps
							.add(configuration
									.getResultMap(resultMapName
											.trim()));
				} catch (IllegalArgumentException e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 190 88 8135540"); 
					throw new IncompleteElementException(
							"Could not find result map "
									+ resultMapName,
							e);
				}
			}}
		} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 190 91 8135540");  if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 190 92 8135540")|| true) && (resultType != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 190 21 19 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 190 21 19 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 190 93 8135540"); {
			ResultMap.Builder inlineResultMapBuilder = new ResultMap.Builder(
					configuration,
					statementBuilder
							.id()
							+ "-Inline",
					resultType,
					new ArrayList<ResultMapping>(),
					null);
			resultMaps
					.add(inlineResultMapBuilder
							.build());
		} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 190 94 8135540"); }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 190 95 8135540");
		statementBuilder
				.resultMaps(resultMaps);

		statementBuilder
				.resultSetType(resultSetType);
	}

	private void setStatementTimeout(
			Integer timeout,
			MappedStatement.Builder statementBuilder) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 190 96 8135540"); 
		if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 190 97 8135540")|| true) && (timeout == null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 190 22 20 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 190 22 20 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 190 98 8135540"); {
			timeout = configuration
					.getDefaultStatementTimeout();
		} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 190 99 8135540");
		statementBuilder
				.timeout(timeout);
	}

	public ResultMapping buildResultMapping(
			Class<?> resultType,
			String property,
			String column,
			Class<?> javaType,
			JdbcType jdbcType,
			String nestedSelect,
			String nestedResultMap,
			String notNullColumn,
			String columnPrefix,
			Class<? extends TypeHandler<?>> typeHandler,
			List<ResultFlag> flags,
			String resultSet,
			String foreignColumn,
			boolean lazy) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 190 100 8135540"); 
		Class<?> javaTypeClass = resolveResultJavaType(
				resultType, property,
				javaType);
		TypeHandler<?> typeHandlerInstance = resolveTypeHandler(
				javaTypeClass,
				typeHandler);
		List<ResultMapping> composites = parseCompositeColumnName(column);
		if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 190 101 8135540")|| true) && (composites.size() > 0? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 190 23 21 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 190 23 21 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 190 102 8135540");
			column = null; }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 190 103 8135540");
		ResultMapping.Builder builder = new ResultMapping.Builder(
				configuration,
				property, column,
				javaTypeClass);
		builder.jdbcType(jdbcType);
		builder.nestedQueryId(applyCurrentNamespace(
				nestedSelect, true));
		builder.nestedResultMapId(applyCurrentNamespace(
				nestedResultMap, true));
		builder.resultSet(resultSet);
		builder.typeHandler(typeHandlerInstance);
		builder.flags(flags == null ? new ArrayList<ResultFlag>()
				: flags);
		builder.composites(composites);
		builder.notNullColumns(parseMultipleColumnNames(notNullColumn));
		builder.columnPrefix(columnPrefix);
		builder.foreignColumn(foreignColumn);
		builder.lazy(lazy);
		return builder.build();
	}

	private Set<String> parseMultipleColumnNames(
			String columnName) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 190 104 8135540"); 
		Set<String> columns = new HashSet<String>();
		if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 190 105 8135540")|| true) && (columnName != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 190 24 22 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 190 24 22 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 190 106 8135540"); {
			if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 190 107 8135540")|| true) && (columnName.indexOf(',') > -1? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 190 25 23 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 190 25 23 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 190 108 8135540"); {
				StringTokenizer parser = new StringTokenizer(
						columnName,
						"{}, ", false);
				while ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 190 109 8135540")|| true) && (parser
						.hasMoreTokens()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 190 26 24 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 190 26 24 0 0 ","8135540",false,0) && false))){ ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 190 110 8135540");  {
					String column = parser
							.nextToken();
					columns.add(column);
				}}
			} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 190 112 8135540");  {
				columns.add(columnName);
			} }
		} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 190 114 8135540");
		return columns;
	}

	private List<ResultMapping> parseCompositeColumnName(
			String columnName) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 190 115 8135540"); 
		List<ResultMapping> composites = new ArrayList<ResultMapping>();
		int zoa_cond_n116_0 = 2;
int zoa_cond_n116_1 = 2;
int zoa_cond_n116_2 = 2;
int zoa_cond_n116_3 = 6;
//zoa_cond_n116_0#columnName != null$zoa_cond_n116_1#columnName.indexOf('=') > -1$zoa_cond_n116_2#columnName.indexOf(',') > -1$zoa_cond_n116_3#columnName.indexOf('=') > -1 || columnName.indexOf(',') > -1
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 190 116 8135540")|| true) && ((columnName != null?(zoa_cond_n116_0 != (zoa_cond_n116_0 = 1)):(zoa_cond_n116_0 == (zoa_cond_n116_0 = 0)))
				&& ((columnName
						.indexOf('=') > -1?(zoa_cond_n116_1 != (zoa_cond_n116_1 = 1)):(zoa_cond_n116_1 == (zoa_cond_n116_1 = 0))) || (columnName
						.indexOf(',') > -1?(zoa_cond_n116_2 != (zoa_cond_n116_2 = 1)):(zoa_cond_n116_2 == (zoa_cond_n116_2 = 0)))?(zoa_cond_n116_3 != (zoa_cond_n116_3 = 5)):(zoa_cond_n116_3 == (zoa_cond_n116_3 = 4)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 190 31 25 1 4 ","8135540",true,zoa_cond_n116_0,zoa_cond_n116_1,zoa_cond_n116_2,zoa_cond_n116_3) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 190 31 25 0 4 ","8135540",false,zoa_cond_n116_0,zoa_cond_n116_1,zoa_cond_n116_2,zoa_cond_n116_3) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 190 117 8135540"); {
			StringTokenizer parser = new StringTokenizer(
					columnName,
					"{}=, ", false);
			while ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 190 118 8135540")|| true) && (parser
					.hasMoreTokens()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 190 32 26 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 190 32 26 0 0 ","8135540",false,0) && false))){ ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 190 119 8135540");  {
				String property = parser
						.nextToken();
				String column = parser
						.nextToken();
				ResultMapping.Builder complexBuilder = new ResultMapping.Builder(
						configuration,
						property,
						column,
						configuration
								.getTypeHandlerRegistry()
								.getUnknownTypeHandler());
				composites
						.add(complexBuilder
								.build());
			}}
		} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 190 121 8135540");
		return composites;
	}

	private Class<?> resolveResultJavaType(
			Class<?> resultType,
			String property,
			Class<?> javaType) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 190 122 8135540"); 
		int zoa_cond_n123_0 = 2;
int zoa_cond_n123_1 = 2;
//zoa_cond_n123_0#javaType == null$zoa_cond_n123_1#property != null
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 190 123 8135540")|| true) && ((javaType == null?(zoa_cond_n123_0 != (zoa_cond_n123_0 = 1)):(zoa_cond_n123_0 == (zoa_cond_n123_0 = 0)))
				&& (property != null?(zoa_cond_n123_1 != (zoa_cond_n123_1 = 1)):(zoa_cond_n123_1 == (zoa_cond_n123_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 190 35 27 1 2 ","8135540",true,zoa_cond_n123_0,zoa_cond_n123_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 190 35 27 0 2 ","8135540",false,zoa_cond_n123_0,zoa_cond_n123_1) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 190 124 8135540"); {
			try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 190 125 8135540"); 
				MetaClass metaResultType = MetaClass
						.forClass(resultType);
				javaType = metaResultType
						.getSetterType(property);
			} catch (Exception e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 190 126 8135540"); 
				// ignore, following null check statement will deal with the
				// situation
			}
		} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 190 128 8135540");
		if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 190 129 8135540")|| true) && (javaType == null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 190 36 28 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 190 36 28 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 190 130 8135540"); {
			javaType = Object.class;
		} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 190 131 8135540");
		return javaType;
	}

	private Class<?> resolveParameterJavaType(
			Class<?> resultType,
			String property,
			Class<?> javaType,
			JdbcType jdbcType) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 190 132 8135540"); 
		if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 190 133 8135540")|| true) && (javaType == null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 190 37 29 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 190 37 29 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 190 134 8135540"); {
			if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 190 135 8135540")|| true) && (JdbcType.CURSOR
					.equals(jdbcType)? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 190 38 30 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 190 38 30 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 190 136 8135540"); {
				javaType = java.sql.ResultSet.class;
			} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 190 137 8135540");  if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 190 138 8135540")|| true) && (Map.class
					.isAssignableFrom(resultType)? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 190 39 31 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 190 39 31 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 190 139 8135540"); {
				javaType = Object.class;
			} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 190 140 8135540");  {
				MetaClass metaResultType = MetaClass
						.forClass(resultType);
				javaType = metaResultType
						.getGetterType(property);
			} } }
		} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 190 143 8135540");
		if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 190 144 8135540")|| true) && (javaType == null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 190 40 32 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 190 40 32 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 190 145 8135540"); {
			javaType = Object.class;
		} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 190 146 8135540");
		return javaType;
	}

	/** Backward compatibility signature */
	public ResultMapping buildResultMapping(
			Class<?> resultType,
			String property,
			String column,
			Class<?> javaType,
			JdbcType jdbcType,
			String nestedSelect,
			String nestedResultMap,
			String notNullColumn,
			String columnPrefix,
			Class<? extends TypeHandler<?>> typeHandler,
			List<ResultFlag> flags) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 190 147 8135540"); 
		return buildResultMapping(
				resultType,
				property,
				column,
				javaType,
				jdbcType,
				nestedSelect,
				nestedResultMap,
				notNullColumn,
				columnPrefix,
				typeHandler,
				flags,
				null,
				null,
				configuration
						.isLazyLoadingEnabled());
	}

	public LanguageDriver getLanguageDriver(
			Class<?> langClass) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 190 148 8135540"); 
		if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 190 149 8135540")|| true) && (langClass != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 190 41 33 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 190 41 33 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 190 150 8135540"); {
			configuration
					.getLanguageRegistry()
					.register(langClass);
		} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 190 151 8135540");  {
			langClass = configuration
					.getLanguageRegistry()
					.getDefaultDriverClass();
		} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 190 152 8135540");
		return configuration
				.getLanguageRegistry()
				.getDriver(langClass);
	}

	/** Backward compatibility signature */
	public MappedStatement addMappedStatement(
			String id,
			SqlSource sqlSource,
			StatementType statementType,
			SqlCommandType sqlCommandType,
			Integer fetchSize,
			Integer timeout,
			String parameterMap,
			Class<?> parameterType,
			String resultMap,
			Class<?> resultType,
			ResultSetType resultSetType,
			boolean flushCache,
			boolean useCache,
			boolean resultOrdered,
			KeyGenerator keyGenerator,
			String keyProperty,
			String keyColumn,
			String databaseId,
			LanguageDriver lang) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 190 153 8135540"); 
		return addMappedStatement(id,
				sqlSource,
				statementType,
				sqlCommandType,
				fetchSize, timeout,
				parameterMap,
				parameterType,
				resultMap, resultType,
				resultSetType,
				flushCache, useCache,
				resultOrdered,
				keyGenerator,
				keyProperty, keyColumn,
				databaseId, lang, null);
	}

}

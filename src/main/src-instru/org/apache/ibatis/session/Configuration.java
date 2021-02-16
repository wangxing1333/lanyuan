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
package org.apache.ibatis.session;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.apache.ibatis.binding.MapperRegistry;
import org.apache.ibatis.builder.CacheRefResolver;
import org.apache.ibatis.builder.ResultMapResolver;
import org.apache.ibatis.builder.annotation.MethodResolver;
import org.apache.ibatis.builder.xml.XMLStatementBuilder;
import org.apache.ibatis.cache.Cache;
import org.apache.ibatis.cache.decorators.FifoCache;
import org.apache.ibatis.cache.decorators.LruCache;
import org.apache.ibatis.cache.decorators.SoftCache;
import org.apache.ibatis.cache.decorators.WeakCache;
import org.apache.ibatis.cache.impl.PerpetualCache;
import org.apache.ibatis.datasource.jndi.JndiDataSourceFactory;
import org.apache.ibatis.datasource.pooled.PooledDataSourceFactory;
import org.apache.ibatis.datasource.unpooled.UnpooledDataSourceFactory;
import org.apache.ibatis.executor.BatchExecutor;
import org.apache.ibatis.executor.CachingExecutor;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.ReuseExecutor;
import org.apache.ibatis.executor.SimpleExecutor;
import org.apache.ibatis.executor.keygen.KeyGenerator;
import org.apache.ibatis.executor.loader.ProxyFactory;
import org.apache.ibatis.executor.loader.cglib.CglibProxyFactory;
import org.apache.ibatis.executor.loader.javassist.JavassistProxyFactory;
import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.resultset.DefaultResultSetHandler;
import org.apache.ibatis.executor.resultset.ResultSetHandler;
import org.apache.ibatis.executor.statement.RoutingStatementHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.logging.commons.JakartaCommonsLoggingImpl;
import org.apache.ibatis.logging.jdk14.Jdk14LoggingImpl;
import org.apache.ibatis.logging.log4j.Log4jImpl;
import org.apache.ibatis.logging.log4j2.Log4j2Impl;
import org.apache.ibatis.logging.nologging.NoLoggingImpl;
import org.apache.ibatis.logging.slf4j.Slf4jImpl;
import org.apache.ibatis.logging.stdout.StdOutImpl;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMap;
import org.apache.ibatis.mapping.ResultMap;
import org.apache.ibatis.mapping.VendorDatabaseIdProvider;
import org.apache.ibatis.parsing.XNode;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.InterceptorChain;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;
import org.apache.ibatis.reflection.factory.ObjectFactory;
import org.apache.ibatis.reflection.wrapper.DefaultObjectWrapperFactory;
import org.apache.ibatis.reflection.wrapper.ObjectWrapperFactory;
import org.apache.ibatis.scripting.LanguageDriver;
import org.apache.ibatis.scripting.LanguageDriverRegistry;
import org.apache.ibatis.scripting.defaults.RawLanguageDriver;
import org.apache.ibatis.scripting.xmltags.XMLLanguageDriver;
import org.apache.ibatis.transaction.Transaction;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.apache.ibatis.transaction.managed.ManagedTransactionFactory;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeAliasRegistry;
import org.apache.ibatis.type.TypeHandlerRegistry;

/**
 * @author Clinton Begin
 */
import com.process.ZoaExp;
import com.process.ZoaThreadLocal;
public class Configuration {

	protected Environment environment;

	protected boolean safeRowBoundsEnabled = false;
	protected boolean safeResultHandlerEnabled = true;
	protected boolean mapUnderscoreToCamelCase = false;
	protected boolean aggressiveLazyLoading = true;
	protected boolean multipleResultSetsEnabled = true;
	protected boolean useGeneratedKeys = false;
	protected boolean useColumnLabel = true;
	protected boolean cacheEnabled = true;
	protected boolean callSettersOnNulls = false;
	protected String logPrefix;
	protected Class<? extends Log> logImpl;
	protected LocalCacheScope localCacheScope = LocalCacheScope.SESSION;
	protected JdbcType jdbcTypeForNull = JdbcType.OTHER;
	protected Set<String> lazyLoadTriggerMethods = new HashSet<String>(
			Arrays.asList(new String[] {
					"equals", "clone",
					"hashCode",
					"toString" }));
	protected Integer defaultStatementTimeout;
	protected ExecutorType defaultExecutorType = ExecutorType.SIMPLE;
	protected AutoMappingBehavior autoMappingBehavior = AutoMappingBehavior.PARTIAL;

	protected Properties variables = new Properties();
	protected ObjectFactory objectFactory = new DefaultObjectFactory();
	protected ObjectWrapperFactory objectWrapperFactory = new DefaultObjectWrapperFactory();
	protected MapperRegistry mapperRegistry = new MapperRegistry(
			this);

	protected boolean lazyLoadingEnabled = false;
	protected ProxyFactory proxyFactory;

	protected String databaseId;
	/**
	 * Configuration factory class. Used to create Configuration for loading
	 * deserialized unread properties.
	 * 
	 * @see <a
	 *      href='https://code.google.com/p/mybatis/issues/detail?id=300'>Issue
	 *      300</a> (google code)
	 */
	protected Class<?> configurationFactory;

	protected final InterceptorChain interceptorChain = new InterceptorChain();
	protected final TypeHandlerRegistry typeHandlerRegistry = new TypeHandlerRegistry();
	protected final TypeAliasRegistry typeAliasRegistry = new TypeAliasRegistry();
	protected final LanguageDriverRegistry languageRegistry = new LanguageDriverRegistry();

	protected final Map<String, MappedStatement> mappedStatements = new StrictMap<MappedStatement>(
			"Mapped Statements collection");
	protected final Map<String, Cache> caches = new StrictMap<Cache>(
			"Caches collection");
	protected final Map<String, ResultMap> resultMaps = new StrictMap<ResultMap>(
			"Result Maps collection");
	protected final Map<String, ParameterMap> parameterMaps = new StrictMap<ParameterMap>(
			"Parameter Maps collection");
	protected final Map<String, KeyGenerator> keyGenerators = new StrictMap<KeyGenerator>(
			"Key Generators collection");

	protected final Set<String> loadedResources = new HashSet<String>();
	protected final Map<String, XNode> sqlFragments = new StrictMap<XNode>(
			"XML fragments parsed from previous mappers");

	protected final Collection<XMLStatementBuilder> incompleteStatements = new LinkedList<XMLStatementBuilder>();
	protected final Collection<CacheRefResolver> incompleteCacheRefs = new LinkedList<CacheRefResolver>();
	protected final Collection<ResultMapResolver> incompleteResultMaps = new LinkedList<ResultMapResolver>();
	protected final Collection<MethodResolver> incompleteMethods = new LinkedList<MethodResolver>();

	public static final String SHOW_COLUMNS_FROM = "show columns from ";

	public static final String COLUMN_KEY = "column_key";

	public static final String FIELD = "field";

	public static final String LY_TABLE = "ly_table";

	public static final String FINDBYWHERE = "findByWhere";

	public static final String FINDBYPAGE = "findByPage";

	public static final String DELETEBYNAMES = "deleteByNames";

	public static final String DELETEBYATTRIBUTE = "deleteByAttribute";

	public static final String FINDBYNAMES = "findByNames";

	public static final String FINDBYATTRIBUTE = "findByAttribute";

	public static final String ADDENTITY = "addEntity";

	public static final String EDITENTITY = "editEntity";

	public static final String FINDBYFRIST = "findbyFrist";

	public static final String BATCHSAVE = "batchSave";

	/*
	 * A map holds cache-ref relationship. The key is the namespace that
	 * references a cache bound to another namespace and the value is the
	 * namespace which the actual cache is bound to.
	 */
	protected final Map<String, String> cacheRefMap = new HashMap<String, String>();

	public Configuration(
			Environment environment) {
		this();
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 279 0 8135540"); 
		this.environment = environment;
	}

	public Configuration() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 279 1 8135540"); 
		typeAliasRegistry
				.registerAlias(
						"JDBC",
						JdbcTransactionFactory.class);
		typeAliasRegistry
				.registerAlias(
						"MANAGED",
						ManagedTransactionFactory.class);

		typeAliasRegistry
				.registerAlias(
						"JNDI",
						JndiDataSourceFactory.class);
		typeAliasRegistry
				.registerAlias(
						"POOLED",
						PooledDataSourceFactory.class);
		typeAliasRegistry
				.registerAlias(
						"UNPOOLED",
						UnpooledDataSourceFactory.class);

		typeAliasRegistry
				.registerAlias(
						"PERPETUAL",
						PerpetualCache.class);
		typeAliasRegistry
				.registerAlias("FIFO",
						FifoCache.class);
		typeAliasRegistry
				.registerAlias("LRU",
						LruCache.class);
		typeAliasRegistry
				.registerAlias("SOFT",
						SoftCache.class);
		typeAliasRegistry
				.registerAlias("WEAK",
						WeakCache.class);

		typeAliasRegistry
				.registerAlias(
						"DB_VENDOR",
						VendorDatabaseIdProvider.class);

		typeAliasRegistry
				.registerAlias(
						"XML",
						XMLLanguageDriver.class);
		typeAliasRegistry
				.registerAlias(
						"RAW",
						RawLanguageDriver.class);

		typeAliasRegistry
				.registerAlias("SLF4J",
						Slf4jImpl.class);
		typeAliasRegistry
				.registerAlias(
						"COMMONS_LOGGING",
						JakartaCommonsLoggingImpl.class);
		typeAliasRegistry
				.registerAlias("LOG4J",
						Log4jImpl.class);
		typeAliasRegistry
				.registerAlias(
						"LOG4J2",
						Log4j2Impl.class);
		typeAliasRegistry
				.registerAlias(
						"JDK_LOGGING",
						Jdk14LoggingImpl.class);
		typeAliasRegistry
				.registerAlias(
						"STDOUT_LOGGING",
						StdOutImpl.class);
		typeAliasRegistry
				.registerAlias(
						"NO_LOGGING",
						NoLoggingImpl.class);

		typeAliasRegistry
				.registerAlias(
						"CGLIB",
						CglibProxyFactory.class);
		typeAliasRegistry
				.registerAlias(
						"JAVASSIST",
						JavassistProxyFactory.class);

		languageRegistry
				.setDefaultDriverClass(XMLLanguageDriver.class);
		languageRegistry
				.register(RawLanguageDriver.class);
	}

	public String getLogPrefix() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 279 2 8135540"); 
		return logPrefix;
	}

	public void setLogPrefix(
			String logPrefix) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 279 3 8135540"); 
		this.logPrefix = logPrefix;
	}

	public Class<? extends Log> getLogImpl() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 279 4 8135540"); 
		return logImpl;
	}

	@SuppressWarnings("unchecked")
	public void setLogImpl(
			Class<?> logImpl) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 279 5 8135540"); 
		if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 279 6 8135540")|| true) && (logImpl != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 279 0 0 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 279 0 0 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 279 7 8135540"); {
			this.logImpl = (Class<? extends Log>) logImpl;
			LogFactory
					.useCustomLogging(this.logImpl);
		} }
	}

	public boolean isCallSettersOnNulls() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 279 9 8135540"); 
		return callSettersOnNulls;
	}

	public void setCallSettersOnNulls(
			boolean callSettersOnNulls) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 279 10 8135540"); 
		this.callSettersOnNulls = callSettersOnNulls;
	}

	public String getDatabaseId() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 279 11 8135540"); 
		return databaseId;
	}

	public void setDatabaseId(
			String databaseId) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 279 12 8135540"); 
		this.databaseId = databaseId;
	}

	public Class<?> getConfigurationFactory() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 279 13 8135540"); 
		return configurationFactory;
	}

	public void setConfigurationFactory(
			Class<?> configurationFactory) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 279 14 8135540"); 
		this.configurationFactory = configurationFactory;
	}

	public boolean isSafeResultHandlerEnabled() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 279 15 8135540"); 
		return safeResultHandlerEnabled;
	}

	public void setSafeResultHandlerEnabled(
			boolean safeResultHandlerEnabled) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 279 16 8135540"); 
		this.safeResultHandlerEnabled = safeResultHandlerEnabled;
	}

	public boolean isSafeRowBoundsEnabled() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 279 17 8135540"); 
		return safeRowBoundsEnabled;
	}

	public void setSafeRowBoundsEnabled(
			boolean safeRowBoundsEnabled) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 279 18 8135540"); 
		this.safeRowBoundsEnabled = safeRowBoundsEnabled;
	}

	public boolean isMapUnderscoreToCamelCase() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 279 19 8135540"); 
		return mapUnderscoreToCamelCase;
	}

	public void setMapUnderscoreToCamelCase(
			boolean mapUnderscoreToCamelCase) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 279 20 8135540"); 
		this.mapUnderscoreToCamelCase = mapUnderscoreToCamelCase;
	}

	public void addLoadedResource(
			String resource) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 279 21 8135540"); 
		loadedResources.add(resource);
	}

	public boolean isResourceLoaded(
			String resource) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 279 22 8135540"); 
		return loadedResources
				.contains(resource);
	}

	public Environment getEnvironment() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 279 23 8135540"); 
		return environment;
	}

	public void setEnvironment(
			Environment environment) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 279 24 8135540"); 
		this.environment = environment;
	}

	public AutoMappingBehavior getAutoMappingBehavior() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 279 25 8135540"); 
		return autoMappingBehavior;
	}

	public void setAutoMappingBehavior(
			AutoMappingBehavior autoMappingBehavior) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 279 26 8135540"); 
		this.autoMappingBehavior = autoMappingBehavior;
	}

	public boolean isLazyLoadingEnabled() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 279 27 8135540"); 
		return lazyLoadingEnabled;
	}

	public void setLazyLoadingEnabled(
			boolean lazyLoadingEnabled) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 279 28 8135540"); 
		this.lazyLoadingEnabled = lazyLoadingEnabled;
	}

	public ProxyFactory getProxyFactory() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 279 29 8135540"); 
		if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 279 30 8135540")|| true) && (proxyFactory == null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 279 1 1 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 279 1 1 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 279 31 8135540"); {
			// makes sure CGLIB is not needed unless explicitly requested
			proxyFactory = new CglibProxyFactory();
		} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 279 32 8135540");
		return proxyFactory;
	}

	public void setProxyFactory(
			ProxyFactory proxyFactory) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 279 33 8135540"); 
		this.proxyFactory = proxyFactory;
	}

	public boolean isAggressiveLazyLoading() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 279 34 8135540"); 
		return aggressiveLazyLoading;
	}

	public void setAggressiveLazyLoading(
			boolean aggressiveLazyLoading) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 279 35 8135540"); 
		this.aggressiveLazyLoading = aggressiveLazyLoading;
	}

	public boolean isMultipleResultSetsEnabled() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 279 36 8135540"); 
		return multipleResultSetsEnabled;
	}

	public void setMultipleResultSetsEnabled(
			boolean multipleResultSetsEnabled) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 279 37 8135540"); 
		this.multipleResultSetsEnabled = multipleResultSetsEnabled;
	}

	public Set<String> getLazyLoadTriggerMethods() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 279 38 8135540"); 
		return lazyLoadTriggerMethods;
	}

	public void setLazyLoadTriggerMethods(
			Set<String> lazyLoadTriggerMethods) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 279 39 8135540"); 
		this.lazyLoadTriggerMethods = lazyLoadTriggerMethods;
	}

	public boolean isUseGeneratedKeys() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 279 40 8135540"); 
		return useGeneratedKeys;
	}

	public void setUseGeneratedKeys(
			boolean useGeneratedKeys) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 279 41 8135540"); 
		this.useGeneratedKeys = useGeneratedKeys;
	}

	public ExecutorType getDefaultExecutorType() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 279 42 8135540"); 
		return defaultExecutorType;
	}

	public void setDefaultExecutorType(
			ExecutorType defaultExecutorType) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 279 43 8135540"); 
		this.defaultExecutorType = defaultExecutorType;
	}

	public boolean isCacheEnabled() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 279 44 8135540"); 
		return cacheEnabled;
	}

	public void setCacheEnabled(
			boolean cacheEnabled) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 279 45 8135540"); 
		this.cacheEnabled = cacheEnabled;
	}

	public Integer getDefaultStatementTimeout() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 279 46 8135540"); 
		return defaultStatementTimeout;
	}

	public void setDefaultStatementTimeout(
			Integer defaultStatementTimeout) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 279 47 8135540"); 
		this.defaultStatementTimeout = defaultStatementTimeout;
	}

	public boolean isUseColumnLabel() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 279 48 8135540"); 
		return useColumnLabel;
	}

	public void setUseColumnLabel(
			boolean useColumnLabel) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 279 49 8135540"); 
		this.useColumnLabel = useColumnLabel;
	}

	public LocalCacheScope getLocalCacheScope() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 279 50 8135540"); 
		return localCacheScope;
	}

	public void setLocalCacheScope(
			LocalCacheScope localCacheScope) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 279 51 8135540"); 
		this.localCacheScope = localCacheScope;
	}

	public JdbcType getJdbcTypeForNull() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 279 52 8135540"); 
		return jdbcTypeForNull;
	}

	public void setJdbcTypeForNull(
			JdbcType jdbcTypeForNull) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 279 53 8135540"); 
		this.jdbcTypeForNull = jdbcTypeForNull;
	}

	public Properties getVariables() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 279 54 8135540"); 
		return variables;
	}

	public void setVariables(
			Properties variables) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 279 55 8135540"); 
		this.variables = variables;
	}

	public TypeHandlerRegistry getTypeHandlerRegistry() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 279 56 8135540"); 
		return typeHandlerRegistry;
	}

	public TypeAliasRegistry getTypeAliasRegistry() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 279 57 8135540"); 
		return typeAliasRegistry;
	}

	/**
	 * @since 3.2.2
	 */
	public MapperRegistry getMapperRegistry() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 279 58 8135540"); 
		return mapperRegistry;
	}

	public ObjectFactory getObjectFactory() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 279 59 8135540"); 
		return objectFactory;
	}

	public void setObjectFactory(
			ObjectFactory objectFactory) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 279 60 8135540"); 
		this.objectFactory = objectFactory;
	}

	public ObjectWrapperFactory getObjectWrapperFactory() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 279 61 8135540"); 
		return objectWrapperFactory;
	}

	public void setObjectWrapperFactory(
			ObjectWrapperFactory objectWrapperFactory) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 279 62 8135540"); 
		this.objectWrapperFactory = objectWrapperFactory;
	}

	/**
	 * @since 3.2.2
	 */
	public List<Interceptor> getInterceptors() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 279 63 8135540"); 
		return interceptorChain
				.getInterceptors();
	}

	public LanguageDriverRegistry getLanguageRegistry() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 279 64 8135540"); 
		return languageRegistry;
	}

	public void setDefaultScriptingLanguage(
			Class<?> driver) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 279 65 8135540"); 
		if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 279 66 8135540")|| true) && (driver == null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 279 2 2 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 279 2 2 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 279 67 8135540"); {
			driver = XMLLanguageDriver.class;
		} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 279 68 8135540");
		getLanguageRegistry()
				.setDefaultDriverClass(
						driver);
	}

	public LanguageDriver getDefaultScriptingLanuageInstance() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 279 69 8135540"); 
		return languageRegistry
				.getDefaultDriver();
	}

	public MetaObject newMetaObject(
			Object object) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 279 70 8135540"); 
		return MetaObject.forObject(
				object, objectFactory,
				objectWrapperFactory);
	}

	public ParameterHandler newParameterHandler(
			MappedStatement mappedStatement,
			Object parameterObject,
			BoundSql boundSql) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 279 71 8135540"); 
		ParameterHandler parameterHandler = mappedStatement
				.getLang()
				.createParameterHandler(
						mappedStatement,
						parameterObject,
						boundSql);
		parameterHandler = (ParameterHandler) interceptorChain
				.pluginAll(parameterHandler);
		return parameterHandler;
	}

	public ResultSetHandler newResultSetHandler(
			Executor executor,
			MappedStatement mappedStatement,
			RowBounds rowBounds,
			ParameterHandler parameterHandler,
			ResultHandler resultHandler,
			BoundSql boundSql) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 279 72 8135540"); 
		ResultSetHandler resultSetHandler = new DefaultResultSetHandler(
				executor,
				mappedStatement,
				parameterHandler,
				resultHandler,
				boundSql, rowBounds);
		resultSetHandler = (ResultSetHandler) interceptorChain
				.pluginAll(resultSetHandler);
		return resultSetHandler;
	}

	public StatementHandler newStatementHandler(
			Executor executor,
			MappedStatement mappedStatement,
			Object parameterObject,
			RowBounds rowBounds,
			ResultHandler resultHandler,
			BoundSql boundSql) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 279 73 8135540"); 
		StatementHandler statementHandler = new RoutingStatementHandler(
				executor,
				mappedStatement,
				parameterObject,
				rowBounds,
				resultHandler, boundSql);
		statementHandler = (StatementHandler) interceptorChain
				.pluginAll(statementHandler);
		return statementHandler;
	}

	public Executor newExecutor(
			Transaction transaction) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 279 74 8135540"); 
		return newExecutor(transaction,
				defaultExecutorType);
	}

	public Executor newExecutor(
			Transaction transaction,
			ExecutorType executorType) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 279 75 8135540"); 
		executorType = executorType == null ? defaultExecutorType
				: executorType;
		executorType = executorType == null ? ExecutorType.SIMPLE
				: executorType;
		Executor executor;
		if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 279 76 8135540")|| true) && (ExecutorType.BATCH == executorType? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 279 3 3 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 279 3 3 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 279 77 8135540"); {
			executor = new BatchExecutor(
					this, transaction);
		} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 279 78 8135540");  if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 279 79 8135540")|| true) && (ExecutorType.REUSE == executorType? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 279 4 4 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 279 4 4 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 279 80 8135540"); {
			executor = new ReuseExecutor(
					this, transaction);
		} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 279 81 8135540");  {
			executor = new SimpleExecutor(
					this, transaction);
		} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 279 82 8135540"); }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 279 83 8135540");
		if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 279 84 8135540")|| true) && (cacheEnabled? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 279 5 5 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 279 5 5 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 279 85 8135540"); {
			executor = new CachingExecutor(
					executor);
		} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 279 86 8135540");
		executor = (Executor) interceptorChain
				.pluginAll(executor);
		return executor;
	}

	public void addKeyGenerator(
			String id,
			KeyGenerator keyGenerator) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 279 87 8135540"); 
		keyGenerators.put(id,
				keyGenerator);
	}

	public Collection<String> getKeyGeneratorNames() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 279 88 8135540"); 
		return keyGenerators.keySet();
	}

	public Collection<KeyGenerator> getKeyGenerators() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 279 89 8135540"); 
		return keyGenerators.values();
	}

	public KeyGenerator getKeyGenerator(
			String id) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 279 90 8135540"); 
		return keyGenerators.get(id);
	}

	public boolean hasKeyGenerator(
			String id) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 279 91 8135540"); 
		return keyGenerators
				.containsKey(id);
	}

	public void addCache(Cache cache) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 279 92 8135540"); 
		caches.put(cache.getId(), cache);
	}

	public Collection<String> getCacheNames() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 279 93 8135540"); 
		return caches.keySet();
	}

	public Collection<Cache> getCaches() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 279 94 8135540"); 
		return caches.values();
	}

	public Cache getCache(String id) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 279 95 8135540"); 
		return caches.get(id);
	}

	public boolean hasCache(String id) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 279 96 8135540"); 
		return caches.containsKey(id);
	}

	public void addResultMap(
			ResultMap rm) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 279 97 8135540"); 
		resultMaps.put(rm.getId(), rm);
		checkLocallyForDiscriminatedNestedResultMaps(rm);
		checkGloballyForDiscriminatedNestedResultMaps(rm);
	}

	public Collection<String> getResultMapNames() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 279 98 8135540"); 
		return resultMaps.keySet();
	}

	public Collection<ResultMap> getResultMaps() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 279 99 8135540"); 
		return resultMaps.values();
	}

	public ResultMap getResultMap(
			String id) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 279 100 8135540"); 
		return resultMaps.get(id);
	}

	public boolean hasResultMap(
			String id) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 279 101 8135540"); 
		return resultMaps
				.containsKey(id);
	}

	public void addParameterMap(
			ParameterMap pm) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 279 102 8135540"); 
		parameterMaps.put(pm.getId(),
				pm);
	}

	public Collection<String> getParameterMapNames() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 279 103 8135540"); 
		return parameterMaps.keySet();
	}

	public Collection<ParameterMap> getParameterMaps() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 279 104 8135540"); 
		return parameterMaps.values();
	}

	public ParameterMap getParameterMap(
			String id) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 279 105 8135540"); 
		return parameterMaps.get(id);
	}

	public boolean hasParameterMap(
			String id) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 279 106 8135540"); 
		return parameterMaps
				.containsKey(id);
	}

	public void addMappedStatement(
			MappedStatement ms) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 279 107 8135540"); 
		mappedStatements.put(
				ms.getId(), ms);
	}

	public Collection<String> getMappedStatementNames() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 279 108 8135540"); 
		buildAllStatements();
		return mappedStatements
				.keySet();
	}

	public Collection<MappedStatement> getMappedStatements() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 279 109 8135540"); 
		buildAllStatements();
		return mappedStatements
				.values();
	}

	public Collection<XMLStatementBuilder> getIncompleteStatements() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 279 110 8135540"); 
		return incompleteStatements;
	}

	public void addIncompleteStatement(
			XMLStatementBuilder incompleteStatement) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 279 111 8135540"); 
		incompleteStatements
				.add(incompleteStatement);
	}

	public Collection<CacheRefResolver> getIncompleteCacheRefs() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 279 112 8135540"); 
		return incompleteCacheRefs;
	}

	public void addIncompleteCacheRef(
			CacheRefResolver incompleteCacheRef) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 279 113 8135540"); 
		incompleteCacheRefs
				.add(incompleteCacheRef);
	}

	public Collection<ResultMapResolver> getIncompleteResultMaps() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 279 114 8135540"); 
		return incompleteResultMaps;
	}

	public void addIncompleteResultMap(
			ResultMapResolver resultMapResolver) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 279 115 8135540"); 
		incompleteResultMaps
				.add(resultMapResolver);
	}

	public void addIncompleteMethod(
			MethodResolver builder) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 279 116 8135540"); 
		incompleteMethods.add(builder);
	}

	public Collection<MethodResolver> getIncompleteMethods() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 279 117 8135540"); 
		return incompleteMethods;
	}

	public MappedStatement getMappedStatement(
			String id) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 279 118 8135540"); 
		return this.getMappedStatement(
				id, true);
	}

	public MappedStatement getMappedStatement(
			String id,
			boolean validateIncompleteStatements) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 279 119 8135540"); 
		if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 279 120 8135540")|| true) && (validateIncompleteStatements? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 279 6 6 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 279 6 6 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 279 121 8135540"); {
			buildAllStatements();
		} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 279 122 8135540");
		return mappedStatements.get(id);
	}

	public Map<String, XNode> getSqlFragments() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 279 123 8135540"); 
		return sqlFragments;
	}

	public void addInterceptor(
			Interceptor interceptor) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 279 124 8135540"); 
		interceptorChain
				.addInterceptor(interceptor);
	}

	public void addMappers(
			String packageName,
			Class<?> superType) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 279 125 8135540"); 
		mapperRegistry.addMappers(
				packageName, superType);
	}

	public void addMappers(
			String packageName) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 279 126 8135540"); 
		mapperRegistry
				.addMappers(packageName);
	}

	public <T> void addMapper(
			Class<T> type) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 279 127 8135540"); 
		mapperRegistry.addMapper(type);
	}

	public <T> T getMapper(
			Class<T> type,
			SqlSession sqlSession) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 279 128 8135540"); 
		return mapperRegistry
				.getMapper(type,
						sqlSession);
	}

	public boolean hasMapper(
			Class<?> type) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 279 129 8135540"); 
		return mapperRegistry
				.hasMapper(type);
	}

	public boolean hasStatement(
			String statementName) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 279 130 8135540"); 
		return hasStatement(
				statementName, true);
	}

	public boolean hasStatement(
			String statementName,
			boolean validateIncompleteStatements) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 279 131 8135540"); 
		if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 279 132 8135540")|| true) && (validateIncompleteStatements? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 279 7 7 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 279 7 7 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 279 133 8135540"); {
			buildAllStatements();
		} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 279 134 8135540");
		return mappedStatements
				.containsKey(statementName);
	}

	public void addCacheRef(
			String namespace,
			String referencedNamespace) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 279 135 8135540"); 
		cacheRefMap.put(namespace,
				referencedNamespace);
	}

	/*
	 * Parses all the unprocessed statement nodes in the cache. It is
	 * recommended to call this method once all the mappers are added as it
	 * provides fail-fast statement validation.
	 */
	protected void buildAllStatements() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 279 136 8135540"); 
		if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 279 137 8135540")|| true) && (!incompleteResultMaps
				.isEmpty()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 279 8 8 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 279 8 8 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 279 138 8135540"); {
			synchronized (incompleteResultMaps) {
				// This always throws a BuilderException.
				incompleteResultMaps
						.iterator()
						.next()
						.resolve();
			}
		} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 279 139 8135540");
		if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 279 140 8135540")|| true) && (!incompleteCacheRefs
				.isEmpty()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 279 9 9 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 279 9 9 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 279 141 8135540"); {
			synchronized (incompleteCacheRefs) {
				// This always throws a BuilderException.
				incompleteCacheRefs
						.iterator()
						.next()
						.resolveCacheRef();
			}
		} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 279 142 8135540");
		if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 279 143 8135540")|| true) && (!incompleteStatements
				.isEmpty()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 279 10 10 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 279 10 10 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 279 144 8135540"); {
			synchronized (incompleteStatements) {
				// This always throws a BuilderException.
				incompleteStatements
						.iterator()
						.next()
						.parseStatementNode();
			}
		} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 279 145 8135540");
		if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 279 146 8135540")|| true) && (!incompleteMethods
				.isEmpty()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 279 11 11 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 279 11 11 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 279 147 8135540"); {
			synchronized (incompleteMethods) {
				// This always throws a BuilderException.
				incompleteMethods
						.iterator()
						.next()
						.resolve();
			}
		} }
	}

	/*
	 * Extracts namespace from fully qualified statement id.
	 * 
	 * @param statementId
	 * 
	 * @return namespace or null when id does not contain period.
	 */
	protected String extractNamespace(
			String statementId) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 279 149 8135540"); 
		int lastPeriod = statementId
				.lastIndexOf('.');
		return lastPeriod > 0 ? statementId
				.substring(0,
						lastPeriod)
				: null;
	}

	// Slow but a one time cost. A better solution is welcome.
	protected void checkGloballyForDiscriminatedNestedResultMaps(
			ResultMap rm) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 279 150 8135540"); 
		if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 279 151 8135540")|| true) && (rm.hasNestedResultMaps()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 279 12 12 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 279 12 12 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 279 152 8135540"); {
			for (Map.Entry<String, ResultMap> entry : /* TRUE */resultMaps
					.entrySet()){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 279 153 8135540");ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 279 154 8135540"); {
				Object value = entry
						.getValue();
				if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 279 155 8135540")|| true) && (value instanceof ResultMap? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 279 13 13 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 279 13 13 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 279 156 8135540"); {
					ResultMap entryResultMap = (ResultMap) value;
					int zoa_cond_n157_0 = 2;
int zoa_cond_n157_1 = 2;
//zoa_cond_n157_0#entryResultMap.hasNestedResultMaps()$zoa_cond_n157_1#entryResultMap.getDiscriminator() != null
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 279 157 8135540")|| true) && (!(entryResultMap
							.hasNestedResultMaps()?(zoa_cond_n157_0 != (zoa_cond_n157_0 = 1)):(zoa_cond_n157_0 == (zoa_cond_n157_0 = 0)))
							&& (entryResultMap
									.getDiscriminator() != null?(zoa_cond_n157_1 != (zoa_cond_n157_1 = 1)):(zoa_cond_n157_1 == (zoa_cond_n157_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 279 16 14 1 2 ","8135540",true,zoa_cond_n157_0,zoa_cond_n157_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 279 16 14 0 2 ","8135540",false,zoa_cond_n157_0,zoa_cond_n157_1) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 279 158 8135540"); {
						Collection<String> discriminatedResultMapNames = entryResultMap
								.getDiscriminator()
								.getDiscriminatorMap()
								.values();
						if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 279 159 8135540")|| true) && (discriminatedResultMapNames
								.contains(rm
										.getId())? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 279 17 15 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 279 17 15 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 279 160 8135540"); {
							entryResultMap
									.forceNestedResultMaps();
						} }
					} }
				} }
			}}
		} }
	}

	// Slow but a one time cost. A better solution is welcome.
	protected void checkLocallyForDiscriminatedNestedResultMaps(
			ResultMap rm) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 279 166 8135540"); 
		int zoa_cond_n167_0 = 2;
int zoa_cond_n167_1 = 2;
//zoa_cond_n167_0#rm.hasNestedResultMaps()$zoa_cond_n167_1#rm.getDiscriminator() != null
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 279 167 8135540")|| true) && (!(rm.hasNestedResultMaps()?(zoa_cond_n167_0 != (zoa_cond_n167_0 = 1)):(zoa_cond_n167_0 == (zoa_cond_n167_0 = 0)))
				&& (rm.getDiscriminator() != null?(zoa_cond_n167_1 != (zoa_cond_n167_1 = 1)):(zoa_cond_n167_1 == (zoa_cond_n167_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 279 20 16 1 2 ","8135540",true,zoa_cond_n167_0,zoa_cond_n167_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 279 20 16 0 2 ","8135540",false,zoa_cond_n167_0,zoa_cond_n167_1) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 279 168 8135540"); {
			for (Map.Entry<String, String> entry : /* TRUE */rm
					.getDiscriminator()
					.getDiscriminatorMap()
					.entrySet()){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 279 169 8135540");ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 279 170 8135540"); {
				String discriminatedResultMapName = entry
						.getValue();
				if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 279 171 8135540")|| true) && (hasResultMap(discriminatedResultMapName)? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 279 21 17 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 279 21 17 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 279 172 8135540"); {
					ResultMap discriminatedResultMap = resultMaps
							.get(discriminatedResultMapName);
					if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 279 173 8135540")|| true) && (discriminatedResultMap
							.hasNestedResultMaps()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 279 22 18 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 279 22 18 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 279 174 8135540"); {
						rm.forceNestedResultMaps();
						 break;
					} }
				} }
			}}
		} }
	}

	protected static class StrictMap<V>
			extends HashMap<String, V> {

		private static final long serialVersionUID = -4950446264854982944L;
		private String name;

		public StrictMap(String name,
				int initialCapacity,
				float loadFactor) {
			super(initialCapacity,
					loadFactor);
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 279 179 8135540"); 
			this.name = name;
		}

		public StrictMap(String name,
				int initialCapacity) {
			super(initialCapacity);
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 279 180 8135540"); 
			this.name = name;
		}

		public StrictMap(String name) {
			super();
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 279 181 8135540"); 
			this.name = name;
		}

		public StrictMap(
				String name,
				Map<String, ? extends V> m) {
			super(m);
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 279 182 8135540"); 
			this.name = name;
		}

		@SuppressWarnings("unchecked")
		public V put(String key, V value) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 279 183 8135540"); 
			if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 279 184 8135540")|| true) && (containsKey(key)? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 279 23 19 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 279 23 19 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 279 185 8135540");
				throw new IllegalArgumentException(
						name
								+ " already contains value for "
								+ key); }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 279 186 8135540");
			if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 279 187 8135540")|| true) && (key.contains(".")? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 279 24 20 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 279 24 20 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 279 188 8135540"); {
				final String shortKey = getShortName(key);
				if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 279 189 8135540")|| true) && (super.get(shortKey) == null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 279 25 21 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 279 25 21 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 279 190 8135540"); {
					super.put(shortKey,
							value);
				} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 279 191 8135540");  {
					super.put(
							shortKey,
							(V) new Ambiguity(
									shortKey));
				} }
			} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 279 193 8135540");
			return super
					.put(key, value);
		}

		public V get(Object key) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 279 194 8135540"); 
			V value = super.get(key);
			if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 279 195 8135540")|| true) && (value == null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 279 26 22 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 279 26 22 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 279 196 8135540"); {
				throw new IllegalArgumentException(
						name
								+ " does not contain value for "
								+ key);
			} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 279 197 8135540");
			if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 279 198 8135540")|| true) && (value instanceof Ambiguity? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 279 27 23 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 279 27 23 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 279 199 8135540"); {
				throw new IllegalArgumentException(
						((Ambiguity) value)
								.getSubject()
								+ " is ambiguous in "
								+ name
								+ " (try using the full name including the namespace, or rename one of the entries)");
			} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 279 200 8135540");
			return value;
		}

		private String getShortName(
				String key) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 279 201 8135540"); 
			final String[] keyparts = key
					.split("\\.");
			final String shortKey = keyparts[keyparts.length - 1];
			return shortKey;
		}

		protected static class Ambiguity {
			private String subject;

			public Ambiguity(
					String subject) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 279 202 8135540"); 
				this.subject = subject;
			}

			public String getSubject() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 279 203 8135540"); 
				return subject;
			}
		}
	}

}

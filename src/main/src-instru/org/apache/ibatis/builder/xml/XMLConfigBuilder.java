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
package org.apache.ibatis.builder.xml;

import java.io.InputStream;
import java.io.Reader;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.builder.BaseBuilder;
import org.apache.ibatis.builder.BuilderException;
import org.apache.ibatis.datasource.DataSourceFactory;
import org.apache.ibatis.executor.ErrorContext;
import org.apache.ibatis.executor.loader.ProxyFactory;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.DatabaseIdProvider;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.parsing.XNode;
import org.apache.ibatis.parsing.XPathParser;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.reflection.MetaClass;
import org.apache.ibatis.reflection.factory.ObjectFactory;
import org.apache.ibatis.reflection.wrapper.ObjectWrapperFactory;
import org.apache.ibatis.session.AutoMappingBehavior;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.LocalCacheScope;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.type.JdbcType;

/**
 * @author Clinton Begin
 */
import com.process.ZoaExp;
import com.process.ZoaThreadLocal;
public class XMLConfigBuilder extends BaseBuilder {

  private boolean parsed;
  private XPathParser parser;
  private String environment;

  public XMLConfigBuilder(Reader reader) {
    this(reader, null, null);
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 182 0 8135540"); 
  }

  public XMLConfigBuilder(Reader reader, String environment) {
    this(reader, environment, null);
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 182 1 8135540"); 
  }

  public XMLConfigBuilder(Reader reader, String environment, Properties props) {
    this(new XPathParser(reader, true, props, new XMLMapperEntityResolver()), environment, props);
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 182 2 8135540"); 
  }

  public XMLConfigBuilder(InputStream inputStream) {
    this(inputStream, null, null);
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 182 3 8135540"); 
  }

  public XMLConfigBuilder(InputStream inputStream, String environment) {
    this(inputStream, environment, null);
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 182 4 8135540"); 
  }

  public XMLConfigBuilder(InputStream inputStream, String environment, Properties props) {
    this(new XPathParser(inputStream, true, props, new XMLMapperEntityResolver()), environment, props);
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 182 5 8135540"); 
  }

  private XMLConfigBuilder(XPathParser parser, String environment, Properties props) {
    super(new Configuration());
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 182 6 8135540"); 
    ErrorContext.instance().resource("SQL Mapper Configuration");
    this.configuration.setVariables(props);
    this.parsed = false;
    this.environment = environment;
    this.parser = parser;
  }

  public Configuration parse() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 182 7 8135540"); 
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 182 8 8135540")|| true) && (parsed? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 182 0 0 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 182 0 0 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 182 9 8135540"); {
      throw new BuilderException("Each XMLConfigBuilder can only be used once.");
    } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 182 10 8135540");
    parsed = true;
    parseConfiguration(parser.evalNode("/configuration"));
    return configuration;
  }

  private void parseConfiguration(XNode root) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 182 11 8135540"); 
    try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 182 12 8135540"); 
      propertiesElement(root.evalNode("properties")); //issue #117 read properties first
      typeAliasesElement(root.evalNode("typeAliases"));
      pluginElement(root.evalNode("plugins"));
      objectFactoryElement(root.evalNode("objectFactory"));
      objectWrapperFactoryElement(root.evalNode("objectWrapperFactory"));
      settingsElement(root.evalNode("settings"));
      environmentsElement(root.evalNode("environments")); // read it after objectFactory and objectWrapperFactory issue #631
      databaseIdProviderElement(root.evalNode("databaseIdProvider"));
      typeHandlerElement(root.evalNode("typeHandlers"));
      mapperElement(root.evalNode("mappers"));
    } catch (Exception e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 182 13 8135540"); 
      throw new BuilderException("Error parsing SQL Mapper Configuration. Cause: " + e, e);
    }
  }

  private void typeAliasesElement(XNode parent) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 182 15 8135540"); 
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 182 16 8135540")|| true) && (parent != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 182 1 1 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 182 1 1 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 182 17 8135540"); {
      for (XNode child : /* TRUE */parent.getChildren()){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 182 18 8135540");ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 182 19 8135540"); {
        if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 182 20 8135540")|| true) && ("package".equals(child.getName())? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 182 2 2 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 182 2 2 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 182 21 8135540"); {
          String typeAliasPackage = child.getStringAttribute("name");
          configuration.getTypeAliasRegistry().registerAliases(typeAliasPackage);
        } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 182 22 8135540");  {
          String alias = child.getStringAttribute("alias");
          String type = child.getStringAttribute("type");
          try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 182 23 8135540"); 
            Class<?> clazz = Resources.classForName(type);
            if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 182 24 8135540")|| true) && (alias == null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 182 3 3 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 182 3 3 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 182 25 8135540"); {
              typeAliasRegistry.registerAlias(clazz);
            } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 182 26 8135540");  {
              typeAliasRegistry.registerAlias(alias, clazz);
            } }
          } catch (ClassNotFoundException e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 182 28 8135540"); 
            throw new BuilderException("Error registering typeAlias for '" + alias + "'. Cause: " + e, e);
          }
        } }
      }}
    } }
  }

  private void pluginElement(XNode parent) throws Exception {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 182 33 8135540"); 
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 182 34 8135540")|| true) && (parent != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 182 4 4 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 182 4 4 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 182 35 8135540"); {
      for (XNode child : /* TRUE */parent.getChildren()){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 182 36 8135540");ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 182 37 8135540"); {
        String interceptor = child.getStringAttribute("interceptor");
        Properties properties = child.getChildrenAsProperties();
        Interceptor interceptorInstance = (Interceptor) resolveClass(interceptor).newInstance();
        interceptorInstance.setProperties(properties);
        configuration.addInterceptor(interceptorInstance);
      }}
    } }
  }

  private void objectFactoryElement(XNode context) throws Exception {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 182 40 8135540"); 
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 182 41 8135540")|| true) && (context != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 182 5 5 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 182 5 5 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 182 42 8135540"); {
      String type = context.getStringAttribute("type");
      Properties properties = context.getChildrenAsProperties();
      ObjectFactory factory = (ObjectFactory) resolveClass(type).newInstance();
      factory.setProperties(properties);
      configuration.setObjectFactory(factory);
    } }
  }

  private void objectWrapperFactoryElement(XNode context) throws Exception {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 182 44 8135540"); 
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 182 45 8135540")|| true) && (context != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 182 6 6 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 182 6 6 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 182 46 8135540"); {
      String type = context.getStringAttribute("type");
      ObjectWrapperFactory factory = (ObjectWrapperFactory) resolveClass(type).newInstance();
      configuration.setObjectWrapperFactory(factory);
    } }
  }

  private void propertiesElement(XNode context) throws Exception {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 182 48 8135540"); 
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 182 49 8135540")|| true) && (context != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 182 7 7 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 182 7 7 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 182 50 8135540"); {
      Properties defaults = context.getChildrenAsProperties();
      String resource = context.getStringAttribute("resource");
      String url = context.getStringAttribute("url");
      int zoa_cond_n51_0 = 2;
int zoa_cond_n51_1 = 2;
//zoa_cond_n51_0#resource != null$zoa_cond_n51_1#url != null
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 182 51 8135540")|| true) && ((resource != null?(zoa_cond_n51_0 != (zoa_cond_n51_0 = 1)):(zoa_cond_n51_0 == (zoa_cond_n51_0 = 0))) && (url != null?(zoa_cond_n51_1 != (zoa_cond_n51_1 = 1)):(zoa_cond_n51_1 == (zoa_cond_n51_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 182 10 8 1 2 ","8135540",true,zoa_cond_n51_0,zoa_cond_n51_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 182 10 8 0 2 ","8135540",false,zoa_cond_n51_0,zoa_cond_n51_1) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 182 52 8135540"); {
        throw new BuilderException("The properties element cannot specify both a URL and a resource based property file reference.  Please specify one or the other.");
      } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 182 53 8135540");
      if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 182 54 8135540")|| true) && (resource != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 182 11 9 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 182 11 9 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 182 55 8135540"); {
        defaults.putAll(Resources.getResourceAsProperties(resource));
      } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 182 56 8135540");  if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 182 57 8135540")|| true) && (url != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 182 12 10 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 182 12 10 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 182 58 8135540"); {
        defaults.putAll(Resources.getUrlAsProperties(url));
      } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 182 59 8135540"); }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 182 60 8135540");
      Properties vars = configuration.getVariables();
      if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 182 61 8135540")|| true) && (vars != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 182 13 11 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 182 13 11 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 182 62 8135540"); {
        defaults.putAll(vars);
      } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 182 63 8135540");
      parser.setVariables(defaults);
      configuration.setVariables(defaults);
    } }
  }

  private void settingsElement(XNode context) throws Exception {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 182 65 8135540"); 
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 182 66 8135540")|| true) && (context != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 182 14 12 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 182 14 12 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 182 67 8135540"); {
      Properties props = context.getChildrenAsProperties();
      // Check that all settings are known to the configuration class
      MetaClass metaConfig = MetaClass.forClass(Configuration.class);
      for (Object key : /* TRUE */props.keySet()){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 182 68 8135540");ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 182 69 8135540"); {
        if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 182 70 8135540")|| true) && (!metaConfig.hasSetter(String.valueOf(key))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 182 15 13 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 182 15 13 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 182 71 8135540"); {
          throw new BuilderException("The setting " + key + " is not known.  Make sure you spelled it correctly (case sensitive).");
        } }
      }}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 182 73 8135540");
      configuration.setAutoMappingBehavior(AutoMappingBehavior.valueOf(props.getProperty("autoMappingBehavior", "PARTIAL")));
      configuration.setCacheEnabled(booleanValueOf(props.getProperty("cacheEnabled"), true));
      configuration.setProxyFactory((ProxyFactory) createInstance(props.getProperty("proxyFactory")));
      configuration.setLazyLoadingEnabled(booleanValueOf(props.getProperty("lazyLoadingEnabled"), false));
      configuration.setAggressiveLazyLoading(booleanValueOf(props.getProperty("aggressiveLazyLoading"), true));
      configuration.setMultipleResultSetsEnabled(booleanValueOf(props.getProperty("multipleResultSetsEnabled"), true));
      configuration.setUseColumnLabel(booleanValueOf(props.getProperty("useColumnLabel"), true));
      configuration.setUseGeneratedKeys(booleanValueOf(props.getProperty("useGeneratedKeys"), false));
      configuration.setDefaultExecutorType(ExecutorType.valueOf(props.getProperty("defaultExecutorType", "SIMPLE")));
      configuration.setDefaultStatementTimeout(integerValueOf(props.getProperty("defaultStatementTimeout"), null));
      configuration.setMapUnderscoreToCamelCase(booleanValueOf(props.getProperty("mapUnderscoreToCamelCase"), false));
      configuration.setSafeRowBoundsEnabled(booleanValueOf(props.getProperty("safeRowBoundsEnabled"), false));
      configuration.setLocalCacheScope(LocalCacheScope.valueOf(props.getProperty("localCacheScope", "SESSION")));
      configuration.setJdbcTypeForNull(JdbcType.valueOf(props.getProperty("jdbcTypeForNull", "OTHER")));
      configuration.setLazyLoadTriggerMethods(stringSetValueOf(props.getProperty("lazyLoadTriggerMethods"), "equals,clone,hashCode,toString"));
      configuration.setSafeResultHandlerEnabled(booleanValueOf(props.getProperty("safeResultHandlerEnabled"), true));
      configuration.setDefaultScriptingLanguage(resolveClass(props.getProperty("defaultScriptingLanguage")));
      configuration.setCallSettersOnNulls(booleanValueOf(props.getProperty("callSettersOnNulls"), false));
      configuration.setLogPrefix(props.getProperty("logPrefix"));
      configuration.setLogImpl(resolveClass(props.getProperty("logImpl")));
      configuration.setConfigurationFactory(resolveClass(props.getProperty("configurationFactory")));
    } }
  }

  private void environmentsElement(XNode context) throws Exception {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 182 75 8135540"); 
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 182 76 8135540")|| true) && (context != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 182 16 14 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 182 16 14 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 182 77 8135540"); {
      if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 182 78 8135540")|| true) && (environment == null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 182 17 15 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 182 17 15 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 182 79 8135540"); {
        environment = context.getStringAttribute("default");
      } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 182 80 8135540");
      for (XNode child : /* TRUE */context.getChildren()){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 182 81 8135540");ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 182 82 8135540"); {
        String id = child.getStringAttribute("id");
        if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 182 83 8135540")|| true) && (isSpecifiedEnvironment(id)? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 182 18 16 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 182 18 16 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 182 84 8135540"); {
          TransactionFactory txFactory = transactionManagerElement(child.evalNode("transactionManager"));
          DataSourceFactory dsFactory = dataSourceElement(child.evalNode("dataSource"));
          DataSource dataSource = dsFactory.getDataSource();
          Environment.Builder environmentBuilder = new Environment.Builder(id)
              .transactionFactory(txFactory)
              .dataSource(dataSource);
          configuration.setEnvironment(environmentBuilder.build());
        } }
      }}
    } }
  }

  private void databaseIdProviderElement(XNode context) throws Exception {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 182 88 8135540"); 
    DatabaseIdProvider databaseIdProvider = null;
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 182 89 8135540")|| true) && (context != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 182 19 17 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 182 19 17 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 182 90 8135540"); {
      String type = context.getStringAttribute("type");
      if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 182 91 8135540")|| true) && ("VENDOR".equals(type)? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 182 20 18 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 182 20 18 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 182 92 8135540"); type = "DB_VENDOR"; }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 182 93 8135540"); // awful patch to keep backward compatibility
      Properties properties = context.getChildrenAsProperties();
      databaseIdProvider = (DatabaseIdProvider) resolveClass(type).newInstance();
      databaseIdProvider.setProperties(properties);
    } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 182 94 8135540");
    Environment environment = configuration.getEnvironment();
    int zoa_cond_n95_0 = 2;
int zoa_cond_n95_1 = 2;
//zoa_cond_n95_0#environment != null$zoa_cond_n95_1#databaseIdProvider != null
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 182 95 8135540")|| true) && ((environment != null?(zoa_cond_n95_0 != (zoa_cond_n95_0 = 1)):(zoa_cond_n95_0 == (zoa_cond_n95_0 = 0))) && (databaseIdProvider != null?(zoa_cond_n95_1 != (zoa_cond_n95_1 = 1)):(zoa_cond_n95_1 == (zoa_cond_n95_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 182 23 19 1 2 ","8135540",true,zoa_cond_n95_0,zoa_cond_n95_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 182 23 19 0 2 ","8135540",false,zoa_cond_n95_0,zoa_cond_n95_1) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 182 96 8135540"); {
      String databaseId = databaseIdProvider.getDatabaseId(environment.getDataSource());
      configuration.setDatabaseId(databaseId);
    } }
  }

  private TransactionFactory transactionManagerElement(XNode context) throws Exception {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 182 98 8135540"); 
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 182 99 8135540")|| true) && (context != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 182 24 20 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 182 24 20 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 182 100 8135540"); {
      String type = context.getStringAttribute("type");
      Properties props = context.getChildrenAsProperties();
      TransactionFactory factory = (TransactionFactory) resolveClass(type).newInstance();
      factory.setProperties(props);
      return factory;
    } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 182 101 8135540");
    throw new BuilderException("Environment declaration requires a TransactionFactory.");
  }

  private DataSourceFactory dataSourceElement(XNode context) throws Exception {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 182 102 8135540"); 
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 182 103 8135540")|| true) && (context != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 182 25 21 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 182 25 21 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 182 104 8135540"); {
      String type = context.getStringAttribute("type");
      Properties props = context.getChildrenAsProperties();
      DataSourceFactory factory = (DataSourceFactory) resolveClass(type).newInstance();
      factory.setProperties(props);
      return factory;
    } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 182 105 8135540");
    throw new BuilderException("Environment declaration requires a DataSourceFactory.");
  }

  private void typeHandlerElement(XNode parent) throws Exception {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 182 106 8135540"); 
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 182 107 8135540")|| true) && (parent != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 182 26 22 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 182 26 22 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 182 108 8135540"); {
      for (XNode child : /* TRUE */parent.getChildren()){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 182 109 8135540");ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 182 110 8135540"); {
        if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 182 111 8135540")|| true) && ("package".equals(child.getName())? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 182 27 23 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 182 27 23 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 182 112 8135540"); {
          String typeHandlerPackage = child.getStringAttribute("name");
          typeHandlerRegistry.register(typeHandlerPackage);
        } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 182 113 8135540");  {
          String javaTypeName = child.getStringAttribute("javaType");
          String jdbcTypeName = child.getStringAttribute("jdbcType");
          String handlerTypeName = child.getStringAttribute("handler");
          Class<?> javaTypeClass = resolveClass(javaTypeName);
          JdbcType jdbcType = resolveJdbcType(jdbcTypeName);
          Class<?> typeHandlerClass = resolveClass(handlerTypeName);
          if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 182 114 8135540")|| true) && (javaTypeClass != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 182 28 24 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 182 28 24 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 182 115 8135540"); {
            if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 182 116 8135540")|| true) && (jdbcType == null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 182 29 25 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 182 29 25 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 182 117 8135540"); {
              typeHandlerRegistry.register(javaTypeClass, typeHandlerClass);
            } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 182 118 8135540");  {
              typeHandlerRegistry.register(javaTypeClass, jdbcType, typeHandlerClass);
            } }
          } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 182 120 8135540");  {
            typeHandlerRegistry.register(typeHandlerClass);
          } }
        } }
      }}
    } }
  }

  private void mapperElement(XNode parent) throws Exception {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 182 125 8135540"); 
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 182 126 8135540")|| true) && (parent != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 182 30 26 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 182 30 26 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 182 127 8135540"); {
      for (XNode child : /* TRUE */parent.getChildren()){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 182 128 8135540");ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 182 129 8135540"); {
        if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 182 130 8135540")|| true) && ("package".equals(child.getName())? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 182 31 27 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 182 31 27 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 182 131 8135540"); {
          String mapperPackage = child.getStringAttribute("name");
          configuration.addMappers(mapperPackage);
        } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 182 132 8135540");  {
          String resource = child.getStringAttribute("resource");
          String url = child.getStringAttribute("url");
          String mapperClass = child.getStringAttribute("class");
          int zoa_cond_n133_0 = 2;
int zoa_cond_n133_1 = 2;
int zoa_cond_n133_2 = 2;
//zoa_cond_n133_0#resource != null$zoa_cond_n133_1#url == null$zoa_cond_n133_2#mapperClass == null
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 182 133 8135540")|| true) && ((resource != null?(zoa_cond_n133_0 != (zoa_cond_n133_0 = 1)):(zoa_cond_n133_0 == (zoa_cond_n133_0 = 0))) && (url == null?(zoa_cond_n133_1 != (zoa_cond_n133_1 = 1)):(zoa_cond_n133_1 == (zoa_cond_n133_1 = 0))) && (mapperClass == null?(zoa_cond_n133_2 != (zoa_cond_n133_2 = 1)):(zoa_cond_n133_2 == (zoa_cond_n133_2 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 182 35 28 1 3 ","8135540",true,zoa_cond_n133_0,zoa_cond_n133_1,zoa_cond_n133_2) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 182 35 28 0 3 ","8135540",false,zoa_cond_n133_0,zoa_cond_n133_1,zoa_cond_n133_2) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 182 134 8135540"); {
            ErrorContext.instance().resource(resource);
            InputStream inputStream = Resources.getResourceAsStream(resource);
            XMLMapperBuilder mapperParser = new XMLMapperBuilder(inputStream, configuration, resource, configuration.getSqlFragments());
            mapperParser.parse();
          } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 182 135 8135540");  int zoa_cond_n136_0 = 2;
int zoa_cond_n136_1 = 2;
int zoa_cond_n136_2 = 2;
//zoa_cond_n136_0#resource == null$zoa_cond_n136_1#url != null$zoa_cond_n136_2#mapperClass == null
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 182 136 8135540")|| true) && ((resource == null?(zoa_cond_n136_0 != (zoa_cond_n136_0 = 1)):(zoa_cond_n136_0 == (zoa_cond_n136_0 = 0))) && (url != null?(zoa_cond_n136_1 != (zoa_cond_n136_1 = 1)):(zoa_cond_n136_1 == (zoa_cond_n136_1 = 0))) && (mapperClass == null?(zoa_cond_n136_2 != (zoa_cond_n136_2 = 1)):(zoa_cond_n136_2 == (zoa_cond_n136_2 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 182 39 29 1 3 ","8135540",true,zoa_cond_n136_0,zoa_cond_n136_1,zoa_cond_n136_2) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 182 39 29 0 3 ","8135540",false,zoa_cond_n136_0,zoa_cond_n136_1,zoa_cond_n136_2) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 182 137 8135540"); {
            ErrorContext.instance().resource(url);
            InputStream inputStream = Resources.getUrlAsStream(url);
            XMLMapperBuilder mapperParser = new XMLMapperBuilder(inputStream, configuration, url, configuration.getSqlFragments());
            mapperParser.parse();
          } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 182 138 8135540");  int zoa_cond_n139_0 = 2;
int zoa_cond_n139_1 = 2;
int zoa_cond_n139_2 = 2;
//zoa_cond_n139_0#resource == null$zoa_cond_n139_1#url == null$zoa_cond_n139_2#mapperClass != null
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 182 139 8135540")|| true) && ((resource == null?(zoa_cond_n139_0 != (zoa_cond_n139_0 = 1)):(zoa_cond_n139_0 == (zoa_cond_n139_0 = 0))) && (url == null?(zoa_cond_n139_1 != (zoa_cond_n139_1 = 1)):(zoa_cond_n139_1 == (zoa_cond_n139_1 = 0))) && (mapperClass != null?(zoa_cond_n139_2 != (zoa_cond_n139_2 = 1)):(zoa_cond_n139_2 == (zoa_cond_n139_2 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 182 43 30 1 3 ","8135540",true,zoa_cond_n139_0,zoa_cond_n139_1,zoa_cond_n139_2) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 182 43 30 0 3 ","8135540",false,zoa_cond_n139_0,zoa_cond_n139_1,zoa_cond_n139_2) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 182 140 8135540"); {
            Class<?> mapperInterface = Resources.classForName(mapperClass);
            configuration.addMapper(mapperInterface);
          } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 182 141 8135540");  {
            throw new BuilderException("A mapper element may only specify a url, resource or class, but not more than one.");
          } } } }
        } }
      }}
    } }
  }

  private boolean isSpecifiedEnvironment(String id) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 182 148 8135540"); 
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 182 149 8135540")|| true) && (environment == null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 182 44 31 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 182 44 31 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 182 150 8135540"); {
      throw new BuilderException("No environment specified.");
    } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 182 151 8135540");  if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 182 152 8135540")|| true) && (id == null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 182 45 32 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 182 45 32 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 182 153 8135540"); {
      throw new BuilderException("Environment requires an id attribute.");
    } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 182 154 8135540");  if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 182 155 8135540")|| true) && (environment.equals(id)? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 182 46 33 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 182 46 33 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 182 156 8135540"); {
      return true;
    } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 182 157 8135540"); }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 182 158 8135540"); }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 182 159 8135540");
    return false;
  }

}

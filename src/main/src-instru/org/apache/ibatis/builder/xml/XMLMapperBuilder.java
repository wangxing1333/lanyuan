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
package org.apache.ibatis.builder.xml;

import java.io.InputStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.ibatis.builder.BaseBuilder;
import org.apache.ibatis.builder.BuilderException;
import org.apache.ibatis.builder.CacheRefResolver;
import org.apache.ibatis.builder.IncompleteElementException;
import org.apache.ibatis.builder.MapperBuilderAssistant;
import org.apache.ibatis.builder.ResultMapResolver;
import org.apache.ibatis.cache.Cache;
import org.apache.ibatis.executor.ErrorContext;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.Discriminator;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.mapping.ParameterMode;
import org.apache.ibatis.mapping.ResultFlag;
import org.apache.ibatis.mapping.ResultMap;
import org.apache.ibatis.mapping.ResultMapping;
import org.apache.ibatis.parsing.XNode;
import org.apache.ibatis.parsing.XPathParser;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

/**
 * @author Clinton Begin
 */
import com.process.ZoaExp;
import com.process.ZoaThreadLocal;
public class XMLMapperBuilder extends BaseBuilder {

  private XPathParser parser;
  private MapperBuilderAssistant builderAssistant;
  private Map<String, XNode> sqlFragments;
  private String resource;

  @Deprecated
  public XMLMapperBuilder(Reader reader, Configuration configuration, String resource, Map<String, XNode> sqlFragments, String namespace) {
    this(reader, configuration, resource, sqlFragments);
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 209 0 8135540"); 
    this.builderAssistant.setCurrentNamespace(namespace);
  }

  @Deprecated
  public XMLMapperBuilder(Reader reader, Configuration configuration, String resource, Map<String, XNode> sqlFragments) {
    this(new XPathParser(reader, true, configuration.getVariables(), new XMLMapperEntityResolver()),
        configuration, resource, sqlFragments);
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 209 1 8135540"); 
  }

  public XMLMapperBuilder(InputStream inputStream, Configuration configuration, String resource, Map<String, XNode> sqlFragments, String namespace) {
    this(inputStream, configuration, resource, sqlFragments);
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 209 2 8135540"); 
    this.builderAssistant.setCurrentNamespace(namespace);
  }

  public XMLMapperBuilder(InputStream inputStream, Configuration configuration, String resource, Map<String, XNode> sqlFragments) {
    this(new XPathParser(inputStream, true, configuration.getVariables(), new XMLMapperEntityResolver()),
        configuration, resource, sqlFragments);
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 209 3 8135540"); 
  }

  private XMLMapperBuilder(XPathParser parser, Configuration configuration, String resource, Map<String, XNode> sqlFragments) {
    super(configuration);
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 209 4 8135540"); 
    this.builderAssistant = new MapperBuilderAssistant(configuration, resource);
    this.parser = parser;
    this.sqlFragments = sqlFragments;
    this.resource = resource;
  }

  public void parse() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 209 5 8135540"); 
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 209 6 8135540")|| true) && (!configuration.isResourceLoaded(resource)? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 209 0 0 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 209 0 0 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 209 7 8135540"); {
      configurationElement(parser.evalNode("/mapper"));
      configuration.addLoadedResource(resource);
      bindMapperForNamespace();
    } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 209 8 8135540");

    parsePendingResultMaps();
    parsePendingChacheRefs();
    parsePendingStatements();
  }

  public XNode getSqlFragment(String refid) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 209 9 8135540"); 
    return sqlFragments.get(refid);
  }

  private void configurationElement(XNode context) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 209 10 8135540"); 
    try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 209 11 8135540"); 
      String namespace = context.getStringAttribute("namespace");
      if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 209 12 8135540")|| true) && (namespace.equals("")? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 209 1 1 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 209 1 1 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 209 13 8135540"); {
    	  throw new BuilderException("Mapper's namespace cannot be empty");
      } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 209 14 8135540");
      builderAssistant.setCurrentNamespace(namespace);
      cacheRefElement(context.evalNode("cache-ref"));
      cacheElement(context.evalNode("cache"));
      parameterMapElement(context.evalNodes("/mapper/parameterMap"));
      resultMapElements(context.evalNodes("/mapper/resultMap"));
      sqlElement(context.evalNodes("/mapper/sql"));
      buildStatementFromContext(context.evalNodes("select|insert|update|delete"));
    } catch (Exception e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 209 15 8135540"); 
      throw new BuilderException("Error parsing Mapper XML. Cause: " + e, e);
    }
  }

  private void buildStatementFromContext(List<XNode> list) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 209 17 8135540"); 
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 209 18 8135540")|| true) && (configuration.getDatabaseId() != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 209 2 2 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 209 2 2 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 209 19 8135540"); {
      buildStatementFromContext(list, configuration.getDatabaseId());
    } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 209 20 8135540");
    buildStatementFromContext(list, null);
  }

  private void buildStatementFromContext(List<XNode> list, String requiredDatabaseId) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 209 21 8135540"); 
    for (XNode context : /* TRUE */list){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 209 22 8135540");ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 209 23 8135540"); {
      final XMLStatementBuilder statementParser = new XMLStatementBuilder(configuration, builderAssistant, context, requiredDatabaseId);
      try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 209 24 8135540"); 
        statementParser.parseStatementNode();
      } catch (IncompleteElementException e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 209 25 8135540"); 
        configuration.addIncompleteStatement(statementParser);
      }
    }}
  }

  private void parsePendingResultMaps() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 209 28 8135540"); 
    Collection<ResultMapResolver> incompleteResultMaps = configuration.getIncompleteResultMaps();
    synchronized (incompleteResultMaps) {
      Iterator<ResultMapResolver> iter = incompleteResultMaps.iterator();
      while ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 209 29 8135540")|| true) && (iter.hasNext()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 209 3 3 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 209 3 3 0 0 ","8135540",false,0) && false))){ ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 209 30 8135540");  {
        try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 209 31 8135540"); 
          iter.next().resolve();
          iter.remove();
        } catch (IncompleteElementException e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 209 32 8135540"); 
          // ResultMap is still missing a resource...
        }
      }}
    }
  }

  private void parsePendingChacheRefs() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 209 35 8135540"); 
	  Collection<CacheRefResolver> incompleteCacheRefs = configuration.getIncompleteCacheRefs();
	  synchronized (incompleteCacheRefs) {
		  Iterator<CacheRefResolver> iter = incompleteCacheRefs.iterator();
		  while ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 209 36 8135540")|| true) && (iter.hasNext()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 209 4 4 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 209 4 4 0 0 ","8135540",false,0) && false))){ ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 209 37 8135540");  {
			  try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 209 38 8135540"); 
				  iter.next().resolveCacheRef();
				  iter.remove();
			  } catch (IncompleteElementException e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 209 39 8135540"); 
				  // Cache ref is still missing a resource...
			  }
		  }}
	  }
  }

  private void parsePendingStatements() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 209 42 8135540"); 
	  Collection<XMLStatementBuilder> incompleteStatements = configuration.getIncompleteStatements();
	  synchronized (incompleteStatements) {
		  Iterator<XMLStatementBuilder> iter = incompleteStatements.iterator();
		  while ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 209 43 8135540")|| true) && (iter.hasNext()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 209 5 5 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 209 5 5 0 0 ","8135540",false,0) && false))){ ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 209 44 8135540");  {
			  try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 209 45 8135540"); 
				  iter.next().parseStatementNode();
				  iter.remove();
			  } catch (IncompleteElementException e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 209 46 8135540"); 
				  // Statement is still missing a resource...
			  }
		  }}
	  }
  }

  private void cacheRefElement(XNode context) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 209 49 8135540"); 
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 209 50 8135540")|| true) && (context != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 209 6 6 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 209 6 6 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 209 51 8135540"); {
      configuration.addCacheRef(builderAssistant.getCurrentNamespace(), context.getStringAttribute("namespace"));
      CacheRefResolver cacheRefResolver = new CacheRefResolver(builderAssistant, context.getStringAttribute("namespace"));
      try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 209 52 8135540"); 
    	  cacheRefResolver.resolveCacheRef();
      } catch (IncompleteElementException e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 209 53 8135540"); 
    	  configuration.addIncompleteCacheRef(cacheRefResolver);
      }
    } }
  }

  private void cacheElement(XNode context) throws Exception {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 209 56 8135540"); 
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 209 57 8135540")|| true) && (context != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 209 7 7 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 209 7 7 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 209 58 8135540"); {
      String type = context.getStringAttribute("type", "PERPETUAL");
      Class<? extends Cache> typeClass = typeAliasRegistry.resolveAlias(type);
      String eviction = context.getStringAttribute("eviction", "LRU");
      Class<? extends Cache> evictionClass = typeAliasRegistry.resolveAlias(eviction);
      Long flushInterval = context.getLongAttribute("flushInterval");
      Integer size = context.getIntAttribute("size");
      boolean readWrite = !context.getBooleanAttribute("readOnly", false);
      Properties props = context.getChildrenAsProperties();
      builderAssistant.useNewCache(typeClass, evictionClass, flushInterval, size, readWrite, props);
    } }
  }

  private void parameterMapElement(List<XNode> list) throws Exception {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 209 60 8135540"); 
    for (XNode parameterMapNode : /* TRUE */list){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 209 61 8135540");ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 209 62 8135540"); {
      String id = parameterMapNode.getStringAttribute("id");
      String type = parameterMapNode.getStringAttribute("type");
      Class<?> parameterClass = resolveClass(type);
      List<XNode> parameterNodes = parameterMapNode.evalNodes("parameter");
      List<ParameterMapping> parameterMappings = new ArrayList<ParameterMapping>();
      for (XNode parameterNode : /* TRUE */parameterNodes){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 209 63 8135540");ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 209 64 8135540"); {
        String property = parameterNode.getStringAttribute("property");
        String javaType = parameterNode.getStringAttribute("javaType");
        String jdbcType = parameterNode.getStringAttribute("jdbcType");
        String resultMap = parameterNode.getStringAttribute("resultMap");
        String mode = parameterNode.getStringAttribute("mode");
        String typeHandler = parameterNode.getStringAttribute("typeHandler");
        Integer numericScale = parameterNode.getIntAttribute("numericScale");
        ParameterMode modeEnum = resolveParameterMode(mode);
        Class<?> javaTypeClass = resolveClass(javaType);
        JdbcType jdbcTypeEnum = resolveJdbcType(jdbcType);
        @SuppressWarnings("unchecked")
        Class<? extends TypeHandler<?>> typeHandlerClass = (Class<? extends TypeHandler<?>>) resolveClass(typeHandler);
        ParameterMapping parameterMapping = builderAssistant.buildParameterMapping(parameterClass, property, javaTypeClass, jdbcTypeEnum, resultMap, modeEnum, typeHandlerClass, numericScale);
        parameterMappings.add(parameterMapping);
      }}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 209 65 8135540");
      builderAssistant.addParameterMap(id, parameterClass, parameterMappings);
    }}
  }

  private void resultMapElements(List<XNode> list) throws Exception {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 209 67 8135540"); 
    for (XNode resultMapNode : /* TRUE */list){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 209 68 8135540");ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 209 69 8135540"); {
      try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 209 70 8135540"); 
        resultMapElement(resultMapNode);
      } catch (IncompleteElementException e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 209 71 8135540"); 
        // ignore, it will be retried
      }
    }}
  }

  private ResultMap resultMapElement(XNode resultMapNode) throws Exception {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 209 74 8135540"); 
    return resultMapElement(resultMapNode, Collections.<ResultMapping> emptyList());
  }

  private ResultMap resultMapElement(XNode resultMapNode, List<ResultMapping> additionalResultMappings) throws Exception {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 209 75 8135540"); 
    ErrorContext.instance().activity("processing " + resultMapNode.getValueBasedIdentifier());
    String id = resultMapNode.getStringAttribute("id",
        resultMapNode.getValueBasedIdentifier());
    String type = resultMapNode.getStringAttribute("type",
        resultMapNode.getStringAttribute("ofType",
            resultMapNode.getStringAttribute("resultType",
                resultMapNode.getStringAttribute("javaType"))));
    String extend = resultMapNode.getStringAttribute("extends");
    Boolean autoMapping = resultMapNode.getBooleanAttribute("autoMapping");
    Class<?> typeClass = resolveClass(type);
    Discriminator discriminator = null;
    List<ResultMapping> resultMappings = new ArrayList<ResultMapping>();
    resultMappings.addAll(additionalResultMappings);
    List<XNode> resultChildren = resultMapNode.getChildren();
    for (XNode resultChild : /* TRUE */resultChildren){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 209 76 8135540");ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 209 77 8135540"); {
      if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 209 78 8135540")|| true) && ("constructor".equals(resultChild.getName())? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 209 8 8 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 209 8 8 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 209 79 8135540"); {
        processConstructorElement(resultChild, typeClass, resultMappings);
      } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 209 80 8135540");  if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 209 81 8135540")|| true) && ("discriminator".equals(resultChild.getName())? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 209 9 9 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 209 9 9 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 209 82 8135540"); {
        discriminator = processDiscriminatorElement(resultChild, typeClass, resultMappings);
      } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 209 83 8135540");  {
        ArrayList<ResultFlag> flags = new ArrayList<ResultFlag>();
        if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 209 84 8135540")|| true) && ("id".equals(resultChild.getName())? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 209 10 10 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 209 10 10 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 209 85 8135540"); {
          flags.add(ResultFlag.ID);
        } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 209 86 8135540");
        resultMappings.add(buildResultMappingFromContext(resultChild, typeClass, flags));
      } } }
    }}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 209 89 8135540");
    ResultMapResolver resultMapResolver = new ResultMapResolver(builderAssistant, id, typeClass, extend, discriminator, resultMappings, autoMapping);
    try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 209 90 8135540"); 
      return resultMapResolver.resolve();
    } catch (IncompleteElementException  e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 209 91 8135540"); 
      configuration.addIncompleteResultMap(resultMapResolver);
      throw e;
    }
  }

  private void processConstructorElement(XNode resultChild, Class<?> resultType, List<ResultMapping> resultMappings) throws Exception {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 209 93 8135540"); 
    List<XNode> argChildren = resultChild.getChildren();
    for (XNode argChild : /* TRUE */argChildren){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 209 94 8135540");ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 209 95 8135540"); {
      ArrayList<ResultFlag> flags = new ArrayList<ResultFlag>();
      flags.add(ResultFlag.CONSTRUCTOR);
      if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 209 96 8135540")|| true) && ("idArg".equals(argChild.getName())? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 209 11 11 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 209 11 11 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 209 97 8135540"); {
        flags.add(ResultFlag.ID);
      } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 209 98 8135540");
      resultMappings.add(buildResultMappingFromContext(argChild, resultType, flags));
    }}
  }

  private Discriminator processDiscriminatorElement(XNode context, Class<?> resultType, List<ResultMapping> resultMappings) throws Exception {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 209 100 8135540"); 
    String column = context.getStringAttribute("column");
    String javaType = context.getStringAttribute("javaType");
    String jdbcType = context.getStringAttribute("jdbcType");
    String typeHandler = context.getStringAttribute("typeHandler");
    Class<?> javaTypeClass = resolveClass(javaType);
    @SuppressWarnings("unchecked")
    Class<? extends TypeHandler<?>> typeHandlerClass = (Class<? extends TypeHandler<?>>) resolveClass(typeHandler);
    JdbcType jdbcTypeEnum = resolveJdbcType(jdbcType);
    Map<String, String> discriminatorMap = new HashMap<String, String>();
    for (XNode caseChild : /* TRUE */context.getChildren()){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 209 101 8135540");ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 209 102 8135540"); {
      String value = caseChild.getStringAttribute("value");
      String resultMap = caseChild.getStringAttribute("resultMap", processNestedResultMappings(caseChild, resultMappings));
      discriminatorMap.put(value, resultMap);
    }}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 209 103 8135540");
    return builderAssistant.buildDiscriminator(resultType, column, javaTypeClass, jdbcTypeEnum, typeHandlerClass, discriminatorMap);
  }

  private void sqlElement(List<XNode> list) throws Exception {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 209 104 8135540"); 
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 209 105 8135540")|| true) && (configuration.getDatabaseId() != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 209 12 12 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 209 12 12 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 209 106 8135540"); {
      sqlElement(list, configuration.getDatabaseId());
    } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 209 107 8135540");
    sqlElement(list, null);
  }

  private void sqlElement(List<XNode> list, String requiredDatabaseId) throws Exception {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 209 108 8135540"); 
    for (XNode context : /* TRUE */list){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 209 109 8135540");ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 209 110 8135540"); {
      String databaseId = context.getStringAttribute("databaseId");
      String id = context.getStringAttribute("id");
      id = builderAssistant.applyCurrentNamespace(id, false);
      if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 209 111 8135540")|| true) && (databaseIdMatchesCurrent(id, databaseId, requiredDatabaseId)? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 209 13 13 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 209 13 13 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 209 112 8135540"); sqlFragments.put(id, context); }
    }}
  }
  
  private boolean databaseIdMatchesCurrent(String id, String databaseId, String requiredDatabaseId) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 209 115 8135540"); 
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 209 116 8135540")|| true) && (requiredDatabaseId != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 209 14 14 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 209 14 14 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 209 117 8135540"); {
      if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 209 118 8135540")|| true) && (!requiredDatabaseId.equals(databaseId)? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 209 15 15 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 209 15 15 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 209 119 8135540"); {
        return false;
      } }
    } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 209 121 8135540");  {
      if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 209 122 8135540")|| true) && (databaseId != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 209 16 16 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 209 16 16 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 209 123 8135540"); {
        return false;
      } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 209 124 8135540");
      // skip this fragment if there is a previous one with a not null databaseId
      if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 209 125 8135540")|| true) && (this.sqlFragments.containsKey(id)? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 209 17 17 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 209 17 17 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 209 126 8135540"); {
        XNode context = this.sqlFragments.get(id);
        if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 209 127 8135540")|| true) && (context.getStringAttribute("databaseId") != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 209 18 18 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 209 18 18 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 209 128 8135540"); {
          return false;
        } }
      } }
    } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 209 131 8135540");
    return true;
  }

  private ResultMapping buildResultMappingFromContext(XNode context, Class<?> resultType, ArrayList<ResultFlag> flags) throws Exception {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 209 132 8135540"); 
    String property = context.getStringAttribute("property");
    String column = context.getStringAttribute("column");
    String javaType = context.getStringAttribute("javaType");
    String jdbcType = context.getStringAttribute("jdbcType");
    String nestedSelect = context.getStringAttribute("select");
    String nestedResultMap = context.getStringAttribute("resultMap",
        processNestedResultMappings(context, Collections.<ResultMapping> emptyList()));
    String notNullColumn = context.getStringAttribute("notNullColumn");
    String columnPrefix = context.getStringAttribute("columnPrefix");
    String typeHandler = context.getStringAttribute("typeHandler");
    String resulSet = context.getStringAttribute("resultSet");
    String foreignColumn = context.getStringAttribute("foreignColumn");
    boolean lazy = "lazy".equals(context.getStringAttribute("fetchType", configuration.isLazyLoadingEnabled() ? "lazy" : "eager"));
    Class<?> javaTypeClass = resolveClass(javaType);
    @SuppressWarnings("unchecked")
    Class<? extends TypeHandler<?>> typeHandlerClass = (Class<? extends TypeHandler<?>>) resolveClass(typeHandler);
    JdbcType jdbcTypeEnum = resolveJdbcType(jdbcType);
    return builderAssistant.buildResultMapping(resultType, property, column, javaTypeClass, jdbcTypeEnum, nestedSelect, nestedResultMap, notNullColumn, columnPrefix, typeHandlerClass, flags, resulSet, foreignColumn, lazy);
  }
  
  private String processNestedResultMappings(XNode context, List<ResultMapping> resultMappings) throws Exception {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 209 133 8135540"); 
    int zoa_cond_n134_0 = 2;
int zoa_cond_n134_1 = 2;
int zoa_cond_n134_2 = 2;
//zoa_cond_n134_0#"association".equals(context.getName())$zoa_cond_n134_1#"collection".equals(context.getName())$zoa_cond_n134_2#"case".equals(context.getName())
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 209 134 8135540")|| true) && (("association".equals(context.getName())?(zoa_cond_n134_0 != (zoa_cond_n134_0 = 1)):(zoa_cond_n134_0 == (zoa_cond_n134_0 = 0)))
        || ("collection".equals(context.getName())?(zoa_cond_n134_1 != (zoa_cond_n134_1 = 1)):(zoa_cond_n134_1 == (zoa_cond_n134_1 = 0)))
        || ("case".equals(context.getName())?(zoa_cond_n134_2 != (zoa_cond_n134_2 = 1)):(zoa_cond_n134_2 == (zoa_cond_n134_2 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 209 22 19 1 3 ","8135540",true,zoa_cond_n134_0,zoa_cond_n134_1,zoa_cond_n134_2) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 209 22 19 0 3 ","8135540",false,zoa_cond_n134_0,zoa_cond_n134_1,zoa_cond_n134_2) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 209 135 8135540"); {
      if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 209 136 8135540")|| true) && (context.getStringAttribute("select") == null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 209 23 20 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 209 23 20 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 209 137 8135540"); {
        ResultMap resultMap = resultMapElement(context, resultMappings);
        return resultMap.getId();
      } }
    } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 209 139 8135540");
    return null;
  }

  private void bindMapperForNamespace() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 209 140 8135540"); 
    String namespace = builderAssistant.getCurrentNamespace();
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 209 141 8135540")|| true) && (namespace != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 209 24 21 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 209 24 21 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 209 142 8135540"); {
      Class<?> boundType = null;
      try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 209 143 8135540"); 
        boundType = Resources.classForName(namespace);
      } catch (ClassNotFoundException e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 209 144 8135540"); 
        //ignore, bound type is not required
      }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 209 145 8135540");
      if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 209 146 8135540")|| true) && (boundType != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 209 25 22 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 209 25 22 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 209 147 8135540"); {
        if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 209 148 8135540")|| true) && (!configuration.hasMapper(boundType)? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 209 26 23 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 209 26 23 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 209 149 8135540"); {
          // Spring may not know the real resource name so we set a flag
          // to prevent loading again this resource from the mapper interface
          // look at MapperAnnotationBuilder#loadXmlResource
          configuration.addLoadedResource("namespace:" + namespace);
          configuration.addMapper(boundType);
        } }
      } }
    } }
  }

}

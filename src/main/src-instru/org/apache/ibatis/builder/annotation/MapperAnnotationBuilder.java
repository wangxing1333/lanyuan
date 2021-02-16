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
package org.apache.ibatis.builder.annotation;

import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.annotations.Arg;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.CacheNamespaceRef;
import org.apache.ibatis.annotations.Case;
import org.apache.ibatis.annotations.ConstructorArgs;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Lang;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.TypeDiscriminator;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.binding.BindingException;
import org.apache.ibatis.binding.MapperMethod.ParamMap;
import org.apache.ibatis.builder.BuilderException;
import org.apache.ibatis.builder.IncompleteElementException;
import org.apache.ibatis.builder.MapperBuilderAssistant;
import org.apache.ibatis.builder.xml.XMLMapperBuilder;
import org.apache.ibatis.executor.keygen.Jdbc3KeyGenerator;
import org.apache.ibatis.executor.keygen.KeyGenerator;
import org.apache.ibatis.executor.keygen.NoKeyGenerator;
import org.apache.ibatis.executor.keygen.SelectKeyGenerator;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.Discriminator;
import org.apache.ibatis.mapping.FetchType;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ResultFlag;
import org.apache.ibatis.mapping.ResultMapping;
import org.apache.ibatis.mapping.ResultSetType;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.mapping.StatementType;
import org.apache.ibatis.scripting.LanguageDriver;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;
import org.apache.ibatis.type.UnknownTypeHandler;

/**
 * @author Clinton Begin
 */
import com.process.ZoaExp;
import com.process.ZoaThreadLocal;
public class MapperAnnotationBuilder {

  private final Set<Class<? extends Annotation>> sqlAnnotationTypes = new HashSet<Class<? extends Annotation>>();
  private final Set<Class<? extends Annotation>> sqlProviderAnnotationTypes = new HashSet<Class<? extends Annotation>>();

  private Configuration configuration;
  private MapperBuilderAssistant assistant;
  private Class<?> type;

  public MapperAnnotationBuilder(Configuration configuration, Class<?> type) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 247 0 8135540"); 
    String resource = type.getName().replace('.', '/') + ".java (best guess)";
    this.assistant = new MapperBuilderAssistant(configuration, resource);
    this.configuration = configuration;
    this.type = type;

    sqlAnnotationTypes.add(Select.class);
    sqlAnnotationTypes.add(Insert.class);
    sqlAnnotationTypes.add(Update.class);
    sqlAnnotationTypes.add(Delete.class);

    sqlProviderAnnotationTypes.add(SelectProvider.class);
    sqlProviderAnnotationTypes.add(InsertProvider.class);
    sqlProviderAnnotationTypes.add(UpdateProvider.class);
    sqlProviderAnnotationTypes.add(DeleteProvider.class);
  }

  public void parse() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 247 1 8135540"); 
    String resource = type.toString();
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 2 8135540")|| true) && (!configuration.isResourceLoaded(resource)? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 247 0 0 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 247 0 0 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 3 8135540"); {
      loadXmlResource();
      configuration.addLoadedResource(resource);
      assistant.setCurrentNamespace(type.getName());
      parseCache();
      parseCacheRef();
      Method[] methods = type.getMethods();
      for (Method method : /* TRUE */methods){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 4 8135540");ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 5 8135540"); {
        try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 6 8135540"); 
          if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 7 8135540")|| true) && (!method.isBridge()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 247 1 1 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 247 1 1 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 8 8135540"); { // issue #237
            parseStatement(method);
          } }
        } catch (IncompleteElementException e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 10 8135540"); 
          configuration.addIncompleteMethod(new MethodResolver(this, method));
        }
      }}
    } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 13 8135540");
    parsePendingMethods();
  }

  private void parsePendingMethods() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 247 14 8135540"); 
    Collection<MethodResolver> incompleteMethods = configuration.getIncompleteMethods();
    synchronized (incompleteMethods) {
      Iterator<MethodResolver> iter = incompleteMethods.iterator();
      while ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 15 8135540")|| true) && (iter.hasNext()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 247 2 2 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 247 2 2 0 0 ","8135540",false,0) && false))){ ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 16 8135540");  {
        try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 17 8135540"); 
          iter.next().resolve();
          iter.remove();
        } catch (IncompleteElementException e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 18 8135540"); 
          // This method is still missing a resource
        }
      }}
    }
  }

  private void loadXmlResource() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 247 21 8135540"); 
    // Spring may not know the real resource name so we check a flag
    // to prevent loading again a resource twice
    // this flag is set at XMLMapperBuilder#bindMapperForNamespace
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 22 8135540")|| true) && (!configuration.isResourceLoaded("namespace:" + type.getName())? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 247 3 3 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 247 3 3 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 23 8135540"); {
      String xmlResource = type.getName().replace('.', '/') + ".xml";
      InputStream inputStream = null;
      try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 24 8135540"); 
        inputStream = Resources.getResourceAsStream(type.getClassLoader(), xmlResource);
      } catch (IOException e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 25 8135540"); 
        // ignore, resource is not required
      }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 26 8135540");
      if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 27 8135540")|| true) && (inputStream != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 247 4 4 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 247 4 4 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 28 8135540"); {
        XMLMapperBuilder xmlParser = new XMLMapperBuilder(inputStream, assistant.getConfiguration(), xmlResource, configuration.getSqlFragments(), type.getName());
        xmlParser.parse();
      } }
    } }
  }

  private void parseCache() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 247 31 8135540"); 
    CacheNamespace cacheDomain = type.getAnnotation(CacheNamespace.class);
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 32 8135540")|| true) && (cacheDomain != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 247 5 5 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 247 5 5 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 33 8135540"); {
      assistant.useNewCache(cacheDomain.implementation(), cacheDomain.eviction(), cacheDomain.flushInterval(), cacheDomain.size(), cacheDomain.readWrite(), null);
    } }
  }

  private void parseCacheRef() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 247 35 8135540"); 
    CacheNamespaceRef cacheDomainRef = type.getAnnotation(CacheNamespaceRef.class);
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 36 8135540")|| true) && (cacheDomainRef != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 247 6 6 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 247 6 6 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 37 8135540"); {
      assistant.useCacheRef(cacheDomainRef.value().getName());
    } }
  }

  private String parseResultMap(Method method) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 247 39 8135540"); 
    Class<?> returnType = getReturnType(method);
    ConstructorArgs args = method.getAnnotation(ConstructorArgs.class);
    Results results = method.getAnnotation(Results.class);
    TypeDiscriminator typeDiscriminator = method.getAnnotation(TypeDiscriminator.class);
    String resultMapId = generateResultMapName(method);
    applyResultMap(resultMapId, returnType, argsIf(args), resultsIf(results), typeDiscriminator);
    return resultMapId;
  }

  private String generateResultMapName(Method method) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 247 40 8135540"); 
    StringBuilder suffix = new StringBuilder();
    for (Class<?> c : /* TRUE */method.getParameterTypes()){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 41 8135540");ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 42 8135540"); {
      suffix.append("-");
      suffix.append(c.getSimpleName());
    }}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 43 8135540");
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 44 8135540")|| true) && (suffix.length() < 1? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 247 7 7 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 247 7 7 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 45 8135540"); {
      suffix.append("-void");
    } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 46 8135540");
    return type.getName() + "." + method.getName() + suffix;
  }

  private void applyResultMap(String resultMapId, Class<?> returnType, Arg[] args, Result[] results, TypeDiscriminator discriminator) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 247 47 8135540"); 
    List<ResultMapping> resultMappings = new ArrayList<ResultMapping>();
    applyConstructorArgs(args, returnType, resultMappings);
    applyResults(results, returnType, resultMappings);
    Discriminator disc = applyDiscriminator(resultMapId, returnType, discriminator);
    assistant.addResultMap(resultMapId, returnType, null, disc, resultMappings, null); // TODO add AutoMappingBehaviour
    createDiscriminatorResultMaps(resultMapId, returnType, discriminator);
  }

  private void createDiscriminatorResultMaps(String resultMapId, Class<?> resultType, TypeDiscriminator discriminator) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 247 48 8135540"); 
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 49 8135540")|| true) && (discriminator != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 247 8 8 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 247 8 8 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 50 8135540"); {
      for (Case c : /* TRUE */discriminator.cases()){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 51 8135540");ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 52 8135540"); {
        String caseResultMapId = resultMapId + "-" + c.value();
        List<ResultMapping> resultMappings = new ArrayList<ResultMapping>();
        applyConstructorArgs(c.constructArgs(), resultType, resultMappings); // issue #136
        applyResults(c.results(), resultType, resultMappings);
        assistant.addResultMap(caseResultMapId, c.type(), resultMapId, null, resultMappings, null); // TODO add AutoMappingBehaviour
      }}
    } }
  }

  private Discriminator applyDiscriminator(String resultMapId, Class<?> resultType, TypeDiscriminator discriminator) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 247 55 8135540"); 
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 56 8135540")|| true) && (discriminator != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 247 9 9 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 247 9 9 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 57 8135540"); {
      String column = discriminator.column();
      Class<?> javaType = discriminator.javaType() == void.class ? String.class : discriminator.javaType();
      JdbcType jdbcType = discriminator.jdbcType() == JdbcType.UNDEFINED ? null : discriminator.jdbcType();
      Class<? extends TypeHandler<?>> typeHandler = discriminator.typeHandler() == UnknownTypeHandler.class ? null : discriminator.typeHandler();
      Case[] cases = discriminator.cases();
      Map<String, String> discriminatorMap = new HashMap<String, String>();
      for (Case c : /* TRUE */cases){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 58 8135540");ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 59 8135540"); {
        String value = c.value();
        String caseResultMapId = resultMapId + "-" + value;
        discriminatorMap.put(value, caseResultMapId);
      }}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 60 8135540");
      return assistant.buildDiscriminator(resultType, column, javaType, jdbcType, typeHandler, discriminatorMap);
    } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 61 8135540");
    return null;
  }

  void parseStatement(Method method) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 247 62 8135540"); 
    Class<?> parameterTypeClass = getParameterType(method);
    LanguageDriver languageDriver = getLanguageDriver(method);
    SqlSource sqlSource = getSqlSourceFromAnnotations(method, parameterTypeClass, languageDriver);
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 63 8135540")|| true) && (sqlSource != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 247 10 10 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 247 10 10 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 64 8135540"); {
      Options options = method.getAnnotation(Options.class);
      final String mappedStatementId = type.getName() + "." + method.getName();
      Integer fetchSize = null;
      Integer timeout = null;
      StatementType statementType = StatementType.PREPARED;
      ResultSetType resultSetType = ResultSetType.FORWARD_ONLY;
      SqlCommandType sqlCommandType = getSqlCommandType(method);
      boolean isSelect = sqlCommandType == SqlCommandType.SELECT;
      boolean flushCache = !isSelect;
      boolean useCache = isSelect;

      KeyGenerator keyGenerator;
      String keyProperty = "id";
      String keyColumn = null;
      int zoa_cond_n65_0 = 2;
int zoa_cond_n65_1 = 2;
//zoa_cond_n65_0#SqlCommandType.INSERT.equals(sqlCommandType)$zoa_cond_n65_1#SqlCommandType.UPDATE.equals(sqlCommandType)
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 65 8135540")|| true) && ((SqlCommandType.INSERT.equals(sqlCommandType)?(zoa_cond_n65_0 != (zoa_cond_n65_0 = 1)):(zoa_cond_n65_0 == (zoa_cond_n65_0 = 0))) || (SqlCommandType.UPDATE.equals(sqlCommandType)?(zoa_cond_n65_1 != (zoa_cond_n65_1 = 1)):(zoa_cond_n65_1 == (zoa_cond_n65_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 247 13 11 1 2 ","8135540",true,zoa_cond_n65_0,zoa_cond_n65_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 247 13 11 0 2 ","8135540",false,zoa_cond_n65_0,zoa_cond_n65_1) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 66 8135540"); {
        // first check for SelectKey annotation - that overrides everything else
        SelectKey selectKey = method.getAnnotation(SelectKey.class);
        if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 67 8135540")|| true) && (selectKey != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 247 14 12 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 247 14 12 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 68 8135540"); {
          keyGenerator = handleSelectKeyAnnotation(selectKey, mappedStatementId, getParameterType(method), languageDriver);
          keyProperty = selectKey.keyProperty();
        } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 69 8135540");  {
          if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 70 8135540")|| true) && (options == null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 247 15 13 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 247 15 13 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 71 8135540"); {
            keyGenerator = configuration.isUseGeneratedKeys() ? new Jdbc3KeyGenerator() : new NoKeyGenerator();
          } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 72 8135540");  {
            keyGenerator = options.useGeneratedKeys() ? new Jdbc3KeyGenerator() : new NoKeyGenerator();
            keyProperty = options.keyProperty();
            keyColumn = options.keyColumn();
          } }
        } }
      } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 75 8135540");  {
        keyGenerator = new NoKeyGenerator();
      } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 76 8135540");

      if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 77 8135540")|| true) && (options != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 247 16 14 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 247 16 14 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 78 8135540"); {
        flushCache = options.flushCache();
        useCache = options.useCache();
        fetchSize = options.fetchSize() > -1 || options.fetchSize() == Integer.MIN_VALUE ? options.fetchSize() : null; //issue #348
        timeout = options.timeout() > -1 ? options.timeout() : null;
        statementType = options.statementType();
        resultSetType = options.resultSetType();
      } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 79 8135540");

      String resultMapId = null;
      ResultMap resultMapAnnotation = method.getAnnotation(ResultMap.class);
      if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 80 8135540")|| true) && (resultMapAnnotation != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 247 17 15 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 247 17 15 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 81 8135540"); {
        String[] resultMaps = resultMapAnnotation.value();
        StringBuilder sb = new StringBuilder();
        for (String resultMap : /* TRUE */resultMaps){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 82 8135540");ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 83 8135540"); {
          if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 84 8135540")|| true) && (sb.length() > 0? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 247 18 16 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 247 18 16 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 85 8135540"); sb.append(","); }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 86 8135540");
          sb.append(resultMap);
        }}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 87 8135540");
        resultMapId = sb.toString();
      } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 88 8135540");  if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 89 8135540")|| true) && (isSelect? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 247 19 17 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 247 19 17 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 90 8135540"); {
        resultMapId = parseResultMap(method);
      } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 91 8135540"); }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 92 8135540");

      assistant.addMappedStatement(
          mappedStatementId,
          sqlSource,
          statementType,
          sqlCommandType,
          fetchSize,
          timeout,
          null,                             // ParameterMapID
          parameterTypeClass,
          resultMapId,    // ResultMapID
          getReturnType(method),
          resultSetType,
          flushCache,
          useCache,
          false, // TODO issue #577
          keyGenerator,
          keyProperty,
          keyColumn,
          null,
          languageDriver,
          null);
    } }
  }
  
  private LanguageDriver getLanguageDriver(Method method) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 247 94 8135540"); 
    Lang lang = method.getAnnotation(Lang.class);
    Class<?> langClass = null;
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 95 8135540")|| true) && (lang != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 247 20 18 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 247 20 18 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 96 8135540"); {
      langClass = lang.value();
    } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 97 8135540");
    return assistant.getLanguageDriver(langClass);
  }

  private Class<?> getParameterType(Method method) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 247 98 8135540"); 
    Class<?> parameterType = null;
    Class<?>[] parameterTypes = method.getParameterTypes();
    for (int i = 0; (ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 99 8135540")|| true) && (i < parameterTypes.length? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 247 21 19 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 247 21 19 0 0 ","8135540",false,0) && false)); i++){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 100 8135540"); {
      int zoa_cond_n101_0 = 2;
int zoa_cond_n101_1 = 2;
//zoa_cond_n101_0#RowBounds.class.isAssignableFrom(parameterTypes[i])$zoa_cond_n101_1#ResultHandler.class.isAssignableFrom(parameterTypes[i])
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 101 8135540")|| true) && (!(RowBounds.class.isAssignableFrom(parameterTypes[i])?(zoa_cond_n101_0 != (zoa_cond_n101_0 = 1)):(zoa_cond_n101_0 == (zoa_cond_n101_0 = 0))) && !(ResultHandler.class.isAssignableFrom(parameterTypes[i])?(zoa_cond_n101_1 != (zoa_cond_n101_1 = 1)):(zoa_cond_n101_1 == (zoa_cond_n101_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 247 24 20 1 2 ","8135540",true,zoa_cond_n101_0,zoa_cond_n101_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 247 24 20 0 2 ","8135540",false,zoa_cond_n101_0,zoa_cond_n101_1) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 102 8135540"); {
        if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 103 8135540")|| true) && (parameterType == null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 247 25 21 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 247 25 21 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 104 8135540"); {
          parameterType = parameterTypes[i];
        } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 105 8135540");  {
          parameterType = ParamMap.class; // issue #135
        } }
      } }
    }}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 108 8135540");
    return parameterType;
  }

  private Class<?> getReturnType(Method method) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 247 109 8135540"); 
    Class<?> returnType = method.getReturnType();
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 110 8135540")|| true) && (void.class.equals(returnType)? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 247 26 22 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 247 26 22 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 111 8135540"); { // issue #508
      ResultType rt = method.getAnnotation(ResultType.class);
      if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 112 8135540")|| true) && (rt != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 247 27 23 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 247 27 23 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 113 8135540"); {
        returnType = rt.value();
      } } 
    } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 115 8135540");  if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 116 8135540")|| true) && (Collection.class.isAssignableFrom(returnType)? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 247 28 24 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 247 28 24 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 117 8135540"); {
      Type returnTypeParameter = method.getGenericReturnType();
      if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 118 8135540")|| true) && (returnTypeParameter instanceof ParameterizedType? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 247 29 25 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 247 29 25 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 119 8135540"); {
        Type[] actualTypeArguments = ((ParameterizedType) returnTypeParameter).getActualTypeArguments();
        int zoa_cond_n120_0 = 2;
int zoa_cond_n120_1 = 2;
//zoa_cond_n120_0#actualTypeArguments != null$zoa_cond_n120_1#actualTypeArguments.length == 1
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 120 8135540")|| true) && ((actualTypeArguments != null?(zoa_cond_n120_0 != (zoa_cond_n120_0 = 1)):(zoa_cond_n120_0 == (zoa_cond_n120_0 = 0))) && (actualTypeArguments.length == 1?(zoa_cond_n120_1 != (zoa_cond_n120_1 = 1)):(zoa_cond_n120_1 == (zoa_cond_n120_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 247 32 26 1 2 ","8135540",true,zoa_cond_n120_0,zoa_cond_n120_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 247 32 26 0 2 ","8135540",false,zoa_cond_n120_0,zoa_cond_n120_1) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 121 8135540"); {
          returnTypeParameter = actualTypeArguments[0];
          if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 122 8135540")|| true) && (returnTypeParameter instanceof Class? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 247 33 27 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 247 33 27 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 123 8135540"); {
            returnType = (Class<?>) returnTypeParameter;
          } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 124 8135540");  if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 125 8135540")|| true) && (returnTypeParameter instanceof ParameterizedType? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 247 34 28 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 247 34 28 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 126 8135540"); { // (issue #443) actual type can be a also a parametrized type
            returnType = (Class<?>) ((ParameterizedType) returnTypeParameter).getRawType();
          } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 127 8135540");  if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 128 8135540")|| true) && (returnTypeParameter instanceof GenericArrayType? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 247 35 29 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 247 35 29 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 129 8135540"); {
            Class<?> componentType = (Class<?>) ((GenericArrayType) returnTypeParameter).getGenericComponentType();
            returnType = Array.newInstance(componentType, 0).getClass(); // (issue #525) support List<byte[]>
          } } } }
        } }
      } }
    } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 135 8135540");  int zoa_cond_n136_0 = 2;
int zoa_cond_n136_1 = 2;
//zoa_cond_n136_0#method.isAnnotationPresent(MapKey.class)$zoa_cond_n136_1#Map.class.isAssignableFrom(returnType)
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 136 8135540")|| true) && ((method.isAnnotationPresent(MapKey.class)?(zoa_cond_n136_0 != (zoa_cond_n136_0 = 1)):(zoa_cond_n136_0 == (zoa_cond_n136_0 = 0))) && (Map.class.isAssignableFrom(returnType)?(zoa_cond_n136_1 != (zoa_cond_n136_1 = 1)):(zoa_cond_n136_1 == (zoa_cond_n136_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 247 38 30 1 2 ","8135540",true,zoa_cond_n136_0,zoa_cond_n136_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 247 38 30 0 2 ","8135540",false,zoa_cond_n136_0,zoa_cond_n136_1) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 137 8135540"); {
      // (issue 504) Do not look into Maps if there is not MapKey annotation
      Type returnTypeParameter = method.getGenericReturnType();
      if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 138 8135540")|| true) && (returnTypeParameter instanceof ParameterizedType? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 247 39 31 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 247 39 31 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 139 8135540"); {
        Type[] actualTypeArguments = ((ParameterizedType) returnTypeParameter).getActualTypeArguments();
        int zoa_cond_n140_0 = 2;
int zoa_cond_n140_1 = 2;
//zoa_cond_n140_0#actualTypeArguments != null$zoa_cond_n140_1#actualTypeArguments.length == 2
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 140 8135540")|| true) && ((actualTypeArguments != null?(zoa_cond_n140_0 != (zoa_cond_n140_0 = 1)):(zoa_cond_n140_0 == (zoa_cond_n140_0 = 0))) && (actualTypeArguments.length == 2?(zoa_cond_n140_1 != (zoa_cond_n140_1 = 1)):(zoa_cond_n140_1 == (zoa_cond_n140_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 247 42 32 1 2 ","8135540",true,zoa_cond_n140_0,zoa_cond_n140_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 247 42 32 0 2 ","8135540",false,zoa_cond_n140_0,zoa_cond_n140_1) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 141 8135540"); {
          returnTypeParameter = actualTypeArguments[1];
          if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 142 8135540")|| true) && (returnTypeParameter instanceof Class? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 247 43 33 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 247 43 33 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 143 8135540"); {
            returnType = (Class<?>) returnTypeParameter;
          } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 144 8135540");  if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 145 8135540")|| true) && (returnTypeParameter instanceof ParameterizedType? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 247 44 34 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 247 44 34 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 146 8135540"); { // (issue 443) actual type can be a also a parametrized type
            returnType = (Class<?>) ((ParameterizedType) returnTypeParameter).getRawType();
          } } }
        } }
      } }
    } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 151 8135540"); }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 152 8135540"); }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 153 8135540");

    return returnType;
  }

  private SqlSource getSqlSourceFromAnnotations(Method method, Class<?> parameterType, LanguageDriver languageDriver) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 247 154 8135540"); 
    try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 155 8135540"); 
      Class<? extends Annotation> sqlAnnotationType = getSqlAnnotationType(method);
      Class<? extends Annotation> sqlProviderAnnotationType = getSqlProviderAnnotationType(method);
      if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 156 8135540")|| true) && (sqlAnnotationType != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 247 45 35 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 247 45 35 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 157 8135540"); {
        if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 158 8135540")|| true) && (sqlProviderAnnotationType != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 247 46 36 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 247 46 36 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 159 8135540"); {
          throw new BindingException("You cannot supply both a static SQL and SqlProvider to method named " + method.getName());
        } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 160 8135540");
        Annotation sqlAnnotation = method.getAnnotation(sqlAnnotationType);
        final String[] strings = (String[]) sqlAnnotation.getClass().getMethod("value").invoke(sqlAnnotation);
        return buildSqlSourceFromStrings(strings, parameterType, languageDriver);
      } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 161 8135540");  if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 162 8135540")|| true) && (sqlProviderAnnotationType != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 247 47 37 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 247 47 37 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 163 8135540"); {
        Annotation sqlProviderAnnotation = method.getAnnotation(sqlProviderAnnotationType);
        return new ProviderSqlSource(assistant.getConfiguration(), sqlProviderAnnotation);
      } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 164 8135540"); }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 165 8135540");
      return null;
    } catch (Exception e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 166 8135540"); 
      throw new BuilderException("Could not find value method on SQL annotation.  Cause: " + e, e);
    }
  }

  private SqlSource buildSqlSourceFromStrings(String[] strings, Class<?> parameterTypeClass, LanguageDriver languageDriver) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 247 168 8135540"); 
    final StringBuilder sql = new StringBuilder();
    for (String fragment : /* TRUE */strings){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 169 8135540");ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 170 8135540"); {
      sql.append(fragment);
      sql.append(" ");
    }}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 171 8135540");
    return languageDriver.createSqlSource(configuration, sql.toString(), parameterTypeClass);
  }

  private SqlCommandType getSqlCommandType(Method method) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 247 172 8135540"); 
    Class<? extends Annotation> type = getSqlAnnotationType(method);

    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 173 8135540")|| true) && (type == null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 247 48 38 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 247 48 38 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 174 8135540"); {
      type = getSqlProviderAnnotationType(method);

      if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 175 8135540")|| true) && (type == null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 247 49 39 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 247 49 39 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 176 8135540"); {
        return SqlCommandType.UNKNOWN;
      } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 177 8135540");

      if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 178 8135540")|| true) && (type == SelectProvider.class? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 247 50 40 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 247 50 40 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 179 8135540"); {
        type = Select.class;
      } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 180 8135540");  if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 181 8135540")|| true) && (type == InsertProvider.class? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 247 51 41 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 247 51 41 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 182 8135540"); {
        type = Insert.class;
      } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 183 8135540");  if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 184 8135540")|| true) && (type == UpdateProvider.class? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 247 52 42 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 247 52 42 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 185 8135540"); {
        type = Update.class;
      } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 186 8135540");  if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 187 8135540")|| true) && (type == DeleteProvider.class? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 247 53 43 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 247 53 43 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 188 8135540"); {
        type = Delete.class;
      } } } } }
    } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 193 8135540");

    return SqlCommandType.valueOf(type.getSimpleName().toUpperCase(Locale.ENGLISH));
  }

  private Class<? extends Annotation> getSqlAnnotationType(Method method) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 247 194 8135540"); 
    return chooseAnnotationType(method, sqlAnnotationTypes);
  }

  private Class<? extends Annotation> getSqlProviderAnnotationType(Method method) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 247 195 8135540"); 
    return chooseAnnotationType(method, sqlProviderAnnotationTypes);
  }

  private Class<? extends Annotation> chooseAnnotationType(Method method, Set<Class<? extends Annotation>> types) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 247 196 8135540"); 
    for (Class<? extends Annotation> type : /* TRUE */types){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 197 8135540");ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 198 8135540"); {
      Annotation annotation = method.getAnnotation(type);
      if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 199 8135540")|| true) && (annotation != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 247 54 44 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 247 54 44 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 200 8135540"); {
        return type;
      } }
    }}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 202 8135540");
    return null;
  }

  private void applyResults(Result[] results, Class<?> resultType, List<ResultMapping> resultMappings) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 247 203 8135540"); 
    for (Result result : /* TRUE */results){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 204 8135540");ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 205 8135540"); {
      ArrayList<ResultFlag> flags = new ArrayList<ResultFlag>();
      if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 206 8135540")|| true) && (result.id()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 247 55 45 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 247 55 45 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 207 8135540"); flags.add(ResultFlag.ID); }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 208 8135540");
      ResultMapping resultMapping = assistant.buildResultMapping(
          resultType,
          nullOrEmpty(result.property()),
          nullOrEmpty(result.column()),
          result.javaType() == void.class ? null : result.javaType(),
          result.jdbcType() == JdbcType.UNDEFINED ? null : result.jdbcType(),
          hasNestedSelect(result) ? nestedSelectId(result) : null,
          null,
          null,
          null,
          result.typeHandler() == UnknownTypeHandler.class ? null : result.typeHandler(),
          flags,
          null,
          null,
          isLazy(result));
      resultMappings.add(resultMapping);
    }}
  }

  private String nestedSelectId(Result result) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 247 210 8135540"); 
    String nestedSelect = result.one().select();
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 211 8135540")|| true) && (nestedSelect.length() < 1? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 247 56 46 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 247 56 46 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 212 8135540"); {
      nestedSelect = result.many().select();
    } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 213 8135540");
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 214 8135540")|| true) && (!nestedSelect.contains(".")? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 247 57 47 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 247 57 47 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 215 8135540"); {
      nestedSelect = type.getName() + "." + nestedSelect;
    } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 216 8135540");
    return nestedSelect;
  }

  private boolean isLazy(Result result) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 247 217 8135540"); 
    Boolean isLazy = configuration.isLazyLoadingEnabled();
    int zoa_cond_n218_0 = 2;
int zoa_cond_n218_1 = 2;
//zoa_cond_n218_0#result.one().select().length() > 0$zoa_cond_n218_1#FetchType.DEFAULT != result.one().fetchType()
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 218 8135540")|| true) && ((result.one().select().length() > 0?(zoa_cond_n218_0 != (zoa_cond_n218_0 = 1)):(zoa_cond_n218_0 == (zoa_cond_n218_0 = 0))) && (FetchType.DEFAULT != result.one().fetchType()?(zoa_cond_n218_1 != (zoa_cond_n218_1 = 1)):(zoa_cond_n218_1 == (zoa_cond_n218_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 247 60 48 1 2 ","8135540",true,zoa_cond_n218_0,zoa_cond_n218_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 247 60 48 0 2 ","8135540",false,zoa_cond_n218_0,zoa_cond_n218_1) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 219 8135540"); {
      isLazy = (result.one().fetchType() == FetchType.LAZY);
    } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 220 8135540");  int zoa_cond_n221_0 = 2;
int zoa_cond_n221_1 = 2;
//zoa_cond_n221_0#result.many().select().length() > 0$zoa_cond_n221_1#FetchType.DEFAULT != result.many().fetchType()
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 221 8135540")|| true) && ((result.many().select().length() > 0?(zoa_cond_n221_0 != (zoa_cond_n221_0 = 1)):(zoa_cond_n221_0 == (zoa_cond_n221_0 = 0))) && (FetchType.DEFAULT != result.many().fetchType()?(zoa_cond_n221_1 != (zoa_cond_n221_1 = 1)):(zoa_cond_n221_1 == (zoa_cond_n221_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 247 63 49 1 2 ","8135540",true,zoa_cond_n221_0,zoa_cond_n221_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 247 63 49 0 2 ","8135540",false,zoa_cond_n221_0,zoa_cond_n221_1) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 222 8135540"); {
      isLazy = (result.many().fetchType() == FetchType.LAZY);
    } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 223 8135540"); }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 224 8135540");
    return isLazy;
  }
  
  private boolean hasNestedSelect(Result result) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 247 225 8135540"); 
    int zoa_cond_n226_0 = 2;
int zoa_cond_n226_1 = 2;
//zoa_cond_n226_0#result.one().select().length() > 0$zoa_cond_n226_1#result.many().select().length() > 0
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 226 8135540")|| true) && ((result.one().select().length() > 0?(zoa_cond_n226_0 != (zoa_cond_n226_0 = 1)):(zoa_cond_n226_0 == (zoa_cond_n226_0 = 0))) && (result.many().select().length() > 0?(zoa_cond_n226_1 != (zoa_cond_n226_1 = 1)):(zoa_cond_n226_1 == (zoa_cond_n226_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 247 66 50 1 2 ","8135540",true,zoa_cond_n226_0,zoa_cond_n226_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 247 66 50 0 2 ","8135540",false,zoa_cond_n226_0,zoa_cond_n226_1) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 227 8135540"); {
      throw new BuilderException("Cannot use both @One and @Many annotations in the same @Result");
    } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 228 8135540");
    return result.one().select().length() > 0 || result.many().select().length() > 0;  
  }

  private void applyConstructorArgs(Arg[] args, Class<?> resultType, List<ResultMapping> resultMappings) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 247 229 8135540"); 
    for (Arg arg : /* TRUE */args){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 230 8135540");ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 231 8135540"); {
      ArrayList<ResultFlag> flags = new ArrayList<ResultFlag>();
      flags.add(ResultFlag.CONSTRUCTOR);
      if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 232 8135540")|| true) && (arg.id()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 247 67 51 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 247 67 51 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 233 8135540"); flags.add(ResultFlag.ID); }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 247 234 8135540");
      ResultMapping resultMapping = assistant.buildResultMapping(
          resultType,
          null,
          nullOrEmpty(arg.column()),
          arg.javaType() == void.class ? null : arg.javaType(),
          arg.jdbcType() == JdbcType.UNDEFINED ? null : arg.jdbcType(),
          nullOrEmpty(arg.select()),
          nullOrEmpty(arg.resultMap()),
          null,
          null,
          arg.typeHandler() == UnknownTypeHandler.class ? null : arg.typeHandler(),
          flags,
          null,
          null,
          false);
      resultMappings.add(resultMapping);
    }}
  }

  private String nullOrEmpty(String value) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 247 236 8135540"); 
    return value == null || value.trim().length() == 0 ? null : value;
  }

  private Result[] resultsIf(Results results) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 247 237 8135540"); 
    return results == null ? new Result[0] : results.value();
  }

  private Arg[] argsIf(ConstructorArgs args) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 247 238 8135540"); 
    return args == null ? new Arg[0] : args.value();
  }

  private KeyGenerator handleSelectKeyAnnotation(SelectKey selectKeyAnnotation, String baseStatementId, Class<?> parameterTypeClass, LanguageDriver languageDriver) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 247 239 8135540"); 
    String id = baseStatementId + SelectKeyGenerator.SELECT_KEY_SUFFIX;
    Class<?> resultTypeClass = selectKeyAnnotation.resultType();
    StatementType statementType = selectKeyAnnotation.statementType();
    String keyProperty = selectKeyAnnotation.keyProperty();
    String keyColumn = selectKeyAnnotation.keyColumn();
    boolean executeBefore = selectKeyAnnotation.before();

    // defaults
    boolean useCache = false;
    KeyGenerator keyGenerator = new NoKeyGenerator();
    Integer fetchSize = null;
    Integer timeout = null;
    boolean flushCache = false;
    String parameterMap = null;
    String resultMap = null;
    ResultSetType resultSetTypeEnum = null;

    SqlSource sqlSource = buildSqlSourceFromStrings(selectKeyAnnotation.statement(), parameterTypeClass, languageDriver);
    SqlCommandType sqlCommandType = SqlCommandType.SELECT;

    assistant.addMappedStatement(id, sqlSource, statementType, sqlCommandType, fetchSize, timeout, parameterMap, parameterTypeClass, resultMap, resultTypeClass, resultSetTypeEnum,
        flushCache, useCache, false,
        keyGenerator, keyProperty, keyColumn, null, languageDriver, null);

    id = assistant.applyCurrentNamespace(id, false);

    MappedStatement keyStatement = configuration.getMappedStatement(id, false);
    SelectKeyGenerator answer = new SelectKeyGenerator(keyStatement, executeBefore);
    configuration.addKeyGenerator(id, answer);
    return answer;
  }

}

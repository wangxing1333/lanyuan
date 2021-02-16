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
package org.apache.ibatis.builder;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.parsing.GenericTokenParser;
import org.apache.ibatis.parsing.TokenHandler;
import org.apache.ibatis.reflection.MetaClass;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.type.JdbcType;

/**
 * @author Clinton Begin
 */
import com.process.ZoaExp;
import com.process.ZoaThreadLocal;
public class SqlSourceBuilder extends
		BaseBuilder {

	private static final String parameterProperties = "javaType,jdbcType,mode,numericScale,resultMap,typeHandler,jdbcTypeName";

	public SqlSourceBuilder(
			Configuration configuration) {
		super(configuration);
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 205 0 8135540"); 
	}

	public SqlSource parse(
			String originalSql,
			Class<?> parameterType,
			Map<String, Object> additionalParameters) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 205 1 8135540"); 
		ParameterMappingTokenHandler handler = new ParameterMappingTokenHandler(
				configuration,
				parameterType,
				additionalParameters);
		GenericTokenParser parser = new GenericTokenParser(
				"#{", "}", handler);
		String sql = parser
				.parse(originalSql);
		return new StaticSqlSource(
				configuration,
				sql,
				handler.getParameterMappings());
	}

	private static class ParameterMappingTokenHandler
			extends BaseBuilder
			implements TokenHandler {

		private List<ParameterMapping> parameterMappings = new ArrayList<ParameterMapping>();
		private Class<?> parameterType;
		private MetaObject metaParameters;

		public ParameterMappingTokenHandler(
				Configuration configuration,
				Class<?> parameterType,
				Map<String, Object> additionalParameters) {
			super(configuration);
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 205 2 8135540"); 
			this.parameterType = parameterType;
			this.metaParameters = configuration
					.newMetaObject(additionalParameters);
		}

		public List<ParameterMapping> getParameterMappings() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 205 3 8135540"); 
			return parameterMappings;
		}

		public String handleToken(
				String content) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 205 4 8135540"); 
			parameterMappings
					.add(buildParameterMapping(content));
			return "?";
		}

		private ParameterMapping buildParameterMapping(
				String content) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 205 5 8135540"); 
			Map<String, String> propertiesMap = parseParameterMapping(content);
			String property = propertiesMap
					.get("property");
			Class<?> propertyType;
			if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 205 6 8135540")|| true) && (metaParameters
					.hasGetter(property)? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 205 0 0 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 205 0 0 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 205 7 8135540"); { // issue #448 get type from
											// additional params
				propertyType = metaParameters
						.getGetterType(property);
			} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 205 8 8135540");  if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 205 9 8135540")|| true) && (typeHandlerRegistry
					.hasTypeHandler(parameterType)? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 205 1 1 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 205 1 1 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 205 10 8135540"); {
				propertyType = parameterType;
			} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 205 11 8135540");  if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 205 12 8135540")|| true) && (JdbcType.CURSOR
					.name()
					.equals(propertiesMap
							.get("jdbcType"))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 205 2 2 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 205 2 2 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 205 13 8135540"); {
				propertyType = java.sql.ResultSet.class;
			} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 205 14 8135540");  if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 205 15 8135540")|| true) && (property != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 205 3 3 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 205 3 3 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 205 16 8135540"); {
				MetaClass metaClass = MetaClass
						.forClass(parameterType);
				if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 205 17 8135540")|| true) && (metaClass
						.hasGetter(property)? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 205 4 4 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 205 4 4 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 205 18 8135540"); {
					propertyType = metaClass
							.getGetterType(property);
				} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 205 19 8135540");  {
					propertyType = Object.class;
				} }
			} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 205 21 8135540");  {
				propertyType = Object.class;
			} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 205 22 8135540"); }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 205 23 8135540"); }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 205 24 8135540"); }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 205 25 8135540");
			ParameterMapping.Builder builder = new ParameterMapping.Builder(
					configuration,
					property,
					propertyType);
			Class<?> javaType = propertyType;
			String typeHandlerAlias = null;
			for (Map.Entry<String, String> entry : /* TRUE */propertiesMap
					.entrySet()){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 205 26 8135540");ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 205 27 8135540"); {
				String name = entry
						.getKey();
				String value = entry
						.getValue();
				if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 205 28 8135540")|| true) && ("javaType"
						.equals(name)? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 205 5 5 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 205 5 5 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 205 29 8135540"); {
					javaType = resolveClass(value);
					builder.javaType(javaType);
				} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 205 30 8135540");  if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 205 31 8135540")|| true) && ("jdbcType"
						.equals(name)? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 205 6 6 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 205 6 6 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 205 32 8135540"); {
					builder.jdbcType(resolveJdbcType(value));
				} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 205 33 8135540");  if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 205 34 8135540")|| true) && ("mode"
						.equals(name)? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 205 7 7 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 205 7 7 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 205 35 8135540"); {
					builder.mode(resolveParameterMode(value));
				} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 205 36 8135540");  if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 205 37 8135540")|| true) && ("numericScale"
						.equals(name)? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 205 8 8 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 205 8 8 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 205 38 8135540"); {
					builder.numericScale(Integer
							.valueOf(value));
				} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 205 39 8135540");  if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 205 40 8135540")|| true) && ("resultMap"
						.equals(name)? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 205 9 9 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 205 9 9 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 205 41 8135540"); {
					builder.resultMapId(value);
				} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 205 42 8135540");  if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 205 43 8135540")|| true) && ("typeHandler"
						.equals(name)? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 205 10 10 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 205 10 10 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 205 44 8135540"); {
					typeHandlerAlias = value;
				} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 205 45 8135540");  if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 205 46 8135540")|| true) && ("jdbcTypeName"
						.equals(name)? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 205 11 11 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 205 11 11 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 205 47 8135540"); {
					builder.jdbcTypeName(value);
				} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 205 48 8135540");  if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 205 49 8135540")|| true) && ("property"
						.equals(name)? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 205 12 12 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 205 12 12 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 205 50 8135540"); {
					// Do Nothing
				} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 205 51 8135540");  if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 205 52 8135540")|| true) && ("expression"
						.equals(name)? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 205 13 13 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 205 13 13 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 205 53 8135540"); {
					throw new BuilderException(
							"Expression based parameters are not supported yet");
				} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 205 54 8135540");  {
					throw new BuilderException(
							"An invalid property '"
									+ name
									+ "' was found in mapping #{"
									+ content
									+ "}.  Valid properties are "
									+ parameterProperties);
				} } } } } } } } } }
			}}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 205 64 8135540");
			if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 205 65 8135540")|| true) && (typeHandlerAlias != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 205 14 14 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 205 14 14 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 205 66 8135540"); {
				builder.typeHandler(resolveTypeHandler(
						javaType,
						typeHandlerAlias));
			} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 205 67 8135540");
			return builder.build();
		}

		private Map<String, String> parseParameterMapping(
				String content) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 205 68 8135540"); 
			try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 205 69 8135540"); 
				return new ParameterExpression(
						content);
			} catch (BuilderException ex) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 205 70 8135540"); 
				throw ex;
			} catch (Exception ex) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 205 71 8135540"); 
				throw new BuilderException(
						"Parsing error was found in mapping #{"
								+ content
								+ "}.  Check syntax #{property|(expression), var1=value1, var2=value2, ...} ",
						ex);
			}
		}
	}

}

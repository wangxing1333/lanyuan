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
package org.apache.ibatis.type;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.io.ResolverUtil;

/**
 * @author Clinton Begin
 */
import com.process.ZoaExp;
import com.process.ZoaThreadLocal;
public final class TypeHandlerRegistry {

  private static final Map<Class<?>, Class<?>> reversePrimitiveMap = new HashMap<Class<?>, Class<?>>() {
    private static final long serialVersionUID = 1L;
    {
      ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 189 0 8135540"); put(Byte.class, byte.class);
      put(Short.class, short.class);
      put(Integer.class, int.class);
      put(Long.class, long.class);
      put(Float.class, float.class);
      put(Double.class, double.class);
      put(Boolean.class, boolean.class);
      put(Character.class, char.class);
    }
  };

  private final Map<JdbcType, TypeHandler<?>> JDBC_TYPE_HANDLER_MAP = new EnumMap<JdbcType, TypeHandler<?>>(JdbcType.class);
  private final Map<Type, Map<JdbcType, TypeHandler<?>>> TYPE_HANDLER_MAP = new HashMap<Type, Map<JdbcType, TypeHandler<?>>>();
  private final TypeHandler<Object> UNKNOWN_TYPE_HANDLER = new UnknownTypeHandler(this);
  private final Map<Class<?>, TypeHandler<?>> ALL_TYPE_HANDLERS_MAP = new HashMap<Class<?>, TypeHandler<?>>();

  public TypeHandlerRegistry() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 189 1 8135540"); 
    register(Boolean.class, new BooleanTypeHandler());
    register(boolean.class, new BooleanTypeHandler());
    register(JdbcType.BOOLEAN, new BooleanTypeHandler());
    register(JdbcType.BIT, new BooleanTypeHandler());

    register(Byte.class, new ByteTypeHandler());
    register(byte.class, new ByteTypeHandler());
    register(JdbcType.TINYINT, new ByteTypeHandler());

    register(Short.class, new ShortTypeHandler());
    register(short.class, new ShortTypeHandler());
    register(JdbcType.SMALLINT, new ShortTypeHandler());

    register(Integer.class, new IntegerTypeHandler());
    register(int.class, new IntegerTypeHandler());
    register(JdbcType.INTEGER, new IntegerTypeHandler());

    register(Long.class, new LongTypeHandler());
    register(long.class, new LongTypeHandler());

    register(Float.class, new FloatTypeHandler());
    register(float.class, new FloatTypeHandler());
    register(JdbcType.FLOAT, new FloatTypeHandler());

    register(Double.class, new DoubleTypeHandler());
    register(double.class, new DoubleTypeHandler());
    register(JdbcType.DOUBLE, new DoubleTypeHandler());

    register(String.class, new StringTypeHandler());
    register(String.class, JdbcType.CHAR, new StringTypeHandler());
    register(String.class, JdbcType.CLOB, new ClobTypeHandler());
    register(String.class, JdbcType.VARCHAR, new StringTypeHandler());
    register(String.class, JdbcType.LONGVARCHAR, new ClobTypeHandler());
    register(String.class, JdbcType.NVARCHAR, new NStringTypeHandler());
    register(String.class, JdbcType.NCHAR, new NStringTypeHandler());
    register(String.class, JdbcType.NCLOB, new NClobTypeHandler());
    register(JdbcType.CHAR, new StringTypeHandler());
    register(JdbcType.VARCHAR, new StringTypeHandler());
    register(JdbcType.CLOB, new ClobTypeHandler());
    register(JdbcType.LONGVARCHAR, new ClobTypeHandler());
    register(JdbcType.NVARCHAR, new NStringTypeHandler());
    register(JdbcType.NCHAR, new NStringTypeHandler());
    register(JdbcType.NCLOB, new NClobTypeHandler());

    register(Object.class, JdbcType.ARRAY, new ArrayTypeHandler());
    register(JdbcType.ARRAY, new ArrayTypeHandler());

    register(BigInteger.class, new BigIntegerTypeHandler());
    register(JdbcType.BIGINT, new LongTypeHandler());

    register(BigDecimal.class, new BigDecimalTypeHandler());
    register(JdbcType.REAL, new BigDecimalTypeHandler());
    register(JdbcType.DECIMAL, new BigDecimalTypeHandler());
    register(JdbcType.NUMERIC, new BigDecimalTypeHandler());

    register(Byte[].class, new ByteObjectArrayTypeHandler());
    register(Byte[].class, JdbcType.BLOB, new BlobByteObjectArrayTypeHandler());
    register(Byte[].class, JdbcType.LONGVARBINARY, new BlobByteObjectArrayTypeHandler());
    register(byte[].class, new ByteArrayTypeHandler());
    register(byte[].class, JdbcType.BLOB, new BlobTypeHandler());
    register(byte[].class, JdbcType.LONGVARBINARY, new BlobTypeHandler());
    register(JdbcType.LONGVARBINARY, new BlobTypeHandler());
    register(JdbcType.BLOB, new BlobTypeHandler());

    register(Object.class, UNKNOWN_TYPE_HANDLER);
    register(Object.class, JdbcType.OTHER, UNKNOWN_TYPE_HANDLER);
    register(JdbcType.OTHER, UNKNOWN_TYPE_HANDLER);

    register(Date.class, new DateTypeHandler());
    register(Date.class, JdbcType.DATE, new DateOnlyTypeHandler());
    register(Date.class, JdbcType.TIME, new TimeOnlyTypeHandler());
    register(JdbcType.TIMESTAMP, new DateTypeHandler());
    register(JdbcType.DATE, new DateOnlyTypeHandler());
    register(JdbcType.TIME, new TimeOnlyTypeHandler());

    register(java.sql.Date.class, new SqlDateTypeHandler());
    register(java.sql.Time.class, new SqlTimeTypeHandler());
    register(java.sql.Timestamp.class, new SqlTimestampTypeHandler());

    // issue #273
    register(Character.class, new CharacterTypeHandler());
    register(char.class, new CharacterTypeHandler());
  }

  public boolean hasTypeHandler(Class<?> javaType) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 189 2 8135540"); 
    return hasTypeHandler(javaType, null);
  }

  public boolean hasTypeHandler(TypeReference<?> javaTypeReference) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 189 3 8135540"); 
    return hasTypeHandler(javaTypeReference, null);
  }

  public boolean hasTypeHandler(Class<?> javaType, JdbcType jdbcType) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 189 4 8135540"); 
    return javaType != null && getTypeHandler((Type) javaType, jdbcType) != null;
  }

  public boolean hasTypeHandler(TypeReference<?> javaTypeReference, JdbcType jdbcType) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 189 5 8135540"); 
    return javaTypeReference != null && getTypeHandler(javaTypeReference, jdbcType) != null;
  }

  public TypeHandler<?> getMappingTypeHandler(Class<? extends TypeHandler<?>> handlerType) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 189 6 8135540"); 
    return ALL_TYPE_HANDLERS_MAP.get(handlerType);
  }

  public <T> TypeHandler<T> getTypeHandler(Class<T> type) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 189 7 8135540"); 
    return getTypeHandler((Type) type, null);
  }

  public <T> TypeHandler<T> getTypeHandler(TypeReference<T> javaTypeReference) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 189 8 8135540"); 
    return getTypeHandler(javaTypeReference, null);
  }

  public TypeHandler<?> getTypeHandler(JdbcType jdbcType) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 189 9 8135540"); 
    return JDBC_TYPE_HANDLER_MAP.get(jdbcType);
  }

  public <T> TypeHandler<T> getTypeHandler(Class<T> type, JdbcType jdbcType) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 189 10 8135540"); 
    return getTypeHandler((Type) type, jdbcType);
  }

  public <T> TypeHandler<T> getTypeHandler(TypeReference<T> javaTypeReference, JdbcType jdbcType) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 189 11 8135540"); 
    return getTypeHandler(javaTypeReference.getRawType(), jdbcType);
  }

  private <T> TypeHandler<T> getTypeHandler(Type type, JdbcType jdbcType) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 189 12 8135540"); 
    Map<JdbcType, TypeHandler<?>> jdbcHandlerMap = TYPE_HANDLER_MAP.get(type);
    TypeHandler<?> handler = null;
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 189 13 8135540")|| true) && (jdbcHandlerMap != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 189 0 0 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 189 0 0 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 189 14 8135540"); {
      handler = jdbcHandlerMap.get(jdbcType);
      if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 189 15 8135540")|| true) && (handler == null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 189 1 1 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 189 1 1 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 189 16 8135540"); {
        handler = jdbcHandlerMap.get(null);
      } }
    } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 189 18 8135540");
    int zoa_cond_n19_0 = 2;
int zoa_cond_n19_1 = 2;
int zoa_cond_n19_2 = 2;
int zoa_cond_n19_3 = 2;
//zoa_cond_n19_0#handler == null$zoa_cond_n19_1#type != null$zoa_cond_n19_2#type instanceof Class$zoa_cond_n19_3#Enum.class.isAssignableFrom((Class<?>)type)
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 189 19 8135540")|| true) && ((handler == null?(zoa_cond_n19_0 != (zoa_cond_n19_0 = 1)):(zoa_cond_n19_0 == (zoa_cond_n19_0 = 0))) && (type != null?(zoa_cond_n19_1 != (zoa_cond_n19_1 = 1)):(zoa_cond_n19_1 == (zoa_cond_n19_1 = 0))) && (type instanceof Class?(zoa_cond_n19_2 != (zoa_cond_n19_2 = 1)):(zoa_cond_n19_2 == (zoa_cond_n19_2 = 0))) && (Enum.class.isAssignableFrom((Class<?>) type)?(zoa_cond_n19_3 != (zoa_cond_n19_3 = 1)):(zoa_cond_n19_3 == (zoa_cond_n19_3 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 189 6 2 1 4 ","8135540",true,zoa_cond_n19_0,zoa_cond_n19_1,zoa_cond_n19_2,zoa_cond_n19_3) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 189 6 2 0 4 ","8135540",false,zoa_cond_n19_0,zoa_cond_n19_1,zoa_cond_n19_2,zoa_cond_n19_3) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 189 20 8135540"); {
      handler = new EnumTypeHandler((Class<?>) type);
    } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 189 21 8135540");
    @SuppressWarnings("unchecked")
    // type drives generics here
    TypeHandler<T> returned = (TypeHandler<T>) handler;
    return returned;
  }

  public TypeHandler<Object> getUnknownTypeHandler() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 189 22 8135540"); 
    return UNKNOWN_TYPE_HANDLER;
  }

  public void register(JdbcType jdbcType, TypeHandler<?> handler) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 189 23 8135540"); 
    JDBC_TYPE_HANDLER_MAP.put(jdbcType, handler);
  }

  //
  // REGISTER INSTANCE
  //

  // Only handler

  @SuppressWarnings("unchecked")
  public <T> void register(TypeHandler<T> typeHandler) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 189 24 8135540"); 
    boolean mappedTypeFound = false;
    MappedTypes mappedTypes = typeHandler.getClass().getAnnotation(MappedTypes.class);
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 189 25 8135540")|| true) && (mappedTypes != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 189 7 3 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 189 7 3 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 189 26 8135540"); {
      for (Class<?> handledType : /* TRUE */mappedTypes.value()){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 189 27 8135540");ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 189 28 8135540"); {
        register(handledType, typeHandler);
        mappedTypeFound = true;
      }}
    } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 189 30 8135540");
    // @since 3.1.0 - try to auto-discover the mapped type
    int zoa_cond_n31_0 = 2;
int zoa_cond_n31_1 = 2;
//zoa_cond_n31_0#mappedTypeFound$zoa_cond_n31_1#typeHandler instanceof TypeReference
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 189 31 8135540")|| true) && (!(mappedTypeFound?(zoa_cond_n31_0 != (zoa_cond_n31_0 = 1)):(zoa_cond_n31_0 == (zoa_cond_n31_0 = 0))) && (typeHandler instanceof TypeReference?(zoa_cond_n31_1 != (zoa_cond_n31_1 = 1)):(zoa_cond_n31_1 == (zoa_cond_n31_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 189 10 4 1 2 ","8135540",true,zoa_cond_n31_0,zoa_cond_n31_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 189 10 4 0 2 ","8135540",false,zoa_cond_n31_0,zoa_cond_n31_1) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 189 32 8135540"); {
      try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 189 33 8135540"); 
        TypeReference<T> typeReference = (TypeReference<T>) typeHandler;
        register(typeReference.getRawType(), typeHandler);
        mappedTypeFound = true;
      } catch (Throwable t) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 189 34 8135540"); 
        // maybe users define the TypeReference with a different type and are not assignable, so just ignore it
      }
    } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 189 36 8135540");
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 189 37 8135540")|| true) && (!mappedTypeFound? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 189 11 5 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 189 11 5 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 189 38 8135540"); {
      register((Class<T>) null, typeHandler);
    } }
  }

  // java type + handler

  public <T> void register(Class<T> javaType, TypeHandler<? extends T> typeHandler) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 189 40 8135540"); 
    register((Type) javaType, typeHandler);
  }

  private <T> void register(Type javaType, TypeHandler<? extends T> typeHandler) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 189 41 8135540"); 
    MappedJdbcTypes mappedJdbcTypes = typeHandler.getClass().getAnnotation(MappedJdbcTypes.class);
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 189 42 8135540")|| true) && (mappedJdbcTypes != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 189 12 6 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 189 12 6 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 189 43 8135540"); {
      for (JdbcType handledJdbcType : /* TRUE */mappedJdbcTypes.value()){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 189 44 8135540");ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 189 45 8135540"); {
        register(javaType, handledJdbcType, typeHandler);
      }}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 189 46 8135540");
      if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 189 47 8135540")|| true) && (mappedJdbcTypes.includeNullJdbcType()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 189 13 7 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 189 13 7 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 189 48 8135540"); {
        register(javaType, null, typeHandler);
      } }
    } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 189 50 8135540");  {
      register(javaType, null, typeHandler);
    } }
  }

  public <T> void register(TypeReference<T> javaTypeReference, TypeHandler<? extends T> handler) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 189 52 8135540"); 
    register(javaTypeReference.getRawType(), handler);
  }

  // java type + jdbc type + handler

  public <T> void register(Class<T> type, JdbcType jdbcType, TypeHandler<? extends T> handler) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 189 53 8135540"); 
    register((Type) type, jdbcType, handler);
  }

  private void register(Type javaType, JdbcType jdbcType, TypeHandler<?> handler) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 189 54 8135540"); 
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 189 55 8135540")|| true) && (javaType != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 189 14 8 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 189 14 8 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 189 56 8135540"); {
      Map<JdbcType, TypeHandler<?>> map = TYPE_HANDLER_MAP.get(javaType);
      if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 189 57 8135540")|| true) && (map == null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 189 15 9 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 189 15 9 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 189 58 8135540"); {
        map = new HashMap<JdbcType, TypeHandler<?>>();
        TYPE_HANDLER_MAP.put(javaType, map);
      } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 189 59 8135540");
      map.put(jdbcType, handler);
      if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 189 60 8135540")|| true) && (reversePrimitiveMap.containsKey(javaType)? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 189 16 10 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 189 16 10 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 189 61 8135540"); {
        register(reversePrimitiveMap.get(javaType), jdbcType, handler);
      } }
    } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 189 63 8135540");
    ALL_TYPE_HANDLERS_MAP.put(handler.getClass(), handler);
  }

  //
  // REGISTER CLASS
  //

  // Only handler type

  public void register(Class<?> typeHandlerClass) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 189 64 8135540"); 
    boolean mappedTypeFound = false;
    MappedTypes mappedTypes = typeHandlerClass.getAnnotation(MappedTypes.class);
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 189 65 8135540")|| true) && (mappedTypes != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 189 17 11 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 189 17 11 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 189 66 8135540"); {
      for (Class<?> javaTypeClass : /* TRUE */mappedTypes.value()){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 189 67 8135540");ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 189 68 8135540"); {
        register(javaTypeClass, typeHandlerClass);
        mappedTypeFound = true;
      }}
    } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 189 70 8135540");
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 189 71 8135540")|| true) && (!mappedTypeFound? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 189 18 12 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 189 18 12 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 189 72 8135540"); {
      register(getInstance(null, typeHandlerClass));
    } }
  }

  // java type + handler type

  public void register(Class<?> javaTypeClass, Class<?> typeHandlerClass) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 189 74 8135540"); 
    register(javaTypeClass, getInstance(javaTypeClass, typeHandlerClass));
  }

  // java type + jdbc type + handler type

  public void register(Class<?> javaTypeClass, JdbcType jdbcType, Class<?> typeHandlerClass) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 189 75 8135540"); 
    register(javaTypeClass, jdbcType, getInstance(javaTypeClass, typeHandlerClass));
  }

  // Construct a handler (used also from Builders)

  @SuppressWarnings("unchecked")
  public <T> TypeHandler<T> getInstance(Class<?> javaTypeClass, Class<?> typeHandlerClass) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 189 76 8135540"); 
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 189 77 8135540")|| true) && (javaTypeClass != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 189 19 13 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 189 19 13 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 189 78 8135540"); {
      try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 189 79 8135540"); 
        Constructor<?> c = typeHandlerClass.getConstructor(Class.class);
        return (TypeHandler<T>) c.newInstance(javaTypeClass);
      } catch (NoSuchMethodException ignored) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 189 80 8135540"); 
        // ignored
      } catch (Exception e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 189 81 8135540"); 
        throw new TypeException("Failed invoking constructor for handler " + typeHandlerClass, e);
      }
    } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 189 83 8135540");
    try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 189 84 8135540"); 
      Constructor<?> c = typeHandlerClass.getConstructor();
      return (TypeHandler<T>) c.newInstance();
    } catch (Exception e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 189 85 8135540"); 
      throw new TypeException("Unable to find a usable constructor for " + typeHandlerClass, e);
    }
  }

  // scan

  public void register(String packageName) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 189 87 8135540"); 
    ResolverUtil<Class<?>> resolverUtil = new ResolverUtil<Class<?>>();
    resolverUtil.find(new ResolverUtil.IsA(TypeHandler.class), packageName);
    Set<Class<? extends Class<?>>> handlerSet = resolverUtil.getClasses();
    for (Class<?> type : /* TRUE */handlerSet){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 189 88 8135540");ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 189 89 8135540"); {
      //Ignore inner classes and interfaces (including package-info.java) and abstract classes
      int zoa_cond_n90_0 = 2;
int zoa_cond_n90_1 = 2;
int zoa_cond_n90_2 = 2;
//zoa_cond_n90_0#type.isAnonymousClass()$zoa_cond_n90_1#type.isInterface()$zoa_cond_n90_2#Modifier.isAbstract(type.getModifiers())
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 189 90 8135540")|| true) && (!(type.isAnonymousClass()?(zoa_cond_n90_0 != (zoa_cond_n90_0 = 1)):(zoa_cond_n90_0 == (zoa_cond_n90_0 = 0))) && !(type.isInterface()?(zoa_cond_n90_1 != (zoa_cond_n90_1 = 1)):(zoa_cond_n90_1 == (zoa_cond_n90_1 = 0))) && !(Modifier.isAbstract(type.getModifiers())?(zoa_cond_n90_2 != (zoa_cond_n90_2 = 1)):(zoa_cond_n90_2 == (zoa_cond_n90_2 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 189 23 14 1 3 ","8135540",true,zoa_cond_n90_0,zoa_cond_n90_1,zoa_cond_n90_2) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 189 23 14 0 3 ","8135540",false,zoa_cond_n90_0,zoa_cond_n90_1,zoa_cond_n90_2) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 189 91 8135540"); {
        register(type);
      } }
    }}
  }
  
  // get information
  
  /**
   * @since 3.2.2
   */
  public Collection<TypeHandler<?>> getTypeHandlers() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 189 94 8135540"); 
    return Collections.unmodifiableCollection(ALL_TYPE_HANDLERS_MAP.values());
  }
  
}

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

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.ibatis.cache.Cache;
import org.apache.ibatis.cache.CacheException;
import org.apache.ibatis.cache.decorators.LoggingCache;
import org.apache.ibatis.cache.decorators.LruCache;
import org.apache.ibatis.cache.decorators.ScheduledCache;
import org.apache.ibatis.cache.decorators.SerializedCache;
import org.apache.ibatis.cache.decorators.SynchronizedCache;
import org.apache.ibatis.cache.impl.PerpetualCache;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;

/**
 * @author Clinton Begin
 */
import com.process.ZoaExp;
import com.process.ZoaThreadLocal;
public class CacheBuilder {
  private String id;
  private Class<? extends Cache> implementation;
  private List<Class<? extends Cache>> decorators;
  private Integer size;
  private Long clearInterval;
  private boolean readWrite;
  private Properties properties;

  public CacheBuilder(String id) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 166 0 8135540"); 
    this.id = id;
    this.decorators = new ArrayList<Class<? extends Cache>>();
  }

  public CacheBuilder implementation(Class<? extends Cache> implementation) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 166 1 8135540"); 
    this.implementation = implementation;
    return this;
  }

  public CacheBuilder addDecorator(Class<? extends Cache> decorator) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 166 2 8135540"); 
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 166 3 8135540")|| true) && (decorator != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 166 0 0 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 166 0 0 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 166 4 8135540"); {
      this.decorators.add(decorator);
    } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 166 5 8135540");
    return this;
  }

  public CacheBuilder size(Integer size) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 166 6 8135540"); 
    this.size = size;
    return this;
  }

  public CacheBuilder clearInterval(Long clearInterval) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 166 7 8135540"); 
    this.clearInterval = clearInterval;
    return this;
  }

  public CacheBuilder readWrite(boolean readWrite) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 166 8 8135540"); 
    this.readWrite = readWrite;
    return this;
  }

  public CacheBuilder properties(Properties properties) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 166 9 8135540"); 
    this.properties = properties;
    return this;
  }

  public Cache build() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 166 10 8135540"); 
    setDefaultImplementations();
    Cache cache = newBaseCacheInstance(implementation, id);
    setCacheProperties(cache);
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 166 11 8135540")|| true) && (PerpetualCache.class.equals(cache.getClass())? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 166 1 1 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 166 1 1 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 166 12 8135540"); { // issue #352, do not apply decorators to custom caches
      for (Class<? extends Cache> decorator : /* TRUE */decorators){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 166 13 8135540");ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 166 14 8135540"); {
        cache = newCacheDecoratorInstance(decorator, cache);
        setCacheProperties(cache);
      }}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 166 15 8135540");
      cache = setStandardDecorators(cache);
    } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 166 16 8135540");  if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 166 17 8135540")|| true) && (!LoggingCache.class.isAssignableFrom(cache.getClass())? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 166 2 2 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 166 2 2 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 166 18 8135540"); {
      cache = new LoggingCache(cache);
    } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 166 19 8135540"); }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 166 20 8135540");
    return cache;
  }

  private void setDefaultImplementations() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 166 21 8135540"); 
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 166 22 8135540")|| true) && (implementation == null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 166 3 3 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 166 3 3 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 166 23 8135540"); {
      implementation = PerpetualCache.class;
      if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 166 24 8135540")|| true) && (decorators.size() == 0? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 166 4 4 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 166 4 4 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 166 25 8135540"); {
        decorators.add(LruCache.class);
      } }
    } }
  }

  private Cache setStandardDecorators(Cache cache) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 166 28 8135540"); 
    try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 166 29 8135540"); 
      MetaObject metaCache = SystemMetaObject.forObject(cache);
      int zoa_cond_n30_0 = 2;
int zoa_cond_n30_1 = 2;
//zoa_cond_n30_0#size != null$zoa_cond_n30_1#metaCache.hasSetter("size")
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 166 30 8135540")|| true) && ((size != null?(zoa_cond_n30_0 != (zoa_cond_n30_0 = 1)):(zoa_cond_n30_0 == (zoa_cond_n30_0 = 0))) && (metaCache.hasSetter("size")?(zoa_cond_n30_1 != (zoa_cond_n30_1 = 1)):(zoa_cond_n30_1 == (zoa_cond_n30_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 166 7 5 1 2 ","8135540",true,zoa_cond_n30_0,zoa_cond_n30_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 166 7 5 0 2 ","8135540",false,zoa_cond_n30_0,zoa_cond_n30_1) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 166 31 8135540"); {
        metaCache.setValue("size", size);
      } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 166 32 8135540");
      if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 166 33 8135540")|| true) && (clearInterval != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 166 8 6 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 166 8 6 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 166 34 8135540"); {
        cache = new ScheduledCache(cache);
        ((ScheduledCache) cache).setClearInterval(clearInterval);
      } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 166 35 8135540");
      if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 166 36 8135540")|| true) && (readWrite? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 166 9 7 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 166 9 7 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 166 37 8135540"); {
        cache = new SerializedCache(cache);
      } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 166 38 8135540");
      cache = new LoggingCache(cache);
      cache = new SynchronizedCache(cache);
      return cache;
    } catch (Exception e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 166 39 8135540"); 
      throw new CacheException("Error building standard cache decorators.  Cause: " + e, e);
    }
  }

  private void setCacheProperties(Cache cache) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 166 41 8135540"); 
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 166 42 8135540")|| true) && (properties != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 166 10 8 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 166 10 8 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 166 43 8135540"); {
      MetaObject metaCache = SystemMetaObject.forObject(cache);
      for (Map.Entry<Object, Object> entry : /* TRUE */properties.entrySet()){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 166 44 8135540");ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 166 45 8135540"); {
        String name = (String) entry.getKey();
        String value = (String) entry.getValue();
        if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 166 46 8135540")|| true) && (metaCache.hasSetter(name)? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 166 11 9 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 166 11 9 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 166 47 8135540"); {
          Class<?> type = metaCache.getSetterType(name);
          if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 166 48 8135540")|| true) && (String.class == type? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 166 12 10 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 166 12 10 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 166 49 8135540"); {
            metaCache.setValue(name, value);
          } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 166 50 8135540");  int zoa_cond_n51_0 = 2;
int zoa_cond_n51_1 = 2;
//zoa_cond_n51_0#int.class == type$zoa_cond_n51_1#Integer.class == type
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 166 51 8135540")|| true) && ((int.class == type?(zoa_cond_n51_0 != (zoa_cond_n51_0 = 1)):(zoa_cond_n51_0 == (zoa_cond_n51_0 = 0)))
              || (Integer.class == type?(zoa_cond_n51_1 != (zoa_cond_n51_1 = 1)):(zoa_cond_n51_1 == (zoa_cond_n51_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 166 15 11 1 2 ","8135540",true,zoa_cond_n51_0,zoa_cond_n51_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 166 15 11 0 2 ","8135540",false,zoa_cond_n51_0,zoa_cond_n51_1) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 166 52 8135540"); {
            metaCache.setValue(name, Integer.valueOf(value));
          } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 166 53 8135540");  int zoa_cond_n54_0 = 2;
int zoa_cond_n54_1 = 2;
//zoa_cond_n54_0#long.class == type$zoa_cond_n54_1#Long.class == type
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 166 54 8135540")|| true) && ((long.class == type?(zoa_cond_n54_0 != (zoa_cond_n54_0 = 1)):(zoa_cond_n54_0 == (zoa_cond_n54_0 = 0)))
              || (Long.class == type?(zoa_cond_n54_1 != (zoa_cond_n54_1 = 1)):(zoa_cond_n54_1 == (zoa_cond_n54_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 166 18 12 1 2 ","8135540",true,zoa_cond_n54_0,zoa_cond_n54_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 166 18 12 0 2 ","8135540",false,zoa_cond_n54_0,zoa_cond_n54_1) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 166 55 8135540"); {
            metaCache.setValue(name, Long.valueOf(value));
          } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 166 56 8135540");  int zoa_cond_n57_0 = 2;
int zoa_cond_n57_1 = 2;
//zoa_cond_n57_0#short.class == type$zoa_cond_n57_1#Short.class == type
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 166 57 8135540")|| true) && ((short.class == type?(zoa_cond_n57_0 != (zoa_cond_n57_0 = 1)):(zoa_cond_n57_0 == (zoa_cond_n57_0 = 0)))
              || (Short.class == type?(zoa_cond_n57_1 != (zoa_cond_n57_1 = 1)):(zoa_cond_n57_1 == (zoa_cond_n57_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 166 21 13 1 2 ","8135540",true,zoa_cond_n57_0,zoa_cond_n57_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 166 21 13 0 2 ","8135540",false,zoa_cond_n57_0,zoa_cond_n57_1) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 166 58 8135540"); {
            metaCache.setValue(name, Short.valueOf(value));
          } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 166 59 8135540");  int zoa_cond_n60_0 = 2;
int zoa_cond_n60_1 = 2;
//zoa_cond_n60_0#byte.class == type$zoa_cond_n60_1#Byte.class == type
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 166 60 8135540")|| true) && ((byte.class == type?(zoa_cond_n60_0 != (zoa_cond_n60_0 = 1)):(zoa_cond_n60_0 == (zoa_cond_n60_0 = 0)))
              || (Byte.class == type?(zoa_cond_n60_1 != (zoa_cond_n60_1 = 1)):(zoa_cond_n60_1 == (zoa_cond_n60_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 166 24 14 1 2 ","8135540",true,zoa_cond_n60_0,zoa_cond_n60_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 166 24 14 0 2 ","8135540",false,zoa_cond_n60_0,zoa_cond_n60_1) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 166 61 8135540"); {
            metaCache.setValue(name, Byte.valueOf(value));
          } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 166 62 8135540");  int zoa_cond_n63_0 = 2;
int zoa_cond_n63_1 = 2;
//zoa_cond_n63_0#float.class == type$zoa_cond_n63_1#Float.class == type
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 166 63 8135540")|| true) && ((float.class == type?(zoa_cond_n63_0 != (zoa_cond_n63_0 = 1)):(zoa_cond_n63_0 == (zoa_cond_n63_0 = 0)))
              || (Float.class == type?(zoa_cond_n63_1 != (zoa_cond_n63_1 = 1)):(zoa_cond_n63_1 == (zoa_cond_n63_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 166 27 15 1 2 ","8135540",true,zoa_cond_n63_0,zoa_cond_n63_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 166 27 15 0 2 ","8135540",false,zoa_cond_n63_0,zoa_cond_n63_1) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 166 64 8135540"); {
            metaCache.setValue(name, Float.valueOf(value));
          } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 166 65 8135540");  int zoa_cond_n66_0 = 2;
int zoa_cond_n66_1 = 2;
//zoa_cond_n66_0#boolean.class == type$zoa_cond_n66_1#Boolean.class == type
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 166 66 8135540")|| true) && ((boolean.class == type?(zoa_cond_n66_0 != (zoa_cond_n66_0 = 1)):(zoa_cond_n66_0 == (zoa_cond_n66_0 = 0)))
              || (Boolean.class == type?(zoa_cond_n66_1 != (zoa_cond_n66_1 = 1)):(zoa_cond_n66_1 == (zoa_cond_n66_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 166 30 16 1 2 ","8135540",true,zoa_cond_n66_0,zoa_cond_n66_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 166 30 16 0 2 ","8135540",false,zoa_cond_n66_0,zoa_cond_n66_1) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 166 67 8135540"); {
            metaCache.setValue(name, Boolean.valueOf(value));
          } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 166 68 8135540");  int zoa_cond_n69_0 = 2;
int zoa_cond_n69_1 = 2;
//zoa_cond_n69_0#double.class == type$zoa_cond_n69_1#Double.class == type
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 166 69 8135540")|| true) && ((double.class == type?(zoa_cond_n69_0 != (zoa_cond_n69_0 = 1)):(zoa_cond_n69_0 == (zoa_cond_n69_0 = 0)))
              || (Double.class == type?(zoa_cond_n69_1 != (zoa_cond_n69_1 = 1)):(zoa_cond_n69_1 == (zoa_cond_n69_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 166 33 17 1 2 ","8135540",true,zoa_cond_n69_0,zoa_cond_n69_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 166 33 17 0 2 ","8135540",false,zoa_cond_n69_0,zoa_cond_n69_1) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 166 70 8135540"); {
            metaCache.setValue(name, Double.valueOf(value));
          } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 166 71 8135540");  {
            throw new CacheException("Unsupported property type for cache: '" + name + "' of type " + type);
          } } } } } } } } }
        } }
      }}
    } }
  }

  private Cache newBaseCacheInstance(Class<? extends Cache> cacheClass, String id) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 166 83 8135540"); 
    Constructor<? extends Cache> cacheConstructor = getBaseCacheConstructor(cacheClass);
    try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 166 84 8135540"); 
      return cacheConstructor.newInstance(id);
    } catch (Exception e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 166 85 8135540"); 
      throw new CacheException("Could not instantiate cache implementation (" + cacheClass + "). Cause: " + e, e);
    }
  }

  private Constructor<? extends Cache> getBaseCacheConstructor(Class<? extends Cache> cacheClass) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 166 87 8135540"); 
    try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 166 88 8135540"); 
      return cacheClass.getConstructor(String.class);
    } catch (Exception e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 166 89 8135540"); 
      throw new CacheException("Invalid base cache implementation (" + cacheClass + ").  " +
          "Base cache implementations must have a constructor that takes a String id as a parameter.  Cause: " + e, e);
    }
  }

  private Cache newCacheDecoratorInstance(Class<? extends Cache> cacheClass, Cache base) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 166 91 8135540"); 
    Constructor<? extends Cache> cacheConstructor = getCacheDecoratorConstructor(cacheClass);
    try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 166 92 8135540"); 
      return cacheConstructor.newInstance(base);
    } catch (Exception e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 166 93 8135540"); 
      throw new CacheException("Could not instantiate cache decorator (" + cacheClass + "). Cause: " + e, e);
    }
  }

  private Constructor<? extends Cache> getCacheDecoratorConstructor(Class<? extends Cache> cacheClass) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 166 95 8135540"); 
    try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 166 96 8135540"); 
      return cacheClass.getConstructor(Cache.class);
    } catch (Exception e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 166 97 8135540"); 
      throw new CacheException("Invalid cache decorator (" + cacheClass + ").  " +
          "Cache decorators must have a constructor that takes a Cache instance as a parameter.  Cause: " + e, e);
    }
  }
}

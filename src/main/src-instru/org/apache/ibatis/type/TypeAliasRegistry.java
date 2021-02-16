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

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.io.ResolverUtil;
import org.apache.ibatis.io.Resources;

/**
 * @author Clinton Begin
 */
import com.process.ZoaExp;
import com.process.ZoaThreadLocal;
public class TypeAliasRegistry {

  private final Map<String, Class<?>> TYPE_ALIASES = new HashMap<String, Class<?>>();

  public TypeAliasRegistry() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 158 0 8135540"); 
    registerAlias("string", String.class);

    registerAlias("byte", Byte.class);
    registerAlias("long", Long.class);
    registerAlias("short", Short.class);
    registerAlias("int", Integer.class);
    registerAlias("integer", Integer.class);
    registerAlias("double", Double.class);
    registerAlias("float", Float.class);
    registerAlias("boolean", Boolean.class);

    registerAlias("byte[]", Byte[].class);
    registerAlias("long[]", Long[].class);
    registerAlias("short[]", Short[].class);
    registerAlias("int[]", Integer[].class);
    registerAlias("integer[]", Integer[].class);
    registerAlias("double[]", Double[].class);
    registerAlias("float[]", Float[].class);
    registerAlias("boolean[]", Boolean[].class);

    registerAlias("_byte", byte.class);
    registerAlias("_long", long.class);
    registerAlias("_short", short.class);
    registerAlias("_int", int.class);
    registerAlias("_integer", int.class);
    registerAlias("_double", double.class);
    registerAlias("_float", float.class);
    registerAlias("_boolean", boolean.class);

    registerAlias("_byte[]", byte[].class);
    registerAlias("_long[]", long[].class);
    registerAlias("_short[]", short[].class);
    registerAlias("_int[]", int[].class);
    registerAlias("_integer[]", int[].class);
    registerAlias("_double[]", double[].class);
    registerAlias("_float[]", float[].class);
    registerAlias("_boolean[]", boolean[].class);

    registerAlias("date", Date.class);
    registerAlias("decimal", BigDecimal.class);
    registerAlias("bigdecimal", BigDecimal.class);
    registerAlias("biginteger", BigInteger.class);
    registerAlias("object", Object.class);

    registerAlias("date[]", Date[].class);
    registerAlias("decimal[]", BigDecimal[].class);
    registerAlias("bigdecimal[]", BigDecimal[].class);
    registerAlias("biginteger[]", BigInteger[].class);
    registerAlias("object[]", Object[].class);

    registerAlias("map", Map.class);
    registerAlias("hashmap", HashMap.class);
    registerAlias("list", List.class);
    registerAlias("arraylist", ArrayList.class);
    registerAlias("collection", Collection.class);
    registerAlias("iterator", Iterator.class);

    registerAlias("ResultSet", ResultSet.class);
  }

  @SuppressWarnings("unchecked")
  // throws class cast exception as well if types cannot be assigned
  public <T> Class<T> resolveAlias(String string) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 158 1 8135540"); 
    try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 158 2 8135540"); 
      if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 158 3 8135540")|| true) && (string == null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 158 0 0 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 158 0 0 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 158 4 8135540"); return null; }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 158 5 8135540");
      String key = string.toLowerCase(Locale.ENGLISH); // issue #748
      Class<T> value;
      if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 158 6 8135540")|| true) && (TYPE_ALIASES.containsKey(key)? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 158 1 1 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 158 1 1 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 158 7 8135540"); {
        value = (Class<T>) TYPE_ALIASES.get(key);
      } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 158 8 8135540");  {
        value = (Class<T>) Resources.classForName(string);
      } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 158 9 8135540");
      return value;
    } catch (ClassNotFoundException e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 158 10 8135540"); 
      throw new TypeException("Could not resolve type alias '" + string + "'.  Cause: " + e, e);
    }
  }

  public void registerAliases(String packageName){
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 158 12 8135540"); 
    registerAliases(packageName, Object.class);
  }

  public void registerAliases(String packageName, Class<?> superType){
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 158 13 8135540"); 
    ResolverUtil<Class<?>> resolverUtil = new ResolverUtil<Class<?>>();
    resolverUtil.find(new ResolverUtil.IsA(superType), packageName);
    Set<Class<? extends Class<?>>> typeSet = resolverUtil.getClasses();
    for(Class<?> type : /* TRUE */typeSet){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 158 14 8135540");ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 158 15 8135540");{
      // Ignore inner classes and interfaces (including package-info.java)
      // Skip also inner classes. See issue #6
      int zoa_cond_n16_0 = 2;
int zoa_cond_n16_1 = 2;
int zoa_cond_n16_2 = 2;
//zoa_cond_n16_0#type.isAnonymousClass()$zoa_cond_n16_1#type.isInterface()$zoa_cond_n16_2#type.isMemberClass()
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 158 16 8135540")|| true) && (!(type.isAnonymousClass()?(zoa_cond_n16_0 != (zoa_cond_n16_0 = 1)):(zoa_cond_n16_0 == (zoa_cond_n16_0 = 0))) && !(type.isInterface()?(zoa_cond_n16_1 != (zoa_cond_n16_1 = 1)):(zoa_cond_n16_1 == (zoa_cond_n16_1 = 0))) && !(type.isMemberClass()?(zoa_cond_n16_2 != (zoa_cond_n16_2 = 1)):(zoa_cond_n16_2 == (zoa_cond_n16_2 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 158 5 2 1 3 ","8135540",true,zoa_cond_n16_0,zoa_cond_n16_1,zoa_cond_n16_2) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 158 5 2 0 3 ","8135540",false,zoa_cond_n16_0,zoa_cond_n16_1,zoa_cond_n16_2) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 158 17 8135540"); {
        registerAlias(type);
      } }
    }}
  }

  public void registerAlias(Class<?> type) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 158 20 8135540"); 
    String alias = type.getSimpleName();
    Alias aliasAnnotation = type.getAnnotation(Alias.class);
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 158 21 8135540")|| true) && (aliasAnnotation != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 158 6 3 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 158 6 3 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 158 22 8135540"); {
      alias = aliasAnnotation.value();
    } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 158 23 8135540"); 
    registerAlias(alias, type);
  }

  public void registerAlias(String alias, Class<?> value) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 158 24 8135540"); 
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 158 25 8135540")|| true) && (alias == null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 158 7 4 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 158 7 4 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 158 26 8135540"); throw new TypeException("The parameter alias cannot be null"); }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 158 27 8135540");
    String key = alias.toLowerCase(Locale.ENGLISH); // issue #748
    int zoa_cond_n28_0 = 2;
int zoa_cond_n28_1 = 2;
int zoa_cond_n28_2 = 2;
//zoa_cond_n28_0#TYPE_ALIASES.containsKey(key)$zoa_cond_n28_1#TYPE_ALIASES.get(key) != null$zoa_cond_n28_2#TYPE_ALIASES.get(key).equals(value)
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 158 28 8135540")|| true) && ((TYPE_ALIASES.containsKey(key)?(zoa_cond_n28_0 != (zoa_cond_n28_0 = 1)):(zoa_cond_n28_0 == (zoa_cond_n28_0 = 0))) && (TYPE_ALIASES.get(key) != null?(zoa_cond_n28_1 != (zoa_cond_n28_1 = 1)):(zoa_cond_n28_1 == (zoa_cond_n28_1 = 0))) && !(TYPE_ALIASES.get(key).equals(value)?(zoa_cond_n28_2 != (zoa_cond_n28_2 = 1)):(zoa_cond_n28_2 == (zoa_cond_n28_2 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 158 11 5 1 3 ","8135540",true,zoa_cond_n28_0,zoa_cond_n28_1,zoa_cond_n28_2) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 158 11 5 0 3 ","8135540",false,zoa_cond_n28_0,zoa_cond_n28_1,zoa_cond_n28_2) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 158 29 8135540"); {
      throw new TypeException("The alias '" + alias + "' is already mapped to the value '" + TYPE_ALIASES.get(key).getName() + "'.");
    } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 158 30 8135540");
    TYPE_ALIASES.put(key, value);
  }

  public void registerAlias(String alias, String value) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 158 31 8135540"); 
    try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 158 32 8135540"); 
      registerAlias(alias, Resources.classForName(value));
    } catch (ClassNotFoundException e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 158 33 8135540"); 
      throw new TypeException("Error registering type alias "+alias+" for "+value+". Cause: " + e, e);
    }
  }
  
  /**
   * @since 3.2.2
   */
  public Map<String, Class<?>> getTypeAliases() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 158 35 8135540"); 
    return Collections.unmodifiableMap(TYPE_ALIASES);
  }

}

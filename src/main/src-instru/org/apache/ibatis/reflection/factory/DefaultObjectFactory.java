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
package org.apache.ibatis.reflection.factory;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import org.apache.ibatis.reflection.ReflectionException;

/**
 * @author Clinton Begin
 */
import com.process.ZoaExp;
import com.process.ZoaThreadLocal;
public class DefaultObjectFactory implements ObjectFactory, Serializable {

  private static final long serialVersionUID = -8855120656740914948L;

  public <T> T create(Class<T> type) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 299 0 8135540"); 
    return create(type, null, null);
  }

  public <T> T create(Class<T> type, List<Class<?>> constructorArgTypes, List<Object> constructorArgs) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 299 1 8135540"); 
    Class<?> classToCreate = resolveInterface(type);
    @SuppressWarnings("unchecked")
    // we know types are assignable
    T created = (T) instantiateClass(classToCreate, constructorArgTypes, constructorArgs);
    return created;
  }

  public void setProperties(Properties properties) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 299 2 8135540"); 
    // no props for default
  }

  private <T> T instantiateClass(Class<T> type, List<Class<?>> constructorArgTypes, List<Object> constructorArgs) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 299 3 8135540"); 
    try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 299 4 8135540"); 
      Constructor<T> constructor;
      int zoa_cond_n5_0 = 2;
int zoa_cond_n5_1 = 2;
//zoa_cond_n5_0#constructorArgTypes == null$zoa_cond_n5_1#constructorArgs == null
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 299 5 8135540")|| true) && ((constructorArgTypes == null?(zoa_cond_n5_0 != (zoa_cond_n5_0 = 1)):(zoa_cond_n5_0 == (zoa_cond_n5_0 = 0))) || (constructorArgs == null?(zoa_cond_n5_1 != (zoa_cond_n5_1 = 1)):(zoa_cond_n5_1 == (zoa_cond_n5_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 299 2 0 1 2 ","8135540",true,zoa_cond_n5_0,zoa_cond_n5_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 299 2 0 0 2 ","8135540",false,zoa_cond_n5_0,zoa_cond_n5_1) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 299 6 8135540"); {
        constructor = type.getDeclaredConstructor();
        if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 299 7 8135540")|| true) && (!constructor.isAccessible()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 299 3 1 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 299 3 1 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 299 8 8135540"); {
          constructor.setAccessible(true);
        } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 299 9 8135540");
        return constructor.newInstance();
      } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 299 10 8135540");
      constructor = type.getDeclaredConstructor(constructorArgTypes.toArray(new Class[constructorArgTypes.size()]));
      if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 299 11 8135540")|| true) && (!constructor.isAccessible()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 299 4 2 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 299 4 2 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 299 12 8135540"); {
        constructor.setAccessible(true);
      } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 299 13 8135540");
      return constructor.newInstance(constructorArgs.toArray(new Object[constructorArgs.size()]));
    } catch (Exception e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 299 14 8135540"); 
      StringBuilder argTypes = new StringBuilder();
      if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 299 15 8135540")|| true) && (constructorArgTypes != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 299 5 3 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 299 5 3 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 299 16 8135540"); {
        for (Class<?> argType : /* TRUE */constructorArgTypes){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 299 17 8135540");ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 299 18 8135540"); {
          argTypes.append(argType.getSimpleName());
          argTypes.append(",");
        }}
      } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 299 20 8135540");
      StringBuilder argValues = new StringBuilder();
      if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 299 21 8135540")|| true) && (constructorArgs != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 299 6 4 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 299 6 4 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 299 22 8135540"); {
        for (Object argValue : /* TRUE */constructorArgs){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 299 23 8135540");ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 299 24 8135540"); {
          argValues.append(String.valueOf(argValue));
          argValues.append(",");
        }}
      } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 299 26 8135540");
      throw new ReflectionException("Error instantiating " + type + " with invalid types (" + argTypes + ") or values (" + argValues + "). Cause: " + e, e);
    }
  }

  protected Class<?> resolveInterface(Class<?> type) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 299 28 8135540"); 
    Class<?> classToCreate;
    int zoa_cond_n29_0 = 2;
int zoa_cond_n29_1 = 2;
int zoa_cond_n29_2 = 2;
//zoa_cond_n29_0#type == List.class$zoa_cond_n29_1#type == Collection.class$zoa_cond_n29_2#type == Iterable.class
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 299 29 8135540")|| true) && ((type == List.class?(zoa_cond_n29_0 != (zoa_cond_n29_0 = 1)):(zoa_cond_n29_0 == (zoa_cond_n29_0 = 0))) || (type == Collection.class?(zoa_cond_n29_1 != (zoa_cond_n29_1 = 1)):(zoa_cond_n29_1 == (zoa_cond_n29_1 = 0))) || (type == Iterable.class?(zoa_cond_n29_2 != (zoa_cond_n29_2 = 1)):(zoa_cond_n29_2 == (zoa_cond_n29_2 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 299 10 5 1 3 ","8135540",true,zoa_cond_n29_0,zoa_cond_n29_1,zoa_cond_n29_2) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 299 10 5 0 3 ","8135540",false,zoa_cond_n29_0,zoa_cond_n29_1,zoa_cond_n29_2) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 299 30 8135540"); {
      classToCreate = ArrayList.class;
    } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 299 31 8135540");  if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 299 32 8135540")|| true) && (type == Map.class? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 299 11 6 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 299 11 6 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 299 33 8135540"); {
      classToCreate = HashMap.class;
    } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 299 34 8135540");  if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 299 35 8135540")|| true) && (type == SortedSet.class? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 299 12 7 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 299 12 7 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 299 36 8135540"); { // issue #510 Collections Support
      classToCreate = TreeSet.class;
    } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 299 37 8135540");  if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 299 38 8135540")|| true) && (type == Set.class? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 299 13 8 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 299 13 8 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 299 39 8135540"); {
      classToCreate = HashSet.class;
    } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 299 40 8135540");  {
      classToCreate = type;
    } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 299 41 8135540"); }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 299 42 8135540"); }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 299 43 8135540"); }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 299 44 8135540");
    return classToCreate;
  }

  public <T> boolean isCollection(Class<T> type) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 299 45 8135540"); 
    return Collection.class.isAssignableFrom(type);
  }

}

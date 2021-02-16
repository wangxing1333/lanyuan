// ZOA_CREATED! DO NOT EDIT IT! -- 
/*
 *    Copyright 2009-2011 the original author or authors.
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
package org.apache.ibatis.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;

import org.apache.ibatis.reflection.invoker.GetFieldInvoker;
import org.apache.ibatis.reflection.invoker.Invoker;
import org.apache.ibatis.reflection.invoker.MethodInvoker;
import org.apache.ibatis.reflection.property.PropertyTokenizer;

/**
 * @author Clinton Begin
 */
import com.process.ZoaExp;
import com.process.ZoaThreadLocal;
public class MetaClass {

  private Reflector reflector;

  private MetaClass(Class<?> type) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 284 0 8135540"); 
    this.reflector = Reflector.forClass(type);
  }

  public static MetaClass forClass(Class<?> type) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 284 1 8135540"); 
    return new MetaClass(type);
  }

  public static boolean isClassCacheEnabled() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 284 2 8135540"); 
    return Reflector.isClassCacheEnabled();
  }

  public static void setClassCacheEnabled(boolean classCacheEnabled) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 284 3 8135540"); 
    Reflector.setClassCacheEnabled(classCacheEnabled);
  }

  public MetaClass metaClassForProperty(String name) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 284 4 8135540"); 
    Class<?> propType = reflector.getGetterType(name);
    return MetaClass.forClass(propType);
  }

  public String findProperty(String name) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 284 5 8135540"); 
    StringBuilder prop = buildProperty(name, new StringBuilder());
    return prop.length() > 0 ? prop.toString() : null;
  }

  public String findProperty(String name, boolean useCamelCaseMapping) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 284 6 8135540"); 
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 284 7 8135540")|| true) && (useCamelCaseMapping? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 284 0 0 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 284 0 0 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 284 8 8135540"); {
      name = name.replace("_", "");
    } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 284 9 8135540");
    return findProperty(name);
  }

  public String[] getGetterNames() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 284 10 8135540"); 
    return reflector.getGetablePropertyNames();
  }

  public String[] getSetterNames() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 284 11 8135540"); 
    return reflector.getSetablePropertyNames();
  }

  public Class<?> getSetterType(String name) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 284 12 8135540"); 
    PropertyTokenizer prop = new PropertyTokenizer(name);
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 284 13 8135540")|| true) && (prop.hasNext()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 284 1 1 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 284 1 1 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 284 14 8135540"); {
      MetaClass metaProp = metaClassForProperty(prop.getName());
      return metaProp.getSetterType(prop.getChildren());
    } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 284 15 8135540");  {
      return reflector.getSetterType(prop.getName());
    } }
  }

  public Class<?> getGetterType(String name) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 284 17 8135540"); 
    PropertyTokenizer prop = new PropertyTokenizer(name);
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 284 18 8135540")|| true) && (prop.hasNext()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 284 2 2 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 284 2 2 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 284 19 8135540"); {
      MetaClass metaProp = metaClassForProperty(prop);
      return metaProp.getGetterType(prop.getChildren());
    } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 284 20 8135540");  {
      return getGetterType(prop); // issue #506. Resolve the type inside a Collection Object
    } }
  }

  private MetaClass metaClassForProperty(PropertyTokenizer prop) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 284 22 8135540"); 
    Class<?> propType = getGetterType(prop);
    return MetaClass.forClass(propType);
  }

  private Class<?> getGetterType(PropertyTokenizer prop) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 284 23 8135540"); 
    Class<?> type = reflector.getGetterType(prop.getName());
    int zoa_cond_n24_0 = 2;
int zoa_cond_n24_1 = 2;
//zoa_cond_n24_0#prop.getIndex() != null$zoa_cond_n24_1#Collection.class.isAssignableFrom(type)
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 284 24 8135540")|| true) && ((prop.getIndex() != null?(zoa_cond_n24_0 != (zoa_cond_n24_0 = 1)):(zoa_cond_n24_0 == (zoa_cond_n24_0 = 0))) && (Collection.class.isAssignableFrom(type)?(zoa_cond_n24_1 != (zoa_cond_n24_1 = 1)):(zoa_cond_n24_1 == (zoa_cond_n24_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 284 5 3 1 2 ","8135540",true,zoa_cond_n24_0,zoa_cond_n24_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 284 5 3 0 2 ","8135540",false,zoa_cond_n24_0,zoa_cond_n24_1) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 284 25 8135540"); {
      Type returnType = getGenericGetterType(prop.getName());
      if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 284 26 8135540")|| true) && (returnType instanceof ParameterizedType? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 284 6 4 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 284 6 4 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 284 27 8135540"); {
        Type[] actualTypeArguments = ((ParameterizedType) returnType).getActualTypeArguments();
        int zoa_cond_n28_0 = 2;
int zoa_cond_n28_1 = 2;
//zoa_cond_n28_0#actualTypeArguments != null$zoa_cond_n28_1#actualTypeArguments.length == 1
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 284 28 8135540")|| true) && ((actualTypeArguments != null?(zoa_cond_n28_0 != (zoa_cond_n28_0 = 1)):(zoa_cond_n28_0 == (zoa_cond_n28_0 = 0))) && (actualTypeArguments.length == 1?(zoa_cond_n28_1 != (zoa_cond_n28_1 = 1)):(zoa_cond_n28_1 == (zoa_cond_n28_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 284 9 5 1 2 ","8135540",true,zoa_cond_n28_0,zoa_cond_n28_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 284 9 5 0 2 ","8135540",false,zoa_cond_n28_0,zoa_cond_n28_1) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 284 29 8135540"); {
          returnType = actualTypeArguments[0];
          if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 284 30 8135540")|| true) && (returnType instanceof Class? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 284 10 6 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 284 10 6 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 284 31 8135540"); {
            type = (Class<?>) returnType;
          } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 284 32 8135540");  if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 284 33 8135540")|| true) && (returnType instanceof ParameterizedType? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 284 11 7 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 284 11 7 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 284 34 8135540"); {
            type = (Class<?>) ((ParameterizedType) returnType).getRawType();
          } } }
        } }
      } }
    } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 284 39 8135540");
    return type;
  }

  private Type getGenericGetterType(String propertyName) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 284 40 8135540"); 
    try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 284 41 8135540"); 
      Invoker invoker = reflector.getGetInvoker(propertyName);
      if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 284 42 8135540")|| true) && (invoker instanceof MethodInvoker? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 284 12 8 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 284 12 8 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 284 43 8135540"); {
        Field _method = MethodInvoker.class.getDeclaredField("method");
        _method.setAccessible(true);
        Method method = (Method) _method.get(invoker);
        return method.getGenericReturnType();
      } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 284 44 8135540");  if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 284 45 8135540")|| true) && (invoker instanceof GetFieldInvoker? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 284 13 9 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 284 13 9 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 284 46 8135540"); {
        Field _field = GetFieldInvoker.class.getDeclaredField("field");
        _field.setAccessible(true);
        Field field = (Field) _field.get(invoker);
        return field.getGenericType();
      } } }
    } catch (NoSuchFieldException e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 284 49 8135540"); 
    } catch (IllegalAccessException e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 284 50 8135540"); 
    }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 284 51 8135540");
    return null;
  }

  public boolean hasSetter(String name) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 284 52 8135540"); 
    PropertyTokenizer prop = new PropertyTokenizer(name);
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 284 53 8135540")|| true) && (prop.hasNext()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 284 14 10 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 284 14 10 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 284 54 8135540"); {
      if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 284 55 8135540")|| true) && (reflector.hasSetter(prop.getName())? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 284 15 11 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 284 15 11 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 284 56 8135540"); {
        MetaClass metaProp = metaClassForProperty(prop.getName());
        return metaProp.hasSetter(prop.getChildren());
      } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 284 57 8135540");  {
        return false;
      } }
    } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 284 59 8135540");  {
      return reflector.hasSetter(prop.getName());
    } }
  }

  public boolean hasGetter(String name) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 284 61 8135540"); 
    PropertyTokenizer prop = new PropertyTokenizer(name);
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 284 62 8135540")|| true) && (prop.hasNext()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 284 16 12 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 284 16 12 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 284 63 8135540"); {
      if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 284 64 8135540")|| true) && (reflector.hasGetter(prop.getName())? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 284 17 13 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 284 17 13 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 284 65 8135540"); {
        MetaClass metaProp = metaClassForProperty(prop);
        return metaProp.hasGetter(prop.getChildren());
      } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 284 66 8135540");  {
        return false;
      } }
    } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 284 68 8135540");  {
      return reflector.hasGetter(prop.getName());
    } }
  }

  public Invoker getGetInvoker(String name) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 284 70 8135540"); 
    return reflector.getGetInvoker(name);
  }

  public Invoker getSetInvoker(String name) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 284 71 8135540"); 
    return reflector.getSetInvoker(name);
  }

  private StringBuilder buildProperty(String name, StringBuilder builder) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 284 72 8135540"); 
    PropertyTokenizer prop = new PropertyTokenizer(name);
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 284 73 8135540")|| true) && (prop.hasNext()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 284 18 14 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 284 18 14 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 284 74 8135540"); {
      String propertyName = reflector.findPropertyName(prop.getName());
      if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 284 75 8135540")|| true) && (propertyName != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 284 19 15 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 284 19 15 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 284 76 8135540"); {
        builder.append(propertyName);
        builder.append(".");
        MetaClass metaProp = metaClassForProperty(propertyName);
        metaProp.buildProperty(prop.getChildren(), builder);
      } }
    } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 284 78 8135540");  {
      String propertyName = reflector.findPropertyName(name);
      if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 284 79 8135540")|| true) && (propertyName != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 284 20 16 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 284 20 16 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 284 80 8135540"); {
        builder.append(propertyName);
      } }
    } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 284 82 8135540");
    return builder;
  }

}

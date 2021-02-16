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
package org.apache.ibatis.reflection.wrapper;

import java.util.List;

import org.apache.ibatis.reflection.ExceptionUtil;
import org.apache.ibatis.reflection.MetaClass;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.ReflectionException;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.apache.ibatis.reflection.factory.ObjectFactory;
import org.apache.ibatis.reflection.invoker.Invoker;
import org.apache.ibatis.reflection.property.PropertyTokenizer;

/**
 * @author Clinton Begin
 */
import com.process.ZoaExp;
import com.process.ZoaThreadLocal;
public class BeanWrapper extends BaseWrapper {

  private Object object;
  private MetaClass metaClass;

  public BeanWrapper(MetaObject metaObject, Object object) {
    super(metaObject);
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 282 0 8135540"); 
    this.object = object;
    this.metaClass = MetaClass.forClass(object.getClass());
  }

  public Object get(PropertyTokenizer prop) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 282 1 8135540"); 
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 282 2 8135540")|| true) && (prop.getIndex() != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 282 0 0 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 282 0 0 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 282 3 8135540"); {
      Object collection = resolveCollection(prop, object);
      return getCollectionValue(prop, collection);
    } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 282 4 8135540");  {
      return getBeanProperty(prop, object);
    } }
  }

  public void set(PropertyTokenizer prop, Object value) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 282 6 8135540"); 
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 282 7 8135540")|| true) && (prop.getIndex() != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 282 1 1 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 282 1 1 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 282 8 8135540"); {
      Object collection = resolveCollection(prop, object);
      setCollectionValue(prop, collection, value);
    } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 282 9 8135540");  {
      setBeanProperty(prop, object, value);
    } }
  }

  public String findProperty(String name, boolean useCamelCaseMapping) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 282 11 8135540"); 
    return metaClass.findProperty(name, useCamelCaseMapping);
  }

  public String[] getGetterNames() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 282 12 8135540"); 
    return metaClass.getGetterNames();
  }

  public String[] getSetterNames() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 282 13 8135540"); 
    return metaClass.getSetterNames();
  }

  public Class<?> getSetterType(String name) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 282 14 8135540"); 
    PropertyTokenizer prop = new PropertyTokenizer(name);
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 282 15 8135540")|| true) && (prop.hasNext()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 282 2 2 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 282 2 2 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 282 16 8135540"); {
      MetaObject metaValue = metaObject.metaObjectForProperty(prop.getIndexedName());
      if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 282 17 8135540")|| true) && (metaValue == SystemMetaObject.NULL_META_OBJECT? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 282 3 3 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 282 3 3 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 282 18 8135540"); {
        return metaClass.getSetterType(name);
      } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 282 19 8135540");  {
        return metaValue.getSetterType(prop.getChildren());
      } }
    } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 282 21 8135540");  {
      return metaClass.getSetterType(name);
    } }
  }

  public Class<?> getGetterType(String name) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 282 23 8135540"); 
    PropertyTokenizer prop = new PropertyTokenizer(name);
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 282 24 8135540")|| true) && (prop.hasNext()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 282 4 4 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 282 4 4 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 282 25 8135540"); {
      MetaObject metaValue = metaObject.metaObjectForProperty(prop.getIndexedName());
      if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 282 26 8135540")|| true) && (metaValue == SystemMetaObject.NULL_META_OBJECT? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 282 5 5 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 282 5 5 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 282 27 8135540"); {
        return metaClass.getGetterType(name);
      } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 282 28 8135540");  {
        return metaValue.getGetterType(prop.getChildren());
      } }
    } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 282 30 8135540");  {
      return metaClass.getGetterType(name);
    } }
  }

  public boolean hasSetter(String name) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 282 32 8135540"); 
    PropertyTokenizer prop = new PropertyTokenizer(name);
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 282 33 8135540")|| true) && (prop.hasNext()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 282 6 6 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 282 6 6 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 282 34 8135540"); {
      if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 282 35 8135540")|| true) && (metaClass.hasSetter(prop.getIndexedName())? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 282 7 7 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 282 7 7 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 282 36 8135540"); {
        MetaObject metaValue = metaObject.metaObjectForProperty(prop.getIndexedName());
        if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 282 37 8135540")|| true) && (metaValue == SystemMetaObject.NULL_META_OBJECT? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 282 8 8 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 282 8 8 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 282 38 8135540"); {
          return metaClass.hasSetter(name);
        } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 282 39 8135540");  {
          return metaValue.hasSetter(prop.getChildren());
        } }
      } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 282 41 8135540");  {
        return false;
      } }
    } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 282 43 8135540");  {
      return metaClass.hasSetter(name);
    } }
  }

  public boolean hasGetter(String name) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 282 45 8135540"); 
    PropertyTokenizer prop = new PropertyTokenizer(name);
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 282 46 8135540")|| true) && (prop.hasNext()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 282 9 9 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 282 9 9 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 282 47 8135540"); {
      if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 282 48 8135540")|| true) && (metaClass.hasGetter(prop.getIndexedName())? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 282 10 10 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 282 10 10 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 282 49 8135540"); {
        MetaObject metaValue = metaObject.metaObjectForProperty(prop.getIndexedName());
        if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 282 50 8135540")|| true) && (metaValue == SystemMetaObject.NULL_META_OBJECT? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 282 11 11 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 282 11 11 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 282 51 8135540"); {
          return metaClass.hasGetter(name);
        } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 282 52 8135540");  {
          return metaValue.hasGetter(prop.getChildren());
        } }
      } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 282 54 8135540");  {
        return false;
      } }
    } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 282 56 8135540");  {
      return metaClass.hasGetter(name);
    } }
  }

  public MetaObject instantiatePropertyValue(String name, PropertyTokenizer prop, ObjectFactory objectFactory) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 282 58 8135540"); 
    MetaObject metaValue;
    Class<?> type = getSetterType(prop.getName());
    try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 282 59 8135540"); 
      Object newObject = objectFactory.create(type);
      metaValue = MetaObject.forObject(newObject, metaObject.getObjectFactory(), metaObject.getObjectWrapperFactory());
      set(prop, newObject);
    } catch (Exception e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 282 60 8135540"); 
      throw new ReflectionException("Cannot set value of property '" + name + "' because '" + name + "' is null and cannot be instantiated on instance of " + type.getName() + ". Cause:" + e.toString(), e);
    }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 282 61 8135540");
    return metaValue;
  }

  private Object getBeanProperty(PropertyTokenizer prop, Object object) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 282 62 8135540"); 
    try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 282 63 8135540"); 
      Invoker method = metaClass.getGetInvoker(prop.getName());
      try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 282 64 8135540"); 
        return method.invoke(object, NO_ARGUMENTS);
      } catch (Throwable t) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 282 65 8135540"); 
        throw ExceptionUtil.unwrapThrowable(t);
      }
    } catch (RuntimeException e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 282 67 8135540"); 
      throw e;
    } catch (Throwable t) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 282 68 8135540"); 
      throw new ReflectionException("Could not get property '" + prop.getName() + "' from " + object.getClass() + ".  Cause: " + t.toString(), t);
    }
  }

  private void setBeanProperty(PropertyTokenizer prop, Object object, Object value) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 282 70 8135540"); 
    try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 282 71 8135540"); 
      Invoker method = metaClass.getSetInvoker(prop.getName());
      Object[] params = {value};
      try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 282 72 8135540"); 
        method.invoke(object, params);
      } catch (Throwable t) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 282 73 8135540"); 
        throw ExceptionUtil.unwrapThrowable(t);
      }
    } catch (Throwable t) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 282 75 8135540"); 
      throw new ReflectionException("Could not set property '" + prop.getName() + "' of '" + object.getClass() + "' with value '" + value + "' Cause: " + t.toString(), t);
    }
  }

  public boolean isCollection() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 282 77 8135540"); 
    return false;
  }

  public void add(Object element) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 282 78 8135540"); 
    throw new UnsupportedOperationException();
  }

  public <E> void addAll(List<E> list) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 282 79 8135540"); 
    throw new UnsupportedOperationException();
  }

}

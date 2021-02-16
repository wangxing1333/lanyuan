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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.apache.ibatis.reflection.factory.ObjectFactory;
import org.apache.ibatis.reflection.property.PropertyTokenizer;

/**
 * @author Clinton Begin
 */
import com.process.ZoaExp;
import com.process.ZoaThreadLocal;
public class MapWrapper extends BaseWrapper {

  private Map<String, Object> map;

  public MapWrapper(MetaObject metaObject, Map<String, Object> map) {
    super(metaObject);
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 269 0 8135540"); 
    this.map = map;
  }

  public Object get(PropertyTokenizer prop) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 269 1 8135540"); 
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 269 2 8135540")|| true) && (prop.getIndex() != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 269 0 0 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 269 0 0 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 269 3 8135540"); {
      Object collection = resolveCollection(prop, map);
      return getCollectionValue(prop, collection);
    } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 269 4 8135540");  {
      return map.get(prop.getName());
    } }
  }

  public void set(PropertyTokenizer prop, Object value) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 269 6 8135540"); 
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 269 7 8135540")|| true) && (prop.getIndex() != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 269 1 1 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 269 1 1 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 269 8 8135540"); {
      Object collection = resolveCollection(prop, map);
      setCollectionValue(prop, collection, value);
    } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 269 9 8135540");  {
      map.put(prop.getName(), value);
    } }
  }

  public String findProperty(String name, boolean useCamelCaseMapping) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 269 11 8135540"); 
    return name;
  }

  public String[] getGetterNames() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 269 12 8135540"); 
    return map.keySet().toArray(new String[map.keySet().size()]);
  }

  public String[] getSetterNames() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 269 13 8135540"); 
    return map.keySet().toArray(new String[map.keySet().size()]);
  }

  public Class<?> getSetterType(String name) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 269 14 8135540"); 
    PropertyTokenizer prop = new PropertyTokenizer(name);
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 269 15 8135540")|| true) && (prop.hasNext()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 269 2 2 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 269 2 2 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 269 16 8135540"); {
      MetaObject metaValue = metaObject.metaObjectForProperty(prop.getIndexedName());
      if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 269 17 8135540")|| true) && (metaValue == SystemMetaObject.NULL_META_OBJECT? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 269 3 3 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 269 3 3 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 269 18 8135540"); {
        return Object.class;
      } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 269 19 8135540");  {
        return metaValue.getSetterType(prop.getChildren());
      } }
    } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 269 21 8135540");  {
      if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 269 22 8135540")|| true) && (map.get(name) != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 269 4 4 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 269 4 4 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 269 23 8135540"); {
        return map.get(name).getClass();
      } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 269 24 8135540");  {
        return Object.class;
      } }
    } }
  }

  public Class<?> getGetterType(String name) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 269 27 8135540"); 
    PropertyTokenizer prop = new PropertyTokenizer(name);
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 269 28 8135540")|| true) && (prop.hasNext()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 269 5 5 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 269 5 5 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 269 29 8135540"); {
      MetaObject metaValue = metaObject.metaObjectForProperty(prop.getIndexedName());
      if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 269 30 8135540")|| true) && (metaValue == SystemMetaObject.NULL_META_OBJECT? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 269 6 6 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 269 6 6 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 269 31 8135540"); {
        return Object.class;
      } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 269 32 8135540");  {
        return metaValue.getGetterType(prop.getChildren());
      } }
    } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 269 34 8135540");  {
      if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 269 35 8135540")|| true) && (map.get(name) != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 269 7 7 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 269 7 7 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 269 36 8135540"); {
        return map.get(name).getClass();
      } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 269 37 8135540");  {
        return Object.class;
      } }
    } }
  }

  public boolean hasSetter(String name) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 269 40 8135540"); 
    return true;
  }

  public boolean hasGetter(String name) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 269 41 8135540"); 
    PropertyTokenizer prop = new PropertyTokenizer(name);
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 269 42 8135540")|| true) && (prop.hasNext()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 269 8 8 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 269 8 8 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 269 43 8135540"); {
      if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 269 44 8135540")|| true) && (map.containsKey(prop.getIndexedName())? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 269 9 9 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 269 9 9 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 269 45 8135540"); {
        MetaObject metaValue = metaObject.metaObjectForProperty(prop.getIndexedName());
        if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 269 46 8135540")|| true) && (metaValue == SystemMetaObject.NULL_META_OBJECT? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 269 10 10 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 269 10 10 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 269 47 8135540"); {
          return true;
        } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 269 48 8135540");  {
          return metaValue.hasGetter(prop.getChildren());
        } }
      } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 269 50 8135540");  {
        return false;
      } }
    } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 269 52 8135540");  {
      return map.containsKey(prop.getName());
    } }
  }

  public MetaObject instantiatePropertyValue(String name, PropertyTokenizer prop, ObjectFactory objectFactory) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 269 54 8135540"); 
    HashMap<String, Object> map = new HashMap<String, Object>();
    set(prop, map);
    return MetaObject.forObject(map, metaObject.getObjectFactory(), metaObject.getObjectWrapperFactory());
  }

  public boolean isCollection() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 269 55 8135540"); 
    return false;
  }

  public void add(Object element) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 269 56 8135540"); 
    throw new UnsupportedOperationException();
  }

  public <E> void addAll(List<E> element) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 269 57 8135540"); 
    throw new UnsupportedOperationException();
  }

}

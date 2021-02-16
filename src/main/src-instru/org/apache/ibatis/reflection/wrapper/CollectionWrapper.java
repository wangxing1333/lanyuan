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

import java.util.Collection;
import java.util.List;

import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.factory.ObjectFactory;
import org.apache.ibatis.reflection.property.PropertyTokenizer;

/**
 * @author Clinton Begin
 */
import com.process.ZoaExp;
import com.process.ZoaThreadLocal;
public class CollectionWrapper implements ObjectWrapper {

  private Collection<Object> object;

  public CollectionWrapper(MetaObject metaObject, Collection<Object> object) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 294 0 8135540"); 
    this.object = object;
  }

  public Object get(PropertyTokenizer prop) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 294 1 8135540"); 
    throw new UnsupportedOperationException();
  }

  public void set(PropertyTokenizer prop, Object value) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 294 2 8135540"); 
    throw new UnsupportedOperationException();
  }

  public String findProperty(String name, boolean useCamelCaseMapping) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 294 3 8135540"); 
    throw new UnsupportedOperationException();
  }

  public String[] getGetterNames() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 294 4 8135540"); 
    throw new UnsupportedOperationException();
  }

  public String[] getSetterNames() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 294 5 8135540"); 
    throw new UnsupportedOperationException();
  }

  public Class<?> getSetterType(String name) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 294 6 8135540"); 
    throw new UnsupportedOperationException();
  }

  public Class<?> getGetterType(String name) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 294 7 8135540"); 
    throw new UnsupportedOperationException();
  }

  public boolean hasSetter(String name) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 294 8 8135540"); 
    throw new UnsupportedOperationException();
  }

  public boolean hasGetter(String name) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 294 9 8135540"); 
    throw new UnsupportedOperationException();
  }

  public MetaObject instantiatePropertyValue(String name, PropertyTokenizer prop, ObjectFactory objectFactory) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 294 10 8135540"); 
    throw new UnsupportedOperationException();
  }

  public boolean isCollection() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 294 11 8135540"); 
    return true;
  }

  public void add(Object element) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 294 12 8135540"); 
    object.add(element);
  }

  public <E> void addAll(List<E> element) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 294 13 8135540"); 
    object.addAll(element);
  }

}

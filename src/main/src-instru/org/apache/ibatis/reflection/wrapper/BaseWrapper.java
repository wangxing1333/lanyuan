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
import java.util.Map;

import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.ReflectionException;
import org.apache.ibatis.reflection.property.PropertyTokenizer;

/**
 * @author Clinton Begin
 */
import com.process.ZoaExp;
import com.process.ZoaThreadLocal;
public abstract class BaseWrapper implements ObjectWrapper {

  protected static final Object[] NO_ARGUMENTS = new Object[0];
  protected MetaObject metaObject;

  protected BaseWrapper(MetaObject metaObject) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 193 0 8135540"); 
    this.metaObject = metaObject;
  }

  protected Object resolveCollection(PropertyTokenizer prop, Object object) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 193 1 8135540"); 
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 193 2 8135540")|| true) && ("".equals(prop.getName())? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 193 0 0 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 193 0 0 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 193 3 8135540"); {
      return object;
    } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 193 4 8135540");  {
      return metaObject.getValue(prop.getName());
    } }
  }

  protected Object getCollectionValue(PropertyTokenizer prop, Object collection) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 193 6 8135540"); 
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 193 7 8135540")|| true) && (collection instanceof Map? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 193 1 1 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 193 1 1 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 193 8 8135540"); {
      return ((Map) collection).get(prop.getIndex());
    } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 193 9 8135540");  {
      int i = Integer.parseInt(prop.getIndex());
      if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 193 10 8135540")|| true) && (collection instanceof List? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 193 2 2 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 193 2 2 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 193 11 8135540"); {
        return ((List) collection).get(i);
      } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 193 12 8135540");  if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 193 13 8135540")|| true) && (collection instanceof Object[]? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 193 3 3 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 193 3 3 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 193 14 8135540"); {
        return ((Object[]) collection)[i];
      } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 193 15 8135540");  if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 193 16 8135540")|| true) && (collection instanceof char[]? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 193 4 4 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 193 4 4 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 193 17 8135540"); {
        return ((char[]) collection)[i];
      } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 193 18 8135540");  if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 193 19 8135540")|| true) && (collection instanceof boolean[]? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 193 5 5 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 193 5 5 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 193 20 8135540"); {
        return ((boolean[]) collection)[i];
      } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 193 21 8135540");  if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 193 22 8135540")|| true) && (collection instanceof byte[]? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 193 6 6 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 193 6 6 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 193 23 8135540"); {
        return ((byte[]) collection)[i];
      } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 193 24 8135540");  if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 193 25 8135540")|| true) && (collection instanceof double[]? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 193 7 7 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 193 7 7 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 193 26 8135540"); {
        return ((double[]) collection)[i];
      } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 193 27 8135540");  if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 193 28 8135540")|| true) && (collection instanceof float[]? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 193 8 8 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 193 8 8 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 193 29 8135540"); {
        return ((float[]) collection)[i];
      } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 193 30 8135540");  if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 193 31 8135540")|| true) && (collection instanceof int[]? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 193 9 9 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 193 9 9 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 193 32 8135540"); {
        return ((int[]) collection)[i];
      } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 193 33 8135540");  if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 193 34 8135540")|| true) && (collection instanceof long[]? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 193 10 10 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 193 10 10 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 193 35 8135540"); {
        return ((long[]) collection)[i];
      } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 193 36 8135540");  if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 193 37 8135540")|| true) && (collection instanceof short[]? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 193 11 11 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 193 11 11 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 193 38 8135540"); {
        return ((short[]) collection)[i];
      } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 193 39 8135540");  {
        throw new ReflectionException("The '" + prop.getName() + "' property of " + collection + " is not a List or Array.");
      } } } } } } } } } } }
    } }
  }

  protected void setCollectionValue(PropertyTokenizer prop, Object collection, Object value) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 193 51 8135540"); 
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 193 52 8135540")|| true) && (collection instanceof Map? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 193 12 12 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 193 12 12 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 193 53 8135540"); {
      ((Map) collection).put(prop.getIndex(), value);
    } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 193 54 8135540");  {
      int i = Integer.parseInt(prop.getIndex());
      if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 193 55 8135540")|| true) && (collection instanceof List? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 193 13 13 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 193 13 13 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 193 56 8135540"); {
        ((List) collection).set(i, value);
      } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 193 57 8135540");  if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 193 58 8135540")|| true) && (collection instanceof Object[]? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 193 14 14 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 193 14 14 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 193 59 8135540"); {
        ((Object[]) collection)[i] = value;
      } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 193 60 8135540");  if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 193 61 8135540")|| true) && (collection instanceof char[]? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 193 15 15 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 193 15 15 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 193 62 8135540"); {
        ((char[]) collection)[i] = (Character) value;
      } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 193 63 8135540");  if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 193 64 8135540")|| true) && (collection instanceof boolean[]? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 193 16 16 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 193 16 16 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 193 65 8135540"); {
        ((boolean[]) collection)[i] = (Boolean) value;
      } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 193 66 8135540");  if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 193 67 8135540")|| true) && (collection instanceof byte[]? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 193 17 17 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 193 17 17 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 193 68 8135540"); {
        ((byte[]) collection)[i] = (Byte) value;
      } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 193 69 8135540");  if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 193 70 8135540")|| true) && (collection instanceof double[]? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 193 18 18 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 193 18 18 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 193 71 8135540"); {
        ((double[]) collection)[i] = (Double) value;
      } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 193 72 8135540");  if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 193 73 8135540")|| true) && (collection instanceof float[]? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 193 19 19 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 193 19 19 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 193 74 8135540"); {
        ((float[]) collection)[i] = (Float) value;
      } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 193 75 8135540");  if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 193 76 8135540")|| true) && (collection instanceof int[]? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 193 20 20 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 193 20 20 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 193 77 8135540"); {
        ((int[]) collection)[i] = (Integer) value;
      } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 193 78 8135540");  if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 193 79 8135540")|| true) && (collection instanceof long[]? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 193 21 21 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 193 21 21 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 193 80 8135540"); {
        ((long[]) collection)[i] = (Long) value;
      } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 193 81 8135540");  if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 193 82 8135540")|| true) && (collection instanceof short[]? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 193 22 22 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 193 22 22 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 193 83 8135540"); {
        ((short[]) collection)[i] = (Short) value;
      } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 193 84 8135540");  {
        throw new ReflectionException("The '" + prop.getName() + "' property of " + collection + " is not a List or Array.");
      } } } } } } } } } } }
    } }
  }

}
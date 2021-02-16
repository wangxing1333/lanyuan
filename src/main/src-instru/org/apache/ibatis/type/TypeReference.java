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
package org.apache.ibatis.type;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * References a generic type.
 *
 * @param <T> the referenced type
 * @author Simone Tripodi
 * @since 3.1.0
 */
import com.process.ZoaExp;
import com.process.ZoaThreadLocal;
public abstract class TypeReference<T> {

  private final Type rawType;

  protected TypeReference() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 265 0 8135540"); 
    rawType = getSuperclassTypeParameter(getClass());
  }

  Type getSuperclassTypeParameter(Class<?> clazz) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 265 1 8135540"); 
    Type genericSuperclass = clazz.getGenericSuperclass();
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 265 2 8135540")|| true) && (genericSuperclass instanceof Class? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 265 0 0 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 265 0 0 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 265 3 8135540"); {
      // try to climb up the hierarchy until meet something useful
      if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 265 4 8135540")|| true) && (TypeReference.class != genericSuperclass? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 265 1 1 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 265 1 1 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 265 5 8135540"); {
        return getSuperclassTypeParameter(clazz.getSuperclass());
      } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 265 6 8135540");

      throw new TypeException("'" + getClass() + "' extends TypeReference but misses the type parameter. "
        + "Remove the extension or add a type parameter to it.");
    } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 265 7 8135540");

    Type rawType = ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0];
    // TODO remove this when Reflector is fixed to return Types
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 265 8 8135540")|| true) && (rawType instanceof ParameterizedType? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 265 2 2 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 265 2 2 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 265 9 8135540"); {
      rawType = ((ParameterizedType) rawType).getRawType();
    } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 265 10 8135540");

    return rawType;
  }

  public final Type getRawType() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 265 11 8135540"); 
    return rawType;
  }

  @Override
  public String toString() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 265 12 8135540"); 
    return rawType.toString();
  }

}

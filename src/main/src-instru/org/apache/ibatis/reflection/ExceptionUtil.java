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
package org.apache.ibatis.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.UndeclaredThrowableException;

/**
 * @author Clinton Begin
 */
import com.process.ZoaExp;
import com.process.ZoaThreadLocal;
public class ExceptionUtil {

  public static Throwable unwrapThrowable(Throwable wrapped) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 304 0 8135540"); 
    Throwable unwrapped = wrapped;
    while (/* TRUE */true){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 304 1 8135540");
 ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 304 2 8135540");  {
      if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 304 3 8135540")|| true) && (unwrapped instanceof InvocationTargetException? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 304 0 0 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 304 0 0 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 304 4 8135540"); {
        unwrapped = ((InvocationTargetException) unwrapped).getTargetException();
      } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 304 5 8135540");  if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 304 6 8135540")|| true) && (unwrapped instanceof UndeclaredThrowableException? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 304 1 1 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 304 1 1 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 304 7 8135540"); {
        unwrapped = ((UndeclaredThrowableException) unwrapped).getUndeclaredThrowable();
      } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 304 8 8135540");  {
        return unwrapped;
      } } }
    }}
  }

}

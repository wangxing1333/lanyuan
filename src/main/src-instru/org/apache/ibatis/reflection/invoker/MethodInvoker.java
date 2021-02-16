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
package org.apache.ibatis.reflection.invoker;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Clinton Begin
 */
import com.process.ZoaExp;
import com.process.ZoaThreadLocal;
public class MethodInvoker implements Invoker {

  private Class<?> type;
  private Method method;

  public MethodInvoker(Method method) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 195 0 8135540"); 
    this.method = method;

    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 195 1 8135540")|| true) && (method.getParameterTypes().length == 1? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 195 0 0 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 195 0 0 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 195 2 8135540"); {
      type = method.getParameterTypes()[0];
    } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 195 3 8135540");  {
      type = method.getReturnType();
    } }
  }

  public Object invoke(Object target, Object[] args) throws IllegalAccessException, InvocationTargetException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 195 5 8135540"); 
    return method.invoke(target, args);
  }

  public Class<?> getType() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 195 6 8135540"); 
    return type;
  }
}

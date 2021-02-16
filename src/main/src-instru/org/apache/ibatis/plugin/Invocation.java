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
package org.apache.ibatis.plugin;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Clinton Begin
 */
import com.process.ZoaExp;
import com.process.ZoaThreadLocal;
public class Invocation {

  private Object target;
  private Method method;
  private Object[] args;

  public Invocation(Object target, Method method, Object[] args) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 286 0 8135540"); 
    this.target = target;
    this.method = method;
    this.args = args;
  }

  public Object getTarget() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 286 1 8135540"); 
    return target;
  }

  public Method getMethod() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 286 2 8135540"); 
    return method;
  }

  public Object[] getArgs() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 286 3 8135540"); 
    return args;
  }

  public Object proceed() throws InvocationTargetException, IllegalAccessException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 286 4 8135540"); 
    return method.invoke(target, args);
  }

}

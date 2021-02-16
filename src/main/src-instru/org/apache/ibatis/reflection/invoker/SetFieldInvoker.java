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

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * @author Clinton Begin
 */
import com.process.ZoaExp;
import com.process.ZoaThreadLocal;
public class SetFieldInvoker implements Invoker {
  private Field field;

  public SetFieldInvoker(Field field) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 272 0 8135540"); 
    this.field = field;
  }

  public Object invoke(Object target, Object[] args) throws IllegalAccessException, InvocationTargetException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 272 1 8135540"); 
    field.set(target, args[0]);
    return null;
  }

  public Class<?> getType() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 272 2 8135540"); 
    return field.getType();
  }
}

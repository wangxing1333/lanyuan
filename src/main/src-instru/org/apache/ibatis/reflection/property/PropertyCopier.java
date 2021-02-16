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
package org.apache.ibatis.reflection.property;

import java.lang.reflect.Field;

/**
 * @author Clinton Begin
 */
import com.process.ZoaExp;
import com.process.ZoaThreadLocal;
public class PropertyCopier {

  public static void copyBeanProperties(Class<?> type, Object sourceBean, Object destinationBean) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 201 0 8135540"); 
    Class<?> parent = type;
    while ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 201 1 8135540")|| true) && (parent != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 201 0 0 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 201 0 0 0 0 ","8135540",false,0) && false))){ ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 201 2 8135540");  {
      final Field[] fields = parent.getDeclaredFields();
      for(Field field : /* TRUE */fields){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 201 3 8135540");ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 201 4 8135540"); {
        try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 201 5 8135540"); 
          field.setAccessible(true);
          field.set(destinationBean, field.get(sourceBean));
        } catch (Exception e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 201 6 8135540"); 
          // Nothing useful to do, will only fail on final fields, which will be ignored.
        }
      }}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 201 8 8135540");
      parent = parent.getSuperclass();
    }}
  }

}

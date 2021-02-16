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
package org.apache.ibatis.executor.result;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.reflection.factory.ObjectFactory;
import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.ResultHandler;

/**
 * @author Clinton Begin
 */
import com.process.ZoaExp;
import com.process.ZoaThreadLocal;
public class DefaultResultHandler implements ResultHandler {

  private final List<Object> list;

  public DefaultResultHandler() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 171 0 8135540"); 
    list = new ArrayList<Object>();
  }

  @SuppressWarnings("unchecked")
  public DefaultResultHandler(ObjectFactory objectFactory) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 171 1 8135540"); 
    list = objectFactory.create(List.class);
  }

  public void handleResult(ResultContext context) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 171 2 8135540"); 
    list.add(context.getResultObject());
  }

  public List<Object> getResultList() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 171 3 8135540"); 
    return list;
  }

}

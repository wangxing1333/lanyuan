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

import org.apache.ibatis.session.ResultContext;

/**
 * @author Clinton Begin
 */
import com.process.ZoaExp;
import com.process.ZoaThreadLocal;
public class DefaultResultContext implements ResultContext {

  private Object resultObject;
  private int resultCount;
  private boolean stopped;

  public DefaultResultContext() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 164 0 8135540"); 
    resultObject = null;
    resultCount = 0;
    stopped = false;
  }

  public Object getResultObject() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 164 1 8135540"); 
    return resultObject;
  }

  public int getResultCount() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 164 2 8135540"); 
    return resultCount;
  }

  public boolean isStopped() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 164 3 8135540"); 
    return stopped;
  }

  public void nextResultObject(Object resultObject) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 164 4 8135540"); 
    resultCount++;
    this.resultObject = resultObject;
  }

  public void stop() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 164 5 8135540"); 
    this.stopped = true;
  }

}

// ZOA_CREATED! DO NOT EDIT IT! -- 
/*
 *    Copyright 2009-2011 the original author or authors.
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
package org.apache.ibatis.executor.keygen;

import java.sql.Statement;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;

/**
 * @author Clinton Begin
 */
import com.process.ZoaExp;
import com.process.ZoaThreadLocal;
public class NoKeyGenerator implements KeyGenerator {

  public void processBefore(Executor executor, MappedStatement ms, Statement stmt, Object parameter) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 222 0 8135540"); 
  }

  public void processAfter(Executor executor, MappedStatement ms, Statement stmt, Object parameter) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 222 1 8135540"); 
  }

}

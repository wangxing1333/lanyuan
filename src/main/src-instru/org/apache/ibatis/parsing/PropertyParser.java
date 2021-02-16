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
package org.apache.ibatis.parsing;

import java.util.Properties;

/**
 * @author Clinton Begin
 */
import com.process.ZoaExp;
import com.process.ZoaThreadLocal;
public class PropertyParser {

  public static String parse(String string, Properties variables) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 183 0 8135540"); 
    VariableTokenHandler handler = new VariableTokenHandler(variables);
    GenericTokenParser parser = new GenericTokenParser("${", "}", handler);
    return parser.parse(string);
  }

  private static class VariableTokenHandler implements TokenHandler {
    private Properties variables;

    public VariableTokenHandler(Properties variables) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 183 1 8135540"); 
      this.variables = variables;
    }

    public String handleToken(String content) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 183 2 8135540"); 
      int zoa_cond_n3_0 = 2;
int zoa_cond_n3_1 = 2;
//zoa_cond_n3_0#variables != null$zoa_cond_n3_1#variables.containsKey(content)
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 183 3 8135540")|| true) && ((variables != null?(zoa_cond_n3_0 != (zoa_cond_n3_0 = 1)):(zoa_cond_n3_0 == (zoa_cond_n3_0 = 0))) && (variables.containsKey(content)?(zoa_cond_n3_1 != (zoa_cond_n3_1 = 1)):(zoa_cond_n3_1 == (zoa_cond_n3_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 183 2 0 1 2 ","8135540",true,zoa_cond_n3_0,zoa_cond_n3_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 183 2 0 0 2 ","8135540",false,zoa_cond_n3_0,zoa_cond_n3_1) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 183 4 8135540"); {
        return variables.getProperty(content);
      } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 183 5 8135540");
      return "${" + content + "}";
    }
  }
}

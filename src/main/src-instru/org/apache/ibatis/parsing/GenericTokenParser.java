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

/**
 * @author Clinton Begin
 */
import com.process.ZoaExp;
import com.process.ZoaThreadLocal;
public class GenericTokenParser {

  private final String openToken;
  private final String closeToken;
  private final TokenHandler handler;

  public GenericTokenParser(String openToken, String closeToken, TokenHandler handler) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 290 0 8135540"); 
    this.openToken = openToken;
    this.closeToken = closeToken;
    this.handler = handler;
  }

  public String parse(String text) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 290 1 8135540"); 
    StringBuilder builder = new StringBuilder();
    int zoa_cond_n2_0 = 2;
int zoa_cond_n2_1 = 2;
//zoa_cond_n2_0#text != null$zoa_cond_n2_1#text.length() > 0
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 290 2 8135540")|| true) && ((text != null?(zoa_cond_n2_0 != (zoa_cond_n2_0 = 1)):(zoa_cond_n2_0 == (zoa_cond_n2_0 = 0))) && (text.length() > 0?(zoa_cond_n2_1 != (zoa_cond_n2_1 = 1)):(zoa_cond_n2_1 == (zoa_cond_n2_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 290 2 0 1 2 ","8135540",true,zoa_cond_n2_0,zoa_cond_n2_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 290 2 0 0 2 ","8135540",false,zoa_cond_n2_0,zoa_cond_n2_1) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 290 3 8135540"); {
      char[] src = text.toCharArray();
      int offset = 0;
      int start = text.indexOf(openToken, offset);
      while ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 290 4 8135540")|| true) && (start > -1? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 290 3 1 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 290 3 1 0 0 ","8135540",false,0) && false))){ ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 290 5 8135540");  {
        int zoa_cond_n6_0 = 2;
int zoa_cond_n6_1 = 2;
//zoa_cond_n6_0#start > 0$zoa_cond_n6_1#src[start - 1] == '\\'
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 290 6 8135540")|| true) && ((start > 0?(zoa_cond_n6_0 != (zoa_cond_n6_0 = 1)):(zoa_cond_n6_0 == (zoa_cond_n6_0 = 0))) && (src[start - 1] == '\\'?(zoa_cond_n6_1 != (zoa_cond_n6_1 = 1)):(zoa_cond_n6_1 == (zoa_cond_n6_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 290 6 2 1 2 ","8135540",true,zoa_cond_n6_0,zoa_cond_n6_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 290 6 2 0 2 ","8135540",false,zoa_cond_n6_0,zoa_cond_n6_1) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 290 7 8135540"); {
          // the variable is escaped. remove the backslash.
          builder.append(src, offset, start - offset - 1).append(openToken);
          offset = start + openToken.length();
        } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 290 8 8135540");  {
          int end = text.indexOf(closeToken, start);
          if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 290 9 8135540")|| true) && (end == -1? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 290 7 3 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 290 7 3 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 290 10 8135540"); {
            builder.append(src, offset, src.length - offset);
            offset = src.length;
          } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 290 11 8135540");  {
            builder.append(src, offset, start - offset);
            offset = start + openToken.length();
            String content = new String(src, offset, end - offset);
            builder.append(handler.handleToken(content));
            offset = end + closeToken.length();
          } }
        } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 290 13 8135540");
        start = text.indexOf(openToken, offset);
      }}ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 290 14 8135540"); 
      if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 290 15 8135540")|| true) && (offset < src.length? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 290 8 4 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 290 8 4 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 290 16 8135540"); {
        builder.append(src, offset, src.length - offset);
      } }
    } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 290 18 8135540");
    return builder.toString();
  }

}

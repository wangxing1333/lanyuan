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

import java.util.Iterator;

/**
 * @author Clinton Begin
 */
import com.process.ZoaExp;
import com.process.ZoaThreadLocal;
public class PropertyTokenizer implements Iterable<PropertyTokenizer>, Iterator<PropertyTokenizer> {
  private String name;
  private String indexedName;
  private String index;
  private String children;

  public PropertyTokenizer(String fullname) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 200 0 8135540"); 
    int delim = fullname.indexOf('.');
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 200 1 8135540")|| true) && (delim > -1? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 200 0 0 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 200 0 0 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 200 2 8135540"); {
      name = fullname.substring(0, delim);
      children = fullname.substring(delim + 1);
    } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 200 3 8135540");  {
      name = fullname;
      children = null;
    } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 200 4 8135540");
    indexedName = name;
    delim = name.indexOf('[');
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 200 5 8135540")|| true) && (delim > -1? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 200 1 1 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 200 1 1 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 200 6 8135540"); {
      index = name.substring(delim + 1, name.length() - 1);
      name = name.substring(0, delim);
    } }
  }

  public String getName() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 200 8 8135540"); 
    return name;
  }

  public String getIndex() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 200 9 8135540"); 
    return index;
  }

  public String getIndexedName() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 200 10 8135540"); 
    return indexedName;
  }

  public String getChildren() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 200 11 8135540"); 
    return children;
  }

  public boolean hasNext() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 200 12 8135540"); 
    return children != null;
  }

  public PropertyTokenizer next() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 200 13 8135540"); 
    return new PropertyTokenizer(children);
  }

  public void remove() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 200 14 8135540"); 
    throw new UnsupportedOperationException("Remove is not supported, as it has no meaning in the context of properties.");
  }

  public Iterator<PropertyTokenizer> iterator() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 200 15 8135540"); 
    return this;
  }
}

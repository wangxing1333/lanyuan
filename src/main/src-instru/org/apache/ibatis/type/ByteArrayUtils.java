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
package org.apache.ibatis.type;

/**
 * @author Clinton Begin
 */
import com.process.ZoaExp;
import com.process.ZoaThreadLocal;
class ByteArrayUtils {
  static byte[] convertToPrimitiveArray(Byte[] objects) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 244 0 8135540"); 
    final byte[] bytes = new byte[objects.length];
    for (int i = 0; (ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 244 1 8135540")|| true) && (i < objects.length? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 244 0 0 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 244 0 0 0 0 ","8135540",false,0) && false)); i++){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 244 2 8135540"); {
      Byte b = objects[i];
      bytes[i] = b;
    }}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 244 3 8135540");
    return bytes;
  }

  static Byte[] convertToObjectArray(byte[] bytes) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 244 4 8135540"); 
    final Byte[] objects = new Byte[bytes.length];
    for (int i = 0; (ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 244 5 8135540")|| true) && (i < bytes.length? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 244 1 1 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 244 1 1 0 0 ","8135540",false,0) && false)); i++){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 244 6 8135540"); {
      byte b = bytes[i];
      objects[i] = b;
    }}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 244 7 8135540");
    return objects;
  }
}

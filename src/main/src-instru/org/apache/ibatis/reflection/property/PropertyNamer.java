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

import java.util.Locale;

import org.apache.ibatis.reflection.ReflectionException;

/**
 * @author Clinton Begin
 */
import com.process.ZoaExp;
import com.process.ZoaThreadLocal;
public class PropertyNamer {

	public static String methodToProperty(
			String name) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 256 0 8135540"); 
		if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 256 1 8135540")|| true) && (name.startsWith("is")? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 256 0 0 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 256 0 0 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 256 2 8135540"); {
			name = name.substring(2);
		} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 256 3 8135540");  int zoa_cond_n4_0 = 2;
int zoa_cond_n4_1 = 2;
//zoa_cond_n4_0#name.startsWith("get")$zoa_cond_n4_1#name.startsWith("set")
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 256 4 8135540")|| true) && ((name
				.startsWith("get")?(zoa_cond_n4_0 != (zoa_cond_n4_0 = 1)):(zoa_cond_n4_0 == (zoa_cond_n4_0 = 0)))
				|| (name.startsWith("set")?(zoa_cond_n4_1 != (zoa_cond_n4_1 = 1)):(zoa_cond_n4_1 == (zoa_cond_n4_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 256 3 1 1 2 ","8135540",true,zoa_cond_n4_0,zoa_cond_n4_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 256 3 1 0 2 ","8135540",false,zoa_cond_n4_0,zoa_cond_n4_1) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 256 5 8135540"); {
			name = name.substring(3);
		} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 256 6 8135540");  {
			throw new ReflectionException(
					"Error parsing property name '"
							+ name
							+ "'.  Didn't start with 'is', 'get' or 'set'.");
		} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 256 7 8135540"); }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 256 8 8135540");

		int zoa_cond_n9_0 = 2;
int zoa_cond_n9_1 = 2;
int zoa_cond_n9_2 = 2;
int zoa_cond_n9_3 = 6;
//zoa_cond_n9_0#name.length() == 1$zoa_cond_n9_1#name.length() > 1$zoa_cond_n9_2#Character.isUpperCase(name.charAt(1))$zoa_cond_n9_3#name.length() > 1 && !Character.isUpperCase(name.charAt(1))
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 256 9 8135540")|| true) && ((name.length() == 1?(zoa_cond_n9_0 != (zoa_cond_n9_0 = 1)):(zoa_cond_n9_0 == (zoa_cond_n9_0 = 0)))
				|| ((name.length() > 1?(zoa_cond_n9_1 != (zoa_cond_n9_1 = 1)):(zoa_cond_n9_1 == (zoa_cond_n9_1 = 0))) && !(Character
						.isUpperCase(name
								.charAt(1))?(zoa_cond_n9_2 != (zoa_cond_n9_2 = 1)):(zoa_cond_n9_2 == (zoa_cond_n9_2 = 0)))?(zoa_cond_n9_3 != (zoa_cond_n9_3 = 5)):(zoa_cond_n9_3 == (zoa_cond_n9_3 = 4)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 256 8 2 1 4 ","8135540",true,zoa_cond_n9_0,zoa_cond_n9_1,zoa_cond_n9_2,zoa_cond_n9_3) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 256 8 2 0 4 ","8135540",false,zoa_cond_n9_0,zoa_cond_n9_1,zoa_cond_n9_2,zoa_cond_n9_3) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 256 10 8135540"); {
			name = name
					.substring(0, 1)
					.toLowerCase(
							Locale.ENGLISH)
					+ name.substring(1);
		} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 256 11 8135540");

		return name;
	}

	public static boolean isProperty(
			String name) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 256 12 8135540"); 
		return name.startsWith("get")
				|| name.startsWith("set")
				|| name.startsWith("is");
	}

	public static boolean isGetter(
			String name) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 256 13 8135540"); 
		return name.startsWith("get")
				|| name.startsWith("is");
	}

	public static boolean isSetter(
			String name) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 256 14 8135540"); 
		return name.startsWith("set");
	}

}

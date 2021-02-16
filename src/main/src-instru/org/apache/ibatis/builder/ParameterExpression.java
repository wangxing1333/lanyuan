// ZOA_CREATED! DO NOT EDIT IT! -- 
/*
 * Copyright 2012-2013 MyBatis.org.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.ibatis.builder;

import java.util.HashMap;

/**
 * Inline parameter expression parser. Supported grammar (simplified):
 * 
 * <pre>
 * inline-parameter = (propertyName | expression) oldJdbcType attributes
 * propertyName = /expression language's property navigation path/
 * expression = '(' /expression language's expression/ ')'
 * oldJdbcType = ':' /any valid jdbc type/
 * attributes = (',' attribute)*
 * attribute = name '=' value
 * </pre>
 */
/**
 * @author Frank D. Martinez [mnesarco]
 */
import com.process.ZoaExp;
import com.process.ZoaThreadLocal;
public class ParameterExpression extends
		HashMap<String, String> {

	private static final long serialVersionUID = -2417552199605158680L;

	public ParameterExpression(
			String expression) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 242 0 8135540"); 
		parse(expression);
	}

	private void parse(String expression) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 242 1 8135540"); 
		int p = skipWS(expression, 0);
		if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 242 2 8135540")|| true) && (expression.charAt(p) == '('? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 242 0 0 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 242 0 0 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 242 3 8135540"); {
			expression(expression,
					p + 1);
		} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 242 4 8135540");  {
			property(expression, p);
		} }
	}

	private void expression(
			String expression, int left) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 242 6 8135540"); 
		int match = 1;
		int right = left + 1;
		while ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 242 7 8135540")|| true) && (match > 0? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 242 1 1 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 242 1 1 0 0 ","8135540",false,0) && false))){ ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 242 8 8135540");  {
			if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 242 9 8135540")|| true) && (expression
					.charAt(right) == ')'? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 242 2 2 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 242 2 2 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 242 10 8135540"); {
				match--;
			} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 242 11 8135540");  if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 242 12 8135540")|| true) && (expression
					.charAt(right) == '('? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 242 3 3 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 242 3 3 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 242 13 8135540"); {
				match++;
			} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 242 14 8135540"); }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 242 15 8135540");
			right++;
		}}ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 242 16 8135540"); 
		put("expression",
				expression
						.substring(
								left,
								right - 1));
		jdbcTypeOpt(expression, right);
	}

	private void property(
			String expression, int left) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 242 17 8135540"); 
		if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 242 18 8135540")|| true) && (left < expression.length()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 242 4 4 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 242 4 4 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 242 19 8135540"); {
			int right = skipUntil(
					expression, left,
					",:");
			put("property",
					trimmedStr(
							expression,
							left, right));
			jdbcTypeOpt(expression,
					right);
		} }
	}

	private int skipWS(
			String expression, int p) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 242 21 8135540"); 
		for (int i = p; (ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 242 22 8135540")|| true) && (i < expression
				.length()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 242 5 5 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 242 5 5 0 0 ","8135540",false,0) && false)); i++){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 242 23 8135540"); {
			if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 242 24 8135540")|| true) && (expression.charAt(i) > 0x20? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 242 6 6 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 242 6 6 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 242 25 8135540"); {
				return i;
			} }
		}}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 242 27 8135540");
		return expression.length();
	}

	private int skipUntil(
			String expression, int p,
			final String endChars) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 242 28 8135540"); 
		for (int i = p; (ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 242 29 8135540")|| true) && (i < expression
				.length()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 242 7 7 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 242 7 7 0 0 ","8135540",false,0) && false)); i++){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 242 30 8135540"); {
			char c = expression
					.charAt(i);
			if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 242 31 8135540")|| true) && (endChars.indexOf(c) > -1? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 242 8 8 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 242 8 8 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 242 32 8135540"); {
				return i;
			} }
		}}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 242 34 8135540");
		return expression.length();
	}

	private void jdbcTypeOpt(
			String expression, int p) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 242 35 8135540"); 
		p = skipWS(expression, p);
		if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 242 36 8135540")|| true) && (p < expression.length()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 242 9 9 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 242 9 9 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 242 37 8135540"); {
			if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 242 38 8135540")|| true) && (expression.charAt(p) == ':'? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 242 10 10 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 242 10 10 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 242 39 8135540"); {
				jdbcType(expression,
						p + 1);
			} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 242 40 8135540");  if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 242 41 8135540")|| true) && (expression
					.charAt(p) == ','? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 242 11 11 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 242 11 11 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 242 42 8135540"); {
				option(expression,
						p + 1);
			} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 242 43 8135540");  {
				throw new BuilderException(
						"Parsing error in {"
								+ new String(
										expression)
								+ "} in position "
								+ p);
			} } }
		} }
	}

	private void jdbcType(
			String expression, int p) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 242 47 8135540"); 
		int left = skipWS(expression, p);
		int right = skipUntil(
				expression, left, ",");
		if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 242 48 8135540")|| true) && (right > left? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 242 12 12 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 242 12 12 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 242 49 8135540"); {
			put("jdbcType",
					trimmedStr(
							expression,
							left, right));
		} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 242 50 8135540");  {
			throw new BuilderException(
					"Parsing error in {"
							+ new String(
									expression)
							+ "} in position "
							+ p);
		} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 242 51 8135540");
		option(expression, right + 1);
	}

	private void option(
			String expression, int p) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 242 52 8135540"); 
		int left = skipWS(expression, p);
		if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 242 53 8135540")|| true) && (left < expression.length()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 242 13 13 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 242 13 13 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 242 54 8135540"); {
			int right = skipUntil(
					expression, left,
					"=");
			String name = trimmedStr(
					expression, left,
					right);
			left = right + 1;
			right = skipUntil(
					expression, left,
					",");
			String value = trimmedStr(
					expression, left,
					right);
			put(name, value);
			option(expression,
					right + 1);
		} }
	}

	private String trimmedStr(
			String str, int start,
			int end) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 242 56 8135540"); 
		while ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 242 57 8135540")|| true) && (str.charAt(start) <= 0x20? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 242 14 14 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 242 14 14 0 0 ","8135540",false,0) && false))){ ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 242 58 8135540");  {
			start++;
		}}ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 242 59 8135540"); 
		while ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 242 60 8135540")|| true) && (str.charAt(end - 1) <= 0x20? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 242 15 15 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 242 15 15 0 0 ","8135540",false,0) && false))){ ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 242 61 8135540");  {
			end--;
		}}ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 242 62 8135540"); 
		return start >= end ? "" : str
				.substring(start, end);
	}

}

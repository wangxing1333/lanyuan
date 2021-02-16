// ZOA_CREATED! DO NOT EDIT IT! -- 
package com.lanyuan.util;

import com.process.ZoaExp;
import com.process.ZoaThreadLocal;
public class UnicodeUtils {

	public static void main(String[] args)

	{
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 238 0 8135540"); 
		

		String str = "是";
		
		System.out.println(str);
		
		str = toUnicode(str, false);

		System.out.println(str);

		str = "az";
		
		System.out.println(str);
		
		str = stringToUnicode(str);
		
		System.out.println(str);
		
		str = fromUnicode(str);
		
		System.out.println(str);

	}

	public UnicodeUtils() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 238 1 8135540"); 

	}
	
	/**
	 * 英文,标点符号转Unicode
	 * @param s
	 * @return
	 */
	public static String stringToUnicode(String s) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 238 2 8135540"); 
		String str = "";
		for (int i = 0; (ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 238 3 8135540")|| true) && (i < s.length()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 238 0 0 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 238 0 0 0 0 ","8135540",false,0) && false)); i++){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 238 4 8135540"); {
			int ch = (int) s.charAt(i);
			if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 238 5 8135540")|| true) && (ch > 255? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 238 1 1 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 238 1 1 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 238 6 8135540");
				str += "\\u" + Integer.toHexString(ch); }
			else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 238 7 8135540"); 
				str += "\\u00" + Integer.toHexString(ch); }
		}}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 238 9 8135540");
		return str;
	}


	private static final char[] hexDigit = {

	'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E',
			'F'

	};

	private static char toHex(int nibble) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 238 10 8135540"); 

		return hexDigit[(nibble & 0xF)];

	}

	/**
	 * 中文转换为Unicode码
	 * 
	 * @param theString
	 * @param escapeSpace
	 * @return
	 */
	public static String toUnicode(String theString, boolean escapeSpace) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 238 11 8135540"); 

		int len = theString.length();

		int bufLen = len * 2;

		if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 238 12 8135540")|| true) && (bufLen < 0? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 238 2 2 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 238 2 2 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 238 13 8135540"); {

			bufLen = Integer.MAX_VALUE;

		} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 238 14 8135540");

		StringBuffer outBuffer = new StringBuffer(bufLen);

		for (int x = 0; (ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 238 15 8135540")|| true) && (x < len? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 238 3 3 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 238 3 3 0 0 ","8135540",false,0) && false)); x++){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 238 16 8135540"); {

			char aChar = theString.charAt(x);

			// Handle common case first, selecting largest block that

			// avoids the specials below

			int zoa_cond_n17_0 = 2;
int zoa_cond_n17_1 = 2;
//zoa_cond_n17_0#(aChar > 61)$zoa_cond_n17_1#(aChar < 127)
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 238 17 8135540")|| true) && (((aChar > 61)?(zoa_cond_n17_0 != (zoa_cond_n17_0 = 1)):(zoa_cond_n17_0 == (zoa_cond_n17_0 = 0))) && ((aChar < 127)?(zoa_cond_n17_1 != (zoa_cond_n17_1 = 1)):(zoa_cond_n17_1 == (zoa_cond_n17_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 238 6 4 1 2 ","8135540",true,zoa_cond_n17_0,zoa_cond_n17_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 238 6 4 0 2 ","8135540",false,zoa_cond_n17_0,zoa_cond_n17_1) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 238 18 8135540"); {

				if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 238 19 8135540")|| true) && (aChar == '\\'? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 238 7 5 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 238 7 5 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 238 20 8135540"); {

					outBuffer.append('\\');
					outBuffer.append('\\');

					continue;

				} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 238 21 8135540");

				outBuffer.append(aChar);

				continue;

			} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 238 22 8135540");

			 ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 238 23 8135540");switch (aChar) {

			case ' ':
 ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 238 25 8135540");

				int zoa_cond_n26_0 = 2;
int zoa_cond_n26_1 = 2;
//zoa_cond_n26_0#x == 0$zoa_cond_n26_1#escapeSpace
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 238 26 8135540")|| true) && ((x == 0?(zoa_cond_n26_0 != (zoa_cond_n26_0 = 1)):(zoa_cond_n26_0 == (zoa_cond_n26_0 = 0))) || (escapeSpace?(zoa_cond_n26_1 != (zoa_cond_n26_1 = 1)):(zoa_cond_n26_1 == (zoa_cond_n26_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 238 10 6 1 2 ","8135540",true,zoa_cond_n26_0,zoa_cond_n26_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 238 10 6 0 2 ","8135540",false,zoa_cond_n26_0,zoa_cond_n26_1) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 238 27 8135540");

					outBuffer.append('\\'); }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 238 28 8135540");

				outBuffer.append(' ');

				break;

			case '\t':
 ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 238 30 8135540");
				outBuffer.append('\\');
				outBuffer.append('t');

				break;

			case '\n':
 ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 238 32 8135540");
				outBuffer.append('\\');
				outBuffer.append('n');

				break;

			case '\r':
 ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 238 34 8135540");
				outBuffer.append('\\');
				outBuffer.append('r');

				break;

			case '\f':
 ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 238 36 8135540");
				outBuffer.append('\\');
				outBuffer.append('f');

				break;

			case '=':
 ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 238 38 8135540"); // Fall through

			case ':':
 ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 238 40 8135540"); // Fall through

			case '#':
 ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 238 42 8135540"); // Fall through

			case '!':
 ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 238 44 8135540");

				outBuffer.append('\\');
				outBuffer.append(aChar);

				break;

			default:
 ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 238 46 8135540");

				int zoa_cond_n47_0 = 2;
int zoa_cond_n47_1 = 2;
//zoa_cond_n47_0#(aChar < 32)$zoa_cond_n47_1#(aChar > 126)
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 238 47 8135540")|| true) && (((aChar < 0x0020)?(zoa_cond_n47_0 != (zoa_cond_n47_0 = 1)):(zoa_cond_n47_0 == (zoa_cond_n47_0 = 0))) || ((aChar > 0x007e)?(zoa_cond_n47_1 != (zoa_cond_n47_1 = 1)):(zoa_cond_n47_1 == (zoa_cond_n47_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 238 13 7 1 2 ","8135540",true,zoa_cond_n47_0,zoa_cond_n47_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 238 13 7 0 2 ","8135540",false,zoa_cond_n47_0,zoa_cond_n47_1) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 238 48 8135540"); {

					outBuffer.append('\\');

					outBuffer.append('u');

					outBuffer.append(toHex((aChar >> 12) & 0xF));

					outBuffer.append(toHex((aChar >> 2) & 0xF));

					outBuffer.append(toHex((aChar >> 4) & 0xF));

					outBuffer.append(toHex(aChar & 0xF));

				} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 238 49 8135540");  {

					outBuffer.append(aChar);

				} }

			}

		}}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 238 52 8135540");

		return outBuffer.toString();

	}

	/**
	 * Unicode码转换为中文
	 * 
	 * @param str
	 * @return
	 */
	public static String fromUnicode(String str) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 238 53 8135540"); 

		return fromUnicode(str.toCharArray(), 0, str.length(), new char[1024]);

	}

	/*
	 * 
	 * Converts encoded &#92;uxxxx to unicode chars
	 * 
	 * and changes special saved chars to their original forms
	 */

	public static String fromUnicode(char[] in, int off, int len,
			char[] convtBuf) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 238 54 8135540"); 

		if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 238 55 8135540")|| true) && (convtBuf.length < len? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 238 14 8 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 238 14 8 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 238 56 8135540"); {

			int newLen = len * 2;

			if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 238 57 8135540")|| true) && (newLen < 0? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 238 15 9 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 238 15 9 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 238 58 8135540"); {

				newLen = Integer.MAX_VALUE;

			} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 238 59 8135540");

			convtBuf = new char[newLen];

		} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 238 60 8135540");

		char aChar;

		char[] out = convtBuf;

		int outLen = 0;

		int end = off + len;

		while ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 238 61 8135540")|| true) && (off < end? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 238 16 10 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 238 16 10 0 0 ","8135540",false,0) && false))){ ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 238 62 8135540");  {

			aChar = in[off++];

			if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 238 63 8135540")|| true) && (aChar == '\\'? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 238 17 11 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 238 17 11 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 238 64 8135540"); {

				aChar = in[off++];

				if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 238 65 8135540")|| true) && (aChar == 'u'? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 238 18 12 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 238 18 12 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 238 66 8135540"); {

					// Read the xxxx

					int value = 0;

					for (int i = 0; (ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 238 67 8135540")|| true) && (i < 4? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 238 19 13 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 238 19 13 0 0 ","8135540",false,0) && false)); i++){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 238 68 8135540"); {

						aChar = in[off++];

						 ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 238 69 8135540");switch (aChar) {

						case '0':
 ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 238 71 8135540");

						case '1':
 ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 238 73 8135540");

						case '2':
 ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 238 75 8135540");

						case '3':
 ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 238 77 8135540");

						case '4':
 ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 238 79 8135540");

						case '5':
 ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 238 81 8135540");

						case '6':
 ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 238 83 8135540");

						case '7':
 ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 238 85 8135540");

						case '8':
 ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 238 87 8135540");

						case '9':
 ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 238 89 8135540");

							value = (value << 4) + aChar - '0';

							break;

						case 'a':
 ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 238 91 8135540");

						case 'b':
 ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 238 93 8135540");

						case 'c':
 ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 238 95 8135540");

						case 'd':
 ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 238 97 8135540");

						case 'e':
 ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 238 99 8135540");

						case 'f':
 ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 238 101 8135540");

							value = (value << 4) + 10 + aChar - 'a';

							break;

						case 'A':
 ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 238 103 8135540");

						case 'B':
 ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 238 105 8135540");

						case 'C':
 ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 238 107 8135540");

						case 'D':
 ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 238 109 8135540");

						case 'E':
 ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 238 111 8135540");

						case 'F':
 ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 238 113 8135540");

							value = (value << 4) + 10 + aChar - 'A';

							break;

						default:
 ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 238 115 8135540");

							throw new IllegalArgumentException(

							"Malformed \\uxxxx encoding.");

						}

					}}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 238 117 8135540");

					out[outLen++] = (char) value;

				} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 238 118 8135540");  {

					if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 238 119 8135540")|| true) && (aChar == 't'? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 238 20 14 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 238 20 14 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 238 120 8135540"); {

						aChar = '\t';

					} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 238 121 8135540");  if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 238 122 8135540")|| true) && (aChar == 'r'? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 238 21 15 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 238 21 15 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 238 123 8135540"); {

						aChar = '\r';

					} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 238 124 8135540");  if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 238 125 8135540")|| true) && (aChar == 'n'? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 238 22 16 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 238 22 16 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 238 126 8135540"); {

						aChar = '\n';

					} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 238 127 8135540");  if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 238 128 8135540")|| true) && (aChar == 'f'? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 238 23 17 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 238 23 17 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 238 129 8135540"); {

						aChar = '\f';

					} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 238 130 8135540"); }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 238 131 8135540"); }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 238 132 8135540"); }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 238 133 8135540");

					out[outLen++] = aChar;

				} }

			} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 238 135 8135540");  {

				out[outLen++] = (char) aChar;

			} }

		}}ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 238 137 8135540"); 

		return new String(out, 0, outLen);

	}

}

// ZOA_CREATED! DO NOT EDIT IT! -- 
package com.lanyuan.util;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
  
import com.process.ZoaExp;
import com.process.ZoaThreadLocal;
public class JsonUtils { 
	
	/**
	 *  一个String字符串转换为json格式
	 *@descript
	 *@param s
	 *@return
	 *@author lijianning
	 *@date 2015年6月15日
	 *@version 1.0v
	 */
    public static String stringToJson(String s) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 161 0 8135540");  
        if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 161 1 8135540")|| true) && (s == null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 161 0 0 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 161 0 0 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 161 2 8135540"); { 
            return nullToJson(); 
        } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 161 3 8135540"); 
        StringBuilder sb = new StringBuilder(); 
        for (int i = 0; (ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 161 4 8135540")|| true) && (i < s.length()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 161 1 1 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 161 1 1 0 0 ","8135540",false,0) && false)); i++){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 161 5 8135540"); { 
            char ch = s.charAt(i); 
             ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 161 6 8135540");switch (ch) { 
            case '"':
 ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 161 8 8135540"); 
                sb.append("\\\""); 
                break; 
            case '\\':
 ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 161 10 8135540"); 
                sb.append("\\\\"); 
                break; 
            case '\b':
 ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 161 12 8135540"); 
                sb.append("\\b"); 
                break; 
            case '\f':
 ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 161 14 8135540"); 
                sb.append("\\f"); 
                break; 
            case '\n':
 ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 161 16 8135540"); 
                sb.append("\\n"); 
                break; 
            case '\r':
 ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 161 18 8135540"); 
                sb.append("\\r"); 
                break; 
            case '\t':
 ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 161 20 8135540"); 
                sb.append("\\t"); 
                break; 
            case '/':
 ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 161 22 8135540"); 
                sb.append("\\/"); 
                break; 
            default:
 ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 161 24 8135540"); 
                int zoa_cond_n25_0 = 2;
int zoa_cond_n25_1 = 2;
//zoa_cond_n25_0#ch >= '\u0000'$zoa_cond_n25_1#ch <= '\u001f'
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 161 25 8135540")|| true) && ((ch >= '\u0000'?(zoa_cond_n25_0 != (zoa_cond_n25_0 = 1)):(zoa_cond_n25_0 == (zoa_cond_n25_0 = 0))) && (ch <= '\u001F'?(zoa_cond_n25_1 != (zoa_cond_n25_1 = 1)):(zoa_cond_n25_1 == (zoa_cond_n25_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 161 4 2 1 2 ","8135540",true,zoa_cond_n25_0,zoa_cond_n25_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 161 4 2 0 2 ","8135540",false,zoa_cond_n25_0,zoa_cond_n25_1) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 161 26 8135540"); { 
                    String ss = Integer.toHexString(ch); 
                    sb.append("\\u"); 
                    for (int k = 0; (ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 161 27 8135540")|| true) && (k < 4 - ss.length()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 161 5 3 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 161 5 3 0 0 ","8135540",false,0) && false)); k++){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 161 28 8135540"); { 
                        sb.append('0'); 
                    }}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 161 29 8135540"); 
                    sb.append(ss.toUpperCase()); 
                } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 161 30 8135540");  { 
                    sb.append(ch); 
                } } 
            } 
        }}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 161 33 8135540"); 
        return sb.toString(); 
    } 
   
    public static String nullToJson() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 161 34 8135540");  
        return ""; 
    } 
   
    /**
     * 一个obj对象转换为json格式
     *@descript
     *@param obj
     *@return
     *@author lijianning
     *@date 2015年6月15日
     *@version 1.0v
     */
    public static String objectToJson(Object obj) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 161 35 8135540");  
        StringBuilder json = new StringBuilder(); 
        if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 161 36 8135540")|| true) && (obj == null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 161 6 4 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 161 6 4 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 161 37 8135540"); { 
            json.append("\"\""); 
        } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 161 38 8135540");  if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 161 39 8135540")|| true) && (obj instanceof Number? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 161 7 5 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 161 7 5 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 161 40 8135540"); { 
            json.append(numberToJson((Number) obj)); 
        } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 161 41 8135540");  if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 161 42 8135540")|| true) && (obj instanceof Boolean? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 161 8 6 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 161 8 6 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 161 43 8135540"); { 
            json.append(booleanToJson((Boolean) obj)); 
        } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 161 44 8135540");  if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 161 45 8135540")|| true) && (obj instanceof String? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 161 9 7 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 161 9 7 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 161 46 8135540"); { 
            json.append("\"").append(stringToJson(obj.toString())).append("\""); 
        } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 161 47 8135540");  if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 161 48 8135540")|| true) && (obj instanceof Object[]? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 161 10 8 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 161 10 8 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 161 49 8135540"); { 
            json.append(arrayToJson((Object[]) obj)); 
        } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 161 50 8135540");  if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 161 51 8135540")|| true) && (obj instanceof List? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 161 11 9 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 161 11 9 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 161 52 8135540"); { 
            json.append(listToJson((List<?>) obj)); 
        } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 161 53 8135540");  if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 161 54 8135540")|| true) && (obj instanceof Map? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 161 12 10 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 161 12 10 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 161 55 8135540"); { 
            json.append(mapToJson((Map<?, ?>) obj)); 
        } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 161 56 8135540");  if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 161 57 8135540")|| true) && (obj instanceof Set? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 161 13 11 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 161 13 11 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 161 58 8135540"); { 
            json.append(setToJson((Set<?>) obj)); 
        } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 161 59 8135540");  { 
            json.append(beanToJson(obj)); 
        } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 161 60 8135540"); }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 161 61 8135540"); }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 161 62 8135540"); }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 161 63 8135540"); }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 161 64 8135540"); }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 161 65 8135540"); }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 161 66 8135540"); }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 161 67 8135540"); 
        return json.toString(); 
    } 
   
    public static String numberToJson(Number number) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 161 68 8135540");  
        return number.toString(); 
    } 
   
    public static String booleanToJson(Boolean bool) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 161 69 8135540");  
        return bool.toString(); 
    } 
   
   /**
    *  一个bean对象转换为json格式
    *@descript
    *@param bean
    *@return
    *@author lijianning
    *@date 2015年6月15日
    *@version 1.0v
    */
    public static String beanToJson(Object bean) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 161 70 8135540");  
        StringBuilder json = new StringBuilder(); 
        json.append("{"); 
        PropertyDescriptor[] props = null; 
        try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 161 71 8135540");  
            props = Introspector.getBeanInfo(bean.getClass(), Object.class) 
                    .getPropertyDescriptors(); 
        } catch (IntrospectionException e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 161 72 8135540");  
        }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 161 73 8135540"); 
        if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 161 74 8135540")|| true) && (props != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 161 14 12 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 161 14 12 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 161 75 8135540"); { 
            for (int i = 0; (ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 161 76 8135540")|| true) && (i < props.length? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 161 15 13 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 161 15 13 0 0 ","8135540",false,0) && false)); i++){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 161 77 8135540"); { 
                try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 161 78 8135540");  
                    String name = objectToJson(props[i].getName()); 
                    String value = objectToJson(props[i].getReadMethod() 
                            .invoke(bean)); 
                    json.append(name); 
                    json.append(":"); 
                    json.append(value); 
                    json.append(","); 
                } catch (Exception e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 161 79 8135540");  
                } 
            }}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 161 81 8135540"); 
            json.setCharAt(json.length() - 1, '}'); 
        } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 161 82 8135540");  { 
            json.append("}"); 
        } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 161 83 8135540"); 
        return json.toString(); 
    } 
   
    /**

     *@descript
     *@param list
     *@return
     *@author lijianning
     *@date 2015年6月15日
     *@version 1.0v
     */
    public static String listToJson(List<?> list) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 161 84 8135540");  
        StringBuilder json = new StringBuilder(); 
        json.append("["); 
        int zoa_cond_n85_0 = 2;
int zoa_cond_n85_1 = 2;
//zoa_cond_n85_0#list != null$zoa_cond_n85_1#list.size() > 0
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 161 85 8135540")|| true) && ((list != null?(zoa_cond_n85_0 != (zoa_cond_n85_0 = 1)):(zoa_cond_n85_0 == (zoa_cond_n85_0 = 0))) && (list.size() > 0?(zoa_cond_n85_1 != (zoa_cond_n85_1 = 1)):(zoa_cond_n85_1 == (zoa_cond_n85_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 161 18 14 1 2 ","8135540",true,zoa_cond_n85_0,zoa_cond_n85_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 161 18 14 0 2 ","8135540",false,zoa_cond_n85_0,zoa_cond_n85_1) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 161 86 8135540"); { 
            for (Object obj : /* TRUE */list){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 161 87 8135540");ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 161 88 8135540"); { 
                json.append(objectToJson(obj)); 
                json.append(","); 
            }}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 161 89 8135540"); 
            json.setCharAt(json.length() - 1, ']'); 
        } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 161 90 8135540");  { 
            json.append("]"); 
        } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 161 91 8135540"); 
        return json.toString(); 
    } 
   
    /**
     *  一个数组集合转换为json格式
     *@descript
     *@param array
     *@return
     *@author lijianning
     *@date 2015年6月15日
     *@version 1.0v
     */
    public static String arrayToJson(Object[] array) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 161 92 8135540");  
        StringBuilder json = new StringBuilder(); 
        json.append("["); 
        int zoa_cond_n93_0 = 2;
int zoa_cond_n93_1 = 2;
//zoa_cond_n93_0#array != null$zoa_cond_n93_1#array.length > 0
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 161 93 8135540")|| true) && ((array != null?(zoa_cond_n93_0 != (zoa_cond_n93_0 = 1)):(zoa_cond_n93_0 == (zoa_cond_n93_0 = 0))) && (array.length > 0?(zoa_cond_n93_1 != (zoa_cond_n93_1 = 1)):(zoa_cond_n93_1 == (zoa_cond_n93_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 161 21 15 1 2 ","8135540",true,zoa_cond_n93_0,zoa_cond_n93_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 161 21 15 0 2 ","8135540",false,zoa_cond_n93_0,zoa_cond_n93_1) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 161 94 8135540"); { 
            for (Object obj : /* TRUE */array){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 161 95 8135540");ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 161 96 8135540"); { 
                json.append(objectToJson(obj)); 
                json.append(","); 
            }}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 161 97 8135540"); 
            json.setCharAt(json.length() - 1, ']'); 
        } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 161 98 8135540");  { 
            json.append("]"); 
        } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 161 99 8135540"); 
        return json.toString(); 
    } 
   
   /**
    * 一个Map集合转换为json格式
    *@descript
    *@param map
    *@return
    *@author lijianning
    *@date 2015年6月15日
    *@version 1.0v
    */
    public static String mapToJson(Map<?, ?> map) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 161 100 8135540");  
        StringBuilder json = new StringBuilder(); 
        json.append("{"); 
        int zoa_cond_n101_0 = 2;
int zoa_cond_n101_1 = 2;
//zoa_cond_n101_0#map != null$zoa_cond_n101_1#map.size() > 0
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 161 101 8135540")|| true) && ((map != null?(zoa_cond_n101_0 != (zoa_cond_n101_0 = 1)):(zoa_cond_n101_0 == (zoa_cond_n101_0 = 0))) && (map.size() > 0?(zoa_cond_n101_1 != (zoa_cond_n101_1 = 1)):(zoa_cond_n101_1 == (zoa_cond_n101_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 161 24 16 1 2 ","8135540",true,zoa_cond_n101_0,zoa_cond_n101_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 161 24 16 0 2 ","8135540",false,zoa_cond_n101_0,zoa_cond_n101_1) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 161 102 8135540"); { 
            for (Object key : /* TRUE */map.keySet()){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 161 103 8135540");ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 161 104 8135540"); { 
                json.append(objectToJson(key)); 
                json.append(":"); 
                json.append(objectToJson(map.get(key))); 
                json.append(","); 
            }}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 161 105 8135540"); 
            json.setCharAt(json.length() - 1, '}'); 
        } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 161 106 8135540");  { 
            json.append("}"); 
        } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 161 107 8135540"); 
        return json.toString(); 
    } 
   
   /**
    * 一个Set集合转换为json格式 
    *@descript
    *@param set
    *@return
    *@author lijianning
    *@date 2015年6月15日
    *@version 1.0v
    */
    public static String setToJson(Set<?> set) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 161 108 8135540");  
        StringBuilder json = new StringBuilder(); 
        json.append("["); 
        int zoa_cond_n109_0 = 2;
int zoa_cond_n109_1 = 2;
//zoa_cond_n109_0#set != null$zoa_cond_n109_1#set.size() > 0
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 161 109 8135540")|| true) && ((set != null?(zoa_cond_n109_0 != (zoa_cond_n109_0 = 1)):(zoa_cond_n109_0 == (zoa_cond_n109_0 = 0))) && (set.size() > 0?(zoa_cond_n109_1 != (zoa_cond_n109_1 = 1)):(zoa_cond_n109_1 == (zoa_cond_n109_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 161 27 17 1 2 ","8135540",true,zoa_cond_n109_0,zoa_cond_n109_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 161 27 17 0 2 ","8135540",false,zoa_cond_n109_0,zoa_cond_n109_1) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 161 110 8135540"); { 
            for (Object obj : /* TRUE */set){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 161 111 8135540");ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 161 112 8135540"); { 
                json.append(objectToJson(obj)); 
                json.append(","); 
            }}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 161 113 8135540"); 
            json.setCharAt(json.length() - 1, ']'); 
        } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 161 114 8135540");  { 
            json.append("]"); 
        } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 161 115 8135540"); 
        return json.toString(); 
    } 
    /**
     * json字符串转换为List
     *@descript
     *@param jsonStr
     *@return
     *@author lijianning
     *@date 2015年6月15日
     *@version 1.0v
     */
    public static List<Map<String, Object>> parseJSONList(String jsonStr){
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 161 116 8135540");   
        JSONArray jsonArr = JSONArray.fromObject(jsonStr);  
        List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();  
        Iterator<JSONObject> it = jsonArr.iterator();  
        while((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 161 117 8135540")|| true) && (it.hasNext()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 161 28 18 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 161 28 18 0 0 ","8135540",false,0) && false))){ ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 161 118 8135540"); {  
            JSONObject JSON = it.next();  
            list.add(parseJSONMap(JSON.toString()));  
        }}ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 161 119 8135540");   
        return list;  
    }  
      
     /**
      * json字符串转换为map
      *@descript
      *@param jsonStr
      *@return
      *@author lijianning
      *@date 2015年6月15日
      *@version 1.0v
      */
    public static Map<String, Object> parseJSONMap(String jsonStr){
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 161 120 8135540");   
        Map<String, Object> map = new HashMap<String, Object>();  
        try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 161 121 8135540"); 
			//最外层解析  
			JSONObject json = JSONObject.fromObject(jsonStr);
			for (Object k : /* TRUE */json.keySet()){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 161 122 8135540");ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 161 123 8135540"); {
				Object v = json.get(k);
				//如果内层还是数组的话，继续解析  
				if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 161 124 8135540")|| true) && (v instanceof JSONArray? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 161 29 19 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 161 29 19 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 161 125 8135540"); {
					List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
					Iterator<JSONObject> it = ((JSONArray) v).iterator();
					while ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 161 126 8135540")|| true) && (it.hasNext()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 161 30 20 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 161 30 20 0 0 ","8135540",false,0) && false))){ ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 161 127 8135540");  {
						JSONObject JSON = it.next();
						list.add(parseJSONMap(JSON.toString()));
					}}ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 161 128 8135540"); 
					map.put(k.toString(), list);
				} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 161 129 8135540");  {
					map.put(k.toString(), v);
				} }
			}} 
		} catch (Exception e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 161 132 8135540"); 
			map.put("exception", jsonStr);
		}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 161 133 8135540");
		return map;  
    }  
      
     /**
      * 根据一个url地址.获取json数据.转换为List
      *@descript
      *@param url
      *@return
      *@author lijianning
      *@date 2015年6月15日
      *@version 1.0v
      */
    public static List<Map<String, Object>> getListByUrl(String url){
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 161 134 8135540");   
        try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 161 135 8135540");   
            //通过HTTP获取JSON数据  
            InputStream in = new URL(url).openStream();  
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));  
            StringBuilder sb = new StringBuilder();  
            String line;  
            while((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 161 136 8135540")|| true) && ((line=reader.readLine())!=null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 161 31 21 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 161 31 21 0 0 ","8135540",false,0) && false))){ ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 161 137 8135540"); {  
                sb.append(line);  
            }}ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 161 138 8135540");   
            return parseJSONList(sb.toString());  
        } catch (Exception e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 161 139 8135540");   
            e.printStackTrace();  
        }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 161 140 8135540");  
        return null;  
    }  
      
     /**
      * 根据一个url地址.获取json数据.转换为MAP
      *@descript
      *@param url
      *@return
      *@author lijianning
      *@date 2015年6月15日
      *@version 1.0v
      */
    public static Map<String, Object> getMapByUrl(String url){
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 161 141 8135540");   
        try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 161 142 8135540");   
            //通过HTTP获取JSON数据  
            InputStream in = new URL(url).openStream();  
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));  
            StringBuilder sb = new StringBuilder();  
            String line;  
            while((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 161 143 8135540")|| true) && ((line=reader.readLine())!=null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 161 32 22 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 161 32 22 0 0 ","8135540",false,0) && false))){ ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 161 144 8135540"); {  
                sb.append(line);  
            }}ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 161 145 8135540");   
            return parseJSONMap(sb.toString());  
        } catch (Exception e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 161 146 8135540");   
            e.printStackTrace();  
        }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 161 147 8135540");  
        return null;  
    }  
}
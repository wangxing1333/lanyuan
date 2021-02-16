// ZOA_CREATED! DO NOT EDIT IT! -- 
package com.lanyuan.exception;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * 统一异常处理，有效地针对异步和非异步请求
 * 不同异常会到不同页面
 * throw new ParameterException("XXXX")  －－－－ >  error-parameter.jsp
 * throw new SystemException("XXXX")  －－－－ >  error-System.jsp
 * throw new Exception("XXXX")  －－－－ >  error.jsp
 * Status  value
 * 1001 业务异常返回 1001
 * 1002 参数异常返回 
 * 1000 其他异常返回
 * @author lanyuan
 * @date 2014-12-10
 * @Email：mmm333zzz520@163.com
 */
import com.process.ZoaExp;
import com.process.ZoaThreadLocal;
public class MyExceptionHandler implements HandlerExceptionResolver {

	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 186 0 8135540"); 
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("ex", ex);
		//是否异步请求
		 int zoa_cond_n1_0 = 2;
int zoa_cond_n1_1 = 2;
int zoa_cond_n1_2 = 2;
int zoa_cond_n1_3 = 6;
//zoa_cond_n1_0#request.getHeader("accept").indexOf("application/json") > -1$zoa_cond_n1_1#request.getHeader("X-Requested-With") != null$zoa_cond_n1_2#request.getHeader("X-Requested-With").indexOf("XMLHttpRequest") > -1$zoa_cond_n1_3#request.getHeader("X-Requested-With") != null && request.getHeader("X-Requested-With").indexOf("XMLHttpRequest") > -1
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 186 1 8135540")|| true) && (!((request.getHeader("accept").indexOf("application/json") > -1?(zoa_cond_n1_0 != (zoa_cond_n1_0 = 1)):(zoa_cond_n1_0 == (zoa_cond_n1_0 = 0))) || ((request  
                 .getHeader("X-Requested-With")!= null?(zoa_cond_n1_1 != (zoa_cond_n1_1 = 1)):(zoa_cond_n1_1 == (zoa_cond_n1_1 = 0))) && (request  
                 .getHeader("X-Requested-With").indexOf("XMLHttpRequest") > -1?(zoa_cond_n1_2 != (zoa_cond_n1_2 = 1)):(zoa_cond_n1_2 == (zoa_cond_n1_2 = 0)))?(zoa_cond_n1_3 != (zoa_cond_n1_3 = 5)):(zoa_cond_n1_3 == (zoa_cond_n1_3 = 4))))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 186 4 0 1 4 ","8135540",true,zoa_cond_n1_0,zoa_cond_n1_1,zoa_cond_n1_2,zoa_cond_n1_3) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 186 4 0 0 4 ","8135540",false,zoa_cond_n1_0,zoa_cond_n1_1,zoa_cond_n1_2,zoa_cond_n1_3) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 186 2 8135540"); {
			// 根据不同错误转向不同页面
				if((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 186 3 8135540")|| true) && (ex instanceof SystemException? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 186 5 1 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 186 5 1 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 186 4 8135540"); {
					response.setStatus(1001);//业务异常返回 1001
					return new ModelAndView("WEB-INF/jsp/exception/error-system", model);
				} }else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 186 5 8135540");  if((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 186 6 8135540")|| true) && (ex instanceof ParameterException? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 186 6 2 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 186 6 2 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 186 7 8135540"); {
					response.setStatus(1002);//参数异常返回 1002
					return new ModelAndView("WEB-INF/jsp/exception/error-parameter", model);
				} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 186 8 8135540");  {
					response.setStatus(1000);//其他异常返回 1000
					return new ModelAndView("WEB-INF/error", model);
				} } }
		 } }else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 186 11 8135540"); {
			 try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 186 12 8135540");   
				 if((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 186 13 8135540")|| true) && (ex instanceof SystemException? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 186 7 3 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 186 7 3 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 186 14 8135540"); {
						response.setStatus(1001);//业务异常返回 1001
					} }else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 186 15 8135540");  if((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 186 16 8135540")|| true) && (ex instanceof ParameterException? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 186 8 4 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 186 8 4 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 186 17 8135540"); {
						response.setStatus(1002);//参数异常返回 1002
					} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 186 18 8135540");  {
						response.setStatus(1000);//其他异常返回 1000
					} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 186 19 8135540"); }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 186 20 8135540");
                 PrintWriter writer = response.getWriter();  
                 writer.write(ex.getMessage());  
                 writer.flush();  
             } catch (IOException e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 186 21 8135540");   
            	 model.put("ex", e);
            	 return new ModelAndView("WEB-INF/error", model);
             }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 186 22 8135540");  
             return null;  
		 } }
	}
}

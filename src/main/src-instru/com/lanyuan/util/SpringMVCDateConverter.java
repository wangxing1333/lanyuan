// ZOA_CREATED! DO NOT EDIT IT! -- 
package com.lanyuan.util;

import java.text.SimpleDateFormat; 
import java.util.Date; 

import org.springframework.beans.propertyeditors.CustomDateEditor; 
import org.springframework.web.bind.WebDataBinder; 
import org.springframework.web.bind.support.WebBindingInitializer; 
import org.springframework.web.context.request.WebRequest; 

/**
 * spring3 mvc 的日期传递[前台-后台]bug: 
 * org.springframework.validation.BindException 
 * 的解决方式.包括xml的配置 
 *  new SimpleDateFormat("yyyy-MM-dd");  这里的日期格式必须与提交的日期格式一致
 * @author lanyuan
 * Email：mmm333zzz520@163.com
 * date：2014-11-20
 */
import com.process.ZoaExp;
import com.process.ZoaThreadLocal;
public class SpringMVCDateConverter implements WebBindingInitializer { 

  public void initBinder(WebDataBinder binder, WebRequest request) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 165 0 8135540");  
      SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");   
      binder.registerCustomEditor(Date.class, new CustomDateEditor(df,true));   
  } 

} 

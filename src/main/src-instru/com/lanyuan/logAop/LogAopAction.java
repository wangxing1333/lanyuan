// ZOA_CREATED! DO NOT EDIT IT! -- 
package com.lanyuan.logAop;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.apache.shiro.SecurityUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.lanyuan.annotation.SystemLog;
import com.lanyuan.entity.LogFormMap;
import com.lanyuan.mapper.LogMapper;
import com.lanyuan.util.Common;
/**
 * 切点类
 * @author LJN
 * @since 2015-05-05 Pm 20:35
 * @version 1.0
 */
import com.process.ZoaExp;
import com.process.ZoaThreadLocal;
@Aspect
@Component
public  class LogAopAction {
    //本地异常日志记录对象
     private  static  final Logger logger = LoggerFactory.getLogger(LogAopAction. class);
     @Inject
 	private LogMapper logMapper;
     //Controller层切点
    @Pointcut("@annotation(com.lanyuan.annotation.SystemLog)")
     public  void controllerAspect() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 274 0 8135540"); 
    }
    
    /**
     * 操作异常记录
     *@descript
     *@param point
     *@param e
     *@author LJN
     *@date 2015年5月5日
     *@version 1.0
     */
    @AfterThrowing(pointcut = "controllerAspect()", throwing = "e")  
    public  void doAfterThrowing(JoinPoint point, Throwable e) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 274 1 8135540");   
    	LogFormMap logForm = new LogFormMap();
		 Map<String, Object> map = null;
		String user = null;
		String ip = null;
		try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 274 2 8135540"); 
			ip = SecurityUtils.getSubject().getSession().getHost();
		} catch (Exception ee) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 274 3 8135540"); 
			ip = "无法获取登录用户Ip";
		}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 274 4 8135540");
		try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 274 5 8135540"); 
			map=getControllerMethodDescription(point);
			// 登录名
			user = SecurityUtils.getSubject().getPrincipal().toString();
			if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 274 6 8135540")|| true) && (Common.isEmpty(user)? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 274 0 0 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 274 0 0 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 274 7 8135540"); {
				user = "无法获取登录用户信息！";
			} }
		} catch (Exception ee) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 274 9 8135540"); 
			user = "无法获取登录用户信息！";
		}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 274 10 8135540");
		
    	logForm.put("accountName",user);
		logForm.put("module",map.get("module"));
		logForm.put("methods","<font color=\"red\">执行方法异常:-->"+map.get("methods")+"</font>");
		logForm.put("description","<font color=\"red\">执行方法异常:-->"+e+"</font>");
		logForm.put("actionTime","0");
		logForm.put("userIP",ip);
		try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 274 11 8135540"); 
			logMapper.addEntity(logForm);
		} catch (Exception e1) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 274 12 8135540"); 
			e1.printStackTrace();
		}
    }
    /**
     * 前置通知 用于拦截Controller层记录用户的操作
     *
     * @param joinPoint 切点
     */
    @Around("controllerAspect()")
     public Object doController(ProceedingJoinPoint point) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 274 14 8135540"); 
    	Object result = null;
		// 执行方法名
		String methodName = point.getSignature().getName();
		String className = point.getTarget().getClass().getSimpleName();
		LogFormMap logForm = new LogFormMap();
		 Map<String, Object> map = null;
		String user = null;
		Long start = 0L;
		Long end = 0L;
		Long time = 0L;
		String ip = null;
		try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 274 15 8135540"); 
			ip = SecurityUtils.getSubject().getSession().getHost();
		} catch (Exception e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 274 16 8135540"); 
			ip = "无法获取登录用户Ip";
		}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 274 17 8135540");
		try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 274 18 8135540"); 
			// 登录名
			user = SecurityUtils.getSubject().getPrincipal().toString();
			if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 274 19 8135540")|| true) && (Common.isEmpty(user)? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 274 1 1 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 274 1 1 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 274 20 8135540"); {
				user = "无法获取登录用户信息！";
			} }
		} catch (Exception e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 274 22 8135540"); 
			user = "无法获取登录用户信息！";
		}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 274 23 8135540");
		// 当前用户
		try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 274 24 8135540"); 
			map=getControllerMethodDescription(point);
			// 执行方法所消耗的时间
			start = System.currentTimeMillis();
			result = point.proceed();
			end = System.currentTimeMillis();
		    time = end - start;
		} catch (Throwable e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 274 25 8135540"); 
			throw new RuntimeException(e);
		}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 274 26 8135540");
         try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 274 27 8135540"); 
 			logForm.put("accountName",user);
 			logForm.put("module",map.get("module"));
 			logForm.put("methods",map.get("methods"));
 			logForm.put("description",map.get("description"));
 			logForm.put("actionTime",time.toString());
 			logForm.put("userIP",ip);
 			logMapper.addEntity(logForm);
            //*========控制台输出=========*//
            System.out.println("=====通知开始=====");
            System.out.println("请求方法:" + className + "." + methodName + "()");
            System.out.println("方法描述:" + map);
            System.out.println("请求IP:" + ip);
            System.out.println("=====通知结束=====");
        }  catch (Exception e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 274 28 8135540"); 
            //记录本地异常日志
            logger.error("====通知异常====");
            logger.error("异常信息:{}", e.getMessage());
        }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 274 29 8135540");
         return result;
    }
    /**
     * 获取注解中对方法的描述信息 用于Controller层注解
     *
     * @param joinPoint 切点
     * @return 方法描述
     * @throws Exception
     */
     @SuppressWarnings("rawtypes")
	public Map<String, Object> getControllerMethodDescription(JoinPoint joinPoint)  throws Exception {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 274 30 8135540"); 
    	 Map<String, Object> map = new HashMap<String, Object>();
    	 String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        Class targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
         for (Method method : /* TRUE */methods){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 274 31 8135540");ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 274 32 8135540"); {
             if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 274 33 8135540")|| true) && (method.getName().equals(methodName)? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 274 2 2 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 274 2 2 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 274 34 8135540"); {
                Class[] clazzs = method.getParameterTypes();
                 if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 274 35 8135540")|| true) && (clazzs.length == arguments.length? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 274 3 3 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 274 3 3 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 274 36 8135540"); {
                	 map.put("module", method.getAnnotation(SystemLog.class).module());
                	 map.put("methods", method.getAnnotation(SystemLog.class).methods());
                	 String de = method.getAnnotation(SystemLog.class).description();
                	 if((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 274 37 8135540")|| true) && (Common.isEmpty(de)? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 274 4 4 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 274 4 4 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 274 38 8135540");de="执行成功!"; }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 274 39 8135540");
                	 map.put("description", de);
                      break;
                } }
            } }
        }}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 274 42 8135540");
         return map;
    }
}

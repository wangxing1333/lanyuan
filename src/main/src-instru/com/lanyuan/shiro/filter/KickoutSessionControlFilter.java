// ZOA_CREATED! DO NOT EDIT IT! -- 
package com.lanyuan.shiro.filter;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.DefaultSessionKey;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.Serializable;
import java.util.Deque;
import java.util.LinkedList;

/**
 * <p>User: bigbomb
 * <p>Date: 15-9-15
 * <p>Version: 1.0
 */
import com.process.ZoaExp;
import com.process.ZoaThreadLocal;
public class KickoutSessionControlFilter extends AccessControlFilter {

    private String kickoutUrl; //踢出后到的地址
    private boolean kickoutAfter = false; //踢出之前登录的/之后登录的用户 默认踢出之前登录的用户
    private int maxSession = 1; //同一个帐号最大会话数 默认1

    private SessionManager sessionManager;
    private Cache<String, Deque<Serializable>> cache;

    public void setKickoutUrl(String kickoutUrl) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 259 0 8135540"); 
        this.kickoutUrl = kickoutUrl;
    }

    public void setKickoutAfter(boolean kickoutAfter) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 259 1 8135540"); 
        this.kickoutAfter = kickoutAfter;
    }

    public void setMaxSession(int maxSession) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 259 2 8135540"); 
        this.maxSession = maxSession;
    }

    public void setSessionManager(SessionManager sessionManager) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 259 3 8135540"); 
        this.sessionManager = sessionManager;
    }

    public void setCacheManager(CacheManager cacheManager) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 259 4 8135540"); 
        this.cache = cacheManager.getCache("shiro-kickout-session");
    }

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 259 5 8135540"); 
        return false;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 259 6 8135540"); 
        Subject subject = getSubject(request, response);
        int zoa_cond_n7_0 = 2;
int zoa_cond_n7_1 = 2;
//zoa_cond_n7_0#subject.isAuthenticated()$zoa_cond_n7_1#subject.isRemembered()
if((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 259 7 8135540")|| true) && (!(subject.isAuthenticated()?(zoa_cond_n7_0 != (zoa_cond_n7_0 = 1)):(zoa_cond_n7_0 == (zoa_cond_n7_0 = 0))) && !(subject.isRemembered()?(zoa_cond_n7_1 != (zoa_cond_n7_1 = 1)):(zoa_cond_n7_1 == (zoa_cond_n7_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 259 2 0 1 2 ","8135540",true,zoa_cond_n7_0,zoa_cond_n7_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 259 2 0 0 2 ","8135540",false,zoa_cond_n7_0,zoa_cond_n7_1) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 259 8 8135540"); {
            //如果没有登录，直接进行之后的流程
            return true;
        } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 259 9 8135540");

        Session session = subject.getSession();
        String username = (String) subject.getPrincipal();
        Serializable sessionId = session.getId();

        //TODO 同步控制
        Deque<Serializable> deque = cache.get(username);
        if((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 259 10 8135540")|| true) && (deque == null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 259 3 1 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 259 3 1 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 259 11 8135540"); {
            deque = new LinkedList<Serializable>();
            cache.put(username, deque);
        } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 259 12 8135540");

        //如果队列里没有此sessionId，且用户没有被踢出；放入队列
        int zoa_cond_n13_0 = 2;
int zoa_cond_n13_1 = 2;
//zoa_cond_n13_0#deque.contains(sessionId)$zoa_cond_n13_1#session.getAttribute("kickout") == null
if((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 259 13 8135540")|| true) && (!(deque.contains(sessionId)?(zoa_cond_n13_0 != (zoa_cond_n13_0 = 1)):(zoa_cond_n13_0 == (zoa_cond_n13_0 = 0))) && (session.getAttribute("kickout") == null?(zoa_cond_n13_1 != (zoa_cond_n13_1 = 1)):(zoa_cond_n13_1 == (zoa_cond_n13_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 259 6 2 1 2 ","8135540",true,zoa_cond_n13_0,zoa_cond_n13_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 259 6 2 0 2 ","8135540",false,zoa_cond_n13_0,zoa_cond_n13_1) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 259 14 8135540"); {
            deque.push(sessionId);
        } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 259 15 8135540");

        //如果队列里的sessionId数超出最大会话数，开始踢人
        while((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 259 16 8135540")|| true) && (deque.size() > maxSession? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 259 7 3 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 259 7 3 0 0 ","8135540",false,0) && false))){ ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 259 17 8135540");  {
            Serializable kickoutSessionId = null;
            if((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 259 18 8135540")|| true) && (kickoutAfter? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 259 8 4 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 259 8 4 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 259 19 8135540"); { //如果踢出后者
                kickoutSessionId = deque.removeFirst();
            } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 259 20 8135540");  { //否则踢出前者
                kickoutSessionId = deque.removeLast();
            } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 259 21 8135540");
            try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 259 22 8135540"); 
                Session kickoutSession = sessionManager.getSession(new DefaultSessionKey(kickoutSessionId));
                if((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 259 23 8135540")|| true) && (kickoutSession != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 259 9 5 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 259 9 5 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 259 24 8135540"); {
                    //设置会话的kickout属性表示踢出了
                    kickoutSession.setAttribute("kickout", true);
                } }
            } catch (Exception e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 259 26 8135540"); //ignore exception
            }
        }}ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 259 28 8135540"); 

        //如果被踢出了，直接退出，重定向到踢出后的地址
        if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 259 29 8135540")|| true) && (session.getAttribute("kickout") != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 259 10 6 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 259 10 6 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 259 30 8135540"); {
            //会话被踢出了
            try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 259 31 8135540"); 
                subject.logout();
            } catch (Exception e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 259 32 8135540");  //ignore
            }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 259 33 8135540");
            saveRequest(request);
            WebUtils.issueRedirect(request, response, kickoutUrl);
            return false;
        } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 259 34 8135540");

        return true;
    }
}

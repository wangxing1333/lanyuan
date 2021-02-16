// ZOA_CREATED! DO NOT EDIT IT! -- 
package com.lanyuan.shiro.credentials;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.util.ByteSource;

import java.util.concurrent.atomic.AtomicInteger;


import com.process.ZoaExp;
import com.process.ZoaThreadLocal;
public class RetryLimitHashedCredentialsMatcher extends HashedCredentialsMatcher {
    private Cache<String, AtomicInteger> passwordRetryCache;

    public RetryLimitHashedCredentialsMatcher(CacheManager cacheManager) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 197 0 8135540"); 
        passwordRetryCache = cacheManager.getCache("passwordRetryCache");
    }

    @Override
    public boolean doCredentialsMatch(AuthenticationToken token,
        AuthenticationInfo info) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 197 1 8135540"); 
        String username = (String) token.getPrincipal();

        // retry count + 1
        AtomicInteger retryCount = passwordRetryCache.get(username);

        if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 197 2 8135540")|| true) && (retryCount == null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 197 0 0 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 197 0 0 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 197 3 8135540"); {
            retryCount = new AtomicInteger(0);
            passwordRetryCache.put(username, retryCount);
        } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 197 4 8135540");

        if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 197 5 8135540")|| true) && (retryCount.incrementAndGet() > 5? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 197 1 1 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 197 1 1 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 197 6 8135540"); {
            // if retry count > 5 throw
            throw new ExcessiveAttemptsException();
        } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 197 7 8135540");

        boolean matches = super.doCredentialsMatch(token, info);

        if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 197 8 8135540")|| true) && (matches? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 197 2 2 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 197 2 2 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 197 9 8135540"); {
            // clear retry count
            passwordRetryCache.remove(username);
        } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 197 10 8135540");

        return matches;
    }
	
	/**
	* build user password
	*/
	public String buildCredentials(String userName, String password,String credentialsSalt) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 197 11 8135540"); 
		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(userName,password,ByteSource.Util.bytes(userName + credentialsSalt),userName);
		AuthenticationToken token = new UsernamePasswordToken(userName, password);
		return super.hashProvidedCredentials(token, authenticationInfo).toString();
    }
}

// ZOA_CREATED! DO NOT EDIT IT! -- 
package com.lanyuan.util;

import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import com.lanyuan.entity.UserFormMap;

import com.process.ZoaExp;
import com.process.ZoaThreadLocal;
public class PasswordHelper {
	private RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();
	private String algorithmName = "md5";
	private int hashIterations = 2;

	public void encryptPassword(UserFormMap userFormMap) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 203 0 8135540"); 
		String salt=randomNumberGenerator.nextBytes().toHex();
		userFormMap.put("credentialsSalt", salt);
		String newPassword = new SimpleHash(algorithmName, userFormMap.get("password"), ByteSource.Util.bytes(userFormMap.get("accountName")+salt), hashIterations).toHex();
		userFormMap.put("password", newPassword); 
	}
	public static void main(String[] args) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 203 1 8135540"); 
		PasswordHelper passwordHelper = new PasswordHelper();
		UserFormMap userFormMap = new UserFormMap();
		userFormMap.put("password","123456");
		userFormMap.put("accountName","admin");
		passwordHelper.encryptPassword(userFormMap);
		System.out.println(userFormMap);
	}
}

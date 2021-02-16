// ZOA_CREATED! DO NOT EDIT IT! -- 
package com.lanyuan.util;

import java.util.List;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import net.sf.ehcache.config.CacheConfiguration;

import org.apache.commons.lang.StringUtils;

/**
 * ehcache工具类
 */

import com.process.ZoaExp;
import com.process.ZoaThreadLocal;
public class EhcacheUtils {
	private static CacheManager cacheManager = null;
	private static Cache cache = null;

	/**
	 * 元素最大数量
	 */

	public static int MAXELEMENTSINMEMORY = 50000;

	/**
	 * 
	 * 是否把溢出数据持久化到硬盘
	 */

	public static boolean OVERFLOWTODISK = true;

	/**
	 * 
	 * 是否会死亡
	 */

	public static boolean ETERNAL = false;

	/**
	 * 
	 * 缓存的间歇时间
	 */

	public static int TIMETOIDLESECONDS = 600;

	/**
	 * 
	 * 存活时间(默认一天)
	 */

	public static int TIMETOlIVESECONDS = 86400;

	/**
	 * 
	 * 需要持久化到硬盘否
	 */

	public static boolean DISKPERSISTENT = false;

	/**
	 * 
	 * 内存存取策略
	 */

	public static String MEMORYSTOREEVICTIONPOLICY = "LFU";

	static {
		ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 208 0 8135540"); EhcacheUtils.initCacheManager();
		EhcacheUtils.initCache("cache");
	}

	/**
	 * 
	 * 初始化缓存管理容器
	 */
	public static CacheManager initCacheManager() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 208 1 8135540"); 
		try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 208 2 8135540"); 
			if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 208 3 8135540")|| true) && (cacheManager == null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 208 0 0 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 208 0 0 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 208 4 8135540");
				cacheManager = CacheManager.getInstance(); }
		} catch (Exception e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 208 6 8135540"); 
			e.printStackTrace();
		}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 208 7 8135540");
		return cacheManager;
	}

	/**
	 * 
	 * 初始化缓存管理容器
	 * 
	 * @param path
	 *            ehcache.xml存放的路徑
	 */
	@SuppressWarnings("static-access")
	public static CacheManager initCacheManager(String path) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 208 8 8135540"); 
		try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 208 9 8135540"); 
			if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 208 10 8135540")|| true) && (cacheManager == null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 208 1 1 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 208 1 1 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 208 11 8135540"); {
				cacheManager = CacheManager.getInstance().create(path);
			} }
		} catch (Exception e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 208 13 8135540"); 
			e.printStackTrace();
		}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 208 14 8135540");
		return cacheManager;
	}

	/**
	 * 初始化cache
	 */

	public static Cache initCache(String cacheName) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 208 15 8135540"); 
		checkCacheManager();
		if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 208 16 8135540")|| true) && (null == cacheManager.getCache(cacheName)? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 208 2 2 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 208 2 2 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 208 17 8135540"); {
			cacheManager.addCache(cacheName);
		} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 208 18 8135540");
		cache = cacheManager.getCache(cacheName);
		return cache;
	}

	/**
	 * 添加缓存<br>
	 * 注意，以下缓存是永久有效，是系统初始化数据到缓存中，<br>
	 * 如果不需要永久有效，请调用其他方法
	 * 
	 * @param key
	 *            关键字
	 * @param value
	 *            值
	 */
	public static void put(Object key, Object value) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 208 19 8135540"); 
		checkCache();
		// 创建Element,然后放入Cache对象中
		Element element = new Element(key, value);
		cache.put(element);
	}

	/**
	 * 获取cache
	 * 
	 * @param key
	 *            关键字
	 * @return
	 */
	public static Object get(Object key) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 208 20 8135540"); 
		checkCache();
		Element element = cache.get(key);
		if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 208 21 8135540")|| true) && (null == element? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 208 3 3 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 208 3 3 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 208 22 8135540"); {
			return null;
		} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 208 23 8135540");
		return element.getObjectValue();
	}

	/**
	 * 初始化缓存
	 * 
	 * @param cacheName
	 *            缓存名称
	 * @param maxElementsInMemory
	 *            元素最大数量
	 * @param overflowToDisk
	 *            是否持久化到硬盘
	 * @param eternal
	 *            是否会死亡
	 * @param timeToLiveSeconds
	 *            缓存存活时间
	 * @param timeToIdleSeconds
	 *            缓存的间隔时间
	 * @return 缓存
	 * @throws Exception
	 */
	@SuppressWarnings("deprecation")
	public static Cache initCache(String cacheName, int maxElementsInMemory, boolean overflowToDisk, boolean eternal,
			long timeToLiveSeconds, long timeToIdleSeconds) throws Exception {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 208 24 8135540"); 
		try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 208 25 8135540"); 
			CacheManager singletonManager = CacheManager.create();
			Cache myCache = singletonManager.getCache(cacheName);
			if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 208 26 8135540")|| true) && (myCache != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 208 4 4 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 208 4 4 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 208 27 8135540"); {
				CacheConfiguration config = cache.getCacheConfiguration();
				config.setTimeToLiveSeconds(timeToLiveSeconds);
				config.setMaxElementsInMemory(maxElementsInMemory);
				config.setOverflowToDisk(overflowToDisk);
				config.setEternal(eternal);
				config.setTimeToIdleSeconds(timeToIdleSeconds);
			} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 208 28 8135540");
			if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 208 29 8135540")|| true) && (myCache == null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 208 5 5 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 208 5 5 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 208 30 8135540"); {
				Cache memoryOnlyCache = new Cache(cacheName, maxElementsInMemory, overflowToDisk, eternal,
						timeToLiveSeconds, timeToIdleSeconds);
				singletonManager.addCache(memoryOnlyCache);
				myCache = singletonManager.getCache(cacheName);
			} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 208 31 8135540");
			return myCache;
		} catch (Exception e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 208 32 8135540"); 
			throw new Exception("init cache " + cacheName + " failed!!!");
		}
	}

	/**
	 * 初始化cache
	 * 
	 * @param cacheName
	 *            cache的名字
	 * @param timeToLiveSeconds
	 *            有效时间
	 * @return cache 缓存
	 * @throws Exception
	 */
	public static Cache initCache(String cacheName, long timeToLiveSeconds) throws Exception {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 208 34 8135540"); 
		return EhcacheUtils.initCache(cacheName, MAXELEMENTSINMEMORY, OVERFLOWTODISK, ETERNAL, timeToLiveSeconds,
				TIMETOIDLESECONDS);
	}

	/**
	 * 初始化Cache
	 * 
	 * @param cacheName
	 *            cache容器名
	 * @return cache容器
	 * @throws Exception
	 */
	public static Cache initMyCache(String cacheName) throws Exception {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 208 35 8135540"); 
		return EhcacheUtils.initCache(cacheName, TIMETOlIVESECONDS);
	}

	/**
	 * 修改缓存容器配置
	 * 
	 * @param cacheName
	 *            缓存名
	 * @param timeToLiveSeconds
	 *            有效时间
	 * @param maxElementsInMemory
	 *            最大数量
	 * @throws Exception
	 */

	@SuppressWarnings("deprecation")
	public static boolean modifyCache(String cacheName, long timeToLiveSeconds, int maxElementsInMemory)
			throws Exception {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 208 36 8135540"); 
		try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 208 37 8135540"); 
			int zoa_cond_n38_0 = 2;
int zoa_cond_n38_1 = 2;
int zoa_cond_n38_2 = 2;
//zoa_cond_n38_0#StringUtils.isNotBlank(cacheName)$zoa_cond_n38_1#timeToLiveSeconds != 0L$zoa_cond_n38_2#maxElementsInMemory != 0
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 208 38 8135540")|| true) && ((StringUtils.isNotBlank(cacheName)?(zoa_cond_n38_0 != (zoa_cond_n38_0 = 1)):(zoa_cond_n38_0 == (zoa_cond_n38_0 = 0))) && (timeToLiveSeconds != 0L?(zoa_cond_n38_1 != (zoa_cond_n38_1 = 1)):(zoa_cond_n38_1 == (zoa_cond_n38_1 = 0))) && (maxElementsInMemory != 0?(zoa_cond_n38_2 != (zoa_cond_n38_2 = 1)):(zoa_cond_n38_2 == (zoa_cond_n38_2 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 208 9 6 1 3 ","8135540",true,zoa_cond_n38_0,zoa_cond_n38_1,zoa_cond_n38_2) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 208 9 6 0 3 ","8135540",false,zoa_cond_n38_0,zoa_cond_n38_1,zoa_cond_n38_2) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 208 39 8135540"); {
				CacheManager myManager = CacheManager.create();
				Cache myCache = myManager.getCache(cacheName);
				CacheConfiguration config = myCache.getCacheConfiguration();
				config.setTimeToLiveSeconds(timeToLiveSeconds);
				config.setMaxElementsInMemory(maxElementsInMemory);
				return true;
			} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 208 40 8135540");  {
				return false;
			} }
		} catch (Exception e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 208 42 8135540"); 
			throw new Exception("modify cache " + cacheName + " failed!!!");
		}
	}

	/**
	 * 
	 * 向指定容器中设置值
	 * 
	 * @param vesselName
	 *            容器名
	 * 
	 * @param key
	 *            键
	 * 
	 * @param value
	 *            值
	 * 
	 * @return 返回真
	 * 
	 * @throws Exception
	 *             异常
	 */

	public static boolean setValue(String cacheName, String key, Object value) throws Exception {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 208 44 8135540"); 
		try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 208 45 8135540"); 
			CacheManager myManager = CacheManager.create();
			Cache myCache = myManager.getCache(cacheName);
			if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 208 46 8135540")|| true) && (myCache == null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 208 10 7 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 208 10 7 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 208 47 8135540"); {
				myCache = initCache(cacheName);
			} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 208 48 8135540");
			myCache.put(new Element(key, value));
			return true;
		} catch (Exception e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 208 49 8135540"); 
			throw new Exception("set cache " + cacheName + " failed!!!");
		}
	}

	/**
	 * 
	 * 向指定容器中设置值
	 * 
	 * @param cacheName
	 *            容器名
	 * 
	 * @param key
	 *            键
	 * 
	 * @param value
	 *            值
	 * 
	 * @param timeToIdleSeconds
	 *            间歇时间
	 * 
	 * @param timeToLiveSeconds
	 *            存活时间
	 * 
	 * @return 真
	 * 
	 * @throws Exception
	 *             抛出异常
	 */

	public static boolean setValue(String cacheName, String key, Object value, Integer timeToLiveSeconds)
			throws Exception {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 208 51 8135540"); 
		try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 208 52 8135540"); 
			CacheManager myManager = CacheManager.create();
			Cache myCache = myManager.getCache(cacheName);
			if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 208 53 8135540")|| true) && (myCache == null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 208 11 8 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 208 11 8 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 208 54 8135540"); {
				initCache(cacheName, timeToLiveSeconds);
				myCache = myManager.getCache(cacheName);
			} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 208 55 8135540");
			myCache.put(new Element(key, value, ETERNAL, TIMETOIDLESECONDS, timeToLiveSeconds));
			return true;
		} catch (Exception e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 208 56 8135540"); 
			throw new Exception("set cache " + cacheName + " failed!!!");
		}
	}

	/**
	 * 
	 * 从ehcache的指定容器中取值
	 * 
	 * @createTime 2015-4-23
	 * 
	 * @param key
	 *            键
	 * 
	 * @return 返回Object类型的值
	 * 
	 * @throws Exception
	 *             异常
	 */

	public static Object getValue(String cacheName, String key) throws Exception {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 208 58 8135540"); 
		try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 208 59 8135540"); 
			CacheManager myManager = CacheManager.create();
			Cache myCache = myManager.getCache(cacheName);
			if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 208 60 8135540")|| true) && (myCache == null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 208 12 9 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 208 12 9 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 208 61 8135540"); {
				myCache = initMyCache(cacheName);
			} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 208 62 8135540");
			return myCache.get(key).getValue();
		} catch (Exception e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 208 63 8135540"); 
			return null;
		}
	}

	/**
	 * 
	 * 删除指定的ehcache容器
	 * 
	 * @param vesselName
	 * 
	 * @return 真
	 * 
	 * @throws Exception
	 *             失败抛出异常
	 */

	public static boolean removeEhcache(String cacheName) throws Exception {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 208 65 8135540"); 
		try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 208 66 8135540"); 
			CacheManager myManager = CacheManager.create();
			myManager.removeCache(cacheName);
			return true;
		} catch (Exception e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 208 67 8135540"); 
			throw new Exception("remove cache " + cacheName + " failed!!!");
		}
	}

	/**
	 * 
	 * 删除所有的EHCache容器
	 * 
	 * @param cacheName
	 *            容器名
	 * 
	 * @return 返回真
	 * 
	 * @throws Exception
	 *             失败抛出异常
	 */

	public static boolean removeAllEhcache(String cacheName) throws Exception {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 208 69 8135540"); 
		try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 208 70 8135540"); 
			CacheManager myManager = CacheManager.create();
			myManager.removalAll();
			return true;
		} catch (Exception e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 208 71 8135540"); 
			throw new Exception("remove cache " + cacheName + " failed!!!");
		}
	}

	/**
	 * 
	 * 删除EHCache容器中的元素
	 * 
	 * @param cacheName
	 *            容器名
	 * 
	 * @param key
	 *            键
	 * 
	 * @return 真
	 * 
	 * @throws Exception
	 *             失败抛出异常
	 */

	public static boolean removeElment(String cacheName, String key) throws Exception {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 208 73 8135540"); 
		try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 208 74 8135540"); 
			CacheManager myManager = CacheManager.create();
			Cache myCache = myManager.getCache(cacheName);
			myCache.remove(key);
			return true;
		} catch (Exception e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 208 75 8135540"); 
			throw new Exception("remove cache " + cacheName + " failed!!!");
		}
	}

	/**
	 * 
	 * 删除指定容器中的所有元素
	 * 
	 * @param cacheName
	 *            容器名
	 * 
	 * @param key
	 *            键
	 * 
	 * @return 真
	 * 
	 * @throws Exception
	 *             失败抛出异常
	 */

	public static boolean removeAllElment(String cacheName, String key) throws Exception {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 208 77 8135540"); 
		try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 208 78 8135540"); 
			CacheManager myManager = CacheManager.create();
			Cache myCache = myManager.getCache(cacheName);
			myCache.removeAll();
			return true;
		} catch (Exception e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 208 79 8135540"); 
			throw new Exception("remove cache " + cacheName + " failed!!!");
		}
	}

	/**
	 * 释放CacheManage
	 */

	public static void shutdown() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 208 81 8135540"); 
		cacheManager.shutdown();
	}

	/**
	 * 移除cache
	 * 
	 * @param cacheName
	 */

	public static void removeCache(String cacheName) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 208 82 8135540"); 
		checkCacheManager();
		cache = cacheManager.getCache(cacheName);
		if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 208 83 8135540")|| true) && (null != cache? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 208 13 10 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 208 13 10 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 208 84 8135540"); {
			cacheManager.removeCache(cacheName);
		} }
	}

	/**
	 * 移除cache中的key
	 * 
	 * @param cacheName
	 */

	public static void remove(String key) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 208 86 8135540"); 
		checkCache();
		cache.remove(key);
	}

	/**
	 * 移除所有cache
	 */

	public static void removeAllCache() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 208 87 8135540"); 
		checkCacheManager();
		cacheManager.removalAll();
	}

	/**
	 * 
	 * 移除所有Element
	 */

	public static void removeAllKey() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 208 88 8135540"); 
		checkCache();
		cache.removeAll();
	}

	/**
	 * 
	 * 获取所有的cache名称
	 * 
	 * @return
	 */

	public static String[] getAllCaches() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 208 89 8135540"); 
		checkCacheManager();
		return cacheManager.getCacheNames();
	}

	/**
	 * 
	 * 获取Cache所有的Keys
	 * 
	 * @return
	 */

	@SuppressWarnings("rawtypes")
	public static List getKeys() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 208 90 8135540"); 
		checkCache();
		return cache.getKeys();
	}

	/**
	 * 
	 * 检测cacheManager
	 */

	private static void checkCacheManager() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 208 91 8135540"); 
		if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 208 92 8135540")|| true) && (null == cacheManager? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 208 14 11 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 208 14 11 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 208 93 8135540"); {
			throw new IllegalArgumentException("调用前请先初始化CacheManager值：EHCacheUtil.initCacheManager");
		} }
	}

	private static void checkCache() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 208 95 8135540"); 
		if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 208 96 8135540")|| true) && (null == cache? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 208 15 12 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 208 15 12 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 208 97 8135540"); {
			throw new IllegalArgumentException("调用前请先初始化Cache值：EHCacheUtil.initCache(参数)");
		} }
	}

	@SuppressWarnings("rawtypes")
	public static void main(String[] arg) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 208 99 8135540"); 
		// 初始化--必须
		EhcacheUtils.initCacheManager();
		EhcacheUtils.initCache("cache");
		EhcacheUtils.put("A", "AAAAA");
		EhcacheUtils.put("B", "BBBBB");
		EhcacheUtils.put("F", "FFFFF");
		System.out.println(EhcacheUtils.get("F"));
		List keys = EhcacheUtils.getKeys();
		for (int i = 0; (ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 208 100 8135540")|| true) && (i < keys.size()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 208 16 13 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 208 16 13 0 0 ","8135540",false,0) && false)); i++){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 208 101 8135540"); {
			System.out.println(keys.get(i));
		}}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 208 102 8135540");
		EhcacheUtils.shutdown();
	}
}

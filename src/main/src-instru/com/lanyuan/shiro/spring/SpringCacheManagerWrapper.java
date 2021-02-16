// ZOA_CREATED! DO NOT EDIT IT! -- 
/**
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.lanyuan.shiro.spring;

import net.sf.ehcache.Ehcache;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.util.CollectionUtils;
import org.springframework.cache.support.SimpleValueWrapper;

import java.util.*;

/**
 * 包装Spring cache抽象
 * <p>Version: 3.0
 */
import com.process.ZoaExp;
import com.process.ZoaThreadLocal;
public class SpringCacheManagerWrapper implements CacheManager {

    private org.springframework.cache.CacheManager cacheManager;

    /**
     * 设置spring cache manager
     *
     * @param cacheManager
     */
    public void setCacheManager(org.springframework.cache.CacheManager cacheManager) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 270 0 8135540"); 
        this.cacheManager = cacheManager;
    }

    
    public <K, V> Cache<K, V> getCache(String name) throws CacheException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 270 1 8135540"); 
        org.springframework.cache.Cache springCache = cacheManager.getCache(name);
        return new SpringCacheWrapper(springCache);
    }

    static class SpringCacheWrapper implements Cache {
        private org.springframework.cache.Cache springCache;

        SpringCacheWrapper(org.springframework.cache.Cache springCache) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 270 2 8135540"); 
            this.springCache = springCache;
        }

        
        public Object get(Object key) throws CacheException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 270 3 8135540"); 
            Object value = springCache.get(key);
            if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 270 4 8135540")|| true) && (value instanceof SimpleValueWrapper? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 270 0 0 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 270 0 0 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 270 5 8135540"); {
                return ((SimpleValueWrapper) value).get();
            } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 270 6 8135540");
            return value;
        }

        
        public Object put(Object key, Object value) throws CacheException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 270 7 8135540"); 
            springCache.put(key, value);
            return value;
        }

        
        public Object remove(Object key) throws CacheException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 270 8 8135540"); 
            springCache.evict(key);
            return null;
        }

        
        public void clear() throws CacheException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 270 9 8135540"); 
            springCache.clear();
        }

        
        public int size() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 270 10 8135540"); 
            if((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 270 11 8135540")|| true) && (springCache.getNativeCache() instanceof Ehcache? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 270 1 1 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 270 1 1 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 270 12 8135540"); {
                Ehcache ehcache = (Ehcache) springCache.getNativeCache();
                return ehcache.getSize();
            } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 270 13 8135540");
            throw new UnsupportedOperationException("invoke spring cache abstract size method not supported");
        }

        
        public Set keys() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 270 14 8135540"); 
            if((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 270 15 8135540")|| true) && (springCache.getNativeCache() instanceof Ehcache? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 270 2 2 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 270 2 2 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 270 16 8135540"); {
                Ehcache ehcache = (Ehcache) springCache.getNativeCache();
                return new HashSet(ehcache.getKeys());
            } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 270 17 8135540");
            throw new UnsupportedOperationException("invoke spring cache abstract keys method not supported");
        }

        
        public Collection values() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 270 18 8135540"); 
            if((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 270 19 8135540")|| true) && (springCache.getNativeCache() instanceof Ehcache? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 270 3 3 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 270 3 3 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 270 20 8135540"); {
                Ehcache ehcache = (Ehcache) springCache.getNativeCache();
                List keys = ehcache.getKeys();
                if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 270 21 8135540")|| true) && (!CollectionUtils.isEmpty(keys)? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 270 4 4 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 270 4 4 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 270 22 8135540"); {
                    List values = new ArrayList(keys.size());
                    for (Object key : /* TRUE */keys){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 270 23 8135540");ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 270 24 8135540"); {
                        Object value = get(key);
                        if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 270 25 8135540")|| true) && (value != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 270 5 5 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 270 5 5 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 270 26 8135540"); {
                            values.add(value);
                        } }
                    }}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 270 28 8135540");
                    return Collections.unmodifiableList(values);
                } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 270 29 8135540");  {
                    return Collections.emptyList();
                } }
            } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 270 31 8135540");
            throw new UnsupportedOperationException("invoke spring cache abstract values method not supported");
        }
    }
}

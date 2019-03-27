package com.study.cache.cache;

import java.util.concurrent.ConcurrentHashMap;

/**
 * 缓存管理器
 */
public class CacheManager {

    /**
     * 缓存Map对象
     */
    private static ConcurrentHashMap<String,CacheEntity> cacheMap = new ConcurrentHashMap<>();

}

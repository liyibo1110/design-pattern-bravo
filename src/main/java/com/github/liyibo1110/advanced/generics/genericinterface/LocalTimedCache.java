package com.github.liyibo1110.advanced.generics.genericinterface;

import cn.hutool.core.lang.Pair;

import java.time.Duration;
import java.time.Instant;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author liyibo
 * @date 2025-10-17 10:54
 */
public class LocalTimedCache<T> implements Cache<T> {

    private final Map<String, Pair<T, Instant>> cache = new ConcurrentHashMap<>();

    @Override
    public void put(String key, T value) {
        cache.put(key, new Pair<>(value, null));
    }

    @Override
    public void put(String key, T value, Duration expiration) {
        cache.put(key, new Pair<>(value, Instant.now().plus(expiration)));
    }

    @Override
    public T get(String key) {
        Pair<T, Instant> entry = cache.get(key);
        if(entry == null)
            return null;

        Instant expireTime = entry.getValue();
        if(expireTime == null)
            return entry.getKey();
        else if(expireTime.isAfter(Instant.now()))
            return entry.getKey();
        else {
            cache.remove(key);
            return null;
        }
    }
}

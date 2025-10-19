package com.github.liyibo1110.advanced.generics.genericinterface;

import java.time.Duration;

/**
 * @author liyibo
 * @date 2025-10-17 10:53
 */
public interface Cache<T> {

    void put(String key, T value);

    void put(String key, T value, Duration expiration);

    T get(String key);
}

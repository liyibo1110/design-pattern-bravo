package com.github.liyibo1110.advanced.generics.genericinterface;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

/**
 * @author liyibo
 * @date 2025-10-17 10:57
 */
public class LocalTimedCacheTest {

    @Test
    public void test() throws InterruptedException {
        LocalTimedCache<String> cache = new LocalTimedCache<>();
        cache.put("key", "value");
        cache.put("exKey", "exValue", Duration.ofSeconds(1));

        Assertions.assertNull(cache.get("a"));
        Assertions.assertEquals("value", cache.get("key"));
        Assertions.assertEquals("exValue", cache.get("exKey"));

        TimeUnit.SECONDS.sleep(2);

        Assertions.assertNull(cache.get("a"));
        Assertions.assertEquals("value", cache.get("key"));
        Assertions.assertNull(cache.get("exKey"));
    }
}

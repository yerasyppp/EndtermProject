package com.restaurant.patterns;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryCache {
    private static InMemoryCache instance;
    private Map<String, Object> cache = new ConcurrentHashMap<>();

    private InMemoryCache() {}

    public static synchronized InMemoryCache getInstance() {
        if (instance == null) {
            instance = new InMemoryCache();
        }
        return instance;
    }

    public void put(String key, Object value) {
        cache.put(key, value);
    }

    public Object get(String key) {
        return cache.get(key);
    }

    public void remove(String key) {
        cache.remove(key);
    }

    public void clear() {
        cache.clear();
    }
}
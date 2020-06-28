package com.everything.demo.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Component
public class RedisUtils {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    public Long increment(String key, Long offset) {
        return redisTemplate.opsForValue().increment(key, offset);
    }

    public Long increment(String key, Long offset, long timeout, TimeUnit timeUnit) {
        Long value = redisTemplate.opsForValue().increment(key, offset);
        if (offset.longValue() == value.longValue()) {
            redisTemplate.expire(key, timeout, timeUnit);
        }
        return value;
    }

    public void put(String key, Object value, long expire, TimeUnit timeUnit) {
        redisTemplate.opsForValue().set(key, value, expire, timeUnit);
    }

    public <T> T get(String key) {
        return (T) redisTemplate.opsForValue().get(key);
    }

    public boolean hasKey(String key) {
        return redisTemplate.hasKey(key);
    }

    public void delete(String key) {
        redisTemplate.delete(key);
    }

    public void addHashMap(String key, Object hashKey, Object value, long expire, TimeUnit timeUnit) {
        redisTemplate.opsForHash().put(key, hashKey, value);
        redisTemplate.expire(key, expire, timeUnit);
    }

    public long sizeHashMap(String key) {
        return redisTemplate.opsForHash().size(key);
    }

    public List multiGetFromHashMap(String key, List hashKeys) {
        return redisTemplate.opsForHash().multiGet(key, hashKeys);
    }

    public Map getEntriesFromHashMap(String key) {
        return redisTemplate.opsForHash().entries(key);
    }
    
    public void put(String key, Object value){
    	redisTemplate.opsForValue().set(key, value);
    }
    
    public void addHashSet(String key, String value, long expire, TimeUnit timeUnit) {
        redisTemplate.opsForSet().add(key, value);
        redisTemplate.expire(key, expire, timeUnit);
    }

    public Set getHashSet(String key) {
        return redisTemplate.opsForSet().members(key);
    }
    
}

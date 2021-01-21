package com.ivy.system.config;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.RemovalListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
public class CacheConfig{

    @Bean
    public Cache<String,Object> caffeineCache(){
        return Caffeine.newBuilder()
                .expireAfterWrite(60, TimeUnit.MINUTES)
                .weakKeys()// 弱引用key
                .weakValues()// 弱引用value
                .removalListener((RemovalListener<String, Object>) (key, value, cause) -> System.out.println("key:" + key + ", value:" + value + ", 删除原因:" + cause.toString()))
                .initialCapacity(100).maximumSize(10000).build();
    }

}
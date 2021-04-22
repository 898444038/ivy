package com.ivy.system.utils;

import com.github.benmanes.caffeine.cache.AsyncLoadingCache;
import com.github.benmanes.caffeine.cache.CacheLoader;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.RemovalListener;
import org.springframework.lang.NonNull;

import java.util.concurrent.TimeUnit;

public class CaffeineUtils {

    public static void main(String[] args) {

        AsyncLoadingCache<String, String> cache = Caffeine.newBuilder()
            .initialCapacity(10)// 初始缓存长度为10
            .maximumSize(1024)// 最大数量上限
            .expireAfterWrite(5, TimeUnit.MINUTES)// 表示自从最后一次写入后多久就会过期
            .expireAfterAccess(5,TimeUnit.MINUTES)//表示自从最后一次访问（写入或者读取）后多久就会过期
            //.expireAfter()//自定义过期策略
            .refreshAfterWrite(1, TimeUnit.MINUTES)// 失效时间
            //.weakKeys()// 弱引用key
            //.weakValues()// 弱引用value
            // 剔除监听
            .removalListener((RemovalListener<String, String>) (key, value, cause) -> System.out.println("key:" + key + ", value:" + value + ", 删除原因:" + cause.toString()))
            // 异步加载机制
            .buildAsync(new CacheLoader<String, String>() {
                public String load(@NonNull String key) throws Exception {
                    return getValue(key);// 这里我们就可以从数据库或者其他地方查询最新的数据
                }
            });
    }

    public static String getValue(String key){
        return null;
    }
}

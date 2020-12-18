package com.ivy.admin.utils.monitor;

import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import org.redisson.client.RedisClient;
import org.redisson.client.RedisClientConfig;
import org.redisson.client.RedisConnection;
import org.redisson.client.codec.StringCodec;
import org.redisson.client.protocol.RedisCommands;
import org.redisson.client.protocol.RedisStrictCommand;
import org.redisson.client.protocol.decoder.StringMapDataDecoder;

import java.util.HashMap;
import java.util.Map;

/**
 * redis 监控
 */
public class RedisMonitorUtil {

    public static final RedisStrictCommand<Map<String, String>> INFO_ALL = new RedisStrictCommand<Map<String, String>>("INFO", "ALL", new StringMapDataDecoder());
    public static final RedisStrictCommand<Map<String, String>> INFO_DEFAULT = new RedisStrictCommand<Map<String, String>>("INFO", "DEFAULT", new StringMapDataDecoder());
    public static final RedisStrictCommand<Map<String, String>> INFO_SERVER = new RedisStrictCommand<Map<String, String>>("INFO", "SERVER", new StringMapDataDecoder());
    public static final RedisStrictCommand<Map<String, String>> INFO_CLIENTS = new RedisStrictCommand<Map<String, String>>("INFO", "CLIENTS", new StringMapDataDecoder());
    public static final RedisStrictCommand<Map<String, String>> INFO_MEMORY = new RedisStrictCommand<Map<String, String>>("INFO", "MEMORY", new StringMapDataDecoder());
    public static final RedisStrictCommand<Map<String, String>> INFO_PERSISTENCE = new RedisStrictCommand<Map<String, String>>("INFO", "PERSISTENCE", new StringMapDataDecoder());
    public static final RedisStrictCommand<Map<String, String>> INFO_STATS = new RedisStrictCommand<Map<String, String>>("INFO", "STATS", new StringMapDataDecoder());
    public static final RedisStrictCommand<Map<String, String>> INFO_REPLICATION = new RedisStrictCommand<Map<String, String>>("INFO", "REPLICATION", new StringMapDataDecoder());
    public static final RedisStrictCommand<Map<String, String>> INFO_CPU = new RedisStrictCommand<Map<String, String>>("INFO", "CPU", new StringMapDataDecoder());
    public static final RedisStrictCommand<Map<String, String>> INFO_COMMANDSTATS = new RedisStrictCommand<Map<String, String>>("INFO", "COMMANDSTATS", new StringMapDataDecoder());
    public static final RedisStrictCommand<Map<String, String>> INFO_CLUSTER = new RedisStrictCommand<Map<String, String>>("INFO", "CLUSTER", new StringMapDataDecoder());
    public static final RedisStrictCommand<Map<String, String>> INFO_KEYSPACE = new RedisStrictCommand<Map<String, String>>("INFO", "KEYSPACE", new StringMapDataDecoder());

    /**
     * 获取redis连接
     * @return
     */
    public static RedisConnection getRedisConnection(String host,String port,int dataBase) {
        EventLoopGroup group = new NioEventLoopGroup();
        RedisClientConfig config = new RedisClientConfig();
        //redis地址
        config.setAddress("redis://"+host+":"+port);
        //redis密码
        config.setPassword(null);
        //redis 库
        config.setDatabase(dataBase).setClientName("myClient").setGroup(group);
        RedisClient redisClient = RedisClient.create(config);
        return redisClient.connect();
    }

    public static void info(RedisConnection redis,RedisStrictCommand<Map<String, String>> command){
        Map<String,String> redisInfo = redis.sync(StringCodec.INSTANCE, command);
        redisInfo.forEach((k, v) -> System.out.println("key:value = " + k + ":" + v));
        System.out.println("-------------------------------------------------------");
    }

    public static void main(String[] args) {
        RedisConnection redis = getRedisConnection("127.0.0.1","6379",1);
        info(redis,RedisCommands.INFO_ALL);
        info(redis,RedisCommands.INFO_DEFAULT);
        info(redis,RedisCommands.INFO_SERVER);
        info(redis,RedisCommands.INFO_CLIENTS);
        info(redis,RedisCommands.INFO_MEMORY);
        info(redis,RedisCommands.INFO_PERSISTENCE);
        info(redis,RedisCommands.INFO_STATS);
        info(redis,RedisCommands.INFO_REPLICATION);
        info(redis,RedisCommands.INFO_CPU);
        info(redis,RedisCommands.INFO_COMMANDSTATS);
        info(redis,RedisCommands.INFO_CLUSTER);
        info(redis,RedisCommands.INFO_KEYSPACE);
    }
}

package com.redis;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisSentinelPool;

import java.util.HashSet;
import java.util.Set;

public class InitJedisClient {

    public static Jedis getJedis(){
        return new Jedis("192.168.1.110", 6379);
    }

    public static JedisPool getJedisPool(){
        GenericObjectPoolConfig<Object> poolConfig = new GenericObjectPoolConfig<>();
        return new JedisPool(poolConfig,"10.101.32.41", 6379);
    }

    public static JedisSentinelPool getJedisSentinelPool(){
        String masterName="mymaster";
        Set<String> sentinels=new HashSet<>();
        sentinels.add("192.168.67.138:26379");
        sentinels.add("192.168.67.139:26379");
        sentinels.add("192.168.67.140:26379");
        GenericObjectPoolConfig poolConfig=new GenericObjectPoolConfig();
        poolConfig.setMaxIdle(10);
        poolConfig.setMaxTotal(10);
        poolConfig.setMaxWaitMillis(10);
        poolConfig.setJmxEnabled(true);
        JedisSentinelPool jedisSentinelPool=new JedisSentinelPool(masterName,sentinels,poolConfig,2000,"root123");
        return jedisSentinelPool;
    }
}

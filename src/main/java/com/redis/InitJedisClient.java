package com.redis;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class InitJedisClient {

    public static Jedis getJedis(){
        return new Jedis("192.168.1.110", 6379);
    }

    public static JedisPool getJedisPool(){
        GenericObjectPoolConfig<Object> poolConfig = new GenericObjectPoolConfig<>();
        return new JedisPool(poolConfig,"192.168.1.110", 6379);
    }
}

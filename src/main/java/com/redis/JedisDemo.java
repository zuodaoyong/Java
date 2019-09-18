package com.redis;

import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisSentinelPool;
import redis.clients.jedis.Pipeline;

import java.util.List;
import java.util.Map;

public class JedisDemo {

    private static JedisPool jedisPool;
    private static Jedis jedis;
    private static JedisSentinelPool jedisSentinelPool;
    @Before
    public void before(){
        jedisPool = InitJedisClient.getJedisPool();
        jedis=InitJedisClient.getJedis();
        jedisSentinelPool=InitJedisClient.getJedisSentinelPool();
    }
    /**
     * set操作
     */
    @Test
    public void set(){
       jedis.set("hello","world123");
    }

    /**
     * 自增操作
     */
    @Test
    public void incr(){
        jedis.incr("count");
    }

    /**
     * hash操作
     */
    @Test
    public void hset(){
        jedis.hset("myhash","name","neo");
        jedis.hset("myhash","age","30");
    }

    @Test
    public void hgetAll(){
        Jedis resource = jedisPool.getResource();
        Map<String, String> myhash = resource.hgetAll("myhash");
        System.out.println(myhash);
        resource.close();
    }

    @Test
    public void list(){
        Jedis resource = jedisPool.getResource();
        long start=System.currentTimeMillis();
        for(int i=0;i<1000000;i++){
            resource.lpush("mylist",i+"");
        }
        long end=System.currentTimeMillis();
        System.out.println((end-start)/1000+"秒");
    }

    @Test
    public void list2(){
        Jedis resource = jedisPool.getResource();
        long start=System.currentTimeMillis();
        for(int i=0;i<1000;i++){
            Pipeline pipelined = resource.pipelined();
            for(int j=0;j<100000;j++){
                pipelined.lpush("mylist2",j+"");
            }
        }

        long end=System.currentTimeMillis();
        System.out.println((end-start)/1000+"秒");
    }

    /**
     * hyperLogLog
     */
    @Test
    public void pfadd(){
        Jedis resource = jedisPool.getResource();
        resource.pfadd("pf1","uuid-1","uuid-2","uuid-3");
    }

    @Test
    public void initJedisSentinelPool(){
        Jedis resource = jedisSentinelPool.getResource();
        List<String> mymaster = resource.sentinelGetMasterAddrByName("mymaster");
        System.out.println(mymaster);
    }
}

package com.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.params.SetParams;
public class DistributeLock {
    static JedisPool jedisPool = InitJedisClient.getJedisPool();
    public static void main(String[] args) {

    }

    private static void distributeLockv2(){
        Jedis jedis = jedisPool.getResource();
        try{
            SetParams params=SetParams.setParams();
            //jedis.set
            jedis.set("productLock", "productLock",params.nx());
//            if(setnx!=1){
//                return;
//            }
            String productId = jedis.get("productId");
            jedis.set("productId",(Integer.valueOf(productId)-1)+"");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            jedis.del("productLock");
        }
    }

    private static void distributeLockv1(){
        Jedis jedis = jedisPool.getResource();
        try{
            Long setnx = jedis.setnx("productLock", "productLock");
            if(setnx!=1){
                return;
            }
            String productId = jedis.get("productId");
            jedis.set("productId",(Integer.valueOf(productId)-1)+"");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            jedis.del("productLock");
        }
    }
}

package com.java.algorithmv2.杂项;

import com.google.common.base.Charsets;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

import java.util.Arrays;
import java.util.List;


public class 布隆过滤器 {
    public static void main(String[] args) {
        List<String> list= Arrays.asList(new String[]{"java","python","scala","hadoop"});
        //fpp:误判率
        BloomFilter bloomFilter=BloomFilter.create(Funnels.stringFunnel(Charsets.UTF_8),list.size(),0.01);
        for(String str:list){
            bloomFilter.put(str);
        }
        //定义误判数量
        int errorCount=0;
        for(int i=0;i<100;i++){
           String str="abc"+i;
           if(bloomFilter.mightContain(str)){
               errorCount++;
           }
        }
        System.out.println(errorCount);
    }
}

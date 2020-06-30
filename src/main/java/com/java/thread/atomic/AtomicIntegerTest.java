package com.java.thread.atomic;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest {


    public static void main(String[] args) throws Exception{

        Account account=new Account(10000);
        List<Thread> list=new ArrayList<>();
        for(int i=0;i<1000;i++){
            list.add(new Thread(()->{
                account.updateAcount(-10);
            }));
        }
        long startTime=System.nanoTime();
        list.forEach(t->t.start());
        while (Thread.activeCount()>2){
            Thread.sleep(100);
        }
        long end=System.nanoTime();
        System.out.println(account.getAcount()+"耗时："+(end-startTime)/1000_000+"ms");
    }

    static class Account{
        private AtomicInteger balance;

        public Account(Integer balance){
            this.balance=new AtomicInteger(balance);
        }
        private Integer getAcount(){
            return balance.get();
        }

        private void updateAcount(Integer amount){
            while (true){
                //获取最新余额
                int currentAcount = balance.get();
                Integer newBalance=currentAcount+amount;
                if(balance.compareAndSet(currentAcount, newBalance)){
                    break;
                }
            }
        }
    }
}

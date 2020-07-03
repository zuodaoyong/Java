package com.java.thread.atomic;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class AtomicAccumulatorDemo {

    public static void main(String[] args) throws Exception{

        test(
                ()->new AtomicLong(0),
                (addr)->addr.getAndIncrement()
        );
        //使用累计器
        test(
                ()->new LongAdder(),
                (add)->add.increment()
        );
    }

    private static <T> void test(Supplier<T> adder, Consumer<T> action) throws Exception{
        T add = adder.get();
        List<Thread> ts=new ArrayList<>();
        for(int i=0;i<4;i++){
            ts.add(new Thread(()->{
                for(int j=0;j<500000;j++){
                    action.accept(add);
                }
            }));
        }
        long start=System.nanoTime();
        ts.forEach(t->t.start());
        while (Thread.activeCount()>2){
            Thread.sleep(100);
        }
        long end=System.nanoTime();
        System.out.println("花费："+(end-start)/1000_000+"ms");
        System.out.println(add);
    }
}

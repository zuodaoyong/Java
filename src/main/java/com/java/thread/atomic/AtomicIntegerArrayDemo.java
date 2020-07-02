package com.java.thread.atomic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class AtomicIntegerArrayDemo {


    public static void main(String[] args) throws Exception{
        test(()->new int[10],
                (arr)->arr.length,
                (arr,index)->arr[index]++,
                (arr)-> System.out.println(Arrays.toString(arr)));

        test(()->new AtomicIntegerArray(10),
                (arr)->arr.length(),
                (arr,index)->arr.getAndIncrement(index),
                (arr)-> System.out.println(arr));

    }
    private static <T> void test(
            Supplier<T> supplier,
            Function<T,Integer> function,
            BiConsumer<T,Integer> biConsumer,
            Consumer<T> printConsumer) throws Exception{

        List<Thread> list=new ArrayList<>();
        T t = supplier.get();
        Integer length = function.apply(t);

        for(int i=0;i<length;i++){
            list.add(new Thread(()->{
                for(int j=0;j<10000;j++){
                    biConsumer.accept(t,j%length);
                }
            }));
        }
        list.forEach(th->th.start());

        while (Thread.activeCount()>2){

            Thread.sleep(100);
        }

        printConsumer.accept(t);
    }
}

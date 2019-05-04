package com.java.thread.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class BlockingQueueDemo {
    public static void main(String[] args) throws Exception{
        BlockingQueue<String> blockingQueue=new ArrayBlockingQueue<String>(3);
        //test1(blockingQueue);
        //test2(blockingQueue);
        //test3(blockingQueue);
        test4(blockingQueue);
    }

    private static void test4(BlockingQueue<String> blockingQueue) throws Exception{
        blockingQueue.offer("a",2, TimeUnit.SECONDS);//添加元素
        blockingQueue.offer("b",2, TimeUnit.SECONDS);
        blockingQueue.offer("c",2, TimeUnit.SECONDS);
        System.out.println("=========");
        blockingQueue.offer("d",2,TimeUnit.SECONDS);//阻塞
        System.out.println("=========");
        System.out.println(blockingQueue.poll(2,TimeUnit.SECONDS));
        System.out.println(blockingQueue.poll(2,TimeUnit.SECONDS));
        System.out.println(blockingQueue.poll(2,TimeUnit.SECONDS));
        System.out.println(blockingQueue.poll(2,TimeUnit.SECONDS));
    }

    private static void test3(BlockingQueue<String> blockingQueue) throws Exception{
        blockingQueue.put("a");//添加元素
        blockingQueue.put("b");
        blockingQueue.put("c");
        //blockingQueue.put("d");//阻塞
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
    }

    private static void test2(BlockingQueue<String> blockingQueue) {
        System.out.println(blockingQueue.offer("a"));//添加元素
        System.out.println(blockingQueue.offer("b"));
        System.out.println(blockingQueue.offer("c"));
        System.out.println(blockingQueue.offer("d"));
        System.out.println(blockingQueue.peek());//返回队列头部元素
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
    }

    private static void test1(BlockingQueue<String> blockingQueue) {
        blockingQueue.add("a");
        blockingQueue.add("b");
        blockingQueue.add("c");
        blockingQueue.add("d");
        blockingQueue.remove();
        blockingQueue.element();//返回队列头部元素
    }
}

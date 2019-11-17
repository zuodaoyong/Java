package com.java.thread.interrupt;

public class InterruptDemo {
    public static void main(String[] args) throws Exception{
        //interruptTest1();
        //interruptTest2();
        //interruptTest3();
        /*new Thread(){
            @Override
            public void run() {
                while (true){}
            }
        }.start();*/
        interruptTest4();
    }

    private static void interruptTest4(){
        ThreadService threadService=new ThreadService();
        threadService.execute(()->{
            while (true){
                System.out.println("inner");
            }
        });
        threadService.shutdown(10000);
    }

    private static void interruptTest3() throws InterruptedException {
        Thread t=new Thread(){
            @Override
            public void run() {
                while (true){
                    try {
                        Thread.sleep(1);
                    }catch (Exception e){
                       break;
                    }
                }
            }
        };
        Thread.sleep(10000);
        t.interrupt();
    }

    private static void interruptTest2(){
        Thread main = Thread.currentThread();
        Thread t=new Thread(){
            @Override
            public void run() {
                while (true){

                }
            }
        };
        t.start();
        Thread t2=new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep(100);
                }catch (Exception e){
                    e.printStackTrace();
                }
                //t.interrupt();
                main.interrupt();
            }
        };
        t2.start();
        try{
            t.join();
        }catch (Exception e){
            System.out.println("中断");
            e.printStackTrace();
        }
    }

    private static void interruptTest1() {
        Thread t=new Thread(){
            @Override
            public void run() {
                while (true){
                    try{
                       Thread.sleep(10);
                    }catch (Exception e){
                        System.out.println(">>"+this.isInterrupted());
                        e.printStackTrace();
                    }
                }
            }
        };

        t.start();
        System.out.println(t.isInterrupted());
        t.interrupt();
        System.out.println(t.isInterrupted());
    }
}

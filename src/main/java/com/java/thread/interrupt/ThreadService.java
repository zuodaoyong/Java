package com.java.thread.interrupt;

public class ThreadService {

    private Thread executeThread;
    private boolean finished=false;

    public void execute(Runnable task){
        executeThread=new Thread(){
            @Override
            public void run() {
                Thread runner=new Thread(task);
                runner.setDaemon(true);
                runner.start();
                try {
                    runner.join();
                    finished=true;
                } catch (InterruptedException e) {
                    //e.printStackTrace();
                }
            }
        };
        executeThread.start();
    }

    public void shutdown(long mills){
        long currentTime=System.currentTimeMillis();
        while (!finished){
            if(System.currentTimeMillis()-currentTime>=mills){
                System.out.println("任务超时");
                executeThread.interrupt();
                break;
            }
            try{
                executeThread.sleep(1);
            }catch (Exception e){

            }
        }
        finished=false;
    }
}

package com.netty.bio;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BIODemo {

    public static void main(String[] args) throws IOException {
        ExecutorService threadPool = Executors.newCachedThreadPool();
        //创建serverSocket
        ServerSocket serverSocket=new ServerSocket(6666);
        System.out.println("服务器启动了。。。");
        while (true){
            Socket socket=serverSocket.accept();
            System.out.println("客户端连接进来了");
            threadPool.submit(()->{
                handler(socket);
            });
        }
    }

    private static void handler(Socket socket){
        byte[] bytes=new byte[1024];
        try {
            InputStream inputStream = socket.getInputStream();
            int len;
            while ((len=inputStream.read(bytes))!=-1){
                System.out.println(new String(bytes,0,len));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

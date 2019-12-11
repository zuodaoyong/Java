package com.netty.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Scanner;

public class ChartClient {
    private final String host="127.0.0.1";
    private final int port=6667;
    private Selector selector;
    private SocketChannel socketChannel;
    private String username;

    public ChartClient() throws Exception{
        selector = Selector.open();
        socketChannel =SocketChannel.open(new InetSocketAddress(host,port));
        socketChannel.configureBlocking(false);
        socketChannel.register(selector, SelectionKey.OP_READ);
        username=socketChannel.getRemoteAddress().toString().substring(1);
        System.out.println(username+" is ok..");
    }

    private void sendInfo(String info){
        info=username+"说："+info;
        try {
            socketChannel.write(ByteBuffer.wrap(info.getBytes()));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void readInfo() {
        try{
            int select = selector.select();
            if(select>0){
                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                while (iterator.hasNext()){
                    SelectionKey next = iterator.next();
                    if(next.isReadable()){
                        SocketChannel channel = (SocketChannel)next.channel();
                        ByteBuffer allocate = ByteBuffer.allocate(1024);
                        channel.read(allocate);
                        System.out.println(new String(allocate.array()));

                    }
                    iterator.remove();
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        ChartClient chartClient=new ChartClient();

        new Thread(){
            @Override
            public void run() {
                while (true){
                    chartClient.readInfo();
                    try{
                        Thread.currentThread().sleep(3000);
                    }catch (Exception e1){
                        e1.printStackTrace();
                    }
                }
            }
        }.start();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()){
            String nextLine = scanner.nextLine();
            chartClient.sendInfo(nextLine);
        }
    }
}

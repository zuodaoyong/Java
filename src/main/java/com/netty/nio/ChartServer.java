package com.netty.nio;


import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;

public class ChartServer {
    private Selector selector;
    private ServerSocketChannel serverSocketChannel;
    private int port=6667;

    //初始化
    public ChartServer(){
        try{
            selector=Selector.open();
            serverSocketChannel=ServerSocketChannel.open();
            serverSocketChannel.socket().bind(new InetSocketAddress(port));
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        }catch (Exception e){
           e.printStackTrace();
        }
    }

    //监听
    private void listen() throws Exception{
        while (true){
            int select = selector.select();
            if(select>0){//有事件产生
                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                while (iterator.hasNext()){
                    SelectionKey next = iterator.next();
                    //监听到accept
                    if(next.isAcceptable()){
                        SocketChannel socketChannel = serverSocketChannel.accept();
                        socketChannel.configureBlocking(false);
                        socketChannel.register(selector,SelectionKey.OP_READ);
                        System.out.println(socketChannel.getRemoteAddress()+"上线了");
                    }
                    if(next.isReadable()){
                        //处理读
                    }
                    iterator.remove();
                }
            }else{
                System.out.println("等待");
            }
        }
    }

    private void readData(SelectionKey selectionKey) {
        SocketChannel channel=null;
        try{
            channel = (SocketChannel)selectionKey.channel();
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            int read = channel.read(buffer);
            if(read>0){
                String msg=new String(buffer.array());
                System.out.println("from 客户端:"+msg);
                sendOtherClients(msg,channel);
            }
        }catch (Exception e){
            try{
                System.out.println(channel.getRemoteAddress()+"离线了");
                selectionKey.cancel();
                channel.close();
            }catch (Exception ex){
                e.printStackTrace();
            }
        }
    }

    private void sendOtherClients(String msg,SocketChannel channel) throws Exception{
        System.out.println("服务器转发消息中。。。");
        for(SelectionKey selectionKey:selector.keys()){
            SocketChannel socketChannel = (SocketChannel)selectionKey.channel();
            if(socketChannel instanceof SocketChannel &&channel!=socketChannel){
                ByteBuffer byteBuffer = ByteBuffer.wrap(msg.getBytes());
                socketChannel.write(byteBuffer);
            }
        }

    }

    public static void main(String[] args) throws Exception{
        ChartServer chartServer=new ChartServer();
        chartServer.listen();
    }
}

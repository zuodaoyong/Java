package com.netty.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Arrays;

public class ScatterAndGatherTest {
    public static void main(String[] args) throws Exception {
        ServerSocketChannel socketChannel = ServerSocketChannel.open();
        InetSocketAddress inetSocketAddress=new InetSocketAddress(7000);
        socketChannel.socket().bind(inetSocketAddress);
        ByteBuffer[] byteBuffers=new ByteBuffer[2];
        byteBuffers[0]=ByteBuffer.allocate(5);
        byteBuffers[1]=ByteBuffer.allocate(3);
        SocketChannel accept = socketChannel.accept();
        int messageLen=8;
        while (true){
            int byteRead=0;
            while (byteRead<messageLen){
                long read = accept.read(byteBuffers);
                byteRead+=read;
                Arrays.asList(byteBuffers).stream().map(e->"position="+e.position()+",limit="+
                        e.limit()).forEach(System.out::println);
            }
            Arrays.asList(byteBuffers).forEach(e->e.flip());
            int byteWrite=0;
            while (byteWrite<messageLen){
                long write = accept.write(byteBuffers);
                byteWrite+=write;
            }
            Arrays.asList(byteBuffers).forEach(e->e.clear());

        }
    }
}

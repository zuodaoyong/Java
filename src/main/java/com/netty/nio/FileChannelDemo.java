package com.netty.nio;

import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.FileChannel;
import java.nio.file.*;

public class FileChannelDemo {

    public static void main(String[] args) throws Exception{
        String message="hello world";
        FileOutputStream out=new FileOutputStream("D:\\temp\\netty\\t.txt");
        FileChannel fileChannel= out.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        byteBuffer.put(message.getBytes());
        byteBuffer.flip();
        fileChannel.write(byteBuffer);
        out.close();
    }
}

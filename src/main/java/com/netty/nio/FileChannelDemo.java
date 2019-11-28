package com.netty.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.FileChannel;
import java.nio.file.*;

public class FileChannelDemo {

    public static void main(String[] args) throws Exception{
        //writeFile();
        //readFile();
        copyFile();
    }

    private static void copyFile() throws Exception{
        FileInputStream inputStream=new FileInputStream("D:\\temp\\hadoop-2.7.2.zip");
        FileChannel inChannel = inputStream.getChannel();
        FileOutputStream outputStream=new FileOutputStream("D:\\temp\\netty\\hadoop-2.7.2.zip");
        FileChannel outChannel = outputStream.getChannel();
        ByteBuffer byteBuffer=ByteBuffer.allocate(1024);
        while (true){
            byteBuffer.clear();
            int read = inChannel.read(byteBuffer);
            if(read==-1){
                break;
            }
            byteBuffer.flip();
            outChannel.write(byteBuffer);
        }
    }

    private static void readFile() throws Exception{
        FileInputStream inputStream=new FileInputStream("D:\\temp\\netty\\1.txt");
        FileChannel channel = inputStream.getChannel();
        ByteBuffer byteBuffer=ByteBuffer.allocate(1024);
        channel.read(byteBuffer);
        System.out.println(new String(byteBuffer.array()));
    }

    private static void writeFile() throws Exception{
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

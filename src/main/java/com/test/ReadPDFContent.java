package com.test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ReadPDFContent {


    public static void main(String[] args) throws Exception{
        String s = readFile("D:\\temp\\tool\\test.txt");
        writeFile(s,"D:\\temp\\tool\\test1.txt");
    }

    private static String readFile(String file) throws Exception{
        //FileInputStream inputStream=new FileInputStream(file);
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line=null;
        StringBuilder content=new StringBuilder("");

        while ((line=bufferedReader.readLine())!=null){
            content.append(line);
        }

        return content.toString();
    }

    private static void writeFile(String message,String file) throws Exception{
        FileOutputStream out=new FileOutputStream(file);
        FileChannel fileChannel= out.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(102400);
        byteBuffer.put(message.getBytes());
        byteBuffer.flip();
        fileChannel.write(byteBuffer);
        out.close();
    }
}

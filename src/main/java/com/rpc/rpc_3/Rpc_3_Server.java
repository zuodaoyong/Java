package com.rpc.rpc_3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

public class Rpc_3_Server {

    private static boolean running=true;

    public static void main(String[] args) throws Exception{
        ServerSocket ss=new ServerSocket(8888);
        while (running){
            Thread.sleep(TimeUnit.MICROSECONDS.toMillis(10));
            Socket s=ss.accept();
            process(s);
            s.close();
        }
        ss.close();
    }

    private static void process(Socket s) throws Exception{
        InputStream in=s.getInputStream();
        OutputStream out=s.getOutputStream();
        DataInputStream dis=new DataInputStream(in);
        DataOutputStream dos=new DataOutputStream(out);
        int id=dis.readInt();
        System.out.println("server receive id is "+id);
        dos.writeInt(id*2);
        dos.writeUTF("id="+id);
        dos.flush();
    }
}

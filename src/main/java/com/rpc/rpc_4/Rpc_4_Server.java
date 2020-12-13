package com.rpc.rpc_4;

import com.rpc.UserServiceImpl;

import java.io.*;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

public class Rpc_4_Server {

    private static boolean running=true;

    public static void main(String[] args) throws Exception{
        ServerSocket ss=new ServerSocket(8888);
        while (running){
            Socket s=ss.accept();
            process(s);
            s.close();
            Thread.sleep(TimeUnit.MICROSECONDS.toMillis(10));
        }
        ss.close();
    }

    private static void process(Socket s) throws Exception{
        InputStream in=s.getInputStream();
        OutputStream out=s.getOutputStream();
        ObjectInputStream ois=new ObjectInputStream(in);
        DataOutputStream dos=new DataOutputStream(out);

        String methodName = ois.readUTF();
        Class<?>[] parameterTypes  = (Class[])ois.readObject();
        Object[] args=(Object[])ois.readObject();
        UserServiceImpl userService=new UserServiceImpl();

        Method method = userService.getClass().getMethod(methodName, parameterTypes);
        int invoke = (int)method.invoke(userService, args);

        dos.writeInt(invoke*2);
        dos.writeUTF("id="+invoke);
        dos.flush();
    }
}

package com.rpc.rpc_3;

import com.rpc.IUserService;
import com.rpc.User;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.Socket;

public class Stub {


    public IUserService getStub(){

        InvocationHandler h=new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Socket s=new Socket("127.0.0.1",8888);
                ByteArrayOutputStream bos=new ByteArrayOutputStream();
                DataOutputStream dos=new DataOutputStream(bos);
                dos.writeInt((int)args[0]);
                s.getOutputStream().write(bos.toByteArray());
                s.getOutputStream().flush();
                DataInputStream dis=new DataInputStream(s.getInputStream());

                int id=dis.readInt();

                String name=dis.readUTF();
                System.out.println("id="+id+",name="+name);
                User user=new User(id,name);
                dos.close();
                s.close();
                return user;
            }
        };

        Object o=Proxy.newProxyInstance(IUserService.class.getClassLoader(),new Class[]{IUserService.class},h);
        return (IUserService) o;
    }

}

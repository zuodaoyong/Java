package com.rpc.rpc_2;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class Stub {

    public void printInfo(int v_id) throws Exception{
        Socket s=new Socket("127.0.0.1",8888);
        ByteArrayOutputStream bos=new ByteArrayOutputStream();
        DataOutputStream dos=new DataOutputStream(bos);
        dos.writeInt(v_id);
        s.getOutputStream().write(bos.toByteArray());
        s.getOutputStream().flush();
        DataInputStream dis=new DataInputStream(s.getInputStream());

        int id=dis.readInt();

        String name=dis.readUTF();
        System.out.println("id="+id+",name="+name);
        dos.close();
        s.close();
    }
}

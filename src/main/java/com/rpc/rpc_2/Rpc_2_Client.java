package com.rpc.rpc_2;

public class Rpc_2_Client {

    public static void main(String[] args) throws Exception{
        Stub stub=new Stub();
        stub.printInfo(3);
    }
}

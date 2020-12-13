package com.rpc.rpc_4;

import com.rpc.IUserService;

public class Rpc_4_Client {

    public static void main(String[] args) {
        Stub stub=new Stub();
        IUserService userService = stub.getStub();
        userService.printInfo(10);
    }
}

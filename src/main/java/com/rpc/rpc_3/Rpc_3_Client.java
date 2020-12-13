package com.rpc.rpc_3;

import com.rpc.IUserService;

public class Rpc_3_Client {

    public static void main(String[] args) {
        Stub stub=new Stub();
        IUserService userService=stub.getStub();
        userService.printInfo(8);
    }
}

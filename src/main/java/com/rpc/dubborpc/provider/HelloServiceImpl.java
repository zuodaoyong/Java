package com.rpc.dubborpc.provider;

import com.rpc.dubborpc.interfaces.HelloService;

public class HelloServiceImpl implements HelloService {

    @Override
    public String hello(String msg) {
        System.out.println("msg="+msg);
        return "server received msg is "+msg;
    }
}

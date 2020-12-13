package com.rpc;

public class UserServiceImpl implements IUserService {
    @Override
    public int printInfo(int id) {
        System.out.println("server receive id is "+id);
        return id;
    }
}

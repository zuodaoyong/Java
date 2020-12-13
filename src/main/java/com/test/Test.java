package com.test;


import com.java.spring.annotation.bean.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {


        List<User> users=new ArrayList<>();
        users.add(new User("a",1));
        users.add(new User("b",2));
        users.add(new User("a",2));
        Map<Integer, List<User>> group =
                users.stream().collect(Collectors.groupingBy(User::getAreaManagerId));
        System.out.println(group);
    }

}





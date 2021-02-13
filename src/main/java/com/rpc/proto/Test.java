package com.rpc.proto;

/**
 * cd 到D:\project\Java\下执行
 * protoc --java_out=src\main\java src\main\resource\proto\addressbook.proto
 */
public class Test {

    public static void main(String[] args) throws Exception{
        AddressBookProtos.Person person = AddressBookProtos.Person.newBuilder().setId(1).setName("test").build();
        System.out.println(person);
        byte[] bytes = person.toByteArray();
        AddressBookProtos.Person parse = AddressBookProtos.Person.parseFrom(bytes);
        System.out.println(parse);

    }
}

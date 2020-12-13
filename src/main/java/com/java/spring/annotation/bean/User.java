package com.java.spring.annotation.bean;



public class User {

    public User(String name, int areaManagerId) {
        this.name = name;
        this.areaManagerId = areaManagerId;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", areaManagerId=" + areaManagerId +
                '}';
    }

    private String name;
    private int areaManagerId;

    public int getAreaManagerId() {
        return areaManagerId;
    }

    public void setAreaManagerId(int areaManagerId) {
        this.areaManagerId = areaManagerId;
    }
}

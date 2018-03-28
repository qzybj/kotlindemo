package com.example.lib_java.model;

/**
 * Created by zyb
 *
 * @date 2018/3/21
 * @description
 */
public class Person {

    public String name;
    public String address;
    public int age;
    public boolean isBjLocal;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isBjLocal() {
        return isBjLocal;
    }

    public void setBjLocal(boolean bjLocal) {
        isBjLocal = bjLocal;
    }
}

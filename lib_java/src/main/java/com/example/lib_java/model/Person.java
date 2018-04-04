package com.example.lib_java.model;

import com.example.lib_java.annotation.ObjectReflect;
import com.example.lib_java.util.ObjectReflectUtil;

import java.math.BigDecimal;

/**
 * Created by zyb
 *
 * @date 2018/3/21
 * @description
 */
public class Person {

    public String name;
    @ObjectReflect(ObjectReflectUtil.FIELD_IGNORE)
    public String address;
    public int age;
    public boolean isBjLocal;
    public float height;
    public BigDecimal money;

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

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                ", isBjLocal=" + isBjLocal +
                ", height=" + height +
                ", money=" + money +
                '}';
    }
}

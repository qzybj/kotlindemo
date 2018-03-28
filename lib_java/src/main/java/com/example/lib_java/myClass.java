package com.example.lib_java;


import com.example.lib_java.model.Person;
import com.example.lib_java.util.TestUtil;
import com.example.lib_java.util.TestUtil1;

public class myClass {

    public final static String TAG = "tag";

    public static void main(String args[]) {
        //testSplit();
        //cutReceiptNo;
        Person person = new Person();
        person.name = "name";
        person.address = "beijing";
        person.age = 10;
        person.setBjLocal(true);
        String[] values = TestUtil1.prtValuesPlus(person);
        if(values!=null){
            for (String value :values) {
                TestUtil.print(value);
            }
        }

    }
}
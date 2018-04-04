package com.example.lib_java;


import com.example.lib_java.model.Person;
import com.example.lib_java.util.ObjectReflectUtil;
import com.example.lib_java.util.SplitUtil;
import com.example.lib_java.util.ClassFieldUtil;

import java.math.BigDecimal;

public class TestMain {

    public final static String TAG = "tag";

    public static void main(String args[]) {
        //testPrtPersonInfo(buildPerson());
        testCopyPersonInfo();
    }

    private static void testCopyPersonInfo() {
        Person copyPerson = buildPerson();
        Person sourcePerson = new Person();
        Person person=null;
        copyPerson.equals(person);

        String str = new String("123123113");
        SplitUtil.printLn("before merge: -------------");
        SplitUtil.printLn(sourcePerson.toString());
        boolean isCopySuccess = ObjectReflectUtil.mergeObject(sourcePerson,copyPerson);
        SplitUtil.printLn("copy is "+isCopySuccess);
        SplitUtil.printLn("after merge: -------------");
        SplitUtil.printLn(sourcePerson.toString());
    }

    /**
     * 打印Model所有字段
     * @param person
     */
    private static void testPrtPersonInfo(Person person) {
        String[] values = ClassFieldUtil.prtValuesPlus(person);
        if (values != null) {
            for (String value : values) {
                SplitUtil.print(value);
            }
        }
    }

    /**
     * New model对象
     * @return
     */
    private static Person buildPerson() {
        Person person = new Person();
        person.name = "name";
        person.address = "beijing";
        person.age = 10;
        person.setBjLocal(true);
        person.setHeight(16.5f);
        person.setMoney(new BigDecimal("100.5"));
        return person;
    }
}
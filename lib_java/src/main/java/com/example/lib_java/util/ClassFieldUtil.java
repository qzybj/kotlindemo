package com.example.lib_java.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * Created by zyb
 *
 * @date 2018/3/21
 * @description 获取反射值
 */
public class ClassFieldUtil {

    public static void prtFields(Class cls) {
        Field[] fields = cls.getClass().getDeclaredFields();//根据Class对象获得属性 私有的也可以获得
        for (Field f : fields) {
            SplitUtil.print(f.getType().getName() + f.getType());//打印每个属性的类型名字
        }
    }

    public static String[] prtValuesPlus(Object model) {
        if (model != null) {
            Field[] field = model.getClass().getDeclaredFields();
            if(field!=null){
                String[] values = new String[field.length];
                for (int i = 0; i < field.length; i++) {
                    field[i].setAccessible(true);
                    try {
                        Object obj = field[i].get(model);
                        if(obj!=null){
                            values[i] = obj.toString();
                        }
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
                return values;
            }
        }
        return null;
    }


    public static void prtValues(Object model) {
        try {
            // 获取实体类的所有属性，返回Field数组
            Field[] field = model.getClass().getDeclaredFields();
            // 获取属性的名字
            String[] modelName = new String[field.length];
            String[] modelType = new String[field.length];
            for (int i = 0; i < field.length; i++) {
                // 获取属性的名字
                String name = field[i].getName();
                modelName[i] = name;
                // 获取属性类型
                String type = field[i].getGenericType().toString();
                modelType[i] = type;

                //关键。。。可访问私有变量
                field[i].setAccessible(true);
                //给属性赋值
                //field[i].set(model, field[i].getType().getConstructor(field[i].getType()).newInstance("kou"));


                // 将属性的首字母大写
                name = name.replaceFirst(name.substring(0, 1), name.substring(0, 1)
                        .toUpperCase());

                if (type.equals("class java.lang.String")) {
                    // 如果type是类类型，则前面包含"class "，后面跟类名
                    Method m = model.getClass().getMethod("get" + name);
                    // 调用getter方法获取属性值
                    String value = (String) m.invoke(model);
                    if (value != null) {

                        SplitUtil.print("attribute value:" + value);
                    }
                }
                if (type.equals("class java.lang.Integer")||type.equals("int")) {
                    Method m = model.getClass().getMethod("get" + name);
                    Integer value = (Integer) m.invoke(model);
                    if (value != null) {
                        SplitUtil.print("attribute value:" + value);
                    }
                }
                if (type.equals("class java.lang.Short")) {
                    Method m = model.getClass().getMethod("get" + name);
                    Short value = (Short) m.invoke(model);
                    if (value != null) {
                        SplitUtil.print("attribute value:" + value);
                    }
                }
                if (type.equals("class java.lang.Double")) {
                    Method m = model.getClass().getMethod("get" + name);
                    Double value = (Double) m.invoke(model);
                    if (value != null) {
                        SplitUtil.print("attribute value:" + value);
                    }
                }
                if (type.equals("class java.lang.Boolean")||type.equals("boolean")) {
                    Method m = model.getClass().getMethod("get" + name);
                    Boolean value = (Boolean) m.invoke(model);
                    if (value != null) {
                        SplitUtil.print("attribute value:" + value);
                    }
                }
                if (type.equals("class java.util.Date")) {
                    Method m = model.getClass().getMethod("get" + name);
                    Date value = (Date) m.invoke(model);
                    if (value != null) {
                        SplitUtil.print("attribute value:"
                                + value.toLocaleString());
                    }
                }
            }
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
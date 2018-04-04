package com.example.lib_java.util;

import com.example.lib_java.annotation.ObjectReflect;

import java.lang.reflect.Field;

/**
 * Created by zyb
 *
 * @date 2018/4/3
 * @description
 */
public class ObjectReflectUtil {
    /**复制字段*/
    public static final String FIELD_COPY = "field_copy";
    /**忽略字段*/
    public static final String FIELD_IGNORE = "field_ignore";

    /**
     * 将 copyObj 中添加 ObjectReflect 注解的字段，复制到sourceObj
     * @param sourceObj
     * @param copyObj
     */
    public static boolean mergeObject(Object sourceObj, Object copyObj) {
        if (sourceObj == null || copyObj == null) {
            return false;
        }
        if (sourceObj.getClass() != copyObj.getClass()) {
            return false;
        }
        // 获取实体类的所有属性，返回Field数组
        Field[] sourceField = sourceObj.getClass().getDeclaredFields();
        Field[] copyField = copyObj.getClass().getDeclaredFields();
        ObjectReflect annotationInfo = null;

        for (int i = 0; i < sourceField.length; i++) {
            //如果字段设定忽略，则不处理
            annotationInfo = sourceField[i].getAnnotation(ObjectReflect.class);
            if(annotationInfo!=null){
                if(FIELD_IGNORE.equals(annotationInfo.value())){
                    continue ;
                }
            }
            if(sourceField[i]!=null&&copyField[i]!=null){
                //复制值到
                sourceField[i].setAccessible(true);
                copyField[i].setAccessible(true);
                try {
                    sourceField[i].set(sourceObj, copyField[i].get(copyObj));
                } catch (IllegalAccessException e) {
                    return false;
                }
            }
        }
        return true;
    }

}

package com.example.lib_java.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zyb
 *
 * @date 2018/1/30
 * @description
 */
public class CListUtil {
    /**
     * 判断是否为空
     * @param objList
     * @return
     */
    public static boolean isEmpty(Object[] objList){
        if(objList == null ||
                objList.length == 0){
            return true ;
        }
        return false;
    }
    /**
     * 将数组转成ArrayList
     * @param targets
     * @return
     */
    public static <T> ArrayList<T> toList(T... targets){
        if( targets == null ||
                targets.length == 0 ){
            return null ;
        }
        ArrayList<T> list = new ArrayList<>();
        for(T obj: targets){
            list.add(obj);
        }
        return list ;
    }
    /**
     * 检查当前list是否为空
     * @param tagetList
     * @return
     */
    @SuppressWarnings("rawtypes")
    public static boolean isEmpty(List tagetList){
        if( tagetList == null ||
                tagetList.size() == 0 ){
            return true ;
        }
        return false ;
    }
}

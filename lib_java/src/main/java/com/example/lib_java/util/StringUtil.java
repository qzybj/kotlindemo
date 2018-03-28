package com.example.lib_java.util;

/**
 * Created by zyb
 *
 * @date 2018/1/30
 * @description
 */
public class StringUtil {
    /**
     * Check current string is empty.
     * @param str
     * @return
     */
    public static boolean isEmpty(String str){
        if( str != null && str.trim().length() > 0){
            return false ;
        }
        return true ;
    }


    public static boolean isNotEmpty(String str){
        return !isEmpty(str);
    }
}

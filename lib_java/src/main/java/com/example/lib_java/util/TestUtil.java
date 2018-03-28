package com.example.lib_java.util;

import com.example.lib_java.config.SystemConfigConstant;
import com.example.lib_java.config.UrlConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Created by zyb
 *
 * @date 2018/1/30
 * @description
 */
public class TestUtil {


    public static void testFix(){
        print("call testFix method!");
    }

    public static void print(String msg){
        if(StringUtil.isNotEmpty(msg)){
            System.out.println(msg);
        }
    }
    /**
     * 截取小票号处理
     * @param receiptNo
     * @return
     */
    public static String cutReceiptNo(String receiptNo){
        if(receiptNo==null||receiptNo.length()==11){
            return receiptNo;
        }
        if(receiptNo.length()==20){
            return receiptNo.substring(3,14);
        }else if(receiptNo.length()==14){
            return receiptNo.substring(3,14);
        }else{
            return receiptNo;
        }
    }

    /**
     * 用指定的分隔符分割指定字段串，并判断是否是满足自己指定的长度
     * @param str
     * @param regularExpression
     * @param size 默认传返回的最小长度，不满足则返回null,如果不用检测指定长度，则传入-1
     * @return
     */
    public static String[] getSplit(String str,String regularExpression,int size) {
        if(StringUtil.isNotEmpty(str)
                &&StringUtil.isNotEmpty(regularExpression)){
            if(SystemConfigConstant.STRING_DIVIDE_CHAR.equals(regularExpression)){
                str = str.replace(SystemConfigConstant.STRING_DIVIDE_CHAR, SystemConfigConstant.STRING_DIVIDE_CHAR_REPLACE);
                regularExpression = SystemConfigConstant.STRING_DIVIDE_CHAR_REPLACE;
            }
            String[] split = str.split(regularExpression);
            if(!CListUtil.isEmpty(split)){
                if(size==-1){
                    return split;
                }else{
                    if(split.length>=size){
                        return split;
                    }
                }
            }
        }
        return null;
    }
    /**
     * 测试Url的处理
     */
    public static void testUrlHost() {

        Map<UrlConfig, Integer> map = new HashMap();
        HashSet<UrlConfig> urlConfigSet = new HashSet<>();
        UrlConfig tmp = UrlConfig.ChannelBaseUrl;

        urlConfigSet.add(UrlConfig.MiaoBaseUrl);

        map.put(UrlConfig.ChannelBaseUrl, 5);
        print(UrlConfig.ChannelBaseUrl.getMasterHost());
        print(UrlConfig.ChannelBaseUrl.getBakHost());
        UrlConfig.ChannelBaseUrl.setMasterHost("edit 11111");
        UrlConfig.ChannelBaseUrl.setBakHost("edit 222222");
        print(UrlConfig.ChannelBaseUrl.getMasterHost());
        print(UrlConfig.ChannelBaseUrl.getBakHost());
        print(map.get(UrlConfig.ChannelBaseUrl) + "");
        print((tmp == UrlConfig.ChannelBaseUrl) + "");


        UrlConfig.MiaoBaseUrl.setMasterHost("miaoBaseUrl");
        for (UrlConfig item : urlConfigSet) {
            if (item != null) {
                print(item.getMasterHost());
            }
        }

    }

    /**
     * 测试小票截取
     */
    private static void cutReceiptNo() {
        String tmp = "0123456789x";
        System.out.println(TestUtil.cutReceiptNo(tmp));
        String code = "E11";
        System.out.println(code.substring(0,2));
        System.out.println(code.substring(2));
    }

    /**
     * 测试数据分割
     */
    private static void testSplit() {
        String storeNos ="HZ01,HZ02,HZ03,HZ10";
        String storeNo ="HZ08";
        ArrayList<String> list = CListUtil.toList(TestUtil.getSplit(storeNos, ",", -1));
        if (!CListUtil.isEmpty(list)) {
            if(list.contains(storeNo)){
                System.out.println("include "+storeNo);
            }else{
                System.out.println("not include "+storeNo);
            }
        }
    }

}

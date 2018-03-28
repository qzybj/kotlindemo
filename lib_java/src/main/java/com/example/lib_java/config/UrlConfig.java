package com.example.lib_java.config;

/**
 * Created by zyb
 *
 * @date 2018/1/30
 * @description
 */
public enum UrlConfig {

    //会员/积分相关地址
    MemberBaseUrl("11111","22222"),

    //储值卡用*/
    PrepaidCardBaseUrl("",""),

    //券相关接口*/
    CouponBaseUrl("",""),

    //渠道折扣相关接口*/
    ChannelBaseUrl("11111","22222"),

    //喵街支付相关接口*/
    MiaoBaseUrl("",""),

    //手淘支付相关接口*/
    TaoBaseUrl("","");


    private String masterHost;

    private String bakHost;


    UrlConfig(String masterHost, String bakHost) {
        this.masterHost = masterHost;
        this.bakHost = bakHost;
    }

    public String getMasterHost() {
        return masterHost;
    }

    public void setMasterHost(String masterHost) {
        this.masterHost = masterHost;
    }

    public String getBakHost() {
        return bakHost;
    }

    public void setBakHost(String bakHost) {
        this.bakHost = bakHost;
    }
}
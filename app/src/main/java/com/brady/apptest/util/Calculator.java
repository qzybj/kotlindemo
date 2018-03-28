package com.brady.apptest.util;

/**
 * Created by zyb
 *
 * @date 2018/2/27
 * @description
 */
public class Calculator {
    public int add(int one, int another) {
        //为了简单起见，暂不考虑溢出等情况。
        return one + another;
    }

    public double sum(double a, double b){
        return a + b;
    }

    public double substract(double a, double b){
        return a-b;
    }

    public double divide(double divident, double dividor) {
        if (dividor == 0) throw new IllegalArgumentException("Dividor cannot be 0");

        return divident / dividor;
    }

    public double multiply(double a, double b){
        return a*b;
    }
}
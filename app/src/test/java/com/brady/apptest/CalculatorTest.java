package com.brady.apptest;

import com.brady.apptest.util.Calculator;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by zyb
 *
 * @date 2018/2/27
 * @description
 */
public class CalculatorTest {
    @Test
    public void testAdd() throws Exception {
        Calculator calculator = new Calculator();
        int sum = calculator.add(1, 2);
        Assert.assertEquals(3, sum);
    }
}

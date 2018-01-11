package com.jwong.test;

import org.junit.Test;

import java.math.BigDecimal;

/**
 * Test20180111 class
 *
 * @author J.Wong
 * @date 2018/01/11
 */
public class Test20180111 {
    @Test
    public void test1() {
        System.out.println(888.68 - 0.1);

        BigDecimal a = new BigDecimal(Double.toString(888.68));
        BigDecimal b = new BigDecimal(Double.toString(0.1));
        System.out.println(a.subtract(b).doubleValue());
    }
}

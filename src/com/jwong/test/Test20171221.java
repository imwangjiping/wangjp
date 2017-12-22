package com.jwong.test;

import java.time.ZonedDateTime;

/**
 * Test20171221 class
 *
 * @author J.Wong
 * @date 2017/12/21
 */
public class Test20171221 {

    public static void main(String[] args) {
        ZonedDateTime nowTemp = ZonedDateTime.now();
        int month = nowTemp.minusDays(1).getMonthValue(); // 昨天所在月份
        // 根据昨天所在月份，获取那个月的1月1日0点 （ >= ）
        ZonedDateTime lastMonthStart = ZonedDateTime.of(nowTemp.getYear(), month, 1, 0, 0, 0, 0, nowTemp.getZone());
        // 获取当月1日的0点 （ < ）
        ZonedDateTime lastMonthEnd = ZonedDateTime.of(nowTemp.getYear(), nowTemp.getMonthValue(), nowTemp.getDayOfMonth(), 0, 0, 0, 0, nowTemp.getZone());

        System.out.println(lastMonthStart);
        System.out.println(lastMonthEnd);

    }

}

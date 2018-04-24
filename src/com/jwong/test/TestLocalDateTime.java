package com.jwong.test;

import org.junit.Test;

import java.time.LocalDateTime;

/**
 * TestLocalDateTime class
 *
 * @author J.Wong
 * @date 2018/04/24
 */
public class TestLocalDateTime {

    @Test
    public void test1() {
        LocalDateTime local = LocalDateTime.now();
        local = LocalDateTime.of(local.getYear(), 4, 1, 14, 01);

        LocalDateTime localDateTime = local;
        localDateTime = local.plusDays(6L);
        localDateTime = local.plusMonths(1L).minusDays(1L);
        localDateTime = local.plusYears(1L).minusDays(1);
        System.out.println(LocalDateTime.of(localDateTime.getYear(), localDateTime.getMonthValue(), localDateTime.getDayOfMonth(), 23, 59, 59, 999999999));
    }
}

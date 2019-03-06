package com.jwong.test;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

/**
 * Test20190112 class
 *
 * @author J.Wong
 * @date 2019/01/14
 */
public class Test20190112 {

    /**
     * 逗号分割字符串数组
     */
    @Test
    public void test1() {
        String[] arrays = new String[]{"1", "2", "3"};
        System.out.println(String.join(",", arrays));
    }

    /**
     *
     */
    @Test
    public void test2() {
        String[] arrays = new String[]{"1", "2", "3"};
    }

    @Test
    public void test3() {
        List<List<String>> sqlParams = new ArrayList<>();
        List<String> params = Arrays.asList("1", "-", "3", "4");

        long count = params.stream().filter("-"::equals).count();
        System.out.println("count = " + count);
        int forCount = Integer.valueOf((params.size() - count) + "");

        for (int i = forCount; i >= 0; i--) {
            List<String> temp = new ArrayList<>(params);
            sqlParams.add(temp);
            System.out.println(sqlParams);
            for (int j = params.size() - 1; j >= 0; j--) {
                if ("-".equals(params.get(j))) {
                    continue;
                } else {
                    params.set(j, "-");
                    break;
                }
            }
        }

        System.out.println(sqlParams);
    }

    @Test
    public void test4() {
        List<String> ids = new ArrayList<>();
        ids.add("1");
        ids.add("1");
        ids.add("2");
        ids.add("2");

        List<String> collect = ids.stream().distinct().collect(Collectors.toList());
        System.out.println(collect);
    }

    @Test
    public void test5() throws InterruptedException {
        Long second = LocalDateTime.now().toEpochSecond(ZoneOffset.of("+8"));
        System.out.println(second);

        Thread.sleep(1000);
        Long s = LocalDateTime.now().toEpochSecond(ZoneOffset.of("+8"));
        System.out.println(s);
    }

    /**
     * 获取某个时间是当年的第几周
     */
    @Test
    public void test6() {
        LocalDateTime firstDayOfYear = LocalDateTime.of(2019, 1, 7, 0, 0);
        System.out.println(firstDayOfYear.getDayOfWeek().getValue());
        firstDayOfYear = firstDayOfYear.plusDays(4L);
        WeekFields week = WeekFields.of(Locale.getDefault());
        int startWeek = firstDayOfYear.get(week.weekOfWeekBasedYear());

        LocalDateTime today = LocalDateTime.of(2019, 1, 13, 0, 0);
        WeekFields weekFields = WeekFields.of(Locale.getDefault());
        int todayWeek = today.get(weekFields.weekOfWeekBasedYear());

        System.out.println(todayWeek - startWeek + 1);
    }

    @Test
    public void test7() {

    }
}

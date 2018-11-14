package com.jwong.test;

import org.junit.Test;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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


    @Test
    public void test2() {
        String originalStr = "(R1) 可乐 (Q15 - Q15.您对以下饮料的喜欢程度是什么？请用1-5分打分，1分表示一点也不喜欢；5分表示极其喜欢。 【横向单选，1个others在纵向】 )";
        String needToRemoveEndStr = "Q15 - Q15.您对以下饮料的喜欢程度是什么？请用1-5分打分，1分表示一点也不喜欢；5分表示极其喜欢。 【横向单选，1个others在纵向】";
        if (originalStr.contains(needToRemoveEndStr)) {
            System.out.println(originalStr.substring(0, originalStr.indexOf(needToRemoveEndStr) - 1).trim());
            ;
        }
    }

    @Test
    public void test3() {
        List<String> list = new ArrayList() {{

            add("aa");
            add("a");
            add("bb");

        }};
        System.out.println(list.contains("b"));

        System.out.println(list.indexOf("bb"));

    }

    @Test
    public void test4() {
        Map<String, String> map = new HashMap<String, String>() {{
            put("a", "aa");
            put("b", "bb");
        }};

        map.forEach((key, value) -> System.out.println(key + "-" + value));

    }

    @Test
    public void test5(){
        String str = "Q32. 拥有的社交媒体账号 - ^questID('Q32. ')^请问您拥有哪些社交媒体账号？ ^SAMA('[复选]')^";

        System.out.println(str.replaceAll("\\^.*?\\^", "***"));

    }

}

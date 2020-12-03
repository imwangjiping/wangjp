package com.jwong.test;

import java.util.*;

/**
 * Test20201203 class
 *
 * @author J.Wong
 * @date 2020/12/03
 */
public class Test20201203 {

    public static void main(String[] args) {
        /* 初始化数据 */
        List<StationArea> stationAreas = new ArrayList<>();
        int stationCount = 0;
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 5; j++) {
                StationArea stationArea = new StationArea();
                stationArea.setStation("station" + (++stationCount));
                stationArea.setArea("考核区域" + (i % 2 == 0 ? "2" : "1"));
                stationAreas.add(stationArea);
            }
        }

        /* 分组 */
        Map<String, List<StationArea>> result = new IdentityHashMap<>();
        Map<String, List<StationArea>> resultMap = new HashMap<>();
        String lastArea = "";
        for (StationArea stationArea : stationAreas) {
            String area = stationArea.getArea();
            if ("".equals(lastArea)) {
                lastArea = area;
            }
            if (!lastArea.equals(area)) {
                result.putAll(resultMap);
                resultMap = new HashMap<>();
            }
            resultMap.computeIfAbsent(area, k -> new ArrayList<>());
            resultMap.get(area).add(stationArea);
            lastArea = area;
        }
        result.putAll(resultMap);

    }

    static class StationArea {
        private String station;
        private String area;

        public String getStation() {
            return station;
        }

        public void setStation(String station) {
            this.station = station;
        }

        public String getArea() {
            return area;
        }

        public void setArea(String area) {
            this.area = area;
        }

        @Override
        public String toString() {
            final StringBuffer sb = new StringBuffer("StationArea{");
            sb.append("station='").append(station).append('\'');
            sb.append(", area='").append(area).append('\'');
            sb.append('}');
            return sb.toString();
        }
    }

}

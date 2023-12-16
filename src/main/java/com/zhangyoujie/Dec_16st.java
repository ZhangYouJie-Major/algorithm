package com.zhangyoujie;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @author zhangyoujie
 * @date 2023/12/16
 */
public class Dec_16st {

    public static void main(String[] args) {
        CountIntervals countIntervals = new CountIntervals();
        countIntervals.add(2, 3);
        countIntervals.add(7, 10);
        countIntervals.add(5, 8);
        System.out.println(countIntervals.count());
    }


}

class CountIntervals {

    TreeMap<Integer, Integer> intervalTree = new TreeMap<>();
    int ctn = 0;

    public CountIntervals() {

    }

    public void add(int left, int right) {
        //找到比right小的区间 如果区间的右边界大于left 说明 左边和区间有交集 合并区间
        Map.Entry<Integer, Integer> interval = intervalTree.floorEntry(right);
        while (null != interval && interval.getValue() >= left) {
            int l = interval.getKey();
            int r = interval.getValue();
            left = Math.min(left, l);
            right = Math.max(right, r);
            ctn -= r - l + 1;
            intervalTree.remove(l);
            interval = intervalTree.floorEntry(right);

        }
        ctn += right - left + 1;
        intervalTree.put(left, right);

    }

    public int count() {
        return ctn;
    }
}

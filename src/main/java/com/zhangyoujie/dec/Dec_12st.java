package com.zhangyoujie.dec;

import java.util.*;

/**
 * @author zhangyoujie
 * @date 2023/12/12
 */
public class Dec_12st {

    public static void main(String[] args) {
        System.out.println(secondGreaterElement(new int[]{2, 4, 0, 6, 6}));
    }


    public static int[] secondGreaterElement(int[] nums) {
        int length = nums.length;
        int[] ans = new int[length];
        Arrays.fill(ans, -1);
        int[][] arr = new int[length][2];
        for (int i = 0; i < length; i++) {
            arr[i] = new int[]{nums[i], i};
        }
        /*
         * 按照值排序 值降序 如果值相同按照下标升序
         * 最大的元素肯定没有
         */
        Arrays.sort(arr, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int[] ints : arr) {
            int i = ints[1];
            //寻找比当前下标大的下标 为什么要按照值降序是因为 最大的元素肯定是没有下一个更大的元素的 倒着插入 可以找到比较小元素的最大值
            Integer j = treeSet.higher(i);
            if (null != j && null != treeSet.higher(j)) {
                ans[i] = nums[treeSet.higher(j)];
            }
            treeSet.add(i);
        }

        return ans;
    }
}

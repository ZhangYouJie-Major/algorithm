package com.zhangyoujie.dec;

/**
 * @author zhangyoujie
 * @date 2023/12/18
 */
public class Dec_18st {


    public int findPeakElement(int[] nums) {
        int length = nums.length;
        int index = 0;
        for (int i = 1; i < length; ++i) {
            if (nums[i] > nums[index]) {
                index = i;
            }
        }
        return index;
    }
}

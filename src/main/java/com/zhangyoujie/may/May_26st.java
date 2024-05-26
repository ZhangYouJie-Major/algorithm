package com.zhangyoujie.may;

public class May_26st {


    public int Trap(int[] height) {
        int length = height.length;

        int pre_max = 0;
        int suf_max = 0;
        int left = 0;
        int right = length - 1;

        int ans = 0;
        while (left <= right) {
            if (pre_max < suf_max) {
                ans += pre_max - height[left];
                pre_max = Math.max(pre_max, height[left]);
                left++;
            } else {
                ans += suf_max - height[right];
                suf_max = Math.max(suf_max, height[right]);
                right--;
            }

        }
        return ans;

    }

}

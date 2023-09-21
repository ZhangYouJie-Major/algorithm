package com.zhangyoujie;

import java.util.*;

/**
 * @author zhangyoujie
 * @date 2023/8/14
 */
public class Aug_14 {


    public static void main(String[] args) {
        int[] ints = circularGameLosers(5, 2);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    public static int[] circularGameLosers(int n, int k) {

        boolean[] visit = new boolean[n];
        for (int i = k, j = 0; !visit[j]; i += k) {
            visit[j] = true;
            j = (j + i) % n;
        }
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                list.add(i + 1);
            }
        }
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }


    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(((o1, o2) -> o1 - o2));

        int[] ans = new int[k + 1];

        int length = nums.length;
        int left = 0;
        int right = 0;
        int max = 0;

        for (int i = 0; i < k; i++) {
            max = Math.max(max, nums[i]);
            right = i;
            queue.offer(nums[i]);
        }
        while (right < length) {

//            if (queue.peek()>)


        }

        return new int[]{};
    }


    public static int equalSubstring(String s, String t, int maxCost) {
        int length = s.length();
        int left = 0;
        int right = 0;
        //窗口
        int sum = 0;
        int res = 0;

        while (right < length) {
            sum += Math.abs(s.charAt(right) - t.charAt(right));

            //移动左边减少
            while (sum > maxCost) {
                //窗口左边界右移
                sum -= Math.abs(s.charAt(left) - t.charAt(left));
                left++;
            }

            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;

    }
}

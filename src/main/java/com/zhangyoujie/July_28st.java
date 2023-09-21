package com.zhangyoujie;

import sun.plugin.WJcovUtil;

import javax.swing.text.html.HTMLWriter;
import java.util.*;

/**
 * @author zhangyoujie
 * @date 2023/7/28
 */
public class July_28st {

    public static void main(String[] args) {
//        Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        int[] ints = twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println(ints);
    }

    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }


    public static int[] twoSum(int[] nums, int target) {
        int length = nums.length;
        Arrays.sort(nums);
        int left = 0;
        int right = length - 1;
        while (left < right) {
            if (nums[left] + nums[right] < target) {
                left++;
            }
            if (nums[left] + nums[right] > target) {
                right--;
            }

            if (nums[left] + nums[right] == target) {
                return new int[]{nums[left], nums[right]};
            }
        }
        return new int[]{};

    }

    public static int[] finalPrices(int[] prices) {
        int length = prices.length;

        int[] ans = new int[length];

        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < length; i++) {
            while (!deque.isEmpty() && prices[deque.peek()] >= prices[i]) {
                Integer index = deque.pop();
                ans[index] = prices[index] - prices[i];
            }
            deque.push(i);
        }

        return ans;

    }


}

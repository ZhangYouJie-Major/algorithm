package com.zhangyoujie.jan;

import com.zhangyoujie.tool.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhangyoujie
 * @date 2024/1/6
 */
public class Jan_6st {
    // 18,6,10,3
    public static void main(String[] args) {
        minCost(new int[]{1, 2, 1, 2, 1}, 5);
    }


    public static int minCost(int[] nums, int k) {
        int length = nums.length;

        // dp[i+1] 表示前i个数的最小代价
        //  dp[i+1] = min(dp[i] + i - j +1 - unique(j,i) + k )
        int[] dp = new int[length + 1];
        int[] count = new int[length];
        for (int i = 0; i < length; ++i) {
            Arrays.fill(count, 0);
            int unique = 0;
            int mn = Integer.MAX_VALUE;
            for (int j = i; j >= 0; j--) {
                int x = nums[j];
                if (count[x] == 0) {
                    ++unique;
                } else if (count[x] == 1) {
                    --unique;
                }
                count[x]++;
                mn = Math.min(dp[j] - unique + i - j + 1, mn);
            }
            dp[i + 1] = k + mn;
        }
        return dp[length];
    }

    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode tail = head;
        while (tail.next != null) {
            //遍历节点的next为插入节点
            tail.next = new ListNode(gcd(tail.val, tail.next.val), tail.next);
            //遍历节点指向遍历节点的next节点
            tail = tail.next.next;
        }
        return head;
    }

    public int findGCD(int[] nums) {
        Arrays.sort(nums);
        return gcd(nums[0], nums[nums.length - 1]);

    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}

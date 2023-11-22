package com.zhangyoujie;

/**
 * @author zhangyoujie
 * @date 2023/11/22
 */


public class Nov_22st {

    public static void main(String[] args) {
        moveZeroes(new int[]{1, 0});
    }

    public static int minPathCost(int[][] grid, int[][] moveCost) {
        int row = grid.length;
        int col = grid[0].length;

        // 从0,0 移动到 i,j 花费的最小路径
        int[][] dp = new int[row][col];

        dp[0] = grid[0].clone();

        int ans = Integer.MAX_VALUE;

        for (int i = 1; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int min = Integer.MAX_VALUE;
                for (int k = 0; k < col; k++) {
                    min = Math.min(min, dp[i - 1][k] + moveCost[grid[i - 1][k]][j]);
                }
                dp[i][j] = min + grid[i][j];
            }
        }
        for (int i = 0; i < col; i++) {
            ans = Math.min(dp[row - 1][i], ans);
        }
        return ans;
    }


    public static void moveZeroes(int[] nums) {
        int length = nums.length;
        int left = 0;
        int right = left + 1;
        while (right < length) {
            if (nums[left] == 0) {
                if (nums[right] == 0) {
                    right++;
                } else {
                    int temp = nums[left];
                    nums[left] = nums[right];
                    nums[right] = temp;
                    left++;
                    right++;
                }
            } else {
                left++;
                right++;
            }
        }
    }


    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (null == headA || null == headB) return null;

        ListNode pA = headA;
        ListNode pB = headB;

        // 当第一个到达空时候 第二个到空的间距就是两个链表的差距n步 先遍历完的 先走第二次的n步
        // 则两个节点的遍历再第二次会一起到达公共节点
        while (pA != pB) {
            pA = null == pA ? headB :headA.next;
            pB = null == pB ? headA :headB.next;
        }
        return pA;

    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}

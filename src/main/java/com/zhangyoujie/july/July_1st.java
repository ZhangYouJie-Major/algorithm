package com.zhangyoujie.july;

import java.util.*;
import java.util.zip.Inflater;

/**
 * @author zhangyoujie
 * @date 2023/7/1
 */
public class July_1st {

    public static List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {

        List<Integer> list0 = new ArrayList<>(colsum.length);
        List<Integer> list1 = new ArrayList<>(colsum.length);

        int count = 0;

        for (int i = 0; i < colsum.length; i++) {
            count += colsum[i];
            list0.add(i, 0);
            list1.add(i, 0);
        }

        if (count != upper + lower) {
            return new ArrayList<>();
        }


        List<List<Integer>> result = new ArrayList<>();
        result.add(0, list0);
        result.add(1, list1);

        for (int i = 0; i < colsum.length; i++) {

            if (colsum[i] == 2) {

                upper--;
                lower--;
                List<Integer> upperList = result.get(0);
                List<Integer> lowerList = result.get(1);

                upperList.set(i, 1);
                lowerList.set(i, 1);
                result.set(0, upperList);
                result.set(1, lowerList);
            }
        }

        for (int i = 0; i < colsum.length; i++) {
            if (colsum[i] == 1) {

                if (upper > 0) {
                    List<Integer> upperList = result.get(0);
                    upperList.set(i, 1);
                    upper--;
                    continue;
                }

                if (lower > 0) {
                    List<Integer> lowerList = result.get(1);
                    lowerList.set(i, 1);
                    lower--;
                }
            }
        }

        if (upper != 0 || lower != 0) {
            return new ArrayList<>();
        }


        return result;
    }


    public boolean isCircularSentence(String sentence) {

        String[] s = sentence.split(" ");

        if (s.length == 1) {
            return s[0].charAt(0) == s[0].charAt(s[0].length() - 1);
        }

        if (s[0].charAt(0) != s[s.length - 1].charAt(s[s.length - 1].length() - 1)) {
            return false;
        }

        for (int i = 0; i < s.length - 1; i++) {
            if (s[i].charAt(s[i].length() - 1) != s[i + 1].charAt(0)) {
                return false;
            }

        }
        return true;
    }


    /**
     * 两数之和
     *
     * @param nums   数组
     * @param target 目标值
     * @return 数组
     * <p>
     * 通过哈希表来解决 时间复杂度O(n) 空间复杂度O(n)
     * 将target 减去数组中的每个元素，然后将结果作为key，数组下标作为value存入哈希表中
     */
    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(target - nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && map.get(nums[i]) != i) {
                return new int[]{i, map.get(nums[i])};
            }
        }
        return new int[]{};

    }

    /**
     * 删除链表的倒数第 N 个结点
     *
     * @param head 头结点
     * @param n    倒数第n个
     * @return 头结点
     * <p>
     * 通过快慢指针来解决 时间复杂度O(n) 空间复杂度O(1)
     * 1.快指针先走n步
     * 2.快慢指针同时走，当快指针走到尾部时，慢指针刚好走到倒数第n个节点
     * 3.删除倒数第n个节点
     */

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;

        while (n > 0) {
            fast = fast.next;
            n--;
        }
        if (fast == null) {
            return head.next;
        }

        while (fast.next != null && slow.next != null) {
            fast = fast.next;
            slow = slow.next;

        }
        if (slow.next != null) {
            slow.next = slow.next.next;
        } else {
            head = head.next;
        }
        return head;

    }

    /**
     * 不同路径
     *
     * @param m 行
     * @param n 列
     * @return 路径数
     * 动态规划 dp[i][j] = dp[i-1][j] + dp[i][j-1] dp[i][j]标识到达i,j的路径数
     */
    public int uniquePaths(int m, int n) {


        int[][] dp = new int[m][n];
        Arrays.fill(dp[0], 1);

        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }

        }

        return dp[m - 1][n - 1];
    }

    public static int longestAlternatingSubarray(int[] nums, int threshold) {
        int left = 0;
        int right = nums.length - 1;

        int max = 0;

        while (left <= right) {
            if (nums[right] > threshold) {
                right--;
                continue;
            }
            if (nums[left] % 2 != 0) {
                left++;
                continue;
            }

            boolean flag = true;
            boolean flag1 = true;

            for (int i = left; i < right; i++) {
                if (nums[i] > threshold) {
                    if (Math.abs(i - left) > Math.abs(i - right)) {
                        right = i - 1;
                    } else {
                        left = i + 1;
                    }
                    flag1 = false;
                    break;
                }
            }

            for (int i = left; i < right; i++) {
                if (nums[i] % 2 == nums[i + 1] % 2) {
                    flag = false;
                    break;
                }
            }
            if (!flag1) {
                continue;
            }
            if (flag) {
                max = Math.max(max, right - left + 1);
            }
            left++;

        }

        return max;
    }


    public static void main(String[] args) {
        int i = minSubArrayLen(11, new int[]{1, 2, 3, 4, 5});
        System.out.println(i);
    }

    public static int minSubArrayLen(int target, int[] nums) {

        int length = nums.length;
        if (length == 0) {
            return 0;
        }

        int[] sum = new int[length + 1];
        int ans = Integer.MAX_VALUE;
        sum[0] = 0;
        for (int i = 1; i <= length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }

        Arrays.sort(nums);

        //sum[j] -sum[i] > = target -->sum[j]  > =sum[i]+target
        for (int i = 1; i <= length; i++) {
            int s = sum[i - 1] + target;

            //  Arrays.binarySearch 寻找下标 当没找到是 返回-index 则顺序在 index-1之后
            int index = Arrays.binarySearch(sum, s);
            if (index < 0) {
                index = -index - 1;
            }
            if (index <= length) {
                ans = Math.min(ans, index - (i - 1));
            }

        }
        return ans == Integer.MAX_VALUE ? 0 : ans;

    }

    public static int findMiddleIndex(int[] nums) {

        int total = Arrays.stream(nums).sum();

        int tolalLeft = 0;

        for (int i = 0; i < nums.length; i++) {
            if (tolalLeft * 2 == total - nums[i]) {
                return i;
            }
            tolalLeft += nums[i];
        }

        return -1;

    }

    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }

        return left;
    }

//    public static int[][] merge(int[][] intervals) {
//
//        int[][] res = new int[intervals.length][intervals[0].length];
//
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < intervals.length; i++) {
//            map.put(intervals[i][0], intervals[i][1]);
//        }
//        int[][] temp = new int[intervals.length][intervals[0].length];
//        int index = 0;
//        for (Map.Entry<Integer, Integer> integerIntegerEntry : map.entrySet()) {
//            temp[index][0] = integerIntegerEntry.getKey();
//            temp[index][1] = integerIntegerEntry.getValue();
//            index++;
//        }
//
//
//        for (int i = 0; i < temp.length; i++) {
//            int left = temp[i][0];
//            int right = temp[i][1];
//            if (temp[i + 1][0] < right && temp[i + 1][1] < right) {
//                continue;
//            } else if ()
//
//
//        }
//
//
//        return new int[][]{};
//
//    }

    public static List<List<Integer>> threeSum(int[] nums) {

        Set<String> set = new HashSet<>();
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                continue;
            }

            //中间指针
            int mid = i + 1;

            int right = nums.length - 1;

            while (mid < right) {

                while (mid < right && nums[mid] + nums[right] + nums[i] > 0) {
                    right--;
                }
                if (mid == right) {
                    break;
                }
                if (nums[mid] + nums[right] + nums[i] == 0) {

                    String key = new StringBuffer().append(nums[i]).append(nums[mid]).append(nums[right]).toString();
                    if (!set.contains(key)) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[mid]);
                        list.add(nums[right]);
                        list.add(nums[i]);

                        res.add(list);
                        set.add(key);
                    }


                }
                mid++;
            }

        }

        return res;

    }

//    public int minFallingPathSum(int[][] matrix) {
//
//    }


    public static int alternateDigitSum(int n) {

        int sum = 0;
        Deque<Integer> digits = new ArrayDeque<>();
        while (n > 0) {
            digits.addLast(n % 10);
            n /= 10;
        }

        int index = 0;
        while (!digits.isEmpty()) {
            if (index % 2 == 0) {
                sum += digits.pollLast();
            } else {
                sum -= digits.pollLast();
            }
            index++;

        }
        return sum;

    }

//    public static long maxAlternatingSum(int[] nums) {
//
//
//
//    }


    public class ListNode {
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

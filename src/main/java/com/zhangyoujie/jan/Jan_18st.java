package com.zhangyoujie.jan;

import jdk.nashorn.internal.ir.annotations.Ignore;

import java.util.*;

/**
 * @author zhangyoujie
 * @date 2024/1/18
 */
public class Jan_18st {

    public static void main(String[] args) {
        System.out.println(fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
    }


    public List<List<Integer>> threeSum(int[] nums) {
        int length = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            if (nums[i] + nums[i + 1] + nums[i + 2] > 0) break;
            if (nums[i] + nums[length - 1] + nums[length - 2] < 0) continue;
            int left = i + 1;
            int right = length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    left++;
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    right--;
                } else if (sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return ans;
    }


    public static List<List<Integer>> fourSum(int[] nums, int target) {
        int length = nums.length;
        Arrays.sort(nums);

        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            if ((long) nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) break;
            if ((long) nums[i] + nums[length - 1] + nums[length - 2] + nums[length - 3] < target) continue;

            for (int j = i + 1; j < length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                if ((long) nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) break;
                if ((long) nums[i] + nums[j] + nums[length - 1] + nums[length - 2] < target) continue;

                int left = j + 1;
                int right = length - 1;
                while (left < right) {
                    long sum = nums[i] + nums[j] + nums[left] + nums[right];

                    if (sum == target) {
                        list.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        left++;
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        right--;
                    } else if (sum > target) {
                        right--;
                    } else {
                        left++;
                    }
                }

            }
        }
        return list;
    }

    public void merge(int[] A, int m, int[] B, int n) {
        int[] ans = new int[A.length];
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i <= m; i++) {
            queue.add(A[i]);
        }
        for (int i = 0; i <= n; i++) {
            queue.add(B[i]);
        }
        int index = 0;
        while (!queue.isEmpty()) {
            ans[index] = queue.poll();
            index++;
        }
        for (int i = 0; i < ans.length; i++) {
            A[i] = ans[i];
        }

    }

    public static long minimumRemoval(int[] beans) {
        Arrays.sort(beans);
        int length = beans.length;
        long total = 0;
        for (int i = 0; i < length; i++) {
            total += beans[i];
        }
        long ans = Long.MAX_VALUE;
        for (int i = 0; i < length; i++) {
            ans = Math.min(ans, total - (long) beans[i] * (length - i));
        }
        return ans;
    }
}

package com.zhangyoujie.nov;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author zhangyoujie
 * @date 2023/11/24
 */
public class Nov_24st {

    public static void main(String[] args) {
        System.out.println("i".compareTo("love"));
        System.out.println(topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 2));
    }


    public static List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            Integer count = map.getOrDefault(word, 0);
            count++;
            map.put(word, count);
        }
        List<String> list = new ArrayList<>(map.keySet());
        list.sort((o1, o2) -> map.get(o1).intValue() == map.get(o2).intValue() ?
                o1.compareTo(o2) : map.get(o2) - map.get(o1));
        return list.subList(0, k);


    }

    public int distributeCandies(int[] candyType) {
        Set<Integer> set = new HashSet<>();
        for (int i : candyType) {
            set.add(i);
        }
        return Math.min(candyType.length / 2, set.size());

    }

    //100000
    //011111
    public static int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            Integer integer = map.getOrDefault(num, 0);
            integer++;
            if (integer == 3) {
                map.remove(num);
            } else {
                map.put(num, integer);
            }
        }
        return map.keySet().iterator().next();
    }

    int ans = 0;

    public int pseudoPalindromicPaths(TreeNode root) {
        dfs(root, 0);
        return ans;
    }

    public void dfs(TreeNode node, int mask) {
        mask ^= 1 << node.val;
        if (null == node.left && null == node.right) {
            if ((mask & (mask - 1)) == 0) {
                ans++;
            }
        }
        if (null != node.left) {
            dfs(node.left, mask);
        }
        if (null != node.right) {
            dfs(node.right, mask);
        }
    }




    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set1.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            set2.add(nums2[i]);
        }
        set1.retainAll(set2);
        int[] ans = new int[set1.size()];

        int i = 0;
        for (Integer integer : set1) {
            ans[i] = integer;
            i++;
        }
        return ans;

    }

    public static void sortColors(int[] nums) {
        int length = nums.length;

        Set<String> set = new HashSet<>();
        int left = 0;
        int right = length - 1;
        for (int i = 0; i < length; i++) {
            while (i <= right && nums[i] == 2) {
                int temp = nums[i];
                nums[i] = nums[right];
                nums[right] = temp;
                --right;
            }

            if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[left];
                nums[left] = temp;
                ++left;
            }

        }
    }

    public static int[] countBits(int n) {

        int[] ans = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            String binaryString = Integer.toBinaryString(i);
            int sum = 0;
            for (int j = 0; j < binaryString.length(); j++) {
                if (binaryString.charAt(j) == '1') {
                    sum++;
                }
            }
            ans[i] = sum;
        }
        return ans;
    }

    public static boolean isPowerOfThree(int n) {
        int max = 2147483647;
        int target = 1;
        for (int i = 0; i < 31; i++) {
            if (target == n) {
                return true;
            }
            target *= 3;
            if (target > max) {
                break;
            }
        }
        return false;
    }

    public static int countPairs(List<Integer> nums, int target) {
        nums = nums.stream().sorted().collect(Collectors.toList());
        int size = nums.size();
        int left = 0;
        int right = left + 1;

        int ans = 0;
        while (right < size) {
            if (nums.get(left) + nums.get(right) < target) {
                ans++;
                right++;
            } else {
                left++;
                right = left + 1;
                continue;
            }
            if (right == size) {
                left++;
                right = left + 1;
            }

        }
        return ans;
    }

    public static int nthSuperUglyNumber(int n, int[] primes) {

        PriorityQueue<Integer> q = new PriorityQueue<>();
        q.add(1);
        while (n-- > 0) {
            int x = q.poll();
            if (n == 0) return x;
            for (int k : primes) {
                if (k <= Integer.MAX_VALUE / x) q.add(k * x);
                if (x % k == 0) break;
            }
        }
        return -1; // never
    }


    public static int lengthOfLIS(int[] nums) {

        int length = nums.length;
        // dp[i] 是以i结尾 递增子序列的长度 dp[i] = Math.max(dp[j]+1) 0 < j < i && num[i] > num[j]
        int[] dp = new int[length];
        dp[0] = 1;
        int max = 1;
        for (int i = 1; i < length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;

    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
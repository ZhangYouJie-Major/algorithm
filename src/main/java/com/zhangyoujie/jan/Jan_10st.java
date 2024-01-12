package com.zhangyoujie.jan;

import jdk.nashorn.internal.ir.IfNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhangyoujie
 * @date 2024/1/10
 */
public class Jan_10st {

    public static void main(String[] args) {
        Jan_10st st = new Jan_10st();
        System.out.println(st.combinationSum4(new int[]{1, 2, 3}, 4));
    }


    int[] nums;
    int target;
    int sum = 0;

    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i >= nums[j]) {
                    dp[i] += dp[i - nums[j]];
                }
            }
        }
        return dp[target];
    }


    public List<List<Integer>> palindromePairs(String[] words) {
        int n = words.length;
        long[] pows = new long[301];
        pows[0] = 1;
        // Calculate powers of 26 modulo mod3
        for (int i = 1; i < 301; i++) {
            pows[i] = (pows[i - 1] * 26) % 1000000007;
        }

        long[] hash = new long[n];
        long[] revHash = new long[n];

        // Calculate hash values for each word
        for (int i = 0; i < n; ++i) {
            int length = words[i].length();
            //构建正向hash
            for (int j = length - 1; j >= 0; j--) {
                hash[i] = (hash[i] + (words[i].charAt(j) - 'a' + 1) * pows[j]) % 1000000007;
            }
            //构建反向hash
            for (int j = 0; j < length; j++) {
                revHash[i] = (revHash[i] + (words[i].charAt(j) - 'a' + 1) * pows[j]) % 1000000007;
            }
        }

        List<List<Integer>> result = new ArrayList<>();

        // Check for palindrome pairs
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i == j) continue;
                int lengthI = words[i].length();
                int lengthJ = words[j].length();
                //如果两个字符串是回文串  则两个hash值相等
                if ((hash[i] * pows[lengthJ] + hash[j]) % 1000000007 ==
                        (revHash[j] * pows[lengthI] + revHash[i]) % 1000000007) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }

        return result;
    }

    int ans = 0;

    public int minLength(String s) {
        dfs(s);
        return ans;
    }

    void dfs(String s) {
        String s1 = "AB";
        String s2 = "CD";
        if (!s.contains(s1) && !s.contains(s2)) {
            ans = s.length();
            return;
        }
        s = s.replace(s1, "");
        s = s.replace(s2, "");
        dfs(s);
    }


    boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}

class Node {
    Node[] children = new Node[26];

    int index;

    public void insert(String word, int index) {
        Node node = this;
        int length = word.length();
        for (int i = 0; i < length; i++) {
            char ch = word.charAt(i);
            int pos = ch - 'a';
            if (children[pos] == null) {
                children[pos] = new Node();
            }
            node = node.children[pos];
        }
        this.index = index;
    }

    // 搜索当前输入字符的
    public Integer search(String word, int start, int end) {
        Node node = this;
        for (int i = end; i >= start; i--) {
            char ch = word.charAt(i);
            int pos = ch - 'a';
            if (node.children[pos] == null) {
                return null;
            }
            node = node.children[pos];
        }
        return index;
    }
}
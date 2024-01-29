package com.zhangyoujie.jan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhangyoujie
 * @date 2024/1/25
 */
public class Jan_25st {

    public static void main(String[] args) {
        Jan_25st st = new Jan_25st();

        System.out.println(st.findAnagrams("aaaaaaaaaa", "aaaaaaaaaaaaa"));
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        if (p.length() > s.length())
            return ans;


        int window = p.length();

        int[] ctn = new int[26];
        for (int i = 0; i < p.length(); i++) {
            ctn[p.charAt(i) - 'a']++;
        }

        int[] arr = new int[26];
        for (int i = 0; i < window; i++) {
            arr[s.charAt(i) - 'a']++;
        }
        if (Arrays.equals(ctn, arr)) {
            ans.add(0);
        }

        for (int i = 1; i < s.length() - (window - 1); i++) {
            arr[s.charAt(i - 1) - 'a']--;
            arr[s.charAt(i + window - 1) - 'a']++;
            if (Arrays.equals(ctn, arr)) {
                ans.add(i);
            }
        }
        return ans;
    }

    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) return false;
        int window = s1.length();

        int[] ctn1 = new int[26];
        int[] ctn2 = new int[26];

        for (int i = 0; i < window; i++) {
            ctn1[s1.charAt(i) - 'a']++;
        }

        for (int i = 0; i < window; i++) {
            ctn2[s2.charAt(i) - 'a']++;
        }
        boolean flag = false;
        flag = Arrays.equals(ctn1, ctn2);
        if (flag) {
            return flag;
        }

        for (int i = 1; i < s2.length() - (window - 1); i++) {
            ctn2[s2.charAt(i - 1) - 'a']--;
            ctn2[s2.charAt(i + window - 1) - 'a']++;
            flag = Arrays.equals(ctn1, ctn2);

            if (flag) {
                return flag;
            }
        }
        return false;

    }

    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int sum = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (Integer.bitCount(i) == k)
                sum += nums.get(i);
        }
        return sum;
    }

    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int length = nums.length;
        int base = 50;

        // 因为 nums[i]的值域很小 如果采用优先队列求第k和最小数容易超时 我们可以通计数排序的原理 维护一个ctn
        // 每次遍历ctn 找到第x小的数值
        int[] ans = new int[length - k + 1];
        int[] ctn = new int[2 * base + 1];
        for (int i = 0; i < k; i++) {
            ctn[nums[i] + base]++;
        }


        int x1 = x;
        for (int m = 0; m < ctn.length; m++) {
            if (x1 - ctn[m] <= 0) {
                ans[0] = Math.min((m - base), 0);
                break;
            }
            x1 -= ctn[m];
        }

        for (int i = 1; i < length - (k - 1); i++) {
            x1 = x;
            ctn[nums[i - 1] + base]--;
            ctn[nums[i + k - 1] + base]++;

            for (int m = 0; m < ctn.length; m++) {
                if (x1 - ctn[m] <= 0) {
                    ans[i] = Math.min((m - base), 0);
                    break;
                }
                x1 -= ctn[m];
            }

        }
        return ans;
    }
}

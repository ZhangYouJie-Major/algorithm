package com.zhangyoujie.jan;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangyoujie
 * @date 2024/1/11
 */
public class Jan_11st {

    public static void main(String[] args) {
        System.out.println(numSubarraysWithSum(new int[]{1, 0, 1, 0, 1}, 2));
    }


    public static int numSubarraysWithSum(int[] nums, int goal) {

        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int ans = 0;
        for (int num : nums) {
            map.put(sum, map.getOrDefault(sum, 0) + 1);
            sum += num;
            // sum[j] - sum[i] = goal  我们记录每次 sum[j] - goal = sum[i]
            // 因此我们遍历到sum[j]  找出对应  sum[j] - goal 对应的计数即可
            ans += map.getOrDefault(sum - goal, 0);
        }

        return ans;
    }

    public static long wonderfulSubstrings(String word) {
        int length = word.length();
        int[] count = new int[10];

        long ans = 0;
        int left = 0;
        for (int i = 0; i < length; i++) {
            count[word.charAt(i) - 'a']++;
            if (!isOk(count)) {
                while (left < i) {
                    if (!isOk(count)) {
                        left++;
                    }
                }
                ans += (i - left) + 1;
            } else {
                ans++;
            }
        }
        return ans;

    }

    public static boolean isOk(int[] count) {
        int ctn = 0;
        for (int j = 0; j < 10; j++) {
            if (count[j] % 2 != 0) {
                ctn++;
            }
        }
        return ctn <= 1;
    }


    public static int minDeletions(String s) {
        int[] count = new int[26];
        int length = s.length();

        for (int i = 0; i < length; i++) {
            int ch = s.charAt(i) - 'a';
            count[ch]++;
        }
        Arrays.sort(count);
        int ans = 0;
        for (int i = count.length - 1; i >= 1; i--) {
            if (count[i] == count[i - 1] && count[i] > 0) {
                // 先把i-1 减去1
                count[i - 1]--;
                ans++;
                for (int j = i - 2; j >= 0; j--) {
                    if (count[j] > count[i - 1]) {
                        count[j]--;
                        ans++;
                    }
                }
            }
        }

        return ans;
    }

    public static int addMinimum(String word) {
        int length = word.length();

        String s = "abc";

        // 不断地循环s 如果直接 +1 最后再判断末尾的字符 如果是b 需要+1 如果是a需要+2
        int ans = 0;
        for (int i = 0, j = 0; j < length; i = (i + 1) % 3) {
            if (s.charAt(i) != word.charAt(j)) {
                ++ans;
            } else {
                j++;
            }
        }
        if (s.charAt(length - 1) != 'c') {
            ans += s.charAt(length - 1) == 'b' ? 1 : 2;
        }
        return ans;

    }
}

package com.zhangyoujie.jan;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author zhangyoujie
 * @date 2024/1/22
 */
public class Jan_22st {

    public static void main(String[] args) {
        Jan_22st st = new Jan_22st();
        System.out.println(st.groupAnagrams(new String[]{"", ""}));

    }

    public List<List<String>> groupAnagrams(String[] strs) {
        return new ArrayList<>(Arrays.stream(strs).collect(Collectors.groupingBy(item -> {
            char[] charArray = item.toCharArray();
            Arrays.sort(charArray);
            return new String(charArray);
        })).values());
    }

    public int minimumPushes(String word) {
        int length = word.length();
        char[] arr = word.toCharArray();
        int[] ctn = new int[26];
        for (int i = 0; i < length; i++) {
            ctn[arr[i] - 'a']++;
        }
        Arrays.sort(ctn);
        int ans = 0;
        for (int i = 0; i < 26; i++) {
            ans += (ctn[25 - i]) * (i / 8 + 1);
        }
        return ans;
    }

    public int lastStoneWeightII(int[] stones) {
        int length = stones.length;
        int sum = Arrays.stream(stones).sum();
        // 设置-的石头为neg +为 sum - neg ->  sum- 2 * neg >=0
        int neg = sum / 2;
        int[][] dp = new int[length + 1][neg + 1];
        for (int i = 1; i <= length; i++) {
            for (int j = 0; j <= neg; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= stones[i - 1])
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - stones[i - 1]] + stones[i - 1]);
            }
        }
        return Math.abs(sum - 2 * dp[length][neg]);

    }


    public int maximumSwap(int num) {
        char[] charArray = String.valueOf(num).toCharArray();
        int length = charArray.length;
        int maxIndex = length - 1;
        int p = -1, q = 0;
        // 从右往左遍历 标记最大值的下标
        for (int i = length - 2; i >= 0; i--) {
            if (charArray[maxIndex] < charArray[i]) {
                //更新最大值
                maxIndex = i;
            } else if (charArray[maxIndex] > charArray[i]) {
                p = i;
                q = maxIndex;
            }
        }
        if (p == -1) {
            return num;
        }
        char temp = charArray[q];
        charArray[q] = charArray[p];
        charArray[p] = temp;

        return Integer.parseInt(new String(charArray));

    }
}

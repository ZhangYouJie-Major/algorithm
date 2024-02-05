package com.zhangyoujie.feb;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author zhangyoujie
 * @date 2024/2/4
 */
public class Feb_4st {


    public int returnToBoundaryCount(int[] nums) {
        int length = nums.length;
        int sum = 0;
        int count = 0;
        for (int i = 0; i < length; i++) {
            sum += nums[i];
            if (sum == 0) {
                count++;
            }
        }
        return count;

    }

    String word = "";
    int min = Integer.MAX_VALUE;

    public int minimumTimeToInitialState(String word, int k) {
        dfs(word, 0, k);
        return min;
    }

    private void dfs(String target, int count, int k) {
        if (Objects.equals(target, word) && count != 0) {
            min = Math.min(min, count);
            return;
        }
        if (count > word.length() / k) {
            return;
        }
        StringBuilder delete = new StringBuilder(word).delete(0, k + 1);
        List<String> list = creatWord(k);
        for (String s : list) {
            delete.append(s);
            dfs(delete.toString(), count + 1, k);
        }

    }

    private List<String> creatWord(int k) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            list.add(String.valueOf(('a' + i)));
        }
        for (int i = 0; i < k - 1; i++) {
            for (int j = 0; j < 26; j++) {
                for (int m = 0; m < list.size(); m++) {
                    list.add(m, list.get(m) + ('a' + j));
                }
            }
        }
        return list;
    }


    public int stoneGameVII(int[] stones) {
        int length = stones.length;
        int[] pre = new int[length + 1];
        for (int i = 0; i < length; i++) {
            pre[i + 1] = pre[i] + stones[i];
        }
        int[][] memo = new int[length][length];

        return dfs(0, length - 1, pre, memo);
    }

    private int dfs(int i, int j, int[] pre, int[][] memo) {
        if (i == j) {
            return 0;
        }
        if (memo[i][j] > 0) {
            return memo[i][j];
        }
        // dfs(i,j) 表示从i->j 先手减去后手的最大值
        /*
         * 例如[5,3,1,4,2] alice移除最右边的2  Alice的最大值为A Bob的最大值为B dfs(0,4) = A - B   A = sum(0,4)
         * dfs(0,3) = B1 - A1 由于 A = sum(0,4) + A1   B1 =
         *
         *
         */
        // dfs(i,j) = Max(sum(i+i,j)-dfs(i+1,j), sum(i,j-1)-dfs(i,j-1))
        // 枚举选左边
        int res1 = pre[j + 1] - pre[i + 1] - dfs(i + 1, j, pre, memo);
        int res2 = pre[j] - pre[i] - dfs(i, j - 1, pre, memo);
        return memo[i][j] = Math.max(res1, res2);
    }
}

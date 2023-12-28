package com.zhangyoujie.dec;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author zhangyoujie
 * @date 2023/12/27
 */
public class Dec_27st {
    

    private List<List<Integer>> ans = new ArrayList<>();
    private int[] nums;

    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums;
        dfs(0, new ArrayList<>());
        return ans;
    }

    private void dfs(int i, List<Integer> path) {
        List<Integer> temp = new ArrayList<>(path);
        if (i == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }
        //不选num[i]
        dfs(i + 1, path);
        //选
        path.add(nums[i]);
        dfs(i + 1, path);

    }

    public static int isWinner(int[] player1, int[] player2) {
        int length = player1.length;

        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < length; i++) {
            if ((i >= 1 && player1[i - 1] == 10) || (i >= 2 && player1[i - 2] == 10)) {
                sum1 += 2 * player1[i];
            } else {
                sum1 += player1[i];
            }

            if ((i >= 1 && player2[i - 1] == 10) || (i >= 2 && player2[i - 2] == 10)) {
                sum2 += 2 * player2[i];
            } else {
                sum2 += player2[i];
            }
        }
        return sum1 == sum2 ? 0 : sum1 > sum2 ? 1 : 2;
    }
}

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


    public static void main(String[] args) {

        List<List<Integer>> subsets = subsets(new int[]{1, 2, 3});

    }


    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int c = 0;
        for (int i = 0; i < nums.length; i++) {
            c = c | (1 << (10 + nums[i]));
        }
        // for (int sub = c; sub > 0; sub = (sub - 1) & c) 枚举所有的子集
        for (int sub = c; sub > 0; sub = (sub - 1) & c) {
            List<Integer> temp = new ArrayList<>();

            StringBuilder s = new StringBuilder(Integer.toBinaryString(sub));
            String binaryString = s.reverse().toString();
            for (int i = binaryString.toCharArray().length - 1; i >= 0; i--) {
                if (binaryString.charAt(i) == '1') {
                    temp.add(i - 10);
                }
            }
            ans.add(temp);
        }
        ans.add(new ArrayList<>());
        return ans;

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

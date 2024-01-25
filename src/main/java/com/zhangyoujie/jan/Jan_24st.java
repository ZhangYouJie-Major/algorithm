package com.zhangyoujie.jan;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author zhangyoujie
 * @date 2024/1/24
 */
public class Jan_24st {

    public static void main(String[] args) {
        Jan_24st st = new Jan_24st();
        System.out.println(st.maxScore(new int[]{96, 90, 41, 82, 39, 74, 64, 50, 30}, 8));
    }

    public int countCompleteSubstrings(String word, int k) {
        int length = word.length();
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = word.charAt(i) - 'a';
        }

        return 1;

    }


    public int maxScore(int[] cardPoints, int k) {
        int length = cardPoints.length;
        int window = length - k;
        int sum = Arrays.stream(cardPoints).sum();

        int min = 0;
        int windowsSum = 0;
        for (int i = 0; i < window; i++) {
            windowsSum += cardPoints[i];
        }
        min = windowsSum;

        for (int i = 1; i < length - (window - 1); i++) {
            int a = cardPoints[i + window - 1];
            int b = cardPoints[i - 1];
            windowsSum += (a - b);
            min = Math.min(min, windowsSum);
        }

        return sum - min;

    }

    public long maximumSumOfHeights(List<Integer> maxHeights) {
        int size = maxHeights.size();

        long max = 0;
        for (int i = 0; i < size; i++) {
            long sum = 0;
            int leftMax = maxHeights.get(i);
            int rightMax = maxHeights.get(i);

            for (int j = i - 1; j >= 0; j--) {
                if (maxHeights.get(j) > leftMax) {
                    sum += leftMax;
                } else {
                    leftMax = maxHeights.get(j);
                    sum += leftMax;
                }
            }
            sum += maxHeights.get(i);
            for (int j = i + 1; j < size; j++) {
                if (maxHeights.get(j) > rightMax) {
                    sum += rightMax;
                } else {
                    rightMax = maxHeights.get(j);
                    sum += rightMax;
                }
            }
            max = Math.max(max, sum);
        }
        return max;
    }

    public int mySqrt(int x) {

        double res = 10;
        for (int i = 0; i < 10; i++) {
            res -= (res * res - x) / (2 * res);
        }
        return (int) res;
    }


    public int maxVowels(String s, int k) {

        Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        char[] arr = s.toCharArray();

        int length = s.length();
        int max = 0;
        int count = 0;
        for (int i = 0; i < k; i++)
            if (set.contains(arr[i]))
                count++;

        max = count;
        for (int i = 1; i < length - k + 1; i++) {
            if (set.contains(arr[i + k - 1]))
                count++;
            if (set.contains(arr[i - 1]))
                count--;
            max = Math.max(max, count);
        }
        return max;


    }
}

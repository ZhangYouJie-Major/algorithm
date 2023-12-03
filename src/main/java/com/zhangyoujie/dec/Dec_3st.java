package com.zhangyoujie.dec;

public class Dec_3st {

    public static void main(String[] args) {
        System.out.println(maxScore(new int[]{1, 2, 3, 4, 5, 6, 1}, 3));
    }

    public static int maxScore(int[] cardPoints, int k) {

        int sum = 0;
        int windows = cardPoints.length - k;
        //k个边界值最大 反向就是取n-k个连续的值最小
        int windowsSum = 0;
        for (int i = 0; i < cardPoints.length; i++) {
            sum += cardPoints[i];
        }
        for (int i = 0; i < windows; i++) {
            windowsSum += cardPoints[i];
        }
        int minw = windowsSum;
        for (int i = windows; i < cardPoints.length; i++) {
            windowsSum = windowsSum + cardPoints[i] - cardPoints[i - windows];
            minw = Math.min(windowsSum, minw);
        }

        return sum - minw;

    }
}

package com.zhangyoujie.dec;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Dec_16st {

    public static void main(String[] args) {
        System.out.println((char) ('a' + 17));
        System.out.println((char) ('b' + 8));
        System.out.println((char) ('c' + 17));
        //  1 3 5 7
        // 1 4 9 16
        // 16 15 12 7
        System.out.println(minCostClimbingStairs(new int[]{1, 2, 3, 4}));
    }

    public static int minCostClimbingStairs(int[] cost) {
        int length = cost.length;
        int[] dp = new int[length + 2];
        dp[0] = dp[1] = 0;

        for (int i = 2; i <= length; i++) {
            dp[i] = Math.min(cost[i - 1] + dp[i - 1], cost[i - 2] + dp[i - 2]);
        }
        return dp[length];

    }

    public int uniqueMorseRepresentations(String[] words) {
        Map<String, String> map = new HashMap<>();
        map.put("a", ".-");
        map.put("b", "-...");
        map.put("c", "-.-.");
        map.put("d", "-..");
        map.put("e", ".");
        map.put("f", "..-.");
        map.put("g", "--.");
        map.put("h", "....");
        map.put("i", "..");
        map.put("j", ".---");
        map.put("k", "-.-");
        map.put("l", ".-..");
        map.put("m", "--");
        map.put("n", "-.");
        map.put("o", "---");
        map.put("p", ".--.");
        map.put("q", "--.-");
        map.put("r", ".-.");
        map.put("s", "...");
        map.put("t", "-");
        map.put("u", "..-");
        map.put("v", "...-");
        map.put("w", ".--");
        map.put("x", "-..-");
        map.put("y", "-.--");
        map.put("z", "--..");
        Set<String> set = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < words[i].length(); j++) {
                stringBuilder.append(map.get(String.valueOf(words[i].charAt(j))));
            }
            set.add(stringBuilder.toString());
        }
        return set.size();
    }

    public static String shiftingLetters(String s, int[] shifts) {
        int length = shifts.length;
        int cnt = 0;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = length - 1; i >= 0; i--) {
            cnt += shifts[i] % 26;
            int step = s.charAt(i) - 'a' + cnt;
            stringBuffer.append((char) ('a' + (step % 26)));
        }
        return stringBuffer.reverse().toString();
    }
}

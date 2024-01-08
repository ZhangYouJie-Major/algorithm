package com.zhangyoujie.dec;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class Dec_30st {

    public static void main(String[] args) {
        System.out.println(dismantlingAction("abba"));
    }


    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        int s1cnt = 0;
        int s2cnt = 0;
        int index = 0;
        Map<Integer, int[]> recall = new HashMap<Integer, int[]>();
        int[] preLoop = new int[2];
        int[] inLoop = new int[2];
        while (true) {
            ++s1cnt;
            for (int i = 0; i < s1.length(); ++i) {
                char ch = s1.charAt(i);
                if (ch == s2.charAt(index)) {
                    index++;
                }
            }
        }

    }

    public int dayOfYear(String date) {
        String[] split = date.split("-");
        LocalDate localDate = LocalDate.of(Integer.valueOf(split[0]), Integer.valueOf(split[1]), Integer.valueOf(split[2]));
        return localDate.getDayOfYear();

    }

    public static int dismantlingAction(String arr) {
        int length = arr.length();
        Map<Character, Integer> map = new HashMap<>();

        int left = 0;
        int max = 0;
        for (int i = 0; i < length; i++) {
            char charAt = arr.charAt(i);
            if (map.containsKey(charAt)) {
                left = Math.max(map.get(charAt) + 1, left);
            }
            map.put(charAt, i);
            max = Math.max(i - left + 1, max);
        }
        return max;

    }


    public int[] twoSum(int[] numbers, int target) {
        int length = numbers.length;
        int left = 0;
        int right = length - 1;
        int ans1 = 0;
        int ans2 = 0;

        while (left < right) {
            if (numbers[left] + numbers[right] > target) {
                right--;
            }
            if (numbers[left] + numbers[right] < target) {
                left++;
            }
            if (numbers[left] + numbers[right] == target) {
                ans1 = left + 1;
                ans2 = right + 1;
                return new int[]{ans1, ans2};
            }
        }
        return new int[]{};

    }

    public String dayOfTheWeek(int day, int month, int year) {
        String[] week = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        LocalDate time = LocalDate.of(year, month, day);
        return week[time.getDayOfWeek().getValue() % 7];

    }
}

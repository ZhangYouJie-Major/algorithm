package com.zhangyoujie.nov;

import java.util.*;

/**
 * @author zhangyoujie
 * @date 2023/11/30
 */
public class NOV_30st {

    public static void main(String[] args) {
        System.out.println(uniqueLetterString("ABC"));
    }

    public static int uniqueLetterString(String s) {
        int res = 0;
        // 如果s为n位字符 字符x 在[1,5,8]的位置  则[0,4] [2,7] [6,n]都是唯一的下标
        int length = s.length();

        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), new ArrayList<>());
                map.get(s.charAt(i)).add(-1);
            }
            map.get(s.charAt(i)).add(i);
        }

        for (Map.Entry<Character, List<Integer>> characterListEntry : map.entrySet()) {
            List<Integer> value = characterListEntry.getValue();
            value.add(s.length());
            for (int i = 1; i < value.size() - 1; i++) {
                res += ((value.get(i) - value.get(i - 1)) * (value.get(i + 1) - value.get(i)));
            }
        }
        return res;

    }

    public static int maximumSum(int[] nums) {

        int max = -1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int target = nums[i];
            int sum = 0;
            while (target != 0) {
                sum += target % 10;
                target /= 10;
            }
            if (map.containsKey(sum)) {
                max = Math.max(max, nums[i] + nums[map.get(sum)]);
                map.put(sum, nums[i] > nums[map.get(sum)] ? i : map.get(sum));
            } else {
                map.put(sum, i);
            }
        }
        return max;

    }

    public static List<String> findRepeatedDnaSequences(String s) {

        List<String> ans = new ArrayList<>();
        int length = s.length();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i <= length - 10; i++) {
            String sub = s.substring(i, i + 10);
            map.put(sub, map.getOrDefault(sub, 0) + 1);
            if (map.get(sub) > 1) {
                ans.add(sub);
            }
        }
        return ans;
    }

    public static boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        if (word1.equals(word2)) {
            return true;
        }

        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        Map<Integer, Integer> map3 = new HashMap<>();
        Map<Integer, Integer> map4 = new HashMap<>();


        for (int i = 0; i < word1.length(); i++) {
            map1.put(word1.charAt(i), map1.getOrDefault(word1.charAt(i), 0) + 1);
        }
        for (int i = 0; i < word2.length(); i++) {
            map2.put(word2.charAt(i), map2.getOrDefault(word2.charAt(i), 0) + 1);
        }
        map1.forEach((k, v) -> {
            map3.put(v, map3.getOrDefault(v, 0) + 1);
        });
        map2.forEach((k, v) -> {
            map4.put(v, map4.getOrDefault(v, 0) + 1);
        });
        return map3.equals(map4);

    }

    public static int sumSubarrayMins(int[] arr) {
        int mod = 1000000007;

        int length = arr.length;
        long ans = 0;

        int[] left = new int[length];
        int[] right = new int[length];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < length; i++) {
            // 维护一个单调递增栈
            while (!deque.isEmpty() && arr[i] <= arr[deque.peek()]) {
                deque.pop();
            }
            left[i] = i - (deque.isEmpty() ? -1 : deque.peek());
            deque.push(i);
        }
        deque.clear();
        for (int i = length - 1; i >= 0; i--) {
            // 维护一个单调递增栈
            while (!deque.isEmpty() && arr[i] < arr[deque.peek()]) {
                deque.pop();
            }
            right[i] = (deque.isEmpty() ? length : deque.peek()) - i;
            deque.push(i);
        }
        for (int i = 0; i < length; i++) {
            ans = (ans + ((long) arr[i] * left[i] * right[i])) % mod;
        }
        return (int) ans;
    }
}

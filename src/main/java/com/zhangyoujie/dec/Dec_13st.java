package com.zhangyoujie.dec;

import java.util.*;

/**
 * @author zhangyoujie
 * @date 2023/12/13
 */
public class Dec_13st {

    public static void main(String[] args) {
        System.out.println(checkDynasty(new int[]{0, 6, 9, 0, 7}));
    }

    public static boolean checkDynasty(int[] places) {
        Arrays.sort(places);
        int length = places.length;
        int zero = 0;
        int unZero = 0;
        int max = places[length - 1];
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < length; i++) {
            if (places[i] != 0) {
                set.add(places[i]);
            } else {
                zero++;
            }
        }
        for (int i = max - length + 1; i <= max; i++) {
            if (!set.contains(i)) {
                unZero++;
            }
        }
        return zero == unZero;
    }

    public static int[] nextGreaterElements(int[] nums) {
        int length = nums.length;
        int[] ans = new int[length];
        Arrays.fill(ans, -1);
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < 2 * length; i++) {
            int index = i % length;
            while (!deque.isEmpty() && nums[deque.peek()] < nums[index]) {
                Integer pop = deque.pop();
                ans[pop] = nums[index];
            }
            deque.push(index);
        }
        return ans;
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int[] ans = new int[length1];
        Arrays.fill(ans, -1);
        for (int i = 0; i < length1; i++) {
            for (int j = 0; j < length2; j++) {
                if (nums2[j] == nums1[i]) {
                    int k = j + 1;
                    while (k < length2) {
                        if (nums2[k] > nums1[i]) {
                            ans[i] = nums2[k];
                            break;
                        }
                        k++;
                    }
                }
            }
        }
        return ans;

    }

    public String makeSmallestPalindrome(String s) {
        char[] charArray = s.toCharArray();
        int length = charArray.length;

        int left = 0;
        int right = length - 1;
        while (left < right) {
            if (charArray[left] != charArray[right]) {
                charArray[left] = charArray[right] = (char) Math.min(charArray[left], charArray[right]);
            }
            left++;
            right--;
        }
        return new String(charArray);
    }
}

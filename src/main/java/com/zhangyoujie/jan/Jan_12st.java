package com.zhangyoujie.jan;

import java.util.*;

/**
 * @author zhangyoujie
 * @date 2024/1/12
 */
public class Jan_12st {


    public static void main(String[] args) {
//        int[] nums = new int[]{1, 5, 4, 4, 7, 3, 1};
//        int[] pre = new int[nums.length + 1];
//        int[] diff = new int[nums.length];
//
//        diff[0] = nums[0];
//        for (int i = 1; i < nums.length; i++) {
//            diff[i] = nums[i] - nums[i - 1];
//        }
//        diff[2] += 2;
//        diff[5] -= 2;
//
//        int[] ans = new int[nums.length];
//        ans[0] = diff[0];
//        for (int i = 1; i < diff.length; i++) {
//            ans[i] += diff[i] + nums[i - 1];
//        }
//        System.out.println(ans);
        System.out.println(convert("PAYPALISHIRING", 3));
    }


    public static List<List<Integer>> threeSum(int[] nums) {
        int length = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1;
            int right = length - 1;
            //和最小的两个数相加都大于零 直接终止
            if (nums[i] + nums[left] + nums[left + 1] > 0) break;
            // 和最大的两个数相加都小于零 直接跳过
            if (nums[i] + nums[right] + nums[right - 1] < 0) continue;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    ans.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    right--;
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                }
            }
        }
        return ans;
    }

    public static int threeSumClosest(int[] nums, int target) {
        int length = nums.length;
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        int[] a = new int[3];
        for (int i = 0; i < length - 2; i++) {
            for (int j = i + 1; j < length - 1; j++) {
                for (int k = j + 1; k < length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (Math.abs(sum - target) < diff) {
                        diff = Math.abs(sum - target);
                        a = new int[]{nums[i], nums[j], nums[k]};
                    }
                }
            }
        }
        return a[0] + a[1] + a[2];
    }

    public static String convert(String s, int numRows) {
        if (numRows < 2) {
            return s;
        }
        List<StringBuffer> rows = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuffer());
        }
        int i = 0;
        int flag = -1;
        for (char c : s.toCharArray()) {
            rows.get(i).append(c);
            if (i == 0 || i == numRows - 1) flag = -flag;
            i += flag;
        }
        String ans = "";
        for (StringBuffer row : rows) {
            ans += row.toString();
        }
        return ans;
    }


    public int subarraySum(int[] nums, int k) {
        int length = nums.length;
        int ans = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            map.put(sum, map.getOrDefault(sum, 0) + 1);
            sum += nums[i];
            ans += map.getOrDefault(sum - k, 0);
        }
        return ans;


    }

    public static int findTheLongestSubstring(String s) {
        int length = s.length();

        int[] pos = new int[1 << 5];
        //用-1填充 区分00000的情况
        Arrays.fill(pos, -1);
        // 用五位进制来表示二进制aeiou的每一位的奇偶 0表示偶数 1表示基数
        //这样我们就可以把五位字母出现的次数的奇偶压缩到((00000)2,(11111)2) 即十进制(0,31)中
        // 11001 例如此时字符串为 aeu为奇数 io为偶数 如果下一个字符为i和a 为 11001 ^ 00100  = 11101 -> 11101 ^ 10000 = 01101
        // 定义当前位置是x
        // x 是0  异或1为1 异或0为0(即当前位置不变)  即从偶数可以+1变成奇数 或者偶数不变
        // x 是1  异或1为0 异或0为1(当前位置不变)    即从奇数+1可以变成偶数  或者奇数不变
        // 从上面的例子可以看出 我们每次异或 只会影响特定位置的

        int ans = 0;
        int status = 0;
        pos[0] = 0;
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            if (ch == 'a') {
                status ^= (1 << 0);
            } else if (ch == 'e') {
                status ^= (1 << 1);
            } else if (ch == 'i') {
                status ^= (1 << 2);
            } else if (ch == 'o') {
                status ^= (1 << 3);
            } else if (ch == 'u') {
                status ^= (1 << 4);
            }
            // 如果有存在基数全是偶数 找出上一个基数的位置 或者偶数的位置
            // 初始话的偶数是pos[0] = 0 即空字符串
            if (pos[status] >= 0) {
                ans = Math.max(ans, i - pos[status] + 1);
            } else {
                pos[status] = i + 1;
            }
        }
        return ans;

    }

    public int countWords(String[] words1, String[] words2) {

        Map<String, Integer> map = new HashMap<>();
        for (String word : words1) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        for (String word : words2) {
            map.put(word, map.getOrDefault(word, 0) + 1000);
        }

        int ans = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1001) {
                ans++;
            }
        }
        return ans;

    }
}

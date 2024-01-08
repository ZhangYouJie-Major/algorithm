package com.zhangyoujie.jan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhangyoujie
 * @date 2024/1/8
 */
public class Jan_8st {

    public static void main(String[] args) {
        Jan_8st st = new Jan_8st();

        System.out.println(st.partition("aab"));
    }

    List<List<String>> ans = new ArrayList<>();
    List<String> path = new ArrayList<>();

    String s;

    public List<List<String>> partition(String s) {
        // aab  选逗号的地方 a,ab  a,a,b  插入逗号的下标只能是小于length-1
        this.s = s;
        dfs(0, 0);
        return ans;
    }

    public void dfs(int start, int end) {
        int length = s.length();
        if (start == length) {
            ans.add(new ArrayList<>(path));
            return;
        }
        //不选end插入逗号
        if (end < length - 1)
            dfs(start, end + 1);
        //选择end插入逗号
        if (isPalindrome(start, end)) {
            // 判断start end 是否为回文串
            path.add(s.substring(start, end + 1));
            // 选择end的下一个字符
            dfs(end + 1, end + 1);
            path.remove(path.size() - 1);
        }
    }

    public boolean isPalindrome(int left, int right) {
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) return false;
        }
        return true;
    }

    public static int numberOfBoomerangs(int[][] points) {
        int length = points.length;
        int count = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (i == j) continue;
                for (int k = 0; k < length; k++) {
                    if (j == k || k == i) continue;
                    int x1 = points[i][0];
                    int y1 = points[i][1];
                    int x2 = points[j][0];
                    int y2 = points[j][1];
                    int x3 = points[k][0];
                    int y3 = points[k][1];

                    int l = (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
                    int r = (x1 - x3) * (x1 - x3) + (y1 - y3) * (y1 - y3);
                    if (l == r) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}

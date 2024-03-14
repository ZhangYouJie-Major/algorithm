package com.zhangyoujie.mar;


import java.util.Arrays;
import java.util.StringJoiner;

/**
 * @author zhangyoujie
 * @date 2024/3/8
 */
public class Mar_8st {


    public int minimumPossibleSum(int n, int target) {
        int mod = (int) 1e9 + 7;
        int m = Math.min(target / 2, n);
        return (int) ((m * (m + 1) + (target + target + n - m - 1) * (n - m)) / 2 % mod);

    }

    public static void main(String[] args) {
        Mar_8st mar8st = new Mar_8st();
        System.out.println(mar8st.capitalizeTitle("L hV"));
    }

    public String capitalizeTitle(String title) {

        StringJoiner ans = new StringJoiner(" ");

        Arrays.stream(title.split(" "))
                .forEach(item -> {
                    char[] charArray = item.toCharArray();
                    if (item.length() > 2) {
                        for (int i = 0; i < charArray.length; i++) {
                            if (i == 0) {
                                charArray[i] = Character.toUpperCase(charArray[i]);
                            } else {
                                charArray[i] = Character.toLowerCase(charArray[i]);
                            }
                        }
                    } else {
                        for (int i = 0; i < charArray.length; i++) {
                            charArray[i] = Character.toLowerCase(charArray[i]);
                        }

                    }
                    ans.add(new String(charArray));

                });
        return ans.toString();
    }
}

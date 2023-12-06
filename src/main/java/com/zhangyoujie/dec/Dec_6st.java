package com.zhangyoujie.dec;

/**
 * @author zhangyoujie
 * @date 2023/12/6
 */
public class Dec_6st {

    public static void main(String[] args) {
        System.out.println(beautifulSubstrings("baeyh", 2));
    }
    public static int beautifulSubstrings(String s, int k) {
        int sum = 0;
        char[] charArray = s.toCharArray();
        int length = charArray.length;
        int k1 = 0;
        int k2 = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                if (charArray[j] == 'a' || charArray[j] == 'e' ||
                        charArray[j] == 'i' || charArray[j] == 'o' ||
                        charArray[j] == 'u') {
                    k1++;
                } else {
                    k2++;
                }
                if (k1 == k2 && k1 * k2 % k == 0) {
                    sum++;
                }
            }
            k1 = 0;
            k2 = 0;
        }
        return sum;
    }
}

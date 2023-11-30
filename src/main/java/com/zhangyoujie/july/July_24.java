package com.zhangyoujie.july;

import javax.print.attribute.HashAttributeSet;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author zhangyoujie
 * @date 2023/7/24
 */
public class July_24 {

    public static void main(String[] args) {
        int i = numJewelsInStones("aA", "aAAbbbb");
        System.out.println(i);
    }

    public static int numJewelsInStones(String jewels, String stones) {

        int ans = 0;
        Set<Character> jewelsSet = new HashSet<>();


        char[] charArray = jewels.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            jewelsSet.add(charArray[i]);
        }
        for (int i = 0; i < stones.toCharArray().length; i++) {
            if (jewelsSet.contains(stones.toCharArray()[i])) {
                ans++;
            }
        }


        return ans;
    }
}

package com.zhangyoujie.dec;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangyoujie
 * @date 2023/12/25
 */
public class Dec_25st {

    public static void main(String[] args) {
        System.out.println(numOfBurgers(2385088, 164763));
    }

    public static List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        List<Integer> ans = new ArrayList<>();

        if (tomatoSlices % 2 != 0 || tomatoSlices < 2 * cheeseSlices || tomatoSlices > 4 * cheeseSlices) {
            return ans;
        }
        ans.add(tomatoSlices / 2 - cheeseSlices);
        ans.add(2 * cheeseSlices - tomatoSlices / 2);
        return ans;

    }


}

package com.zhangyoujie.may;

public class May_8st {

    public static void main(String[] args) {
        System.out.println(wateringPlants(new int[]{1, 1, 1, 4, 2, 3}, 4));
    }

    public static int wateringPlants(int[] plants, int capacity) {
        int length = plants.length;

        int ans = length;
        int water = capacity;

        for (int i = 0; i < length; i++) {
            if (water < plants[i]) {
                ans += i * 2;
                water = capacity;
            }
            water -= plants[i];
        }
        return ans;
    }
}

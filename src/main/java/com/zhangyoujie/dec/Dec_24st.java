package com.zhangyoujie.dec;

public class Dec_24st {

    public long minimumPerimeter(long neededApples) {
        // sn = 2n * (n+1) * (2n+1)
        long n = (long) Math.cbrt(neededApples / 4.0);
        if (2 * n * (n + 1) * (2 * n + 1) < neededApples) {
            n++;
        }
        return n * 8;
    }



}

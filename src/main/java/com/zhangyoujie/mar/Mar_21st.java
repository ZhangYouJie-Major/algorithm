package com.zhangyoujie.mar;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangyoujie
 * @date 2024/3/18
 */
public class Mar_21st {


}


class FrequencyTracker {

    int[] fre = new int[10001];
    int[] freCtn = new int[10001];
    public FrequencyTracker() {

    }
    public void add(int number) {
        --freCtn[fre[number]];
        ++fre[number];
        ++freCtn[fre[number]];
    }

    public void deleteOne(int number) {
        if (fre[number] == 0) {
            return;
        }
        --freCtn[fre[number]];
        --fre[number];
        ++freCtn[fre[number]];
    }

    public boolean hasFrequency(int frequency) {
        return freCtn[frequency] > 0;
    }
}

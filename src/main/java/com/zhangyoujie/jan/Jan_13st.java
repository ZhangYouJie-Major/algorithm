package com.zhangyoujie.jan;

import java.io.File;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Jan_13st {

    public static void main(String[] args) throws Exception {
        String path = "E:\\3.txt";
        File file = new File(path);
        Scanner scanner = new Scanner(file);

        String s = new String();
        while (scanner.hasNextLine()) {
            s += scanner.nextLine();
        }
        System.out.println(repeatLimitedString(s, 10000));
    }

    public static String repeatLimitedString(String s, int repeatLimit) {
        int length = s.length();
        char[] charArray = s.toCharArray();
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        int[] ctn = new int[26];
        for (int i = 0; i < length; i++) {
            char ch = charArray[i];
            ctn[ch - 'a']++;
        }
        for (int i = 0; i < ctn.length; i++) {
            if (ctn[i] == 0) continue;
            priorityQueue.add(new int[]{i, ctn[i]});
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!priorityQueue.isEmpty()) {
            int[] poll = priorityQueue.poll();
            char c = (char) (poll[0] + 'a');
            // 说明一次不能处理完
            if (poll[1] > repeatLimit) {
                //减去
                poll[1] -= repeatLimit;
                if (!priorityQueue.isEmpty()) {
                    int[] pollNext = priorityQueue.poll();
                    pollNext[1] -= 1;
                    char nextC = (char) (pollNext[0] + 'a');
                    for (int i = 0; i < repeatLimit; i++) {
                        stringBuilder.append(c);
                    }
                    stringBuilder.append(nextC);
                    priorityQueue.add(poll);
                    if (pollNext[1] > 0) {
                        priorityQueue.add(pollNext);
                    }
                } else {
                    for (int i = 0; i < repeatLimit; i++) {
                        stringBuilder.append(c);
                    }
                    break;
                }

            } else {
                for (int i = 0; i < poll[1]; i++) {
                    stringBuilder.append(c);
                }
            }
        }
        return stringBuilder.toString();
    }


}

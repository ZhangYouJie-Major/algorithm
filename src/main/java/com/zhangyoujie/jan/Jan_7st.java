package com.zhangyoujie.jan;

import java.util.Arrays;

public class Jan_7st {

    public static void main(String[] args) {
        System.out.println(canConstruct("aa", "aab"));
    }

    public static boolean canConstruct(String ransomNote, String magazine) {

        char[] charArray = ransomNote.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (magazine.indexOf(charArray[i]) != -1) {
                magazine = magazine.replaceFirst(String.valueOf(charArray[i]), "1");
            } else {
                return false;
            }
        }

        return true;
    }
}

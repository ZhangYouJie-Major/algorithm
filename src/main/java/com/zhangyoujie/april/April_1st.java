package com.zhangyoujie.april;

public class April_1st {

    public String finalString(String s) {
        char[] charArray = s.toCharArray();
        int length = charArray.length;
        StringBuilder stringBuffer = new StringBuilder();

        for (int i = 0; i < length; i++) {
            if (charArray[i] == 'i') {
                stringBuffer.reverse();
            } else {
                stringBuffer.append(charArray[i]);
            }
        }
        return stringBuffer.toString();
    }

}

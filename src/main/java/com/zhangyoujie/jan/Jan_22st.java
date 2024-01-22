package com.zhangyoujie.jan;

/**
 * @author zhangyoujie
 * @date 2024/1/22
 */
public class Jan_22st {

    public static void main(String[] args) {
        Jan_22st st = new Jan_22st();
        System.out.println(st.maximumSwap(9952767));

    }

    public int maximumSwap(int num) {
        char[] charArray = String.valueOf(num).toCharArray();
        int length = charArray.length;
        int maxIndex = length - 1;
        int p = -1, q = 0;
        // 从右往左遍历 标记最大值的下标
        for (int i = length - 2; i >= 0; i--) {
            if (charArray[maxIndex] < charArray[i]) {
                //更新最大值
                maxIndex = i;
            } else if (charArray[maxIndex] > charArray[i]) {
                p = i;
                q = maxIndex;
            }
        }
        if (p == -1) {
            return num;
        }
        char temp = charArray[q];
        charArray[q] = charArray[p];
        charArray[p] = temp;

        return Integer.parseInt(new String(charArray));

    }
}

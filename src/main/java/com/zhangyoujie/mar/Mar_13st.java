package com.zhangyoujie.mar;

import java.math.BigDecimal;

/**
 * @author zhangyoujie
 * @date 2024/3/13
 */
public class Mar_13st {

    public static void main(String[] args) {
        Mar_13st mar_13st = new Mar_13st();
        System.out.println(mar_13st.multiply("11001","4141325132131241312312312"));
    }

    public String multiply(String num1, String num2) {

        BigDecimal b1 = new BigDecimal(num1);
        BigDecimal b2 = new BigDecimal(num2);
        BigDecimal multiply = b1.multiply(b2);
        return multiply.toString();

    }

    public String maximumOddBinaryNumber(String s) {
        int count = (int) s.chars().filter(item -> item == '1').count();

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < count - 1; i++) {
            ans.append("1");
        }
        for (int i = 0; i < s.length() - count; i++) {
            ans.append("0");
        }
        ans.append("1");
        return ans.toString();

    }
}

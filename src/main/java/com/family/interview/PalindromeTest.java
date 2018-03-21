package com.family.interview;

/**
 * 回文判断
 * Created by Q_先森 on 2018/3/21.
 */
public class PalindromeTest {

    public static void main(String[] args) {
        String str1 = "12331";
        StringBuilder str2 = new StringBuilder(str1);
        str2.reverse();
        int count = 0;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                System.out.println(str1 + "不是回文数");
                break;
            } else {
                count++;
            }
        }
        if (count == str1.length()) {
            System.out.println(str1 + "是回文数");
        }
    }

}

package com.family.Test;


/**
 * Created by Q_先森 on 2017/12/12.
 */
public class IntegerReview {


    public static void main(String[] args) {
        Integer a = 127;
        Integer b = 127;
        Integer c = new Integer(127);
        Integer d = new Integer(127);
        Integer g = Integer.valueOf(127);
        Integer h = Integer.valueOf(127);

        Integer e = 256;
        Integer f = 256;

        System.out.println(a == b); // true
        System.out.println(c == d); // false
        System.out.println(b == c); // false

        System.out.println(e == f); // false
        System.out.println(g == h); // true
        System.out.println(b == g); // true

    }
}

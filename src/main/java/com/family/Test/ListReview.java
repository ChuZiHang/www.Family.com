package com.family.Test;

import java.util.*;

/**
 * Created by Q_先森 on 2017/12/6.
 */
public class ListReview {

    public static void main(String[] args) {
        test();
    }

    /**
     * 特有方法(相对于Collection)
     */
    private static void test() {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
        list.add("F");

        list.forEach(System.out::println);
        System.out.println("--------割-----------");

        list.add(2, "X"); // 在列表的指定位置插入指定元素（可选操作）。
        list.forEach(str -> {
            System.out.println(str);
        });
        System.out.println("--------割-----------");

        List<String> list1 = new ArrayList<>();
        list1.add("Y");
        list1.add("Z");
        list.addAll(3, list1); // 将指定 collection 中的所有元素都插入到列表中的指定位置（可选操作）。
        list.forEach(System.out::println);
        System.out.println("--------割-----------");

        System.out.println(list.get(1)); // 返回列表中指定位置的元素。
        System.out.println("--------割-----------");

        list.add("B");
        System.out.println(list.indexOf("B")); // 返回此列表中第一次出现的指定元素的索引；如果此列表不包含该元素，则返回 -1。
        System.out.println("--------割-----------");

        System.out.println(list.lastIndexOf("B")); // 返回此列表中最后出现的指定元素的索引；如果列表不包含此元素，则返回 -1。
        System.out.println("--------割-----------");

        ListIterator<String> iterator = list.listIterator(); // 返回此列表元素的列表迭代器（按适当顺序）。
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("--------割-----------");

        // 返回列表中元素的列表迭代器（按适当顺序），从列表的指定位置开始。
        for (ListIterator<String> stringListIterator = list.listIterator(5); stringListIterator.hasNext(); ) {
            System.out.println(stringListIterator.next());
        }
        System.out.println("--------割-----------");

        list.remove(9); //  移除列表中指定位置的元素（可选操作）。
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println("--------割-----------");

        list.set(0, "H"); // 用指定元素替换列表中指定位置的元素（可选操作）。
        for (String str : list) {
            System.out.println(str);
        }
        System.out.println("--------割-----------");

        List<String> subList = list.subList(2, 5); //  返回列表中指定的 fromIndex（包括 ）和 toIndex（不包括）之间的部分视图。
        subList.forEach(System.out::println);
        System.out.println("--------割-----------");

        list.sort(Comparator.comparing(String::hashCode).reversed()); // 按照hash值对list进行排序
        list.forEach(System.out::println);
        System.out.println("--------割-----------");
    }

}

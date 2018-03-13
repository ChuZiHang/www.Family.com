package com.family.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * Created by Q_先森 on 2017/12/12.
 */
public class ArrayListReview {


    public static void main(String[] args) {
        test();
    }
    private static void test() {
        // ArrayList<String> list = new ArrayList<>();// 构造一个初始容量为 10 的空列表（每次递增容量的一半）
        ArrayList<String> list = new ArrayList<>(4);// 构造一个具有指定初始容量的空列表
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");

        ListIterator<String> listIterator = list.listIterator();
        while (listIterator.hasNext()){
            System.out.println(listIterator.next());
        }

        while (listIterator.hasPrevious()){
            String previous = listIterator.previous();
            System.out.println(previous);
        }

        removeRange(list,1,3);

        list.forEach(str ->{
            System.out.println(str);
        });

        // 通过数组来转化成一个List，虽然可以把数组转成集合，但是集合的长度不能改变。
        String[] a=new String[]{"hello","world","just","do","it"};
        List<String> asList = Arrays.asList(a);
//        asList.add("gogogo");  //不可修改asList，会抛出UnsupportedOperationException

    }

    public static<E> void removeRange(ArrayList<E> list,int fromIndex,int toIndex){

        try {
            // 拿到ArrayList的Class对象
            Class<?> clazz = Class.forName("java.util.ArrayList");
            // 通过clazz对象拿到removeRange方法，参数为（int,int）
            Method declaredMethod = clazz.getDeclaredMethod("removeRange", int.class,int.class);
            // 将方法的访问权限设置为可访问
            declaredMethod.setAccessible(true);
            //  调用removeRange方法
            declaredMethod.invoke(list,fromIndex,toIndex);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}

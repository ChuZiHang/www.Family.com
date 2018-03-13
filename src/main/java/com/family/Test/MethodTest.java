package com.family.Test;

import java.lang.reflect.Method;

/**
 * Created by Q_先森 on 2017/12/12.
 */
public class MethodTest {


    static void staticMethod() {
        System.out.println("执行staticMethod()方法");
    }

    public int publicMethod(int i) {
        System.out.println("执行publicMethod()方法");
        return i * 20;
    }

    protected int protectedMethod(String s, int i) throws NumberFormatException {
        System.out.println("执行protectedMethod()方法");
        return Integer.valueOf(s) + i;
    }

    private String privateMethod(String... strings) {
        System.out.println("执行privateMethod()方法");
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < strings.length; i++) {
            stringBuffer.append(strings[i]);
        }
        return stringBuffer.toString();
    }

    public static void main(String[] args) {
        //实例化一个对象：
        MethodTest methodTest = new MethodTest();
        //获得所有的方法
        Method[] declaredMethods = MethodTest.class.getDeclaredMethods();
        for (int i = 0; i < declaredMethods.length; i++) {
            Method method = declaredMethods[i];
            System.out.println("名称：" + method.getName());   //方法名称
            System.out.println("是否允许带有可变参数变量:" + method.isVarArgs());
            System.out.println("入口参数类型依次为：");
            //获得方法所有的参数类型
            Class[] parameterTypes = method.getParameterTypes();
            for (int j = 0; j < parameterTypes.length; j++) {
                System.out.println("parameterTypes[" + j + "]" + parameterTypes[j]);
            }

            System.out.println("返回值类型：" + method.getReturnType()); //获得方法返回值类型
            System.out.println("可能抛出异常类型有：");
            Class[] exceptionTypes = method.getExceptionTypes();  //获得可能抛出的所有异常类型
            for (int j = 0; j < exceptionTypes.length; j++) {
                System.out.println("exceptionTypes[" + j + "]" + exceptionTypes[j]);
            }

            boolean isTurn = true;
            while (isTurn) {
                try {
                    isTurn = false;
                    if (i == 1) {// 这里i=0 是main方法
                        method.invoke(methodTest);
                    } else if (i == 2) {
                        System.out.println("返回值：" + method.invoke(methodTest, 5));
                    } else if (i == 3) {
                        System.out.println("返回值：" + method.invoke(methodTest, "7", 5));
                    } else if (i == 4) {
                        Object[] parameters = new Object[]{new String[]{"M", "W", "Q"}};
                        System.out.println("返回值：" + method.invoke(methodTest, parameters));
                    }
                } catch (Exception e) {
                    System.out.println("在执行方法时抛出异常,执行setAccessible()方法");
                    method.setAccessible(true);
                    isTurn = true;
                }
            }
            System.out.println("============================割============================");
        }
    }
}

package com.wbs.smalldemo;

/**
 * 演示Java里的基本类型值传递
 */
public class Example1 {
    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 20;
        swap(num1, num2);
        System.out.println("num1 = " + num1);
        System.out.println("num2 = " + num2);
    }

    public static void swap(int a, int b) {
        int t = a;
        a = b;
        b = t;
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }
}

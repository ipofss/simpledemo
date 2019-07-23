package com.wbs.simpledemo.prove;

/**
 * 类加载中的方法加载顺序
 */
public class Test {
    public static void main(String[] args) {
        B b = new B();
        b.method();
    }
}

class A {
    public A() {
        System.out.println("1");
    }

    static {
        System.out.println("2");
    }

    public void method() {
        System.out.println("3");
    }
}

class B extends A {
    public B() {
        System.out.println("4");
    }

    static {
        System.out.println("5");
    }

    @Override
    public void method() {
        System.out.println("6");
    }
}

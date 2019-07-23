package com.wbs.simpledemo.smalldemo;

/**
 * 演示Java里的参数为对象的引用传递
 */
public class Example2 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(arr[0]);
        change(arr);
        System.out.println(arr[0]);
    }

    /**
     * 方法得到的是一个对象的引用的拷贝，所以会指向同一个内存地址，修改了内容，会反应到原来的对象上
     * @param array
     */
    public static void change(int[] array) {
        array[0] = 0;
    }
}

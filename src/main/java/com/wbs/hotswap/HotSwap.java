package com.wbs.hotswap;

import java.io.File;
import java.lang.reflect.Method;

/**
 * TODO
 *
 * @author: wangbingshuai
 * @create: 2020-02-25 15:13
 **/
public class HotSwap {
    public static void main(String[] args) throws Exception {
        loadHelloWorld();
        // 回收资源,释放HelloWorld.class文件，使之可以被替换
        System.gc();
        // 等待资源被回收
        Thread.sleep(1000);
        File fileV2 = new File("HelloWorld.class");
        File fileV1 = new File("com/wbs/hotswap/HelloWorld.class");
        // 删除V1版本
        fileV1.delete();
        // 更新V2版本
        fileV2.renameTo(fileV1);
        System.out.println("Update success!");
        loadHelloWorld();
    }

    public static void loadHelloWorld() throws Exception {
        // 自定义类加载器
        MyClassLoader myLoader = new MyClassLoader();
        // 类实例
        Class<?> class1 = myLoader.findClass("com.wbs.hotswap.HelloWorld");
        // 生成新的对象
        Object obj1 = class1.newInstance();
        Method method = class1.getMethod("say");
        // 执行方法say
        method.invoke(obj1);
        // 对象
        System.out.println(obj1.getClass());
        // 对象的类加载器
        System.out.println(obj1.getClass().getClassLoader());
    }
}

package person.zh.mutilthread;

import person.zh.mutilthread.MyThread;

/**
 * @author: joe
 * @dateTime: 2023/2/16 19:33
 * @description: 继承Thread类实现多线程
 * @version: 1.0
 */
public class Demo1 {
    public static void main(String[] args) {
        MyThread t1 = new MyThread("线程1");
        MyThread t2 = new MyThread("线程2");
        MyThread t3 = new MyThread("线程3");
        t1.start();
        t2.start();
        t3.start();
    }

}


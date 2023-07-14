package person.zh.mutilthread;

import person.zh.mutilthread.MyRunnable;

/**
 * @author: joe
 * @dateTime: 2023/2/16 19:41
 * @description: 实现Runnable接口实现多线程
*                 1. 创建类MyRunnable，实现Runnable接口，并实现run方法
 *                2. 创建MyRunnable对象，作为参数备用
 *                3. 创建Thread对象
 * @version: 1.0
 */
public class Demo2 {
    public static void main(String[] args) {
        Runnable mt1 = new MyRunnable();
        Runnable mt2 = new MyRunnable();
        Runnable mt3 = new MyRunnable();
        Thread t1 = new Thread(mt1, "线程1");
        Thread t2 = new Thread(mt2, "线程2");
        Thread t3 = new Thread(mt3, "线程3");
        t1.start();
        t2.start();
        t3.start();
    }

}


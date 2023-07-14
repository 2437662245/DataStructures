package person.zh.mutilthread;

import person.zh.mutilthread.MyCallable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author: joe
 * @dateTime: 2023/2/16 19:48
 * @description: 通过callable实现多线程
 *                  1. 自定义类MyCallable实现Callable接口
 *                  2. 实例化MyCallable，对象ca1
 *                  3. 创建FutureTask对象ft1
 *                  4. 将ft1作为参数创建线程对象
 *                  5. 调用线程start()方法
 * @version: 1.0
 */
public class Demo3 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<Integer> ca1 = new MyCallable();
        FutureTask<Integer> ft1 = new FutureTask<>(ca1);
        new Thread(ft1, "线程1").start();
        System.out.println(Thread.currentThread().getName()+" OK");
        Integer result = (Integer) ft1.get(); // 获取返回值
        System.out.println(result);
    }
}


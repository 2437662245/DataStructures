package person.zh.queue;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author: joe
 * @dateTime: 2023/2/16 20:33
 * @description: TODO
 * @version: 1.0
 */
public class BlockingDequeDemo {
    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(4);
        queue.put(1);
        queue.put(2);
        queue.put(3);
        queue.put(4);
        System.out.println("已满但还插入");
        queue.put(5);
    }
}

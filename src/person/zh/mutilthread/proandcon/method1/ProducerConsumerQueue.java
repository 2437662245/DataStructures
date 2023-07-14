package person.zh.mutilthread.proandcon.method1;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: joe
 * @dateTime: 2023/4/2 19:42
 * @description: 生产者消费者的元素队列 或者说 任务缓冲队列
 * @version: 1.0
 */
public class ProducerConsumerQueue <E>{
    // 队列最大容量
    private static final int QUEUE_MAX_SIZE = 10;

    // 存放元素的队列
    private Queue<E> queue;

    ProducerConsumerQueue() {
        queue = new LinkedList<>();
    }

    /**
     * 往队列添加元素
     * @param e
     * @return
     */
    public synchronized boolean put(E e) {
        // 如果队列已满了，阻塞当前线程
        if (queue.size() >= QUEUE_MAX_SIZE) {
            try {
                wait();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        // 如果队列未满，往队列添加元素
        queue.offer(e);
        System.out.println(Thread.currentThread().getName() + " -> 生产元素，当前元素个数为：" + queue.size());
        // 唤醒其它线程
        notify();
        return true;
    }

    /**
     * 从队列中取元素
     * @return
     */
    public synchronized E get() {
        // 如果队列为空 阻塞当前线程
        if (queue.size() == 0) {
            try {
                wait();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        E e = queue.poll();
        System.out.println(Thread.currentThread().getName() + " -> 消费元素，当前元素个数为：" + queue.size());
        notify();
        return e;
    }

}

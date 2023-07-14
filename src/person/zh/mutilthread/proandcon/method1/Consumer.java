package person.zh.mutilthread.proandcon.method1;

/**
 * @author: joe
 * @dateTime: 2023/4/2 20:01
 * @description: 消费者线程
 * @version: 1.0
 */
public class Consumer implements Runnable{

    private ProducerConsumerQueue<Integer> queue;

    public Consumer(ProducerConsumerQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            queue.get();
        }
    }
}

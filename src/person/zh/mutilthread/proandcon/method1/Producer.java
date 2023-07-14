package person.zh.mutilthread.proandcon.method1;

/**
 * @author: joe
 * @dateTime: 2023/4/2 20:01
 * @description: 生产者
 * @version: 1.0
 */
public class Producer implements Runnable{

    private ProducerConsumerQueue<Integer> queue;

    public Producer(ProducerConsumerQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            queue.put(i);
        }
    }
}

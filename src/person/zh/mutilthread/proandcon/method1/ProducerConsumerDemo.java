package person.zh.mutilthread.proandcon.method1;

/**
 * @author: joe
 * @dateTime: 2023/4/2 20:11
 * @description: TODO
 * @version: 1.0
 */
public class ProducerConsumerDemo {
    public static void main(String[] args) throws InterruptedException {

        // 生产者-消费者模型缓冲区
        ProducerConsumerQueue<Integer> queue = new ProducerConsumerQueue<>();

        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);

        new Thread(producer).start();
        new Thread(consumer).start();
    }
}

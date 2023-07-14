package person.zh.mutilthread.exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: joe
 * @dateTime: 2023/3/11 18:45
 * @description: 生产者消费者模型
 * @version: 1.0
 */
public class ProducerAndConsumer {

    public static void main(String[] args) {

        //让生产者、消费者共享同一个商品工厂
        GoodsFactory goodsFactory = new GoodsFactory();

        Producer producer = new Producer(goodsFactory);
        producer.start();

        Consumer consumer = new Consumer(goodsFactory);
        consumer.start();
    }
}

/**
 * 商品工厂，负责生产和消费商品
 */
class GoodsFactory {
    AtomicInteger atomicInteger = new AtomicInteger();
    List<Goods> goodsList = new ArrayList<>();

    public synchronized void consumerGoods() throws InterruptedException {
        if (goodsList.size() <= 0) {
            System.out.println("商品消费完了，等待生产！");
            //商品消费完了以后，释放锁并阻塞自己，等待唤醒的通知。
            this.wait();
        } else {
            Goods goods = goodsList.remove(0);
            System.out.println("消费了一个商品：" + goods);
            //消费了一个商品后，唤醒生产者
            this.notifyAll();
        }
    }

    public synchronized void producerGoods() throws InterruptedException {
        if (goodsList.size() >= 5) {
            System.out.println("商品太多了，停止生产，等待被消费！");
            //商品满了以后，释放锁并阻塞自己，等待唤醒的通知。
            this.wait();
        } else {
            Goods goods = new Goods(atomicInteger.getAndIncrement(), "xxoo");
            goodsList.add(goods);
            System.out.println("生产了一个商品：" + goods);
            //生产了一个商品后，唤醒消费者
            this.notifyAll();
        }
    }
}

/**
 * 消费者线程，调用商品工厂消费商品
 */
class Consumer extends Thread {

    GoodsFactory goodsFactory;

    public Consumer(GoodsFactory goodsFactory) {
        this.goodsFactory = goodsFactory;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(new Random().nextInt(10) * 100);
                goodsFactory.consumerGoods();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

/**
 * 生产者线程，调用商品工厂生产商品
 */
class Producer extends Thread {

    GoodsFactory goodsFactory;

    public Producer(GoodsFactory goodsFactory) {
        this.goodsFactory = goodsFactory;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(new Random().nextInt(10) * 100);
                goodsFactory.producerGoods();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}


class Goods {

    private int goodId;

    private String goodName;

    public Goods(int goodId, String goodName) {
        this.goodId = goodId;
        this.goodName = goodName;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "goodId=" + goodId +
                ", goodName='" + goodName + '\'' +
                '}';
    }
}

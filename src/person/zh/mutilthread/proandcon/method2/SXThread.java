package person.zh.mutilthread.proandcon.method2;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author: joe
 * @dateTime: 2023/4/2 20:32
 * @description: TODO
 * @version: 1.0
 */
public class SXThread {
    public static void main(String[] args) {
        SXThread sx = new SXThread();
        //仓库类
        Storage s = sx.new Storage();
        //生产者
        Producer p1 = sx.new Producer("生产者一", s);
        Producer p2 = sx.new Producer("生产者二", s);
        //消费者
        Customer c1 = sx.new Customer("消费者一", s);
        Customer c2 = sx.new Customer("消费者二", s);
        Customer c3 = sx.new Customer("消费者三", s);
        //线程池
        ExecutorService service = Executors.newCachedThreadPool();
        //线程启动
        service.submit(p1);
        service.submit(p2);
        service.submit(c1);
        service.submit(c2);
        service.submit(c3);
    }

    //仓库类，存储生产者生产的和消费者消费的产品提供存取两个方法
    class Storage {
        BlockingQueue queue = new LinkedBlockingQueue();

        public void push(Product p) throws InterruptedException {
            queue.put(p);
        }

        public Product pop() throws InterruptedException {
            return (Product) queue.take();
        }
    }

    //产品类只提供产品id，重写了toString()方法
    class Product {
        private int id;

        public Product(int id) {
            this.id = id;
        }

        public String toString() {
            return "产品" + this.id + "号";
        }
    }

    //生产者实现多线程
    class Producer implements Runnable {
        private String name;
        private Storage s;

        public Producer(String name, Storage s) {
            this.name = name;
            this.s = s;
        }

        //先生产出产品再入库
        public void run() {
            try {
                while (true) {
                    Product p = new Product((int) (Math.random() * 1000));
                    s.push(p);
                    System.out.println(name + "生产了" + p.toString());
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //消费者实现多线程
    class Customer implements Runnable {
        private String name;
        private Storage s;

        public Customer(String name, Storage s) {
            this.name = name;
            this.s = s;
        }

        //出库消费
        public void run() {

            try {
                while (true) {
                    Product p = s.pop();
                    System.out.println(name + "消费了" + p.toString());
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

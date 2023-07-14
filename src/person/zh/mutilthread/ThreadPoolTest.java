package person.zh.mutilthread;


import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName: ThreadPoolTest
 * @Description:
 * @Author: zh
 * @DateTime: 2022/10/29 9:30
 * @Version: 1.0
 */
public class ThreadPoolTest {

    volatile static AtomicInteger num = new AtomicInteger();

    public static void add() {
        num.getAndIncrement();
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService threadPool = Executors.newCachedThreadPool();
        try {
            // 模拟有10个顾客过来银行办理业务，池子中只有5个工作人员受理业务
            for (int i = 1; i <= 10; i++) {
                threadPool.execute(()->{
                    System.out.println(Thread.currentThread().getName()+" 办理业务");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown(); // 用完记得关闭
        }

        CompletableFuture future = new CompletableFuture();
    }
}

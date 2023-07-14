package person.zh.mutilthread.exam;

/**
 * @author: joe
 * @dateTime: 2023/3/11 17:56
 * @description: 这种方式只能保证顺序执行，并不能保证三个线程同时启动
 * @version: 1.0
 */
public class OrderPrint1 {
    public static void main(String[] args) throws InterruptedException {
        // 同时启动三个线程，分别为A、B、C，其中A线程打印“a”，B线程打印“b”，C线程打印“c”，要求按照abc顺序打印输出。
        Thread threadA = new Thread(() -> {
            System.out.println("a");
        }, "A");

        Thread threadB = new Thread(() -> {
            System.out.println("b");
        }, "B");
        Thread threadC = new Thread(() -> {
            System.out.println("c");
        }, "C");

        threadA.start();
        threadA.join();

        threadB.start();
        threadB.join();

        threadC.start();
        threadC.join();
    }
}

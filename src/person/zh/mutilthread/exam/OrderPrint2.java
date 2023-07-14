package person.zh.mutilthread.exam;

/**
 * @author: joe
 * @dateTime: 2023/3/11 18:03
 * @description: 使用同步的方式，通过notifyAll和wait方法实现线程间的通信。使用一个标志位，限制被唤醒的线程，只让下一个线程进行打印，保证顺序性
 * @version: 1.0
 */
public class OrderPrint2 {

    static String flag = "A";

    public static void main(String[] args) {
        OrderPrint2 sortPrint_v2 = new OrderPrint2();
        Thread ta = new Thread(() -> sortPrint_v2.A());
        Thread tb = new Thread(() -> sortPrint_v2.B());
        Thread tc = new Thread(() -> sortPrint_v2.C());

        ta.start();

        tb.start();

        tc.start();
    }

    public synchronized void A() {
        try {
            while (true) {
                if (flag.equals("A")) {
                    System.out.println("a");
                    flag = "B";
                    this.notifyAll();
                } else {
                    this.wait();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void B() {
        try {
            while (true) {
                if (flag.equals("B")) {
                    System.out.println("b");
                    flag = "C";
                    this.notifyAll();
                } else {
                    this.wait();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void C() {
        try {
            while (true) {
                if (flag.equals("C")) {
                    System.out.println("c");
                    flag = "A";
                    this.notifyAll();
                } else {
                    this.wait();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

package person.zh.mutilthread.exam;

import java.util.concurrent.Semaphore;

/**
 * @author: joe
 * @dateTime: 2023/3/11 18:11
 * @description: 使用Semaphore实现ab交替打印。abababab......
 * @version: 1.0
 */
public class AlternatePrint2 {

    static String flag = "A";

    public static void main(String[] args) {
        AlternatePrint2 turnPrint = new AlternatePrint2();

        Thread ta = new Thread(() -> turnPrint.A());
        Thread tb = new Thread(() -> turnPrint.B());

        ta.start();
        tb.start();

    }

    public synchronized void A() {
        try {
            while (true) {
                if (flag.equals("A")) {
                    System.out.println("a");
                    flag = "B";
                    this.notify();
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
                    flag = "A";
                    this.notify();
                } else {
                    this.wait();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

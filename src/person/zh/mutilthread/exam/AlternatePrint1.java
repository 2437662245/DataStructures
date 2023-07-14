package person.zh.mutilthread.exam;

import java.util.concurrent.Semaphore;

/**
 * @author: joe
 * @dateTime: 2023/3/11 18:11
 * @description: 使用Semaphore实现ab交替打印。abababab......
 * @version: 1.0
 */
public class AlternatePrint1 {

    Semaphore semaphore1 = new Semaphore(1);
    Semaphore semaphore2 = new Semaphore(0);

    public static void main(String[] args) {
        AlternatePrint1 turnPrint = new AlternatePrint1();

        Thread ta = new Thread(() -> turnPrint.A());
        Thread tb = new Thread(() -> turnPrint.B());

        ta.start();
        tb.start();

    }

    public void A() {
        try {
            while (true) {
                semaphore1.acquire();
                System.out.println("a");
                semaphore2.release();

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void B() {
        try {
            while (true) {
                semaphore2.acquire();
                System.out.println("b");
                semaphore1.release();

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

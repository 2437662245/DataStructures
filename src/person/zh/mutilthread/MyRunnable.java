package person.zh.mutilthread;

/**
 * @author: joe
 * @dateTime: 2023/2/16 20:50
 * @description: TODO
 * @version: 1.0
 */
public class MyRunnable implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
        }
    }
}

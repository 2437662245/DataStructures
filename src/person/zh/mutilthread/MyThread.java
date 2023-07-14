package person.zh.mutilthread;

/**
 * @author: joe
 * @dateTime: 2023/2/16 20:49
 * @description: TODO
 * @version: 1.0
 */
public class MyThread extends Thread {

    private String name;

    public MyThread() {
    }

    public MyThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println(currentThread().getName() + ": " + i);
        }
    }
}

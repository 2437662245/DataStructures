package person.zh.mutilthread;

import java.util.concurrent.Callable;

/**
 * @author: joe
 * @dateTime: 2023/2/16 20:50
 * @description: TODO
 * @version: 1.0
 */
public class MyCallable implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        return 1024;
    }
}

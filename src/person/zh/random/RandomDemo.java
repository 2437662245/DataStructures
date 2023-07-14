package person.zh.random;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @ClassName: RandomDemo
 * @Description:
 * @Author: zh
 * @DateTime: 2022/11/17 20:12
 * @Version: 1.0
 */
public class RandomDemo {

    @Test
    public void testRandom() {
        Random random = new Random();
        // 生成[0,10)随机数
        int nextInt = random.nextInt(10);
    }

    @Test
    public void testLsit() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.remove(Integer.valueOf(1));
        System.out.println(list.get(0));

        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 2);
        map.put(0, 1);
    }
}

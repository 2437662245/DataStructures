package person.zh.map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName: HashMapTest
 * @Description:
 * @Author: zh
 * @DateTime: 2022/10/20 14:11
 * @Version: 1.0
 */
public class HashMapTest {
    public static void main(String[] args) {

        ConcurrentHashMap<Object, Object> hashMap = new ConcurrentHashMap<>();


        Map<Integer, Integer> map = new HashMap<>();

        // 1. 添加put()
        map.put(1, 100);
        map.put(2, 200);
        map.put(3, 300);
        map.put(4, 400);
        map.put(5, 500);
        map.put(6, 600);
        map.put(7, 700);

        // 2. 删除 传入一个参数则根据key删除，传入两个参数根据k、v删除
        map.remove(7);
        map.remove(6);
        map.remove(500);
        map.remove(5, 400);
        map.remove(5, 500);
        map.remove(4, 400);

        // 3. 获取map中元素
        Set<Integer> keys = map.keySet();
        Collection<Integer> values = map.values();
        for (Map.Entry<Integer, Integer> entrys : map.entrySet()) {
            System.out.println("key :" + entrys.getKey() + ", value: " + entrys.getValue());
        }

        System.out.println("map.getOrDefault(1, 1000) = " + map.getOrDefault(1, 1000));
        System.out.println("map.getOrDefault(10, 1010) = " + map.getOrDefault(10, 1010));

        // 4. 是否包含某key或value
        map.containsKey(3);
        map.containsKey(5);
        map.containsValue(800);
        map.containsValue(1000);

    }
}

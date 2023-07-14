package person.zh.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * Auther: zh
 * DateTime: 2022/9/29 19:19
 */
public class TailRecur {

    public static void main(String[] args) {

        String s = "";
        s.charAt(0);
        List<Integer> list = new ArrayList();
        int n = 50;
        long begin1 = System.currentTimeMillis();
        System.out.printf("%d\n", fibonacci(n));
        long end1 = System.currentTimeMillis();
        System.err.println("花费时间：" + (end1 - begin1) + "毫秒");

        long begin2 = System.currentTimeMillis();
        System.out.printf("%d\n", advanced(n, 0L, 1L));
        long end2 = System.currentTimeMillis();
        System.err.println("花费时间：" + (end2 - begin2) + "毫秒");
    }

    static long fibonacci(int n) {
        if (n < 0)
            return -1;
        if (n <= 1)
            return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    static long advanced(int n, long ret1, long ret2) {
        if (n < 0)
            return -1;
        if (n == 0)
            return ret1;
        if (n == 1)
            return ret2;
        return advanced(n - 1, ret2, ret1 + ret2);
    }

}

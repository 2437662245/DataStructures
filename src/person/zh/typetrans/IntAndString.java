package person.zh.typetrans;

import org.junit.Test;

/**
 * @ClassName: Int2String
 * @Description:
 * @Author: zh
 * @DateTime: 2022/10/17 15:34
 * @Version: 1.0
 */
public class IntAndString {

    @Test
    public void int2String() {
        // String.valueOf()
        String s1 = String.valueOf(11111);
        System.out.println(s1);
    }

    @Test
    public void string2Int() {
        String str = "99";
        int i = Integer.valueOf(str);
        System.out.println("i = " + i);
    }
}

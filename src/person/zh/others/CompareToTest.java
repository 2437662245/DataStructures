package person.zh.others;

import org.junit.Test;

/**
 * @ClassName: CompareToTest
 * @Description:
 * @Author: zh
 * @DateTime: 2022/11/24 19:32
 * @Version: 1.0
 */
public class CompareToTest {

    @Test
    public void test() {
        String str1 = "abc";
        String str2 = "bac";
        System.out.println("str1.compareTo(str2) = " + str1.compareTo(str2));
    }
}

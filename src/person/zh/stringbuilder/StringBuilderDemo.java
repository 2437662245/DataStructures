package person.zh.stringbuilder;

import org.junit.Test;

import java.util.stream.IntStream;
/**
 * @ClassName: StringBuilderDemo
 * @Description:
 * @Author: zh
 * @DateTime: 2022/10/26 12:11
 * @Version: 1.0
 */
public class StringBuilderDemo {

    @Test
    public void test() {
        StringBuilder builder = new StringBuilder();

        // 1.增 append在末尾增 insert在任意位置插入
        builder.append(1);
        builder.append(2);
        builder.append(3);
        System.out.println(builder.toString()); // 123
        builder.insert(0, 0);
        System.out.println(builder.toString()); // 0123
        // 2.删除
        builder.delete(1, 2);              // 删除[1, 2)
        System.out.println(builder.toString()); // 23
        builder.deleteCharAt(0);                // 删除index处的字符
        System.out.println(builder.toString()); // 3
        builder.append(1);
        builder.append(2);
        builder.append(3);
        // 3.查询
        String substring = builder.substring(1, 4); // 取[1, 4)返回String
        System.out.println(substring);
        System.out.println("builder.toString() = " + builder.toString());
        System.out.println("builder.charAt(0) = " + builder.charAt(0));

        // 4.修改
        System.out.print(builder + ":");
        builder.setCharAt(0, '8');
        System.out.println("builder.setCharAt(0, '8') -> " + builder);
        // 5.其它
        System.out.print(builder + ":");
        builder.reverse(); // 翻转
        System.out.println("builder.reverse() -> " + builder);


        System.out.println("builder.toString() = " + builder.toString());
        builder.setLength(builder.length() - 1);
        System.out.println("builder.toString() = " + builder.toString());
    }
}

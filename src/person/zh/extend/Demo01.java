package person.zh.extend;

/**
 * @author: joe
 * @dateTime: 2023/2/22 19:05
 * @description: TODO
 * @version: 1.0
 */
public class Demo01 {
    public static void main(String[] args) {
        /*Stu1 stu1 = new Stu1("小王", 18);
        System.out.println(stu1.hashCode());
        Class<? extends Stu1> aClass = stu1.getClass();*/

        // 在堆中创建一个字符串对象，不在串池中
        String str1 = new String("abc");
        System.out.println(str1);

        // 将str1入池
        String str2 = str1.intern();
        System.out.println(str2 == str1);

        String str3 = "abc";
        System.out.println(str1 == str3);
        System.out.println(str2 == str3);

    }
}

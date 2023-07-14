package person.zh.others;

/**
 * @author: joe
 * @dateTime: 2023/4/2 20:38
 * @description: 线程安全的单例模式
 * @version: 1.0
 */

public final class SafeSingleton {

    //持有类的唯一实例
    private static volatile SafeSingleton instance = null;

    /**
     * 私有构造函数
     */
    private SafeSingleton() {
    }

    /**
     * 提供外部获取实例的方法
     * 线程安全：DCL实现
     * synchronized保障了原子性、可见性和有序性
     * volatile保证校验时(null == instance) instance对各个线程是可见的，同时禁止JIT和处理器重排序
     * @return
     */
    public static SafeSingleton getInstance(){
        if (instance == null) {
            synchronized (SafeSingleton.class) {
                if (null == instance) {
                    // new关键字对应三条指令：1.分配对象所需的存储空间  2.实例化对象  3.将对象引用赋值给变量
                    // 这三条指令正常执行顺序是1->2->3，但是JIT编译器或处理器在执行时可能会将其优化为1->3->2
                    // 所以，为了保证instance的可见性以及禁止重排序，所以instance变量必须要用volatile修饰
                    // 否则，极端情况下，一个线程在判断if (null == instance)时，instance不为空直接返回，但此时
                    // instance可能是个半对象(对象并没有经过构造方法初始化)，这将会造成代码错误
                    instance = new SafeSingleton();
                }
            }
        }

        return instance;
    }

}

package person.zh.others;

/**
 * @author: joe
 * @dateTime: 2023/4/2 20:45
 * @description: 非线程安全的单例模式
 * @version: 1.0
 */
public class UnSafeSingleton {
    // 声明私有对象
    private static UnSafeSingleton instance = null;
    // 构造方法私有化
    private UnSafeSingleton(){};
    // 提供获取实例的方法

    public UnSafeSingleton getInstance() {
        if (instance != null) {
            instance = new UnSafeSingleton();
        }
        return instance;
    }
}

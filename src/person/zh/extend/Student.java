package person.zh.extend;

/**
 * @author: joe
 * @dateTime: 2023/2/22 19:06
 * @description: TODO
 * @version: 1.0
 */
public class Student {
    private String name;
    public int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

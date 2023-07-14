package person.zh.hashtable;

import sun.security.util.Length;

public class HashTabDemo {
    public static void main(String[] args) {
        HashTable hashTable = new HashTable(5);
        Emp emp1 = new Emp(1, "Tom");
        hashTable.add(emp1);
        hashTable.print();
    }
}

// 构建hashtable
class HashTable {
    private EmpLinkedList[] empLinkedLists;
    private int size;

    public HashTable(int size) {
        this.size = size;
        empLinkedLists = new EmpLinkedList[size];
        for (int i = 0; i < size; i++) {
            empLinkedLists[i] = new EmpLinkedList();
        }
    }

    // 增加员工信息
    public void add(Emp emp) {
        int listIndex = hashFun(emp.id);
        empLinkedLists[listIndex].addEmp(emp);
    }
    // 删除


    // 查找

    // 遍历散列表 打印
    public void print() {
        for (int i = 0; i < empLinkedLists.length; i++) {
            empLinkedLists[i].print();
        }
    }

    // 散列函数 根据员工id添加到对应的链表中
    public int hashFun(int id) {
        return id % size;
    }

}


// 构建链表
class EmpLinkedList {
    private Emp head; // 头指针

    // 向链表中添加数据
    public void addEmp(Emp emp) {
        // 如果链表为空
        if (head == null) {
            head = emp;
            return;
        } else {
            Emp temp = head;    // 指针寻找最后一个节点 找到后插入
            while(temp.next != null) {
                temp = temp.next;
            }
            temp.next = emp;
        }
    }

    // 遍历链表
    public void print() {
        // 如果链表为空
        if (head == null) {
            System.out.println("链表为空");
            return;
        }
        Emp temp = head;    // 指针向后遍历
        while(temp != null) {
            System.out.printf("id:%d, name:%s \n", temp.id, temp.name);
            temp = temp.next;
        }
    }
}

// 首先构建员工类
class Emp {
    public int id;
    public String name;
    public Emp next;

    public Emp(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }
}
package person.zh.linkedlist;

public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedNode l1 = new LinkedNode(1);
        l1.next = new LinkedNode(8);
        l1.next.next = new LinkedNode(3);
        LinkedNode l2 = new LinkedNode(7);
        l2.next = new LinkedNode(1);
        LinkedNode l3 = addTwoNumbers(l1, l2);
        LinkedNode temp = l3;
        while (temp != null) {
            System.out.println(l3.val);
            temp = temp.next;
        }

        // 递归反转链表
        LinkedNode head = new LinkedNode(0);
        LinkedNode node1 = new LinkedNode(1);
        LinkedNode node2 = new LinkedNode(2);
        LinkedNode node3 = new LinkedNode(3);
        LinkedNode node4 = new LinkedNode(4);
        LinkedNode node5 = new LinkedNode(5);
        LinkedNode node6 = new LinkedNode(6);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        LinkedNode reverseList = reverseList(head);
        System.out.println("reverseList = " + reverseList);
    }

    /**
     * 递归反转链表
     * @param head
     * @return
     */
    public static LinkedNode reverseList(LinkedNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        LinkedNode res = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return res;
    }

    public static LinkedNode addTwoNumbers(LinkedNode l1, LinkedNode l2) {
        // 1. 当两链表都不为空时，一起向后遍历，如果和大于10，用flag标识下次加的时候另外+1
        // 2. 当有一个链表遍历完了，flag判断是否还需要进一，不需要的话直接全部给新链表，需要的话再遍历后边的
        // 特例：当有一个链表为空时，返回另一个
        if (l1.val == 0) {
            return l2;
        }
        if (l2.val == 0) {
            return l1;
        }
        LinkedNode head1 = l1;    // l1的遍历指针
        LinkedNode head2 = l2;    // l2的遍历指针
        LinkedNode res = new LinkedNode();
        LinkedNode resHead = res;    // l2的遍历指针
        boolean flag = false;           // 初始状态不需要进1
        while (head1 != null && head2 != null) {
            if (flag == false) {    // 上次未进一
                resHead.next = new LinkedNode((head1.val + head2.val) % 10);
                if ((head1.val + head2.val) >= 10) {    // 判断这次不需要进一时
                    flag = true;
                }
            }
            else {
                if ((head1.val + head2.val + 1) >= 10) {    // 判断这次不需要进一时
                    flag = true;
                } else {
                    flag = false;
                }
                resHead.next = new LinkedNode((head1.val + head2.val + 1) % 10);
            }
            head1 = head1.next;
            head2 = head2.next;
            resHead = resHead.next;
        }

        while (head1 != null) {
            if (flag == false) {
                resHead.next = head1.next;
                break;
            } else {
                resHead.next = new LinkedNode((head1.val + 1) % 10);
                if (head1.val + 1 >= 10){
                    flag = true;
                } else {
                    flag = false;
                }
                head1 = head1.next;
                resHead = resHead.next;
            }
        }
        while (head2 != null) {
            if (flag == false) {
                resHead.next = head2.next;
                break;
            } else {
                resHead.next = new LinkedNode((head2.val + 1) % 10);
                if (head2.val + 1 >= 10){
                    flag = true;
                } else {
                    flag = false;
                }
                head2 = head2.next;
                resHead = resHead.next;
            }
        }
        if (flag == true) {
            resHead.next = new LinkedNode(1);
        }
        return res.next;
    }
}

class LinkedNode {
    public int val;
    public LinkedNode next;
    LinkedNode() {

    }
    LinkedNode(int val) {
        this.val = val;
    }
}

class LinkedList {
    // 初始化链表
    LinkedNode head = new LinkedNode();

    // 增 头插 尾插
    public void addNode(int val) {
        // 头插法
        LinkedNode linkedNode = new LinkedNode(val);
        /*linkedNode.next = head.next;
        head.next = linkedNode;*/
        // 尾插法
        LinkedNode tempNode = new LinkedNode();
        tempNode = head;
        while(tempNode.next != null) {
            tempNode = tempNode.next;
        }
        tempNode.next = linkedNode;
    }
    // 链表长度
    public int getLength() {
        LinkedNode tempNode = new LinkedNode();
        tempNode = head;
        int len = 0;
        while(tempNode.next!=null){
            tempNode = tempNode.next;
            len++;
        }
        return len;
    }
    // 增加节点到指定位置
    public void addByIndex(int index, int val){

        if (index < 1 || index > getLength()+1) {
            System.out.println("加不了！");
        }
        LinkedNode linkedNode = new LinkedNode(val);
        LinkedNode tempNode = new LinkedNode();
        tempNode = head;
        for (int i = 0; i < index - 1; i++) {
            tempNode = tempNode.next;
        }
        linkedNode.next = tempNode.next;
        tempNode.next = linkedNode;
    }
    // 删除指定位置节点
    public void delByIndex(int index){
        if (index < 1 || index > getLength()) {
            System.out.println("删不了！");
        }
        LinkedNode tempNode = new LinkedNode();
        tempNode = head;
        for (int i = 0; i < index - 1; i++) {
            tempNode = tempNode.next;
        }
        tempNode.next = tempNode.next.next;
    }
    // 从头到位打印链表
    public void printLinkedList() {
        LinkedNode tempNode = new LinkedNode();
        tempNode = head;
        while(tempNode.next != null) {
            System.out.println(tempNode.next.val);
            tempNode = tempNode.next;
        }
    }

    // 查找单链表的倒数第k个节点 思路：遍历知道总个数之后，倒数第k个就是正数第len-k+1个 || 双指针法，一起向后
    // 单链表反转 思路：头节点是第一个节点的情况下，自己构造一个头节点，从原头节点开始依次取出节点头插到新链表上
    // 合并两个有序单链表
    // 环形链表判断
    public boolean hasCycle(LinkedNode head) {
        LinkedNode temp = head;
        LinkedNode cycle = temp;
        while (temp != null) {
            while(cycle.next != null) {
                cycle = cycle.next;
                if (cycle.next == temp) {
                    return true;
                }
            }
            temp = temp.next;
        }
        return false;
    }
    // 逆序打印链表 递归
}
package person.zh.queue;


public class ArrayQueueDemo {
    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(10);
        arrayQueue.addQueue(10);
        arrayQueue.addQueue(20);
        arrayQueue.addQueue(30);
        arrayQueue.addQueue(40);
        arrayQueue.addQueue(50);
        int m = arrayQueue.popQueue();
        System.out.println("出队元素为:" + m);
        arrayQueue.showQueue();
    }
}

class ArrayQueue {
    private int maxSize; // 队列最大容量
    private int front;  // 队头
    private int rear;  // 队尾
    private int[] arr;  // 存放队中元素

    public ArrayQueue(int arrMaxSize) {
        maxSize = arrMaxSize;
        front = -1; // 指向队头的前一个位置
        rear = -1;  // 指向队尾
        arr = new int[maxSize];
    }

    // 判断队列是否满
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    // 判断队列是否为空
    public boolean isEmpty() {
        return rear == front;
    }

    // 入队
    public void addQueue(int data) {
        if (isFull()) {
            System.out.println("队列已满");
            return;
        }
        arr[++rear] = data;
    }

    // 出队
    public int popQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        return arr[++front];
    }

    // 获取队头元素
    public int getQueueHead() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        return arr[front + 1];
    }

    // 打印队列中所有元素
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列为空 无数据");
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]: %d\n", i, arr[i]);
        }
    }
}

package person.zh.stack;

public class ArrayStackDemo {
    public static void main(String[] args) {

    }
}

class ArrayStack {
    private int[] stack;
    private int top;
    private int maxSize;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        top = -1;
        stack = new int[maxSize];
    }

    // 栈满判断 栈满的判断条件为栈顶处索引为maxSize-1
    public boolean isFull() {
        if (top == maxSize-1) {
            return true;
        }
        return false;
    }

    // 栈空判断 条件为top为-1
    public boolean isEmpty() {
        if (top == -1) {
            return true;
        }
        return false;
    }

    // 入栈
    public void push(int val) {
        if (isFull()) {
            System.out.println("栈已满");
            return;
        }
        stack[++top] = val;
    }

    // 返回栈顶并出栈
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈空");
        }
        int temp = stack[top--];
        return temp;
    }

    // 获取栈顶元素
    public int getStackTop() {
        if (isEmpty()) {
            throw new RuntimeException("栈空");
        }
        return stack[top];
    }
}
package person.zh.queue;

import java.util.NoSuchElementException;

public class CircleQueueDemo {
    public static void main(String[] args) {
        CircleQueue circleQueue = new CircleQueue(10);
        circleQueue.offer(10);
        circleQueue.offer(20);
        circleQueue.offer(30);
        circleQueue.offer(40);
        circleQueue.offer(50);
        circleQueue.offer(60);
        circleQueue.offer(70);
        circleQueue.offer(80);
        circleQueue.offer(90);
        circleQueue.showQueue();
        int m = circleQueue.poll();
        circleQueue.offer(100);
        System.out.println(m);
        System.out.println(circleQueue.isFull());
        circleQueue.showQueue();
    }
}

class CircleQueue {
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    public CircleQueue(int arrMaxSize) {
        maxSize = arrMaxSize;
        front = 0;
        rear = 0;
        arr = new int[maxSize];
    }

    /*
    * 1.往队列中添加元素: add(), put(), offer()
      2.从队列中取出或者删除元素: remove() element()  peek()   poll()  take()
每个方法的说明如下：
       offer()方法往队列添加元素如果队列已满直接返回false,队列未满则直接插入并返回true;
       add()方法是对offer()方法的简单封装.如果队列已满,抛出异常new IllegalStateException("Queue full");
       put()方法往队列里插入元素,如果队列已经满,则会一直等待直到队列为空插入新元素,或者线程被中断抛出异常.
       remove()方法直接删除队头的元素:
       peek()方法直接取出队头的元素,并不删除.
       element()方法对peek方法进行简单封装,如果队头元素存在则取出并不删除,如果不存在抛出异常NoSuchElementException()
       poll()方法取出并删除队头的元素,当队列为空,返回null;
       take()方法取出并删除队头的元素,当队列为空,则会一直等待直到队列有新元素可以取出,或者线程被中断抛出异常
　　    offer()方法一般跟pool()方法相对应, put()方法一般跟take()方法相对应.日常开发过程中offer()与pool()方法用的相对比较频繁.
    * */

    // 判断队列是否为空
    public boolean isEmpty() {
        return rear == front;
    }

    // 判断队列是否满
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    // offer()方法往队列添加元素如果队列已满直接返回false,队列未满则直接插入并返回true;
    public boolean offer(int data) {
        if (isFull()) {
            System.out.println("队列已满");
            return false;
        }
        arr[rear] = data;
        rear = (rear + 1) % maxSize;
        return true;
    }

    // add()方法是对offer()方法的简单封装.如果队列已满,抛出异常new IllegalStateException("Queue full");
    public boolean add(int data) {
        if (isFull()) {
            throw new IllegalStateException("Queue full");
        }
        arr[rear] = data;
        rear = (rear + 1) % maxSize;
        return true;
    }

    // put()方法往队列里插入元素,如果队列已经满,则会一直等待直到队列为空插入新元素,或者线程被中断抛出异常.
    // remove()方法直接删除队头的元素:
    public void remove() {
        if (isFull()) {
            System.out.println("队列为空 无法删除");
        }
        front = (front + 1) % maxSize;
    }

    // peek()方法直接取出队头的元素,并不删除.
    public int peek() {
        if (isEmpty()) {
            System.out.println("队列为空，无法取出队头元素");
            return -9999;
        }
        return arr[front];
    }

    // element()方法对peek方法进行简单封装,如果队头元素存在则取出并不删除,如果不存在抛出异常NoSuchElementException()
    public int element() {
        if (isEmpty()) {
            System.out.println("队列为空，无法取出队头元素");
            throw new NoSuchElementException();
        }
        return arr[front];
    }

    // poll()方法取出并删除队头的元素,当队列为空,返回null;
    public int poll() {
        if (isEmpty()) {
            System.out.println("队列为空，无法取出队头元素");
            return -9999;
        }
        int res = arr[front];
        front = (front + 1) % maxSize;
        return res;
    }
    // take()方法取出并删除队头的元素,当队列为空,则会一直等待直到队列有新元素可以取出,或者线程被中断抛出异常
    // offer()方法一般跟pool()方法相对应, put()方法一般跟take()方法相对应.日常开发过程中offer()与pool()方法用的相对比较频繁.
    // 遍历打印队列中所有元素
    public void showQueue() {
        for (int data : arr) {
            System.out.println(data);
        }
    }
}

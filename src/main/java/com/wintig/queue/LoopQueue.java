package com.wintig.queue;

/**
 * @author shitian
 * @Dscpriction 利用数组实现的循环队列
 * @create 2018-08-06 下午11:20
 */
public class LoopQueue<E> implements Queue<E> {

    private E[] data;

    /**
     * 队头所在位置
     */
    private int front;

    /**
     * 最后一个元素，下一个位置
     */
    private int tail;

    private int size;

    public LoopQueue(int capacity) {
        this.data = (E[])new Object[capacity + 1];
        this.front = 0;
        this.tail = 0;
        this.size = 0;
    }

    public LoopQueue() {
        this(10);
    }

    /**
     * 数组中有一个元素会被我们浪费，所以容积是数组的长度减一
     * @return
     */
    public int getCapacity() {
        return data.length - 1;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public void enqueue(E e) {

        //队列满了
        if ((tail + 1) % data.length == front) {
            resize(getCapacity() * 2);
        }

        data[tail] = e;
        tail = (tail + 1) % data.length;
        size ++;
    }

    /**
     * 扩容的时候一定要注意偏移量
     * @param newCapacity
     */
    private void resize(int newCapacity) {

        E[] newData = (E[]) new Object[newCapacity + 1];

        for (int i = 0; i < size; i++) {
            newData[i] = data[ (i + front) % data.length ];
        }

        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public E dequeue() {

        if (isEmpty()) {
            throw new IllegalArgumentException("cannot dequeue from an empty queue!");
        }

        E ret = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size --;

        if (size == getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }

        return ret;
    }

    @Override
    public E getFront() {

        if (isEmpty()) {
            throw new IllegalArgumentException("Queue is empty!");
        }

        return data[front];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("queue : size = %d, capacity = %d\n", size, getCapacity()));
        sb.append("front [");
        for (int i = front; i != tail; i = (i + 1) % data.length) {
            sb.append(data[i]);
            if ((i + 1) % data.length != tail) {
                sb.append(", ");
            }
        }
        sb.append("] tail");
        return sb.toString();
    }

    public static void main(String[] args) {

        LoopQueue<Integer> queue = new LoopQueue<>();
        for(int i = 0 ; i < 10 ; i ++){
            queue.enqueue(i);
            System.out.println(queue);
            if(i % 3 == 2){
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}

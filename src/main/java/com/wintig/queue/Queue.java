package com.wintig.queue;

/**
 * @author shitian
 * @create 2018-08-06 上午2:24
 */
public interface Queue<E> {

    int getSize();

    boolean isEmpty();

    void enqueue(E e);

    E dequeue();

    E getFront();
}
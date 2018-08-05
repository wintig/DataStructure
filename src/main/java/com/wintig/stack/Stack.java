package com.wintig.stack;

/**
 * @author shitian
 * @create 2018-08-06 上午1:32
 */
public interface Stack<E> {

    int size();

    boolean isEmpty();

    void push(E e);

    E pop();

    E peek();


}

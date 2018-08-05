package com.wintig.stack;

import com.wintig.list.ArrayList;

/**
 * @author shitian
 * @create 2018-08-06 上午1:34
 */
public class ArrayStack<E> implements Stack<E> {

    ArrayList<E> array;

    public ArrayStack(int capacity) {
        this.array =  new ArrayList<E>(capacity);
    }

    public ArrayStack() {
        array = new ArrayList<E>();
    }

    public int size() {
        return array.getSize();
    }

    public boolean isEmpty() {
        return array.isEmpty();
    }

    public void push(E e) {
        array.addLast(e);
    }

    public E pop() {
        return array.removeLast();
    }

    public E peek() {
        return array.getLast();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("stack：");
        sb.append("[");
        for (int i = 0; i < array.getSize(); i++) {
            sb.append(array.get(i));
            if (i != array.getSize() - 1) {
                sb.append(", ");
            }
        }
        sb.append("] top");
        return sb.toString();
    }
}

package com.wintig.queue;

import com.wintig.list.ArrayList;

/**
 * @author shitian
 * @create 2018-08-06 上午2:25
 */
public class ArrayQueue<E> implements Queue<E> {

    private ArrayList<E> array;

    public ArrayQueue(int capacity){
        array = new ArrayList<E>(capacity);
    }

    public ArrayQueue(){
        array = new ArrayList<E>();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }

    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    @Override
    public E getFront() {
        return array.getFirst();
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("Queue: ");
        res.append("front [");
        for(int i = 0 ; i < array.getSize() ; i ++){
            res.append(array.get(i));
            if(i != array.getSize() - 1)
                res.append(", ");
        }
        res.append("] tail");
        return res.toString();
    }


}

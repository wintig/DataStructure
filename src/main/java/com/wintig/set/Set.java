package com.wintig.set;

/**
 * @ClassName Set
 * @Despriction set集合接口
 * @Author shitian
 * @Create 2018-08-20 下午9:24
 */
public interface Set<E> {

    void add(E e);

    void remove(E e);

    boolean contains(E e);

    int getSize();

    boolean isEmpty();

}

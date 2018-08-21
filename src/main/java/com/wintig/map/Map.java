package com.wintig.map;

/**
 * @ClassName Map
 * @Despriction TODO
 * @Author shitian
 * @Create 2018-08-21 下午8:57
 */
public interface Map<K, V> {

    void add(K key, V value);

    V remove(K key);

    boolean contains(K key);

    V get(K key);

    void set(K key, V newValue);

    int getSize();

    boolean isEmpty();

}

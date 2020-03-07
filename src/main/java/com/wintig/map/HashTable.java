package com.wintig.map;



import java.util.TreeMap;

public class HashTable<K, V> {

    // 平均每个槽位，元素数量大于等于10就会扩容
    private static final int upperTol = 10;
    private static final int lowerTol = 2;
    private static final int initCapacity = 7;

    private TreeMap<K, V>[] hashtable;
    private int M;
    private int size;

    public HashTable(int M) {
        this.M = M;
        size = 0;
        hashtable = new TreeMap[M];
        for (int i = 0; i < M; i++) {
            hashtable[i] = new TreeMap<>();
        }
    }

    public HashTable() {
        this(initCapacity);
    }

    // 获得索引
    private int hash(K key) {
        // 消除Key对应hashCode的符号
        return key.hashCode() & 0x7fffffff % M;
    }

    public int getSize() {
        return size;
    }

    public void add(K key, V value) {
        TreeMap<K, V> kvTreeMap = hashtable[hash(key)];
        if (kvTreeMap.containsKey(key)) {
            hashtable[hash(key)].put(key, value);
        } else {
            kvTreeMap.put(key, value);
            size++;

            if (size >= upperTol * M) {
                resize(2 * M);
            }

        }
    }

    public V remove(K key) {
        TreeMap<K, V> map = hashtable[hash(key)];
        V ret = null;
        if (map.containsKey(key)) {
            ret = map.remove(key);
            size--;
            if (size < lowerTol * M && M / 2 >= initCapacity) {
                resize(M / 2);
            }
        }
        return ret;
    }

    public void set(K key, V value) {
        TreeMap<K, V> kvTreeMap = hashtable[hash(key)];
        if (!kvTreeMap.containsKey(key)) {
            throw new IllegalArgumentException(key + " key 不存在");
        }
        kvTreeMap.put(key, value);
    }

    public boolean contains(K key) {
        return hashtable[hash(key)].containsKey(key);
    }

    public V get(K key) {
        return hashtable[hash(key)].get(key);
    }

    private void resize(int newM) {
        TreeMap<K, V>[] newHashTable = new TreeMap[newM];
        for (int i = 0; i < newM; i++) {
            newHashTable[i] = new TreeMap<>();
        }

        // 注意这一点
        int oldM = M;
        this.M = newM;

        // 以前的元素放入新的hashTable
        for (int i = 0; i < oldM; i++) {
            TreeMap<K, V> map = hashtable[i];
            for (K key : map.keySet()) {
                newHashTable[hash(key)].put(key, map.get(key));
            }
        }

        this.hashtable = newHashTable;
    }

}

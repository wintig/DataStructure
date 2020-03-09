package com.wintig.map;


import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

public class ConcurrentHashMap1丶7<K, V> {

    /**
     *
     * HashMap是线程不安全的，要想线程安全的话很容易想到的就是加锁让任何时间只有一个线程能够进行读写
     * HashTable就是这样做的，但是现在已经没人用了，因为并发下太差。这种锁的力度过于大，要想提升效率很自然就会想到减小锁的力度。
     *
     *
     * JDK 1.7的ConcurrentHashMap就是这样的，他采用的是分段锁，将table表拆分成多个Segment组。
     * 其中Segment继承了ReentrantLock，读写数据的时候首先对于每个key取模，确定位于哪个Segment段，然后对当前段进行加锁，通过减少锁的力度
     * 从而达到了提升并发的特性。
     * 理论上ConcurrentHashMap支持当先线程数量的并发，每当一个线程占用锁访问一个Segment时，不会影响到其他的Segment
     *
     *
     * JDK 1.7的ConcurrentHashMap解决了并发问题，并且理论支持N个Segment多次数的并发，但依然存在HashMap再1.7版本中的问题就是遍历链表效率太低
     * 结构上JDK1.8中抛弃了原有的segment分段锁，采用的CAS + synchronized来保证并发安全
     *
     *
     */

    public static void main(String[] args) {

        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();

    }

    static final int DEFAULT_INITAL_CAPACITY = 4;
    static final float DEFAULT_LOAD_FACTOR = 0.75f;
    static final int DEFAULT_CONCURRENCY_LEVEL = 16;
    private Segment<K, V>[] segments;

    private static class Segment<K, V> extends ReentrantLock {
        // 存放真正的数据
        private HashEntry<K, V>[] table;
        transient volatile int count;
    }

    private static final class HashEntry<K, V> {


        final K key;
        final int hash;

        /**
         * 这里为什么要是volatile关键字修饰呢？
         * 就是为了读的时候，其他线程修改了值，也可以立马获取
         */
        volatile V value;


        final HashEntry<K, V> next;

        public HashEntry(K key, int hash, V value, HashEntry<K, V> next) {
            this.key = key;
            this.hash = hash;
            this.value = value;
            this.next = next;
        }
    }

    public V put(K key, V value) {
        int hash = hash(key.hashCode());
        // 计算出对应的槽位
        int segmentIndex = indexFor(hash, segments.length);

        // 锁定hash表
        segments[segmentIndex].lock();

        // other code

        // 解锁
        segments[segmentIndex].unlock();
        return null;
    }

    V get(Object key, int hash) {

        // 取得链表的头部，就是第2次hash过程

        // 链表搜索，直到hash与key均相等时，返回节点的value


        return null;
    }

    /**
     * ConcurrentHash是写锁而不是读锁，所以写的时候是可以读的
     * 当我们删除元素的时候，当读取到第二个红色节点，然后第三个节点被删除了，并没有同步到读线程
     *
     * 那么我们拿到的 2.next就是被删除的。所以我们需要保证读取到的元素，他的下一个节点一定不能为null
     * 所以我们也能看到HashEntry的next是final类型的，所以我们就不能用我们之前的删除方式。
     *
     * 而是位到待删除元素以后，将待删除元素前面的那一些元素全部复制一遍，然后重新连接到新的链表上
     *
     * // 原有链表
     * // 1 --> 2 --> 3 --> 4 --> 5
     * // 删除节点3以后的新链表
     * // 2 --> 1 --> 4 --> 5
     *
     */
    public V remove(Object key) {

        V oldValue = null;
        return oldValue;
    }

    private int indexFor(int hash, int length) {
        return hash & (length - 1);
    }

    private static int hash(int h) {
        h += (h << 15) ^ 0xffffcd7d;
        h ^= (h >>> 10);
        h += (h << 3);
        h ^= (h >>> 6);
        h += (h << 2) + (h << 14);
        return h ^ (h >>> 16);
    }

}
